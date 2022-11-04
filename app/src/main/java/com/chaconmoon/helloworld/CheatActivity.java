package com.chaconmoon.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.chaconmoon.geoquizz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOW = "com.chaconmoon.helloworld.answer_show";

    public static Intent newintent(Context packageContext,boolean answerIsTrue){
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }
    private void setAnswerShowResult(boolean isAnswerShow){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ANSWER_SHOW,true);
        setResult(RESULT_OK,intent);
    }
    public  static boolean wasAnswerShow(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOW,false);

    }
    private boolean nAnswerIsTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        nAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        TextView nAnswerTextView = findViewById(R.id.answer_text_view);
        Button nShowAnswerButton = findViewById(R.id.show_answer_button);
        nShowAnswerButton.setOnClickListener(v -> {
            if (nAnswerIsTrue) {
                nAnswerTextView.setText(R.string.true_button);
            } else {
                nAnswerTextView.setText(R.string.false_button);
            }
            setAnswerShowResult(true);
        });

    }
}