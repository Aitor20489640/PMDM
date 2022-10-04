package com.example.practica02_thegameofpig;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int currentPlayer = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lblP1 = findViewById(R.id.txtViewLblP1);
        TextView lblP2 = findViewById(R.id.txtViewLblP2);
        TextView currentPointsP1 = findViewById(R.id.txtViewCurrentlP1);
        TextView currentPointsP2 = findViewById(R.id.txtViewCurrentlP2);
        TextView umbralP1 = findViewById(R.id.txtViewUmbralP1);
        TextView umbralP2 = findViewById(R.id.txtViewUmbralP2);
        TextView dice = findViewById(R.id.txtViewDice);
        TextView winner = findViewById(R.id.textViewResult);
        Button rollDice = findViewById(R.id.btnRoll);
        Button holdBtn = findViewById(R.id.btnHold);
        Button restart = findViewById(R.id.btnRestart);
        lblP1.setBackgroundColor(Color.parseColor("#380106"));

        //Listener para rollear el dado
        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int diceNumber = getRandomNumber();
                dice.setText(String.valueOf(diceNumber));
                //Si la partida ha terminado al clicar al roll se reinicia la partida
                if (Integer.parseInt(umbralP1.getText().toString()) >= 100 || Integer.parseInt(umbralP2.getText().toString()) >= 100) {
                    restart.performClick();
                }
                if (diceNumber == 1) {
                    if (currentPlayer == 1) {
                        currentPlayer = 2;
                        lblP1.setBackgroundColor(Color.parseColor("#000000"));
                        lblP2.setBackgroundColor(Color.parseColor("#380106"));
                        currentPointsP1.setText("0");
                    }
                    else {
                        currentPlayer = 1;
                        lblP2.setBackgroundColor(Color.parseColor("#000000"));
                        lblP1.setBackgroundColor(Color.parseColor("#380106"));
                        currentPointsP2.setText("0");
                    }
                }
                if (currentPlayer == 1 && diceNumber != 1){
                    currentPointsP1.setText(String.valueOf(diceNumber + Integer.parseInt(currentPointsP1.getText().toString())));
                }
                if (currentPlayer == 2 && diceNumber != 1){
                    currentPointsP2.setText(String.valueOf(diceNumber + Integer.parseInt(currentPointsP2.getText().toString())));
                }
            }
        });

        //Listener para guardar puntuacion
        holdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPlayer == 1) {
                    int hold = Integer.parseInt(currentPointsP1.getText().toString()) + Integer.parseInt(umbralP1.getText().toString());
                    umbralP1.setText(String.valueOf(hold));
                    currentPlayer = 2;
                    lblP1.setBackgroundColor(Color.parseColor("#000000"));
                    lblP2.setBackgroundColor(Color.parseColor("#380106"));
                    currentPointsP1.setText("0");
                }
                else {
                    int hold = Integer.parseInt(currentPointsP2.getText().toString()) + Integer.parseInt(umbralP2.getText().toString());
                    umbralP2.setText(String.valueOf(hold));
                    currentPlayer = 1;
                    lblP2.setBackgroundColor(Color.parseColor("#000000"));
                    lblP1.setBackgroundColor(Color.parseColor("#380106"));
                    currentPointsP2.setText("0");
                }
                if (Integer.parseInt(umbralP1.getText().toString()) >= 100) {
                    winner.setText(R.string.lbl_Result1);
                    winner.setVisibility(View.VISIBLE);
                }
                else if (Integer.parseInt(umbralP2.getText().toString()) >= 100) {
                    winner.setText(R.string.lbl_Result2);
                    winner.setVisibility(View.VISIBLE);
                }
            }
        });

        //Listener para reiniciar partida
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPointsP1.setText(R.string.current_P1);
                currentPointsP2.setText(R.string.current_P2);
                umbralP1.setText(R.string.umbral_P1);
                umbralP2.setText(R.string.umbral_P2);
                dice.setText(R.string.lbl_Dice_Result);
                lblP2.setBackgroundColor(Color.parseColor("#000000"));
                lblP1.setBackgroundColor(Color.parseColor("#380106"));
                currentPlayer = 1;
                winner.setVisibility(View.INVISIBLE);

            }
        });
    }



    public int getRandomNumber() {
        return 1 + (int)(Math.random() * ((6 - 1) + 1));
    }




}