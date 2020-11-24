package com.example.teachely.SignUp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.teachely.Model.SharedPrefernce.SharePrefsKey;
import com.example.teachely.Model.SharedPrefernce.UserManager;
import com.example.teachely.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TeacherInformationFragment extends Fragment implements View.OnClickListener {
    private TextInputLayout etlFirstName;
    private TextInputLayout etlLastName;
    private TextInputLayout etlAge;
    private TextInputEditText etFirstName;
    private TextInputEditText etLastName;
    private TextInputEditText etAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    private UserManager userManager;
    private MaterialButton btnNext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_information_signup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        userManager = new UserManager(view.getContext());
    }

    private void initViews(View view) {
        etlFirstName = view.findViewById(R.id.etl_teacherI_FirstName);
        etlLastName = view.findViewById(R.id.etl_teacherI_LastName);
        etlAge = view.findViewById(R.id.etl_teacherI_Age);
        etFirstName = view.findViewById(R.id.et_teacherI_FirstName);
        etLastName = view.findViewById(R.id.et_teacherI_LastName);
        etAge = view.findViewById(R.id.et_teacherI_Age);
        radioGroupGender = view.findViewById(R.id.radioGroup_teacherI_gender);
        radioMale = view.findViewById(R.id.radioButton_teacherI_male);
        radioFemale = view.findViewById(R.id.radioButton_teacher_female);
        btnNext = view.findViewById(R.id.btn_teacherI_next);
        btnNext.setOnClickListener(this);

    }

    private void checkGenderNullable() {
        radioMale.setChecked(true);
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_teacherI_male:
                        userManager.saveStringField(SharePrefsKey.GENDER_KEY, "آقا");
                        break;
                    case R.id.radioButton_teacher_female:
                        userManager.saveStringField(SharePrefsKey.GENDER_KEY, "خانم");
                        break;
                }
            }
        });
    }

    private boolean checkFieldNullable() {
        if (etFirstName.getText().length() > 0 && etLastName.getText().length() > 0 && etAge.getText().length() > 0)
            return false;
        return true;
    }

    private boolean alertFieldAndSaveThen() {
        if (checkFieldNullable()) {
            if (etFirstName.getText().length() == 0) {
                etlFirstName.setError("لطفا نام خود را وارد نمایید!");
                if (etLastName.getText().length() == 0) {
                    etlLastName.setError("لطفا نام خانوادگی خود را وارد نمایید!");
                    if (etAge.getText().length() == 0) {
                        etlAge.setError("لطفا سن خود را وارد نمایید!");
                        return false;
                    }
                }
            }
        } else {
            userManager.saveStringField(SharePrefsKey.FIRST_NAME_KEY, etFirstName.getText().toString());
            userManager.saveStringField(SharePrefsKey.LAST_NAME_KEY, etLastName.getText().toString());
            userManager.saveStringField(SharePrefsKey.AGE_KEY, etAge.getText().toString());
            checkGenderNullable();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_teacherI_next:
                if (alertFieldAndSaveThen()) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_signUp_container, new SchoolInformationFragment());
                    transaction.commit();
                }
                break;
        }
    }
}
