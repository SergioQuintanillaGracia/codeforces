package Queues;
import java.util.*;

public class Basic {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(3);
        queue.offer(5);
        queue.offer(9);
        queue.offer(23);

        System.out.println("First element: %d".formatted(queue.peek()));
        queue.poll();

        System.out.println("New first element: %d".formatted(queue.peek()));

        while (!queue.isEmpty()) {
            System.out.println("Serving customer " + queue.poll());
        }
    }
}
