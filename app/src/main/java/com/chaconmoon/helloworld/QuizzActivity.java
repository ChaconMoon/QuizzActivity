package com.chaconmoon.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class QuizzActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "index";

    private static final String TAG = "QuizActivity";

    private TextView nQuestionTextView;
    ArrayList<Question> qList = new ArrayList<>();
    ArrayList<Boolean> answers = new ArrayList<Boolean>();
    private int nCurrentIndex =0;
    private int answeredQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"OnCreate(Bundle) called");
        setContentView(R.layout.quizz_activity);
        createQuestions();
        Button nTrueButton = (Button) findViewById(R.id.true_button);

    if (savedInstanceState !=null){
        nCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
    }

       nTrueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (answers.get(nCurrentIndex)==null) {
                    chackAnswer(true);
                } else {
                    ButtonNotWork();
                }
                nCurrentIndex = (nCurrentIndex + 1) % qList.get(nCurrentIndex).getTextRedId();
                updateQuestion();
                CountAns();
            }
        });
        Button nFalseButton = (Button) findViewById(R.id.false_button);

        nFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answers.get(nCurrentIndex)==null) {
                    chackAnswer(false);
                    nCurrentIndex = (nCurrentIndex + 1) % qList.get(nCurrentIndex).getTextRedId();
                    updateQuestion();
                    CountAns();
                } else {
                    ButtonNotWork();
                }
                nCurrentIndex = (nCurrentIndex + 1) % qList.get(nCurrentIndex).getTextRedId();
                updateQuestion();
                CountAns();
            }
        });
        ImageButton nNextButton = (ImageButton) findViewById(R.id.next_button);
        nNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nCurrentIndex = (nCurrentIndex +1)%qList.get(nCurrentIndex).getTextRedId();
                updateQuestion();
            }
        });

        ImageButton nPrevButton = (ImageButton) findViewById(R.id.prev_button);
        nPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nCurrentIndex = (nCurrentIndex -1)%qList.get(nCurrentIndex).getTextRedId();
                updateQuestion();
            }
        });
        nQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        nQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nCurrentIndex = (nCurrentIndex +1)%qList.get(nCurrentIndex).getTextRedId();
                updateQuestion();
            }
        });
        StartQuizz();
    }

    private void ButtonNotWork() {
        Toast.makeText(this,R.string.answered_question,Toast.LENGTH_SHORT).show();


    }

    private void CountAns() {
        if(answeredQuestions==answers.size()){
            int correct = 0, incorrect = 0;
            double pCorrects;
            String toast = "";
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i)==true){
                    correct++;
                } else {
                    incorrect++;
                }
            }
            double totalQuestion = answers.size();
            pCorrects= correct/totalQuestion*100;
            String score = getString(R.string.score);
            toast=correct+"/"+answers.size()+"\n"+ score +" "+ (int) pCorrects+"%";
            Toast.makeText(this,toast,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
     super.onStart();
     Log.d(TAG, "onStart() called");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstantState() called");
        savedInstanceState.putInt(KEY_INDEX,nCurrentIndex);
    }

    private void StartQuizz() {
        updateQuestion();
    }
    private void updateQuestion(){
        if (nCurrentIndex==qList.size())
            nCurrentIndex=0;
        int question = qList.get(nCurrentIndex).getTextRedId();
        nQuestionTextView.setText(question);
    }
    private void chackAnswer(boolean userPressedTrue){
        boolean answerIsTrue = qList.get(nCurrentIndex).isAnswerTrue();

        int messageResId = 0;

        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
            answers.set(nCurrentIndex,true);
        } else {
            messageResId = R.string.incorrct_toast;
            answers.set(nCurrentIndex,false);
        }
        answeredQuestions++;
        Toast.makeText(this,messageResId, Toast.LENGTH_SHORT).show();
    }
    private void createQuestions(){
        qList.add(new Question(R.string.question_australia,true));
        qList.add(new Question(R.string.question_oceans, true));
        qList.add(new Question(R.string.question_mideast,false));
        qList.add(new Question(R.string.question_africo,false));
        qList.add(new Question(R.string.question_americas,true));
        qList.add(new Question(R.string.question_asia,true));
        qList.add(new Question(R.string.question_montains,true));
        for (int i = 0; i < qList.size(); i++) {
            answers.add(null);
        }
    }
}