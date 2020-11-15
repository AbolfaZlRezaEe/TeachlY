package com.example.teachely.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachely.Model.Student;
import com.example.teachely.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students = new ArrayList<>();

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bindStudent(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView grade;
        private TextView score;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_studentItem_username);
            grade = itemView.findViewById(R.id.tv_studentItem_Grade);
            score = itemView.findViewById(R.id.tv_studentItem_score);
        }

        public void bindStudent(Student student) {
            String fullName = student.getFirstName() + student.getLastName();
            name.setText(fullName);
            grade.setText(student.getGrade());
            score.setText(student.getScore());
        }
    }
}
