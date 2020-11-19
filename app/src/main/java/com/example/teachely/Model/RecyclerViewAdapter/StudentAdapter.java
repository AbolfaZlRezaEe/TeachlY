package com.example.teachely.Model.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachely.Model.Model.Student;
import com.example.teachely.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students = new ArrayList<>();

    public StudentAdapter() {
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

    public void addStudent(Student student) {
        students.add(0, student);
        notifyItemInserted(0);
    }

    public void addAll(List<Student> students) {
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView major;
        private TextView score;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_studentItem_username);
            major = itemView.findViewById(R.id.tv_studentItem_Major);
            score = itemView.findViewById(R.id.tv_studentItem_score);
        }

        public void bindStudent(Student student) {
            String fullName = student.getFirstName() + " " + student.getLastName();
            name.setText(fullName);
            String grade=student.getGrade();
            String majorText=student.getMajor();
            if (majorText.length()!=0) {
                major.setText(majorText);
            }else
                major.setText(grade);
            score.setText(String.valueOf(student.getScore()));
        }
    }
}
