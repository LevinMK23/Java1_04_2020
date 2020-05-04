package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameLogic extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private boolean play2 = false;

    private int score = 0;

    private int totalBubbles = 30;
    private int totalBubbles2 = 14;

    private Timer timer;
    private int delay = 9;

    private int playerX = 310;

    private int ballX = 120;
    private int ballY = 350;
    private int ballDirX = -1;
    private int ballDirY = -2;

    private Map map;

    public GameLogic() {
        map = new Map(3, 10);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(new Color(15, 16, 33));
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);

        g.setColor(new Color(0x0F1021));
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        g.setColor(new Color(0xFCF5EE));
        g.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 17));
        g.drawString("Score: " + score, 590, 30);

        g.setColor(new Color(255, 163, 172));
        g.fillRect(playerX, 550, 100, 8);

        g.setColor(new Color(255, 163, 172));
        g.fillOval(ballX, ballY, 20, 20);

        if (totalBubbles <= 0) {
            play = false;
            ballDirX = 0;
            ballDirY = 0;
            g.setColor(new Color(255, 163, 172));
            g.setFont(new Font("Dialog", Font.BOLD, 25));
            g.drawString("Hey, good job!", 250, 300);
            g.drawString("Your score: " + score, 240, 330);

            g.setFont(new Font("Dialog", Font.BOLD, 15));
            g.drawString("Next level (press ALT)", 250, 430);

        }

        if (totalBubbles2 <= 0) {
            play2 = false;
            ballDirX = 0;
            ballDirY = 0;
            g.setColor(new Color(255, 163, 172));
            g.setFont(new Font("Dialog", Font.BOLD, 25));
            g.drawString("You did it!", 255, 300);
            g.drawString("Your score: " + score, 240, 330);

            g.setFont(new Font("Dialog", Font.BOLD, 15));
            g.drawString("Next level (press ALT)", 250, 430);
        }

        if (ballY > 570) {
            play = false;
            play2 = false;
            ballDirX = 0;
            ballDirY = 0;
            g.setColor(new Color(255, 163, 172));
            g.setFont(new Font("Dialog", Font.BOLD, 25));
            g.drawString("Game Over!", 260, 300);
            g.drawString("Your score: " + score, 245, 330);

            g.setFont(new Font("Dialog", Font.BOLD, 15));
            g.drawString("To Restart (press SHIFT)", 250, 430);

        }

        g.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ALT) {
            if (!play) {
                play2 = true;
                ballX = 120;
                ballY = 350;
                ballDirX = -1;
                ballDirY = -2;
                playerX = 310;
                score++;
                totalBubbles2 = 14;
                map = new Map(2, 7);
                timer = new Timer(delay, this);

                repaint();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            if (!play && !play2) {
                play = true;
                ballX = 120;
                ballY = 350;
                ballDirX = -1;
                ballDirY = -2;
                playerX = 310;
                score = 0;
                totalBubbles = 30;
                map = new Map(3, 10);

                repaint();
            }
        }
    }

    private void moveLeft() {
        play = true;
        play2 = true;
        playerX -= 20;
    }

    private void moveRight() {
        play = true;
        play2 = true;
        playerX += 20;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play || play2) {
            if (new Rectangle(ballX, ballY, 20, 20).
                    intersects(new Rectangle(playerX, 550, 100, 8))) ballDirY = -ballDirY;
            Point:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.bubbleWidth + 80;
                        int brickY = i * map.bubbleHeight + 50;
                        int brickWidth = map.bubbleWidth;
                        int brickHeight = map.bubbleHeight;

                        Rectangle rectangle = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
                        Rectangle bubbleRect = rectangle;

                        if (ballRect.intersects(bubbleRect)) {
                            map.setBubbleValue(0, i, j);
                            totalBubbles--;
                            score += 7;

                            if (ballX + 19 <= bubbleRect.x || ballX + 1 >= bubbleRect.x + bubbleRect.width) {
                                ballDirX = -ballDirX;
                            } else {
                                ballDirY = -ballDirY;
                            }
                            break Point;

                        }
                    }
                }
            }
            ballX += ballDirX;
            ballY += ballDirY;
            if (ballX < 0) ballDirX = -ballDirX;
            if (ballY < 0) ballDirY = -ballDirY;
            if (ballX > 670) ballDirX = -ballDirX;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

}
