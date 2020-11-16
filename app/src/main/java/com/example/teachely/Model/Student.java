package com.example.teachely.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_student")
public class Student implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "school_name")
    private String schoolName;
    private String grade;
    @ColumnInfo(name = "phone_number")
    private long phoneNumber;
    @ColumnInfo(name = "nationality_code")
    private long nationalityCode;
    private int age;
    private long score;

    public Student() {

    }

    protected Student(Parcel in) {
        id = in.readLong();
        firstName = in.readString();
        lastName = in.readString();
        schoolName = in.readString();
        grade = in.readString();
        phoneNumber = in.readLong();
        nationalityCode = in.readLong();
        age = in.readInt();
        score = in.readLong();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(long nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(schoolName);
        dest.writeString(grade);
        dest.writeLong(phoneNumber);
        dest.writeLong(nationalityCode);
        dest.writeInt(age);
        dest.writeLong(score);
    }
}
