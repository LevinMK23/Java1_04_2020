package lesson7.persons;

import java.util.ArrayList;

public class Group {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public Group() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        if (!teacher.getGroups().contains(this)) {
            teacher.addGroup(this);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        if (student.getGroup() == null
                || !student.getGroup().equals(this)) {
            student.addToGroup(this);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
}
