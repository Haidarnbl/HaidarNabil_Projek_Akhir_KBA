package com.example.haidarnabil_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.haidarnabil_projek_akhir_kba.api.ApiConfig;
import com.example.haidarnabil_projek_akhir_kba.api.model.register.ResponseRegister;
import com.example.haidarnabil_projek_akhir_kba.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvSudahPunyaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.etUsernameRegister.getText().toString().trim();
                String email = binding.etEmailRegister.getText().toString().trim();
                String password = binding.etPassRegister.getText().toString().trim();

                if (TextUtils.isEmpty(userName)) {
                    binding.etUsernameRegister.setError("Username Harus Diisi !");
                } else if (TextUtils.isEmpty(email)) {
                    binding.etEmailRegister.setError("Email Harus Diisi !");
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPassRegister.setError("Password Harus Diisi !");
                } else {
                    register(userName,email,password);
                }
            }
        });

    }

    private void register(String userName, String email, String password) {
        ApiConfig.service.requestRegister(userName, email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()) {
                    ResponseRegister responseRegister = response.body();

                    if (responseRegister.isSukses()) {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();

                        Intent registerSukses = new Intent(RegisterActivity.this, RegisterSuksesActivity.class);
                        startActivity(registerSukses);
                        finishAffinity();
                    } else {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this,"Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Harap Periksa Internet Anda!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}