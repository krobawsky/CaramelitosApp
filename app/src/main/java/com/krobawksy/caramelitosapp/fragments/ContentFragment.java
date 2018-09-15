package com.krobawksy.caramelitosapp.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.krobawksy.caramelitosapp.R;
import com.krobawksy.caramelitosapp.activity.MapsActivity;
import com.krobawksy.caramelitosapp.activity.ProductosActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yalantis.com.sidemenu.interfaces.ScreenShotable;

public class ContentFragment extends Fragment implements ScreenShotable {

    public static final String CLOSE = "Close";
    public static final String INICIO = "Inicio";
    public static final String HISTORIAL = "Historial";
    public static final String PAINT = "Paint";
    public static final String CASE = "Case";
    public static final String SHOP = "Shop";
    public static final String PARTY = "Party";
    public static final String MOVIE = "Movie";

    private View containerView;
    private Bitmap bitmap;

    public static ContentFragment newInstance() {
        ContentFragment contentFragment = new ContentFragment();
        return contentFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Caramelitos");


        return rootView;
    }

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                ContentFragment.this.bitmap = bitmap;
            }
        };

        thread.start();

    }

    @OnClick(R.id.ll_lugar)
    public void gomap(View v) {
        startActivity(new Intent(getContext(), MapsActivity.class));
    }

    @OnClick(R.id.ll_producto)
    public void goproducto(View v) {
        startActivity(new Intent(getContext(), ProductosActivity.class));
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

}
