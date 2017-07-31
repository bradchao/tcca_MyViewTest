package tw.brad.android.games.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.GREEN);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);

        canvas.drawCircle(100,100,30,paint);

        canvas.drawLine(0,0,400,400,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            Log.i("brad", "UP");
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            Log.i("brad", "MOVE");
        }else if (event.getAction() == MotionEvent.ACTION_DOWN){
            Log.i("brad", "DOWN");
        }
        return true;
    }
}
