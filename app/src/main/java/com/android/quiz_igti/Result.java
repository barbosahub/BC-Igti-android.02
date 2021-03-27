package com.android.quiz_igti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Quiz);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResult = (TextView) findViewById(R.id.txtResult);

        Intent i = getIntent();
        String mScore = String.valueOf(i.getIntExtra(MainActivity.RESULT, 0));
        String mLength = String.valueOf(i.getIntExtra(MainActivity.LENGTH, 0));

        double s = Double.parseDouble(mScore);
        double l = Double.parseDouble(mLength);

        result(s,l);
    }

    public void result(double s, double l){

        double x = (s / l) * 100;

        mResult.setText("Acertou: "+String.valueOf(x) + "%");
    }

    public void ViewResult(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }


}