package com.example.ambar.mycalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

   private enum OPERATOR{
     Pluse, Substract,Devide,Multiply,Equal;

   };

    private String CurrentNumber;
    private String StringAtLeft="";
    private String  StringAtRight="";
    private OPERATOR CurrentOperator=null;
    private int CalculationReasult ;
    private String CalculationString;


    TextView CalculatingReasult ;
    TextView FinalReasult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrentNumber="";
        CalculationReasult=0;
        CalculationString="";

        CalculatingReasult=findViewById(R.id.CalculatingReasult);
        FinalReasult=findViewById(R.id.FinalReasult);

        findViewById(R.id.One).setOnClickListener(MainActivity.this);
        findViewById(R.id.Two).setOnClickListener(MainActivity.this);
        findViewById(R.id.Tree).setOnClickListener(MainActivity.this);
        findViewById(R.id.Four).setOnClickListener(MainActivity.this);
        findViewById(R.id.Five).setOnClickListener(MainActivity.this);
        findViewById(R.id.Six).setOnClickListener(MainActivity.this);
        findViewById(R.id.Seven).setOnClickListener(MainActivity.this);
        findViewById(R.id.Eight).setOnClickListener(MainActivity.this);
        findViewById(R.id.Nine).setOnClickListener(MainActivity.this);
        findViewById(R.id.Zero).setOnClickListener(MainActivity.this);
        findViewById(R.id.ClearAll).setOnClickListener(MainActivity.this);
        findViewById(R.id.Equal).setOnClickListener(MainActivity.this);
        findViewById(R.id.Minus).setOnClickListener(MainActivity.this);
        findViewById(R.id.Devide).setOnClickListener(MainActivity.this);
        findViewById(R.id.Plus).setOnClickListener(MainActivity.this);
        findViewById(R.id.Dual).setOnClickListener(MainActivity.this);





    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case   R.id.Zero:
                NumberTapped (0);
                break;

            case   R.id.One:
                NumberTapped (1);
                break;
            case   R.id.Two:
                NumberTapped (2);
                break;
            case   R.id.Tree:
                NumberTapped (3);
                break;
            case   R.id.Four:
                NumberTapped (4);
                break;
            case   R.id.Five:
                NumberTapped (5);
                break;
            case   R.id.Six:
                NumberTapped (6);
                break;
            case   R.id.Seven:
                NumberTapped (7);
                break;
            case   R.id.Eight:
                NumberTapped (8);
                break;
            case   R.id.Nine:
                NumberTapped (9);
                break;
            case   R.id.Plus:

                OperatorTapped( OPERATOR.Pluse);
                CalculationString+= "+";

                break;

            case   R.id.Minus:

                OperatorTapped( OPERATOR.Substract);
                CalculationString+= "-";
                break;
            case   R.id.Dual:

                OperatorTapped( OPERATOR.Multiply);
                CalculationString+= "*";

                break;
            case   R.id.Devide:

                OperatorTapped( OPERATOR.Devide);
                CalculationString+= "/";

                break;
            case   R.id.Equal:

                OperatorTapped(OPERATOR.Equal);

                break;

            case   R.id.ClearAll:
                ClearTapped( );

                break;


        }
        CalculatingReasult.setText(CalculationString);

    }

    private void NumberTapped (int Number){
        CurrentNumber= CurrentNumber + String.valueOf(Number);
        FinalReasult.setText(CurrentNumber);
        CalculationString= CurrentNumber;
        CalculatingReasult.setText( CalculationString);


    }
    private void OperatorTapped(OPERATOR tappedOperator) {

        if (CurrentOperator != null ) {

            if (!CurrentNumber.equals("")) {


                StringAtRight = CurrentNumber;


                CurrentNumber = "";

                switch (CurrentOperator) {


                    case Pluse:
                        CalculationReasult = Integer.parseInt(StringAtLeft) + Integer.parseInt(StringAtRight);
                        break;
                    case Devide:
                        CalculationReasult = Integer.parseInt(StringAtLeft) / Integer.parseInt(StringAtRight);
                        break;
                    case Multiply:
                        CalculationReasult = Integer.parseInt(StringAtLeft) * Integer.parseInt(StringAtRight);
                        break;
                    case Substract:
                        CalculationReasult = Integer.parseInt(StringAtLeft) - Integer.parseInt(StringAtRight);
                        break;
                }

                StringAtLeft = String.valueOf(CalculationReasult);
                FinalReasult.setText(StringAtLeft);
                CalculationString = StringAtLeft;

            }
        }
        else {

            StringAtLeft=CurrentNumber;
            CurrentNumber="";
            FinalReasult.setText(StringAtLeft);

        }
        CurrentOperator=tappedOperator;

    }

public void ClearTapped( ){
        CurrentNumber="";
        StringAtLeft="";
        StringAtRight="";
        CurrentOperator=null;
        CalculationReasult=0 ;
        CalculationString="";
     CalculatingReasult.setText("0");
     FinalReasult.setText("0");
}


   }
