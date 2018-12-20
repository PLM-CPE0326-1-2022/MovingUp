package com.gmail.plmcpesar.k12schoolsearch.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gmail.plmcpesar.k12schoolsearch.R;

public class DisplayArtsAndDesignIStrandInfoAdapter extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;

    public DisplayArtsAndDesignIStrandInfoAdapter(Context context){
        this.context = context;
    }

    public int[] artsanddesign_slide_images = {
            R.drawable.artsanddesignstrand_flipimage1,
            R.drawable.artsanddesignstrand_flipimage2,
            R.drawable.artsanddesignstrand_flipimage3
    };
    @Override
    public int getCount() {
        return artsanddesign_slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.artsanddesign_slide_layout, container, false);

        ImageView artsanddesignSlideImageView = (ImageView) view.findViewById(R.id.artsanddesignstrand_slide_image);
       artsanddesignSlideImageView.setImageResource(artsanddesign_slide_images[position]);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
