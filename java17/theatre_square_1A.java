import java.util.Scanner;

public class theatre_square_1A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int theatreLength = sc.nextInt();
        int theatreWidth = sc.nextInt();
        double stoneSide = sc.nextInt();

        long lengthStones = (long) Math.ceil(theatreLength / stoneSide);
        long widthStones = (long) Math.ceil(theatreWidth / stoneSide);

        System.out.println(lengthStones * widthStones);
    }
}
