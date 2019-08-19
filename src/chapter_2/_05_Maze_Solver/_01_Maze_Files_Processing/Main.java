package chapter_2._05_Maze_Solver._01_Maze_Files_Processing;

public class Main {

    public static void main(String[] args) {

        String mazeFile = "maze_101_101.txt";
        MazeData data = new MazeData(mazeFile);
        data.print();
    }
}
