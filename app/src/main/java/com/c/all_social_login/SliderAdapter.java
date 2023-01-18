package com.c.all_social_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_image = {
            R.drawable.easy,
            R.drawable.medium,
            R.drawable.hard,
            R.drawable.expert,
    };

    public String[] slide_Heading = {
            "Easy",
            "Medium",
            "Hard",
            "Expert",
    };

    public String[] slide_description = {
            "There are many variations of passages of Lorem Ipsum available , There are many variations of passages of Lorem Ipsum available" + "," + "Easy",
            "There are many variations of passages of Lorem Ipsum available , There are many variations of passages of Lorem Ipsum available" + "," + "Medium",
            "There are many variations of passages of Lorem Ipsum available , There are many variations of passages of Lorem Ipsum available" + "," + "Hard",
            "There are many variations of passages of Lorem Ipsum available , There are many variations of passages of Lorem Ipsum available" + "," + "Expert",
    };

    @Override
    public int getCount() {
        return slide_Heading.length;
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

        ImageView image_view = (ImageView) view.findViewById(R.id.image_view);
        TextView heading_TextView = (TextView) view.findViewById(R.id.heading_TextView);
        TextView text_description = (TextView) view.findViewById(R.id.text_description);

        image_view.setImageResource(slide_image[position]);
        heading_TextView.setText(slide_Heading[position]);
        text_description.setText(slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
