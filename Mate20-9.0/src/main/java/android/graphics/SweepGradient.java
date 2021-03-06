package android.graphics;

public class SweepGradient extends Shader {
    private static final int TYPE_COLORS_AND_POSITIONS = 1;
    private static final int TYPE_COLOR_START_AND_COLOR_END = 2;
    private int mColor0;
    private int mColor1;
    private int[] mColors;
    private float mCx;
    private float mCy;
    private float[] mPositions;
    private int mType;

    private static native long nativeCreate1(long j, float f, float f2, int[] iArr, float[] fArr);

    private static native long nativeCreate2(long j, float f, float f2, int i, int i2);

    public SweepGradient(float cx, float cy, int[] colors, float[] positions) {
        if (colors.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        } else if (positions == null || colors.length == positions.length) {
            this.mType = 1;
            this.mCx = cx;
            this.mCy = cy;
            this.mColors = (int[]) colors.clone();
            this.mPositions = positions != null ? (float[]) positions.clone() : null;
        } else {
            throw new IllegalArgumentException("color and position arrays must be of equal length");
        }
    }

    public SweepGradient(float cx, float cy, int color0, int color1) {
        this.mType = 2;
        this.mCx = cx;
        this.mCy = cy;
        this.mColor0 = color0;
        this.mColor1 = color1;
        this.mColors = null;
        this.mPositions = null;
    }

    /* access modifiers changed from: package-private */
    public long createNativeInstance(long nativeMatrix) {
        if (this.mType == 1) {
            return nativeCreate1(nativeMatrix, this.mCx, this.mCy, this.mColors, this.mPositions);
        }
        return nativeCreate2(nativeMatrix, this.mCx, this.mCy, this.mColor0, this.mColor1);
    }

    /* access modifiers changed from: protected */
    public Shader copy() {
        SweepGradient copy;
        if (this.mType == 1) {
            new SweepGradient(this.mCx, this.mCy, (int[]) this.mColors.clone(), this.mPositions != null ? (float[]) this.mPositions.clone() : null);
        } else {
            copy = new SweepGradient(this.mCx, this.mCy, this.mColor0, this.mColor1);
        }
        copyLocalMatrix(copy);
        return copy;
    }
}
