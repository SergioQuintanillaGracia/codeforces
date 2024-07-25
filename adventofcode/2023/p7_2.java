import java.util.*;

public class p7_2 {
    static char pointsOrder[] = new char[]
    {'J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A'};
    static HashMap<String, Integer> cardsBids = new HashMap<>();
    static ArrayList<String> cards = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;

        while (sc.hasNext()) {
            String line = sc.nextLine();

            if (line.equals("-1")) break;

            // Get the current card and bid and store it into the cards HashMap in
            // ascending order.
            String lineSplit[] = line.split(" ");

            cardsBids.put(lineSplit[0], Integer.parseInt(lineSplit[1]));
            insert(lineSplit[0]);
        }

        for (int i = 0; i < cards.size(); i++) {
            res += cardsBids.get(cards.get(i)) * (i + 1);
        }

        System.out.println(res);

        sc.close();
    }


    public static void insert(String card) {
        int index = cards.size();  // The index where the card will be inserted.

        for (int i = 0; i < cards.size(); i++) {
            if (getCardValue(cards.get(i)) > getCardValue(card)) {
                index = i;
                break;
            }
        }

        cards.add(index, card);
    }


    public static long getCardValue(String card) {
        long points = 0;

        for (int i = 0; i < card.length(); i++) {
            // Get the points value of each character in the card string.
            int charPoints = -1;

            // Search the character position in the pointsOrder array
            // to determine the points.
            for (int j = 0; j < pointsOrder.length; j++) {
                if (pointsOrder[j] == card.charAt(i)) {
                    charPoints = j + 1;
                    break;
                }
            }

            // Add the points based on the position the character is in, to
            // make it easier to determine which card is worth more.
            // The type is multiplied by 10^10 and added.
            // Output examples: 6A7J2 -> 10513061001
            //                  6A3J2 -> 10513021001
            points += charPoints * (Math.pow(10, (4 - i) * 2));
        }

        points += getType(card) * Math.pow(10, 10);

        return points;
    }


    public static int getType(String card) {
        HashMap<Character, Integer> occurr = new HashMap<>();
        int jCount = 0;

        // Map characters with the times they repeat.
        for (char c : card.toCharArray()) {
            if (c == 'J') {
                jCount++;

            } else {
                if (occurr.containsKey(c)) {
                    occurr.put(c, occurr.get(c) + 1);
                
                } else {
                    occurr.put(c, 1);
                }
            }
        }

        // Add the jokers to the most repeated character.
        char mostRepeatedChar = 'K';
        int mostRepeatedCharTimes = 0;
        
        for (char c : occurr.keySet()) {
            if (occurr.get(c) > mostRepeatedCharTimes) {
                mostRepeatedChar = c;
                mostRepeatedCharTimes = occurr.get(c);
            }
        }

        if (occurr.keySet().size() > 0) occurr.put(mostRepeatedChar, occurr.get(mostRepeatedChar) + jCount);
        else occurr.put(mostRepeatedChar, jCount);

        // Quickly handle the first 4 cases.
        if (occurr.containsValue(5)) return 7;
        if (occurr.containsValue(4)) return 6;
        if (occurr.containsValue(3) && occurr.containsValue(2)) return 5;
        if (occurr.containsValue(3) && !occurr.containsValue(2)) return 4;

        int repeated2 = 0;

        // Check how many characters are repeated 2 times.
        for (int i : occurr.values()) {
            if (i == 2) repeated2++;
        }

        if (repeated2 == 2) return 3;
        if (repeated2 == 1) return 2;
        if (repeated2 == 0) return 1;

        System.out.println("COULD NOT GET CARD TYPE");
        return -1;
    }


    public static void debugPrintCards() {
        for (String s : cards) {
            System.out.print("%s, ".formatted(s));
        }

        System.out.println();
    }
}