package com.arfdn.intentapp;

import static com.arfdn.intentapp.MainActivityJava.EXTRA_NAME;
import static com.arfdn.intentapp.SecondActivityJava.EXTRA_ADDRESS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.arfdn.intentapp.databinding.ActivityThirdBinding;

public class ThirdActivityJava extends AppCompatActivity {
    private ActivityThirdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra(EXTRA_NAME);

        binding.btnToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                // Put address into the Intent
                resultIntent.putExtra(EXTRA_ADDRESS, binding.edtAddress.getText().toString());
                resultIntent.putExtra(EXTRA_NAME, name);
                // Set result code and Intent data
                setResult(Activity.RESULT_OK, resultIntent);
                // Finish the activity
                finish();
            }
        });
    }
}
