package com.example.teachely.Views.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.teachely.DataBaseManager.AppDataBase;
import com.example.teachely.DataBaseManager.StudentDao;
import com.example.teachely.Model.Student;
import com.example.teachely.R;
import com.example.teachely.RecyclerView.StudentAdapter;
import com.example.teachely.SharedPrefernce.SharePrefsKey;
import com.example.teachely.SharedPrefernce.UserManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class StudentDetails extends AppCompatActivity implements View.OnClickListener {

    private String[] schoolArray;
    private String[] gradeArray;
    private UserManager userManager;
    private TextInputLayout etlFirstName;
    private TextInputLayout etlLastName;
    private TextInputLayout etlSchoolName;
    private TextInputLayout etlGrade;
    private TextInputLayout etlAge;
    private TextInputLayout etlNationalityCode;
    private TextInputLayout etlPhoneNumber;
    private TextInputEditText etFirstName;
    private TextInputEditText etLastName;
    private TextInputEditText etNationalityCode;
    private TextInputEditText etPhoneNumber;
    private AutoCompleteTextView ctvSchoolName;
    private AutoCompleteTextView ctvGrade;
    private TextInputEditText etAge;
    private FloatingActionButton fabDone;
    private MaterialButton btnBack;
    private MaterialButton btnDelete;
    private String school;
    private String grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdetails);
        userManager = new UserManager(this);
        initViews();
        initializeCTV();
    }

    private void initViews() {
        etlFirstName = findViewById(R.id.etl_studentDetails_firstName);
        etlLastName = findViewById(R.id.etl_studentDetails_lastName);
        etlSchoolName = findViewById(R.id.etl_studentDetails_schoolName);
        etlGrade = findViewById(R.id.etl_studentDetails_Grade);
        etlAge = findViewById(R.id.etl_studentDetails_age);
        etlNationalityCode = findViewById(R.id.etl_studentDetails_nationalityCode);
        etlPhoneNumber = findViewById(R.id.etl_studentDetails_phoneNumber);
        etFirstName = findViewById(R.id.et_studentDetails_firstName);
        etLastName = findViewById(R.id.et_studentDetails_lastName);
        etNationalityCode = findViewById(R.id.et_studentDetails_nationalityCode);
        etPhoneNumber = findViewById(R.id.et_studentDetails_phoneNumber);
        ctvSchoolName = findViewById(R.id.ctv_studentDetails_schoolName);
        etAge = findViewById(R.id.et_studentDetails_age);
        fabDone = findViewById(R.id.fab_studentDetails);
        btnBack = findViewById(R.id.btn_addStudent_back);
        btnDelete = findViewById(R.id.btn_addStudent_delete);
        ctvGrade = findViewById(R.id.ctv_studentDetails_grade);
        btnBack.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        fabDone.setOnClickListener(this);

    }

    private void initializeCTV() {
        //initialize SchoolName Adapter
        schoolArray = new String[]{userManager.getFirstName()};
        ArrayAdapter<String> schoolAdapter = new ArrayAdapter<String>(this, R.layout.school_item, schoolArray);
        ctvSchoolName.setAdapter(schoolAdapter);
        //initialize Grade Adapter
        gradeArray = new String[]{userManager.getStringField(SharePrefsKey.GRADE_KEY)};
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(this, R.layout.grade_item, gradeArray);
        ctvGrade.setAdapter(gradeAdapter);
        ctvSchoolName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ctvGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void showErrorInTextInputLayout() {
        if (etFirstName.getText().length() < 0)
            etlFirstName.setError("لطفا نام دانش آموز را وارد نمایید!");
        if (etLastName.getText().length() < 0)
            etlLastName.setError("لطفا نام خانوادگی دانش آموز را وارد نمایید!");
        if (!ctvSchoolName.enoughToFilter())
            etlSchoolName.setError("لطفا نام مدرسه داش آموز را انتخاب نمایید!");
        if (!ctvGrade.enoughToFilter())
            etlGrade.setError("لطفا مقطع تحصیلی دانش آموز را انتخاب نمایید!");
        if (etAge.getText().length() < 0)
            etlAge.setError("لطفا سن دانش آموز را وارد نمایید!");
        if (etNationalityCode.getText().length() < 0)
            etlNationalityCode.setError("لطفا کد ملی دانش آموز را وارد نمایید!");
        if (etPhoneNumber.getText().length() < 0)
            etlPhoneNumber.setError("لطفا تلفن همراه دانش آموز را وارد نمایید!");
    }

    private boolean checkingNullTextInput() {
        if (etFirstName.getText().length() > 0 && etLastName.getText().length() > 0 && ctvSchoolName.enoughToFilter() && etAge.getText().length() > 0
                && ctvGrade.enoughToFilter() && etNationalityCode.getText().length() > 0 && etPhoneNumber.getText().length() > 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_studentDetails:
                if (checkingNullTextInput()) {
                    showErrorInTextInputLayout();
                    return;
                }
                Student student = new Student();
                student.setFirstName(etFirstName.getText().toString());
                student.setLastName(etLastName.getText().toString());
                student.setSchoolName(school);
                student.setGrade(grade);
                student.setAge(Integer.parseInt(etAge.getText().toString()));
                student.setNationalityCode(Integer.parseInt(etNationalityCode.getText().toString()));
                student.setPhoneNumber(etPhoneNumber.getText().toString());
                Intent intent = new Intent(StudentDetails.this, MainActivity.class);
                intent.putExtra(MainActivity.REQUEST_CALL_BACK, student);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_addStudent_back:
                onBackPressed();
                break;
            case R.id.btn_addStudent_delete:
                break;
        }
    }

}
