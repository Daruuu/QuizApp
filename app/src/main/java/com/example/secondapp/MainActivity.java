package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonTrue;
    Button buttonFalse;
    TextView textViewOne;
    List<Question> questionList;
    private String answer;
    private int currentQuestionIndex = 0;
    private final int totalPoints = -1;

    //llamamos a este metodo cuando creamos una instancia de la clase activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillQuestionsWithData();

        buttonTrue = findViewById(R.id.true_button);
        buttonFalse = findViewById(R.id.false_button);
        textViewOne = findViewById(R.id.textView01);

        buttonTrue.setBackgroundColor(Color.rgb(120, 194, 87));
        buttonTrue.setOnClickListener(v -> {
            checkQuestion(true);
        });
        buttonFalse.setBackgroundColor(Color.rgb(229, 9, 20));
        buttonFalse.setOnClickListener(v -> {
            checkQuestion(false);
        });
        updateQuestion();
    }

    void fillQuestionsWithData() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Is the sky blue", true));
        questionList.add(new Question("Is the sun red", false));
        questionList.add(new Question("Is the number of bicycle wheel 3?", false));
        questionList.add(new Question("Is 1 +1 = 3", false));
        questionList.add(new Question("La luna es un planeta", false));
        questionList.add(new Question("El sol gira alrededor de la Tierra", false));
        questionList.add(new Question("El río Amazonas es el río más largo del mundo", true));
        questionList.add(new Question("Los elefantes pueden saltar.", false));
        questionList.add(new Question("Los pingüinos pueden volar.", false));
        questionList.add(new Question("El Monte Everest es la montaña más alta del mundo", true));
    }

    void updateQuestion() {
        Question myQuestion = questionList.get(currentQuestionIndex);
        String questionTitle = myQuestion.getTitleQuestion();
        textViewOne.setText(questionTitle);
    }

    void checkQuestion(boolean userAnswer) {
        if (questionList.get(currentQuestionIndex).isAnswer() == userAnswer) {
            showToastAtTop(R.string.correct_toast);
        } else {
            showToastAtTop(R.string.incorrect_toast);
        }
        currentQuestionIndex++;
        if (currentQuestionIndex == questionList.size()) {
            currentQuestionIndex = 0;
        }
        updateQuestion();
    }

    void showToastAtTop(int toastMessage) {
        Toast t;
        // horizontal y vertical
        t = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
//        t.setGravity(Gravity.TOP, 0, 0);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        t.show();
    }
}