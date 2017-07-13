import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          1. 选取一个【基准pivot】元素，通常选择第一个元素或者最后一个元素；
 *          2. 进行分区partition操作，通过一趟排序将待排序的记录分割成两个部分，其中一个部分的元素均【比基准元素小】，另一部分元素均【比基准元素大】；
 *          3. 对每个分区递归地进行步骤1~3，递归的结束条件是子序列的大小是0或1，这时整体已经排好序。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(NlogN)
 *     三、空间复杂度：O(logN)~O(N)
 *     四、稳定性：不稳定
 *     五、结论
 *          1. 最坏的情况下，也就是每次选取的基准都是最大或最小的元素（例如，在上例7,8,10,9中），
 *              导致每次只划分出了一个子序列，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)；
 *          2. 最好的情况下，每次选取的基准都能均匀划分，只需要logN次划分就能结束递归，时间复杂度为O(logN)。
 *          3. 平均情况下，需要的时间复杂度为O(NlogN)。
 * </pre>
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
        Assert.assertFalse(Utils.isOrdered(arrays));

        quick.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
