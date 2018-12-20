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
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayAcadStrandInfoAdapter;

public class DisplayAcademicStrandListActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    private ImageButton viewStemStrandInfo;
    private ImageButton viewAbmStrandInfo;
    private ImageButton viewGasStrandInfo;
    private ImageButton viewHummsStrandInfo;

    private ViewPager acadStrandSlideViewPager;
    private LinearLayout acadStrandDotLayout;

    private TextView[] acadStrandDots;

    private int acadStrandCurrentPage;

    private DisplayAcadStrandInfoAdapter acadStandProgramSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_academic_strand_list);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.acadprograms_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("TVL Track");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        acadStrandSlideViewPager = (ViewPager) findViewById(R.id.acadstrand_slideimage);
        acadStrandDotLayout = (LinearLayout) findViewById(R.id.acadstrand_dotsLayout);

        acadStandProgramSliderAdapter = new DisplayAcadStrandInfoAdapter(this);
        acadStrandSlideViewPager.setAdapter(acadStandProgramSliderAdapter);

        acadStrandSlideViewPager.addOnPageChangeListener(viewListener);

        acadStrandAddDotsIndicator(0);

        viewStemStrandInfo = (ImageButton) findViewById(R.id.acadstrand1);
        viewAbmStrandInfo = (ImageButton) findViewById(R.id.acadstrand2);
        viewGasStrandInfo = (ImageButton) findViewById(R.id.acadstrand3);
        viewHummsStrandInfo = (ImageButton) findViewById(R.id.acadstrand4);

        viewStemStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewStemStrandIntent = new Intent(DisplayAcademicStrandListActivity.this, DisplayAcademicStemInfoActivity.class);
                startActivity(viewStemStrandIntent);
            }
        });

        viewAbmStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAbmStrandIntent = new Intent(DisplayAcademicStrandListActivity.this, DisplayAcademicAbmInfoActivity.class);
                startActivity(viewAbmStrandIntent);
            }
        });

        viewGasStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewGasStrandIntent = new Intent(DisplayAcademicStrandListActivity.this, DisplayAcademicGasInfoActivity.class);
                startActivity(viewGasStrandIntent);
            }
        });

        viewHummsStrandInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewHummsStrandIntent = new Intent(DisplayAcademicStrandListActivity.this, DisplayAcademicHummsInfoActivity.class);
                startActivity(viewHummsStrandIntent);
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

    private void acadStrandAddDotsIndicator(int position) {
        acadStrandDots = new TextView[4];

        acadStrandDotLayout.removeAllViews();

        for(int dotCount=0; dotCount<acadStrandDots.length; dotCount++){
            acadStrandDots[dotCount] = new TextView(this);
            acadStrandDots[dotCount].setText(Html.fromHtml("&#8226;"));
            acadStrandDots[dotCount].setTextSize(35);
            acadStrandDots[dotCount].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            acadStrandDotLayout.addView(acadStrandDots[dotCount]);
        }
        acadStrandDotLayout.setGravity(Gravity.CENTER);
        if (acadStrandDots.length>0){
            acadStrandDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            acadStrandAddDotsIndicator(position);

            acadStrandCurrentPage= position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
