package isaac.app;

import static android.provider.Settings.System.getString;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    List<Paint> mPaintList;
    List<Path> mPathList;

    Paint mCurrentPaint;
    Path mCurrentPath;
    ColorDrawable mCurrentColor;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintList = new ArrayList<Paint>();
        mPathList = new ArrayList<Path>();
        mCurrentColor = new ColorDrawable();
        mCurrentColor.setColor(Color.BLACK);
        initLayerDraw();
    }

    public void setColor(Color color) {
        mCurrentColor.setColor(color.toArgb());
        mCurrentPaint.setColor(color.toArgb());
    }

    public void initLayerDraw(){
        mCurrentPaint = new Paint();
        mCurrentPath = new Path();

        mCurrentPaint.setStyle(Paint.Style.STROKE);
        mCurrentPaint.setStrokeWidth(20);
        mCurrentPaint.setColor(mCurrentColor.getColor());

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i < mPaintList.size(); i++){
            canvas.drawPath(mPathList.get(i), mPaintList.get(i));
        }
        canvas.drawPath(mCurrentPath, mCurrentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x, y;
        x = event.getX();
        y = event.getY();
        switch(event.getAction()){
            case(MotionEvent.ACTION_DOWN):
                mCurrentPath.moveTo(x,y);
                mCurrentPath.lineTo(x,y);
                break;
            case(MotionEvent.ACTION_MOVE):
                mCurrentPath.lineTo(x,y);
                break;
            case(MotionEvent.ACTION_UP):
                mCurrentPath.lineTo(x,y);
                mPaintList.add(mCurrentPaint);
                mPathList.add(mCurrentPath);
                initLayerDraw();
                break;
            default:
                break;
        }
        invalidate(); // ----> tem que colocar para o android entender que vai rodar o metodo onDraw
        return true;
    }
}
