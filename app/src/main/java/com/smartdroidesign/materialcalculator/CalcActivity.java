package com.smartdroidesign.materialcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CalcActivity extends Activity {

    TextView resultsText;
    TextView processView;




    String runningNUmber = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneButton = findViewById(R.id.oneButton);
        Button twoButton = findViewById(R.id.twoButton);
        Button threeButton = findViewById(R.id.threeButton);
        Button fourButton = findViewById(R.id.fourButton);
        Button fiveButton = findViewById(R.id.fiveButton);
        Button sixButton = findViewById(R.id.sixButton);
        Button sevenButton = findViewById(R.id.sevenButton);
        Button eightButton = findViewById(R.id.eightButton);
        Button nineButton = findViewById(R.id.nineButton);
        Button zeroButton = findViewById(R.id.zeroButton);
        Button clearAllButton = findViewById(R.id.clearAllBtn);



        ImageButton equalButton = findViewById(R.id.equalButton);
        ImageButton divideButton = findViewById(R.id.divideButton);
        ImageButton multiplyButton = findViewById(R.id.multiplyButton);
        ImageButton subtractButton = findViewById(R.id.subtractButton);
        ImageButton addButton = findViewById(R.id.addButton);

        Button delButton = findViewById(R.id.delButton);
        resultsText = findViewById(R.id.resultsText);
        processView = findViewById(R.id.processView);



        resultsText.setText("");
        processView.setText("");


        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s1", runningNUmber));


            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s2", runningNUmber));

            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s3", runningNUmber));

            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s4", runningNUmber));

            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s5", runningNUmber));

            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s6", runningNUmber));

            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s7", runningNUmber));

            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s8", runningNUmber));

            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s9", runningNUmber));

            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(String.format("%s0", runningNUmber));

            }
        });

        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processView.setText("");
                resultsText.setText("");



            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                if (runningNUmber.length() > 0){
                    runningNUmber = runningNUmber.substring(0, runningNUmber.length()-1);
                    processView.setText(runningNUmber);


                } else {
                    resultsText.setText("");
                }



            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber += "+");


            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "-");


            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + ":");


            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "x");


            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runningNUmber = processView.getText().toString();
                runningNUmber = runningNUmber.replaceAll("x", "*");
                runningNUmber = runningNUmber.replaceAll(":", "/");



                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";

                try{
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, runningNUmber, "JavaScript", 1, null).toString();
                }catch (Exception e){
                    result = "Error";
                }
                result = result.replaceAll("[.0]*$", "");
                resultsText.setText(result);



            }
        });



    }

}

