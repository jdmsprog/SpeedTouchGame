package appinventor.ai_hyeongjinlee0317.Week10_SpeedTouchGame;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextToSpeech;
import com.google.appinventor.components.runtime.VerticalArrangement;
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
import gnu.kawa.functions.AddOp;
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

/* compiled from: Screen1.yail */
/* loaded from: classes.dex */
public class Screen1 extends Form implements Runnable {
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit10;
    static final FString Lit100;
    static final PairWithPosition Lit101;
    static final SimpleSymbol Lit102;
    static final FString Lit103;
    static final SimpleSymbol Lit104;
    static final FString Lit105;
    static final FString Lit106;
    static final SimpleSymbol Lit107;
    static final IntNum Lit108;
    static final IntNum Lit109;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit110;
    static final IntNum Lit111;
    static final FString Lit112;
    static final PairWithPosition Lit113;
    static final PairWithPosition Lit114;
    static final SimpleSymbol Lit115;
    static final FString Lit116;
    static final SimpleSymbol Lit117;
    static final IntNum Lit118;
    static final SimpleSymbol Lit119;
    static final SimpleSymbol Lit12;
    static final IntNum Lit120;
    static final FString Lit121;
    static final PairWithPosition Lit122;
    static final PairWithPosition Lit123;
    static final PairWithPosition Lit124;
    static final PairWithPosition Lit125;
    static final PairWithPosition Lit126;
    static final PairWithPosition Lit127;
    static final PairWithPosition Lit128;
    static final PairWithPosition Lit129;
    static final IntNum Lit13;
    static final PairWithPosition Lit130;
    static final PairWithPosition Lit131;
    static final PairWithPosition Lit132;
    static final PairWithPosition Lit133;
    static final PairWithPosition Lit134;
    static final PairWithPosition Lit135;
    static final PairWithPosition Lit136;
    static final PairWithPosition Lit137;
    static final SimpleSymbol Lit138;
    static final SimpleSymbol Lit139;
    static final SimpleSymbol Lit14;
    static final PairWithPosition Lit140;
    static final SimpleSymbol Lit141;
    static final SimpleSymbol Lit142;
    static final PairWithPosition Lit143;
    static final PairWithPosition Lit144;
    static final SimpleSymbol Lit145;
    static final FString Lit146;
    static final SimpleSymbol Lit147;
    static final IntNum Lit148;
    static final IntNum Lit149;
    static final SimpleSymbol Lit15;
    static final FString Lit150;
    static final SimpleSymbol Lit151;
    static final FString Lit152;
    static final SimpleSymbol Lit153;
    static final FString Lit154;
    static final PairWithPosition Lit155;
    static final IntNum Lit156;
    static final PairWithPosition Lit157;
    static final PairWithPosition Lit158;
    static final SimpleSymbol Lit159;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit160;
    static final FString Lit161;
    static final IntNum Lit162;
    static final FString Lit163;
    static final PairWithPosition Lit164;
    static final PairWithPosition Lit165;
    static final PairWithPosition Lit166;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final IntNum Lit23;
    static final IntNum Lit24;
    static final PairWithPosition Lit25;
    static final SimpleSymbol Lit26;
    static final PairWithPosition Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final FString Lit38;
    static final IntNum Lit39;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit40;
    static final IntNum Lit41;
    static final SimpleSymbol Lit42;
    static final IntNum Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final FString Lit46;
    static final FString Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit5;
    static final IntNum Lit50;
    static final IntNum Lit51;
    static final FString Lit52;
    static final FString Lit53;
    static final SimpleSymbol Lit54;
    static final IntNum Lit55;
    static final IntNum Lit56;
    static final FString Lit57;
    static final FString Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit6;
    static final IntNum Lit60;
    static final FString Lit61;
    static final FString Lit62;
    static final SimpleSymbol Lit63;
    static final FString Lit64;
    static final FString Lit65;
    static final IntNum Lit66;
    static final FString Lit67;
    static final FString Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit7;
    static final IntNum Lit70;
    static final FString Lit71;
    static final FString Lit72;
    static final IntNum Lit73;
    static final IntNum Lit74;
    static final SimpleSymbol Lit75;
    static final IntNum Lit76;
    static final FString Lit77;
    static final PairWithPosition Lit78;
    static final IntNum Lit79;
    static final IntNum Lit8;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final FString Lit82;
    static final SimpleSymbol Lit83;
    static final IntNum Lit84;
    static final IntNum Lit85;
    static final FString Lit86;
    static final FString Lit87;
    static final FString Lit88;
    static final FString Lit89;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit90;
    static final FString Lit91;
    static final FString Lit92;
    static final FString Lit93;
    static final FString Lit94;
    static final SimpleSymbol Lit95;
    static final FString Lit96;
    static final FString Lit97;
    static final IntNum Lit98;
    static final IntNum Lit99;
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn41 = null;
    static final ModuleMethod lambda$Fn42 = null;
    static final ModuleMethod lambda$Fn43 = null;
    static final ModuleMethod lambda$Fn44 = null;
    static final ModuleMethod lambda$Fn45 = null;
    static final ModuleMethod lambda$Fn46 = null;
    static final ModuleMethod lambda$Fn47 = null;
    static final ModuleMethod lambda$Fn48 = null;
    static final ModuleMethod lambda$Fn49 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn50 = null;
    static final ModuleMethod lambda$Fn51 = null;
    static final ModuleMethod lambda$Fn52 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public Clock Clock1;
    public final ModuleMethod Clock1$Timer;
    public Clock Clock2;
    public final ModuleMethod Clock2$Timer;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public HorizontalArrangement HorizontalArrangement3;
    public HorizontalArrangement HorizontalArrangement4;
    public Notifier Notifier1;
    public final ModuleMethod Screen1$Initialize;
    public TextToSpeech TextToSpeech1;
    public VerticalArrangement VerticalArrangement1;
    public VerticalArrangement VerticalArrangement2;
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

    /* renamed from: 결과_버튼  reason: contains not printable characters */
    public Button f0_;

