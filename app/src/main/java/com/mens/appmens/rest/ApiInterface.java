package com.mens.appmens.rest;

import com.mens.appmens.model.PeriodsMens;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by islam on 30/08/17.
 */

public interface ApiInterface {
    // Periode menstruasi
    @GET("periods/?format=json")
    Call<PeriodsMens> periodeMens();
}
