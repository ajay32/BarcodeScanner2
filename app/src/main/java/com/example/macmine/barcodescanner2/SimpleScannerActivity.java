package com.example.macmine.barcodescanner2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by macmine on 13/11/17.
 */

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
    //    Log.v("ajaymehta", rawResult.getText()); // Prints scan results
    //    Log.v("ajaymehta", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

    //    Toast.makeText(this, rawResult.getText() +" ",Toast.LENGTH_LONG).show();

        //=== lets not print any result here ..we send back the result ...where the intent is coming from carring the request code..

        Intent i = getIntent();
        i.putExtra("SCAN_RESULT", rawResult.getText());
        setResult(Activity.RESULT_OK, i);
        finish();






        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }
}