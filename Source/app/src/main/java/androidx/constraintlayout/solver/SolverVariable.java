package androidx.constraintlayout.solver;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public float computedValue;
    int definitionId;
    public int id;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;
    private static int uniqueSlackId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueUnrestrictedId = 1;
    private static int uniqueConstantId = 1;
    private static int uniqueId = 1;

    /* loaded from: classes2.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String prefix) {
        if (prefix != null) {
            return prefix + uniqueErrorId;
        }
        switch (type) {
            case UNRESTRICTED:
                StringBuilder append = new StringBuilder().append("U");
                int i = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i;
                return append.append(i).toString();
            case CONSTANT:
                StringBuilder append2 = new StringBuilder().append("C");
                int i2 = uniqueConstantId + 1;
                uniqueConstantId = i2;
                return append2.append(i2).toString();
            case SLACK:
                StringBuilder append3 = new StringBuilder().append("S");
                int i3 = uniqueSlackId + 1;
                uniqueSlackId = i3;
                return append3.append(i3).toString();
            case ERROR:
                StringBuilder append4 = new StringBuilder().append("e");
                int i4 = uniqueErrorId + 1;
                uniqueErrorId = i4;
                return append4.append(i4).toString();
            case UNKNOWN:
                StringBuilder append5 = new StringBuilder().append("V");
                int i5 = uniqueId + 1;
                uniqueId = i5;
                return append5.append(i5).toString();
            default:
                throw new AssertionError(type.name());
        }
    }

    public SolverVariable(String name, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mName = name;
        this.mType = type;
    }

    public SolverVariable(Type type, String prefix) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mType = type;
    }

    void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    String strengthsToString() {
        String representation = this + "[";
        boolean negative = INTERNAL_DEBUG;
        boolean empty = true;
        for (int j = 0; j < this.strengthVector.length; j++) {
            String representation2 = representation + this.strengthVector[j];
            if (this.strengthVector[j] > 0.0f) {
                negative = INTERNAL_DEBUG;
            } else if (this.strengthVector[j] < 0.0f) {
                negative = true;
            }
            if (this.strengthVector[j] != 0.0f) {
                empty = INTERNAL_DEBUG;
            }
            if (j < this.strengthVector.length - 1) {
                representation = representation2 + ", ";
            } else {
                representation = representation2 + "] ";
            }
        }
        if (negative) {
            representation = representation + " (-)";
        }
        if (empty) {
            return representation + " (*)";
        }
        return representation;
    }

    public final void addToRow(ArrayRow row) {
        for (int i = 0; i < this.mClientEquationsCount; i++) {
            if (this.mClientEquations[i] == row) {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = row;
        this.mClientEquationsCount++;
    }

    public final void removeFromRow(ArrayRow row) {
        int count = this.mClientEquationsCount;
        for (int i = 0; i < count; i++) {
            if (this.mClientEquations[i] == row) {
                for (int j = 0; j < (count - i) - 1; j++) {
                    this.mClientEquations[i + j] = this.mClientEquations[i + j + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public final void updateReferencesWithNewDefinition(ArrayRow definition) {
        int count = this.mClientEquationsCount;
        for (int i = 0; i < count; i++) {
            this.mClientEquations[i].variables.updateFromRow(this.mClientEquations[i], definition, INTERNAL_DEBUG);
        }
        this.mClientEquationsCount = 0;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setType(Type type, String prefix) {
        this.mType = type;
    }

    public String toString() {
        String result = "" + this.mName;
        return result;
    }
}
