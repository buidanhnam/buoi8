package com.example.bui.buoi8;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btndialer, btnMes, btnMusic, btnCamera, btnContact, btngallery;
    private TextView txtDate;
    private MyView txtTime;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnCamera = (Button) findViewById(R.id.btncamera);
        btnContact = (Button) findViewById(R.id.btncontact);
        btndialer = (Button) findViewById(R.id.btndialer);
        btnMes = (Button) findViewById(R.id.btnMes);
        btnMusic = (Button) findViewById(R.id.btnmusic);
        btngallery = (Button) findViewById(R.id.btngallery);
        txtTime = (MyView) findViewById(R.id.txtTime);
        txtDate = (TextView) findViewById(R.id.txtDate);
        btndialer.setOnClickListener(this);
        btngallery.setOnClickListener(this);
        btnMusic.setOnClickListener(this);
        btnContact.setOnClickListener(this);
        btnMes.setOnClickListener(this);
        btnCamera.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndialer:
                intent = new Intent(MainActivity.this, DialerActivity.class);

                startActivity(intent);

                break;
            case R.id.btnMes:

//                   intent = new Intent(Intent.ACTION_SENDTO ,Uri.parse("sms:"+ "0986837648" ));
                intent = new Intent(MainActivity.this, MessActivity.class);
                startActivity(intent);

                break;
            case R.id.btncontact:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case R.id.btnmusic:
                intent = new Intent(Intent.ACTION_PICK);

                intent.setType("immage/*");
                startActivity(intent);
                break;
            case R.id.btncamera:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case R.id.btngallery:
                 intent = new Intent(MainActivity.this, GallaryActivity.class);
                 startActivity(intent);
                break;
        }
    }


}
