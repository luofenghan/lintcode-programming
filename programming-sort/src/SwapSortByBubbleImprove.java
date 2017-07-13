import org.junit.Assert;

/**
 * @title 冒泡排序
 * @method
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
        Assert.assertFalse(Utils.isAsc(arrays));

        bubbleImprove.sort1(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));


        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isAsc(arrays));

        bubbleImprove.sort2(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
