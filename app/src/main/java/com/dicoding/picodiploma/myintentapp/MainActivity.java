package com.dicoding.picodiploma.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialButton mBtnMoveActivity;
    private MaterialButton mBtnMoveActivityWithData;
    private MaterialButton mBtnDialer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMoveActivity = findViewById(R.id.move_activity);
        mBtnMoveActivityWithData = findViewById(R.id.move_activity_with_data);
        mBtnDialer = findViewById(R.id.dial_number);
        mBtnMoveActivity.setOnClickListener(this);
        mBtnMoveActivityWithData.setOnClickListener(this);
        mBtnDialer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.move_activity_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Tom Holland");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                startActivity(moveWithDataIntent);
                break;
            case R.id.dial_number:
                String phoneNumber = "081282728374";
                Intent callNumberIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(callNumberIntent);
                break;
        }

    }
}
