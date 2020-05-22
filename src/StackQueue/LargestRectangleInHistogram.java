package StackQueue;

import java.util.LinkedList;
import java.util.ListIterator;

public class LargestRectangleInHistogram {

    private LinkedList<HistoryData> history = new LinkedList<HistoryData>();

    public static class HistoryData {
        public int num;
        public int count = 0;
    }

    public int calc(int[] arr) {

        for (int i =0; i< arr.length; i++) {
            HistoryData hd = new HistoryData();
            hd.num = arr[i];
            hd.count = 1;
            ListIterator<HistoryData> prevIter = history.listIterator(0);
            boolean isFirst = true;
            while (prevIter.hasNext()) {
                HistoryData previous = prevIter.next();
                if (previous.num >= hd.num) {
                    hd.count++;
                } else {
                    if (isFirst) {
                        previous.count++;
                    }
                    break; // only update head of list (which is smaller)
                }
                isFirst = false;
            }
            history.addFirst(hd);
        }

        // iterate over the list to find the max (num * count)
        int max = 0;
        ListIterator<HistoryData> prevIter = history.listIterator(0);
        while (prevIter.hasNext()) {
            HistoryData item = prevIter.next();
            int area = item.num * item.count;
            if (area > max)
                max = area;
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();

        int[] arr = new int[] {2,1,5,6,2,3};

        System.out.println("LargestRectangleInHistogram - " + lrih.calc(arr));
    }
}
