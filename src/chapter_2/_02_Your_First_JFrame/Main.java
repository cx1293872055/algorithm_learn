package chapter_2._02_Your_First_JFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome");
        });
    }
}
