package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayTVLStrandInfoAdapter;

public class DisplayTVLStrandListActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;
    private ViewPager tvlStrandSlideViewPager;
    private LinearLayout tvlStrandDotLayout;

    private ImageButton viewIctStrandInfo;
    private ImageButton viewIndustrialArtsStrandInfo;
    private ImageButton viewHomeEconomicsStrandInfo;
    private ImageButton viewAgriFisheryStrandInfo;

    private TextView[] tvlStrandDots;

    private int tvlStrandCurrentPage;

    private DisplayTVLStrandInfoAdapter tvlStandProgramSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tvlstrand_list);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tvlprograms_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("TVL Track");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvlStrandSlideViewPager = (ViewPager) findViewById(R.id.tvlstrand_slideimage);
        tvlStrandDotLayout = (LinearLayout) findViewById(R.id.tvlstrand_dotsLayout);

        tvlStandProgramSliderAdapter = new DisplayTVLStrandInfoAdapter(this);
        tvlStrandSlideViewPager.setAdapter(tvlStandProgramSliderAdapter);

        tvlStrandSlideViewPager.addOnPageChangeListener(viewListener);

        tvlStrandAddDotsIndicator(0);

        viewHomeEconomicsStrandInfo = (ImageButton) findViewById(R.id.tvlstrand1);
        viewIctStrandInfo = (ImageButton) findViewById(R.id.tvlstrand2);
        viewAgriFisheryStrandInfo = (ImageButton) findViewById(R.id.tvlstrand3);
        viewIndustrialArtsStrandInfo = (ImageButton) findViewById(R.id.tvlstrand4);

        viewHomeEconomicsStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewHEStrandIntent = new Intent(DisplayTVLStrandListActivity.this, DisplayTVLHomeEconomicsInfoActivity.class);
                startActivity(viewHEStrandIntent);
            }
        });

        viewIctStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewICTStrandIntent = new Intent(DisplayTVLStrandListActivity.this, DisplayTVLIctInfoActivity.class);
                startActivity(viewICTStrandIntent);
            }
        });

        viewAgriFisheryStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAgriFisheryStrandIntent = new Intent(DisplayTVLStrandListActivity.this, DisplayTVLAgriFisheryInfoActivity.class);
                startActivity(viewAgriFisheryStrandIntent);
            }
        });

        viewIndustrialArtsStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIndustrialArtsStrandIntent = new Intent(DisplayTVLStrandListActivity.this, DisplayTVLIndustrialArtsInfoActivity.class);
                startActivity(viewIndustrialArtsStrandIntent);
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void tvlStrandAddDotsIndicator(int position) {
        tvlStrandDots = new TextView[4];
        tvlStrandDotLayout.removeAllViews();

        for(int dotCount=0; dotCount<tvlStrandDots.length; dotCount++){
            tvlStrandDots[dotCount] = new TextView(this);
            tvlStrandDots[dotCount].setText(Html.fromHtml("&#8226;"));
            tvlStrandDots[dotCount].setTextSize(35);
            tvlStrandDots[dotCount].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            tvlStrandDotLayout.addView(tvlStrandDots[dotCount]);
        }
        tvlStrandDotLayout.setGravity(Gravity.CENTER);
        if (tvlStrandDots.length>0){
            tvlStrandDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tvlStrandAddDotsIndicator(position);

            tvlStrandCurrentPage= position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
