package lesson7.persons;

import java.util.ArrayList;

public class Teacher extends Person {

    public Teacher(String name) {
        super(name);
        groups = new ArrayList<>();
    }

    private ArrayList<Group> groups;

    public void addGroup(Group group) {
        groups.add(group);
        if (!group.getTeachers().contains(this)) {
            group.addTeacher(this);
        }
    }

    public ArrayList<Student> getStudentsByGroup(Group group) {
        if (groups.contains(group)) {
            return group.getStudents();
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<Teacher> getWorkmates() {
        ArrayList<Teacher> workmates = new ArrayList<>();
        for (Group group : groups) {
            for (Teacher teacher : group.getTeachers()) {
                if (!teacher.equals(this) && !workmates.contains(teacher)) {
                    workmates.add(teacher);
                }
            }
        }
        return workmates;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return getName();
    }
}
