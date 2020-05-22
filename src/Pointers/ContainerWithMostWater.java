package Pointers;

public class  ContainerWithMostWater {

    public int check(int [] arr) {
        if (arr == null || arr.length <= 1 ) {
            return 0; // or illegal arg excep (for null)
        }

        int maxArea = 0;
        int i = 0, j = arr.length -1;
        while (i < j) {
            int currArea = Math.min(arr[i], arr[j]) * Math.abs(i - j);
            if (currArea > maxArea) {
                maxArea = currArea;
            }

            // keeping largest element at same index
            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        ContainerWithMostWater cwmw = new ContainerWithMostWater();
//        int[] arr = new int[] { 2, 5, 4, 3, 2 };
//        int[] arr = new int[] { 2, 5, 4, 3, 3 };
        int[] arr = new int[] { 2, 5, 4, 5, 3 };
        System.out.println("Pointers.ContainerWithMostWater - " + cwmw.check(arr));
    }
}
