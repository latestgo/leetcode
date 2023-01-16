package offer;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer_59_MaxQueue {
}
class MaxQueue {
    Queue<Integer> queue = new ArrayDeque<>();
    Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
    public MaxQueue() {
    }

    public int max_value() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        return priorityQueue.element();
    }

    public void push_back(int value) {
        queue.add(value);
        priorityQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int v = queue.poll();
        priorityQueue.remove(v);
        return v;
    }
}
