package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.BaseUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

/* loaded from: classes.dex */
public class define_unit extends Syntax {
    public static final define_unit define_base_unit;
    public static final define_unit define_unit = new define_unit(false);
    boolean base;

    static {
        define_unit.setName("define-unit");
        define_base_unit = new define_unit(true);
        define_base_unit.setName("define-base-unit");
    }

    public define_unit(boolean base) {
        this.base = base;
    }

    @Override // kawa.lang.Syntax
    public boolean scanForDefinitions(Pair st, Vector forms, ScopeExp defs, Translator tr) {
        if (st.getCdr() instanceof Pair) {
            Pair p = (Pair) st.getCdr();
            Object q = p.getCar();
            if (q instanceof SimpleSymbol) {
                String name = q.toString();
                Symbol sym = Scheme.unitNamespace.getSymbol(name);
                Declaration decl = defs.getDefine(sym, 'w', tr);
                tr.push(decl);
                Translator.setLine(decl, p);
                decl.setFlag(16384L);
                if (defs instanceof ModuleExp) {
                    decl.setCanRead(true);
                }
                Unit unit = null;
                if (this.base && p.getCdr() == LList.Empty) {
                    unit = BaseUnit.make(name, (String) null);
                } else if (p.getCdr() instanceof Pair) {
                    Object v = ((Pair) p.getCdr()).getCar();
                    if (this.base && (v instanceof CharSequence)) {
                        unit = BaseUnit.make(name, v.toString());
                    } else if (!this.base && (v instanceof Quantity)) {
                        unit = Unit.make(name, (Quantity) v);
                    }
                }
                if (unit != null) {
                    decl.noteValue(new QuoteExp(unit));
                }
                forms.addElement(Translator.makePair(st, this, Translator.makePair(p, decl, p.getCdr())));
                return true;
            }
        }
        tr.error('e', "missing name in define-unit");
        return false;
    }

    @Override // kawa.lang.Syntax
    public Expression rewriteForm(Pair form, Translator tr) {
        Object obj = form.getCdr();
        if (obj instanceof Pair) {
            Pair p1 = (Pair) obj;
            if (p1.getCar() instanceof Declaration) {
                Declaration decl = (Declaration) p1.getCar();
                Symbol symbol = (Symbol) decl.getSymbol();
                String unit = symbol.getLocalPart();
                ClassType unitType = ClassType.make("gnu.math.Unit");
                decl.setType(unitType);
                Expression value = decl.getValue();
                if (!(value instanceof QuoteExp) || !(((QuoteExp) value).getValue() instanceof Unit)) {
                    if (this.base) {
                        String dimension = null;
                        if (p1.getCdr() != LList.Empty) {
                            dimension = ((Pair) p1.getCdr()).getCar().toString();
                        }
                        BaseUnit bunit = BaseUnit.make(unit, dimension);
                        value = new QuoteExp(bunit);
                    } else if (!(p1.getCdr() instanceof Pair)) {
                        return tr.syntaxError("missing value for define-unit");
                    } else {
                        Pair p2 = (Pair) p1.getCdr();
                        Expression value2 = tr.rewrite(p2.getCar());
                        if (value2 instanceof QuoteExp) {
                            Object quantity = ((QuoteExp) value2).getValue();
                            if (quantity instanceof Quantity) {
                                value = new QuoteExp(Unit.make(unit, (Quantity) quantity));
                            }
                        }
                        Expression[] args = {new QuoteExp(unit), value2};
                        value = Invoke.makeInvokeStatic(unitType, "make", args);
                    }
                }
                SetExp sexp = new SetExp(decl, value);
                sexp.setDefining(true);
                decl.noteValue(value);
                return sexp;
            }
        }
        return tr.syntaxError("invalid syntax for " + getName());
    }
}
