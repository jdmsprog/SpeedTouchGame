package gnu.kawa.swingviews;

import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Display;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Paintable;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.mapping.Procedure;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.WeakHashMap;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/* loaded from: classes.dex */
public class SwingDisplay extends Display {
    static final SwingDisplay instance = new SwingDisplay();
    private static WeakHashMap documents = null;

    public static Display getInstance() {
        return instance;
    }

    @Override // gnu.kawa.models.Display
    public Window makeWindow() {
        SwingFrame window = new SwingFrame(null, null, null);
        window.display = this;
        return window;
    }

    @Override // gnu.kawa.models.Display
    public void addButton(Button model, Object where) {
        addView(new SwingButton(model), where);
    }

    @Override // gnu.kawa.models.Display
    public void addLabel(Label model, Object where) {
        addView(new SwingLabel(model), where);
    }

    @Override // gnu.kawa.models.Display
    public void addImage(DrawImage model, Object where) {
        addView(new JLabel(new ImageIcon(model.getImage())), where);
    }

    @Override // gnu.kawa.models.Display
    public void addText(Text model, Object where) {
        addView(new JTextField(getSwingDocument(model), model.getText(), 50), where);
    }

    static synchronized Document getSwingDocument(Text model) {
        Document document;
        synchronized (SwingDisplay.class) {
            if (documents == null) {
                documents = new WeakHashMap();
            }
            Object existing = documents.get(model);
            if (existing != null) {
                document = (Document) existing;
            } else {
                Document doc = new PlainDocument(new SwingContent(model.buffer));
                documents.put(model, doc);
                document = doc;
            }
        }
        return document;
    }

    @Override // gnu.kawa.models.Display
    public void addBox(Box model, Object where) {
        addView(new SwingBox(model, this), where);
    }

    @Override // gnu.kawa.models.Display
    public void addSpacer(Spacer model, Object where) {
        addView(new Box.Filler(model.getMinimumSize(), model.getPreferredSize(), model.getMaximumSize()), where);
    }

    @Override // gnu.kawa.models.Display
    public void addView(Object view, Object where) {
        ((Container) where).add((Component) view);
    }

    public static ActionListener makeActionListener(Object command) {
        return command instanceof ActionListener ? (ActionListener) command : new ProcActionListener((Procedure) command);
    }

    @Override // gnu.kawa.models.Display
    public Model coerceToModel(Object component) {
        if (component instanceof Component) {
            return new ComponentModel((Component) component);
        }
        if (component instanceof Paintable) {
            return new ComponentModel(new SwingPaintable((Paintable) component));
        }
        return super.coerceToModel(component);
    }
}
