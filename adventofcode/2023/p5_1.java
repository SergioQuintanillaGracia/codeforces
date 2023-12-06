import java.util.*;

public class p5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currArray = -1;
        // Arrays will be:
        // 0 - seed to soil             1 - soil to fertilizer
        // 2 - fertilizer to water      3 - water to light
        // 4 - light to temperature     5 - temperature to humidity
        // 6 - humidity to location
        ArrayList<ArrayList<long[]>> arrays = new ArrayList<>();
        long seeds[] = null;
        boolean seedsRead = false;

        // Create the 7 ArrayLists.
        for (int i = 0; i < 7; i++) {
            arrays.add(new ArrayList<long[]>());
        }

        while (sc.hasNext()) {
            String line = sc.nextLine();

            if (line.equals("-1")) break;

            if (line.length() > 0) {
                // The line is not empty.
                if (!Character.isDigit(line.charAt(0))) {
                    // The first character is not a digit, the line switches the array
                    // where the input will be stored.
                    
                    if (seedsRead) currArray++;

                    if (currArray == -1) {
                        // If it's the first line that doesn't have a digit as its first
                        // character, it's the seeds line. We need to store the seeds into
                        // an array.
                        String seedsStr[] = line.split(": ")[1].split(" ");
                        seeds = new long[seedsStr.length];

                        // Transform the string elements into ints, and add them to the
                        // seeds array.
                        for (int i = 0; i < seedsStr.length; i++) {
                            seeds[i] = Long.parseLong(seedsStr[i]);
                        }

                        seedsRead = true;
                    }
                
                } else {
                    if (currArray <= 6) {
                        // Split the input array.
                        String[] arrS = line.split(" ");
                        long[] arr = new long[arrS.length];

                        // Move the arrS elements to arr as longs.
                        for (int i = 0; i < arrS.length; i++) {
                            arr[i] = Long.parseLong(arrS[i]);
                        }

                        // Add the new array to the corresponding ArrayList in arrays.
                        arrays.get(currArray).add(arr);
                    }
                }
            }
        }

        long min = Long.MAX_VALUE;

        for (long seed : seeds) {
            long soil = getCorresp(seed, 0, arrays);
            long fertilizer = getCorresp(soil, 1, arrays);
            long water = getCorresp(fertilizer, 2, arrays);
            long light = getCorresp(water, 3, arrays);
            long temperature = getCorresp(light, 4, arrays);
            long humidity = getCorresp(temperature, 5, arrays);
            long location = getCorresp(humidity, 6, arrays);

            min = location < min ? location : min;
        }

        System.out.println("Final min: %d".formatted(min));
    }

    
    public static long getCorresp(long num, int arrIndex, ArrayList<ArrayList<long[]>> arrays) {
        ArrayList<long[]> array = arrays.get(arrIndex);

        for (long arr[] : array) {
            long destRangeStart = arr[0];
            long srcRangeStart = arr[1];
            long rangeLength = arr[2];

            if (num >= srcRangeStart && num < srcRangeStart + rangeLength) {
                // If the number is inside the range, return the new number according to
                // the data in the array.
                return num - srcRangeStart + destRangeStart;
            }
        }

        // If the number isn't inside any range, return it.
        return num;
    }
}
