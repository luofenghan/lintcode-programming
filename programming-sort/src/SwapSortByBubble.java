import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          通过【交换使相邻的两个数】变成小数在前大数在后，这样每次遍历后，最大的数就“沉”到最后面了，重复N次即可以使数组有序。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：稳定
 *     五、结论
 *          1. 只有在n比较小的时候性能才比较好
 *
 * </pre>
 */
public class SwapSortByBubble {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Utils.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwapSortByBubble bubble = new SwapSortByBubble();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        bubble.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
