package com.example.macmine.barcodescanner2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//===========camera permission required=============

//http://www.qr-code-generator.com/ you can create static qr code here ..without login ....n use it ......if you wanna create dynamic qr code ..then u have to login ..n u will get trial version
// you need dynamic qr code ..like  u see in paytm ..every person who create an account get his own qr code...so that other user can send money or get money by scanning...
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {


        Intent intent = new Intent(this, SimpleScannerActivity.class);

        startActivityForResult(intent, 2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==2) {
            if(resultCode == RESULT_OK) {

                String contents = data.getStringExtra("SCAN_RESULT");

                Toast.makeText(this,contents +"" , Toast.LENGTH_LONG).show();
            }
        }

    }
}
