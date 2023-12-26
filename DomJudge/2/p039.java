import java.util.*;

public class p039 {
    private static double x, y, z;
    private static double influence = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine().trim();

            if (!line.equals("")) {
                // Receive the input for the test case.
                if (line.charAt(0) == 't') {
                    // The line contains the target position coordinates.
                    String lineArrStr[] = line.split(": ")[1].split(" ");
                    x = Double.parseDouble(lineArrStr[0]);
                    y = Double.parseDouble(lineArrStr[1]);
                    z = Double.parseDouble(lineArrStr[2]);
                
                } else {
                    // The line contains a jedi or sith position.
                    // First, we get the data.
                    String lineArrStr[] = line.split(": ")[1].split(" ");
                    double currX = Double.parseDouble(lineArrStr[0]);
                    double currY = Double.parseDouble(lineArrStr[1]);
                    double currZ = Double.parseDouble(lineArrStr[2]);
                    double strength = Double.parseDouble(lineArrStr[3]);

                    // We get the distance from the person to the individual.
                    double dist = Math.sqrt(Math.pow(x - currX, 2) + Math.pow(y - currY, 2)
                        + Math.pow(z - currZ, 2));
                    
                    // If the distance is smaller than the strength, they are influenced by
                    // that strength.
                    // Addition or subtraction of the strength will depend on if it is a jedi
                    // or a sith.
                    if (dist < strength) {
                        if (line.charAt(0) == 'j') {
                            // It is a jedi.
                            influence += strength;
                        
                        } else {
                            // It is a sith.
                            influence -= strength;
                        }
                    }
                }
            
            } else {
                // The line is empty, the current case input has ended.
                // Output the result.
                outputMessage(influence);

                // Reset the values of the variables to prepare them for the next test case.
                influence = 0;
                x = y = z = 0;
            }
        }

        // When the code gets here, the last test case will have been inputted.
        // We also have to consider this last case.
        outputMessage(influence);

        sc.close();
    }


    public static void outputMessage(double influence) {
        if (influence > 0) {
            System.out.printf("mortal at (%.2f,%.2f,%.2f) is protected\n", x, y, z);
        
        } else if (influence < 0) {
            System.out.printf("mortal at (%.2f,%.2f,%.2f) is in danger\n", x, y, z);
        
        } else {
            System.out.printf("mortal at (%.2f,%.2f,%.2f) is in no man's land\n", x, y, z);
        }
        
    }
}
