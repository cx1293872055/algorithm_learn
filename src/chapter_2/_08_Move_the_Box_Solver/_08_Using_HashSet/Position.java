package chapter_2._08_Move_the_Box_Solver._08_Using_HashSet;

public class Position {

    private int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public boolean nextTo(Position p){
        return Math.abs(x - p.x) + Math.abs(y - p.y) == 1;
    }
}
