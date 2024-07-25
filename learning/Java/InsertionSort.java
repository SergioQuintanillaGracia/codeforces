public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 11, 13, 5, 6};
        insertionSort(arr);
        printArray(arr);
    }


    static void insertionSort(int arr[]) {
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


    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }
}