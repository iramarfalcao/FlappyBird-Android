package com.iramarjunior.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.iramarjunior.elements.Bird;
import com.iramarjunior.flappybird.R;

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private Bitmap background;

    public Game(Context context) {
        super(context);
        initElements();
        this.background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
    }

    private void initElements() {
        bird = new Bird();
    }

    @Override
    public void run() {

        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            bird.drawOn(canvas);
            bird.down();

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