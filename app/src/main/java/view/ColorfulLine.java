package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gxg.administrator.mydemo7.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvliheng on 2017/8/22 at 13:43.
 */

public class ColorfulLine extends View {
    List<Integer> colors = new ArrayList<>();
    List<Integer> colorSizes = new ArrayList<>();
    private int direction = 1;
    private Paint paint;
    private Context mContext;

    public ColorfulLine(Context context) {
        super(context);
        mContext = context;
        init(null);
    }

    public ColorfulLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public ColorfulLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }


    public void init(AttributeSet attrs) {

        paint = new Paint();
        if (attrs != null) {
            TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.ColorfulLine);
            String colorString = array.getString(R.styleable.ColorfulLine_colors);
            String[] split = colorString.split(",");
            for (int i = 0; i < split.length; i++) {
                colors.add(Color.parseColor(split[i]));
            }
            int colorSizeUnit = array.getInt(R.styleable.ColorfulLine_colorSizeUnit, 1);
            String colorSizesString = array.getString(R.styleable.ColorfulLine_colorSizes);
            String[] strings = colorSizesString.split(",");
            for (int i = 0; i < strings.length; i++) {
                colorSizes.add(dip2px(mContext, Float.valueOf(strings[i])));
            }

            direction = array.getInt(R.styleable.ColorfulLine_direction, 1);
            array.recycle();

        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int drawnSize = 0;
        switch (direction) {
            case 1:
                if (drawnSize < width) {
                    for (int i = 0; i < colors.size(); i++) {
                        paint.setColor(colors.get(i));
                        canvas.drawRect(Float.valueOf(drawnSize), 0f, Float.valueOf(drawnSize + colorSizes.get(i)), Float.valueOf(height), paint);
                        drawnSize += colorSizes.get(i);
                    }
                }
                break;
            case 2:
                if (drawnSize < height) {
                    for (int i = 0; i < colors.size(); i++) {
                        paint.setColor(colors.get(i));
                        canvas.drawRect(0f, Float.valueOf(drawnSize), Float.valueOf(width), Float.valueOf(drawnSize + colorSizes.get(i)), paint);
                        drawnSize += colorSizes.get(i);
                    }
                }
                break;
        }
    }

    private int width;
    private int height;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
