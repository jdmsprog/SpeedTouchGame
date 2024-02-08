package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.appinventor.components.common.ComponentConstants;

/* JADX INFO: Access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class DrawableContainer extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;
    private int mAlpha = 255;
    private int mCurIndex = -1;
    private int mLastIndex = -1;

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.draw(canvas);
        }
        if (this.mLastDrawable != null) {
            this.mLastDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    private boolean needsMirroring() {
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            return true;
        }
        return DEBUG;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect padding) {
        boolean result;
        Rect r = this.mDrawableContainerState.getConstantPadding();
        if (r != null) {
            padding.set(r);
            result = (((r.left | r.top) | r.bottom) | r.right) != 0 ? true : DEBUG;
        } else if (this.mCurrDrawable != null) {
            result = this.mCurrDrawable.getPadding(padding);
        } else {
            result = super.getPadding(padding);
        }
        if (needsMirroring()) {
            int left = padding.left;
            int right = padding.right;
            padding.left = right;
            padding.right = left;
        }
        return result;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (!this.mHasAlpha || this.mAlpha != alpha) {
            this.mHasAlpha = true;
            this.mAlpha = alpha;
            if (this.mCurrDrawable != null) {
                if (this.mEnterAnimationEnd == 0) {
                    this.mCurrDrawable.setAlpha(alpha);
                } else {
                    animate(DEBUG);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        if (this.mDrawableContainerState.mDither != dither) {
            this.mDrawableContainerState.mDither = dither;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableContainerState.mHasColorFilter = true;
        if (this.mDrawableContainerState.mColorFilter != colorFilter) {
            this.mDrawableContainerState.mColorFilter = colorFilter;
            if (this.mCurrDrawable != null) {
                this.mCurrDrawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        this.mDrawableContainerState.mHasTintList = true;
        if (this.mDrawableContainerState.mTintList != tint) {
            this.mDrawableContainerState.mTintList = tint;
            DrawableCompat.setTintList(this.mCurrDrawable, tint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode tintMode) {
        this.mDrawableContainerState.mHasTintMode = true;
        if (this.mDrawableContainerState.mTintMode != tintMode) {
            this.mDrawableContainerState.mTintMode = tintMode;
            DrawableCompat.setTintMode(this.mCurrDrawable, tintMode);
        }
    }

    public void setEnterFadeDuration(int ms) {
        this.mDrawableContainerState.mEnterFadeDuration = ms;
    }

    public void setExitFadeDuration(int ms) {
        this.mDrawableContainerState.mExitFadeDuration = ms;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setBounds(bounds);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        if (this.mDrawableContainerState.mAutoMirrored != mirrored) {
            this.mDrawableContainerState.mAutoMirrored = mirrored;
            if (this.mCurrDrawable != null) {
                DrawableCompat.setAutoMirrored(this.mCurrDrawable, this.mDrawableContainerState.mAutoMirrored);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean changed = DEBUG;
        if (this.mLastDrawable != null) {
            this.mLastDrawable.jumpToCurrentState();
            this.mLastDrawable = null;
            this.mLastIndex = -1;
            changed = true;
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            changed = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
            changed = true;
        }
        if (changed) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        if (this.mCurrDrawable != null) {
            DrawableCompat.setHotspot(this.mCurrDrawable, x, y);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        if (this.mHotspotBounds == null) {
            this.mHotspotBounds = new Rect(left, top, right, bottom);
        } else {
            this.mHotspotBounds.set(left, top, right, bottom);
        }
        if (this.mCurrDrawable != null) {
            DrawableCompat.setHotspotBounds(this.mCurrDrawable, left, top, right, bottom);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect outRect) {
        if (this.mHotspotBounds != null) {
            outRect.set(this.mHotspotBounds);
        } else {
            super.getHotspotBounds(outRect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setState(state);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setState(state);
        }
        return DEBUG;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        if (this.mLastDrawable != null) {
            return this.mLastDrawable.setLevel(level);
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.setLevel(level);
        }
        return DEBUG;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return this.mDrawableContainerState.setLayoutDirection(layoutDirection, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        if (this.mCurrDrawable != null) {
            return this.mCurrDrawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(@NonNull Drawable who) {
        if (this.mDrawableContainerState != null) {
            this.mDrawableContainerState.invalidateCache();
        }
        if (who == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {
        if (who == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {
        if (who == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, what);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        if (this.mLastDrawable != null) {
            this.mLastDrawable.setVisible(visible, restart);
        }
        if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(visible, restart);
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mCurrDrawable == null || !this.mCurrDrawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.getOpacity();
    }

    void setCurrentIndex(int index) {
        selectDrawable(index);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean selectDrawable(int index) {
        if (index == this.mCurIndex) {
            return DEBUG;
        }
        long now = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            if (this.mLastDrawable != null) {
                this.mLastDrawable.setVisible(DEBUG, DEBUG);
            }
            if (this.mCurrDrawable != null) {
                this.mLastDrawable = this.mCurrDrawable;
                this.mLastIndex = this.mCurIndex;
                this.mExitAnimationEnd = this.mDrawableContainerState.mExitFadeDuration + now;
            } else {
                this.mLastDrawable = null;
                this.mLastIndex = -1;
                this.mExitAnimationEnd = 0L;
            }
        } else if (this.mCurrDrawable != null) {
            this.mCurrDrawable.setVisible(DEBUG, DEBUG);
        }
        if (index >= 0 && index < this.mDrawableContainerState.mNumChildren) {
            Drawable d = this.mDrawableContainerState.getChild(index);
            this.mCurrDrawable = d;
            this.mCurIndex = index;
            if (d != null) {
                if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
                    this.mEnterAnimationEnd = this.mDrawableContainerState.mEnterFadeDuration + now;
                }
                initializeDrawableForDisplay(d);
            }
        } else {
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
        }
        if (this.mEnterAnimationEnd != 0 || this.mExitAnimationEnd != 0) {
            if (this.mAnimationRunnable == null) {
                this.mAnimationRunnable = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainer.this.animate(true);
                        DrawableContainer.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.mAnimationRunnable);
            }
            animate(true);
        }
        invalidateSelf();
        return true;
    }

    private void initializeDrawableForDisplay(Drawable d) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new BlockInvalidateCallback();
        }
        d.setCallback(this.mBlockInvalidateCallback.wrap(d.getCallback()));
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                d.setAlpha(this.mAlpha);
            }
            if (this.mDrawableContainerState.mHasColorFilter) {
                d.setColorFilter(this.mDrawableContainerState.mColorFilter);
            } else {
                if (this.mDrawableContainerState.mHasTintList) {
                    DrawableCompat.setTintList(d, this.mDrawableContainerState.mTintList);
                }
                if (this.mDrawableContainerState.mHasTintMode) {
                    DrawableCompat.setTintMode(d, this.mDrawableContainerState.mTintMode);
                }
            }
            d.setVisible(isVisible(), true);
            d.setDither(this.mDrawableContainerState.mDither);
            d.setState(getState());
            d.setLevel(getLevel());
            d.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                d.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                d.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
            }
            Rect hotspotBounds = this.mHotspotBounds;
            if (Build.VERSION.SDK_INT >= 21 && hotspotBounds != null) {
                d.setHotspotBounds(hotspotBounds.left, hotspotBounds.top, hotspotBounds.right, hotspotBounds.bottom);
            }
        } finally {
            d.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    void animate(boolean schedule) {
        this.mHasAlpha = true;
        long now = SystemClock.uptimeMillis();
        boolean animating = DEBUG;
        if (this.mCurrDrawable != null) {
            if (this.mEnterAnimationEnd != 0) {
                if (this.mEnterAnimationEnd <= now) {
                    this.mCurrDrawable.setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                } else {
                    int animAlpha = ((int) ((this.mEnterAnimationEnd - now) * 255)) / this.mDrawableContainerState.mEnterFadeDuration;
                    this.mCurrDrawable.setAlpha(((255 - animAlpha) * this.mAlpha) / 255);
                    animating = true;
                }
            }
        } else {
            this.mEnterAnimationEnd = 0L;
        }
        if (this.mLastDrawable != null) {
            if (this.mExitAnimationEnd != 0) {
                if (this.mExitAnimationEnd <= now) {
                    this.mLastDrawable.setVisible(DEBUG, DEBUG);
                    this.mLastDrawable = null;
                    this.mLastIndex = -1;
                    this.mExitAnimationEnd = 0L;
                } else {
                    int animAlpha2 = ((int) ((this.mExitAnimationEnd - now) * 255)) / this.mDrawableContainerState.mExitFadeDuration;
                    this.mLastDrawable.setAlpha((this.mAlpha * animAlpha2) / 255);
                    animating = true;
                }
            }
        } else {
            this.mExitAnimationEnd = 0L;
        }
        if (schedule && animating) {
            scheduleSelf(this.mAnimationRunnable, 16 + now);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateDensity(Resources res) {
        this.mDrawableContainerState.updateDensity(res);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState()) {
            this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            return this.mDrawableContainerState;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState clone = cloneConstantState();
            clone.mutate();
            setConstantState(clone);
            this.mMutated = true;
        }
        return this;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = DEBUG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainer mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState orig, DrawableContainer owner, Resources res) {
            Resources resources;
            this.mDensity = ComponentConstants.TEXTBOX_PREFERRED_WIDTH;
            this.mVariablePadding = DrawableContainer.DEBUG;
            this.mConstantSize = DrawableContainer.DEBUG;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = owner;
            if (res != null) {
                resources = res;
            } else {
                resources = orig != null ? orig.mSourceRes : null;
            }
            this.mSourceRes = resources;
            this.mDensity = DrawableContainer.resolveDensity(res, orig != null ? orig.mDensity : 0);
            if (orig != null) {
                this.mChangingConfigurations = orig.mChangingConfigurations;
                this.mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = orig.mVariablePadding;
                this.mConstantSize = orig.mConstantSize;
                this.mDither = orig.mDither;
                this.mMutated = orig.mMutated;
                this.mLayoutDirection = orig.mLayoutDirection;
                this.mEnterFadeDuration = orig.mEnterFadeDuration;
                this.mExitFadeDuration = orig.mExitFadeDuration;
                this.mAutoMirrored = orig.mAutoMirrored;
                this.mColorFilter = orig.mColorFilter;
                this.mHasColorFilter = orig.mHasColorFilter;
                this.mTintList = orig.mTintList;
                this.mTintMode = orig.mTintMode;
                this.mHasTintList = orig.mHasTintList;
                this.mHasTintMode = orig.mHasTintMode;
                if (orig.mDensity == this.mDensity) {
                    if (orig.mCheckedPadding) {
                        this.mConstantPadding = new Rect(orig.mConstantPadding);
                        this.mCheckedPadding = true;
                    }
                    if (orig.mCheckedConstantSize) {
                        this.mConstantWidth = orig.mConstantWidth;
                        this.mConstantHeight = orig.mConstantHeight;
                        this.mConstantMinimumWidth = orig.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = orig.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (orig.mCheckedOpacity) {
                    this.mOpacity = orig.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (orig.mCheckedStateful) {
                    this.mStateful = orig.mStateful;
                    this.mCheckedStateful = true;
                }
                Drawable[] origDr = orig.mDrawables;
                this.mDrawables = new Drawable[origDr.length];
                this.mNumChildren = orig.mNumChildren;
                SparseArray<Drawable.ConstantState> origDf = orig.mDrawableFutures;
                if (origDf != null) {
                    this.mDrawableFutures = origDf.clone();
                } else {
                    this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
                }
                int count = this.mNumChildren;
                for (int i = 0; i < count; i++) {
                    if (origDr[i] != null) {
                        Drawable.ConstantState cs = origDr[i].getConstantState();
                        if (cs != null) {
                            this.mDrawableFutures.put(i, cs);
                        } else {
                            this.mDrawables[i] = origDr[i];
                        }
                    }
                }
                return;
            }
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final int addChild(Drawable dr) {
            int pos = this.mNumChildren;
            if (pos >= this.mDrawables.length) {
                growArray(pos, pos + 10);
            }
            dr.mutate();
            dr.setVisible(DrawableContainer.DEBUG, true);
            dr.setCallback(this.mOwner);
            this.mDrawables[pos] = dr;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations |= dr.getChangingConfigurations();
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = DrawableContainer.DEBUG;
            this.mCheckedConstantSize = DrawableContainer.DEBUG;
            this.mCheckedConstantState = DrawableContainer.DEBUG;
            return pos;
        }

        void invalidateCache() {
            this.mCheckedOpacity = DrawableContainer.DEBUG;
            this.mCheckedStateful = DrawableContainer.DEBUG;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int getCapacity() {
            return this.mDrawables.length;
        }

        private void createAllFutures() {
            if (this.mDrawableFutures != null) {
                int futureCount = this.mDrawableFutures.size();
                for (int keyIndex = 0; keyIndex < futureCount; keyIndex++) {
                    int index = this.mDrawableFutures.keyAt(keyIndex);
                    Drawable.ConstantState cs = this.mDrawableFutures.valueAt(keyIndex);
                    this.mDrawables[index] = prepareDrawable(cs.newDrawable(this.mSourceRes));
                }
                this.mDrawableFutures = null;
            }
        }

        private Drawable prepareDrawable(Drawable child) {
            if (Build.VERSION.SDK_INT >= 23) {
                child.setLayoutDirection(this.mLayoutDirection);
            }
            Drawable child2 = child.mutate();
            child2.setCallback(this.mOwner);
            return child2;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final Drawable getChild(int index) {
            int keyIndex;
            Drawable result = this.mDrawables[index];
            if (result == null) {
                if (this.mDrawableFutures == null || (keyIndex = this.mDrawableFutures.indexOfKey(index)) < 0) {
                    return null;
                }
                Drawable.ConstantState cs = this.mDrawableFutures.valueAt(keyIndex);
                Drawable prepared = prepareDrawable(cs.newDrawable(this.mSourceRes));
                this.mDrawables[index] = prepared;
                this.mDrawableFutures.removeAt(keyIndex);
                if (this.mDrawableFutures.size() == 0) {
                    this.mDrawableFutures = null;
                }
                return prepared;
            }
            return result;
        }

        final boolean setLayoutDirection(int layoutDirection, int currentIndex) {
            boolean changed = DrawableContainer.DEBUG;
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            for (int i = 0; i < count; i++) {
                if (drawables[i] != null) {
                    boolean childChanged = DrawableContainer.DEBUG;
                    if (Build.VERSION.SDK_INT >= 23) {
                        childChanged = drawables[i].setLayoutDirection(layoutDirection);
                    }
                    if (i == currentIndex) {
                        changed = childChanged;
                    }
                }
            }
            this.mLayoutDirection = layoutDirection;
            return changed;
        }

        final void updateDensity(Resources res) {
            if (res != null) {
                this.mSourceRes = res;
                int targetDensity = DrawableContainer.resolveDensity(res, this.mDensity);
                int sourceDensity = this.mDensity;
                this.mDensity = targetDensity;
                if (sourceDensity != targetDensity) {
                    this.mCheckedConstantSize = DrawableContainer.DEBUG;
                    this.mCheckedPadding = DrawableContainer.DEBUG;
                }
            }
        }

        @RequiresApi(21)
        final void applyTheme(Resources.Theme theme) {
            if (theme != null) {
                createAllFutures();
                int count = this.mNumChildren;
                Drawable[] drawables = this.mDrawables;
                for (int i = 0; i < count; i++) {
                    if (drawables[i] != null && drawables[i].canApplyTheme()) {
                        drawables[i].applyTheme(theme);
                        this.mChildrenChangingConfigurations |= drawables[i].getChangingConfigurations();
                    }
                }
                updateDensity(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            for (int i = 0; i < count; i++) {
                Drawable d = drawables[i];
                if (d != null) {
                    if (d.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState future = this.mDrawableFutures.get(i);
                    if (future != null && future.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return DrawableContainer.DEBUG;
        }

        void mutate() {
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            for (int i = 0; i < count; i++) {
                if (drawables[i] != null) {
                    drawables[i].mutate();
                }
            }
            this.mMutated = true;
        }

        final void clearMutated() {
            this.mMutated = DrawableContainer.DEBUG;
        }

        public final void setVariablePadding(boolean variable) {
            this.mVariablePadding = variable;
        }

        public final Rect getConstantPadding() {
            if (this.mVariablePadding) {
                return null;
            }
            if (this.mConstantPadding != null || this.mCheckedPadding) {
                return this.mConstantPadding;
            }
            createAllFutures();
            Rect r = null;
            Rect t = new Rect();
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            for (int i = 0; i < count; i++) {
                if (drawables[i].getPadding(t)) {
                    if (r == null) {
                        r = new Rect(0, 0, 0, 0);
                    }
                    if (t.left > r.left) {
                        r.left = t.left;
                    }
                    if (t.top > r.top) {
                        r.top = t.top;
                    }
                    if (t.right > r.right) {
                        r.right = t.right;
                    }
                    if (t.bottom > r.bottom) {
                        r.bottom = t.bottom;
                    }
                }
            }
            this.mCheckedPadding = true;
            this.mConstantPadding = r;
            return r;
        }

        public final void setConstantSize(boolean constant) {
            this.mConstantSize = constant;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final int getConstantWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getConstantHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i = 0; i < count; i++) {
                Drawable dr = drawables[i];
                int s = dr.getIntrinsicWidth();
                if (s > this.mConstantWidth) {
                    this.mConstantWidth = s;
                }
                int s2 = dr.getIntrinsicHeight();
                if (s2 > this.mConstantHeight) {
                    this.mConstantHeight = s2;
                }
                int s3 = dr.getMinimumWidth();
                if (s3 > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = s3;
                }
                int s4 = dr.getMinimumHeight();
                if (s4 > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = s4;
                }
            }
        }

        public final void setEnterFadeDuration(int duration) {
            this.mEnterFadeDuration = duration;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final void setExitFadeDuration(int duration) {
            this.mExitFadeDuration = duration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            createAllFutures();
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            int op = count > 0 ? drawables[0].getOpacity() : -2;
            for (int i = 1; i < count; i++) {
                op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            }
            this.mOpacity = op;
            this.mCheckedOpacity = true;
            return op;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            createAllFutures();
            int count = this.mNumChildren;
            Drawable[] drawables = this.mDrawables;
            boolean isStateful = DrawableContainer.DEBUG;
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                } else if (!drawables[i].isStateful()) {
                    i++;
                } else {
                    isStateful = true;
                    break;
                }
            }
            this.mStateful = isStateful;
            this.mCheckedStateful = true;
            return isStateful;
        }

        public void growArray(int oldSize, int newSize) {
            Drawable[] newDrawables = new Drawable[newSize];
            System.arraycopy(this.mDrawables, 0, newDrawables, 0, oldSize);
            this.mDrawables = newDrawables;
        }

        public synchronized boolean canConstantState() {
            boolean z = DrawableContainer.DEBUG;
            synchronized (this) {
                if (this.mCheckedConstantState) {
                    z = this.mCanConstantState;
                } else {
                    createAllFutures();
                    this.mCheckedConstantState = true;
                    int count = this.mNumChildren;
                    Drawable[] drawables = this.mDrawables;
                    int i = 0;
                    while (true) {
                        if (i < count) {
                            if (drawables[i].getConstantState() != null) {
                                i++;
                            } else {
                                this.mCanConstantState = DrawableContainer.DEBUG;
                                break;
                            }
                        } else {
                            this.mCanConstantState = true;
                            z = true;
                            break;
                        }
                    }
                }
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setConstantState(DrawableContainerState state) {
        this.mDrawableContainerState = state;
        if (this.mCurIndex >= 0) {
            this.mCurrDrawable = state.getChild(this.mCurIndex);
            if (this.mCurrDrawable != null) {
                initializeDrawableForDisplay(this.mCurrDrawable);
            }
        }
        this.mLastIndex = -1;
        this.mLastDrawable = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        BlockInvalidateCallback() {
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.mCallback = callback;
            return this;
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable who) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {
            if (this.mCallback != null) {
                this.mCallback.scheduleDrawable(who, what, when);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {
            if (this.mCallback != null) {
                this.mCallback.unscheduleDrawable(who, what);
            }
        }
    }

    static int resolveDensity(@Nullable Resources r, int parentDensity) {
        int densityDpi = r == null ? parentDensity : r.getDisplayMetrics().densityDpi;
        return densityDpi == 0 ? ComponentConstants.TEXTBOX_PREFERRED_WIDTH : densityDpi;
    }
}
