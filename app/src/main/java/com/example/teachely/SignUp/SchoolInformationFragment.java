package com.example.teachely.SignUp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

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

public class SchoolInformationFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SchoolInformationFragme";
    private TextView tvUserName;
    private TextInputLayout etlSchoolName;
    private TextInputLayout etlGrade;
    private TextInputLayout etlAcademicYear;
    private TextInputLayout etlField;
    private TextInputEditText etSchoolName;
    private AutoCompleteTextView completeTextViewGrade;
    private AutoCompleteTextView completeTextViewAcademicYear;
    private AutoCompleteTextView completeTextViewField;
    private UserManager userManager;
    private String grade;
    private String selection;
    private MaterialButton btnNext;
    private OnDetachFragment onDetachFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onDetachFragment = (OnDetachFragment) context;
    }

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
        userManager = new UserManager(view.getContext());
        String firstName = userManager.getStringField(SharePrefsKey.FIRST_NAME_KEY);
        String lastName = userManager.getStringField(SharePrefsKey.LAST_NAME_KEY);
        if (!firstName.isEmpty() && !lastName.isEmpty())
            tvUserName.setText("خوش آمدید " + firstName + " " + lastName);
        initializeAutoCompleteTextViews();
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
        btnNext = view.findViewById(R.id.btn_schoolI_next);
        btnNext.setOnClickListener(this);
    }

    private void initializeAutoCompleteTextViews() {
        String[] gradeList = new String[]{"پیش دبستان", "ابتدایی", "متوسطه اول", "متوسطه دوم"};
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_autocompletetextview, gradeList);
        completeTextViewGrade.setAdapter(gradeAdapter);
        completeTextViewGrade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection = (String) parent.getItemAtPosition(position);
                userManager.saveStringField(SharePrefsKey.GRADE_KEY, selection);
                Log.i(TAG, "onItemSelected: " + selection);
                checkingGradeInformation();
            }
        });
    }

    private void checkingGradeInformation() {
        if (selection != null)
            switch (selection) {
                case "ابتدایی":
                    String[] academicYearList1 = new String[]{"اول", "دوم", "سوم", "چهارم", "پنجم", "ششم"};
                    ArrayAdapter<String> academicYearAdapter1 = new ArrayAdapter<String>(getContext(), R.layout.item_autocompletetextview, academicYearList1);
                    completeTextViewAcademicYear.setAdapter(academicYearAdapter1);
                    completeTextViewAcademicYear.clearListSelection();
                    completeTextViewAcademicYear.setOnItemClickListener(((parent, view, position, id) -> {
                        String academicYear = (String) parent.getItemAtPosition(position);
                        if (academicYear != null)
                            userManager.saveStringField(SharePrefsKey.ACADEMIC_YEAR_KEY, academicYear);
                    }));
                    etlAcademicYear.setVisibility(View.VISIBLE);
                    break;
                case "متوسطه اول":
                    String[] academicYearList2 = new String[]{"هفتم", "هشتم", "نهم"};
                    ArrayAdapter<String> academicYearAdapter2 = new ArrayAdapter<String>(getContext(), R.layout.item_autocompletetextview, academicYearList2);
                    completeTextViewAcademicYear.setAdapter(academicYearAdapter2);
                    completeTextViewAcademicYear.clearListSelection();
                    completeTextViewAcademicYear.setOnItemClickListener(((parent, view, position, id) -> {
                        String academicYear = (String) parent.getItemAtPosition(position);
                        if (academicYear != null)
                            userManager.saveStringField(SharePrefsKey.ACADEMIC_YEAR_KEY, academicYear);
                    }));
                    etlAcademicYear.setVisibility(View.VISIBLE);
                    break;
                case "متوسطه دوم":
                    String[] academicYearList3 = new String[]{"دهم", "یازدهم", "دوازدهم"};
                    ArrayAdapter<String> academicYearAdapter3 = new ArrayAdapter<String>(getContext(), R.layout.item_autocompletetextview, academicYearList3);
                    completeTextViewAcademicYear.setAdapter(academicYearAdapter3);
                    completeTextViewAcademicYear.clearListSelection();
                    etlAcademicYear.setVisibility(View.VISIBLE);
                    completeTextViewAcademicYear.setOnItemClickListener(((parent, view, position, id) -> {
                        String academicYear = (String) parent.getItemAtPosition(position);
                        if (academicYear != null)
                            userManager.saveStringField(SharePrefsKey.ACADEMIC_YEAR_KEY, academicYear);
                    }));
                    String[] fieldList = new String[]{"ریاضی", "فارسی", "ادبیات"};
                    ArrayAdapter<String> FieldAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_autocompletetextview, fieldList);
                    completeTextViewField.setAdapter(FieldAdapter);
                    etlField.setVisibility(View.VISIBLE);
                    completeTextViewField.setOnItemClickListener((parent, view, position, id) -> {
                        String field = (String) parent.getItemAtPosition(position);
                        if (field != null)
                            userManager.saveStringField(SharePrefsKey.SCHOOL_FIELD_KEY, field);
                    });
                    break;
            }
        grade = userManager.getStringField(SharePrefsKey.GRADE_KEY);
    }

    private boolean checkFieldNullable() {
        if (etSchoolName.getText().length() > 0 && completeTextViewGrade.enoughToFilter() && (grade.equals("پیش دبستان") || grade.equals("ابتدایی") ||
                grade.equals("متوسطه اول") || grade.equals("متوسطه دوم")))
            return false;
        return true;
    }

    private boolean alertFilterAndSaveThen() {
        if (checkFieldNullable()) {
            if (etSchoolName.getText().length() == 0) {
                etlSchoolName.setError("لطفا نام مدرسه را وارد نمایید!");
                if (!completeTextViewGrade.enoughToFilter()) {
                    etlGrade.setError("لطفا پایه تحصیلی را وارد نمایید!");
                    if (grade.equals("ابتدایی") || grade.equals("متوسطه اول") || grade.equals("متوسطه دوم")) {
                        etlAcademicYear.setError("لطفا پایه تحصیلی را وارد نمایید!");
                        if (grade.equals("متوسطه دوم"))
                            etlField.setError("لطفا رشته تحصیلی را وارد نمایید!");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_schoolI_next:
                if (alertFilterAndSaveThen()) {
                    userManager.saveStringField(SharePrefsKey.SCHOOL_NAME_KEY,etSchoolName.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                }
                break;
        }
    }

    public interface OnDetachFragment {
        void onDetach(boolean click);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDetachFragment.onDetach(true);
    }
}
