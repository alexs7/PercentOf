package com.alexs7.percentof;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    private EditText percentageText;
    private EditText valueText;
    private PercentageCalculator percentageCalculator;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT < 19) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else{
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentageText = (EditText)findViewById(R.id.percentageField);
        percentageText.setOnKeyListener(this);

        valueText = (EditText)findViewById(R.id.valueField);
        valueText.setOnKeyListener(this);

        resultView = (TextView)findViewById(R.id.result);

        percentageCalculator = new PercentageCalculator();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(percentageText.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if(event.getAction() == KeyEvent.ACTION_UP) {

            String value = valueText.getText().toString();
            String percentage = percentageText.getText().toString();

            if ((!percentage.isEmpty()) && (!value.isEmpty())) {

                BigDecimal valueBD = new BigDecimal(value);
                BigDecimal percentageBD = new BigDecimal(percentage);

                resultView.setText(percentageCalculator.calculatePercentage(percentageBD, valueBD).toString());

            }

        }

        return false;
    }
}
