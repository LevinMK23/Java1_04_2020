public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        System.out.println("Hello! First Home work");
        Task3(1, 2, 3, 4);  // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
        Task4(10,11);  // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        Task5(-1); // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
        Task6(2); // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        Task7("Михаил!"); // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        Task8(1945); // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    }

    public static float Task3 (int a, int b, int c, int d){
        float resultTask3 = a * (b + (c / d));
        System.out.println("3. Результат выражениея a * (b + (c / d)) равен " + resultTask3);
        return resultTask3;
    }

    public static boolean Task4(int e, int f) {
        int Sum = e + f;
        if (Sum >= 10 && Sum <= 20) {
            System.out.println("4. True");
            return true;
        } else {
            System.out.println("4. False");
            return false;
        }
    }

    public static void Task5 (int g) {
        if (g >= 0) {
            System.out.println("5. Положительное");
        } else {
            System.out.println("5. Отрицательное");
        }
    }

    public static boolean Task6 (int h) {
        if (h < 0) {
            System.out.println("6. True");
            return true;
        } else {
            System.out.println("6. False");
            return false;}
    }

    public static void Task7 (String name){
        System.out.println("7. Привет, " + name);
    }

    public static void Task8 (int year) {
        int check1 = year % 4; // если без остатка - високосный
        int check2 = year % 400; // если без остатка - високосный
        int check3 = year % 100; // если без остатка - не високосный
        // если год кратен 4, то високосный
        // если год кратен и 100 и 400, то не високосный
        // если год кратен только 400

        if (check1 == 0 && check2 != 0 && check3 != 0) {
            System.out.println("8. " + year + " год - Високосный");
        } else if (check2 == 0 && check3 == 0 && check1 == 0) {
            System.out.println("8. " + year + " год - Високосный");
        } else if (check2 == 0 && check3 == 0 && check1 != 0){
            System.out.println("8. " + year + " год не Високосной");
        } else {
            System.out.println("8. " + year + " год не Високосной");
        }

    }

}
