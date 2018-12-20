package com.gmail.plmcpesar.k12schoolsearch.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class OnboardSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public OnboardSliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
        R.drawable.onboard1,
        R.drawable.onboard2,
        R.drawable.onboard3,
        R.drawable.onboard4,
        R.drawable.onboard5,
        R.drawable.onboard6
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.slide_image);
        slideImageView.setImageResource(slide_images[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
