package com.example.haidarnabil_projek_akhir_kba.api.model.dosen;

import com.google.gson.annotations.SerializedName;

public class DataDosenItem{

	@SerializedName("image")
	private String image;

	@SerializedName("nama")
	private String nama;

	@SerializedName("nidn")
	private String nidn;

	@SerializedName("id")
	private String id;

	@SerializedName("mata_kuliah")
	private String mataKuliah;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNidn(String nidn){
		this.nidn = nidn;
	}

	public String getNidn(){
		return nidn;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMataKuliah(String mataKuliah){
		this.mataKuliah = mataKuliah;
	}

	public String getMataKuliah(){
		return mataKuliah;
	}

	@Override
 	public String toString(){
		return 
			"DataDosenItem{" + 
			"image = '" + image + '\'' + 
			",nama = '" + nama + '\'' + 
			",nidn = '" + nidn + '\'' + 
			",id = '" + id + '\'' + 
			",mata_kuliah = '" + mataKuliah + '\'' + 
			"}";
		}
}