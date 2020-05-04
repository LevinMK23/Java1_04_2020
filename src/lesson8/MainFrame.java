package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static javax.swing.text.StyleConstants.Bold;
import static javax.swing.text.StyleConstants.FontFamily;
import static lesson8.TamagochiGame.dog;

public class MainFrame extends JFrame {

    public JButton[] jbtn = new JButton[4];
    public JPanel panel = new JPanel();
    public JPanel playground = new JPanel();
    public JPanel statsPanel = new JPanel();
    private JLabel time;
    private JLabel allStatsShow;
    public JLabel picLabel = new JLabel();
    int delayStatsTime = 10000; // Время апдейта статов
    int delay = 5000; // Время на которое кнопки будут не доступны, при выполнении действия
    private final Timer stts2 = new Timer(delayStatsTime, this::updateStatsTimer);

    private final DateFormat formatter = new SimpleDateFormat("dd.MM.yy" + " | " + "HH:mm:ss"); // для текущего времени

    // Картинки, отображающие состояние нашего питомца, после нажатия Действия
    ImageIcon idle = new ImageIcon("src\\lesson8\\pics\\tama.gif");
    ImageIcon eats = new ImageIcon("src\\lesson8\\pics\\tama_eats.gif");
    ImageIcon pees = new ImageIcon("src\\lesson8\\pics\\tama_pees.gif");
    ImageIcon plays = new ImageIcon("src\\lesson8\\pics\\tama_plays.gif");
    ImageIcon sleeps = new ImageIcon("src\\lesson8\\pics\\tama_sleeps.gif");
    ImageIcon gameover = new ImageIcon("src\\lesson8\\pics\\tmg_bg_final.gif");

    //Font font = new Font("HandjetFlowerDouble-Bold",FontFamily,15);


