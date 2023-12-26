import java.util.*;

public class p037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String lineArr[] = sc.nextLine().trim().split(" +");
            double x = Double.parseDouble(lineArr[0]);
            double y = Double.parseDouble(lineArr[1]);

            printQuadrantInfo(x, y);
        }

        sc.close();
    }


    public static void printQuadrantInfo(double x, double y) {
        String str = String.format("( %.2f, %.2f ) is located ", x, y);

        if (x == 0 && y == 0) {
            str += "at the origin of coordinates";
        
        } else if (x != 0 && y == 0) {
            str += "over the x-axis";
        
        } else if (x == 0 && y != 0) {
            str += "over the y-axis";
        
        } else if (x > 0 && y > 0) {
            str += "in the first quadrant";
        
        } else if (x < 0 && y > 0) {
            str += "in the second quadrant";
        
        } else if (x < 0 && y < 0) {
            str += "in the third quadrant";
        
        } else {
            str += "in the fourth quadrant";
        }

        System.out.println(str);
    }
}
