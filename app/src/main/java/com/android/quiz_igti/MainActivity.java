package com.android.quiz_igti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    public final static String RESULT = "com.android.quiz_igti.RESULT";
    public final static String LENGTH = "com.android.quiz_igti.LENGTH";

    private TextView mQuestion;
    private RadioGroup mRadioGroup;
    private RadioButton mChoiceTrue;
    private RadioButton mChoiceFalse;
    private TextView mQuestionView;

    private String mAnswer;
    private int mScore;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Quiz);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group_1);
        mChoiceTrue = (RadioButton) findViewById(R.id.choicetrue);
        mChoiceFalse = (RadioButton) findViewById(R.id.choicefalse);
        mQuestionView = (TextView)  findViewById(R.id.question);
        mQuestion = (TextView) findViewById(R.id.txtResult);
        


        updateQuestion();

        mChoiceTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChoiceTrue.getText() == mAnswer){

                    mScore = mScore + 1;

                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            updateQuestion();
                        }
                    },1000);
                }else{
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            updateQuestion();
                        }
                    },1000);
                }
            }
        });
        mChoiceFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChoiceFalse.getText() == mAnswer){
                    mScore = mScore + 1;

                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            updateQuestion();
                        }
                    },1000);
                }else{
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            updateQuestion();
                        }
                    },1000);
                }
            }
        });

    }

    private void updateQuestion(){

        if (mQuestionLibrary.mQuestions.length == mQuestionNumber){
            redirectActivity();
        }else{
            mRadioGroup.clearCheck();
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));

            mChoiceTrue.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mChoiceFalse.setText(mQuestionLibrary.getChoice2(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;

            mQuestion.setText("Questão - " + mQuestionNumber);
        }
    }


    private void redirectActivity(){
        Intent i = new Intent(this,Result.class);
            i.putExtra(RESULT,mScore);
            i.putExtra(LENGTH,mQuestionLibrary.mQuestions.length);
        startActivity(i);
        finish();
    }

}