import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class FIndMaxStockProfit {

    // {10, 7, 5, 9, 4, 7, 12}


    public static int getMaxProfit(int[] stockPrices) {
        // calculate the max profit
        if (stockPrices == null || stockPrices.length == 0 || stockPrices.length == 1) {
            throw new RuntimeException("invalid input");
        }

        int diff = 0;
        int min = stockPrices[0], max;

        // if next < max update max = next
        // if next < min update mix = next
        // if diff < (max - min) update diff
        for (int i = 1; i < stockPrices.length; i++) {
            int next = max = stockPrices[i];
            if (next < min) {
                min = next;
            }
            int newDiff = max - min;
            if (newDiff > 0 && newDiff > diff) {
                diff = newDiff;
            }
        }

        return diff;
    }


    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[]{1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[]{7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[]{9, 7, 4, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[]{5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[]{});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FIndMaxStockProfit.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}