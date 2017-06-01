package com.jorik.rgbcircles;

import com.jorik.rgbcircles.Circles.SimpleCircle;

/**
 * Created by 111 on 13.08.2016.
 */
public interface ICanvasView {
    void drawCircle (SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}
