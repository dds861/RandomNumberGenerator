package com.dd.randomnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvRandomNumber;
    private EditText mFromEt;
    private EditText mTillEt;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void initView() {
        mTvRandomNumber = (TextView) findViewById(R.id.tvRandomNumber);
        mTvRandomNumber.setOnClickListener(this);

        mFromEt = (EditText) findViewById(R.id.et_from);
        mTillEt = (EditText) findViewById(R.id.et_till);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRandomNumber:
                //создаем переменную чтобы записать туда сгенерированное значение
                String s1;

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
                    //если не пустые тогда инициализируем
                    min = Integer.valueOf(minText);
                    max = Integer.valueOf(maxText);
                }


                //Проверяем чтоб min не был больше max, если так но меняем местами их значения
                if (min > max) {
                    int tempNumber = max;
                    max = min;
                    min = tempNumber;
                }

                //генерируем случайные числа
                long randromNumber = random.nextInt(max - min + 1) + min;

                //устанавливаем новое сгенерированное число
                s1 = String.valueOf(randromNumber);
                mTvRandomNumber.setText(s1);
                break;

            default:
                break;
        }
    }
}
