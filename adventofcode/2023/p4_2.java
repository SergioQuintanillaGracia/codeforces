import java.util.*;

public class p4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentCard = 0;
        int[] cards = new int[205]; // If the number of cards was different, the array size must be changed.
        
        Arrays.fill(cards, 1);

        while (sc.hasNext()) {
            int matching = 0;
            String line = sc.nextLine();

            if (line.equals("a")) break;

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
                        // The number is a winning number, add one to the matching counter.
                        matching++;
                    }
                }
            }

            // Update the next {matching} cards in the cards array, adding x to each one,
            // where x is the current card.
            int currCardAmount = cards[currentCard];

            for (int i = currentCard + 1; i <= currentCard + matching; i++) {
                if (i < cards.length) {
                    cards[i] += currCardAmount;
                
                } else break;
            }

            currentCard++;

            System.out.println(arrSum(cards));
        }
    }


    public static int arrSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }


    public static void debugPrintArray(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print("]");
    }
}
