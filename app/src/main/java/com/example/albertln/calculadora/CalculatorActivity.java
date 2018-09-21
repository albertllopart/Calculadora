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

    private boolean multi_operation = false;

    private int sign = 0; //0=suma, 1=resta, 2=mult, 3=div

    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        number_view = findViewById(R.id.current_number);
        number_view.setText(number);
    }

    public void onClickDigit(View view){

        if (multi_operation == true)
        {
            number = "";
            number_view.setText(number);
            multi_operation = false;
        }
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

        if (operator_1_check == false){
            operator_1_check = true;
        }

        if (operator_2_check == true)
        {
            if (sign == 0)
            {
                result = operator_1 + operator_2;
            }
            else if (sign == 1)
            {
                result = operator_1 - operator_2;
            }
            else if (sign == 2)
            {
                result = operator_1 * operator_2;
            }
            else if (sign == 3)
            {
                result = operator_1 / operator_2;
            }

            operator_1 = result;
            operator_2_check = false;
            number = Double.toString(result);
            number_view.setText(number);
            multi_operation = true;
        }

        if (b.getId() == R.id.btn_plus){
            sign = 0;
        }
        else if (b.getId() == R.id.btn_minus){
            sign = 1;
        }
        else if (b.getId() == R.id.btn_product){
            sign = 2;
        }
        else if (b.getId() == R.id.btn_division){
            sign = 3;
        }

        number = "";
        number_view.setText(number);
    }

    public void onClickDot(View view){

        Button b = (Button)view;
        number += b.getText().toString().charAt(0);
        number_view.setText(number);
    }

    public void onClickEquals(View view){

        if (operator_2_check = true)
        {
            if (sign == 0)
            {
                result = operator_1 + operator_2;
            }
            else if (sign == 1)
            {
                result = operator_1 - operator_2;
            }
            else if (sign == 2)
            {
                result = operator_1 * operator_2;
            }
            else if (sign == 3)
            {
                result = operator_1 / operator_2;
            }

            operator_1 = result;
            operator_2_check = false;
            number = Double.toString(result);
            number_view.setText(number);
        }
    }

    public void onClickClear(View view){

        operator_1 = 0;
        operator_1_check = false;
        operator_2 = 0;
        operator_2_check = false;

        number = "";
        number_view.setText(number);
    }

}
