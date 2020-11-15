package com.example.teachely.Views.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.teachely.R;
import com.example.teachely.RecyclerView.StudentAdapter;
import com.example.teachely.Views.Activitys.Fragments.MainFragments.StudentFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_ACTIVITY = 15;
    private TextView tvUserName;
    private MaterialButton btnGrade;
    private ExtendedFloatingActionButton fabAddStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentTransaction();
    }

    private void initViews(){
        tvUserName=findViewById(R.id.tv_main_username);
        btnGrade=findViewById(R.id.btn_main_grade);
        fabAddStudent=findViewById(R.id.fab_main_AddStudent);
        fabAddStudent.setOnClickListener(this);
        btnGrade.setOnClickListener(this);
    }
    private void fragmentTransaction(){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_main_container,new StudentFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_main_grade:
                break;
            case R.id.fab_main_AddStudent:
                Intent intent =new Intent(MainActivity.this,AddStudentActivity.class);
                startActivityForResult(intent,REQUEST_ACTIVITY);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}