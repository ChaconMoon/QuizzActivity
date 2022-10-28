package com.chaconmoon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class QuizzActivity extends AppCompatActivity {

    private Button nTrueButton;
    private Button nFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        nTrueButton= (Button) findViewById(R.id.true_button);
        nFalseButton= (Button) findViewById(R.id.false_button);
    }
}