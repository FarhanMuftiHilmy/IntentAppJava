package com.arfdn.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.arfdn.intentapp.databinding.ActivityMainBinding;

public class MainActivityJava extends AppCompatActivity {
    private static final String TAG = "MainActivityLifecycle";
    private ActivityMainBinding binding;
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToSecondActivity = new Intent(MainActivityJava.this, SecondActivityJava.class);
                intentToSecondActivity.putExtra(EXTRA_NAME, binding.edtName.getText().toString());
                startActivity(intentToSecondActivity);
            }
        });

        binding.btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, this is a message from my app!");
                startActivity(Intent.createChooser(intent, "Select an app"));
            }
        });

        binding.btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1234567890"));
                startActivity(intent);
            }
        });

        binding.btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate: dipanggil");
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.d(TAG, "onCreate: dipanggil");
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: dipanggil");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: dipanggil");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: dipanggil");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: dipanggil");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: dipanggil");
    }

}
