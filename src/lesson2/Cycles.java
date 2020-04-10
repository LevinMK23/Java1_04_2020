package lesson2;

public class Cycles {

    //break - завершает свой цикл
//        lab:
//        for (int i = 0; i < 5; i++) {
//
//            for (int j = 0; j < 5; j++) {
//
//                for (int k = 0; k < 5; k++) {
//                    System.out.print(" * ");
//                    break lab;
//                }
//
//            }
//            //System.out.print(" * ");
//        }


    public static void testWhile() {
        int start = 0;
        while (++start < 10) {
            System.out.print(start + " ");
        }
        System.out.println();
        while (start > 0) {
            System.out.print(start + " ");
            start--;
        }
        start++;
        System.out.println();
        int pow = 0;
        while (pow < 20) {
            System.out.print(start + " ");
            start *= 3;
            pow++;
        }
    }

    // чем меньше итераций тем лучше
    // сложность по времени определяется количеством итераций
    // сложность по времени это функция, зависящая от входного параметра
    public static void forTest(int n) { // O(n ** 2)
        //alt + ctrl + l
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //[[[]]], n = 3
    public static void printBrackets(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("[");
        }
        for (int i = 0; i < count; i++) {
            System.out.print("]");
        }
    }

    //n = 4 () (()) ((())) (((())))
    public static void printDeepBrackets(int count) {
        for (int i = 1; i <= count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("(");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(")");
            }
        }
    }

    // limit = 10 ()(())((()
    public static int printDeepBracketsWithLimit(int limit) {
        int j = 1, brackets = 0;
        label:
        while (true) {
            for (int i = 0; i < j; i++) {
                System.out.print("(");
                brackets++;
                if (brackets == limit) {
                    break label;
                }
            }
            for (int i = 0; i < j; i++) {
                System.out.print(")");
                brackets++;
                if (brackets == limit) {
                    return brackets;
                }
            }
            j++;
        }
        System.out.println("After return");
        return brackets;
    }

    public static void multipleTable(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // %d int long short byte, %f float double, %c char, %s String
                // \n - переход на следующую строку
                System.out.printf("%4d\n", (i + 1) * (j + 1));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        //testWhile();
        //printDeepBrackets(4);
        System.out.println(printDeepBracketsWithLimit(14));
        //multipleTable(10, 10);
    }

}
