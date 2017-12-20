package com.smartdroidesign.materialcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultsText;
    TextView signView;

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNUmber = "";
    String runningSign = "";
    String runningDot = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentCalculus;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneButton = (Button)findViewById(R.id.oneButton);
        Button twoButton = (Button)findViewById(R.id.twoButton);
        Button threeButton = (Button)findViewById(R.id.threeButton);
        Button fourButton = (Button)findViewById(R.id.fourButton);
        Button fiveButton = (Button)findViewById(R.id.fiveButton);
        Button sixButton = (Button)findViewById(R.id.sixButton);
        Button sevenButton = (Button)findViewById(R.id.sevenButton);
        Button eightButton = (Button)findViewById(R.id.eightButton);
        Button nineButton = (Button)findViewById(R.id.nineButton);
        Button zeroButton = (Button)findViewById(R.id.zeroButton);
        Button dotButton = (Button) findViewById(R.id.dotButton);



        ImageButton equalButton = (ImageButton) findViewById(R.id.equalButton);
        ImageButton divideButton = (ImageButton)findViewById(R.id.divideButton);
        ImageButton multiplyButton = (ImageButton)findViewById(R.id.multiplyButton);
        ImageButton subtractButton = (ImageButton)findViewById(R.id.subtractButton);
        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);

        Button delButton = (Button)findViewById(R.id.delButton);
        resultsText = (TextView)findViewById(R.id.resultsText);
        signView = (TextView)findViewById(R.id.signView);


        resultsText.setText("");
        signView.setText("");

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);

            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);

            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);

            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);

            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);

            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);

            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);

            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);

            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);

            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed();

            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValue = "";
                rightValue = "";
                result = 0;
                runningNUmber = "";
                runningSign = "";
                currentCalculus = null;
                resultsText.setText("0");
                signView.setText("");


            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
                signPressed("+");

            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
                signPressed("-");

            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
                signPressed(":");

            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
                signPressed("x");

            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
                signView.setText("");
            }
        });



    }

    void processOperation(Operation calculus){
        if (currentCalculus != null){

            if (runningNUmber != "") {
                rightValue = runningNUmber;
                runningNUmber = "";

                switch (currentCalculus) {
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;

                }

                leftValue = String.valueOf(result);
                resultsText.setText(leftValue);
            }



        } else {

            leftValue = runningNUmber;
            runningNUmber = "";
            currentCalculus = calculus;
        }

        currentCalculus = calculus;




    }

    void numberPressed(int number){
        runningNUmber += String.valueOf(number);
        resultsText.setText(runningNUmber);

    }

    void numberPressed(){
        runningNUmber += String.valueOf(".");
        resultsText.setText(runningNUmber);

    }

    void signPressed(String sign){
        runningSign += String.valueOf(sign);
        signView.setText(runningSign);


    }




}
