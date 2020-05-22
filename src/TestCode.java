import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class TestCode {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4};
        int[] arr = new int[]{-1,-2,-3,-4,-6};
        final int ret = Arrays.binarySearch(arr, 10);
        System.out.println("ret " + ret);


        String[] strArr = new String[] {"vv" ,"bbb"};
        final int minLen = Arrays.stream(strArr)
                // .map(String::length)
                .min(Comparator.comparing(String::length))
                .get()
                .length();
        System.out.println("minLen " + minLen);

        final int lengthsSum = Arrays.stream(strArr).mapToInt(String::length).sum();
        System.out.println("lengthsSum " + lengthsSum);

        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(10);
        lst.add(20);
        final Iterator<Integer> iterator = lst.iterator();
        Integer val = iterator.next();
        System.out.println("val 1 - " + val);
        val = iterator.next();
        System.out.println("val 2 - " + val);
    }
}
