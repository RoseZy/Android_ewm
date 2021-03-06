package com.example.apple.android_ewm;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CustomScanActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener {
    private DecoratedBarcodeView  dbv;
    private CaptureManager  captureManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scan);
     dbv= (DecoratedBarcodeView) findViewById(R.id.dbv);

        dbv.setTorchListener(this);
        //重要代码，初始化捕获
        captureManager = new CaptureManager(this,dbv);
        captureManager.initializeFromIntent(getIntent(),savedInstanceState);
        captureManager.decode();
    }


    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return dbv.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }


    @Override
    public void onTorchOn() {

    }

    @Override
    public void onTorchOff() {
    }


}
