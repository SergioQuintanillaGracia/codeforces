import java.util.*;


public class p032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirstLine = true;

        while (sc.hasNext()) {
            String line[] = sc.nextLine().trim().split(" ");

            String shape = line[0];
            int size = Integer.parseInt(line[1]);
            char c = line[2].charAt(0);

            if (!isFirstLine) System.out.println();
            else isFirstLine = false;

            switch (shape) {
                case "square":
                    drawSquare(size, c);
                    break;
                case "triangle":
                    drawTriangle(size, c);
                    break;
                case "down-arrow":
                    drawDownArrow(size, c);
                    break;
                case "left-arrow":
                    drawLeftArrow(size, c);
                    break;
                case "right-arrow":
                    drawRightArrow(size, c);
                    break;
                case "diamond":
                    drawDiamond(size, c);
                    break;
                case "trapecious":
                    drawTrapecious(size, c);
                    break;
            }
        }

        sc.close();
    }


    public static void drawSquare(int size, char c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size * 2; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void drawTriangle(int size, char c) {
        int finalSize = size * 2 - 1;

        for (int i = 0; i < size; i++) {
            int charSize = i * 2 + 1;

            // Print initial line spaces.
            for (int j = 0; j < (finalSize - charSize) / 2; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }

            System.out.println();
        }
    }


    public static void drawDownArrow(int size, char c) {
        int maxSize = size * 2 - 1;

        for (int i = size - 1; i >= 0; i--) {
            int charSize = i * 2 + 1;

            // Print initial line spaces.
            for (int j = 0; j < (maxSize - charSize) / 2; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }

            System.out.println();
        }
    }


    public static void drawLeftArrow(int size, char c) {
        int maxSize = size * 2 - 1;

        // Draw the upper part of the arrow.
        for (int i = 0; i < maxSize / 2 + 1; i++) {
            int charSize = i * 2 + 1;
            
            // Print the initial spaces.
            for (int j = 0; j < maxSize - charSize; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }

            System.out.println();
        }

        // Draw the lower part of the arrow.
        for (int i = maxSize / 2; i > 0; i--) {
            int charSize = i * 2 - 1;
            
            // Print the initial spaces.
            for (int j = 0; j < maxSize - charSize; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }
            
            System.out.println();
        }
    }


    public static void drawRightArrow(int size, char c) {
        int maxSize = size * 2 - 1;

        // Draw the upper part of the arrow.
        for (int i = 0; i < maxSize / 2 + 1; i++) {
            // Print the correct amount of characters.
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print(c);
            }

            System.out.println();
        }

        // Draw the lower part of the arrow.
        for (int i = maxSize / 2; i > 0; i--) {
            // Print the correct amount of characters.
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print(c);
            }
            
            System.out.println();
        }
    }


    public static void drawDiamond(int size, char c) {
        // Draw the upper part of the diamond.
        drawTriangle(size, c);
        
        // Draw the lower part of the diamond.
        int maxSize = (size - 1) * 2 - 1;

        for (int i = size - 2; i >= 0; i--) {
            int charSize = i * 2 + 1;

            // Print initial line spaces.
            for (int j = 0; j < (maxSize - charSize) / 2 + 1; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }

            System.out.println();
        }
    }

    public static void drawTrapecious(int size, char c) {
        int finalSize = size * 2 + 1;

        for (int i = 0; i < size; i++) {
            int charSize = size + i * 2;

            // Print initial line spaces.
            for (int j = 0; j < (finalSize - charSize) / 2; j++) {
                System.out.print(" ");
            }

            // Print the correct amount of characters.
            for (int j = 0; j < charSize; j++) {
                System.out.print(c);
            }

            System.out.println();
        }
    }
}
