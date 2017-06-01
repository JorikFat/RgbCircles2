package com.jorik.rgbcircles;

import com.jorik.rgbcircles.Circles.EnemyCircle;
import com.jorik.rgbcircles.Circles.MainCircle;
import com.jorik.rgbcircles.Circles.SimpleCircle;

import java.util.ArrayList;

/**
 * Created by 111 on 12.08.2016.
 */
public class GameManager {
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;

    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h){
        this.canvasView = canvasView;
        width = w;
        height = h;

        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<EnemyCircle>();
        for (int i=0; i < 10; i++){
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            } while(circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetColor();
    }

    private void calculateAndSetColor() {
        for (EnemyCircle enemyCircle:circles){
            enemyCircle.setEnemyColor(mainCircle);
        }
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

        for (EnemyCircle circle: circles){
            canvasView.drawCircle(circle);
        }
        canvasView.drawCircle(mainCircle);
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircle(x, y);
        checkCollision();
        moveCircles();
    }

    private void checkCollision() {
        EnemyCircle circleForDell = null;
        for (EnemyCircle circle:circles) {
            if (mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThan(mainCircle)) {
                    mainCircle.growRadius(circle);
                    circleForDell = circle;
                    calculateAndSetColor();
                    break;
                } else {
                    gameEnd("YOU LOSE!");
                    return;
                }
            }
        }
        if (circleForDell != null){
            circles.remove(circleForDell);
        }
        if (circles.isEmpty()){
            gameEnd("YOU WIN!");
        }
    }

    private void gameEnd(String text) {
        canvasView.showMessage(text);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle:circles){
            circle.moveOneStep();
        }
    }
}
