package Arrays;
// a = { 0, 0, 1, 2, 0}
// b = { 0, 1, 2, 0, 0}

public class IsOneArrayRotationAnother {

    public static boolean check(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        int i = 0, j = 0, lastStart = 0;

        while (j < 2 * b.length) {
            int k = j % b.length;
            if (a[i] == b[k]) {
                i++;
            } else {
                i = 0;
                lastStart++;
                j = lastStart;
            }

            if (i == a.length - 1) {
                return true;
            }

            j++;
        }

        return false;
    }

    public static void main(String args[]) {

        // i = 0
        // j = 0
        // k = 0

//        int[] a = { 1, 2 };
//        int[] b = { 2, 1 };


        int[] a = { 0, 0, 1, 2, 0 };
        int[] b = { 0, 1, 2, 0, 0 };

        //			0, 1, 2, /0, 0, 0, 1, 2, 0/,  0

        System.out.println(check(a, b) ? "found :)" : "not found :(");
    }

}