    // Создаем выпадающее меню
    private JMenuBar createFileMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Жми сюда");
        JMenuItem newGame = new JMenuItem(new newAction());
        JMenuItem exit = new JMenuItem(new ExitAction());
        file.add(newGame);
        file.addSeparator();
        file.add(exit);
        menuBar.add(file);
        setJMenuBar(menuBar);
        return menuBar;
    }

    // Создаем действия меню, для Новой игры (не работает) и Выхода (работает)
    class newAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        newAction() {
            putValue(NAME, "Новая игра");
        }

        // TODO - Новая игра по кнопке
        // TODO - Дописать Save/Load
        public void actionPerformed(ActionEvent e) {


        }
    }

    // Экшн на выход
    class ExitAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        ExitAction() {
            putValue(NAME, "Выход");
        }

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


    // Панель на которую разместим кнопки
    private JPanel panel() {

        panel.setBackground(Color.YELLOW);
        return panel;
    }

    // Создаем панель, на которой будет отображаться наше животное
    private JPanel playground() {

        playground.setBackground(Color.BLACK);
        ImageIcon backgroundPic = new ImageIcon("src\\lesson8\\pics\\nIGpbWT.gif");
        //picLabel.setIcon(backgroundPic);
        picLabel.setIcon(idle);
        playground.add(picLabel);
        add(playground);
        return playground;
    }

    // Создаем кнопки
    public void buttons() {

        jbtn[0] = new JButton("Поиграть");
        jbtn[1] = new JButton("Накормить");
        jbtn[2] = new JButton("Спать");
        jbtn[3] = new JButton("Выгулить");
        Dimension d = new Dimension(170, 110);
        for (int i = 0; i < 4; i++) {
            jbtn[i].setPreferredSize(d);
            add(jbtn[i]);
            panel().add(jbtn[i]);
        }
        add(panel());
    }

    // Вывод текущего времени
    public void curTime() {
        time = new JLabel();
        add(time);
        Timer timer = new Timer(1000, this::actionPerformed);
        timer.start();
    }

    // Вывод текущего времени
    public void actionPerformed(ActionEvent e) {
        String s = formatter.format(Calendar.getInstance().getTime());
        time.setText(s);
    }

    // Панель для вывода статов на экран (здоровье, сытость и т.д.)
    public void currStats() {
        allStatsShow = new JLabel();
        statsPanel.setBackground(Color.GREEN);
        statsPanel.add(allStatsShow);
        add(statsPanel);
        Timer stts = new Timer(500, this::updateStats);
        stts.start();
    }

    // Обновляем статы, когда произшел выбор действия
    public void updateStats(ActionEvent e) {
        allStatsShow.setText("Здоровье: " + dog.getHealth() + " | Радость: " + dog.getFun()
                + " | Сытость: " + dog.getStarv() + " | Сон: " + dog.getSleep() +
                " | Туалет: " + dog.getPoop());
    }

    // Обновляем статы во времени
    public void updateStatWithTime() {
        while (dog.healthCheck()) {
            stts2.start();
        }
        System.out.println("GAME OVER");
        stts2.stop();
        picLabel.setIcon(gameover);
        jbtn[0].setEnabled(false);
        jbtn[1].setEnabled(false);
        jbtn[2].setEnabled(false);
        jbtn[3].setEnabled(false);

        // Выбор "Новая игра" | "Выйти"
        int n;
        do {
            n = JOptionPane.showConfirmDialog(
                    playground,
                    "Твой питомец сбежал, начать новую игру?",
                    "GAME OVER",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                dog.healthCheck();
                restartGame();
            } else if (n == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } while (n == JOptionPane.YES_OPTION);
    }


    // Как сильно меняются статы во времени
    public void updateStatsTimer(ActionEvent e) {
        dog.updateAnimalStats(TamagochiGame.difficulty);
    }


    // Добавляем все на Frame
    public void mainFrame() {
        setLayout(new FlowLayout());
        setTitle("TamoGachi");
        setSize(710, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createFileMenu();
        buttons();
        currStats();
        curTime();
        playground();
        feed();
        play();
        poop();
        sleep();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        updateStatWithTime();
    }

    // Создаем новую игру, очень сырой вариант :<
    public void restartGame() {
        TamagochiGame.dog.name = "GAV";
        TamagochiGame.dog.health = 80;
        TamagochiGame.dog.fun = 80;
        TamagochiGame.dog.starv = 80;
        TamagochiGame.dog.sleep = 10;
        TamagochiGame.dog.poop = 10;
        jbtn[0].setEnabled(true);
        jbtn[1].setEnabled(true);
        jbtn[2].setEnabled(true);
        jbtn[3].setEnabled(true);
        picLabel.setIcon(idle);
        while (dog.healthCheck()) {
            stts2.start();
        }
        System.out.println("GAME OVER");
        stts2.stop();
    }

    ActionListener action = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (jbtnOn() == false) {
                jbtn[0].setEnabled(true);
                jbtn[1].setEnabled(true);
                jbtn[2].setEnabled(true);
                jbtn[3].setEnabled(true);
            }
            picLabel.setIcon(idle);
        }
    };

    // Выключаем все кнопки, при выполнения действия
    public boolean jbtnOn() {
        jbtn[0].setEnabled(false);
        jbtn[1].setEnabled(false);
        jbtn[2].setEnabled(false);
        jbtn[3].setEnabled(false);
        return false;
    }

    private void time(int delay, ActionListener action) {
        new Timer(delay, action).start();
    }

    // Действия на кнопках
    public void feed() {
        jbtn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dog.setStarv(15);
                jbtnOn();
                picLabel.setIcon(eats);
                time(delay, action);
            }
        });
    }

    public void play() {
        jbtn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dog.setFun(10);
                jbtnOn();
                picLabel.setIcon(plays);
                time(delay, action);
            }
        });
    }

    public void sleep() {
        jbtn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dog.setSleep(20);
                jbtnOn();
                picLabel.setIcon(sleeps);
                time(delay, action);
            }
        });
    }

    public void poop() {
        jbtn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dog.setPoop(11);
                jbtnOn();
                picLabel.setIcon(pees);
                time(delay, action);
            }
        });
    }

}
