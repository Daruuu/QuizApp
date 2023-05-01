package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button buttonTrue;
    Button buttonFalse;
    TextView textViewOne;
    ImageButton imageButtonPrev;
    ImageButton imageButtonNext;
    private List<Question> questionList;
    private Set<Integer> saveQuestionsIndex;
    public Intent intentQuizFinish;

    //    private String answer;
    private int currentQuestionIndex = 0;

    private int correctAnswerCount = 0;

    //llamamos a este metodo cuando creamos una instancia de la clase activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillQuestionsWithData();
        saveQuestionsIndex = new HashSet<>();

        buttonTrue = findViewById(R.id.true_button);
        buttonFalse = findViewById(R.id.false_button);
        textViewOne = findViewById(R.id.textView01);
        imageButtonPrev = findViewById(R.id.prev_button);
        imageButtonNext = findViewById(R.id.next_button);

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
        String questionMark = " ?";
        questionList = new ArrayList<>();
        questionList.add(new Question("Is the sky blue" + questionMark, true));
        questionList.add(new Question("Is the sun red" + questionMark, false));
        questionList.add(new Question("Is the number of bicycle wheel 3" + questionMark, false));
        questionList.add(new Question("Is 1 + 1 = 3" + questionMark, false));
        questionList.add(new Question("La luna es un planeta" + questionMark, false));
        questionList.add(new Question("El sol gira alrededor de la Tierra" + questionMark, false));
        questionList.add(new Question("El río Amazonas es el más largo del mundo" + questionMark, true));
        questionList.add(new Question("Los elefantes pueden saltar" + questionMark, false));
        questionList.add(new Question("Los pingüinos pueden volar" + questionMark, false));
        questionList.add(new Question("El Monte Everest es la montanya más alta del mundo" + questionMark, true));
    }

    // quiero que las preguntas no siempre empiezen por el index del arraylist
    void updateQuestion() {
        Random random = new Random();
        int randomIndex;

        do {
            randomIndex = random.nextInt(questionList.size());
        } while (saveQuestionsIndex.contains(randomIndex));

        saveQuestionsIndex.add(randomIndex);
        currentQuestionIndex = randomIndex;

        Question myQuestion = questionList.get(currentQuestionIndex);
        String questionTitle = myQuestion.getTitleQuestion();
        textViewOne.setText(questionTitle);
/*
        if (saveQuestionsIndex.size() == questionList.size()) {
            saveQuestionsIndex.clear();
        }
*/
    }

    void checkQuestion(boolean userAnswer) {
        // creamos una nueva actividad

        //compruebo si la respuesta es correcta, comparando la respuesta real con la repsuesta del usuario
        if (questionList.get(currentQuestionIndex).getAnswer() == userAnswer) {
            showToastAtBottom(R.string.correct_toast);
            //si es correcta aumento el contador correcrtAnserCount
            correctAnswerCount++;
        } else {
            showToastAtBottom(R.string.incorrect_toast);
        }

        if (currentQuestionIndex == questionList.size()) {
/*
            String strPointsQuiz = "Has obtained a total points of " + correctAnswerCount + " points.";
            textViewOne.setText(strPointsQuiz);
*/
            correctAnswerCount = 0;
            currentQuestionIndex = 0;
        }
        updateQuestion();
    }

    void showToastAtBottom(int toastMessage) {
        Toast t;
        // horizontal y vertical
        t = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
//        t.setGravity(Gravity.TOP, 0, 0);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        t.show();
    }
}
/*
tengo mi aplicacion que trata de responder 10 preguntas y obtener un resultado de las preguntas correctas, ahora mo que me falta agregar es un nuveo LinearLayout para poner la puntiacion que he obtenido; dado este codigo como puedo realizarlo


 */