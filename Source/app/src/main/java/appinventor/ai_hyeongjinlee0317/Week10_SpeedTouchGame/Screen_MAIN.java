package appinventor.ai_hyeongjinlee0317.Week10_SpeedTouchGame;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.StopBlocksExecution;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

/* compiled from: Screen_MAIN.yail */
/* loaded from: classes.dex */
public class Screen_MAIN extends Form implements Runnable {
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit10;
    static final IntNum Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final FString Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final IntNum Lit20;
    static final SimpleSymbol Lit21;
    static final IntNum Lit22;
    static final FString Lit23;
    static final FString Lit24;
    static final SimpleSymbol Lit25;
    static final IntNum Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final IntNum Lit29;
    static final SimpleSymbol Lit3;
    static final FString Lit30;
    static final FString Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final IntNum Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final IntNum Lit38;
    static final FString Lit39;
    static final IntNum Lit4;
    static final FString Lit40;
    static final SimpleSymbol Lit41;
    static final IntNum Lit42;
    static final IntNum Lit43;
    static final FString Lit44;
    static final FString Lit45;
    static final SimpleSymbol Lit46;
    static final IntNum Lit47;
    static final IntNum Lit48;
    static final FString Lit49;
    static final SimpleSymbol Lit5;
    static final PairWithPosition Lit50;
    static final SimpleSymbol Lit6;
    static final IntNum Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static Screen_MAIN Screen_MAIN;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public Button Button1;
    public final ModuleMethod Button1$Click;
    public HorizontalArrangement HorizontalArrangement1;
    public Image Image1;
    public Image Image2;
    public Label Label1;
    public Label Label2;
    public TextBox TextBox1;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;
    static final SimpleSymbol Lit76 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit75 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit74 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit73 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit72 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit71 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit70 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit69 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit68 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit67 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit66 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit65 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit64 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit63 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final FString Lit62 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit61 = IntNum.make(25);
    static final SimpleSymbol Lit60 = (SimpleSymbol) new SimpleSymbol("FontBold").readResolve();
    static final SimpleSymbol Lit59 = (SimpleSymbol) new SimpleSymbol("Label2").readResolve();
    static final FString Lit58 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit57 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final IntNum Lit56 = IntNum.make(-1040);
    static final SimpleSymbol Lit55 = (SimpleSymbol) new SimpleSymbol("Hint").readResolve();
    static final SimpleSymbol Lit54 = (SimpleSymbol) new SimpleSymbol("TextBox1").readResolve();
    static final FString Lit53 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit52 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
    static final SimpleSymbol Lit51 = (SimpleSymbol) new SimpleSymbol("Button1$Click").readResolve();

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit9 = simpleSymbol;
        Lit50 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen_MAIN.yail", 331854);
        Lit49 = new FString("com.google.appinventor.components.runtime.Button");
        Lit48 = IntNum.make(17);
        Lit47 = IntNum.make(new int[]{-8340993});
        Lit46 = (SimpleSymbol) new SimpleSymbol("Button1").readResolve();
        Lit45 = new FString("com.google.appinventor.components.runtime.Button");
        Lit44 = new FString("com.google.appinventor.components.runtime.Image");
        Lit43 = IntNum.make(-1020);
        Lit42 = IntNum.make(-1040);
        Lit41 = (SimpleSymbol) new SimpleSymbol("Image2").readResolve();
        Lit40 = new FString("com.google.appinventor.components.runtime.Image");
        Lit39 = new FString("com.google.appinventor.components.runtime.Label");
        Lit38 = IntNum.make(1);
        Lit37 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
        Lit36 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
        Lit35 = IntNum.make(27);
        Lit34 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
        Lit33 = (SimpleSymbol) new SimpleSymbol("FontItalic").readResolve();
        Lit32 = (SimpleSymbol) new SimpleSymbol("Label1").readResolve();
        Lit31 = new FString("com.google.appinventor.components.runtime.Label");
        Lit30 = new FString("com.google.appinventor.components.runtime.Image");
        Lit29 = IntNum.make(-1020);
        Lit28 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
        Lit27 = (SimpleSymbol) new SimpleSymbol("Picture").readResolve();
        Lit26 = IntNum.make(-1040);
        Lit25 = (SimpleSymbol) new SimpleSymbol("Image1").readResolve();
        Lit24 = new FString("com.google.appinventor.components.runtime.Image");
        Lit23 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit22 = IntNum.make(-1040);
        Lit21 = (SimpleSymbol) new SimpleSymbol("Height").readResolve();
        Lit20 = IntNum.make(14804479);
        Lit19 = (SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve();
        Lit18 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit17 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
        Lit16 = (SimpleSymbol) new SimpleSymbol("Theme").readResolve();
        Lit15 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
        Lit14 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit13 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
        Lit12 = (SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve();
        Lit11 = IntNum.make(new int[]{-4861953});
        Lit10 = (SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve();
        Lit8 = (SimpleSymbol) new SimpleSymbol("AppName").readResolve();
        Lit7 = IntNum.make(2);
        Lit6 = (SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve();
        Lit5 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit4 = IntNum.make(3);
        Lit3 = (SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve();
        Lit2 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
        Lit1 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
        Lit0 = (SimpleSymbol) new SimpleSymbol("Screen_MAIN").readResolve();
    }

    public Screen_MAIN() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit63, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit64, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit65, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit66, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit67, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit68, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit69, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit70, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit71, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit72, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit73, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit74, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit75, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit76, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frameVar, 18, null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime8867388546804848894.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frameVar, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frameVar, 20, null, 0);
        lambda$Fn3 = new ModuleMethod(frameVar, 21, null, 0);
        lambda$Fn4 = new ModuleMethod(frameVar, 22, null, 0);
        lambda$Fn5 = new ModuleMethod(frameVar, 23, null, 0);
        lambda$Fn6 = new ModuleMethod(frameVar, 24, null, 0);
        lambda$Fn7 = new ModuleMethod(frameVar, 25, null, 0);
        lambda$Fn8 = new ModuleMethod(frameVar, 26, null, 0);
        lambda$Fn9 = new ModuleMethod(frameVar, 27, null, 0);
        lambda$Fn10 = new ModuleMethod(frameVar, 28, null, 0);
        lambda$Fn11 = new ModuleMethod(frameVar, 29, null, 0);
        lambda$Fn12 = new ModuleMethod(frameVar, 30, null, 0);
        this.Button1$Click = new ModuleMethod(frameVar, 31, Lit51, 0);
        lambda$Fn13 = new ModuleMethod(frameVar, 32, null, 0);
        lambda$Fn14 = new ModuleMethod(frameVar, 33, null, 0);
        lambda$Fn15 = new ModuleMethod(frameVar, 34, null, 0);
        lambda$Fn16 = new ModuleMethod(frameVar, 35, null, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    @Override // java.lang.Runnable
    public void run() {
        CallContext callContext = CallContext.getInstance();
        Consumer consumer = callContext.consumer;
        callContext.consumer = VoidConsumer.instance;
        try {
            run(callContext);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(callContext, th, consumer);
    }

    public final void run(CallContext $ctx) {
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            this.form$Mnenvironment = Environment.make(Lit0.toString());
            FString stringAppend = strings.stringAppend(Lit0.toString(), "-global-vars");
            this.global$Mnvar$Mnenvironment = Environment.make(stringAppend == null ? null : stringAppend.toString());
            Screen_MAIN = null;
            this.form$Mnname$Mnsymbol = Lit0;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit6, Lit7, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "Week10_SpeedTouchGame", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit5);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "landscape", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit15, "Responsive", Lit9);
                    runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Classic", Lit9);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Screen_MAIN", Lit9), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn2));
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit18, Lit19, lambda$Fn3), $result);
                } else {
                    addToComponents(Lit0, Lit23, Lit19, lambda$Fn4);
                }
                this.Image1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit19, Lit24, Lit25, lambda$Fn5), $result);
                } else {
                    addToComponents(Lit19, Lit30, Lit25, lambda$Fn6);
                }
                this.Label1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit19, Lit31, Lit32, lambda$Fn7), $result);
                } else {
                    addToComponents(Lit19, Lit39, Lit32, lambda$Fn8);
                }
                this.Image2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit19, Lit40, Lit41, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit19, Lit44, Lit41, lambda$Fn10);
                }
                this.Button1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit45, Lit46, lambda$Fn11), $result);
                } else {
                    addToComponents(Lit0, Lit49, Lit46, lambda$Fn12);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit51, this.Button1$Click);
                } else {
                    addToFormEnvironment(Lit51, this.Button1$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button1", "Click");
                } else {
                    addToEvents(Lit46, Lit52);
                }
                this.TextBox1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit53, Lit54, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit0, Lit57, Lit54, lambda$Fn14);
                }
                this.Label2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit58, Lit59, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit0, Lit62, Lit59, lambda$Fn16);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit6, Lit7, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit8, "Week10_SpeedTouchGame", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, Lit11, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit12, "landscape", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, "Responsive", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit16, "Classic", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Screen_MAIN", Lit9);
    }

    static Object lambda4() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit6, Lit7, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit10, Lit20, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit21, Lit22, Lit5);
    }

    static Object lambda5() {
        runtime.setAndCoerceProperty$Ex(Lit19, Lit3, Lit4, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit6, Lit7, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit19, Lit10, Lit20, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit19, Lit21, Lit22, Lit5);
    }

    static Object lambda6() {
        runtime.setAndCoerceProperty$Ex(Lit25, Lit21, Lit26, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit25, Lit27, "Click_After.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit25, Lit28, Lit29, Lit5);
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit25, Lit21, Lit26, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit25, Lit27, "Click_After.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit25, Lit28, Lit29, Lit5);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit33, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit34, Lit35, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit36, "SpeedTouchGame", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit37, Lit38, Lit5);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit33, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit34, Lit35, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit36, "SpeedTouchGame", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit37, Lit38, Lit5);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit21, Lit42, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit41, Lit27, "Click_Before.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit28, Lit43, Lit5);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit21, Lit42, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit41, Lit27, "Click_Before.png", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit28, Lit43, Lit5);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit10, Lit47, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit34, Lit48, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit36, "ClickToStart_개발중입니다.", Lit9);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit46, Lit10, Lit47, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit46, Lit34, Lit48, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit46, Lit36, "ClickToStart_개발중입니다.", Lit9);
    }

    public Object Button1$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("Screen2"), Lit50, "open another screen");
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit55, "WriteAnything", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit37, Lit38, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit28, Lit56, Lit5);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit55, "WriteAnything", Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit37, Lit38, Lit5);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit28, Lit56, Lit5);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit59, Lit60, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit34, Lit61, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit36, "WELCOME", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit59, Lit37, Lit38, Lit5);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit59, Lit60, Boolean.TRUE, Lit14);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit34, Lit61, Lit5);
        runtime.setAndCoerceProperty$Ex(Lit59, Lit36, "WELCOME", Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit59, Lit37, Lit38, Lit5);
    }

    /* compiled from: Screen_MAIN.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Screen_MAIN $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (obj instanceof Screen_MAIN) {
                        callContext.value1 = obj;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    return -786431;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return super.match1(moduleMethod, obj, callContext);
                case 5:
                    if (obj instanceof Symbol) {
                        callContext.value1 = obj;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    return -786431;
                case 7:
                    if (obj instanceof Symbol) {
                        callContext.value1 = obj;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    return -786431;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (obj instanceof Screen_MAIN) {
                        callContext.value1 = obj;
                        callContext.proc = moduleMethod;
                        callContext.pc = 1;
                        return 0;
                    }
                    return -786431;
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (obj instanceof Symbol) {
                        callContext.value1 = obj;
                        callContext.value2 = obj2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    return -786431;
                case 5:
                    if (obj instanceof Symbol) {
                        callContext.value1 = obj;
                        callContext.value2 = obj2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    return -786431;
                case 6:
                case 7:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
                case 8:
                    if (obj instanceof Symbol) {
                        callContext.value1 = obj;
                        callContext.value2 = obj2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    return -786431;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (obj instanceof Screen_MAIN) {
                        callContext.value1 = obj;
                        if (obj2 instanceof Component) {
                            callContext.value2 = obj2;
                            if (obj3 instanceof String) {
                                callContext.value3 = obj3;
                                if (obj4 instanceof String) {
                                    callContext.value4 = obj4;
                                    callContext.proc = moduleMethod;
                                    callContext.pc = 4;
                                    return 0;
                                }
                                return -786428;
                            }
                            return -786429;
                        }
                        return -786430;
                    }
                    return -786431;
                case 16:
                    if (obj instanceof Screen_MAIN) {
                        callContext.value1 = obj;
                        if (obj2 instanceof Component) {
                            callContext.value2 = obj2;
                            if (obj3 instanceof String) {
                                callContext.value3 = obj3;
                                callContext.value4 = obj4;
                                callContext.proc = moduleMethod;
                                callContext.pc = 4;
                                return 0;
                            }
                            return -786429;
                        }
                        return -786430;
                    }
                    return -786431;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 4:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return super.apply1(moduleMethod, obj);
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    try {
                        try {
                            try {
                                try {
                                    this.$main.dispatchGenericEvent((Component) obj, (String) obj2, obj3 != Boolean.FALSE, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 6:
                case 7:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                default:
                    return super.apply2(moduleMethod, obj, obj2);
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
            }
        }

        @Override // gnu.expr.ModuleBody
        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Screen_MAIN.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Screen_MAIN.lambda3();
                case 21:
                    return Screen_MAIN.lambda4();
                case 22:
                    return Screen_MAIN.lambda5();
                case 23:
                    return Screen_MAIN.lambda6();
                case 24:
                    return Screen_MAIN.lambda7();
                case 25:
                    return Screen_MAIN.lambda8();
                case 26:
                    return Screen_MAIN.lambda9();
                case 27:
                    return Screen_MAIN.lambda10();
                case 28:
                    return Screen_MAIN.lambda11();
                case 29:
                    return Screen_MAIN.lambda12();
                case 30:
                    return Screen_MAIN.lambda13();
                case 31:
                    return this.$main.Button1$Click();
                case 32:
                    return Screen_MAIN.lambda14();
                case 33:
                    return Screen_MAIN.lambda15();
                case 34:
                    return Screen_MAIN.lambda16();
                case 35:
                    return Screen_MAIN.lambda17();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        @Override // gnu.expr.ModuleBody
        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.AppInventorCompatActivity, android.app.Activity
    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(true);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        int i = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & 1;
        if (i != 0) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (i == 0) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.HandlesEventDispatching
    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (isBoundInFormEnvironment(registeredObject)) {
            if (lookupInFormEnvironment(registeredObject) == componentObject) {
                Object handler = lookupHandler(registeredComponentName, eventName);
                try {
                    Scheme.apply.apply2(handler, LList.makeList(args, 0));
                    return true;
                } catch (PermissionException exception) {
                    exception.printStackTrace();
                    boolean x = this == componentObject;
                    if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                        processException(exception);
                    } else {
                        PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                    }
                    return false;
                } catch (StopBlocksExecution e) {
                    return false;
                } catch (Throwable exception2) {
                    androidLogForm(exception2.getMessage());
                    exception2.printStackTrace();
                    processException(exception2);
                    return false;
                }
            }
            return false;
        }
        EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
        return false;
    }

    @Override // com.google.appinventor.components.runtime.Form, com.google.appinventor.components.runtime.HandlesEventDispatching
    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        SimpleSymbol handler$Mnsymbol = misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName));
        Object handler = lookupInFormEnvironment(handler$Mnsymbol);
        if (handler != Boolean.FALSE) {
            try {
                Scheme.apply.apply2(handler, lists.cons(componentObject, lists.cons(notAlreadyHandled ? Boolean.TRUE : Boolean.FALSE, LList.makeList(args, 0))));
            } catch (PermissionException exception) {
                exception.printStackTrace();
                boolean x = this == componentObject;
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
            } catch (StopBlocksExecution e) {
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(componentName == null ? null : componentName.toString(), eventName != null ? eventName.toString() : null)));
    }

    @Override // com.google.appinventor.components.runtime.Form
    public void $define() {
        Object obj;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Screen_MAIN = this;
        addToFormEnvironment(Lit0, this);
        LList events = this.events$Mnto$Mnregister;
        Object obj2 = events;
        while (obj2 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj2;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj3 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj3, apply12 == null ? null : apply12.toString());
                obj2 = arg0.getCdr();
            } catch (ClassCastException e) {
                throw new WrongType(e, "arg0", -2, obj2);
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            Object reverse = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse != LList.Empty) {
                try {
                    Pair arg02 = (Pair) reverse;
                    misc.force(arg02.getCar());
                    reverse = arg02.getCdr();
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "arg0", -2, reverse);
                }
            }
            Object obj4 = components;
            while (obj4 != LList.Empty) {
                try {
                    Pair arg03 = (Pair) obj4;
                    Object component$Mninfo = arg03.getCar();
                    Object component$Mnname = lists.caddr.apply1(component$Mninfo);
                    lists.cadddr.apply1(component$Mninfo);
                    Object component$Mntype = lists.cadr.apply1(component$Mninfo);
                    try {
                        Object component$Mncontainer = lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo));
                        Object component$Mnobject = Invoke.make.apply2(component$Mntype, component$Mncontainer);
                        SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                        try {
                            addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                            obj4 = arg03.getCdr();
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "add-to-form-environment", 0, component$Mnname);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "lookup-in-form-environment", 0, obj);
                    }
                } catch (ClassCastException e5) {
                    throw new WrongType(e5, "arg0", -2, obj4);
                }
            }
            LList var$Mnval$Mnpairs = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            Object obj5 = var$Mnval$Mnpairs;
            while (obj5 != LList.Empty) {
                try {
                    Pair arg04 = (Pair) obj5;
                    Object var$Mnval = arg04.getCar();
                    Object var = lists.car.apply1(var$Mnval);
                    Object val$Mnthunk = lists.cadr.apply1(var$Mnval);
                    try {
                        addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(val$Mnthunk));
                        obj5 = arg04.getCdr();
                    } catch (ClassCastException e6) {
                        throw new WrongType(e6, "add-to-global-var-environment", 0, var);
                    }
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "arg0", -2, obj5);
                }
            }
            Object obj6 = components;
            while (obj6 != LList.Empty) {
                try {
                    Pair arg05 = (Pair) obj6;
                    Object component$Mninfo2 = arg05.getCar();
                    lists.caddr.apply1(component$Mninfo2);
                    Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                    if (init$Mnthunk != Boolean.FALSE) {
                        Scheme.applyToArgs.apply1(init$Mnthunk);
                    }
                    obj6 = arg05.getCdr();
                } catch (ClassCastException e8) {
                    throw new WrongType(e8, "arg0", -2, obj6);
                }
            }
            Object obj7 = components;
            while (obj7 != LList.Empty) {
                try {
                    Pair arg06 = (Pair) obj7;
                    Object component$Mninfo3 = arg06.getCar();
                    Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                    lists.cadddr.apply1(component$Mninfo3);
                    callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                    obj7 = arg06.getCdr();
                } catch (ClassCastException e9) {
                    throw new WrongType(e9, "arg0", -2, obj7);
                }
            }
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        LList lList = symbols;
        while (lList != LList.Empty) {
            try {
                Pair arg0 = (Pair) lList;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(((Symbol) car).toString(), obj);
                    lList = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, lList);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
