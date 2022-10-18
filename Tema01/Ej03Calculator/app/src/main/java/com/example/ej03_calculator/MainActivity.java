package com.example.ej03_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resul = findViewById(R.id.txtResul);
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnResul = findViewById(R.id.btnResul);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnMinus = findViewById(R.id.btnMinus);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(resul.getText() + "-");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(R.string.Resul);
            }
        });

        btnResul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resul.setText(calculate(resul.getText().toString()));
            }
        });


    }

    public String calculate(String operation) {
        int indice;

        if (operation.contains("+")) {
            indice = operation.indexOf("+");
            String oper1 = operation.substring(0, indice);
            String oper2 = operation.substring(indice + 1);

            return String.valueOf(Integer.parseInt(calculate(oper1)) + Integer.parseInt(calculate(oper2)));
        } else if (operation.contains("-")) {
            indice = operation.lastIndexOf('-');
            String oper1 = operation.substring(0, indice);
            String oper2 = operation.substring(indice+1);
            if (Integer.parseInt(calculate(oper1)) < Integer.parseInt(calculate(oper2))){
                return "-" + String.valueOf(Integer.parseInt(calculate(oper2)) - Integer.parseInt(calculate(oper1)));
            } else {
                return String.valueOf(Integer.parseInt(calculate(oper1)) - Integer.parseInt(calculate(oper2)));
            }
        } else {
            if (operation.isEmpty()) {
                return "0";
            } else {
                System.out.println(operation);
                return operation;
            }
        }
    }
}