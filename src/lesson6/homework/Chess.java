package lesson6.homework;

import java.util.Scanner;

/**
 * Игра в шахматы для двух игроков
 * Реализация компьютерного игрока отсутствует
 * Не реализованы: рокировки, взятие пешкой на проходе, преобразование пешки в другую фигуру по достижению последнего поля доски
 * Ходы вводятся в формате "e 2 e 4"
 * По команде "- exit" можно прервать игру на любом ходу (вместо "-" допускается любой символ)
 */
public class Chess {
    public static void main(String[] args) {
        // Создаём доску с фигурами
        ChessBoard board = new ChessBoard();
        System.out.println(board);
        Scanner in  = new Scanner(System.in);
        // Координаты хода: по горизонтали - буквенные, по вертикали - цифровые
        char x1, x2;
        int y1, y2;
        // Флаг окончания игры по команде игрока
        boolean gameOver = false;
        // Флаг успешно выполненного хода
        boolean successTurn;
        while (true) {
            System.out.println("Ход белых в формате e 2 e 4");
            System.out.println("Для выхода введите \"- exit\"");
            successTurn = false;
            // Заставляем игрока белыми ввести ход в правильном формате
            do {
                try {
                    x1 = in.next().charAt(0);
                    y1 = in.nextInt();
                    x2 = in.next().charAt(0);
                    y2 = in.nextInt();
                } catch (Exception e) {
                    if (in.nextLine().equals("exit")) {
                        System.out.println("Игра прервана по инициативе игрока белыми");
                        gameOver = true;
                        break;
                    }
                    System.out.println(board);
                    System.out.println("Для выхода введите \"- exit\"");
                    System.err.println("Ход введён в неверном формате. Ход белых в формате e 2 e 4:");
                    continue;
                }
                // Когда имеем ход в корректном формате, передаём его для проверки и исполнения объекту доска
                // Если доска выдаёт ошибку, просим игрока ввести другой ход
                successTurn = board.move(x1, y1, x2, y2, true);
                if (!successTurn) {
                    System.out.println(board);
                    System.out.println("Ход белых в формате e 2 e 4:");
                    System.out.println("Для выхода введите \"- exit\"");
                }
            } while (!successTurn);
            if (gameOver) { break; }
            System.out.println(board);
            // Проверка условия победы
            if (board.getPointsOfBlack() <= 0) {
                System.out.println("Победа белых");
                break;
            }
            // Те же действия повторяются для игрока чёрными
            System.out.println("Ход чёрных в формате e 2 e 4:");
            System.out.println("Для выхода введите \"- exit\"");
            successTurn = false;
            do {
                try {
                    x1 = in.next().charAt(0);
                    y1 = in.nextInt();
                    x2 = in.next().charAt(0);
                    y2 = in.nextInt();
                } catch (Exception e) {
                    if (in.nextLine().equals("exit")) {
                        System.out.println("Игра прервана по инициативе игрока чёрными");
                        gameOver = true;
                        break;
                    }
                    System.out.println(board);
                    System.out.println("Для выхода введите \"- exit\"");
                    System.err.println("Ход введён в неверном формате. Ход чёрных в формате e 2 e 4:");
                    continue;
                }
                successTurn = board.move(x1, y1, x2, y2, false);
                if (!successTurn) {
                    System.out.println(board);
                    System.out.println("Ход чёрных в формате e 2 e 4:");
                    System.out.println("Для выхода введите \"- exit\"");
                }
            } while (!successTurn);
            if (gameOver) { break; }
            System.out.println(board);
            if (board.getPointsOfWhite() <= 0) {
                System.out.println("Победа чёрных");
                break;
            }
            System.out.println(board);
        }
    }
}
