package com.example.ej03_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                resul.setText(resul.getText() + " + ");
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
                resul.setText(String.valueOf(calculate(resul.getText().toString())));
            }
        });


    }

    public int calculate(String operation) {
        int acum = -1;
        if (!operation.contains("+")) {
            return Integer.parseInt(operation);
        }
        else {
            if (Character.isDigit(operation.charAt(0))) {
                acum = 0;
                String[] cadenaNumeros = operation.split("\\+");
                int[] numbers = new int[cadenaNumeros.length];

                for (int i = 0; i < cadenaNumeros.length; i++) {
                    cadenaNumeros[i] = cadenaNumeros[i].trim();
                }

                for (int i = 0; i < cadenaNumeros.length; i++) {
                    numbers[i] = Integer.parseInt(cadenaNumeros[i]);
                }
                for (int num : numbers) {
                    acum += num;
                }

            }
            else {
                return -1;
            }
        }

        return acum;
    }
}