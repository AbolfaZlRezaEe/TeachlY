package com.example.teachely.Views.Activitys.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachely.DataBaseManager.AppDataBase;
import com.example.teachely.DataBaseManager.StudentDao;
import com.example.teachely.Model.Student;
import com.example.teachely.R;
import com.example.teachely.RecyclerView.StudentAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> students = new ArrayList<>();
    private StudentDao studentDao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       initializeRecyclerView(view);
    }

    private void initializeRecyclerView(View view){
        recyclerView = view.findViewById(R.id.rv_studentFragment);
        studentDao = AppDataBase.getAppDataBase(getContext()).getStudentDao();
        students = studentDao.getStudents();
        studentAdapter = new StudentAdapter(students);
    }

}
