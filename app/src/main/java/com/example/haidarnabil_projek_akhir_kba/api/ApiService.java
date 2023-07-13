package com.example.haidarnabil_projek_akhir_kba.api;

import com.example.haidarnabil_projek_akhir_kba.api.model.dosen.ResponseDosen;
import com.example.haidarnabil_projek_akhir_kba.api.model.login.ResponseLogin;
import com.example.haidarnabil_projek_akhir_kba.api.model.register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("getDosen")
    Call<ResponseDosen> getDataDosen();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin (@Field("email") String email,
                                      @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister (@Field("username") String userName,
                                            @Field("email") String email,
                                            @Field("password") String password);

}
