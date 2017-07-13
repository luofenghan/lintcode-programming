import org.junit.Assert;

import java.util.Arrays;

/**
 * Created by cwc on 2017/07/13 0013.
 */
@SuppressWarnings("all")
public class SwapSortByQuickImprove {
    public void sort(int[] array, int threshold) {
        sort(array, 0, array.length - 1, threshold);
        Arrays.sort(array);
    }

    private void sort(int[] array, int low, int high, int threshold) {
        if (high - low > threshold) {
            int pivot = partition(array, low, high);
            sort(array, 0, pivot - 1, threshold);
            sort(array, pivot + 1, high, threshold);
        }
    }


    private int partition(int[] array, int low, int high) {
        for (int pivot = array[low]; low < high; ) {
            while (low < high && array[high] >= pivot) high--;
            Utils.swap(array, low, high);
            while (low < high && array[low] <= pivot) low++;
            Utils.swap(array, low, high);
        }
        return low;
    }

    public static void main(String[] args) {
        SwapSortByQuickImprove quickImprove = new SwapSortByQuickImprove();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isAsc(arrays));

        quickImprove.sort(arrays, 7);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
