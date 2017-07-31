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

import java.util.HashMap;
import java.util.LinkedList;

public class MyView extends View {
    private LinkedList<LinkedList<HashMap<String,Float>>> lines;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.GREEN);

        lines = new LinkedList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);

        for (LinkedList<HashMap<String,Float>> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                canvas.drawLine(p0.get("x"), p0.get("y"),
                        p1.get("x"), p1.get("y"), paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX(), ey = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                LinkedList<HashMap<String,Float>> line =
                        new LinkedList<>();
                HashMap<String,Float> point = new HashMap<>();
                point.put("x", ex);
                point.put("y", ey);
                line.add(point);
                lines.add(line);
                break;
            case MotionEvent.ACTION_MOVE:
                HashMap<String,Float> point2 = new HashMap<>();
                point2.put("x", ex);
                point2.put("y", ey);
                lines.getLast().add(point2);
                invalidate();   // repaint
                break;
        }

        return true;
    }

    public void clear(){
        lines.clear();
        invalidate();
    }

    public void undo(){

    }
    public void redo(){

    }

}
