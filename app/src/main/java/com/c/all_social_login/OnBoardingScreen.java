package com.c.all_social_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotLayout;

    TextView[] mDots;

    SliderAdapter sliderAdapter;

    Button btn_prev,btn_next,btn_skip;

    int mCurrentPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording_screen);
        getSupportActionBar().hide();

        slideViewPager=findViewById(R.id.slideViewPager);
        dotLayout=findViewById(R.id.dotLayout);
        btn_prev=(Button) findViewById(R.id.btn_prev);
        btn_next=(Button) findViewById(R.id.btn_next);
        btn_skip=(Button) findViewById(R.id.btn_Skip);

        dotLayout=findViewById(R.id.dotLayout);

        sliderAdapter= new SliderAdapter(this);

        slideViewPager.setAdapter(sliderAdapter);
        addDotIndicator(0);

        slideViewPager.addOnPageChangeListener(onPageChangeListener);
    }

    public void addDotIndicator(int position){
        mDots = new TextView[4];
        dotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentwhite));

            dotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    ViewPager.OnPageChangeListener onPageChangeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            mCurrentPage= position;
            if(position == 0){
                btn_next.setEnabled(true);
                btn_prev.setEnabled(false);
                btn_prev.setVisibility(View.INVISIBLE);

                btn_prev.setText("Next");

            } else if (position == mDots.length - 1) {
                btn_next.setEnabled(true);
                btn_prev.setEnabled(true);
                btn_prev.setVisibility(View.VISIBLE);

                btn_next.setText("Finish");
                btn_next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OnBoardingScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            } else{
                btn_next.setEnabled(true);
                btn_prev.setEnabled(true);
                btn_prev.setVisibility(View.VISIBLE);

                btn_next.setText("Next");
                btn_prev.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}