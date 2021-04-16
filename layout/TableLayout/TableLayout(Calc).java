package org.ict.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button plus, minus, multiple, division;
    EditText first, second;
    TextView result;

    Button [] numButtons = new Button[10];
    Integer [] numBtnIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("calculator2");

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiple = (Button) findViewById(R.id.multiple);
        division = (Button) findViewById(R.id.division);
        first = (EditText) findViewById(R.id.firstnum);
        second = (EditText) findViewById(R.id.secondnum);
        result = (TextView) findViewById(R.id.result);

        // 반복문으로 0~9번 버튼을 전부 연결결
       for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIds[i]);
        }

       for (int i = 0; i < numBtnIds.length; i++) {
           final int index; //명목상 넣어줄 int, 꼭 선언해서 사용해야함
           // i 변수를 익명 클래스 내부에서 바로 호출하면 에러가 나서
           // index에 따로 옮겨놓고 사용.
           index = i;

           numButtons[index].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String num1, num2;
                   if(first.isFocused() == true) {
                       num1 = first.getText().toString() + numButtons[index].getText().toString();
                       first.setText(num1);
                   } else if(second.isFocused() == true) {
                       num2 = second.getText().toString() + numButtons[index].getText().toString();
                       second.setText(num2);
                   } else {
                       Toast.makeText(getApplicationContext(), "입력할 창을 선택해주세요!", Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String count = String.valueOf(Integer.parseInt(first.getText().toString()) + Integer.parseInt(second.getText().toString()));
                    result.setText(count);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 입력할 수 있습니다." , Toast.LENGTH_SHORT).show();
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String count = String.valueOf(Integer.parseInt(first.getText().toString()) - Integer.parseInt(second.getText().toString()));
                    result.setText(count);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 입력할 수 있습니다." , Toast.LENGTH_SHORT).show();
                }

            }
        });

        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String count = String.valueOf(Integer.parseInt(first.getText().toString()) * Integer.parseInt(second.getText().toString()));
                    result.setText(count);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 입력할 수 있습니다." , Toast.LENGTH_SHORT).show();
                }

            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String count = String.valueOf(Integer.parseInt(first.getText().toString()) / Integer.parseInt(second.getText().toString()));
                    result.setText(count);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "정수만 입력할 수 있습니다." , Toast.LENGTH_SHORT).show();
                } catch (ArithmeticException e) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다." , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}