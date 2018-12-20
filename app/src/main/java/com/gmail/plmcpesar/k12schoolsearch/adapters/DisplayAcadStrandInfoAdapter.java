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

public class DisplayAcadStrandInfoAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public DisplayAcadStrandInfoAdapter (Context context){
        this.context = context;
    }

    public int[] acadstrand_slide_images = {
            R.drawable.acadstrand_flipimage1,
            R.drawable.acadstrand_flipimage2,
            R.drawable.acadstrand_flipimage3,
            R.drawable.acadstrand_flipimage4
    };

    @Override
    public int getCount() {
        return acadstrand_slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.acadstrand_slide_layout, container, false);

        ImageView acadSlideImageView = (ImageView) view.findViewById(R.id.acadstrand_slide_image);
        acadSlideImageView.setImageResource(acadstrand_slide_images[position]);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
