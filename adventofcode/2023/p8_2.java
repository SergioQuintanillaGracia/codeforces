import java.util.*;

public class p8_2 {
    static HashMap<String, String[]> elements = new HashMap<>();
    static ArrayList<String> positions = new ArrayList<>();
    static ArrayList<Integer> stepsArr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String instructions = "";
        boolean instructRead = false;

        while (sc.hasNext()) {
            String line = sc.nextLine();

            if (line.equals("-1")) break;
            
            if (!instructRead) {
                // If it's the first line, read the instructions.
                instructions = line;
                instructRead = true;
            
            } else if (!line.equals("")) {
                // Read a line and store the data in the elements HashMap.
                String key = line.split(" = ")[0];
                String valuesStr = line.split(" = ")[1];
                String values[] = valuesStr.substring(1, valuesStr.length() - 1).split(", ");

                elements.put(key, values);
            }
        }

        int currInstrIndex = 0;
        
        // Fill the currPos array.
        for (String s : elements.keySet()) {
            if (s.charAt(2) == 'A') positions.add(s);
        }
        
        for (String pos : positions) {
            int steps = 0;
            
            // Get the steps needed to get each position to another one, ending in Z.
            while (pos.charAt(2) != 'Z') {
                steps++;

                // Move to a new position based on the current instruction.
                if (instructions.charAt(currInstrIndex) == 'L') {
                    pos = elements.get(pos)[0];
                
                } else if (instructions.charAt(currInstrIndex) == 'R') {
                    pos = elements.get(pos)[1];
                }

                // Increment the current instruction index.
                if (++currInstrIndex == instructions.length()) currInstrIndex = 0;
            }

            stepsArr.add(steps);
        }

        for (long i : stepsArr) {
            System.out.print("%d, ".formatted(i));
        }
        System.out.println();

        System.out.println("LCM: %d".formatted(lcm(stepsArr.get(0), stepsArr.get(1))));
        System.out.println("GCD: %d".formatted(gcd(stepsArr.get(0), stepsArr.get(1))));

        
        System.out.println(lcm(stepsArr));
    }


    public static long lcm(List<Integer> arr) {
        long currLcm = arr.get(0);

        for (int i = 1; i < arr.size() - 1; i++) {
            currLcm = lcm(currLcm, arr.get(i));
        }

        return lcm(currLcm, arr.get(arr.size() - 1));
    }

    
    public static long lcm(long a, long b) {
        long gcfAB = gcd(a, b);

        return (a * b) / gcfAB;
    }


    public static long gcd(long a, long b) {
        for (long i = Math.min(a, b); i > 0; i--) {
            if (isLong(((double) a) / i) && isLong(((double) b) / i)) {
                return i;
            }
        }

        return -1;
    }


    public static boolean isLong(double x) { return (x == (long) x); }
}
