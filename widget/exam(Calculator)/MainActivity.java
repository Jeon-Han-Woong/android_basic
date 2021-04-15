package org.ict.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int a, b, c;

    EditText firstNum, secondNum;
    TextView textview1;
    Button btnplus, btnminus, btnmulti, btndivi, btnSize, btnColor, btnReset, btnremain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("작고 초라한 계산기");
        a = 0;
        b = 0;


        firstNum = (EditText) findViewById(R.id.firstNum);
        secondNum = (EditText) findViewById(R.id.secondNum);
        textview1 = (TextView) findViewById(R.id.result);
        btnplus = (Button) findViewById(R.id.plusBtn);
        btnminus = (Button) findViewById(R.id.minusBtn);
        btnmulti = (Button) findViewById(R.id.multiBtn);
        btndivi = (Button) findViewById(R.id.diviBtn);
        btnremain = (Button) findViewById(R.id.btnremain);
        btnSize = (Button) findViewById(R.id.sizeChange);
        btnColor = (Button) findViewById(R.id.colorChange);
        btnReset = (Button) findViewById(R.id.reset);

        btnplus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();

                try {
                    Integer tempnum1 = Integer.parseInt(num1);
                    Integer tempnum2 = Integer.parseInt(num2);
                    Integer tempresult = tempnum1 + tempnum2;
                    String result = String.valueOf(tempresult);
                    textview1.setText(result);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 들어올 수 있습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return false;
            }
        });

        btnminus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();

                try {
                    Integer tempnum1 = Integer.parseInt(num1);
                    Integer tempnum2 = Integer.parseInt(num2);
                    Integer tempresult = tempnum1 - tempnum2;
                    String result = String.valueOf(tempresult);
                    textview1.setText(result);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 들어올 수 있습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return false;
            }
        });

        btnmulti.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();

                try {
                    Integer tempnum1 = Integer.parseInt(num1);
                    Integer tempnum2 = Integer.parseInt(num2);
                    Integer tempresult = tempnum1 * tempnum2;
                    String result = String.valueOf(tempresult);
                    textview1.setText(result);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 들어올 수 있습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return false;
            }
        });

        btndivi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();

                try {
                    Integer tempnum1 = Integer.parseInt(num1);
                    Integer tempnum2 = Integer.parseInt(num2);

                    Integer tempresult = tempnum1 / tempnum2;
                    String result = String.valueOf(tempresult);
                    textview1.setText(result);

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 들어올 수 있습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                } catch (ArithmeticException e) {
                    Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    secondNum.setText("");
                    return false;
                }
                return false;
            }
        });

        btnremain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String num1 = firstNum.getText().toString();
                String num2 = secondNum.getText().toString();

                try {
                    Integer tempnum1 = Integer.parseInt(num1);
                    Integer tempnum2 = Integer.parseInt(num2);

                    Integer tempresult = tempnum1 % tempnum2;
                    String result = String.valueOf(tempresult);
                    textview1.setText(result);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 들어올 수 있습니다.", Toast.LENGTH_SHORT).show();
                    return false;
                } catch (ArithmeticException e) {
                    Toast.makeText(getApplicationContext(), "0으로는 나머지를 구할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    secondNum.setText("");
                    return false;
                }
                return false;
            }
        });

        btnReset.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                textview1.setText("초기화 완료");
                firstNum.setText("");
                secondNum.setText("");
                return false;
            }
        });

        btnColor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a++;
                if (a % 2 == 1) {
                    btnplus.setBackgroundColor(Color.DKGRAY);
                    btnminus.setBackgroundColor(Color.DKGRAY);
                    btnmulti.setBackgroundColor(Color.DKGRAY);
                    btndivi.setBackgroundColor(Color.DKGRAY);
                    btnSize.setBackgroundColor(Color.DKGRAY);
                    btnReset.setBackgroundColor(Color.DKGRAY);
                    btnColor.setBackgroundColor(Color.DKGRAY);
                } else if (a % 2 == 0) {
                    btnplus.setBackgroundColor(Color.BLUE);
                    btnminus.setBackgroundColor(Color.BLUE);
                    btnmulti.setBackgroundColor(Color.BLUE);
                    btndivi.setBackgroundColor(Color.BLUE);
                    btnSize.setBackgroundColor(Color.BLUE);
                    btnReset.setBackgroundColor(Color.BLUE);
                    btnColor.setBackgroundColor(Color.BLUE);
                }
                return false;
            }
        });

        btnSize.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c += 10;

                textview1.setTextSize(c);
                if(textview1.getTextSize() > 100) {
                    c = 0;
                }
                return false;

            }
        });


    }


}