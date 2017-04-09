package com.example.bui.buoi8;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_Send, btn_Danhba;
    private EditText edtContact;
    private String sContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess);
        init();
        onclickListen();
    }

    private void onclickListen() {
        btn_Danhba.setOnClickListener(this);

        btn_Send.setOnClickListener(this);
    }

    private void init() {
        btn_Danhba = (Button) findViewById(R.id.btn_danhba);
        btn_Send = (Button) findViewById(R.id.btn_SendMess);
        edtContact = (EditText) findViewById(R.id.edt_contact);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_SendMess:
                if (edtContact.getText().toString() != null) {
                    sContact = edtContact.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + sContact));
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Khong co SDT", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_danhba:

                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

                startActivityForResult(intent1, 2);


                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {

            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                // Do something with the phone number

                edtContact.setText(number);
            }
        }
    }
}
