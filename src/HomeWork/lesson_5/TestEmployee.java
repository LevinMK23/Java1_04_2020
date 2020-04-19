package HomeWork.lesson_5;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] list = new Employee[5];
        list[0] = new Employee("Ivanov", 62, "stunt man", "Ivan@gmail.com", "8-911-234-56-78");
        list[1] = new Employee("Petrov", 24, "body double", "Petrov@mail.ru", "8-911-123-43-56");
        list[2] = new Employee("Topolev", 31, "film decorator", "Topol@yahoo.com", "89216544567");
        list[3] = new Employee("Lana Wachowski", 54, "director", "WachowskiLana@gmail.com", "+1-345-654-7654");
        list[4] = new Employee("Keanu Charles Reeves", 55, "actor", "Keanu-the-best@gmail.com", "+1-123-456-7890");
        printOver40(list);
    }

    private static void printOver40(Employee[] list) {
        System.out.println("Employees over 40:");
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if((list[i]).getAge() > 40){
               System.out.println(list[i]);
               count++;
            }
        }
        if (count == 0) System.out.println("Everybody young");
    }
}

