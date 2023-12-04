import java.util.*;

public class p3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            
            if (line.equals("a")) break;

            lines.add(line);
        }

        System.out.println("Started algorithm");

        for (int row = 0; row < lines.size(); row++) {
            for (int col = 0; col < lines.get(row).length(); col++) {
                if (lines.get(row).charAt(col) == '*') {
                    // map matches an ArrayList that contains {row, start_col, end_col} with
                    // the number the ArrayList refers to.
                    // It is used to compare two numbers that may be the same, but be in
                    // different positions around the same *. If we used a simple ArrayList to
                    // store the numbers, same numbers in different position would be considered
                    // as 1.
                    HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();



                    if (checkExistence(row, col - 1, lines)) {
                        // Check the left character
                        if (checkChar(lines.get(row).charAt(col - 1))) {
                            int[] num = getNum(lines, row, col - 1);

                            if (num[0] != -1) {
                                System.out.printf("Found %d\n", num[0]);

                                map.put(new ArrayList<>(List.of(num[1], num[2], num[3])), num[0]);
                            }
                        }
                    }

                    if (checkExistence(row, col + 1, lines)) {
                        // Check the right character
                        if (checkChar(lines.get(row).charAt(col + 1))) {
                            int[] num = getNum(lines, row, col + 1);
                            
                            if (num[0] != -1) {
                                System.out.printf("Found %d\n", num[0]);

                                map.put(new ArrayList<>(List.of(num[1], num[2], num[3])), num[0]);
                            }
                        }
                    }

                    // Check the upper characters
                    for (int i = col - 1; i <= col + 1; i++) {
                        
                        if (checkExistence(row - 1, i, lines)) {
                            System.out.printf("x: %d, y: %d\n", row - 1, i);
                            int[] num = getNum(lines, row - 1, i);

                            if (num[0] != -1) {
                                System.out.printf("Found %d at x: %d, y: %d\n", num[0], row - 1, i);

                                map.put(new ArrayList<>(List.of(num[1], num[2], num[3])), num[0]);
                            }
                        }
                    }

                    // Check the lower characters
                    for (int i = col - 1; i <= col + 1; i++) {
                        if (checkExistence(row + 1, i, lines)) {
                            int[] num = getNum(lines, row + 1, i);

                            if (num[0] != -1) {
                                System.out.printf("Found %d\n", num[0]);

                                map.put(new ArrayList<>(List.of(num[1], num[2], num[3])), num[0]);
                            }
                        }
                    }

                    if (map.size() == 2) {
                        sum += (Integer) map.values().toArray()[0] * (Integer) map.values().toArray()[1];
                    }
                }
            }

            System.out.println("Current sum: %d".formatted(sum));
        }
    }


    public static boolean checkExistence(int row, int col, ArrayList<String> lines) {
        if (row >= 0 && col >= 0) {
            // If both are positive, check if they are outside the bounds of the ArrayList.
            return row < lines.size() && col < lines.get(row).length();
        }

        return false;
    }


    public static boolean checkChar(char c) {
        return Character.isDigit(c);
    }


    public static int[] getNum(ArrayList<String> lines, int row, int col) {
        // Given any position where there is a number, it will return an array containing:
        // {num, row, start_col, end_col}
        // Returns an array of -1s if there's no number at that position.
        String charNum = "";  
        int finalCol = -1;

        if (!Character.isDigit(lines.get(row).charAt(col)))
            return new int[] {-1, -1, -1, -1};
        
        // Find where the number starts, and set that position as the new col.
        for (int i = col; i >= -1; i--) {
            if (i == -1) {
                // If i gets to -1, it means it didn't find any char that is not a digit, which means the new col is 0.
                col = 0;
                break;
            }

            if (!Character.isDigit(lines.get(row).charAt(i))) {
                // If we get to a char that is not a digit, the char at the left is the new col.
                col = i + 1;
                break;
            }
        }

        for (int i = col; i < lines.get(row).length(); i++) {
            Character currentChar = lines.get(row).charAt(i);

            if (currentChar > 47 && currentChar < 58) {
                charNum += currentChar;
            
            } else {
                finalCol = i - 1;
                break;
            }
        }

        if (finalCol == -1) {
            // If finalCol is still -1, it means the last number that was checked ended at the end
            // of the row.
            finalCol = lines.get(row).length() - 1;
        }
        
        if (!charNum.equals("")) return new int[] {Integer.parseInt(charNum), row, col, finalCol};
        else return new int[] {-1, -1, -1, -1};
    }


    public static int getNumLength(int num, int length) {
        if (num / 10 != 0) {
            return getNumLength(num / 10, ++length);
        }

        return ++length;
    }
}
