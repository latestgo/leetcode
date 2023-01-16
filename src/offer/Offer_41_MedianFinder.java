package offer;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer_41_MedianFinder {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        double median = finder.findMedian();
        System.out.println(median);
    }
    /** initialize your data structure here. */
    List<Integer> list = new LinkedList<>();
    public Offer_41_MedianFinder() {

    }

    public void addNum(int num) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            if (list.get(i) > num) {
                list.add(i, num);
                return;
            }
            i++;
        }
        if (i >= size) {
            list.add(num);
        }
    }

    public double findMedian() {
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        } else {
            return list.get(mid);
        }
    }
}
class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> maxQ = new PriorityQueue<>();
    Queue<Integer> minQ = new PriorityQueue<>((a, b) ->  b - a );
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (maxQ.size() == minQ.size()) {
            minQ.add(num);
            maxQ.add(minQ.poll());
        } else {
            maxQ.add(num);
            minQ.add(maxQ.poll());
        }
    }

    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return (maxQ.peek() + minQ.peek()) / 2.0;
        } else {
            return maxQ.peek();
        }
    }
}
