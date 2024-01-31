import java.util.*;

public class P053 {
    static String lastNames[] = new String[200];
    static String names[] = new String[200];
    static String phones[] = new String[200];
    static String emails[] = new String[200];
    static String dates[] = new String[200];
    
    static String months[] = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userAmount = sc.nextInt();
        int count = 0;
        int curr = 0;
        sc.nextLine();

        boolean isSorted = false;
        boolean isFirstMonthPrint = true;

        while (sc.hasNext()) {
            if (count >= userAmount) {
                if (!isSorted) {
                    // Sort every array based on the dates.
                    insertionSort(dates, curr);
                    isSorted = true;
                }

                // The input now are months, not users. Print the users in the correct order.
                String month = sc.nextLine().trim();
                listSorted(month, !isFirstMonthPrint);

                isFirstMonthPrint = false;
            
            } else {
                // Add the user data to the arrays.
                // LAST NAMES
                String lastName = sc.nextLine().trim().replaceAll(" +", " ");
                
                // NAME
                String name = sc.nextLine().trim();
                
                // PHONE NUMBER
                String phone = sc.nextLine().trim();
                
                // EMAIL
                String email = sc.nextLine().trim();
                
                // BIRTH DATE
                String date = sc.nextLine().trim().replaceAll(" +", "-");
                
                if (!(contains(lastNames, lastName) && contains(names, name) && contains(phones, phone)
                    && contains(emails, email) && contains(dates, date))) {
                    lastNames[curr] = lastName;
                    names[curr] = name;
                    phones[curr] = phone;
                    emails[curr] = email;
                    dates[curr] = date;

                    curr++;
                }

                count++;
            }
        }

        

        sc.close();
    }


    static boolean contains(String arr[], String str) {
        for (String s : arr) {
            if (s == null) break;
            
            if (s.equals(str)) return true;
        }

        return false;
    }


    static void listSorted(String monthStr, boolean printSpace) {
        boolean atLeastOneFound = false;

        if (printSpace) System.out.println();

        for (int i = 0; i < 200; i++) {
            if (dates[i] == null) {
                break;
            
            } else if (getMonth(dates[i]) == getMonthNum(monthStr)) {
                // The user has to be printed.
                if (!atLeastOneFound) {
                    System.out.println("# ----------------------------------------");
                    System.out.println("# Birth days for month " + monthStr);
                    atLeastOneFound = true;
                }

                printUser(i);
            }
        }

        if (atLeastOneFound) {
            System.out.println("# ----------------------------------------");
        
        } else {
            System.out.println("# No birth days for month " + monthStr);
        }
    }


    static int getMonth(String date) {
        String dateArr[] = date.split("-");
        return Integer.parseInt(dateArr[1]);
    }


    static int getMonthNum(String month) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month)) return i + 1;
        }

        return -1;
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

            while (j > 0 && isOlder(arr[j - 1], arr[j])) {
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


    static void printUser(int i) {
        System.out.printf("%-42s%-31s%-13s%-12sage%6s\n", lastNames[i] + ", " + names[i], emails[i], phones[i], dates[i], getAge(dates[i]));
    }
}