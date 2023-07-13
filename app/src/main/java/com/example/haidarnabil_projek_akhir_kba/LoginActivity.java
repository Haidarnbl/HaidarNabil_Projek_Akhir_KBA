package com.example.haidarnabil_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.haidarnabil_projek_akhir_kba.api.ApiConfig;
import com.example.haidarnabil_projek_akhir_kba.api.model.login.ResponseLogin;
import com.example.haidarnabil_projek_akhir_kba.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etEmailLogin.getText().toString().trim();
                String password = binding.etPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    binding.etEmailLogin.setError("Email Harus Diisi !");
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPasswordLogin.setError("Password Harus Diisi !");
                } else {
                    login(email,password);
                }
            }
        });

    }

    private void login(String email, String password) {
        ApiConfig.service.requestLogin(email,password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();

                    if (responseLogin.isSukses()){
                        Bundle data = new Bundle();
                        data.putString("email", responseLogin.getDataLogin().getEmail());
                        data.putString("password", responseLogin.getDataLogin().getEmail());

                        Intent login = new Intent(LoginActivity.this, MainActivity.class);
                        login.putExtras(data);
                        startActivity(login);
                        finishAffinity();
                    } else {
                        Toast.makeText(LoginActivity.this, responseLogin.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,"Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Harap Periksa Internet Anda!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}