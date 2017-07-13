import org.junit.Assert;

import java.util.Arrays;

/**
 * <pre>
 *     一、排序思想
 *          1. 快速排序通常被认为在同数量级O(NlogN)的排序方法中性能最好的，
 *              若初始序列已经【基本有序】，快排反而【退化为冒泡排序】。
 *          2. 在改进的算法中，只对【长度大于threshold】的子序列递归调用快速排序，让原序列基本有序，
 *              然后再对整个基本有序的序列使用直接插入排序。实践证明，改进后的算法时间复杂度有所降低，
 *              且当【threshold取8】左右的时候，改进算法的性能最优。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(NlogN)
 *     三、空间复杂度：O(logN)~O(N)
 *     四、稳定性：不稳定
 *     五、结论
 *
 * </pre>
 */
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
        Assert.assertFalse(Utils.isOrdered(arrays));

        quickImprove.sort(arrays, 7);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
