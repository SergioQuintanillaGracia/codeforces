    import java.util.*;

    public class p8_1 {
        static HashMap<String, String[]> elements = new HashMap<>();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String instructions = "";
            String currPos = "AAA";
            String destPos = "ZZZ";
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

            int steps = 0;
            int currInstrIndex = 0;

            while (!currPos.equals(destPos)) {
                System.out.print("Currently in %s  |  ".formatted(currPos));
                steps++;

                // Move to a new position based on the current instruction.
                if (instructions.charAt(currInstrIndex) == 'L') {
                    System.out.println("Going to the left (Index: %d)".formatted(currInstrIndex));
                    currPos = elements.get(currPos)[0];
                
                } else if (instructions.charAt(currInstrIndex) == 'R') {
                    System.out.println("Going to the right (Index: %d)".formatted(currInstrIndex));
                    currPos = elements.get(currPos)[1];
                }

                // Increment the current instruction index.
                if (++currInstrIndex == instructions.length()) currInstrIndex = 0;
            }

            System.out.println(steps);
        }
    }
