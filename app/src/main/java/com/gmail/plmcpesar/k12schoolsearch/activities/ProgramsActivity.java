package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.plmcpesar.k12schoolsearch.R;
import com.gmail.plmcpesar.k12schoolsearch.adapters.DisplayTrackInfoAdapter;

public class ProgramsActivity extends AppCompatActivity {

    GridView gridView;
    private android.support.v7.widget.Toolbar mToolbar;
    private ImageButton viewAcademicTrackInfo;
    private ImageButton viewSportTrackInfo;
    private ImageButton viewTVLTrackInfo;
    private ImageButton viewArtsAndDesignInfo;

    private ViewPager programsSlideViewPager;
    private LinearLayout programsDotLayout;

    private TextView[] programDots;

    private int programCurrentPage;

    private DisplayTrackInfoAdapter programSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackprograms);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.programs_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("SHS Programs");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewAcademicTrackInfo = (ImageButton) findViewById(R.id.track1);
        viewTVLTrackInfo = (ImageButton) findViewById(R.id.track2);
        viewSportTrackInfo = (ImageButton) findViewById(R.id.track3);
        viewArtsAndDesignInfo = (ImageButton) findViewById(R.id.track4);


        viewAcademicTrackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAcadStrandIntent = new Intent(ProgramsActivity.this, DisplayAcademicStrandListActivity.class);
                startActivity(viewAcadStrandIntent);
            }
        });

        viewTVLTrackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewTVLStrandIntent = new Intent(ProgramsActivity.this, DisplayTVLStrandListActivity.class);
                startActivity(viewTVLStrandIntent);
            }
        });

        viewSportTrackInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewSportIntent = new Intent(ProgramsActivity.this, DisplaySportStrandInfoActivity.class);
                startActivity(viewSportIntent);
            }
        });

        viewArtsAndDesignInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewArtsAndDesignIntent = new Intent(ProgramsActivity.this, DisplayArtsAndDesignStrandInfoActivity.class);
                startActivity(viewArtsAndDesignIntent);
            }
        });


        programsSlideViewPager = (ViewPager) findViewById(R.id.programs_slideimage);
        programsDotLayout = (LinearLayout) findViewById(R.id.programms_dotsLayout);

        programSliderAdapter = new DisplayTrackInfoAdapter(this);
        programsSlideViewPager.setAdapter(programSliderAdapter);

        programsSlideViewPager.addOnPageChangeListener(viewListener);

        programAddDotsIndicator(0);

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

    private void programAddDotsIndicator(int position) {
        programDots = new TextView[1];
        programsDotLayout.removeAllViews();

        for(int dotCount=0; dotCount<programDots.length; dotCount++){
            programDots[dotCount] = new TextView(this);
            programDots[dotCount].setText(Html.fromHtml("&#8226;"));
            programDots[dotCount].setTextSize(35);
            programDots[dotCount].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            programsDotLayout.addView(programDots[dotCount]);
        }
        programsDotLayout.setGravity(Gravity.CENTER);
        programsDotLayout.setVisibility(View.INVISIBLE);
        if (programDots.length>0){
            programDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            programAddDotsIndicator(position);

            programCurrentPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
