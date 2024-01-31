import java.util.*;

public class P041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        sc.nextLine();

        int dataArr[] = new int[size];
        int dataIndex = 0;

        while (sc.hasNext()) {
            String line = sc.nextLine().trim();

            if (!line.isEmpty()) {
                String lineArr[] = line.split(" +");

                // Add every integer in the line to the data array.
                for (String s : lineArr) {
                    dataArr[dataIndex] = Integer.parseInt(s);
                    dataIndex++;
                }
            }
        }

        insertionSort(dataArr);
        
        System.out.printf("average: %.3f\n", average(dataArr));
        System.out.printf("variance: %.3f\n", variance(dataArr));
        System.out.printf("standard deviation: %.3f\n", standardDeviation(dataArr));
        System.out.printf("min and max: %.3f %.3f\n", min(dataArr), max(dataArr));
        System.out.printf("median: %.3f\n", median(dataArr));
        System.out.printf("mode: %.3f", mode(dataArr));
    }


    public static double average(int[] arr) {
        double length = arr.length;
        double average = 0;

        for (int i : arr) {
            average += i;
        }

        average /= length;

        return average;
    }


    public static double variance(int[] arr) {
        double av = average(arr);
        double length = arr.length;
        double res = 0;

        for (int i : arr) {
            res += Math.pow(i - av, 2);
        }
        
        res /= (length - 1);

        return res;
    }


    public static double standardDeviation(int[] arr) {
        return Math.sqrt(variance(arr));
    }


    public static double min(int arr[]) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }


    public static double max(int arr[]) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }


    public static double median(int arr[]) {
        if (arr.length % 2 == 0) {
            // The array is even, the median is the average of the 2 middle numbers of the array.
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        }

        // If the array is not even, it will return the middle element.
        return arr[arr.length / 2];
    }

    
    public static double mode(int arr[]) {
        // NOTE: The array should be sorted for this function to work correctly.
        int currCount = 1;
        int maxCount = 1;
        int mode = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currCount++;
            
            } else currCount = 1;

            if (currCount > maxCount) {
                maxCount = currCount;
                mode = arr[i];
            }
        }

        return mode;
    }


    static void insertionSort(int arr[]) {
        // I know insertion sort is not efficient, but it's easy to implement, and probably
        // enough for this problem, + I learned some days ago about it.

        // j is decremented in each iteration to compare each element of the array to the
        // previous one.
        int j;

        for (int i = 1; i < arr.length; i++) {
            // Iterate through every position of the array.
            j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                // Swap the values inside the array while the item is not correctly ordered.
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}