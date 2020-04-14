public class homeWork2 {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        System.out.println("\r\nTask - 1");
        System.out.println("Было - 1, 1, 0, 0, 1, 0, 1, 1, 0, 0");
        int[] lag1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            for (int i = 0; i < lag1.length; i++) {
                lag1[i] = lag1[i] == 1 ? 0 : 1;
            System.out.print(" Стало " + lag1[i]);
        }

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("\r\n\nTask - 2");
            int[] lag2 = new int[8];
                for (int i = 1, j = 0; i < lag2.length; i++) lag2[i] = j += 3;
                for (int x : lag2) System.out.print(x + " ");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("\r\n\nTask - 3");
        System.out.println("Было - 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1");
        int[] lag3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < lag3.length; i++) {
                if (lag3[i] < 6) lag3[i] *= 2;
                System.out.print(lag3[i] + " ");
        }

        //4. Создать квадратный двумерный целочисленный массив, и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\r\n\nTask - 4");
        int[][] lag4 = new int[5][5];
            for (int a = 0; a < lag4.length; a++) {
                for (int b = 0, b2 = lag4[a].length; b < lag4[a].length; b++, b2--) {
                    if (a == b || a == (b2 - 1)) lag4[a][b] = 1;
                System.out.print(lag4[a][b] + " ");
            }
                System.out.print("\r\n");
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\r\n\nTask - 5");
        System.out.println("Элементы - 10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1");
        int[] lag5 = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = lag5[0], max = lag5[0], indMax = 0, indMin = 0;
            for (int i = 0; i < lag5.length; i++) {
                if (lag5[i] > max) {
                max = lag5[i];
                indMax = i;
            }
                if (lag5[i] < min) {
                min = lag5[i];
                indMin = i;
            }
        }
        System.out.println("Максимальное значение " + max);
        System.out.println("Минимальное значение  " + min);
        System.out.println("P/S - Всё же немного подглядел из старых уроков :( Pido perdón.");
    }

}
© 2020 GitHub, Inc.
