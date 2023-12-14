import java.util.*;

public class p11_1 {
    static ArrayList<ArrayList<Character>> space = new ArrayList<>();
    // Will store the locations of every galaxy.
    static ArrayList<int[]> galLoc = new ArrayList<>();
    // Will store the locations of the galaxies that have been connected.
    static ArrayList<int[][]> connected = new ArrayList<>();
    // Will store the column positions where the space has been expanded.
    static ArrayList<Integer> expCols = new ArrayList<>();
    // Same as the above, but with rows.
    static ArrayList<Integer> expRows = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currRow = 0;
        long sum = 0;

        while (sc.hasNext()) {
            // Read the input.
            String line = sc.nextLine();
            if (line.equals("-1")) break;

            // Add the input to the space ArrayList.
            ArrayList<Character> input = new ArrayList<>();

            for (char c : line.toCharArray()) {
                input.add(c);
            }

            space.add(input);

            // Add the current row to expRows if it doesn't have galaxies.
            if (!line.contains("#")) expRows.add(currRow);

            currRow++;
        }

        // Check with columns need to be expanded due to the lack of galaxies.
        for (int i = 0; i < space.get(0).size(); i++) {
            StringBuilder col = new StringBuilder();

            for (int j = 0; j < space.size(); j++) {
                col.append(space.get(j).get(i));
            }

            String colS = col.toString();

            // Add the current row to expCols if it doesn't have galaxies.
            if (!colS.contains("#")) expCols.add(i);
        }

        // Fill the galLoc array with the position of every galaxy.
        for (int i = 0; i < space.get(0).size(); i++) {
            for (int j = 0; j < space.size(); j++) {
                // i is x, j is y.
                if (space.get(j).get(i) == '#') {
                    galLoc.add(new int[]{i, j});
                }
            }
        }

        // Iterate through every galaxy position in galPos.
        for (int i = 0; i < galLoc.size(); i++) {
            System.out.println("%d / %d".formatted(i, galLoc.size()));
            for (int j = 0; j < galLoc.size(); j++) {
                int[] gal1 = galLoc.get(i);
                int[] gal2 = galLoc.get(j);

                if (!alreadyConnected(gal1, gal2)) {
                    // Add to the total sum the difference between each coordinate of the
                    // galaxies.
                    sum += getSpace(gal1, gal2, 1);
                }

                connected.add(new int[][]{gal1, gal2});
            }
        }

        System.out.println(sum);

        sc.close();
    }


    public static boolean alreadyConnected(int[] gal1, int[] gal2) {
        for (int[][] i : connected) {
            if ((equals(i[0], gal1) && equals(i[1], gal1)) || (equals(i[0], gal2) && equals(i[0], gal1))) {
                // Both galaxies appear inside the visited ArrayList.
                return true;
            }
        }

        return false;
    }


    public static boolean equals(int[] a, int[] b) {
        // Iterates through every element of both arrays, and, if it finds a
        // difference, it means they are not equal.
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return false;
            }

            return true;
        
        } else return false;
    }


    public static long getSpace(int[] g1, int[] g2, int factor) {
        long sum = 0;

        // Add the difference between their coordinates.
        int diffX = Math.abs(g1[0] - g2[0]);
        int diffY = Math.abs(g1[1] - g2[1]);
        sum += diffX + diffY;

        int smallerX = g1[0] < g2[0] ? g1[0] : g2[0];
        int greaterX = g1[0] < g2[0] ? g2[0] : g1[0];
        int smallerY = g1[1] < g2[1] ? g1[1] : g2[1];
        int greaterY = g1[1] < g2[1] ? g2[1] : g1[1];

        // Check how many rows there have expanded between them.
        for (int i : expCols) {
            if (i > smallerX && i < greaterX) {
                sum += factor;
            }
        }

        // Check how many cols there have expanded between them.
        for (int i : expRows) {
            if (i > smallerY && i < greaterY) {
                sum += factor;
            }
        }

        return sum;
    }
}