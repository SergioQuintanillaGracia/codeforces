import java.util.*;

public class p2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int powerSum = 0;

        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[][] fInput = formatInput(input);

            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;

            for (int i = 0; i < fInput.length; i++) {
                String[] info = fInput[i];

                for (int j = 0; j < info.length; j++) {
                    String[] current = fInput[i][j].split(" ");
                    int currentCount = Integer.parseInt(current[0]);
                    String currentColor = current[1];

                    switch (currentColor) {
                        case "red":
                            maxRed = currentCount > maxRed ? currentCount : maxRed;
                            break;

                        case "green":
                            maxGreen = currentCount > maxGreen ? currentCount : maxGreen;
                            break;
                        
                        case "blue":
                            maxBlue = currentCount > maxBlue ? currentCount : maxBlue;
                            break;
                    }
                }
            }

            powerSum += maxRed * maxGreen * maxBlue;
            
            System.out.println(powerSum);
        }

        sc.close();
    }


    public static String[][] formatInput(String str) {
        String[] tempGameData = str.split(": ")[1].split("; ");
        String[][] gameData = new String[tempGameData.length][3];

        for (int i = 0; i < tempGameData.length; i++) {
            String[] info = tempGameData[i].split(", ");
            gameData[i] = info;
        }

        return gameData;
    }


    // DEBUG METHODS:
    
    public static void debugPrintArray(String[][] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");

            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }

            System.out.print("]");
        }

        System.out.print("]");
    }


    public static void debugPrintArray(String[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print("]");
    }
}