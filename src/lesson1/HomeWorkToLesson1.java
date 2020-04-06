import java.util.Scanner;

public class HomeWorkToLesson1 {

    public static float Task3 (float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean Task4 (int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    public static void Task5 (int a){
        if (a >= 0) System.out.println("Задание 5: число положительное");
        else System.out.println("Задание 5: число отрицательное");
    }

    public static boolean Task6 (int a) {
        return a < 0;
    }

    public static void Task7 (String a) {
        System.out.println("Задание 7: Привет, " + a);
    }

    public static void Task8 (int a) {
        if (a % 100 == 0 && a % 400 == 0 )
            System.out.println("Год " + a + " вискосный");
        else if (a % 4 == 0 && a % 100 != 0)
            System.out.println("Год " + a + " вискосный");
        else if (a % 100 == 0)
            System.out.println("Год " + a + " не вискосный");
        else
            System.out.println("Год " + a + " не вискосный");
    }

    public static void main(String[] args) {
        // Делаем ввод с клавиатуры
        Scanner task = new Scanner(System.in);
        // Обращаемся к методу Task3 и записываем результат в переменную
        float taskAnswer = Task3 (task.nextFloat(), task.nextFloat(), task.nextFloat(), task.nextFloat());
        System.out.println("Задание 3: " + taskAnswer);
        // Аналогично поступаем и с методом Task4
        boolean taskAnswear1 = Task4(task.nextInt(), task.nextInt());
        System.out.println("Задание 4: " + taskAnswear1);
        // Вызываем void метод Task5
        Task5(task.nextInt());
        // Вызываем метод Task6
        System.out.println("Задание 6: " + Task6(task.nextInt()));
        // Обращаемся к методу Task7
        Scanner task1 = new Scanner (System.in);
        Task7(task1.nextLine());
        //Обращаемся к методу Task8
        Task8(task.nextInt());
        /*
        Результат
        33
        2
        1
        5
        Задание 3: 72.6
        2
        8
        Задание 4: true
        -8
        Задание 5: число отрицательное
        0
        Задание 6: false
        Alex
        Задание 7: Привет, Alex
        2000
        Год 2000 вискосный

        Process finished with exit code 0
 */
    }
}
