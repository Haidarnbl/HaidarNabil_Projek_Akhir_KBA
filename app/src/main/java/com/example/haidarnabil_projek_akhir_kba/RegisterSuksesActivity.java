package com.example.haidarnabil_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.haidarnabil_projek_akhir_kba.databinding.ActivityRegisterSuksesBinding;

public class RegisterSuksesActivity extends AppCompatActivity {

    ActivityRegisterSuksesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuksesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginRegisSukses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterSuksesActivity.this, LoginActivity.class);
                startActivity(login);
                finishAffinity();
            }
        });
    }
}