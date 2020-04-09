package ru.geekbrains.lesson2_homework;

public class lesson2_homework {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        int[] a = new int[10];
        System.out.println("Случайный массив");
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 2);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("Преобразованный массив");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void task2() {
        int[] a = new int[8];
        int b = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = b;
            b += 3;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void task3() {
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Заданный массив");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        }
            System.out.println();
            System.out.println("Преобразованный массив");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        System.out.println();
        }

    public static void task4() {

        int[][] a = new int[5][5];
        int x = 0;
        int y = a[a.length -1].length - 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][x] = 1;
                a[i][y] = 1;
                System.out.print(a[i][j] + " ");
            }
            x++;
            y--;
            System.out.println();
        }

    }
}

