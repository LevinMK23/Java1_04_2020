package HomeWork;
//Написать метод, которому в качестве параметра передается строка, обозначающая имя.
// Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

public class task_7 {
    public static void main(String[] args) {
        String name = "Михаил Константинович";
        printHello(name);
    }
    private static void printHello(String name){
        System.out.println("Привет, " + name + "!");
    }
}
