import java.util.LinkedHashMap;

public class Find1stNonRepeatingCharInString {

//    private static class MyExcpetion extends Exception {
//        public int index;
//
//        public MyExcpetion(int index) {
//            this.index = index;
//        }
//    }

    private static class Entry {
        public Integer amount;
        public int index;
    }

    private static int retIndex;

    public static int findIndex(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        LinkedHashMap<Integer, Entry> chars = new LinkedHashMap<Integer, Entry>();

        for (int i = 0; i < str.length(); i++) {
            Integer charAsInt = (Integer) new Integer(str.charAt(i));
            Entry e = chars.get(charAsInt);
            if (e == null) {
                e = new Entry();
                e.amount = 0;
                chars.put(charAsInt ,e);
            }

            e.amount = e.amount + 1;
            e.index = i;
        }

        // for (Map.Entry<Integer, Entry> entry : chars.linkedList()) {
        synchronized(Find1stNonRepeatingCharInString.class) {
            retIndex = -1;
//        try {
            chars.forEach((k, v) -> {
                if (v.amount == 1 &&  // appeared only once
                        retIndex == -1) {  // get the first one
                    retIndex = v.index;
//                    throw new MyExcpetion(v.index);
                }
            });
//        } catch (MyExcpetion me) {
//            ret = me.index;
//        }

            return retIndex;
        }
    }


    public static void main(String args[]) {

        String str = "GeeksForGeeks";

        System.out.println("index is - " + findIndex(str));
        // index 5 expected
    }
}