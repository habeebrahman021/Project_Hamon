package in.zedone.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Classrooms {

    @SerializedName("classrooms")
    List<Classroom> classroomList;


    public Classrooms(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }
}
