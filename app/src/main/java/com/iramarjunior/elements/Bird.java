package com.iramarjunior.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.iramarjunior.graphic.Color;

public class Bird {

    private static final float X = 100;
    private static final float RAIO = 100;
    private static final Paint RED = Color.getBirdColor();
    private float height;

    public Bird() {
        this.height = 100;
    }

    public void drawOn(Canvas canvas) {

        canvas.drawCircle(X, height, RAIO, RED);
    }
}
