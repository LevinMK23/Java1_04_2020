package lesson7.persons;

public class Test {
    public static void main(String[] args) {
        Group g1 = new Group();
        Student s1 = new Student("Ivan");
        Student s2 = new Student("Petr");
        Student s3 = new Student("Oleg");
        Teacher t1 = new Teacher("Alex");
        Teacher t2 = new Teacher("Anna");
        Group g2 = new Group();
        g2.addTeacher(t1);
        g2.addTeacher(t2);
        g2.addTeacher(new Teacher("Vasiliy"));
        g1.addStudent(s1);
        g1.addStudent(s3);
        s2.addToGroup(g1);
        g1.addTeacher(t1);
        g1.addTeacher(t2);
        System.out.println(g1.getStudents());
        System.out.println(s1.getClassmates());

        System.out.println(s2.getClassmates());
        System.out.println(s3.getClassmates());

        System.out.println(s1.getTeachers());

        System.out.println(t1.getStudentsByGroup(g1));
        System.out.println(t1.getStudentsByGroup(new Group()));
        System.out.println(t1.getWorkmates());
        System.out.println(t2.getWorkmates());
        System.out.println(t1.getWorkmates());
        System.out.println(t2.getWorkmates());
    }
}
