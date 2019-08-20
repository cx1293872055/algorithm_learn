package chapter_2._06_Maze_Generalization._08_More_about_Random_Maze_Generalization._01_Problem_about_Current_Random_Maze_Generalization;

import java.util.ArrayList;

public class RandomQueue<E>{

    private ArrayList<E> queue;

    public RandomQueue(){
        queue = new ArrayList<E>();
    }

    public void add(E e){
        queue.add(e);
    }

    public E remove(){
        if(queue.size() == 0)
            throw new IllegalArgumentException("There's no element to remove in Random Qeuue");

        int randIndex = (int)(Math.random()*queue.size());

        E randElement = queue.get(randIndex);
        queue.set(randIndex, queue.get(queue.size()-1));
        queue.remove(queue.size()-1);

        return randElement;
    }

    public int size(){
        return queue.size();
    }

    public boolean empty(){
        return size() == 0;
    }
}