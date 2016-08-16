package com.jorik.rgbcircles;

/**
 * Created by 111 on 12.08.2016.
 */
public class GameManager {
    private MainCircle mainCircle;

    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h){
        this.canvasView = canvasView;
        width = w;
        height = h;

        initMainCircle();
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width/2, height/2);
    }

    void onDraw(){
        canvasView.drawCircle(mainCircle);

    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircle(x, y);
    }
}
