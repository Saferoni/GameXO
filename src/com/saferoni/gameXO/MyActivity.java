package com.saferoni.gameXO;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "myLogs"; // создал лог

    protected char[][] arrayXO = new char[3][3]; //обявил о двумерном масиве

    // обявляю посстоянные  и простые значения
    final char MOVEX = 'X';
    final char MOVEO = 'O';
    final char CLER = '.';
    char tempPC;
    private char thisChois;


    // обявляю кнопки
    TextView menu;
    Button button11, button12, button13, button21, button22, button23, button31, button32, button33;
    Button buttonX, buttonO, buttonPC;

    private char changeMove(char currentMove) {  //обработчик смены Х и О
        char result;
        if (currentMove == MOVEX) {
            result = MOVEO;
        } else {
            result = MOVEX;
        }
        return result;
    }

    private void startGame() {
        button11.setText(Character.toString(CLER));
        button12.setText(Character.toString(CLER));
        button13.setText(Character.toString(CLER));
        button21.setText(Character.toString(CLER));
        button22.setText(Character.toString(CLER));
        button23.setText(Character.toString(CLER));
        button31.setText(Character.toString(CLER));
        button32.setText(Character.toString(CLER));
        button33.setText(Character.toString(CLER));

        button11.setEnabled(true);
        button12.setEnabled(true);
        button13.setEnabled(true);
        button21.setEnabled(true);
        button22.setEnabled(true);
        button23.setEnabled(true);
        button31.setEnabled(true);
        button32.setEnabled(true);
        button33.setEnabled(true);
        buttonPC.setEnabled(true);


        tempPC = 0;
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arrayXO[i][j] = CLER;
            }
        }
    }

    @Override // инициализирую кнопки
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, "находим элементы View");
        menu = (TextView) findViewById(R.id.menu);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button21 = (Button) findViewById(R.id.button21);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button31 = (Button) findViewById(R.id.button31);
        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);
        buttonX = (Button) findViewById(R.id.buttonX);
        buttonO = (Button) findViewById(R.id.buttonO);
        buttonPC = (Button) findViewById(R.id.buttonPC);
