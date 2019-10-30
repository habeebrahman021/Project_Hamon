package in.zedone.myapplication.model;

public class Classroom {

    int id;
    String name;
    int size;
    String layout;

    public Classroom() {

    }

    public Classroom(int id, String name, int size, String layout) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.layout = layout;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getLayout() {
        return layout;
    }
}
