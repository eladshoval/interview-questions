import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TestCode {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4};
        int[] arr = new int[]{-1,-2,-3,-4,-6};
        final int ret = Arrays.binarySearch(arr, 10);
        System.out.println("ret " + ret);


        String[] strArr = new String[] {"vv" ,"bbb"};
        final int minLen = Arrays.stream(strArr)
                // .map(String::length)
                //.sorted(Comparator.comparing(String::length))
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

        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        changeInteger(val);
        System.out.println("val 3 - " + val);

        String pre = "9,1,2,3,#,#";

        class Temp {
            Boolean res = false;

            public void setRes(Boolean res) {
                this.res = res;
            }
        }

        Temp temp = new Temp();
        final String[] split = pre.split(",");
        Arrays.stream(split).forEach(s -> {
            temp.setRes(s != "#");
        });

        System.out.println();
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        Arrays.stream(strings)
                // .map(s -> new javafx.util.Pair<Character, Character>(s[0], s[s.length() -1]))
//                .collect(
//                        Collectors.toMap(
//                                s -> "" + s.charAt(0),
//                                s -> "" + s.charAt(s.length() - 1)));

                .forEach(s -> {
                    map.put("" + s.charAt(0), "" + s.charAt(s.length() - 1));
                });
        return map;
    }

    public static void changeInteger(Integer val) {
        val++;
    }
}
