import org.junit.Assert;

/**
 * Created by cwc on 2017/07/13 0013.
 */
public class SwapSortByQuick {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            sort(array, 0, pivot - 1);
            sort(array, pivot + 1, high);
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
        SwapSortByQuick quick = new SwapSortByQuick();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isAsc(arrays));

        quick.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
