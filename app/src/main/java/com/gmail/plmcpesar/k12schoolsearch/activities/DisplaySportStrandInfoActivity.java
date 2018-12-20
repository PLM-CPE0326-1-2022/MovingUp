package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayArtsAndDesignIStrandInfoAdapter;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplaySportStrandInfoAdapter;

public class DisplaySportStrandInfoActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    private ViewPager sportStrandSlideViewPager;
    private LinearLayout sportStrandDotLayout;

    private TextView[]  sportStrandDots;

    private int  sportStrandCurrentPage;

    private DisplaySportStrandInfoAdapter sportStandProgramSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sport_strand_info);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.sport_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Sports Track");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sportStrandSlideViewPager = (ViewPager) findViewById(R.id.sport_slideimage);
        sportStrandDotLayout = (LinearLayout) findViewById(R.id.sport_dotsLayout);

        sportStandProgramSliderAdapter = new DisplaySportStrandInfoAdapter (this);
        sportStrandSlideViewPager.setAdapter(sportStandProgramSliderAdapter);

        sportStrandSlideViewPager.addOnPageChangeListener(viewListener);

        sportStrandAddDotsIndicator(0);
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

    private void sportStrandAddDotsIndicator(int position) {
        sportStrandDots = new TextView[1];
        sportStrandDotLayout.removeAllViews();

        for(int dotCount=0; dotCount<sportStrandDots.length; dotCount++){
            sportStrandDots[dotCount] = new TextView(this);
            sportStrandDots[dotCount].setText(Html.fromHtml("&#8226;"));
            sportStrandDots[dotCount].setTextSize(35);
            sportStrandDots[dotCount].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            sportStrandDotLayout.addView(sportStrandDots[dotCount]);
        }
        sportStrandDotLayout.setGravity(Gravity.CENTER);
        sportStrandDotLayout.setVisibility(View.INVISIBLE);
        if (sportStrandDots.length>0){
            sportStrandDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            sportStrandAddDotsIndicator(position);

            sportStrandCurrentPage= position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
