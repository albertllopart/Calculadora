package com.example.albertln.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String number = ""; //número actual ("model")
    private TextView number_view;

    private double operator_1 = 0;
    private boolean operator_1_check = false;
    private double operator_2 = 0;
    private boolean operator_2_check = false;

    private int sign = 292; //0=suma, 1=resta, 2=mult, 3=div

    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        number_view = findViewById(R.id.current_number);
        number_view.setText(number);
    }

    public void onClickDigit(View view){

        Button b = (Button)view;
        number += b.getText().toString().charAt(0);
        number_view.setText(number);

        if (operator_1_check == false){
            operator_1 = Double.valueOf(number);
        }
        else {
            operator_2_check = true;
            operator_2 = Double.valueOf(number);
        }
    }

    public void onClickOperator(View view){

        Button b = (Button)view;
        String symbol = b.getText().toString();

        if (operator_1_check == false){
            operator_1_check = true;
        }

        number = "";
        number_view.setText(number);

        if (symbol == "+"){
            sign = 0;
        }
        else if (symbol == "-"){
            sign = 1;
        }
        else if (symbol == "*"){
            sign = 2;
        }
        else if (symbol == "/"){
            sign = 3;
        }
    }

    public void onClickDot(View view){


    }

    public void onClickEquals(View view){

        if (operator_2_check = true)
        {
            result = operator_1 + operator_2;
            number = Double.toString(result);
            number_view.setText(number);
        }
    }

}
