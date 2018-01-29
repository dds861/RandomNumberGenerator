package com.dd.randomnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvRandomNumber;
    private EditText mFromEt;
    private EditText mTillEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mTvRandomNumber = (TextView) findViewById(R.id.tvRandomNumber);
        try {

            mTvRandomNumber.setOnClickListener(this);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter Valid Range", Toast.LENGTH_SHORT).show();
        }

        mFromEt = (EditText) findViewById(R.id.et_from);
        mTillEt = (EditText) findViewById(R.id.et_till);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRandomNumber:

                //создаем Random обьект
                Random random = new Random();

                //создем 2 переменные
                int min, max;

                //считываем мин и макс
                String minText = mFromEt.getText().toString();
                String maxText = mTillEt.getText().toString();

                //проверка, если одно из значений пусто тогда ставим по умолчанию цифры
                if (minText.isEmpty() || maxText.isEmpty()) {
                    min = 0;
                    max = 1000;
                } else {
                    //если не пустые тогда считываем
                    min = Integer.valueOf(minText);
                    max = Integer.valueOf(maxText);
                }


                //Проверяем чтоб min не был больше max, если так но меняем местами их значения
                if (min >= max) {
                    int tempNumber = max;
                    max = min;
                    min = tempNumber;
                }

                //генерируем случайные числа
                long randromNumber = random.nextInt(max - min) + min;

                //устанавливаем новое сгенерированное число
                String s1 = String.valueOf(randromNumber);
                mTvRandomNumber.setText(s1);
                break;

            default:
                break;
        }
    }
}
