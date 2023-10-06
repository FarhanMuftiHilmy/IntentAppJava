package com.arfdn.intentapp;

import static com.arfdn.intentapp.MainActivityJava.EXTRA_NAME;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.arfdn.intentapp.databinding.ActivitySecondBinding;

public class SecondActivityJava extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String name = data != null ? data.getStringExtra(EXTRA_NAME) : null;
                        String address = data != null ? data.getStringExtra(EXTRA_ADDRESS) : null;
                        binding.txtName.setText(name + " beralamat di " + address);
                    }
                }
            });

    public static final String EXTRA_ADDRESS = "extra_address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra(MainActivityJava.EXTRA_NAME);
        binding.txtName.setText(name);

        binding.btnToThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivityJava.this, ThirdActivityJava.class);
                intent.putExtra(EXTRA_NAME, name);
                launcher.launch(intent);
            }
        });

    }
}
