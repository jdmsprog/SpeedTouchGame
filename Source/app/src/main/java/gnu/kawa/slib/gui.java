package gnu.kawa.slib;

import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.Component;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Display;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.xml.KAttr;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.misc;
import kawa.standard.Scheme;

/* compiled from: gui.scm */
/* loaded from: classes.dex */
public class gui extends ModuleBody {
    public static final gui $instance;
    public static final ModuleMethod Button;
    public static final ModuleMethod Column;
    public static final Macro Image;
    public static final ModuleMethod Label;
    static final Class Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SyntaxRules Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SyntaxRules Lit24;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SyntaxRules Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod Row;
    public static final ModuleMethod Text;
    public static final ModuleMethod Window;
    public static final ModuleMethod as$Mncolor;
    public static final ModuleMethod button;
    public static final ModuleMethod image$Mnheight;
    public static final ModuleMethod image$Mnread;
    public static final ModuleMethod image$Mnwidth;
    static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr;
    static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr;
    static final Location loc$$St$DtgetHeight;
    static final Location loc$$St$DtgetWidth;
    public static final Macro process$Mnkeywords;
    public static final Macro run$Mnapplication;
    public static final ModuleMethod set$Mncontent;
    static final IntNum Lit44 = IntNum.make(1);
    static final SimpleSymbol Lit43 = (SimpleSymbol) new SimpleSymbol("value").readResolve();
    static final SimpleSymbol Lit42 = (SimpleSymbol) new SimpleSymbol("name").readResolve();
    static final SimpleSymbol Lit41 = (SimpleSymbol) new SimpleSymbol("invoke").readResolve();
    static final SimpleSymbol Lit40 = (SimpleSymbol) new SimpleSymbol("getName").readResolve();
    static final SimpleSymbol Lit39 = (SimpleSymbol) new SimpleSymbol(LispLanguage.quote_sym).readResolve();
    static final SimpleSymbol Lit38 = (SimpleSymbol) new SimpleSymbol("attr").readResolve();
    static final SimpleSymbol Lit37 = (SimpleSymbol) new SimpleSymbol("<gnu.kawa.xml.KAttr>").readResolve();
    static final SimpleSymbol Lit36 = (SimpleSymbol) new SimpleSymbol(GetNamedPart.INSTANCEOF_METHOD_NAME).readResolve();
    static final SimpleSymbol Lit35 = (SimpleSymbol) new SimpleSymbol("+").readResolve();
    static final SimpleSymbol Lit34 = (SimpleSymbol) new SimpleSymbol("loop").readResolve();
    static final SimpleSymbol Lit33 = (SimpleSymbol) new SimpleSymbol("<object>").readResolve();
    static final SimpleSymbol Lit32 = (SimpleSymbol) new SimpleSymbol("primitive-array-get").readResolve();
    static final SimpleSymbol Lit31 = (SimpleSymbol) new SimpleSymbol(LispLanguage.quasiquote_sym).readResolve();
    static final SimpleSymbol Lit30 = (SimpleSymbol) new SimpleSymbol("$lookup$").readResolve();
    static final SimpleSymbol Lit29 = (SimpleSymbol) new SimpleSymbol("arg").readResolve();
    static final SimpleSymbol Lit28 = (SimpleSymbol) new SimpleSymbol("num-args").readResolve();
    static final SimpleSymbol Lit27 = (SimpleSymbol) new SimpleSymbol("i").readResolve();
    static final SimpleSymbol Lit26 = (SimpleSymbol) new SimpleSymbol("<int>").readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol) new SimpleSymbol("::").readResolve();

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("run-application").readResolve();
        Lit23 = simpleSymbol;
        Lit24 = new SyntaxRules(new Object[]{simpleSymbol}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Lit30, Pair.make((SimpleSymbol) new SimpleSymbol("gnu.kawa.models.Window").readResolve(), Pair.make(Pair.make(Lit31, Pair.make((SimpleSymbol) new SimpleSymbol("open").readResolve(), LList.Empty)), LList.Empty)), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 749575)}, 0)}, 1);
        Lit22 = (SimpleSymbol) new SimpleSymbol("Window").readResolve();
        Lit21 = (SimpleSymbol) new SimpleSymbol("set-content").readResolve();
        Lit20 = (SimpleSymbol) new SimpleSymbol("Column").readResolve();
        Lit19 = (SimpleSymbol) new SimpleSymbol("Row").readResolve();
        Lit18 = (SimpleSymbol) new SimpleSymbol("Text").readResolve();
        Lit17 = (SimpleSymbol) new SimpleSymbol("Label").readResolve();
        Lit16 = (SimpleSymbol) new SimpleSymbol("image-height").readResolve();
        Lit15 = (SimpleSymbol) new SimpleSymbol("image-width").readResolve();
        Lit14 = (SimpleSymbol) new SimpleSymbol("image-read").readResolve();
        Lit13 = new SyntaxRules(new Object[]{(SimpleSymbol) new SimpleSymbol("text-field").readResolve()}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", new Object[0], 1), "\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0002", new Object[]{(SimpleSymbol) new SimpleSymbol("make").readResolve(), (SimpleSymbol) new SimpleSymbol("<gnu.kawa.models.DrawImage>").readResolve()}, 0)}, 1);
        Lit12 = (SimpleSymbol) new SimpleSymbol(Component.LISTVIEW_KEY_IMAGE).readResolve();
        Lit11 = (SimpleSymbol) new SimpleSymbol("Button").readResolve();
        Lit10 = (SimpleSymbol) new SimpleSymbol("button").readResolve();
        Lit9 = (SimpleSymbol) new SimpleSymbol("as-color").readResolve();
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("process-keywords").readResolve();
        Lit7 = simpleSymbol2;
        Lit8 = new SyntaxRules(new Object[]{simpleSymbol2}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", new Object[0], 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0091\b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\t\u000b\u0018,\b\u0011\u0018\u0004\u0011\u00184\u0011\u0018<\b\u0011\u0018D\u0011\u0018L\b\u0011\u0018\u0004a\b\u0011\u0018T\b\u0011\u0018\\\t\u000b\u0018d\b\u0011\u0018l©\u0011\u0018ty\t\u0013\t\u0003\u0011\u0018|\b\u0011\u0018\u0084\t\u000b\u0018\u008c\u0018\u0094\u0099\u0011\u0018\u009ci\u0011\u0018¤\u0011\u0018¬\b\t\u0013\t\u0003\u0018´\u0018¼\b\u0011\u0018Ä1\t\u001b\t\u0003\u0018Ì\u0018Ô", new Object[]{(SimpleSymbol) new SimpleSymbol("let").readResolve(), Lit28, Lit25, Lit26, (SimpleSymbol) new SimpleSymbol("field").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_LENGTH).readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 16426), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 16426), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 16425), Lit34, PairWithPosition.make(PairWithPosition.make(Lit27, PairWithPosition.make(Lit25, PairWithPosition.make(Lit26, PairWithPosition.make(IntNum.make(0), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 20509), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 20503), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 20500), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 20497), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 20496), (SimpleSymbol) new SimpleSymbol("if").readResolve(), PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<").readResolve(), PairWithPosition.make(Lit27, PairWithPosition.make(Lit28, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 24593), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 24591), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 24588), Lit29, PairWithPosition.make(Lit32, PairWithPosition.make(Lit33, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 28710), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 28689), PairWithPosition.make(Lit27, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 28725), (SimpleSymbol) new SimpleSymbol("cond").readResolve(), PairWithPosition.make(Lit36, PairWithPosition.make(Lit29, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<gnu.expr.Keyword>").readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 32797), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 32793), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 32782), PairWithPosition.make(PairWithPosition.make(Lit30, Pair.make((SimpleSymbol) new SimpleSymbol("gnu.expr.Keyword").readResolve(), Pair.make(Pair.make(Lit31, Pair.make(Lit40, LList.Empty)), LList.Empty)), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 40970), PairWithPosition.make(Lit29, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 40995), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 40969), PairWithPosition.make(Lit32, PairWithPosition.make(Lit33, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45087), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45066), PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45107), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45105), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45102), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 45102), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(IntNum.make(2), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49170), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49168), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49165), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49165), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49159), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 49159), PairWithPosition.make(Lit36, PairWithPosition.make(Lit29, PairWithPosition.make(Lit37, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 53270), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 53266), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 53255), (SimpleSymbol) new SimpleSymbol("let*").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit38, PairWithPosition.make(Lit25, PairWithPosition.make(Lit37, PairWithPosition.make(Lit29, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 57388), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 57367), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 57364), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 57358), PairWithPosition.make(PairWithPosition.make(Lit42, PairWithPosition.make(Lit25, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("<java.lang.String>").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(Lit38, PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make(Lit40, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61489), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61489), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61488), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61483), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61475), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61475), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61456), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61453), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61447), PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(Lit38, PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make((SimpleSymbol) new SimpleSymbol("getObjectValue").readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65564), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65564), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65563), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65558), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65550), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65550), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65543), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 65543), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 61447), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 57357), PairWithPosition.make(Lit42, PairWithPosition.make(Lit43, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 69666), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 69661), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73746), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73744), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73741), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73741), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73735), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 73735), (SimpleSymbol) new SimpleSymbol("else").readResolve(), PairWithPosition.make(Lit29, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 81951), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86034), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86032), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86029), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86029), "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86023), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 86023)}, 0)}, 4);
        Lit6 = (SimpleSymbol) new SimpleSymbol("<gnu.kawa.models.Column>").readResolve();
        Lit5 = (SimpleSymbol) new SimpleSymbol("<gnu.kawa.models.Row>").readResolve();
        Lit4 = (SimpleSymbol) new SimpleSymbol("*.getHeight").readResolve();
        Lit3 = (SimpleSymbol) new SimpleSymbol("*.getWidth").readResolve();
        Lit2 = (SimpleSymbol) new SimpleSymbol("cell-spacing").readResolve();
        Lit1 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit0 = Color.class;
        $instance = new gui();
        loc$$St$DtgetWidth = ThreadLocation.getInstance(Lit3, null);
        loc$$St$DtgetHeight = ThreadLocation.getInstance(Lit4, null);
        loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr = ThreadLocation.getInstance(Lit5, null);
        loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr = ThreadLocation.getInstance(Lit6, null);
        process$Mnkeywords = Macro.make(Lit7, Lit8, $instance);
        gui guiVar = $instance;
        as$Mncolor = new ModuleMethod(guiVar, 1, Lit9, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        button = new ModuleMethod(guiVar, 2, Lit10, -4096);
        Button = new ModuleMethod(guiVar, 3, Lit11, -4096);
        Image = Macro.make(Lit12, Lit13, $instance);
        image$Mnread = new ModuleMethod(guiVar, 4, Lit14, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        image$Mnwidth = new ModuleMethod(guiVar, 5, Lit15, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        image$Mnheight = new ModuleMethod(guiVar, 6, Lit16, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        Label = new ModuleMethod(guiVar, 7, Lit17, -4096);
        Text = new ModuleMethod(guiVar, 8, Lit18, -4096);
        Row = new ModuleMethod(guiVar, 9, Lit19, -4096);
        Column = new ModuleMethod(guiVar, 10, Lit20, -4096);
        set$Mncontent = new ModuleMethod(guiVar, 11, Lit21, 8194);
        Window = new ModuleMethod(guiVar, 12, Lit22, -4096);
        run$Mnapplication = Macro.make(Lit23, Lit24, $instance);
        $instance.run();
    }

    public gui() {
        ModuleInfo.register(this);
    }

    @Override // gnu.expr.ModuleBody
    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    public static Color asColor(Object value) {
        if (value instanceof Color) {
            return (Color) value;
        }
        if (value instanceof Integer) {
            try {
                return new Color(((Integer) value).intValue());
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Integer.intValue()", 1, value);
            }
        } else if (value instanceof IntNum) {
            return new Color(IntNum.intValue(value));
        } else {
            return (Color) SlotGet.staticField.apply2(Lit0, value.toString());
        }
    }

    @Override // gnu.expr.ModuleBody
    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 1:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 2:
            case 3:
            default:
                return super.match1(moduleMethod, obj, callContext);
            case 4:
                if (Path.coerceToPathOrNull(obj) != null) {
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return -786431;
            case 5:
                if (obj instanceof BufferedImage) {
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return -786431;
            case 6:
                if (obj instanceof BufferedImage) {
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return -786431;
        }
    }

    static Object buttonKeyword(Button button2, String name, Object value) {
        if (name == "foreground") {
            button2.setForeground(asColor(value));
            return Values.empty;
        } else if (name == "background") {
            button2.setBackground(asColor(value));
            return Values.empty;
        } else if (name == "action") {
            button2.setAction(value);
            return Values.empty;
        } else if (name == PropertyTypeConstants.PROPERTY_TYPE_TEXT) {
            button2.setText(value == null ? null : value.toString());
            return Values.empty;
        } else if (name == "disabled") {
            try {
                button2.setDisabled(value != Boolean.FALSE);
                return Values.empty;
            } catch (ClassCastException e) {
                throw new WrongType(e, "gnu.kawa.models.Button.setDisabled(boolean)", 2, value);
            }
        } else {
            return misc.error$V(Format.formatToString(0, "unknown button attribute ~s", name), new Object[0]);
        }
    }

    static Boolean buttonNonKeyword(Button button2, Object arg) {
        return Boolean.TRUE;
    }

    public static Button button(Object... args) {
        Button button2 = new Button();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                try {
                    buttonKeyword(button2, ((Keyword) arg).getName(), args[i + 1]);
                    i += 2;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                }
            } else if (arg instanceof KAttr) {
                try {
                    KAttr attr = (KAttr) arg;
                    String name = attr.getName();
                    Object value = attr.getObjectValue();
                    buttonKeyword(button2, name, value);
                    i++;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "attr", -2, arg);
                }
            } else {
                buttonNonKeyword(button2, arg);
                i++;
            }
        }
        return button2;
    }

    @Override // gnu.expr.ModuleBody
    public int matchN(ModuleMethod moduleMethod, Object[] objArr, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 3:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 4:
            case 5:
            case 6:
            case 11:
            default:
                return super.matchN(moduleMethod, objArr, callContext);
            case 7:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 8:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 9:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 10:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            case 12:
                callContext.values = objArr;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
        }
    }

    public static Button Button(Object... args) {
        Button button2 = new Button();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                try {
                    buttonKeyword(button2, ((Keyword) arg).getName(), args[i + 1]);
                    i += 2;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                }
            } else if (arg instanceof KAttr) {
                try {
                    KAttr attr = (KAttr) arg;
                    String name = attr.getName();
                    Object value = attr.getObjectValue();
                    buttonKeyword(button2, name, value);
                    i++;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "attr", -2, arg);
                }
            } else {
                buttonNonKeyword(button2, arg);
                i++;
            }
        }
        return button2;
    }

    public static BufferedImage imageRead(Path uri) {
        return ImageIO.read(uri.openInputStream());
    }

    public static int imageWidth(BufferedImage image) {
        try {
            return ((Number) Scheme.applyToArgs.apply2(loc$$St$DtgetWidth.get(), image)).intValue();
        } catch (UnboundLocationException e) {
            e.setLine("/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 74, 3);
            throw e;
        }
    }

    public static int imageHeight(BufferedImage image) {
        try {
            return ((Number) Scheme.applyToArgs.apply2(loc$$St$DtgetHeight.get(), image)).intValue();
        } catch (UnboundLocationException e) {
            e.setLine("/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 77, 3);
            throw e;
        }
    }

    @Override // gnu.expr.ModuleBody
    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        switch (moduleMethod.selector) {
            case 1:
                return asColor(obj);
            case 2:
            case 3:
            default:
                return super.apply1(moduleMethod, obj);
            case 4:
                try {
                    return imageRead(Path.valueOf(obj));
                } catch (ClassCastException e) {
                    throw new WrongType(e, "image-read", 1, obj);
                }
            case 5:
                try {
                    return Integer.valueOf(imageWidth((BufferedImage) obj));
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "image-width", 1, obj);
                }
            case 6:
                try {
                    return Integer.valueOf(imageHeight((BufferedImage) obj));
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "image-height", 1, obj);
                }
        }
    }

    static Object labelKeyword(Label instance, String name, Object value) {
        if (name == Lit1) {
            instance.setText(value == null ? null : value.toString());
            return Values.empty;
        }
        return misc.error$V(Format.formatToString(0, "unknown label attribute ~s", name), new Object[0]);
    }

    static void labelNonKeyword(Label instance, Object arg) {
        instance.setText(arg == null ? null : arg.toString());
    }

    public static Label Label(Object... args) {
        Label instance = new Label();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                try {
                    labelKeyword(instance, ((Keyword) arg).getName(), args[i + 1]);
                    i += 2;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                }
            } else if (arg instanceof KAttr) {
                try {
                    KAttr attr = (KAttr) arg;
                    String name = attr.getName();
                    Object value = attr.getObjectValue();
                    labelKeyword(instance, name, value);
                    i++;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "attr", -2, arg);
                }
            } else {
                labelNonKeyword(instance, arg);
                i++;
            }
        }
        return instance;
    }

    static Object textKeyword(Text instance, String name, Object value) {
        if (name == Lit1) {
            instance.setText(value == null ? null : value.toString());
            return Values.empty;
        }
        return misc.error$V(Format.formatToString(0, "unknown text attribute ~s", name), new Object[0]);
    }

    static void textNonKeyword(Text instance, Object arg) {
        instance.setText(arg == null ? null : arg.toString());
    }

    public static Text Text(Object... args) {
        Text instance = new Text();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                try {
                    textKeyword(instance, ((Keyword) arg).getName(), args[i + 1]);
                    i += 2;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                }
            } else if (arg instanceof KAttr) {
                try {
                    KAttr attr = (KAttr) arg;
                    String name = attr.getName();
                    Object value = attr.getObjectValue();
                    textKeyword(instance, name, value);
                    i++;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "attr", -2, arg);
                }
            } else {
                textNonKeyword(instance, arg);
                i++;
            }
        }
        return instance;
    }

    static Object boxKeyword(Box instance, String name, Object value) {
        if (name == Lit2) {
            instance.setCellSpacing(value);
            return Values.empty;
        }
        return misc.error$V(Format.formatToString(0, "unknown box attribute ~s", name), new Object[0]);
    }

    static Model asModel(Object arg) {
        return Display.getInstance().coerceToModel(arg);
    }

    static void boxNonKeyword(Box box, Object arg) {
        box.add(asModel(arg));
    }

    public static Object Row(Object... args) {
        try {
            Object instance = Invoke.make.apply1(loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr.get());
            int num$Mnargs = args.length;
            int i = 0;
            while (i < num$Mnargs) {
                Object arg = args[i];
                if (arg instanceof Keyword) {
                    try {
                        try {
                            boxKeyword((Box) instance, ((Keyword) arg).getName(), args[i + 1]);
                            i += 2;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "box-keyword", 0, instance);
                    }
                } else if (arg instanceof KAttr) {
                    try {
                        KAttr attr = (KAttr) arg;
                        String name = attr.getName();
                        Object value = attr.getObjectValue();
                        try {
                            boxKeyword((Box) instance, name, value);
                            i++;
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "box-keyword", 0, instance);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "attr", -2, arg);
                    }
                } else {
                    try {
                        boxNonKeyword((Box) instance, arg);
                        i++;
                    } catch (ClassCastException e5) {
                        throw new WrongType(e5, "box-non-keyword", 0, instance);
                    }
                }
            }
            return instance;
        } catch (UnboundLocationException e6) {
            e6.setLine("/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 146, 25);
            throw e6;
        }
    }

    public static Object Column(Object... args) {
        try {
            Object instance = Invoke.make.apply1(loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr.get());
            int num$Mnargs = args.length;
            int i = 0;
            while (i < num$Mnargs) {
                Object arg = args[i];
                if (arg instanceof Keyword) {
                    try {
                        try {
                            boxKeyword((Box) instance, ((Keyword) arg).getName(), args[i + 1]);
                            i += 2;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "box-keyword", 0, instance);
                    }
                } else if (arg instanceof KAttr) {
                    try {
                        KAttr attr = (KAttr) arg;
                        String name = attr.getName();
                        Object value = attr.getObjectValue();
                        try {
                            boxKeyword((Box) instance, name, value);
                            i++;
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "box-keyword", 0, instance);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "attr", -2, arg);
                    }
                } else {
                    try {
                        boxNonKeyword((Box) instance, arg);
                        i++;
                    } catch (ClassCastException e5) {
                        throw new WrongType(e5, "box-non-keyword", 0, instance);
                    }
                }
            }
            return instance;
        } catch (UnboundLocationException e6) {
            e6.setLine("/u2/home/jis/ai2-kawa/gnu/kawa/slib/gui.scm", 151, 25);
            throw e6;
        }
    }

    public static void setContent(Window window, Object pane) {
        window.setContent(pane);
    }

    @Override // gnu.expr.ModuleBody
    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        if (moduleMethod.selector == 11) {
            try {
                setContent((Window) obj, obj2);
                return Values.empty;
            } catch (ClassCastException e) {
                throw new WrongType(e, "set-content", 1, obj);
            }
        }
        return super.apply2(moduleMethod, obj, obj2);
    }

    @Override // gnu.expr.ModuleBody
    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        if (moduleMethod.selector == 11) {
            if (obj instanceof Window) {
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            return -786431;
        }
        return super.match2(moduleMethod, obj, obj2, callContext);
    }

    static Object windowKeyword(Window instance, String name, Object value) {
        if (name == "title") {
            instance.setTitle(value == null ? null : value.toString());
            return Values.empty;
        } else if (name == "content") {
            instance.setContent(value);
            return Values.empty;
        } else if (name == "menubar") {
            instance.setMenuBar(value);
            return Values.empty;
        } else {
            return misc.error$V(Format.formatToString(0, "unknown window attribute ~s", name), new Object[0]);
        }
    }

    static void windowNonKeyword(Window instance, Object arg) {
        instance.setContent(arg);
    }

    public static Window Window(Object... args) {
        Window instance = Display.getInstance().makeWindow();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                try {
                    windowKeyword(instance, ((Keyword) arg).getName(), args[i + 1]);
                    i += 2;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "gnu.expr.Keyword.getName()", 1, arg);
                }
            } else if (arg instanceof KAttr) {
                try {
                    KAttr attr = (KAttr) arg;
                    String name = attr.getName();
                    Object value = attr.getObjectValue();
                    windowKeyword(instance, name, value);
                    i++;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "attr", -2, arg);
                }
            } else {
                windowNonKeyword(instance, arg);
                i++;
            }
        }
        return instance;
    }

    @Override // gnu.expr.ModuleBody
    public Object applyN(ModuleMethod moduleMethod, Object[] objArr) {
        switch (moduleMethod.selector) {
            case 2:
                return button(objArr);
            case 3:
                return Button(objArr);
            case 4:
            case 5:
            case 6:
            case 11:
            default:
                return super.applyN(moduleMethod, objArr);
            case 7:
                return Label(objArr);
            case 8:
                return Text(objArr);
            case 9:
                return Row(objArr);
            case 10:
                return Column(objArr);
            case 12:
                return Window(objArr);
        }
    }
}
