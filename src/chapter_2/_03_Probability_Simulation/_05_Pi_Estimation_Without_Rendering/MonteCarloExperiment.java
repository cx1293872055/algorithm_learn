package chapter_2._03_Probability_Simulation._05_Pi_Estimation_Without_Rendering;

import java.awt.*;

public class MonteCarloExperiment {

    private int squareSide;
    private int N;
    private int outputInterval = 100;

    public MonteCarloExperiment(int squareSide, int N){

        if(squareSide <= 0 || N <= 0)
            throw new IllegalArgumentException("squareSide and N must larger than zero!");

        this.squareSide = squareSide;
        this.N = N;
    }

    public void setOutputInterval(int interval){

        if(interval <= 0)
            throw new IllegalArgumentException("interval must be larger than zero");

        this.outputInterval = interval;
    }

    public void run(){

        Circle circle = new Circle(squareSide/2, squareSide/2, squareSide/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);
        int i;
        for(i = 0 ; i < N ; i ++){

            if( i % outputInterval == 0) {
                System.out.println(data.estimatePi());
            }

            int x = (int)(Math.random() * squareSide);
            int y = (int)(Math.random() * squareSide);
            data.addPoint(new Point(x, y));
        }
        System.out.println(i);
    }

    public static void main(String[] args) {

        int squareSide = 800;
        int N = 1000000;

        MonteCarloExperiment exp = new MonteCarloExperiment(squareSide, N);
        exp.setOutputInterval(10000);
        exp.run();
    }
}
