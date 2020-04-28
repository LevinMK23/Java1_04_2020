package lesson8.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win2 extends JFrame {


    private JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(BorderLayout.EAST, new JButton());
        panel.add(BorderLayout.WEST, new JButton());
        panel.add(BorderLayout.CENTER, new JButton());
        return panel;
    }

    private JMenu createFileMenu() {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Новая игра");
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem("Выход");
        // Добавление к пункту меню изображения
        // Добавим в меню пункта open
        exit.addActionListener(actionEvent -> {
            dispose();
        });
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);
        return file;
    }

    private JMenu createViewMenu() {
        // создадим выпадающее меню
        JMenu viewMenu = new JMenu("Вид");
        // меню-флажки
        JCheckBoxMenuItem line = new JCheckBoxMenuItem("Линейка");
        JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Сетка");
        JCheckBoxMenuItem navig = new JCheckBoxMenuItem("Навигация");
        // меню-переключатели
        JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
        JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");
        JRadioButtonMenuItem three = new JRadioButtonMenuItem("Три страницы");
        // организуем переключатели в логическую группу
        ButtonGroup bg = new ButtonGroup();
        bg.add(one);
        bg.add(two);
        bg.add(three);
        // добавим все в меню
        viewMenu.add(line);
        viewMenu.add(grid);
        viewMenu.add(navig);
        // разделитель можно создать и явно
        viewMenu.add(new JSeparator());
        viewMenu.add(one);
        viewMenu.add(two);
        viewMenu.add(three);
        return viewMenu;
    }

    public Win2() throws HeadlessException {
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        menuBar.add(createFileMenu());
        menuBar.add(createViewMenu());
        menuBar.add(new JMenu("Новая вкладка"));
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Win2();
    }
}
