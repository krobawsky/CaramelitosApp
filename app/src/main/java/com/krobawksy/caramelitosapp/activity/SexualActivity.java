package com.krobawksy.caramelitosapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.krobawksy.caramelitosapp.R;
import com.krobawksy.caramelitosapp.adapter.SectionsTabAdapter;
import com.krobawksy.caramelitosapp.fragments.HombresFragment;
import com.krobawksy.caramelitosapp.fragments.MujeresFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SexualActivity extends AppCompatActivity {

    private static final String TAG = SexualActivity.class.getSimpleName();

    private SectionsTabAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexual);
        ButterKnife.bind(this);

        mSectionsPageAdapter = new SectionsTabAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsTabAdapter adapter = new SectionsTabAdapter(getSupportFragmentManager());

        adapter.addFragment(new HombresFragment(), "Hombres");
        adapter.addFragment(new MujeresFragment(), "Mujeres");

        viewPager.setAdapter(adapter);
    }

    @OnClick(R.id.iv_back)
    public void back(View v) {
        finish();
    }
}
