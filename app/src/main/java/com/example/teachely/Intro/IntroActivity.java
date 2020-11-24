package com.example.teachely.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.teachely.Main.MainActivity;
import com.example.teachely.Model.SharedPrefernce.SharePrefsKey;
import com.example.teachely.R;
import com.example.teachely.Model.SharedPrefernce.UserManager;
import com.example.teachely.SignUp.SignUpActivity;
import com.google.android.material.button.MaterialButton;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private MaterialButton btnNext;
    private MaterialButton btnSkip;
    private LinearLayout linearLayout;
    private IntroViewPagerAdapter introViewPagerAdapter;
    private TextView[] dots;
    private int currentPage = 0;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        userManager = new UserManager(this);
        if(userManager.getStringField(SharePrefsKey.GRADE_KEY)!=null){
            Intent intent=new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
        }
        initViews();
        introViewPagerAdapter = new IntroViewPagerAdapter(this);
        viewPager.setAdapter(introViewPagerAdapter);
        dotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager_intro);
        btnNext = findViewById(R.id.btn_intro_next);
        btnSkip = findViewById(R.id.btn_intro_skip);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout_intro);
        introViewPagerAdapter = new IntroViewPagerAdapter(this);
        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
    }

    public void dotsIndicator(int position) {
        dots = new TextView[3];
        linearLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(40);
            dots[i].setTextColor(getResources().getColor(R.color.gray500));
            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.gray900));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            dotsIndicator(position);
            currentPage = position;

            if (position == dots.length - 1) {
                btnNext.setIconResource(R.drawable.ic_done_black_18dp);
                btnNext.setIconTint(ColorStateList.valueOf(getResources().getColor(android.R.color.white)));
            } else {
                btnNext.setIconResource(R.drawable.ic_arrow_next_black_18dp);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intro_next:
                if (currentPage == dots.length - 1) {
                    Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    currentPage++;
                    viewPager.setCurrentItem(currentPage);
                }
                break;
            case R.id.btn_intro_skip:
                Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}