package com.example.bui.buoi8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnCall, btnDel, btnSao, btnThang;
    private TextView tvHienthi;
    private String numberPhone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnCall = (Button) findViewById(R.id.btn_call);
        btnDel = (Button) findViewById(R.id.btn_del);
        btnSao = (Button) findViewById(R.id.btn_sao);
        btnThang = (Button) findViewById(R.id.btn_thang);
        tvHienthi = (TextView) findViewById(R.id.tvHThi);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSao.setOnClickListener(this);
        btnThang.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_0:
                numberPhone += "0";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_1:
                numberPhone += "1";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_2:
                numberPhone += "2";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_3:
                numberPhone += "3";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_4:
                numberPhone += "4";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_5:
                numberPhone += "5";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_6:
                numberPhone += "6";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_7:
                numberPhone += "7";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_8:
                numberPhone += "8";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_sao:
                numberPhone += "*";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_thang:
                numberPhone += "#";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_9:
                numberPhone += "9";
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_del:
                if(numberPhone != null) {
                    int length = numberPhone.length();
                    if (length > 0) {

                        numberPhone = numberPhone.substring(0, length - 1);

                    }
                }
                tvHienthi.setText(numberPhone);
                break;
            case R.id.btn_call:
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + numberPhone);
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
        }
    }
}
