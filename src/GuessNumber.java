import java.util.Scanner;
import java.lang.String;

public class GuessNumber {
    public static void main(String[] args) {

        randomNumber();

        userNumber();
    }

    public static int randomNumber() {
        int number = (int) Math.round(Math.random() * 1000);
        return number;
    }

    public static void userNumber() {
        int maxTryCount = 10;
        int tryCount = 1;
        int compNumber = randomNumber();
        System.out.print("Please enter the number 0 - 1000: ");
        Scanner scan = new Scanner(System.in);

        for (tryCount = 1; tryCount <= maxTryCount; tryCount++) {
            int userNum = scan.nextInt();
            if (userNum == compNumber) {
                System.out.println("Congrats. You guess!");
                System.out.print("Do you want to play again? Yes - 0, No - 1: ");
                return;
            } else if (userNum > compNumber && userNum < 1000) {
                System.out.println("You entered too many.  You have attempts: " + (maxTryCount - tryCount));
                System.out.print("Please enter the number 0 - 1000: ");
            } else if (userNum < compNumber && userNum < 1000) {
                System.out.println("You entered too small a number. You have attempts: " + (maxTryCount - tryCount));
                System.out.print("Please enter the number 0 - 1000: ");
            }
            if (userNum > 1000) {
                System.out.println("Max value 1000");
                System.out.println("Please enter the number 0 - 1000: ");
            }
            if (tryCount == 10){
                System.out.println("You have used all attempts");
                System.out.println("Do you want to play again? Yes - 0, No - 1");
            }else if (userNum == 0){
                continue;
            }else if(userNum == 1){
                return;
            }
        }
    }
}
