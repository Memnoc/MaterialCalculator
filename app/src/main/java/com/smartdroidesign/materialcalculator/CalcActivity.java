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
        Button clearAllButton = (Button) findViewById(R.id.clearAllBtn);



        ImageButton equalButton = (ImageButton) findViewById(R.id.equalButton);
        ImageButton divideButton = (ImageButton)findViewById(R.id.divideButton);
        ImageButton multiplyButton = (ImageButton)findViewById(R.id.multiplyButton);
        ImageButton subtractButton = (ImageButton)findViewById(R.id.subtractButton);
        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);

        Button delButton = (Button)findViewById(R.id.delButton);
        resultsText = (TextView)findViewById(R.id.resultsText);
        processView = (TextView)findViewById(R.id.processView);



        resultsText.setText("");
        processView.setText("");


        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "1");


            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "2");

            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "3");

            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "4");

            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "5");

            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "6");

            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "7");

            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "8");

            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "9");

            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "0");

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
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber += "+");


            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + "-");


            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
                runningNUmber = processView.getText().toString();
                processView.setText(runningNUmber + ":");


            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearText();
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

