import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          通过【交换使相邻的两个数】变成小数在前大数在后，这样每次遍历后，最大的数就“沉”到最后面了，重复N次即可以使数组有序。
 *             - sort1：设置一个标志性变量pos，用于记录每趟排序中最后一次进行交换的位置。
 *                     由于pos之后的记录均已交换到位，因此在下一趟排序时只要扫描到pos位置即可。
 *             - sort2：传统冒泡排序在每趟的操作中只能找到一个最大值或最小值，
 *                     因此，考虑利用在每趟排序中进行正向和反向的两边冒泡方法一次可以得到【两个最终值（最大值和最小值）】，
 *                     从而使排序趟数几乎减少一半。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：稳定
 *     五、结论
 *
 * </pre>
 */
public class SwapSortByBubbleImprove {
    /**
     * 设置标记变量pos，用于记录每趟排序中最后一次进行交换的位置，
     * 由于pos位置之后的记录已交换到位，所以在进行下一趟排序只要扫描到pos位置即可。
     *
     * @param array
     */
    public void sort1(int[] array) {
        for (int i = array.length - 1; i > 0; ) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    pos = j;
                    Utils.swap(array, j, j + 1);
                }
            }
            i = pos;
        }
    }

    /**
     * 传统冒泡排序每一堂排序操作只能找到一个最大值或者最小值，
     * 因此，考虑利用在每趟排序中进行正向和反向冒泡的方式可以一趟得到两个最终值（最小值和最大值），
     * 从而使排序躺输几乎减少了一半。
     *
     * @param array
     */
    public void sort2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            for (int i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    Utils.swap(array, i, i + 1);
                }
            }
            high--;
            for (int i = high; i > low; i--) {
                if (array[i] < array[i - 1]) {
                    Utils.swap(array, i, i - 1);
                }
            }
            low++;
        }

    }

    public static void main(String[] args) {
        SwapSortByBubbleImprove bubbleImprove = new SwapSortByBubbleImprove();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        bubbleImprove.sort1(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));


        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        bubbleImprove.sort2(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
