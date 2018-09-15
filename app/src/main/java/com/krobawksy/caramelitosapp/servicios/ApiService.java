package com.krobawksy.caramelitosapp.servicios;

import com.krobawksy.caramelitosapp.models.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_BASE_URL = "https://hackathon-jrgflores.c9users.io";

    // Productos
    @GET("/productos")
    Call<List<Producto>> getProductos();

}
