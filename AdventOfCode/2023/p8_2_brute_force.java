import java.util.*;

public class p8_2_brute_force {
    static HashMap<String, String[]> elements = new HashMap<>();
    static ArrayList<String> currPos = new ArrayList<>();

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

        long steps = 0;
        int currInstrIndex = 0;

        // Fill the currPos array.
        for (String s : elements.keySet()) {
            if (s.charAt(2) == 'A') currPos.add(s);
        }

        while (!allEndIn('Z')) {
            if (steps % 10000000 == 0) System.out.println(steps);

            steps++;

            // Move to a new position based on the current instruction.
            if (instructions.charAt(currInstrIndex) == 'L') {
                for (int i = 0; i < currPos.size(); i++) {
                    currPos.set(i, elements.get(currPos.get(i))[0]);
                }
            
            } else if (instructions.charAt(currInstrIndex) == 'R') {
                for (int i = 0; i < currPos.size(); i++) {
                    currPos.set(i, elements.get(currPos.get(i))[1]);
                }
            }

            // Increment the current instruction index.
            if (++currInstrIndex == instructions.length()) currInstrIndex = 0;
        }

        System.out.println(steps);
    }


    public static boolean allEndIn(char c) {
        for (String s : currPos) {
            if (s.charAt(2) != c) return false;
        }

        return true;
    }

    public static int howManyEndIn(char c) {
        int sum = 0;

        for (String s : currPos) {
            if (s.charAt(2) == c) sum++;
        }

        return sum;
    }
}
