import java.util.*;

// NOTE: Remember to update the initial value of dir MANUALLY accordingly.
// It should be set to a direction where there is a pipe connected to S.

// NOTE: 'S' should only be added to switchChars if it acts as a '|' or corner in the
// case we are testing. If it acts like a '-', remove it.

public class p10_2 {
    static String RIGHT = "right";
    static String LEFT = "left";
    static String UP = "up";
    static String DOWN = "down";

    static ArrayList<char[]> pipes = new ArrayList<>();
    static ArrayList<int[]> pipesPos = new ArrayList<>();
    static String dir = LEFT;  // Direction we are moving to. It must be manually updated
                             // accordingly depending on the case we are testing.
    static boolean isInsideArea = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int area = 0;

        while (sc.hasNext()) {
            // Read the input and store it in the pipes ArrayList.
            String line = sc.nextLine();
            if (line.equals("-1")) break;
            pipes.add(line.toCharArray());
        }

        int sPos[] = getSPosition();
        // x and y will store the current position we are in.
        int x = sPos[0];
        int y = sPos[1];

        // Add the current position, the position of S, to the pipesPos array.
        pipesPos.add(new int[]{x, y});

        // Move the current position by one, based on the starting direction.
        if (dir.equals(RIGHT)) x += 1;
        if (dir.equals(LEFT)) x -= 1;
        if (dir.equals(UP)) y -= 1;
        if (dir.equals(DOWN)) y += 1;

        do {
            // Find the positions of the loop of pipes containing S, and store them
            // in the pipesPos ArrayList.
            pipesPos.add(new int[]{x, y});

            // Update the position.
            int increment[] = getIncrement(getChar(x, y));
            x += increment[0];
            y += increment[1];

            // Update the direction:
            if (increment[0] == -1) dir = LEFT;
            if (increment[0] == 1) dir = RIGHT;
            if (increment[1] == -1) dir = UP;
            if (increment[1] == 1) dir = DOWN;
        
        } while (getChar(x, y) != 'S');

        // Stores the previous relevant char (which doesn't account for - or .).
        char prevChar = ' ';

        for (int i = 0; i < pipes.size(); i++) {
            for (int j = 0; j < pipes.get(i).length; j++) {
                // j represents x, i represents y.
                if (contains(pipesPos, new int[]{j, i})) {
                    // If the current position is part of the pipe loop:
                    char c = getChar(j, i);
                    if (c == '|') {
                        prevChar = '|';
                        toggleArea();
                    }

                    if (c == '7') {
                        if (prevChar == 'F') toggleArea();
                        prevChar = c;
                    }

                    if (c == 'J') {
                        if (prevChar == 'L') toggleArea();
                        prevChar = c;
                    }

                    if (c == 'L' || c == 'F') {
                        toggleArea();
                        prevChar = c;
                    }

                } else {
                    if (isInsideArea) area++;
                }
            }

            isInsideArea = false;
        }

        System.out.println(area);

        sc.close();
    }


    public static void toggleArea() { isInsideArea = isInsideArea ? false : true; }


    public static int[] getSPosition() {
        for (int i = 0; i < pipes.size(); i++) {
            for (int j = 0; j < pipes.get(i).length; j++) {
                if (pipes.get(i)[j] == 'S') {
                    return new int[]{j, i};
                }
            }
        }

        return new int[]{-1, -1};
    }


    public static char getChar(int x, int y) {
        return pipes.get(y)[x];
    }


    public static int[] getIncrement(char c) {
        // Returns the increment in position based on the direction we are moving in the
        // pipe and on the character we are in.

        switch (c) {
            case '|':
                if (dir.equals(DOWN)) return new int[]{0, 1};
                else return new int[]{0, -1};

            case '-':
                if (dir.equals(RIGHT)) return new int[]{1, 0};
                else return new int[]{-1, 0};
            
            case 'L':
                if (dir.equals(DOWN)) return new int[]{1, 0};
                else return new int[]{0, -1};
            
            case 'J':
                if (dir.equals(DOWN)) return new int[]{-1, 0};
                else return new int[]{0, -1};

            case '7':
                if (dir.equals(UP)) return new int[]{-1, 0};
                else return new int[]{0, 1};
            
            case 'F':
                if (dir.equals(UP)) return new int[]{1, 0};
                else return new int[]{0, 1};
        }

        System.out.println("ERROR: Couldn't get increment");
        return new int[]{-1, -1};
    }


    public static boolean contains(ArrayList<int[]> list, int[] arr) {
        for (int[] a : list) {
            if (Arrays.equals(a, arr)) return true;
        }

        return false;
    }


    // DEBUG METHODS:
    
    public static void debugPrintArray(int[][] arr) {
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


    public static void debugPrintArray(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print("]");
    }
}