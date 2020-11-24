package com.example.teachely.Intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.teachely.R;

public class IntroViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;

    public IntroViewPagerAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_Image = {
            R.drawable.background_welcome_one,
            R.drawable.background_welcome_two,
            R.drawable.background_welcome_three
    };

    public String[] slide_heading = {
            "تیچلی",
            "مدیریت دانش آموزان",
            "نمرات امتحانات و تکالیف"
    };

    public String[] slide_description = {
            "به تیچلی خوش آمدید. \n تیچلی به شما امکان مدیریت دانش آموزان شما را می دهد \n و سعی در آسان تر کردن مدیریت دانش آموزان شما را دارد",
            "شما می توانید دانش آموزان خود را با استفاده از مقطع و رشته \n مرتب سازی کنید",
            "امتحانات و تکالیف دانش آموزان خود را \n می توانید در بخش تکالیف مدیریت کرده و ثبت نمایید\n و حتی میانگین نمرات آنها را به دست بیاورید."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_intro, container, false);

        ImageView ivIntro = view.findViewById(R.id.iv_layoutIntro);
        TextView tvTitle = view.findViewById(R.id.tv_layoutIntro_Title);
        TextView tvDec = view.findViewById(R.id.tv_layoutIntro_dec);

        ivIntro.setImageResource(slide_Image[position]);
        tvTitle.setText(slide_heading[position]);
        tvDec.setText(slide_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
