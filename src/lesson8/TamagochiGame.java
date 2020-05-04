package lesson8;

import java.io.IOException;

public class TamagochiGame {

    /*
    Тут можно поменять значение, на которое будут изменяться статы с течением времени
    Что то вроде сложности, на низжем уровне :)
    */

    public static int difficulty = 7;
    public static Animal dog = new Animal("GAV",80,10,80, 10);;
    public static MainFrame frame = new MainFrame();

    public static void main(String[] args) throws IOException {
        frame.mainFrame();

    }
}
