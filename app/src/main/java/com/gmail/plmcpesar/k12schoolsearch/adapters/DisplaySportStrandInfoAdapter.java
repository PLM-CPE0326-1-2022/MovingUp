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

public class DisplaySportStrandInfoAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public DisplaySportStrandInfoAdapter (Context context){
        this.context = context;
    }

    public int[] sportstrand_slide_images = {
            R.drawable.sportstrand_flipimage1
    };

    @Override
    public int getCount() {
        return sportstrand_slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sportstrand_slide_layout, container, false);

        ImageView sportSlideImageView = (ImageView) view.findViewById(R.id.sportstrand_slide_image);
        sportSlideImageView.setImageResource(sportstrand_slide_images[position]);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
