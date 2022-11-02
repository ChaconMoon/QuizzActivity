package com.chaconmoon.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.chaconmoon.geoquizz.answer_is_true";
    public static Intent newintent(Context packageContext,boolean answerIsTrue){
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
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
        });

    }
}