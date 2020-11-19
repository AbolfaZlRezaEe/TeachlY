package com.example.teachely.SignUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.teachely.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TeacherInformationFragment extends Fragment {
    private TextInputLayout etlFirstName;
    private TextInputLayout etlLastName;
    private TextInputLayout etlAge;
    private TextInputEditText etFirstName;
    private TextInputEditText etLastName;
    private TextInputEditText etAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale;
    private RadioButton radioFemale;

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

    }
}
