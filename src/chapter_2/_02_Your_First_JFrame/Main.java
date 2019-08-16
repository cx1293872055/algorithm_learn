package chapter_2._02_Your_First_JFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        int n = 10;
        Circle[] circles = new Circle[n];
        int R = 50;
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random()*(sceneWidth - 2 * R)) + R;
            int y = (int)(Math.random()*(sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * (11)) - 5;
            int vy = (int) (Math.random() * (11)) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome",sceneWidth,sceneHeight);
            new Thread(() -> {
                while (true) {
                    frame.render(circles);

                    AlgoVisHelper.pause(20);

                    for (Circle circle : circles) {
                        circle.move(0, 0, sceneWidth, sceneHeight);
                    }
                }
            }).start();

        });
    }
}
