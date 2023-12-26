package Queues;
import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) {
        generateBinaryNumbers(1000);
    }


    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            // Print the next binary number.
            String binaryNumber = queue.poll();
            System.out.println(binaryNumber);

            if (i * 2 + 1 < n) {
                // Only add 2 more numbers if the amount of numbers added to the queue (which is
                // i * 2 + 1) is less than n.
                // It's not necessary to continue adding more after that point, as they will not
                // be printed nor used.
                queue.offer(binaryNumber + 0);
                queue.offer(binaryNumber + 1);
            }
        }
    }
}
