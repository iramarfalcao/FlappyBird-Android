package com.iramarjunior.flappybird;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.iramarjunior.engine.Game;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.container);

        game = new Game(this);
        container.addView(this.game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        game.gameStart();
        new Thread(game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.gamePause();
    }
}
