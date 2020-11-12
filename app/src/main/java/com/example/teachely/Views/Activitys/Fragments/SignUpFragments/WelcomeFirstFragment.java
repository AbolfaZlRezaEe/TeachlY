package com.example.teachely.Views.Activitys.Fragments.SignUpFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.teachely.R;
import com.google.android.material.button.MaterialButton;

public class WelcomeFirstFragment extends Fragment implements View.OnClickListener {

    private MaterialButton signUpBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcomefirst,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signUpBtn=view.findViewById(R.id.btn_welcomefirst_signUp);
        signUpBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_welcomefirst_signUp:
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_welcome_container,new SignUpFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }
}
