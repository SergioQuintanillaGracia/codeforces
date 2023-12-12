import java.util.*;

// NOTE: Remember to update the initial value of dir MANUALLY accordingly.

public class p10_1 {
    static String RIGHT = "right";
    static String LEFT = "left";
    static String UP = "up";
    static String DOWN = "down";

    static ArrayList<char[]> pipes = new ArrayList();
    static String dir = UP;  // Direction we are moving to. It must be updated
                             // accordingly depending on the case we are testing.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = 0;

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

        // Move the current position by one, based on the starting direction.
        if (dir.equals(RIGHT)) x += 1;
        if (dir.equals(LEFT)) x -= 1;
        if (dir.equals(UP)) y -= 1;
        if (dir.equals(DOWN)) y += 1;

        do {
            steps++;

            // Update the position.
            int increment[] = getIncrement(get(x, y));
            x += increment[0];
            y += increment[1];

            // Update the direction:
            if (increment[0] == -1) dir = LEFT;
            if (increment[0] == 1) dir = RIGHT;
            if (increment[1] == -1) dir = UP;
            if (increment[1] == 1) dir = DOWN;
        
        } while (get(x, y) != 'S');

        steps++;

        System.out.println(steps / 2);

        sc.close();
    }


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


    public static char get(int x, int y) {
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