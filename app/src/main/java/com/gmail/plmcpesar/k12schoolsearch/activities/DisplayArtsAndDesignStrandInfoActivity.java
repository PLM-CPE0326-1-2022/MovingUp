package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayAcadStrandInfoAdapter;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayArtsAndDesignIStrandInfoAdapter;

public class DisplayArtsAndDesignStrandInfoActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    private ViewPager artsanddesignStrandSlideViewPager;
    private LinearLayout  artsanddesignStrandDotLayout;

    private TextView[]  artsanddesignStrandDots;

    private int  artsanddesignStrandCurrentPage;

    private DisplayArtsAndDesignIStrandInfoAdapter artsanddesignStandProgramSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_arts_and_design_strand_info);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.artsanddesign_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Arts and Design Track");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        artsanddesignStrandSlideViewPager = (ViewPager) findViewById(R.id.artsanddesign_slideimage);
        artsanddesignStrandDotLayout = (LinearLayout) findViewById(R.id.artsanddesign_dotsLayout);

        artsanddesignStandProgramSliderAdapter = new DisplayArtsAndDesignIStrandInfoAdapter (this);
        artsanddesignStrandSlideViewPager.setAdapter(artsanddesignStandProgramSliderAdapter);

        artsanddesignStrandSlideViewPager.addOnPageChangeListener(viewListener);

        artsanddesignStrandAddDotsIndicator(0);
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

    private void artsanddesignStrandAddDotsIndicator(int position) {
        artsanddesignStrandDots = new TextView[3];
        artsanddesignStrandDotLayout.removeAllViews();

        for(int dotCount=0; dotCount<artsanddesignStrandDots.length; dotCount++){
            artsanddesignStrandDots[dotCount] = new TextView(this);
            artsanddesignStrandDots[dotCount].setText(Html.fromHtml("&#8226;"));
            artsanddesignStrandDots[dotCount].setTextSize(35);
            artsanddesignStrandDots[dotCount].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            artsanddesignStrandDotLayout.addView(artsanddesignStrandDots[dotCount]);
        }
        artsanddesignStrandDotLayout.setGravity(Gravity.CENTER);
        if (artsanddesignStrandDots.length>0){
            artsanddesignStrandDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            artsanddesignStrandAddDotsIndicator(position);

            artsanddesignStrandCurrentPage= position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
