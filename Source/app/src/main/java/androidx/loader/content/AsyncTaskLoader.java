package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    @Nullable
    public abstract D loadInBackground();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch mDone = new CountDownLatch(1);
        boolean waiting;

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        public D doInBackground(Void... params) {
            try {
                return (D) AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException ex) {
                if (!isCancelled()) {
                    throw ex;
                }
                return null;
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void onPostExecute(D data) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, data);
            } finally {
                this.mDone.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void onCancelled(D data) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, data);
            } finally {
                this.mDone.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.waiting = AsyncTaskLoader.DEBUG;
            AsyncTaskLoader.this.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long delayMS) {
        this.mUpdateThrottle = delayMS;
        if (delayMS != 0) {
            this.mHandler = new Handler();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    @Override // androidx.loader.content.Loader
    protected boolean onCancelLoad() {
        boolean cancelled = DEBUG;
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.waiting) {
                    this.mTask.waiting = DEBUG;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                cancelled = this.mTask.cancel(DEBUG);
                if (cancelled) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
            }
        }
        return cancelled;
    }

    public void onCanceled(@Nullable D data) {
    }

    void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle > 0) {
                long now = SystemClock.uptimeMillis();
                if (now < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                    this.mTask.waiting = true;
                    this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                    return;
                }
            }
            this.mTask.executeOnExecutor(this.mExecutor, null);
        }
    }

    void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask task, D data) {
        onCanceled(data);
        if (this.mCancellingTask == task) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask task, D data) {
        if (this.mTask != task) {
            dispatchOnCancelled(task, data);
        } else if (isAbandoned()) {
            onCanceled(data);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(data);
        }
    }

    @Nullable
    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void cancelLoadInBackground() {
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask != null) {
            return true;
        }
        return DEBUG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask task = this.mTask;
        if (task != null) {
            task.waitForLoader();
        }
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        if (this.mTask != null) {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(this.mTask);
            writer.print(" waiting=");
            writer.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(this.mCancellingTask);
            writer.print(" waiting=");
            writer.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, writer);
            writer.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), writer);
            writer.println();
        }
    }
}
