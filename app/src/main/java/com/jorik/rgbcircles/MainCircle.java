package com.jorik.rgbcircles;

/**
 * Created by 111 on 10.08.2016.
 */
public class MainCircle extends SimpleCircle {
    public static final int MAIN_CIRCLE_RADIUS = 50;
    public static final int MAIN_SPEED = 30;

    public MainCircle(int x, int y) {
        super(x, y, MAIN_CIRCLE_RADIUS);
    }

    public void moveMainCircle(int x1, int y1) {
        //с постипенным замедлением
        int dx = (x - x1) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y - y1) * MAIN_SPEED / GameManager.getHeight();
        x -= dx;
        y -= dy;

        // постоянная скорость
//        if (x1>x)
//            x += MAIN_SPEED;
//        else
//            x-= MAIN_SPEED;
//
//        if (y1>y)
//            y += MAIN_SPEED;
//        else
//            y -= MAIN_SPEED;

    }
}
