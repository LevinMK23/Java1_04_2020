package lesson8;

import java.awt.*;

public class Map {
    public int map[][];
    public int bubbleWidth;
    public int bubbleHeight;


    public Map(int row, int column) {
        map = new int[row][column];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++)
                map[i][j] = 1;
        }
        bubbleWidth = 540 / column;
        bubbleHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(new Color(0xF7DDDE));
                    g.fillOval(j * bubbleWidth + 80, i * bubbleHeight + 50, bubbleWidth, bubbleHeight);
                }
            }
        }
    }


    public void setBubbleValue(int value, int row, int column) {
        map[row][column] = value;

    }
}


