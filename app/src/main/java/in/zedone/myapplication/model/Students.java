package in.zedone.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Students {

    @SerializedName("students")
    List<Student> studentList;


    public Students(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
