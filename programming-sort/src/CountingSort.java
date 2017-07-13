import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          有一个待排序的整数序列A，其中元素的最小值不小于0，最大值不超过k，
 *          建立一个长度为k的数组temp，用来temp[i]表示序列A中值为i的元素的个数。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N+K)
 *          2. 【最差】时间复杂度：O(N+K)
 *          3. 【平均】时间复杂度：O(N+K)
 *     三、空间复杂度：O(K)
 *     四、稳定性：稳定
 *     五、结论
 *          1. 不需要比较函数，利用地址偏移，对【范围固定】在[0,k]的整数排序的最佳选择；
 *          2. 由于用来计数的数组的长度取决于待排序数组中数据的范围，这使得计数排序对于数据范围很大的数组，需要大量的时间和内存。
 *          3. 计数排序最重要的性质使稳定性，排序后的相同值元素原有的相对位置不会发生改变。
 * </pre>
 */
public class CountingSort {
    public void sort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : array) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        int[] count = new int[max + 1];
        for (int i : array) {
            count[i]++;
        }
        for (int i = min, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        CountingSort counting = new CountingSort();
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        counting.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