    /* renamed from: 결과_버튼$Click  reason: contains not printable characters */
    public final ModuleMethod f1_$Click;

    /* renamed from: 다시시도버튼  reason: contains not printable characters */
    public Button f2;

    /* renamed from: 다시시도버튼$Click  reason: contains not printable characters */
    public final ModuleMethod f3$Click;

    /* renamed from: 버튼1  reason: contains not printable characters */
    public Button f41;

    /* renamed from: 버튼1$Click  reason: contains not printable characters */
    public final ModuleMethod f51$Click;

    /* renamed from: 버튼2  reason: contains not printable characters */
    public Button f62;

    /* renamed from: 버튼2$Click  reason: contains not printable characters */
    public final ModuleMethod f72$Click;

    /* renamed from: 숫자1  reason: contains not printable characters */
    public Label f81;

    /* renamed from: 숫자2  reason: contains not printable characters */
    public Label f92;

    /* renamed from: 에_클릭하세요1  reason: contains not printable characters */
    public Label f10_1;

    /* renamed from: 에_클릭하세요2  reason: contains not printable characters */
    public Label f11_2;

    /* renamed from: 제목  reason: contains not printable characters */
    public Label f12;

    /* renamed from: 종료버튼  reason: contains not printable characters */
    public Button f13;

    /* renamed from: 종료버튼$Click  reason: contains not printable characters */
    public final ModuleMethod f14$Click;

    /* renamed from: 플레이어1  reason: contains not printable characters */
    public Label f151;

