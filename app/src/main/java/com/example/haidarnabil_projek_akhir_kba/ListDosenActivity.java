package com.example.haidarnabil_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.haidarnabil_projek_akhir_kba.api.ApiConfig;
import com.example.haidarnabil_projek_akhir_kba.api.adapter.DosenAdapter;
import com.example.haidarnabil_projek_akhir_kba.api.model.dosen.DataDosenItem;
import com.example.haidarnabil_projek_akhir_kba.api.model.dosen.ResponseDosen;
import com.example.haidarnabil_projek_akhir_kba.databinding.ActivityListDosenBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDosenActivity extends AppCompatActivity {

    DosenAdapter dosenAdapter;
    ActivityListDosenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListDosenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvListDosen.setHasFixedSize(true);
        binding.rvListDosen.setLayoutManager(new LinearLayoutManager(this));

        ApiConfig.service.getDataDosen().enqueue(new Callback<ResponseDosen>() {
            @Override
            public void onResponse(Call<ResponseDosen> call, Response<ResponseDosen> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ResponseDosen responseDosen = response.body();
                        List<DataDosenItem> dataDosen = responseDosen.getDataDosen();

                        Toast.makeText(ListDosenActivity.this, responseDosen.getPesan(), Toast.LENGTH_SHORT).show();

                        dosenAdapter = new DosenAdapter(dataDosen);
                        binding.rvListDosen.setAdapter(dosenAdapter);
                    } else {
                        Toast.makeText(ListDosenActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ListDosenActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDosen> call, Throwable t) {
                Toast.makeText(ListDosenActivity.this, "Harap Periksa Koneksi Internet Anda!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}