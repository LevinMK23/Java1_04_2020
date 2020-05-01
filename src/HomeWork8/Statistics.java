package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Statistics extends JFrame  {

    private TableModel TableModel;

    public Statistics() throws HeadlessException {
        super("Статистика");
        String[] continents = {"--","Asia","Africa","Australia/Oceania","Europe","North America","South America"};
        JComboBox<String> jBoxContinent = new JComboBox<String>(continents);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton getStatic = new JButton("Получить статистику");
        getStatic.addActionListener(actionEvent  -> {
            String strFilter = (String) jBoxContinent.getSelectedItem();
            try {
                TableModel.setDataByFilter(strFilter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        getStatic.setBounds(5, 5, 200, 30);
        panel.add(getStatic);

        JLabel jLabel = new JLabel("Фильтр стран по континентам");
        jLabel.setBounds(5, 40, 200, 20);
        panel.add(jLabel);

        jBoxContinent.addActionListener(actionEvent  -> {
            String strFilter = (String) jBoxContinent.getSelectedItem();
            try {
                TableModel.setDataByFilter(strFilter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        jBoxContinent.setBounds(5,65,200,25);
        panel.add(jBoxContinent);

        TableModel = new TableModel();
        JTable table = new JTable(TableModel);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(5,100,575,455);
        panel.add(jsp);

        add(panel);

        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Statistics();

    }

}
