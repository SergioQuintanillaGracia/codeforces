import java.util.*;

public class p1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String curr;
        
        while (true) {
            curr = sc.nextLine();


            if (curr.equals("-1")) break;

            sum += getStringValue(curr);
        }

        System.out.println(sum);

        sc.close();
    }


    public static int getStringValue(String str) {
        int currCharInt;
        int first = -1;
        int second = 0;

        str = getNumberString(str);

        for (int i = 0; i < str.length(); i++) {
            currCharInt = str.charAt(i);

            if (currCharInt > 47 && currCharInt < 58) {
                if (first == -1) {
                    first = currCharInt - 48;
                }

                second = currCharInt - 48;
            }
        }

        return first * 10 + second;
    }


    public static String getNumberString(String str) {
        String[] nums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < nums.length; i++) {
            str = str.replace(nums[i], "%c%d%c".formatted(nums[i].charAt(0), i + 1, nums[i].charAt(nums[i].length() - 1)));
        }

        return str;
    }
}
