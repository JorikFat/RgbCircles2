package com.jorik.rgbcircles.Circles;

/**
 * Created by 111 on 16.08.2016.
 */
public class SimpleCircle {
    protected int x;
    protected int y;
    protected int radius;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int color;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public SimpleCircle getCircleArea() {
        return new SimpleCircle(x, y, radius *3);
    }

    public boolean isIntersect(SimpleCircle c) {
        return radius + c.radius >= Math.sqrt(Math.pow(x-c.x,2)+Math.pow(y-c.y,2));
    }
}
