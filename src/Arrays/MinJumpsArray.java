package Arrays;

public class MinJumpsArray {

    public int calcMin(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int[] saved = new int[arr.length];
        saved[arr.length - 1] = 0; // last

        for (int i = arr.length - 2; i >= 0; i--) {
            int jump = arr[i];
            int leftAfterJump = (arr.length - 1 - i) - jump;

            if (leftAfterJump == 0) {
                saved[i] = 1;
            } else if (leftAfterJump > 0) {
                saved[i] = Math.min(
                        saved[i + 1] + 1,
                        saved[i + jump] + 1);

            } else {
                saved[i] = saved[i + 1] + 1;
            }
        }

        return saved[0];
    }

    public static void main(String args[]) {
        MinJumpsArray mja = new MinJumpsArray();

        int[] arr = new int[] {2,3,1,5,2,2,2};

//        int[] arr = new int[] {6,3,1,5,2,2,2};
//        int[] arr = new int[] {2};
//        int[] arr = new int[] {};
//        int[] arr = new int[] {1,2};
//        int[] arr = new int[] {3,2};

        System.out.println(" Min Jumps Array is "  + mja.calcMin(arr));
    }
}
