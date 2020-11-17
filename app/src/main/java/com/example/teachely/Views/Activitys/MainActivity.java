package com.example.teachely.Views.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachely.DataBaseManager.AppDataBase;
import com.example.teachely.DataBaseManager.StudentDao;
import com.example.teachely.Model.Student;
import com.example.teachely.R;
import com.example.teachely.RecyclerView.StudentAdapter;
import com.example.teachely.SharedPrefernce.SharePrefsKey;
import com.example.teachely.SharedPrefernce.UserManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_RESULT = 290;
    public static final String REQUEST_CALL_BACK = "CallBack";
    private TextView tvUserName;
    private MaterialButton btnGrade;
    private ExtendedFloatingActionButton fabAddStudent;
    private StudentAdapter studentAdapter;
    private StudentDao studentDao;
    private UserManager userManager;
    private RecyclerView recyclerView;
    private TextView tvNoStudent;
    private ImageView ivNoStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        userManager = new UserManager(this);
        studentDao = AppDataBase.getAppDataBase(this).getStudentDao();
        studentAdapter = new StudentAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(studentAdapter);
        List<Student> students = studentDao.getStudents();
        studentAdapter.addAll(students);
        if (students.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            ivNoStudent.setVisibility(View.VISIBLE);
            tvNoStudent.setVisibility(View.VISIBLE);
        }
        initializeUserInformation();
    }

    private void initViews() {
        tvUserName = findViewById(R.id.tv_main_username);
        recyclerView = findViewById(R.id.rv_main);
        btnGrade = findViewById(R.id.btn_main_grade);
        fabAddStudent = findViewById(R.id.fab_main_AddStudent);
        tvNoStudent = findViewById(R.id.tv_main_noStudent);
        ivNoStudent = findViewById(R.id.iv_main_noStudent);
        fabAddStudent.setOnClickListener(this);
        btnGrade.setOnClickListener(this);
    }


    private void initializeUserInformation() {
        String userName = userManager.getFirstName() + " " + userManager.getLastName();
        tvUserName.setText(userName);
        String grade = userManager.getStringField(SharePrefsKey.GRADE_KEY);
        btnGrade.setText(grade);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_grade:
                break;
            case R.id.fab_main_AddStudent:
                Intent intent = new Intent(MainActivity.this, StudentDetails.class);
                startActivityForResult(intent, REQUEST_RESULT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_RESULT && resultCode == RESULT_OK && data != null) {
            Student student = data.getParcelableExtra(REQUEST_CALL_BACK);
            if (student != null) {
                studentDao.addStudent(student);
                studentAdapter.addStudent(student);
            } else
                Toast.makeText(this, "خطای نامشخص!", Toast.LENGTH_SHORT).show();

        }
    }
}