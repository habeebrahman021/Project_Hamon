package in.zedone.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Subjects {

    @SerializedName("subjects")
    List<Subject> subjectList;


    public Subjects(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}
