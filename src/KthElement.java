import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthElement {

    private void constructPriorityQueue(int arr[], PriorityQueue<Integer> pq) {
        for (int i=0; i< arr.length; i++) {
            pq.add(arr[i]);
        }
    }

    public static int getKthElement(int arr[], int k) {

        // 1. PriorityQueue (MIN) - construct 		o(n)
        // 2. Poll k items  ==> 	o(log n) * k

        int len = arr.length;

        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Arrays.asList(arr));
        // constructPriorityQueue(arr, pq);

        // Arrays.asList(arr) ==> WRONG (will place 1 element, the array itself)

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                Arrays.stream(arr).boxed().collect(Collectors.toList())
        );

        int kthElement = 0;
        for (int i=0; i<k; i++) {
            kthElement = pq.poll();
        }

        return kthElement;
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 2, 1, 4, 3, 2 };
        int k = 4;

        int kthElement = getKthElement(arr, k);

        System.out.println("kthElement is " + kthElement);
    }

}