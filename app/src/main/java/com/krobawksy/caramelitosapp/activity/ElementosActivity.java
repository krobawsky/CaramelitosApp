package com.krobawksy.caramelitosapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.krobawksy.caramelitosapp.R;
import com.krobawksy.caramelitosapp.adapter.ProductosAdapter;
import com.krobawksy.caramelitosapp.models.Producto;
import com.krobawksy.caramelitosapp.servicios.ApiService;
import com.krobawksy.caramelitosapp.servicios.ApiServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElementosActivity extends AppCompatActivity {

    private static final String TAG = ElementosActivity.class.getSimpleName();

    private RecyclerView productosList;
    private ProductosAdapter adapter;
    List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos);
        ButterKnife.bind(this);

        productosList = (RecyclerView) findViewById(R.id.productos_rv);

        productosList.setLayoutManager(new LinearLayoutManager(this));
        productosList.setAdapter(new ProductosAdapter(this));

        initialize();
    }

    private void initialize(){

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Producto>> call = service.getProductos();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        productos = response.body();
                        Log.d(TAG, "productos: " + productos);

                        int cate_id = getIntent().getExtras().getInt("id");
                        Log.e(TAG, "genero_id:" + cate_id);

                        List<Producto> values = null;
                        values = new ArrayList<Producto>();

                        for(Producto producto: productos){
                            if (producto.getCategoria_idcategoria().equalsIgnoreCase(String.valueOf(cate_id))){
                                values.add(producto);
                            }
                        }

                        adapter = (ProductosAdapter) productosList.getAdapter();
                        adapter.setProductos(values);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(ElementosActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(ElementosActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }

    @OnClick(R.id.iv_back)
    public void back(View v) {
        finish();
    }
}
