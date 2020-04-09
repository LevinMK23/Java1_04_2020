import java.util.Arrays;

public class HomeWorkNumberTwo {
    public static void main(String[] args) {
        System.out.println("Филиппов Вячеслав Домашняя работа №2\n");
        System.out.println("Задание 1");
        int[] first = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
        System.out.println("Массив до: " + Arrays.toString(first));
        for (int i = 0; i < first.length; i++) {
            first[i] = (first[i] == 0) ? 1 : 0;
        }
        System.out.println("Массив после: " + Arrays.toString(first));

        System.out.println("\nЗадание 2");
        int[] second = new int[8];
        for (int i = 0; i < second.length; i++) {
            second[i] = i * 3;
        }
        System.out.println("Результат: " + Arrays.toString(second));

        System.out.println("\nЗадание 3");
        int[] third = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < third.length; i++) {
            third[i] = (third[i] < 6) ? third[i] * 2 : third[i];
        }
        System.out.println("Результат: " + Arrays.toString(third));

        System.out.println("\nЗадание 4");
        int[][] fourth = new int[9][9];
        for (int i = 0; i < fourth.length; i++) {
            fourth[i][i] = 1;
            fourth[i][fourth.length - i - 1] = 1;
            System.out.println(Arrays.toString(fourth[i]));
        }

        System.out.println("\nЗадание 5");
        int[] fifth = {5, 13, -6, 25, 105, 99, 18, 50, 88, 45};
        System.out.println("В заданном массиве " + Arrays.toString(fifth));
        int min = 0;
        int max = 0;
        for (int i = 0; i < fifth.length; i++) {
            if (i == 0) {
                min = fifth[i];
                max = fifth[i];
            } else {
                min = Math.min(fifth[i], min);
                max = Math.max(fifth[i], max);
            }
        }
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("\nЗадачи 6 и 7 я выполнить сам не смог. Нашёл решения и разобрл.");
    }
}

