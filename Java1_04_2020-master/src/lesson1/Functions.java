package lesson1;

public class Functions {

    // функция - кусок программного кода
    // функция имеет аргументы и что то возвращает(но это не точно)
    // функция которая ничего не возвращает имеет тип void и
    // называется процедурой

    // тип_данных имя_функции(тип параметра1....) {impl}



    static int sum(int a, int b) {
        return a + b; // вернуть a + b
    }

    static void sumTwo(int a, int b) {
        System.out.println(a + b);
        lol();
        return;
    }

    static int lol() {
        System.out.println("LOL");
        return 0;
    }

    public static void main(String[] args) {
        lol();
        lol();
        // функция = метод
        System.out.println(sum(1, 7));
        int result = sum(1,12);
        sumTwo(1, 12);
    }
}
