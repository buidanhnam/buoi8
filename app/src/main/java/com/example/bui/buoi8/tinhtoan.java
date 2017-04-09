package com.example.bui.buoi8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tinhtoan extends AppCompatActivity {
      private TextView txtHienthi;
      private EditText edtChao;
    private Button btnOk;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinhtoan);
        init();

    }

    private void init() {
        txtHienthi = (TextView) findViewById(R.id.txtHienthi);

        edtChao = (EditText) findViewById(R.id.edtchao);
        btnOk = (Button) findViewById(R.id.btntinh);
          intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");
        String hienthi = "Xin chao " + bundle.getString("ten") + "ban sinh nam  "+ (2017 - bundle.getInt("tuoi")) ;
        txtHienthi.setText(hienthi);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chao = edtChao.getText().toString();
                intent.putExtra("Chao", chao);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
