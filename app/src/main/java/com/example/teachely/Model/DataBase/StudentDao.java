package com.example.teachely.Model.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.teachely.Model.Model.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    long addStudent(Student student);

    @Delete
    int deleteStudent(Student student);

    @Query("SELECT * FROM tbl_student")
    List<Student> getStudents();

    @Update
    int update(Student student);

    @Query("SELECT * FROM tbl_student WHERE first_name LIKE '%' || :query || '%'")
    List<Student> searchByFirstNameStudent(String query);

    @Query("DELETE FROM tbl_student")
    void deleteAllStudent();
}