    /* renamed from: 플레이어2  reason: contains not printable characters */
    public Label f162;
    static final SimpleSymbol Lit189 = (SimpleSymbol) new SimpleSymbol("any").readResolve();
    static final SimpleSymbol Lit188 = (SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve();
    static final SimpleSymbol Lit187 = (SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve();
    static final SimpleSymbol Lit186 = (SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve();
    static final SimpleSymbol Lit185 = (SimpleSymbol) new SimpleSymbol("send-error").readResolve();
    static final SimpleSymbol Lit184 = (SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve();
    static final SimpleSymbol Lit183 = (SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve();
    static final SimpleSymbol Lit182 = (SimpleSymbol) new SimpleSymbol("add-to-components").readResolve();
    static final SimpleSymbol Lit181 = (SimpleSymbol) new SimpleSymbol("add-to-events").readResolve();
    static final SimpleSymbol Lit180 = (SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve();
    static final SimpleSymbol Lit179 = (SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve();
    static final SimpleSymbol Lit178 = (SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve();
    static final SimpleSymbol Lit177 = (SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve();
    static final SimpleSymbol Lit176 = (SimpleSymbol) new SimpleSymbol("android-log-form").readResolve();
    static final SimpleSymbol Lit175 = (SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve();
    static final FString Lit174 = new FString("com.google.appinventor.components.runtime.TextToSpeech");
    static final SimpleSymbol Lit173 = (SimpleSymbol) new SimpleSymbol("Language").readResolve();
    static final SimpleSymbol Lit172 = (SimpleSymbol) new SimpleSymbol("Country").readResolve();
    static final FString Lit171 = new FString("com.google.appinventor.components.runtime.TextToSpeech");
    static final FString Lit170 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final IntNum Lit169 = IntNum.make(new int[]{-16777216});
    static final FString Lit168 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit167 = (SimpleSymbol) new SimpleSymbol("Clock2$Timer").readResolve();

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit11 = simpleSymbol;
        Lit166 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1196422);
        Lit165 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1196266), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1196261);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit9 = simpleSymbol2;
        Lit164 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1196155), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1196147);
        Lit163 = new FString("com.google.appinventor.components.runtime.Clock");
        Lit162 = IntNum.make(4);
        Lit161 = new FString("com.google.appinventor.components.runtime.Clock");
        Lit160 = (SimpleSymbol) new SimpleSymbol("Timer").readResolve();
        Lit159 = (SimpleSymbol) new SimpleSymbol("Clock1$Timer").readResolve();
        Lit158 = PairWithPosition.make(Lit11, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1151366);
        Lit157 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1151210), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1151205);
        Lit156 = IntNum.make(0);
        Lit155 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1151099), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1151091);
        Lit154 = new FString("com.google.appinventor.components.runtime.Clock");
        Lit153 = (SimpleSymbol) new SimpleSymbol("TimerInterval").readResolve();
        Lit152 = new FString("com.google.appinventor.components.runtime.Clock");
        Lit151 = (SimpleSymbol) new SimpleSymbol("종료버튼$Click").readResolve();
        Lit150 = new FString("com.google.appinventor.components.runtime.Button");
        Lit149 = IntNum.make(-1015);
        Lit148 = IntNum.make(new int[]{-3801115});
        Lit147 = (SimpleSymbol) new SimpleSymbol("종료버튼").readResolve();
        Lit146 = new FString("com.google.appinventor.components.runtime.Button");
        Lit145 = (SimpleSymbol) new SimpleSymbol("결과_버튼$Click").readResolve();
        Lit144 = PairWithPosition.make(Lit11, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022690);
        Lit143 = PairWithPosition.make(Lit11, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022596);
        Lit142 = (SimpleSymbol) new SimpleSymbol("Speak").readResolve();
        Lit141 = (SimpleSymbol) new SimpleSymbol("TextToSpeech1").readResolve();
        Lit140 = PairWithPosition.make(Lit11, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022497);
        Lit139 = (SimpleSymbol) new SimpleSymbol("ShowAlert").readResolve();
        Lit138 = (SimpleSymbol) new SimpleSymbol("Notifier1").readResolve();
        Lit137 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022335), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022330);
        Lit136 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022134), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1022126);
        Lit135 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021940), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021932);
        Lit134 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021806), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021798);
        Lit133 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021643), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021638);
        Lit132 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021506), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021498);
        Lit131 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021343), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021338);
        Lit130 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021206), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021198);
        Lit129 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021040), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1021032);
        Lit128 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020910), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020902);
        Lit127 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020744), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020736);
        Lit126 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020614), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020606);
        Lit125 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020448), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020440);
        Lit124 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020318), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020310);
        Lit123 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020152), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020144);
        Lit122 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020024), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 1020019);
        Lit121 = new FString("com.google.appinventor.components.runtime.Button");
        Lit120 = IntNum.make(-1015);
        Lit119 = (SimpleSymbol) new SimpleSymbol("FontBold").readResolve();
        Lit118 = IntNum.make(new int[]{-9453313});
        Lit117 = (SimpleSymbol) new SimpleSymbol("결과_버튼").readResolve();
        Lit116 = new FString("com.google.appinventor.components.runtime.Button");
        Lit115 = (SimpleSymbol) new SimpleSymbol("다시시도버튼$Click").readResolve();
        Lit114 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 934351), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 934343);
        Lit113 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 934210), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 934202);
        Lit112 = new FString("com.google.appinventor.components.runtime.Button");
        Lit111 = IntNum.make(-1015);
        Lit110 = (SimpleSymbol) new SimpleSymbol("Shape").readResolve();
        Lit109 = IntNum.make(22);
        Lit108 = IntNum.make(new int[]{-13929729});
        Lit107 = (SimpleSymbol) new SimpleSymbol("다시시도버튼").readResolve();
        Lit106 = new FString("com.google.appinventor.components.runtime.Button");
        Lit105 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit104 = (SimpleSymbol) new SimpleSymbol("HorizontalArrangement4").readResolve();
        Lit103 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit102 = (SimpleSymbol) new SimpleSymbol("버튼2$Click").readResolve();
        Lit101 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 835677), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 835672);
        Lit100 = new FString("com.google.appinventor.components.runtime.Button");
        Lit99 = IntNum.make(-1020);
        Lit98 = IntNum.make(-1036);
        Lit97 = new FString("com.google.appinventor.components.runtime.Button");
        Lit96 = new FString("com.google.appinventor.components.runtime.Label");
        Lit95 = (SimpleSymbol) new SimpleSymbol("에_클릭하세요2").readResolve();
        Lit94 = new FString("com.google.appinventor.components.runtime.Label");
        Lit93 = new FString("com.google.appinventor.components.runtime.Label");
        Lit92 = new FString("com.google.appinventor.components.runtime.Label");
        Lit91 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit90 = (SimpleSymbol) new SimpleSymbol("HorizontalArrangement3").readResolve();
        Lit89 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit88 = new FString("com.google.appinventor.components.runtime.Label");
        Lit87 = new FString("com.google.appinventor.components.runtime.Label");
        Lit86 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit85 = IntNum.make(-1050);
        Lit84 = IntNum.make(new int[]{-3735614});
        Lit83 = (SimpleSymbol) new SimpleSymbol("VerticalArrangement2").readResolve();
        Lit82 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit81 = (SimpleSymbol) new SimpleSymbol("Click").readResolve();
        Lit80 = (SimpleSymbol) new SimpleSymbol("버튼1$Click").readResolve();
        Lit79 = IntNum.make(500);
        Lit78 = PairWithPosition.make(Lit189, PairWithPosition.make(Lit189, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 532573), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 532568);
        Lit77 = new FString("com.google.appinventor.components.runtime.Button");
        Lit76 = IntNum.make(-1020);
        Lit75 = (SimpleSymbol) new SimpleSymbol(Component.LISTVIEW_KEY_IMAGE).readResolve();
        Lit74 = IntNum.make(-1036);
        Lit73 = IntNum.make(40);
        Lit72 = new FString("com.google.appinventor.components.runtime.Button");
        Lit71 = new FString("com.google.appinventor.components.runtime.Label");
        Lit70 = IntNum.make(18);
        Lit69 = (SimpleSymbol) new SimpleSymbol("에_클릭하세요1").readResolve();
        Lit68 = new FString("com.google.appinventor.components.runtime.Label");
        Lit67 = new FString("com.google.appinventor.components.runtime.Label");
        Lit66 = IntNum.make(28);
        Lit65 = new FString("com.google.appinventor.components.runtime.Label");
        Lit64 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit63 = (SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve();
        Lit62 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit61 = new FString("com.google.appinventor.components.runtime.Label");
        Lit60 = IntNum.make(26);
        Lit59 = (SimpleSymbol) new SimpleSymbol("FontItalic").readResolve();
        Lit58 = new FString("com.google.appinventor.components.runtime.Label");
        Lit57 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit56 = IntNum.make(-1050);
        Lit55 = IntNum.make(new int[]{-11145});
        Lit54 = (SimpleSymbol) new SimpleSymbol("VerticalArrangement1").readResolve();
        Lit53 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
        Lit52 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit51 = IntNum.make(-1068);
        Lit50 = IntNum.make(2);
        Lit49 = (SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve();
        Lit48 = (SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve();
        Lit47 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
        Lit46 = new FString("com.google.appinventor.components.runtime.Label");
        Lit45 = (SimpleSymbol) new SimpleSymbol("Width").readResolve();
        Lit44 = (SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve();
        Lit43 = IntNum.make(-2);
        Lit42 = (SimpleSymbol) new SimpleSymbol("Height").readResolve();
        Lit41 = IntNum.make(29);
        Lit40 = (SimpleSymbol) new SimpleSymbol("FontSize").readResolve();
        Lit39 = IntNum.make(new int[]{-2889985});
        Lit38 = new FString("com.google.appinventor.components.runtime.Label");
        Lit37 = (SimpleSymbol) new SimpleSymbol("Initialize").readResolve();
        Lit36 = (SimpleSymbol) new SimpleSymbol("Screen1$Initialize").readResolve();
        Lit35 = (SimpleSymbol) new SimpleSymbol("제목").readResolve();
        Lit34 = (SimpleSymbol) new SimpleSymbol("플레이어2").readResolve();
        Lit33 = (SimpleSymbol) new SimpleSymbol("플레이어1").readResolve();
        Lit32 = (SimpleSymbol) new SimpleSymbol("버튼2").readResolve();
        Lit31 = (SimpleSymbol) new SimpleSymbol("버튼1").readResolve();
        Lit30 = (SimpleSymbol) new SimpleSymbol("Clock2").readResolve();
        Lit29 = (SimpleSymbol) new SimpleSymbol("TimerEnabled").readResolve();
        Lit28 = (SimpleSymbol) new SimpleSymbol("Clock1").readResolve();
        Lit27 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 106751), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 106743);
        Lit26 = (SimpleSymbol) new SimpleSymbol("숫자2").readResolve();
        Lit25 = PairWithPosition.make(Lit9, PairWithPosition.make(Lit9, LList.Empty, "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 106610), "/tmp/1702535633840_0.9318309371853506-0/youngandroidproject/../src/appinventor/ai_hyeongjinlee0317/Week10_SpeedTouchGame/Screen1.yail", 106602);
        Lit24 = IntNum.make(300);
        Lit23 = IntNum.make(1);
        Lit22 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
        Lit21 = (SimpleSymbol) new SimpleSymbol("숫자1").readResolve();
        Lit20 = (SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve();
        Lit19 = (SimpleSymbol) new SimpleSymbol("Title").readResolve();
        Lit18 = (SimpleSymbol) new SimpleSymbol("Theme").readResolve();
        Lit17 = (SimpleSymbol) new SimpleSymbol("Sizing").readResolve();
        Lit16 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit15 = (SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve();
        Lit14 = (SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve();
        Lit13 = IntNum.make(new int[]{-599041});
        Lit12 = (SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve();
        Lit10 = (SimpleSymbol) new SimpleSymbol("AppName").readResolve();
        Lit8 = IntNum.make(3);
        Lit7 = (SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve();
        Lit6 = (SimpleSymbol) new SimpleSymbol("g$결과용1").readResolve();
        Lit5 = (SimpleSymbol) new SimpleSymbol("g$결과용2").readResolve();
        Lit4 = (SimpleSymbol) new SimpleSymbol("g$IsClick1").readResolve();
        Lit3 = (SimpleSymbol) new SimpleSymbol("g$IsClick2").readResolve();
        Lit2 = (SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve();
        Lit1 = (SimpleSymbol) new SimpleSymbol("getMessage").readResolve();
        Lit0 = (SimpleSymbol) new SimpleSymbol("Screen1").readResolve();
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frameVar = new frame();
        frameVar.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frameVar, 1, Lit175, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frameVar, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frameVar, 3, Lit176, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frameVar, 4, Lit177, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 5, Lit178, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frameVar, 7, Lit179, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frameVar, 8, Lit180, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frameVar, 9, Lit181, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frameVar, 10, Lit182, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frameVar, 11, Lit183, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frameVar, 12, Lit184, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frameVar, 13, Lit185, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frameVar, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frameVar, 15, Lit186, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frameVar, 16, Lit187, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frameVar, 17, Lit188, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frameVar, 18, null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime8867388546804848894.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frameVar, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frameVar, 20, null, 0);
        lambda$Fn3 = new ModuleMethod(frameVar, 21, null, 0);
        lambda$Fn4 = new ModuleMethod(frameVar, 22, null, 0);
        lambda$Fn5 = new ModuleMethod(frameVar, 23, null, 0);
        lambda$Fn6 = new ModuleMethod(frameVar, 24, null, 0);
        this.Screen1$Initialize = new ModuleMethod(frameVar, 25, Lit36, 0);
        lambda$Fn7 = new ModuleMethod(frameVar, 26, null, 0);
        lambda$Fn8 = new ModuleMethod(frameVar, 27, null, 0);
        lambda$Fn9 = new ModuleMethod(frameVar, 28, null, 0);
        lambda$Fn10 = new ModuleMethod(frameVar, 29, null, 0);
        lambda$Fn11 = new ModuleMethod(frameVar, 30, null, 0);
        lambda$Fn12 = new ModuleMethod(frameVar, 31, null, 0);
        lambda$Fn13 = new ModuleMethod(frameVar, 32, null, 0);
        lambda$Fn14 = new ModuleMethod(frameVar, 33, null, 0);
        lambda$Fn15 = new ModuleMethod(frameVar, 34, null, 0);
        lambda$Fn16 = new ModuleMethod(frameVar, 35, null, 0);
        lambda$Fn17 = new ModuleMethod(frameVar, 36, null, 0);
        lambda$Fn18 = new ModuleMethod(frameVar, 37, null, 0);
        lambda$Fn19 = new ModuleMethod(frameVar, 38, null, 0);
        lambda$Fn20 = new ModuleMethod(frameVar, 39, null, 0);
        lambda$Fn21 = new ModuleMethod(frameVar, 40, null, 0);
        lambda$Fn22 = new ModuleMethod(frameVar, 41, null, 0);
        this.f51$Click = new ModuleMethod(frameVar, 42, Lit80, 0);
        lambda$Fn23 = new ModuleMethod(frameVar, 43, null, 0);
        lambda$Fn24 = new ModuleMethod(frameVar, 44, null, 0);
        lambda$Fn25 = new ModuleMethod(frameVar, 45, null, 0);
        lambda$Fn26 = new ModuleMethod(frameVar, 46, null, 0);
        lambda$Fn27 = new ModuleMethod(frameVar, 47, null, 0);
        lambda$Fn28 = new ModuleMethod(frameVar, 48, null, 0);
        lambda$Fn29 = new ModuleMethod(frameVar, 49, null, 0);
        lambda$Fn30 = new ModuleMethod(frameVar, 50, null, 0);
        lambda$Fn31 = new ModuleMethod(frameVar, 51, null, 0);
        lambda$Fn32 = new ModuleMethod(frameVar, 52, null, 0);
        lambda$Fn33 = new ModuleMethod(frameVar, 53, null, 0);
        lambda$Fn34 = new ModuleMethod(frameVar, 54, null, 0);
        this.f72$Click = new ModuleMethod(frameVar, 55, Lit102, 0);
        lambda$Fn35 = new ModuleMethod(frameVar, 56, null, 0);
        lambda$Fn36 = new ModuleMethod(frameVar, 57, null, 0);
        lambda$Fn37 = new ModuleMethod(frameVar, 58, null, 0);
        lambda$Fn38 = new ModuleMethod(frameVar, 59, null, 0);
        this.f3$Click = new ModuleMethod(frameVar, 60, Lit115, 0);
        lambda$Fn39 = new ModuleMethod(frameVar, 61, null, 0);
        lambda$Fn40 = new ModuleMethod(frameVar, 62, null, 0);
        lambda$Fn41 = new ModuleMethod(frameVar, 63, null, 0);
        lambda$Fn42 = new ModuleMethod(frameVar, 64, null, 0);
        this.f1_$Click = new ModuleMethod(frameVar, 65, Lit145, 0);
        lambda$Fn43 = new ModuleMethod(frameVar, 66, null, 0);
        lambda$Fn44 = new ModuleMethod(frameVar, 67, null, 0);
        this.f14$Click = new ModuleMethod(frameVar, 68, Lit151, 0);
        lambda$Fn45 = new ModuleMethod(frameVar, 69, null, 0);
        lambda$Fn46 = new ModuleMethod(frameVar, 70, null, 0);
        this.Clock1$Timer = new ModuleMethod(frameVar, 71, Lit159, 0);
        lambda$Fn47 = new ModuleMethod(frameVar, 72, null, 0);
        lambda$Fn48 = new ModuleMethod(frameVar, 73, null, 0);
        this.Clock2$Timer = new ModuleMethod(frameVar, 74, Lit167, 0);
        lambda$Fn49 = new ModuleMethod(frameVar, 75, null, 0);
        lambda$Fn50 = new ModuleMethod(frameVar, 76, null, 0);
        lambda$Fn51 = new ModuleMethod(frameVar, 77, null, 0);
        lambda$Fn52 = new ModuleMethod(frameVar, 78, null, 0);
    }

    static Boolean lambda3() {
        return Boolean.FALSE;
    }

    static Boolean lambda4() {
        return Boolean.FALSE;
    }

    static Boolean lambda5() {
        return Boolean.FALSE;
    }

    static Boolean lambda6() {
        return Boolean.FALSE;
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
        runtime.$instance.run();
        this.$Stdebug$Mnform$St = Boolean.FALSE;
        this.form$Mnenvironment = Environment.make(Lit0.toString());
        FString stringAppend = strings.stringAppend(Lit0.toString(), "-global-vars");
        this.global$Mnvar$Mnenvironment = Environment.make(stringAppend == null ? null : stringAppend.toString());
        Screen1 = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.FALSE), $result);
        } else {
            addToGlobalVars(Lit3, lambda$Fn2);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, Boolean.FALSE), $result);
        } else {
            addToGlobalVars(Lit4, lambda$Fn3);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, Boolean.FALSE), $result);
        } else {
            addToGlobalVars(Lit5, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.FALSE), $result);
        } else {
            addToGlobalVars(Lit6, lambda$Fn5);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit7, Lit8, Lit9);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Week10_SpeedTouchGame", Lit11);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit12, Lit13, Lit9);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit14, "landscape", Lit11);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit16);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit11);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Classic", Lit11);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit19, "Screen1", Lit11);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit20, Boolean.FALSE, Lit16), $result);
        } else {
            addToFormDoAfterCreation(new Promise(lambda$Fn6));
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit36, this.Screen1$Initialize);
        } else {
            addToFormEnvironment(Lit36, this.Screen1$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
        } else {
            addToEvents(Lit0, Lit37);
        }
        this.f12 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit38, Lit35, lambda$Fn7), $result);
        } else {
            addToComponents(Lit0, Lit46, Lit35, lambda$Fn8);
        }
        this.HorizontalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit47, Lit48, lambda$Fn9), $result);
        } else {
            addToComponents(Lit0, Lit52, Lit48, lambda$Fn10);
        }
        this.VerticalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit48, Lit53, Lit54, lambda$Fn11), $result);
        } else {
            addToComponents(Lit48, Lit57, Lit54, lambda$Fn12);
        }
        this.f151 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit58, Lit33, lambda$Fn13), $result);
        } else {
            addToComponents(Lit54, Lit61, Lit33, lambda$Fn14);
        }
        this.HorizontalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit62, Lit63, lambda$Fn15), $result);
        } else {
            addToComponents(Lit54, Lit64, Lit63, lambda$Fn16);
        }
        this.f81 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit63, Lit65, Lit21, lambda$Fn17), $result);
        } else {
            addToComponents(Lit63, Lit67, Lit21, lambda$Fn18);
        }
        this.f10_1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit63, Lit68, Lit69, lambda$Fn19), $result);
        } else {
            addToComponents(Lit63, Lit71, Lit69, lambda$Fn20);
        }
        this.f41 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit54, Lit72, Lit31, lambda$Fn21), $result);
        } else {
            addToComponents(Lit54, Lit77, Lit31, lambda$Fn22);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit80, this.f51$Click);
        } else {
            addToFormEnvironment(Lit80, this.f51$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "버튼1", "Click");
        } else {
            addToEvents(Lit31, Lit81);
        }
        this.VerticalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit48, Lit82, Lit83, lambda$Fn23), $result);
        } else {
            addToComponents(Lit48, Lit86, Lit83, lambda$Fn24);
        }
        this.f162 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit83, Lit87, Lit34, lambda$Fn25), $result);
        } else {
            addToComponents(Lit83, Lit88, Lit34, lambda$Fn26);
        }
        this.HorizontalArrangement3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit83, Lit89, Lit90, lambda$Fn27), $result);
        } else {
            addToComponents(Lit83, Lit91, Lit90, lambda$Fn28);
        }
        this.f92 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit90, Lit92, Lit26, lambda$Fn29), $result);
        } else {
            addToComponents(Lit90, Lit93, Lit26, lambda$Fn30);
        }
        this.f11_2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit90, Lit94, Lit95, lambda$Fn31), $result);
        } else {
            addToComponents(Lit90, Lit96, Lit95, lambda$Fn32);
        }
        this.f62 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit83, Lit97, Lit32, lambda$Fn33), $result);
        } else {
            addToComponents(Lit83, Lit100, Lit32, lambda$Fn34);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit102, this.f72$Click);
        } else {
            addToFormEnvironment(Lit102, this.f72$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "버튼2", "Click");
        } else {
            addToEvents(Lit32, Lit81);
        }
        this.HorizontalArrangement4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit103, Lit104, lambda$Fn35), $result);
        } else {
            addToComponents(Lit0, Lit105, Lit104, lambda$Fn36);
        }
        this.f2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit104, Lit106, Lit107, lambda$Fn37), $result);
        } else {
            addToComponents(Lit104, Lit112, Lit107, lambda$Fn38);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit115, this.f3$Click);
        } else {
            addToFormEnvironment(Lit115, this.f3$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "다시시도버튼", "Click");
        } else {
            addToEvents(Lit107, Lit81);
        }
        this.f0_ = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit104, Lit116, Lit117, lambda$Fn39), $result);
        } else {
            addToComponents(Lit104, Lit121, Lit117, lambda$Fn40);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit145, this.f1_$Click);
        } else {
            addToFormEnvironment(Lit145, this.f1_$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "결과_버튼", "Click");
        } else {
            addToEvents(Lit117, Lit81);
        }
        this.f13 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit104, Lit146, Lit147, lambda$Fn43), $result);
        } else {
            addToComponents(Lit104, Lit150, Lit147, lambda$Fn44);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit151, this.f14$Click);
        } else {
            addToFormEnvironment(Lit151, this.f14$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "종료버튼", "Click");
        } else {
            addToEvents(Lit147, Lit81);
        }
        this.Clock1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit152, Lit28, lambda$Fn45), $result);
        } else {
            addToComponents(Lit0, Lit154, Lit28, lambda$Fn46);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit159, this.Clock1$Timer);
        } else {
            addToFormEnvironment(Lit159, this.Clock1$Timer);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Clock1", "Timer");
        } else {
            addToEvents(Lit28, Lit160);
        }
        this.Clock2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit161, Lit30, lambda$Fn47), $result);
        } else {
            addToComponents(Lit0, Lit163, Lit30, lambda$Fn48);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit167, this.Clock2$Timer);
        } else {
            addToFormEnvironment(Lit167, this.Clock2$Timer);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Clock2", "Timer");
        } else {
            addToEvents(Lit30, Lit160);
        }
        this.Notifier1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit168, Lit138, lambda$Fn49), $result);
        } else {
            addToComponents(Lit0, Lit170, Lit138, lambda$Fn50);
        }
        this.TextToSpeech1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit171, Lit141, lambda$Fn51), $result);
        } else {
            addToComponents(Lit0, Lit174, Lit141, lambda$Fn52);
        }
        runtime.initRuntime();
    }

    static Object lambda7() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit10, "Week10_SpeedTouchGame", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit12, Lit13, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit14, "landscape", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit17, "Responsive", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, "Classic", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit19, "Screen1", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit20, Boolean.FALSE, Lit16);
    }

    public Object Screen1$Initialize() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, runtime.callYailPrimitive(runtime.random$Mninteger, LList.list2(Lit23, Lit24), Lit25, "random integer"), Lit11);
        runtime.setAndCoerceProperty$Ex(Lit26, Lit22, runtime.callYailPrimitive(runtime.random$Mninteger, LList.list2(Lit23, Lit24), Lit27, "random integer"), Lit11);
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, "-", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, "-", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit22, "Player1", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit22, "Player2", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "SpeedTouchGame", Lit11);
    }

    static Object lambda8() {
        runtime.setAndCoerceProperty$Ex(Lit35, Lit12, Lit39, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit40, Lit41, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "Speed Touch Game", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit44, Lit23, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit45, Lit43, Lit9);
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit35, Lit12, Lit39, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit40, Lit41, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "Speed Touch Game", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit35, Lit44, Lit23, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit45, Lit43, Lit9);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit42, Lit51, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit45, Lit43, Lit9);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit42, Lit51, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit45, Lit43, Lit9);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit12, Lit55, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit42, Lit43, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit45, Lit56, Lit9);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit54, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit12, Lit55, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit54, Lit42, Lit43, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit54, Lit45, Lit56, Lit9);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit33, Lit59, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit40, Lit60, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit22, "Player1", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit33, Lit44, Lit23, Lit9);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit33, Lit59, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit40, Lit60, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit22, "Player1", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit33, Lit44, Lit23, Lit9);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit7, Lit8, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit49, Lit50, Lit9);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit7, Lit8, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit49, Lit50, Lit9);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit40, Lit66, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit44, Lit23, Lit9);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit40, Lit66, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit21, Lit44, Lit23, Lit9);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit40, Lit70, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit22, "에 클릭하세요.", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit44, Lit23, Lit9);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit40, Lit70, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit22, "에 클릭하세요.", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit44, Lit23, Lit9);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit31, Lit40, Lit73, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit42, Lit74, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit75, "Click_After.png", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, "-", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit31, Lit45, Lit76, Lit9);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit31, Lit40, Lit73, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit42, Lit74, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit75, "Click_After.png", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, "-", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit31, Lit45, Lit76, Lit9);
    }

    /* renamed from: 버튼1$Click  reason: contains not printable characters */
    public Object m71$Click() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), Boolean.FALSE), Lit78, "=") == Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
            return runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.TRUE);
        }
        runtime.addGlobalVarToCurrentFormEnvironment(Lit4, Boolean.TRUE);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, Lit79, Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.TRUE, Lit16);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit83, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit12, Lit84, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit42, Lit43, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit83, Lit45, Lit85, Lit9);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit83, Lit7, Lit8, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit49, Lit50, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit12, Lit84, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit83, Lit42, Lit43, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit83, Lit45, Lit85, Lit9);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit34, Lit59, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit40, Lit60, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit22, "Player2", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit34, Lit44, Lit23, Lit9);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit34, Lit59, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit40, Lit60, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit22, "Player2", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit34, Lit44, Lit23, Lit9);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit90, Lit7, Lit8, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit90, Lit49, Lit50, Lit9);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit90, Lit7, Lit8, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit90, Lit49, Lit50, Lit9);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit26, Lit40, Lit66, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit26, Lit44, Lit23, Lit9);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit26, Lit40, Lit66, Lit9);
        return runtime.setAndCoerceProperty$Ex(Lit26, Lit44, Lit23, Lit9);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit95, Lit40, Lit70, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit22, "에 클릭하세요.", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit95, Lit44, Lit23, Lit9);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit95, Lit40, Lit70, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit95, Lit22, "에 클릭하세요.", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit95, Lit44, Lit23, Lit9);
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit40, Lit73, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit42, Lit98, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit75, "Click_After.png", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, "-", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit45, Lit99, Lit9);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit32, Lit40, Lit73, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit42, Lit98, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit75, "Click_After.png", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, "-", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit32, Lit45, Lit99, Lit9);
    }

    /* renamed from: 버튼2$Click  reason: contains not printable characters */
    public Object m82$Click() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), Boolean.FALSE), Lit101, "=") == Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
            return runtime.addGlobalVarToCurrentFormEnvironment(Lit5, Boolean.TRUE);
        }
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.TRUE);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, Lit79, Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.TRUE, Lit16);
    }

    static Object lambda36() {
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit42, Lit43, Lit9);
    }

    static Object lambda37() {
        return runtime.setAndCoerceProperty$Ex(Lit104, Lit42, Lit43, Lit9);
    }

    static Object lambda38() {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit12, Lit108, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit22, "다시시도", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit45, Lit111, Lit9);
    }

    static Object lambda39() {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit12, Lit108, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit107, Lit22, "다시시도", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit45, Lit111, Lit9);
    }

    /* renamed from: 다시시도버튼$Click  reason: contains not printable characters */
    public Object m6$Click() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit4, Boolean.FALSE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.FALSE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.FALSE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit5, Boolean.FALSE);
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, runtime.callYailPrimitive(runtime.random$Mninteger, LList.list2(Lit23, Lit24), Lit113, "random integer"), Lit11);
        runtime.setAndCoerceProperty$Ex(Lit26, Lit22, runtime.callYailPrimitive(runtime.random$Mninteger, LList.list2(Lit23, Lit24), Lit114, "random integer"), Lit11);
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, "-", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, "-", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit33, Lit22, "Player1", Lit11);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit22, "Player2", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "SpeedTouchGame", Lit11);
    }

    static Object lambda40() {
        runtime.setAndCoerceProperty$Ex(Lit117, Lit12, Lit118, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit119, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit22, "결과", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit117, Lit45, Lit120, Lit9);
    }

    static Object lambda41() {
        runtime.setAndCoerceProperty$Ex(Lit117, Lit12, Lit118, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit119, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit117, Lit22, "결과", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit117, Lit45, Lit120, Lit9);
    }

    /* renamed from: 결과_버튼$Click  reason: contains not printable characters */
    public Object m5_$Click() {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.processAndDelayed$V(new Object[]{lambda$Fn41, lambda$Fn42}), Boolean.TRUE), Lit122, "=") != Boolean.FALSE) {
            if (runtime.callYailPrimitive(Scheme.numGrt, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), runtime.get$Mnproperty.apply2(Lit21, Lit22)), Lit123, ">") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit33, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), runtime.get$Mnproperty.apply2(Lit21, Lit22)), Lit124, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), runtime.get$Mnproperty.apply2(Lit21, Lit22)), Lit125, "<") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit33, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit21, Lit22), runtime.get$Mnproperty.apply2(Lit31, Lit22)), Lit126, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(Scheme.numGrt, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), runtime.get$Mnproperty.apply2(Lit26, Lit22)), Lit127, ">") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit34, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), runtime.get$Mnproperty.apply2(Lit26, Lit22)), Lit128, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), runtime.get$Mnproperty.apply2(Lit26, Lit22)), Lit129, "<") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit34, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit26, Lit22), runtime.get$Mnproperty.apply2(Lit32, Lit22)), Lit130, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), runtime.get$Mnproperty.apply2(Lit21, Lit22)), Lit131, "=") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit33, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), runtime.get$Mnproperty.apply2(Lit21, Lit22)), Lit132, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), runtime.get$Mnproperty.apply2(Lit26, Lit22)), Lit133, "=") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit34, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit26, Lit22), runtime.get$Mnproperty.apply2(Lit32, Lit22)), Lit134, "-"), Lit11);
            }
            if (runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.get$Mnproperty.apply2(Lit33, Lit22), runtime.get$Mnproperty.apply2(Lit34, Lit22)), Lit135, "<") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "PLAYER1 WIN!", Lit11);
            }
            if (runtime.callYailPrimitive(Scheme.numGrt, LList.list2(runtime.get$Mnproperty.apply2(Lit33, Lit22), runtime.get$Mnproperty.apply2(Lit34, Lit22)), Lit136, ">") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "PLAYER2 WIN!", Lit11);
            }
            if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit33, Lit22), runtime.get$Mnproperty.apply2(Lit34, Lit22)), Lit137, "=") != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit35, Lit22, "TIE!", Lit11);
            }
            runtime.callComponentMethod(Lit138, Lit139, LList.list1(runtime.get$Mnproperty.apply2(Lit35, Lit22)), Lit140);
            return runtime.callComponentMethod(Lit141, Lit142, LList.list1(runtime.get$Mnproperty.apply2(Lit35, Lit22)), Lit143);
        }
        return runtime.callComponentMethod(Lit138, Lit139, LList.list1("ERROR!"), Lit144);
    }

    static Object lambda42() {
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit6, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda43() {
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda44() {
        runtime.setAndCoerceProperty$Ex(Lit147, Lit12, Lit148, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit119, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit22, "종료", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit45, Lit149, Lit9);
    }

    static Object lambda45() {
        runtime.setAndCoerceProperty$Ex(Lit147, Lit12, Lit148, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit119, Boolean.TRUE, Lit16);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit40, Lit109, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit42, Lit43, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit110, Lit23, Lit9);
        runtime.setAndCoerceProperty$Ex(Lit147, Lit22, "종료", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit147, Lit45, Lit149, Lit9);
    }

    /* renamed from: 종료버튼$Click  reason: contains not printable characters */
    public Object m9$Click() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.close$Mnapplication, LList.Empty, LList.Empty, "close application");
    }

    static Object lambda46() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit153, Lit23, Lit9);
    }

    static Object lambda47() {
        runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
        return runtime.setAndCoerceProperty$Ex(Lit28, Lit153, Lit23, Lit9);
    }

    public Object Clock1$Timer() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit31, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), Lit23), Lit155, "-"), Lit11);
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit31, Lit22), Lit156), Lit157, "=") != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit28, Lit29, Boolean.FALSE, Lit16);
            return runtime.callComponentMethod(Lit138, Lit139, LList.list1("OH, NO!"), Lit158);
        }
        return Values.empty;
    }

    static Object lambda48() {
        runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
        return runtime.setAndCoerceProperty$Ex(Lit30, Lit153, Lit162, Lit9);
    }

    static Object lambda49() {
        runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
        return runtime.setAndCoerceProperty$Ex(Lit30, Lit153, Lit162, Lit9);
    }

    public Object Clock2$Timer() {
        runtime.setThisForm();
        runtime.setAndCoerceProperty$Ex(Lit32, Lit22, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), Lit23), Lit164, "-"), Lit11);
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.get$Mnproperty.apply2(Lit32, Lit22), Lit156), Lit165, "=") != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit30, Lit29, Boolean.FALSE, Lit16);
            return runtime.callComponentMethod(Lit138, Lit139, LList.list1("OH, NO!"), Lit166);
        }
        return Values.empty;
    }

    static Object lambda50() {
        return runtime.setAndCoerceProperty$Ex(Lit138, Lit12, Lit169, Lit9);
    }

    static Object lambda51() {
        return runtime.setAndCoerceProperty$Ex(Lit138, Lit12, Lit169, Lit9);
    }

    static Object lambda52() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit172, "USA", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit173, "en", Lit11);
    }

    static Object lambda53() {
        runtime.setAndCoerceProperty$Ex(Lit141, Lit172, "USA", Lit11);
        return runtime.setAndCoerceProperty$Ex(Lit141, Lit173, "en", Lit11);
    }

    /* compiled from: Screen1.yail */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Screen1 $main;

        @Override // gnu.expr.ModuleBody
        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (obj instanceof Screen1) {
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
                    if (obj instanceof Screen1) {
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
                    if (obj instanceof Screen1) {
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
                    if (obj instanceof Screen1) {
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
                    return Screen1.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Screen1.lambda3();
                case 21:
                    return Screen1.lambda4();
                case 22:
                    return Screen1.lambda5();
                case 23:
                    return Screen1.lambda6();
                case 24:
                    return Screen1.lambda7();
                case 25:
                    return this.$main.Screen1$Initialize();
                case 26:
                    return Screen1.lambda8();
                case 27:
                    return Screen1.lambda9();
                case 28:
                    return Screen1.lambda10();
                case 29:
                    return Screen1.lambda11();
                case 30:
                    return Screen1.lambda12();
                case 31:
                    return Screen1.lambda13();
                case 32:
                    return Screen1.lambda14();
                case 33:
                    return Screen1.lambda15();
                case 34:
                    return Screen1.lambda16();
                case 35:
                    return Screen1.lambda17();
                case 36:
                    return Screen1.lambda18();
                case 37:
                    return Screen1.lambda19();
                case 38:
                    return Screen1.lambda20();
                case 39:
                    return Screen1.lambda21();
                case 40:
                    return Screen1.lambda22();
                case 41:
                    return Screen1.lambda23();
                case 42:
                    return this.$main.m71$Click();
                case 43:
                    return Screen1.lambda24();
                case 44:
                    return Screen1.lambda25();
                case 45:
                    return Screen1.lambda26();
                case 46:
                    return Screen1.lambda27();
                case 47:
                    return Screen1.lambda28();
                case 48:
                    return Screen1.lambda29();
                case 49:
                    return Screen1.lambda30();
                case 50:
                    return Screen1.lambda31();
                case 51:
                    return Screen1.lambda32();
                case 52:
                    return Screen1.lambda33();
                case 53:
                    return Screen1.lambda34();
                case 54:
                    return Screen1.lambda35();
                case 55:
                    return this.$main.m82$Click();
                case 56:
                    return Screen1.lambda36();
                case 57:
                    return Screen1.lambda37();
                case 58:
                    return Screen1.lambda38();
                case 59:
                    return Screen1.lambda39();
                case 60:
                    return this.$main.m6$Click();
                case 61:
                    return Screen1.lambda40();
                case 62:
                    return Screen1.lambda41();
                case 63:
                    return Screen1.lambda42();
                case 64:
                    return Screen1.lambda43();
                case 65:
                    return this.$main.m5_$Click();
                case 66:
                    return Screen1.lambda44();
                case 67:
                    return Screen1.lambda45();
                case 68:
                    return this.$main.m9$Click();
                case 69:
                    return Screen1.lambda46();
                case 70:
                    return Screen1.lambda47();
                case 71:
                    return this.$main.Clock1$Timer();
                case 72:
                    return Screen1.lambda48();
                case 73:
                    return Screen1.lambda49();
                case 74:
                    return this.$main.Clock2$Timer();
                case 75:
                    return Screen1.lambda50();
                case 76:
                    return Screen1.lambda51();
                case 77:
                    return Screen1.lambda52();
                case 78:
                    return Screen1.lambda53();
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
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 54:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 55:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 61:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 62:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 63:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 64:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 65:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 66:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 67:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 68:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 69:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 70:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 71:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 72:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 73:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 74:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 75:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 76:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 77:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 78:
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
        Screen1 = this;
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
