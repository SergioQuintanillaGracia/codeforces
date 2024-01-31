import java.util.*;

public class P051 {
    static String lastNames[] = new String[200];
    static String names[] = new String[200];
    static String phones[] = new String[200];
    static String emails[] = new String[200];
    static String dates[] = new String[200];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curr = 0;

        while (sc.hasNext()) {
            // LAST NAMES
            lastNames[curr] = sc.nextLine().trim().replaceAll(" +", " ");

            // NAME
            names[curr] = sc.nextLine().trim();

            // PHONE NUMBER
            phones[curr] = sc.nextLine().trim();

            // EMAIL
            emails[curr] = sc.nextLine().trim();

            // BIRTH DATE
            dates[curr] = sc.nextLine().trim().replaceAll(" +", "-");

            curr++;
        }

        // Create an array where the last names and names are together, so we can use it to know
        // which names come first at the time of sorting.
        String fullNames[] = new String[curr];

        for (int i = 0; i < curr; i++) {
            String fullName = lastNames[i] + names[i];
            fullNames[i] = fullName;
        }

        // Sort every array based on the full names.
        insertionSort(fullNames);

        for (int i = 0; i < curr; i++) {
            System.out.printf("%-42s%-31s%-13s%-12sage%6s", lastNames[i] + ", " + names[i], emails[i], phones[i], dates[i], getAge(dates[i]));

            if (i < curr - 1) System.out.println();
        }

        sc.close();
    }


    static int getAge(String date) {
        // Returns the age of a person born on date, assuming it's 20 of February of 2020.
        String dateArr[] = date.split("-");

        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);

        int age = 2020 - year;

        if (month > 2 || (month == 2 && day > 20)) {
            age--;
        }

        return age;
    }


    static void insertionSort(String arr[]) {
        // j is decremented in each iteration to compare each element of the array to the
        // previous one.
        int j;

        for (int i = 1; i < arr.length; i++) {
            // Iterate through every position of the array.
            j = i;

            while (j > 0 && arr[j - 1].toLowerCase().compareTo(arr[j].toLowerCase()) > 0) {
                // Swap the values of every array, until the original one is ordered.
                swap(j, arr);
                swap(j, lastNames);
                swap(j, names);
                swap(j, phones);
                swap(j, emails);
                swap(j, dates);
                j--;
            }
        }

        System.out.println("SORTED: %s".formatted(Arrays.toString(lastNames)));
    }


    static void swap(int i, String arr[]) {
        String temp = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = temp;
    }
}