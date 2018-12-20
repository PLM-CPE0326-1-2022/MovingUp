package com.gmail.plmcpesar.k12schoolsearch.activities;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class DisplayAboutAppActivity extends AppCompatActivity {

    private ScrollView displayAboutScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about_app);

        displayAboutScroll = (ScrollView) findViewById(R.id.display_about_scrollview);
        ObjectAnimator displayAnimation = ObjectAnimator.ofInt(displayAboutScroll, "scrollY", displayAboutScroll.getBottom());
        displayAnimation.setDuration(1200);
        displayAnimation.start();
    }
}
