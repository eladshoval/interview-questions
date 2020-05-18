package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MajorityElementInArray {

    public static int getCommonElement(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array can't be empty or null");
        }

        int m = (int)java.lang.Math.floor(arr.length / 2);

        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>(m);
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            Integer elementCount = countMap.get(element);
            if (elementCount == null) {
                countMap.put(element, 1);
            } else {
                countMap.put(element, elementCount + 1);
            }
        }

        return countMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

    }

    // o(n * log n)
    public static int getCommonElementBAD(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array can't be empty or null");
        }

        int m = (int)java.lang.Math.floor(arr.length / 2);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                Arrays.stream(arr).boxed().collect(Collectors.toList())
        );

        Integer majorityElement = 0;
        int majorityElementCount = 0;

        Integer currElement = 0;
        int currElementCount = 0;

        for (int i = 0; i < arr.length; i++) {
            Integer element = pq.poll(); // o(log n)

            if (element != currElement) {
                currElement = element;
                currElementCount = 0;
            }

            currElementCount++;

            if (majorityElementCount < currElementCount) {
                majorityElementCount = currElementCount;
                majorityElement = currElement;
            }

            if (majorityElementCount == m) {
                return majorityElement;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{2, 1, 2, 2, 4, 4, 4, 4};

        int commonElement = getCommonElement(arr);
        System.out.println("commonElement = " + commonElement);
    }

}