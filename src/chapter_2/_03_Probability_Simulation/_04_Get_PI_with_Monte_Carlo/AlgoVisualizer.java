package chapter_2._03_Probability_Simulation._04_Get_PI_with_Monte_Carlo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private static int DELAY = 40;

    private MonteCarloPiData data;
    private AlgoFrame frame;
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        if(sceneWidth != sceneHeight)
            throw new IllegalArgumentException("This demo must be run in a square window!");
        this.N = N;
        Circle circle = new Circle(sceneWidth/2, sceneHeight/2, sceneWidth/2);
        data = new MonteCarloPiData(circle);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Monte Carlo", sceneWidth, sceneHeight);
            //frame.setSize(1000,1000);
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){

        for(int i = 0 ; i < N ; i ++){

            if( i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                //System.out.println(data.estimatePi());
            }

            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x, y));
        }

    }

    private class AlgoMouseListener extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            System.out.println(e.getPoint());
        }
    }
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 20000;

        AlgoVisualizer vis = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
