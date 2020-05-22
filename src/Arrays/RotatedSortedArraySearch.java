package Arrays;

public class RotatedSortedArraySearch {

    public int check(int[] arr, int first, int last, int val) {

        if (first > last) {
            return -1; // should never get here, just as input check
        }

        int middle = first + (last - first) / 2;

        if (middle == first) { // consecutive (first + 1 == last) OR (first == last)
            if (arr[first] == val) return first;
            if (arr[last] == val) return last;
            return -1;
        }

        if (arr[first] <= arr[middle]) {
            if ((arr[first] <= val && val <= arr[middle]) /* || (first == middle) */){
                return check(arr, first, middle, val);
            } else {
                return check(arr, middle, last, val);
            }
        } else { // arr[first] > arr[middle]
            if ((arr[middle] <= val && arr[val] <= last) /* || (last == middle) */ ) {
                return check(arr, middle, last, val);
            } else {
                return check(arr, first, middle, val);
            }
        }
    }

    public static void main(String[] args) {

        RotatedSortedArraySearch rsas = new RotatedSortedArraySearch();
//        int[] arr = new int[] {10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr = new int[] {3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2};
        // int[] arr = new int[] {7, 8};

        int val = 1;

        System.out.println("RotatedSortedArraySearch:  " +
                rsas.check(arr, 0, arr.length - 1, val));
    }
}
