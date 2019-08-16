package chapter_2._02_Your_First_JFrame;
/**
 * 自定义的JFrame
 */

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    /**
     * 构造方法
     * @param title 窗口标题
     * @param canvasWidth 窗口宽度
     * @param canvasHeight 窗口高度
     */
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();


        setContentPane(canvas);
        pack();

        //设置窗口大小
        //setSize(canvasWidth, canvasHeight);
        //设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可改变
        setResizable(false);
        //设置窗口大小可见
        setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    private class AlgoCanvas extends JPanel{
        public AlgoCanvas() {
            //是否支持双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;
            //坑锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.addRenderingHints(hints);

            //绘制
            AlgoVisHelper.setStrokeWidth(g2d, 5);

            AlgoVisHelper.setColor(g2d,Color.BLUE);
            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);

            AlgoVisHelper.setColor(g2d,Color.RED);
            AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2, 200);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
