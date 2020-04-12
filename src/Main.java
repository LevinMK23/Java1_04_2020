import java.util.Scanner;

public class Main {
    //psvm public static void main
    public static void main(String[] args) {
        //sout
        //System.out.println("Hello world");
        //Task_1();
        Task_2();
    }

    public static void Task_1() {

        int hiddenNumber =  (int)(Math.random()*9);
        boolean win = false;
        int go = 1;


        Scanner  scanner = new Scanner(System.in);

        while (go != 0) {
            System.out.println("Отгадайте число от 0 до 9");

            for (int i = 0; i < 3; i++) {

                int number = scanner.nextInt();

                if (number == hiddenNumber) {
                    System.out.println("Вы отгадали");
                    win = true;
                    break;
                } else {
                    if (number > hiddenNumber) {
                        System.out.println("Ваше число больше");
                    } else {
                        System.out.println("Ваше число меньше");
                    }

                }
            }

            if (!win) {
                System.out.println("Вы проирали");
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            go = scanner.nextInt();
        }
    }

    public static void Task_2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String hiddenWord = words[(int)(Math.random()*25)];
        char[] arrHiddenWord = hiddenWord.toCharArray();
        System.out.println("Отгадайте слово");
        System.out.println(hiddenWord);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            if (hiddenWord.equals(word)){
                System.out.println("Вы отгадали");
                break;
            }
            else {
                System.out.println("Вы не отгадали");
            }

           char[] arrWord = word.toCharArray();
           BublleSort(arrWord);
           char[] arrHW =  arrHiddenWord.clone();
           for (int i = 0; i < arrHW.length; i++) {
               if (binarySearch(arrHW[i],arrWord) == -1) {
                   arrHW[i] = '#';
               }
            }

            String result = new String(arrHW);
            String sharp  = "###############";
            if (result.length() < 15) {
                result = result + sharp.substring(result.length());
            }
            System.out.println(result);
        }
    }

    public static void BublleSort(char[] arrWord) {

        char buffer;

        for (int j = arrWord.length-1; j >= 1 ; j--) {
            for (int i = 0; i < j; i++) {
                if(arrWord[i] > arrWord[i+1] ){
                    buffer = arrWord[i+1];
                    arrWord[i+1] = arrWord[i];
                    arrWord[i] = buffer;
                }
            }
        }


    }

    public static int binarySearch(char key, char[] array) {
        // -1 if not found
        // array have to be sort
        int left = 0, right = array.length - 1;
        while (right - left >= 0) {
            int idx = (left + right) / 2;
            if (array[idx] == key) {
                return idx;
            }
            if (array[idx] > key) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
        return -1;
    }
}
