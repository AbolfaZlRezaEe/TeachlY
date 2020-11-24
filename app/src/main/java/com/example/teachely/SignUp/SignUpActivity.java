package com.example.teachely.SignUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.teachely.Main.MainActivity;
import com.example.teachely.Model.SharedPrefernce.SharePrefsKey;
import com.example.teachely.Model.SharedPrefernce.UserManager;
import com.example.teachely.R;
import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity implements SchoolInformationFragment.OnDetachFragment {

    private View relative;
    private View frame;
    private LottieAnimationView animationSuccess;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fragmentContainer();
        userManager = new UserManager(this);
        relative = findViewById(R.id.relative_signUp);
        frame = findViewById(R.id.frame_signUp_container);
        animationSuccess = findViewById(R.id.animation_success);
    }

    private void fragmentContainer() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_signUp_container, new TeacherInformationFragment());
        transaction.commit();
    }

    private void checkRemoveFragment() {
            relative.setVisibility(View.GONE);
            frame.setVisibility(View.GONE);
            animationSuccess.setVisibility(View.VISIBLE);
            animationSuccess.addAnimatorListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
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

    @Override
    public void onDetach(boolean click) {
        if (click)
            if (userManager.getStringField(SharePrefsKey.GRADE_KEY) != null)
                checkRemoveFragment();
    }
}

