package lesson8.homework;

import java.util.*;
import java.util.Timer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TetrisGame extends Application {
    public static final int move = 25, size = 25;
    public static int xMax = size * 12, yMax = size * 24, score = 0;
    public static int[][] mesh = new int[xMax / size][yMax / size];
    private static Pane group = new Pane();
    private static Form object;
    private static Scene scene = new Scene(group, xMax, yMax);
    private static int top = 0, lineNm = 0;
    private static boolean game = true;
    private static Form nextObj = Controller.makeRect();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        for (int[] a : mesh) { Arrays.fill(a, 0); }

        Line line = new Line(xMax, 0, xMax, yMax);

        Text level = new Text("");
        level.setStyle("-fx-font: 30 arial;");
        level.setY(35);
        level.setX(10);
        level.setFill(Color.GREEN);

        group.getChildren().addAll(line, level);

        Form a = nextObj;
        group.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();

        stage.setScene(scene);
        stage.setTitle("Tetris Game v0.1");
        stage.setResizable(false);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        stage.show();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {

                        if (object.a.getY() == 0 ||
                                object.b.getY() == 0 ||
                                object.c.getY() == 0 ||
                                object.d.getY() == 0) {
                            top++;
                        } else { top = 0; }

                        if (top == 2) {
                            Text gameOver = new Text("GAME\nOVER");
                            gameOver.setFill(Color.RED);
                            gameOver.setStyle("-fx-font: 60 arial;");
                            gameOver.setY(250);
                            gameOver.setX(25);
                            group.getChildren().add(gameOver);
                            game = false;
                        }
                        if (top == 15) { System.exit(0); }
                        if (game) {
                            moveDown(object);
                            level.setText(Integer.toString(lineNm));
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
    }

    private void moveOnKeyPress(Form form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    Controller.moveRight(form);
                } else if (event.getCode().equals(KeyCode.DOWN)) {
                    moveDown(form);
                    score++;
                } else if (event.getCode().equals(KeyCode.LEFT)) {
                    Controller.moveLeft(form);
                } else if (event.getCode().equals(KeyCode.UP)) {
                    moveTurn(form);
                }
            }
        });
    }

    private void moveTurn(Form form) {
        int f = form.form;
        Rectangle a = form.a, b = form.b, c = form.c, d = form.d;
        switch (form.getName()) {
            case "j":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveDown(form.c);
                    moveLeft(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveUp(form.c);
                    moveRight(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveUp(form.c);
                    moveRight(form.c);
                    moveUp(form.b);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveRight(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveRight(form.b);
                    moveRight(form.b);
                    moveDown(form.b);
                    moveDown(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveDown(form.c);
                    moveLeft(form.c);
                    moveDown(form.b);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveLeft(form.b);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveLeft(form.b);
                    moveLeft(form.b);
                    moveUp(form.b);
                    moveUp(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    form.changeForm();
                    break;
                }
                break;
            case "o":
                break;
            case "s":
                if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveUp(form.d);
                    moveUp(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveDown(form.d);
                    moveDown(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
                    moveUp(form.a);
                    moveRight(form.a);
                    moveDown(form.d);
                    moveLeft(form.d);
                    moveLeft(form.c);
                    moveUp(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
                    moveRight(form.a);
                    moveDown(form.a);
                    moveLeft(form.d);
                    moveUp(form.d);
                    moveUp(form.c);
                    moveRight(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveUp(form.d);
                    moveRight(form.d);
                    moveRight(form.c);
                    moveDown(form.c);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
                    moveLeft(form.a);
                    moveUp(form.a);
                    moveRight(form.d);
                    moveDown(form.d);
                    moveDown(form.c);
                    moveLeft(form.c);
                    form.changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    moveUp(form.b);
                    moveRight(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    moveUp(form.b);
                    moveRight(form.b);
                    moveLeft(form.c);
                    moveUp(form.c);
                    moveLeft(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveRight(form.c);
                    moveDown(form.c);
                    moveRight(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    moveUp(form.a);
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.a);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveDown(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    moveDown(form.a);
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.a);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveUp(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    moveUp(form.a);
                    moveUp(form.a);
                    moveRight(form.a);
                    moveRight(form.a);
                    moveUp(form.b);
                    moveRight(form.b);
                    moveDown(form.d);
                    moveLeft(form.d);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    moveDown(form.a);
                    moveDown(form.a);
                    moveLeft(form.a);
                    moveLeft(form.a);
                    moveDown(form.b);
                    moveLeft(form.b);
                    moveUp(form.d);
                    moveRight(form.d);
                    form.changeForm();
                    break;
                }
                break;
        }
    }

    private void removeRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newRects = new ArrayList<Node>();
        int full = 0;

        for (int i = 0; i < mesh[0].length; i++) {
            for (int j = 0; j < mesh.length; j++) {
                if (mesh[j][i] == 1) { full++; }
            }
            if (full == mesh.length) { lines.add(i + lines.size()); }
            full = 0;
        }

        if (lines.size() > 0) {
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle) { rects.add(node); }
                }
                score += 50;
                lineNm++;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * size) {
                        mesh[(int) a.getX() / size][(int) a.getY() / size] = 0;
                        pane.getChildren().remove(node);
                    } else {
                        newRects.add(node);
                    }
                }

                for (Node node : newRects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * size) {
                        mesh[(int) a.getX() / size][(int) a.getY() / size] = 0;
                        a.setY(a.getY() + size);
                    }
                }
                lines.remove(0);
                rects.clear();
                newRects.clear();

                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle) { rects.add(node); }
                }

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        mesh[(int) a.getX() / size][(int) a.getY() / size] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
                rects.clear();
            } while (lines.size() > 0);
        }
    }

    private void moveRight(Rectangle rect) {
        if (rect.getX() + move <= xMax - size) { rect.setX(rect.getX() + move); }
    }

    private void moveLeft(Rectangle rect) {
        if (rect.getX() - move >= 0) { rect.setX(rect.getX() - move); }
    }

    private void moveUp(Rectangle rect) {
        if (rect.getY() - move > 0) { rect.setY(rect.getY() - move); }
    }

    private void moveDown(Rectangle rect) {
        if (rect.getY() + move < yMax) { rect.setY(rect.getY() + move); }
    }

    private void moveDown(Form form) {
        if (form.a.getY() == yMax - size || form.b.getY() == yMax - size || form.c.getY() == yMax - size
                || form.d.getY() == yMax - size || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            mesh[(int) form.a.getX() / size][(int) form.a.getY() / size] = 1;
            mesh[(int) form.b.getX() / size][(int) form.b.getY() / size] = 1;
            mesh[(int) form.c.getX() / size][(int) form.c.getY() / size] = 1;
            mesh[(int) form.d.getX() / size][(int) form.d.getY() / size] = 1;
            removeRows(group);

            Form a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }

        if (form.a.getY() + move < yMax && form.b.getY() + move < yMax && form.c.getY() + move < yMax
                && form.d.getY() + move < yMax) {
            int movea = mesh[(int) form.a.getX() / size][((int) form.a.getY() / size) + 1];
            int moveb = mesh[(int) form.b.getX() / size][((int) form.b.getY() / size) + 1];
            int movec = mesh[(int) form.c.getX() / size][((int) form.c.getY() / size) + 1];
            int moved = mesh[(int) form.d.getX() / size][((int) form.d.getY() / size) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + move);
                form.b.setY(form.b.getY() + move);
                form.c.setY(form.c.getY() + move);
                form.d.setY(form.d.getY() + move);
            }
        }
    }

    private boolean moveA(Form form) {
        return (mesh[(int) form.a.getX() / size][((int) form.a.getY() / size) + 1] == 1);
    }

    private boolean moveB(Form form) {
        return (mesh[(int) form.b.getX() / size][((int) form.b.getY() / size) + 1] == 1);
    }

    private boolean moveC(Form form) {
        return (mesh[(int) form.c.getX() / size][((int) form.c.getY() / size) + 1] == 1);
    }

    private boolean moveD(Form form) {
        return (mesh[(int) form.d.getX() / size][((int) form.d.getY() / size) + 1] == 1);
    }

    private boolean cB(Rectangle rect, int x, int y) {
        boolean xB = false, yB = false;
        if (x >= 0) { xB = rect.getX() + x * move <= xMax - size; }
        if (x < 0) { xB = rect.getX() + x * move >= 0; }
        if (y >= 0) { yB = rect.getY() - y * move > 0; }
        if (y < 0) { yB = rect.getY() + y * move < yMax; }
        return xB && yB && mesh[((int) rect.getX() / size) + x][((int) rect.getY() / size) - y] == 0;
    }

}
