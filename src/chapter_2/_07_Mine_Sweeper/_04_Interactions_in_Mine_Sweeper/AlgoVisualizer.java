package chapter_2._07_Mine_Sweeper._04_Interactions_in_Mine_Sweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private static int DELAY = 5;
    private static int blockSide = 32;

    private MineSweeperData data;
    private AlgoFrame frame;
    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public AlgoVisualizer(int N, int M, int mineNumber){

        data = new MineSweeperData(N, M, mineNumber);
        int sceneWidth = M * blockSide;
        int sceneHeight = N * blockSide;

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Mine Sweeper", sceneWidth,sceneHeight);
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){

        this.setData(false, -1, -1);

    }

    private void setData(boolean isLeftClicked, int x, int y){
        if(isLeftClicked){
            if(data.inArea(x, y))
                data.open[x][y] = true;
        }
        else{
            if(data.inArea(x, y))
                data.flags[x][y] = !data.flags[x][y];
        }

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public void addAlgoMouseListener(){
        frame.addMouseListener(new AlgoMouseListener());
    }

    private class AlgoMouseListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent event){

            event.translatePoint(
                    -(int)(frame.getBounds().width - frame.getCanvasWidth()),
                    -(int)(frame.getBounds().height - frame.getCanvasHeight())
            );
            System.out.println(event.getPoint());
            Point pos = event.getPoint();

            int w = frame.getCanvasWidth() / data.M();
            int h = frame.getCanvasHeight() / data.N();

            int x = pos.y / h;
            int y = pos.x / w;
            // System.out.println(x + " , " + y);

            if(SwingUtilities.isLeftMouseButton(event))
                setData(true, x, y);
            else if(SwingUtilities.isRightMouseButton(event))
                setData(false, x, y);

        }
    }

    public static void main(String[] args) {

        int N = 20;
        int M = 30;
        int mineNumber = 20;

        AlgoVisualizer vis = new AlgoVisualizer(N, M, mineNumber);
    }
}
