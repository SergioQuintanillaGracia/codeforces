import java.util.*;

public class p9_2 {
    // ArrayList that will contain ArrayLists representing each step of
    // the extrapolation process.
    static ArrayList<ArrayList<Long>> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        
        while (sc.hasNext()) {
            String line = sc.nextLine();

            if (line.equals("-1")) break;
            
            // Get the current array data.
            String lineArrS[] = line.split(" ");
            ArrayList<Long> curr = new ArrayList<>();

            // Store the data as longs in curr.
            for (int i = 0; i < lineArrS.length; i++) {
                curr.add(Long.parseLong(lineArrS[i]));
            }

            arr.add(curr);

            while (!isAll0s(curr)) {
                // If the current array is still not zeroes, run the algorithm again and add
                // the new array to the arr array.
                ArrayList<Long> next = new ArrayList<>();
                
                for (int i = 0; i < curr.size() - 1; i++) {
                    next.add(curr.get(i + 1) - curr.get(i));
                }

                curr = next;

                arr.add(curr);
            }

            // Add an element to each array.
            arr.get(arr.size() - 1).add(0L);  // Add a 0 to the last one.

            for (int i = arr.size() - 2; i >= 0; i--) {
                ArrayList<Long> a = arr.get(i);     // Current array
                ArrayList<Long> b = arr.get(i + 1); // Next array

                // Add to a its first element minus the first element of b, at index 0.
                a.add(0, a.get(0) - b.get(0));
            }

            sum += arr.get(0).get(0);

            // Clear the array to prepare it for the next iteration.
            arr.clear();
        }

        System.out.println(sum);
    }


    public static boolean isAll0s(ArrayList<Long> arr) {
        for (Long l : arr) {
            if (l != 0) return false;
        }

        return true;
    }
}
