package chapter_2._07_Mine_Sweeper._03_Knuth_Shuffle;

public class MineSweeperData {

    public static final String blockImageURL = "resources/block.png";
    public static final String flagImageURL = "resources/flag.png";
    public static final String mineImageURL = "resources/mine.png";
    public static String numberImageURL(int num){
        if(num < 0 || num >= 8)
            throw new IllegalArgumentException("No such a number image!");
        return "resources/" + num + ".png";
    }

    private int N, M;
    private boolean[][] mines;

    public MineSweeperData(int N, int M, int mineNumber){

        if(N <= 0 || M <= 0)
            throw new IllegalArgumentException("Mine sweeper size is invalid!");

        if(mineNumber < 0 || mineNumber > N*M)
            throw new IllegalArgumentException("Mine number is larger than the size of mine sweeper board!");

        this.N = N;
        this.M = M;

        mines = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++)
            for(int j = 0 ; j < M ; j ++){
                mines[i][j] = false;
            }

        generateMines(mineNumber);
    }

    public int N(){ return N; }
    public int M(){ return M; }

    public boolean isMine(int x, int y){
        if(!inArea(x, y))
            throw new IllegalArgumentException("Out of index in isMine function!");
        return mines[x][y];
    }

    public boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private void generateMines(int mineNumber){

        for(int i = 0 ; i < mineNumber ; i ++){
            int x = i/M;
            int y = i%M;
            mines[x][y] = true;
        }

        for(int i = N*M-1; i >= 0 ; i-- ){

            int iX = i/M;
            int iY = i%M;

            int randNumber = (int)(Math.random()*(i+1));

            int randX = randNumber/M;
            int randY = randNumber%M;

            swap(iX, iY, randX, randY);
        }
    }

    private void swap(int x1, int y1, int x2, int y2){
        boolean t = mines[x1][y1];
        mines[x1][y1] = mines[x2][y2];
        mines[x2][y2] = t;
    }
}
