import java.util.*;

public class P052 {
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

        // Sort every array based on the dates.
        insertionSort(dates, curr);

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

    static boolean isOlder(String date1, String date2) {
        String date1ArrStr[] = date1.split("-");
        String date2ArrStr[] = date2.split("-");
        int date1Arr[] = new int[3];
        int date2Arr[] = new int[3];

        for (int i = 0; i < 3; i++) {
            date1Arr[i] = Integer.parseInt(date1ArrStr[i]);
            date2Arr[i] = Integer.parseInt(date2ArrStr[i]);
        }

        int days1 = date1Arr[0] * 365 + date1Arr[1] * 30 + date1Arr[2];
        int days2 = date2Arr[0] * 365 + date2Arr[1] * 30 + date2Arr[2];

        if (days1 < days2) return true;
        else return false;
    }


    static void insertionSort(String arr[], int size) {
        // j is decremented in each iteration to compare each element of the array to the
        // previous one.
        int j;

        for (int i = 1; i < size; i++) {
            // Iterate through every position of the array.
            j = i;

            while (j > 0 && isOlder(arr[j], arr[j - 1])) {
                // Swap the values of every array, until the original one is ordered.
                swap(j, lastNames);
                swap(j, names);
                swap(j, phones);
                swap(j, emails);
                swap(j, dates);
                j--;
            }
        }
    }


    static void swap(int i, String arr[]) {
        String temp = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = temp;
    }
}