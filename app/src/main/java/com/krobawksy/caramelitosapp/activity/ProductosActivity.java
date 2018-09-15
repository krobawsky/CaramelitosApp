package com.krobawksy.caramelitosapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.krobawksy.caramelitosapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.ll_medicamentos)
    public void open_medicamentos_modal(View v) {

        final Dialog dialog = new Dialog(ProductosActivity.this);
        dialog.setContentView(R.layout.dialog_categorias);
        ImageButton ibClose = (ImageButton) dialog.findViewById(R.id.ib_close);

        CardView cvAnalgesicos = (CardView) dialog.findViewById(R.id.cv_antianalgesicos);
        CardView cvAcidos = (CardView) dialog.findViewById(R.id.cv_antiacidos);
        CardView cvAlergia = (CardView) dialog.findViewById(R.id.cv_antialergicos);
        CardView cvDiarrea = (CardView) dialog.findViewById(R.id.cv_antidiarreicos);
        CardView cvInfec = (CardView) dialog.findViewById(R.id.cv_antiinfec);
        CardView cvInfla = (CardView) dialog.findViewById(R.id.cv_antiinfla);
        CardView cvPiretics = (CardView) dialog.findViewById(R.id.cv_antipiret);
        CardView cvTos = (CardView) dialog.findViewById(R.id.cv_antitusivos);

        dialog.setCancelable(false);
        ibClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        cvAnalgesicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        });

        cvAcidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
            }
        });

        cvAlergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 3);
                startActivity(intent);
            }
        });


        cvDiarrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });

        cvInfec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 5);
                startActivity(intent);
            }
        });

        cvInfla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 6);
                startActivity(intent);
            }
        });

        cvPiretics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 7);
                startActivity(intent);
            }
        });

        cvTos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosActivity.this, ElementosActivity.class);
                intent.putExtra("id", 8);
                startActivity(intent);
            }
        });

        dialog.show();
    }

    @OnClick(R.id.ll_sexual)
    public void go_sexual(View v) {
        startActivity(new Intent(this, SexualActivity.class));
    }

    @OnClick(R.id.iv_back)
    public void back(View v) {
        finish();
    }
}
