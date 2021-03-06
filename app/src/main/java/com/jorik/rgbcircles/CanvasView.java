package com.jorik.rgbcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.jorik.rgbcircles.Circles.SimpleCircle;

/**
 * Created by 111 on 10.08.2016.
 */
public class CanvasView extends View implements ICanvasView{
    private GameManager gameManager;
    private Canvas canvas;

    private Paint paint; //кисточка

    private static int width;
    private static int height;
    private Toast toast;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        gameManager = new GameManager(this, width, height);
        initPaint();
    }

    // определяем высоту и ширину экрана и заносим их в статические переменные
    private void initWidthAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;
    }

    // инициализация кисточки
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true); // Сглаживание
        paint.setStyle(Paint.Style.FILL); // Заливка
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public void redraw() {
        invalidate();
    }

    @Override
    public void showMessage(String text) {
        if (toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
//        if (event.getAction() == MotionEvent.ACTION_MOVE){ // не понятная проверка
            gameManager.onTouchEvent(x, y);
//        }
        invalidate();
        return true;
    }

}
