package lesson7.Home_work_lesson_7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
        if (food >= 0) {
            System.out.println("Кот наелся и доволен!!))");
        }
        if (food < 0) {
            System.out.println("Этот кот все еще голоден");
            food = 0;
        }

    }


    public void info() {
        System.out.println("Количество еды в тарелке: " + food);
    }

    public void fullPlate() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Чтобы добавить еды в тарелку нажмите 1 или нажмите 0, чтобы очистить тарелку");
            int fill_the_plate = scanner.nextInt();
            if (fill_the_plate == 1) {
                System.out.println("Введите количество единиц еды, которыми бы вы хотели наполнить тарелку");
                int addFood = scanner.nextInt();
                if (addFood < 0) {
                    addFood = 0;
                } else {
                    food += addFood;
                }
                return;
            }
            if (fill_the_plate == 0) {
                System.out.println("Тарелка очищена от излишков пищи");
                food = 0;
                return;
            }
            if (fill_the_plate == 5) {
                System.out.println("Вы решили не менять количество пищи");
                return;
            }
             else {
                System.out.println("Введена не корректная команда");
            }
        }
    }

}
