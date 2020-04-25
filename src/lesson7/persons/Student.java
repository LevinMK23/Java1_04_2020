package lesson7.persons;

import lesson6.homework.A;

import java.util.ArrayList;

public class Student extends Person {

    public Student(String name) {
        super(name);
    }

    public void addToGroup(Group group) {
        this.group = group;
        if (!group.getStudents().contains(this)) {
            group.addStudent(this);
        }
    }

    public ArrayList<Teacher> getTeachers() {
        return group.getTeachers();
    }

    public ArrayList<Student> getClassmates() {
        ArrayList<Student> classmates = new ArrayList<>(group.getStudents());
        classmates.remove(this);
        return classmates;
    }

    public Group getGroup() {
        return group;
    }

    private Group group;

    @Override
    public String toString() {
        return getName();
    }
}
