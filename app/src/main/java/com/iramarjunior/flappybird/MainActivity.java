package com.iramarjunior.flappybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.iramarjunior.engine.Game;

public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.container);

        game = new Game(this);
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
