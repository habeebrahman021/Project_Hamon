package in.zedone.myapplication.model;

public class AssignSub {
    int id;
    String layout;
    String name;
    int size;
    String subject;

    public AssignSub(int id, String layout, String name, int size, String subject) {
        this.id = id;
        this.layout = layout;
        this.name = name;
        this.size = size;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getLayout() {
        return layout;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getSubject() {
        return subject;
    }
}
