import java.util.*;

public class P044 {
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

                // Now, both matrices have been inputted, check if the number of columns of the first one
                // is equal to the number of rows of the second one.
                int rows1 = matrix1.length;
                int cols1 = matrix1[0].length;
                int rows2 = matrix2.length;
                int cols2 = matrix2[0].length;

                if (cols1 == rows2) {
                    // Print the resulting matrix.
                    System.out.printf("%d %d\n", rows1, cols2);

                    for (int i = 0; i < rows1; i++) {
                        for (int j = 0; j < cols2; j++) {
                            int curr = 0;
                            for (int k = 0; k < rows2; k++) {
                                curr += Integer.parseInt(matrix1[i][k]) * Integer.parseInt(matrix2[k][j]);
                            }

                            System.out.printf("%5d ", curr);
                        }

                        System.out.println();
                    }
                
                } else {
                    System.out.println("Number of columns of first matrix is not equal to the number of rows of the second one!");
                }
            }

            // Toggle the value of isFirst.
            isFirst = isFirst ? false : true;
        }
    }
}