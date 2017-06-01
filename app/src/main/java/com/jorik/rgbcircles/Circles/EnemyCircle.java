package com.jorik.rgbcircles.Circles;

import android.graphics.Color;

import com.jorik.rgbcircles.GameManager;

import java.util.Random;

/**
 * Created by 111 on 18.08.2016.
 */
public class EnemyCircle extends SimpleCircle {

    public static final int COLOR_ENEMY = Color.RED;
    public static final int COLOR_FOOD = Color.rgb(0, 200, 0);
    public static final int R = 10;
    public static final int RANDOM_SPEED = 10;
    private int dx, dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle(){
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = 10 + random.nextInt(100);
        EnemyCircle circle = new EnemyCircle(x, y, radius, dx, dy);
        circle.setColor(COLOR_ENEMY);
        return circle;
    }

    public void setEnemyColor(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(COLOR_FOOD);
        } else {
            setColor(COLOR_ENEMY);
        }
    }

    public boolean isSmallerThan(MainCircle mainCircle) {
        if (radius < mainCircle.radius){
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    public void checkBounds(){
        if (x>GameManager.getWidth() || x<0)
            dx = -dx;
        if (y>GameManager.getHeight() || y<0)
            dy = -dy;
    }
}
