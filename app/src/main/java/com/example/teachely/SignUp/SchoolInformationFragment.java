package com.example.teachely.SignUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.teachely.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SchoolInformationFragment extends Fragment {
    private TextView tvUserName;
    private TextInputLayout etlSchoolName;
    private TextInputLayout etlGrade;
    private TextInputLayout etlAcademicYear;
    private TextInputLayout etlField;
    private TextInputEditText etSchoolName;
    private AutoCompleteTextView completeTextViewGrade;
    private AutoCompleteTextView completeTextViewAcademicYear;
    private AutoCompleteTextView completeTextViewField;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school_information_signup, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        tvUserName = view.findViewById(R.id.tv_schoolI_Username);
        etlSchoolName = view.findViewById(R.id.etl_schoolI_SchoolName);
        etSchoolName = view.findViewById(R.id.et_schoolI_SchoolName);
        etlGrade = view.findViewById(R.id.etl_schoolI_grade);
        etlAcademicYear = view.findViewById(R.id.etl_schoolI_academicYear);
        etlField = view.findViewById(R.id.etl_schoolI_field);
        completeTextViewGrade = view.findViewById(R.id.autoComplete_schoolI_grade);
        completeTextViewAcademicYear = view.findViewById(R.id.autoComplete_schoolI_academicYear);
        completeTextViewField = view.findViewById(R.id.autoComplete_schoolI_field);
    }
}
