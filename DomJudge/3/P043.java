import java.util.*;

public class P043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        String matrix1[][] = null;
        String matrix2[][] = null;

        while (sc.hasNext()) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            sc.nextLine();

            if (isFirst) {
                matrix1 = new String[rows][cols];

                for (int i = 0; i < rows; i++) {
                    matrix1[i] = (sc.nextLine().trim().split(" +"));
                }
            
            } else {
                matrix2 = new String[rows][cols];

                for (int i = 0; i < rows; i++) {
                    matrix2[i] = (sc.nextLine().trim().split(" +"));
                }

                // Now, both matrices have been inputted, check if they have the same number of rows and cols.
                if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
                    // Print the resulting matrix.
                    System.out.printf("%d %d\n", rows, cols);

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("%5d ", Integer.parseInt(matrix1[i][j])
                                + Integer.parseInt(matrix2[i][j]));
                        }

                        System.out.println();
                    }
                
                } else {
                    System.out.println("Impossible to add two matrices of different dimensions!");
                }
            }

            // Toggle the value of isFirst.
            isFirst = isFirst ? false : true;
        }
    }
}