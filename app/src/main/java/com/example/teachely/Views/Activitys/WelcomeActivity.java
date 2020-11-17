package com.example.teachely.Views.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.teachely.R;
import com.example.teachely.SharedPrefernce.SharePrefsKey;
import com.example.teachely.SharedPrefernce.UserManager;
import com.example.teachely.Views.Activitys.Fragments.SignUpFragments.GradeFragment;
import com.example.teachely.Views.Activitys.Fragments.SignUpFragments.SignUpFragment;
import com.example.teachely.Views.Activitys.Fragments.SignUpFragments.WelcomeFirstFragment;

public class WelcomeActivity extends AppCompatActivity implements SignUpFragment.OnReceiveInformation
        , GradeFragment.OnReceiveSchoolName {

    private String firstName;
    private String lastName;
    private int age;
    private LottieAnimationView animationView;
    private FrameLayout frameContainer;
    private TextView tvMassage;
    private String gender;
    private UserManager userManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        userManager = new UserManager(this);
        if (userManager.checkInformation()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        fragmentTransaction();
        animationView = findViewById(R.id.lottie_welcome_success);
        frameContainer = findViewById(R.id.frame_welcome_container);
        tvMassage = findViewById(R.id.tv_welcome_successMassage);
        userManager = new UserManager(this);
    }

    private void fragmentTransaction() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_welcome_container, new WelcomeFirstFragment());
        transaction.commit();
    }

    @Override
    public void onReceived(String firstName, String lastName, int age, String gender) {
        if (firstName != null && lastName != null && age != 0) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }
    }

    @Override
    public void onSchoolNameReceive(String schoolName) {
        if (schoolName != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_welcome_container);
            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
            }
            frameContainer.setVisibility(View.GONE);
            animationView.setVisibility(View.VISIBLE);
            tvMassage.setVisibility(View.VISIBLE);
            animationView.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    userManager.saveUserInformation(firstName, lastName, schoolName, gender, age);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        }
    }

    @Override
    public void onEducationReceive(String grade, String elementaryFoundation, String middleFoundation, String highFoundation, String studyLesson) {
        if (grade != null)
            userManager.saveStringField(SharePrefsKey.GRADE_KEY, grade);
        if (elementaryFoundation != null)
            userManager.saveStringField(SharePrefsKey.ELEMENTARY_KEY, elementaryFoundation);
        if (middleFoundation != null)
            userManager.saveStringField(SharePrefsKey.MIDDLE_KEY, middleFoundation);
        if (highFoundation != null)
            userManager.saveStringField(SharePrefsKey.HIGH_KEY, highFoundation);
        if (studyLesson != null)
            userManager.saveStringField(SharePrefsKey.LESSON_KEY, studyLesson);
    }

}