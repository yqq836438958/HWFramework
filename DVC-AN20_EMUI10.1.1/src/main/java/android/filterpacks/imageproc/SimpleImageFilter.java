package android.filterpacks.imageproc;

import android.app.slice.SliceItem;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.Program;
import android.filterfw.format.ImageFormat;

public abstract class SimpleImageFilter extends Filter {
    protected int mCurrentTarget = 0;
    protected String mParameterName;
    protected Program mProgram;

    /* access modifiers changed from: protected */
    public abstract Program getNativeProgram(FilterContext filterContext);

    /* access modifiers changed from: protected */
    public abstract Program getShaderProgram(FilterContext filterContext);

    public SimpleImageFilter(String name, String parameterName) {
        super(name);
        this.mParameterName = parameterName;
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        if (this.mParameterName != null) {
            try {
                addProgramPort(this.mParameterName, this.mParameterName, SimpleImageFilter.class.getDeclaredField("mProgram"), Float.TYPE, false);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException("Internal Error: mProgram field not found!");
            }
        }
        addMaskedInputPort(SliceItem.FORMAT_IMAGE, ImageFormat.create(3));
        addOutputBasedOnInput(SliceItem.FORMAT_IMAGE, SliceItem.FORMAT_IMAGE);
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String portName, FrameFormat inputFormat) {
        return inputFormat;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext context) {
        Frame input = pullInput(SliceItem.FORMAT_IMAGE);
        FrameFormat inputFormat = input.getFormat();
        Frame output = context.getFrameManager().newFrame(inputFormat);
        updateProgramWithTarget(inputFormat.getTarget(), context);
        this.mProgram.process(input, output);
        pushOutput(SliceItem.FORMAT_IMAGE, output);
        output.release();
    }

    /* access modifiers changed from: protected */
    public void updateProgramWithTarget(int target, FilterContext context) {
        if (target != this.mCurrentTarget) {
            if (target == 2) {
                this.mProgram = getNativeProgram(context);
            } else if (target != 3) {
                this.mProgram = null;
            } else {
                this.mProgram = getShaderProgram(context);
            }
            Program program = this.mProgram;
            if (program != null) {
                initProgramInputs(program, context);
                this.mCurrentTarget = target;
                return;
            }
            throw new RuntimeException("Could not create a program for image filter " + this + "!");
        }
    }
}
