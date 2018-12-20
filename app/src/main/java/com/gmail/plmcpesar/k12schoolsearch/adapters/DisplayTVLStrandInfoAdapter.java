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

public class DisplayTVLStrandInfoAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public DisplayTVLStrandInfoAdapter (Context context){
        this.context = context;
    }

    public int[] tvlstrand_slide_images = {
            R.drawable.tvlstrand_flipimage1,
            R.drawable.tvlstrand_flipimage2,
            R.drawable.tvlstrand_flipimage3,
            R.drawable.tvlstrand_flipimage4
    };

    @Override
    public int getCount() {
        return tvlstrand_slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.tvlstrand_layout, container, false);

        ImageView tvlSlideImageView = (ImageView) view.findViewById(R.id.tvlstrand_slide_image);
        tvlSlideImageView.setImageResource(tvlstrand_slide_images[position]);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
