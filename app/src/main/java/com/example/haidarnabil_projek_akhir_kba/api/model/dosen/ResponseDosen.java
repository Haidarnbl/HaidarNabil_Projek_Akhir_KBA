package com.example.haidarnabil_projek_akhir_kba.api.model.dosen;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDosen{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("status")
	private int status;

	@SerializedName("dataDosen")
	private List<DataDosenItem> dataDosen;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setDataDosen(List<DataDosenItem> dataDosen){
		this.dataDosen = dataDosen;
	}

	public List<DataDosenItem> getDataDosen(){
		return dataDosen;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDosen{" + 
			"pesan = '" + pesan + '\'' + 
			",status = '" + status + '\'' + 
			",dataDosen = '" + dataDosen + '\'' + 
			"}";
		}
}