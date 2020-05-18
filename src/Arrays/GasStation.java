package Arrays;

public class GasStation {


    public static int getMinStartIndex(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            int left = 0;
            int j = i;
            do {
                left += a[j] - b[j];
                j = (j + 1) % a.length;

                if (left < 0) {
                    j = a.length; // invalidate j
                    break;
                }
            } while (j != i);

            if (j == i) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String args[]) {
        int[] gas = new int[]{1, 2};
        int[] road = new int[]{2, 1};

        int minIndex = getMinStartIndex(gas, road);
        System.out.println("PASS - minIndex = " + minIndex);

        gas = new int[]{1, 0, 2};
        road = new int[]{2, 3, 1};

        minIndex = getMinStartIndex(gas, road);
        System.out.println("FAIL - minIndex = " + minIndex);
    }

}
