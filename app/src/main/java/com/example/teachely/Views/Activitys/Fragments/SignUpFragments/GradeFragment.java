package com.example.teachely.Views.Activitys.Fragments.SignUpFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.teachely.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class GradeFragment extends Fragment implements View.OnClickListener {

    private MaterialButton btnSignUp;
    private MaterialButton btnBack;
    private ChipGroup cgGrade;
    private ChipGroup cgSchoolGrade;
    private ChipGroup cgElementary;
    private ChipGroup cgMiddle;
    private ChipGroup cgHigh;
    private ChipGroup cgStudy;
    private TextInputLayout etlSchoolName;
    private TextInputEditText etSchoolName;
    private TextView tvSchoolDec;
    private TextView tvStudyDec;
    private String schoolName;
    private String grade;
    private String elementaryFoundation;
    private String middleFoundation;
    private String highFoundation;
    private String studyLesson;
    private TextView tvNameSchoolTitle;
    private OnReceiveSchoolName receiveSchoolName;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        receiveSchoolName = (OnReceiveSchoolName) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initializeChipGroups();

    }

    private void initializeChipGroups() {
        cgGrade.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.chip_grade_elementarySchool:
                        cgMiddle.setVisibility(View.GONE);
                        tvStudyDec.setVisibility(View.GONE);
                        cgHigh.setVisibility(View.GONE);
                        cgStudy.setVisibility(View.GONE);
                        tvSchoolDec.setVisibility(View.VISIBLE);
                        cgElementary.setVisibility(View.VISIBLE);
                        tvNameSchoolTitle.setVisibility(View.VISIBLE);
                        etlSchoolName.setVisibility(View.VISIBLE);
                        grade = "دبستان";
                        break;
                    case R.id.chip_grade_middleSchool:
                        tvStudyDec.setVisibility(View.GONE);
                        cgHigh.setVisibility(View.GONE);
                        cgStudy.setVisibility(View.GONE);
                        cgElementary.setVisibility(View.GONE);
                        tvSchoolDec.setVisibility(View.VISIBLE);
                        cgMiddle.setVisibility(View.VISIBLE);
                        etlSchoolName.setVisibility(View.VISIBLE);
                        tvNameSchoolTitle.setVisibility(View.VISIBLE);
                        grade = "متوسطه دوره اول";
                        break;
                    case R.id.chip_grade_highSchool:
                        tvSchoolDec.setVisibility(View.GONE);
                        cgMiddle.setVisibility(View.GONE);
                        cgElementary.setVisibility(View.GONE);
                        tvSchoolDec.setVisibility(View.VISIBLE);
                        tvStudyDec.setVisibility(View.VISIBLE);
                        cgHigh.setVisibility(View.VISIBLE);
                        cgStudy.setVisibility(View.VISIBLE);
                        etlSchoolName.setVisibility(View.VISIBLE);
                        tvNameSchoolTitle.setVisibility(View.VISIBLE);
                        grade = "متوسطه دوره دوم";
                        break;
                }
            }
        });
        cgElementary.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chip_grade_elementary1:
                        elementaryFoundation = "اول ابتدایی";
                        break;
                    case R.id.chip_grade_elementary2:
                        elementaryFoundation = "دوم ابتدایی";
                        break;
                    case R.id.chip_grade_elementary3:
                        elementaryFoundation = "سوم ابتدایی";
                        break;
                    case R.id.chip_grade_elementary4:
                        elementaryFoundation = "چهارم ابتدایی";
                        break;
                    case R.id.chip_grade_elementary5:
                        elementaryFoundation = "پنجم ابتدایی";
                        break;
                    case R.id.chip_grade_elementary6:
                        elementaryFoundation = "ششم ابتدایی";
                        break;

                }
            }
        });
        cgMiddle.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chip_grade_MiddleSchool1:
                        middleFoundation = "هفتم";
                        break;
                    case R.id.chip_grade_MiddleSchool2:
                        middleFoundation = "هشتم";
                        break;
                    case R.id.chip_grade_MiddleSchool3:
                        middleFoundation = "نهم";
                        break;
                }
            }
        });
        cgHigh.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chip_grade_HighSchool1:
                        highFoundation = "دهم";
                        break;
                    case R.id.chip_grade_HighSchool2:
                        highFoundation = "یازدهم";
                        break;
                    case R.id.chip_grade_HighSchool3:
                        highFoundation = "دوازدهم";
                        break;
                }
            }
        });
        cgStudy.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chip_grade_literatureStudy:
                        studyLesson = "ادبیات";
                        break;
                    case R.id.chip_grade_MathStudy:
                        studyLesson = "ریاضی";
                        break;
                    case R.id.chip_grade_ScienceStudy:
                        studyLesson = "تجربی";
                        break;
                }
            }
        });
    }

    private void initViews(View view) {
        btnSignUp = view.findViewById(R.id.btn_grade_signup);
        btnBack = view.findViewById(R.id.btn_grade_back);
        cgGrade = view.findViewById(R.id.cg_grade_grade);
        cgSchoolGrade = view.findViewById(R.id.cg_grade_GradeSchool);
        cgStudy = view.findViewById(R.id.cg_grade_Study);
        etlSchoolName = view.findViewById(R.id.etl_grade_SchoolName);
        etSchoolName = view.findViewById(R.id.et_grade_SchoolName);
        cgElementary = view.findViewById(R.id.cg_grade_elementarySchool);
        cgMiddle = view.findViewById(R.id.cg_grade_middleSchool);
        cgHigh = view.findViewById(R.id.cg_grade_highSchool);
        tvSchoolDec = view.findViewById(R.id.tv_grade_decSchool);
        tvStudyDec = view.findViewById(R.id.tv_grade_decStudy);
        tvNameSchoolTitle = view.findViewById(R.id.tv_grade_SchoolName);
        btnSignUp.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_grade_signup:
                if (etSchoolName.getText().length() == 0) {
                    etlSchoolName.setError("لطفا نام مدرسه را وارد کنید!");
                } else {
                    schoolName = etSchoolName.getText().toString();
                    receiveSchoolName.onSchoolNameReceive(schoolName);
                    receiveSchoolName.onEducationReceive(grade, elementaryFoundation, middleFoundation, highFoundation, studyLesson);
                }
                break;
            case R.id.btn_grade_back:
                if (getFragmentManager() != null)
                    getFragmentManager().popBackStack();
                break;
        }
    }

    public interface OnReceiveSchoolName {
        void onSchoolNameReceive(String schoolName);

        void onEducationReceive(String grade, String elementaryFoundation
                , String middleFoundation, String highFoundation, String studyLesson);
    }

}
