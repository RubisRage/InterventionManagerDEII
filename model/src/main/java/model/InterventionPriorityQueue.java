package model;

import java.util.TreeSet;

public class InterventionPriorityQueue {
    private final TreeSet<Intervention> queue;

    public InterventionPriorityQueue()
    {
        queue = new TreeSet<>();
    }

    public void push(Intervention intervention){
        queue.add(intervention);
    }

    public Intervention pop() {
        return queue.pollFirst();
    }

    public void remove(Intervention intervention){
        queue.remove(intervention);
    }
}
