import java.util.*;

public class p4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int points = 0;

        while (sc.hasNext()) {
            int currPoints = 0;
            String line = sc.nextLine();
            String[] lineDiv = line.split(" \\| +");

            String[] sWinNums = lineDiv[0].split(": +")[1].split(" +");
            String[] sNums = lineDiv[1].split(" +");
            int[] winNums = new int[sWinNums.length];
            int[] nums = new int[sNums.length];

            // Fill the winNums and nums arrays with the integer values of the strings in
            // sWinNums and sNums.
            for (int i = 0; i < sWinNums.length; i++) {
                winNums[i] = Integer.parseInt(sWinNums[i]);
            }

            for (int i = 0; i < sNums.length; i++) {
                nums[i] = Integer.parseInt(sNums[i]);
            }

            // Find how many numbers are repeated.
            for (int i = 0; i < winNums.length; i++) {
                int winNum = winNums[i];

                for (int j = 0; j < nums.length; j++) {
                    int num = nums[j];

                    if (winNum == num) {
                        // The number is a winning number, add the corresponding points.
                        if (currPoints > 0) {
                            currPoints *= 2;
                        
                        } else {
                            currPoints++;
                        }
                    }
                }
            }

            points += currPoints;

            System.out.println(points);
        }

        sc.close();
    }
}
