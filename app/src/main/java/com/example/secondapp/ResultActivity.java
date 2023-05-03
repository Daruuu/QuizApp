package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewFinishQuiz;
    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewFinishQuiz = findViewById(R.id.TextViewFinishQuiz);
        buttonRestart = findViewById(R.id.restart_game_button);
        buttonRestart.setOnClickListener(v -> {
            endActivity();
        });
        int scoreTotal = getIntent().getIntExtra("score", 0);

    }

    void endActivity() {
        finish();
    }
}