// присваиваю обработчик кнопкам ждет нажатия
        Log.d(TAG, "присваиваем обработчик кнопкам");
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);
        buttonPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.setText("Выбран режим игры с Андроидом");
                if (MOVEX == thisChois) {
                    tempPC = MOVEO;
                } else {
                    tempPC = MOVEX;
                }
                buttonPC.setEnabled(false);
            }
        });
        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "нажатие кнопки X");
                thisChois = MOVEX;
                menu.setText("Начинает " + Character.toString(thisChois));
                startGame();
            }
        });
        buttonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "нажатие кнопки O");
                thisChois = MOVEO;
                menu.setText("Начинает " + Character.toString(thisChois));
                startGame();
            }
        });
    }

    private void pC() {
        if ((CLER == arrayXO[1][1])) {
            onClick(button22);
            return;
        }//всегда занимать центр если свободен
        if ((arrayXO[0][0] == CLER) && (((arrayXO[0][1] == arrayXO[0][2]) && (arrayXO[0][1] != CLER)) || ((arrayXO[1][0] == arrayXO[2][0])
                && (arrayXO[1][0] != CLER)) || (arrayXO[1][1] == arrayXO[2][2]))) {
            onClick(button11);
            return;
        } // для кнопки 11
        if ((arrayXO[0][2] == CLER) && (((arrayXO[0][0] == arrayXO[0][1]) && (arrayXO[0][0] != CLER)) || ((arrayXO[1][2] == arrayXO[2][2])
                && (arrayXO[1][2] != CLER)) || (arrayXO[1][1] == arrayXO[2][0]))) {
            onClick(button13);
            return;
        } // для кнопки 13
        if ((arrayXO[2][0] == CLER) && (((arrayXO[0][0] == arrayXO[1][0]) && (arrayXO[0][0] != CLER)) || ((arrayXO[2][1] == arrayXO[2][2])
                && (arrayXO[2][1] != CLER)) || (arrayXO[1][1] == arrayXO[0][2]))) {
            onClick(button31);
            return;
        } // для кнопки 31
        if ((arrayXO[2][2] == CLER) && (((arrayXO[0][2] == arrayXO[1][2]) && (arrayXO[0][2] != CLER)) || ((arrayXO[2][0] == arrayXO[2][1])
                && (arrayXO[2][0] != CLER)) || (arrayXO[1][1] == arrayXO[0][0]))) {
            onClick(button33);
            return;
        } // для кнопки 33
        if ((arrayXO[0][1] == CLER) && (((arrayXO[0][0] == arrayXO[0][2]) && (arrayXO[0][0] != CLER)) || ((arrayXO[1][1] == arrayXO[2][1])
        ))) {
            onClick(button12);
            return;
        } // для кнопки 12
        if ((arrayXO[1][0] == CLER) && (((arrayXO[0][0] == arrayXO[2][0]) && (arrayXO[0][0] != CLER)) || ((arrayXO[1][1] == arrayXO[1][2])
        ))) {
            onClick(button21);
            return;
        } // для кнопки 21
        if ((arrayXO[1][2] == CLER) && (((arrayXO[0][2] == arrayXO[2][2]) && (arrayXO[0][2] != CLER)) || ((arrayXO[1][1] == arrayXO[1][0])
        ))) {
            onClick(button23);
            return;
        } // для кнопки 23
        if ((arrayXO[2][1] == CLER) && (((arrayXO[2][0] == arrayXO[2][2]) && (arrayXO[2][0] != CLER)) || ((arrayXO[1][1] == arrayXO[0][1])
        ))) {
            onClick(button32);
            return;
        } // для кнопки 32
        if (CLER == arrayXO[2][2]) {
            onClick(button33);
            return;
        }// если занят центр занимать правый нижний угол
        if (CLER == arrayXO[0][0]) {
            onClick(button11);
            return;
        } // занять левый верхний угол
        if (CLER == arrayXO[0][2]) {
            onClick(button13);
            return;
        } // занять правый верхний угол
        if (CLER == arrayXO[2][0]) {
            onClick(button31);
            return;
        } // занять левый нижний угол
        if (CLER == arrayXO[0][1]) {
            onClick(button12);
            return;
        } // занять верх средину
        if (CLER == arrayXO[1][0]) {
            onClick(button21);
            return;
        } // занять лево средину
        if (CLER == arrayXO[1][2]) {
            onClick(button23);
            return;
        } // занять право средину
        if (CLER == arrayXO[2][1]) {
            onClick(button32);
        } // занять низ средину
    }

    public void onClick(View view) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (view.getId()) {
            case R.id.button11:
                arrayXO[0][0] = thisChois;
                break;
            case R.id.button12:
                arrayXO[0][1] = thisChois;
                break;
            case R.id.button13:
                arrayXO[0][2] = thisChois;
                break;
            case R.id.button21:
                arrayXO[1][0] = thisChois;
                break;
            case R.id.button22:
                arrayXO[1][1] = thisChois;
                break;
            case R.id.button23:
                arrayXO[1][2] = thisChois;
                break;
            case R.id.button31:
                arrayXO[2][0] = thisChois;
                break;
            case R.id.button32:
                arrayXO[2][1] = thisChois;
                break;
            case R.id.button33:
                arrayXO[2][2] = thisChois;
                break;
        }
        ((Button) view).setText(Character.toString(thisChois)); // пишу надпись на кнопке текущего хода
        view.setEnabled(false); // запрет второго нажатия
        if ((thisChois == arrayXO[0][0]) && (thisChois == arrayXO[0][1]) && (thisChois == arrayXO[0][2]) ||
                (thisChois == arrayXO[1][0]) && (thisChois == arrayXO[1][1]) && (thisChois == arrayXO[1][2]) ||
                (thisChois == arrayXO[2][0]) && (thisChois == arrayXO[2][1]) && (thisChois == arrayXO[2][2]) ||
                (thisChois == arrayXO[0][0]) && (thisChois == arrayXO[1][0]) && (thisChois == arrayXO[2][0]) ||
                (thisChois == arrayXO[0][1]) && (thisChois == arrayXO[1][1]) && (thisChois == arrayXO[2][1]) ||
                (thisChois == arrayXO[0][2]) && (thisChois == arrayXO[1][2]) && (thisChois == arrayXO[2][2]) ||
                (thisChois == arrayXO[0][0]) && (thisChois == arrayXO[1][1]) && (thisChois == arrayXO[2][2]) ||
                (thisChois == arrayXO[0][2]) && (thisChois == arrayXO[1][1]) && (thisChois == arrayXO[2][0])) {
            menu.setText("Выиграл " + Character.toString(thisChois));
            //прописываю конец игры при заполненном масиве

        } else {
            if (hasArrayNoZeroItems(arrayXO)) { //прописываю конец игры при заполненном масиве 2
                menu.setText("Нет ходов, сыграйте еще");
                return;
            }
            thisChois = changeMove(thisChois);
            menu.setText("Ход " + Character.toString(thisChois));
            if (tempPC == thisChois) {
                pC();
            } else {
                buttonPC.setEnabled(false);
            }
        }
    }

    protected boolean hasArrayNoZeroItems(char[][] array) {
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                if (array[i][j] == CLER) {
                    return false;
                }
            }
        }
        return true;
    }

}
