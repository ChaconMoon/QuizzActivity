package com.chaconmoon.helloworld;

public class Question {
    private int mTextRedId;
    private boolean mAnswerTrue;

    public Question(int TextRedId, boolean AnswerTrue) {
        mTextRedId=TextRedId;
        mAnswerTrue=AnswerTrue;
    }

    public int getTextRedId() {
        return mTextRedId;
    }

    public void setTextRedId(int textRedId) {
        mTextRedId = textRedId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }
}
