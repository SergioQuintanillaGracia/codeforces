import java.util.*;

public class p2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentId = 0;
        int idSum = 0;
        boolean valid = true;

        while (sc.hasNext()) {
            valid = true;
            currentId++;

            String input = sc.nextLine();
            String[][] fInput = formatInput(input);

            for (int i = 0; i < fInput.length; i++) {
                String[] info = fInput[i];

                for (int j = 0; j < info.length; j++) {
                    String[] current = fInput[i][j].split(" ");
                    int currentCount = Integer.parseInt(current[0]);
                    String currentColor = current[1];

                    switch (currentColor) {
                        case "red":
                            if (currentCount > 12) valid = false;
                            break;

                        case "green":
                            if (currentCount > 13) valid = false;
                            break;
                        
                        case "blue":
                            if (currentCount > 14) valid = false;
                            break;
                    }
                }
            }

            if (valid) {
                idSum += currentId;
            }

            System.out.println(idSum);
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