package com.iramarjunior.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.iramarjunior.elements.Bird;

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;

    public Game(Context context) {
        super(context);
        initElements();
    }

    private void initElements() {
        bird = new Bird();
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            // Draws
            bird.drawOn(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void gameStart() {
        isRunning = true;
    }

    public void gamePause() {
        isRunning = false;
    }
}
