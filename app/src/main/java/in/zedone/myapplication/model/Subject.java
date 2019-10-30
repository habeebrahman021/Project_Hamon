package in.zedone.myapplication.model;

public class Subject {

    int id;
    String name;
    String teacher;
    int credits;

    public Subject(){

    }

    public Subject(int id, String name, String teacher, int credits) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCredits() {
        return credits;
    }
}
