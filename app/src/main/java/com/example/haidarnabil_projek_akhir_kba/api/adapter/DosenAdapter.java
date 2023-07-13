package com.example.haidarnabil_projek_akhir_kba.api.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.haidarnabil_projek_akhir_kba.api.model.dosen.DataDosenItem;
import com.example.haidarnabil_projek_akhir_kba.databinding.ItemDosenRecyclerViewBinding;

import java.util.List;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.AdapterViewHolder> {

    List<DataDosenItem> dataDosen;

    public DosenAdapter(List<DataDosenItem> dataDosen) {
        this.dataDosen = dataDosen;
    }


    @NonNull
    @Override
    public DosenAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(ItemDosenRecyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DosenAdapter.AdapterViewHolder holder, int position) {
        DataDosenItem responseDataDosen = dataDosen.get(position);

    String namaDosen = responseDataDosen.getNama();
    String nidnDosen = responseDataDosen.getNidn();
    String matkulDosen = responseDataDosen.getMataKuliah();

    holder.binding.tvListNamaDosen.setText(namaDosen);
    holder.binding.tvListNidn.setText(nidnDosen);
    holder.binding.tvMatakuliah.setText(matkulDosen);

    Glide.with(holder.binding.ivListDosen)
            .load(responseDataDosen.getImage())
            .into(holder.binding.ivListDosen);

    }

    @Override
    public int getItemCount() { return dataDosen.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {

        ItemDosenRecyclerViewBinding binding;

        public AdapterViewHolder(ItemDosenRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
