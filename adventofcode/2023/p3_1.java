import java.util.*;

public class p3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            
            if (line.equals("-1")) break;

            lines.add(line);
        }

        System.out.println("Started algorithm");

        for (int row = 0; row < lines.size(); row++) {
            for (int col = 0; col < lines.get(row).length(); col++) {
                int currentNum = getNum(lines, row, col);
                boolean upperPassed = false;

                if (currentNum != -1) {
                    int numLength = getNumLength(currentNum, 0);
                    
                    System.out.printf("Checking %d\n", currentNum);

                    if (checkExistence(row, col - 1, lines)) {
                        // Check the left character
                        System.out.printf("%d checked by LEFT\n", currentNum);
                        if (checkChar(lines.get(row).charAt(col - 1))) {
                            System.out.printf("%d PASSED THE CHECK\n", currentNum);
                            sum += currentNum;
                            col += numLength - 1;
                            continue;
                        }
                    }

                    if (checkExistence(row, col + numLength, lines)) {
                        // Check the right character
                        System.out.printf("%d checked by RIGHT\n", currentNum);
                        if (checkChar(lines.get(row).charAt(col + numLength))) {
                            System.out.printf("%d PASSED THE CHECK\n", currentNum);
                            sum += currentNum;
                            col += numLength - 1;
                            continue;
                        }
                    }

                    // Check the upper characters
                    for (int i = col - 1; i < col + numLength + 1; i++) {
                        if (checkExistence(row - 1, i, lines)) {
                            System.out.printf("%d checked by UPPER\n", currentNum);
                            if (checkChar(lines.get(row - 1).charAt(i))) {
                                System.out.printf("%d PASSED THE CHECK\n", currentNum);
                                sum += currentNum;
                                col += numLength - 1;
                                upperPassed = true;
                                break;
                            }
                        }
                    }

                    // Check the lower characters
                    if (!upperPassed) {
                        for (int i = col - 1; i < col + numLength + 1; i++) {
                            if (checkExistence(row + 1, i, lines)) {
                                System.out.printf("%d checked by LOWER\n", currentNum);
                                if (checkChar(lines.get(row + 1).charAt(i))) {
                                    System.out.printf("%d PASSED THE CHECK\n", currentNum);
                                    sum += currentNum;
                                    col += numLength - 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Current sum: %d".formatted(sum));
        }
    }


    public static boolean checkExistence(int row, int col, ArrayList<String> lines) {
        if (row > 0 && col > 0) {
            // If both are positive, check if they are outside the bounds of the ArrayList.
            return row < lines.size() && col < lines.get(row).length();
        }

        return false;
    }


    public static boolean checkChar(char c) {
        if (c != '.' && ((c > 32 && c < 48) || (c > 57 && c < 111))) {
            return true;
        }

        return false;
    }


    public static int getNum(ArrayList<String> lines, int row, int col) {
        // Given the starting position of a number, it will return the number.
        // Returns -1 if there is no number at that position.
        String charNum = "";       
        
        for (int i = col; i < lines.get(row).length(); i++) {
            Character currentChar = lines.get(row).charAt(i);

            if (currentChar > 47 && currentChar < 58) {
                charNum += currentChar;
            
            } else break;
        }
        
        if (!charNum.equals("")) return Integer.parseInt(charNum);
        else return -1;
    }


    public static int getNumLength(int num, int length) {
        if (num / 10 != 0) {
            return getNumLength(num / 10, ++length);
        }

        return ++length;
    }
}
