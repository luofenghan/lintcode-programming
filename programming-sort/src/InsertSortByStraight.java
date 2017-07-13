import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          按照索引顺序，每一步将该索引上的值插入到前面已经有序的一组的值适当位置（通过从当前索引处往前的挨个比较）上，直到全部插入为止；
 *     二、时间复杂度分析
 *          1. 【最优】时间复杂度：当输入数据已【预先有序】，直接插入排序的时间复杂度为【O(N)】，因为内层的for循环的检测总是立即判定不成立而终止。
 *          2. 【最差】时间复杂度：当输入数据以【反序】输入时，直接插入排序的时间复杂度为【O(N^2)】，因为由于嵌套循环的每一个都花费N次迭代；
 *          3. 【平均】时间复杂度：O(N^2)
 *     四、空间复杂度：O(1)
 *     五、稳定性：稳定
 *     六、结论
 *          1. 直接插入排序适合【数据量比较小】的排序应用
 *          2. 【逆序数】就是插入排序需要【交换的次数】，N个互异数的数组的平均逆序数是 N(N-1)/4。
 *          3. 通过【交换相邻元素】进行排序的任何算法平均时间复杂度都需要O(N^2)
 * </pre>
 */
public class InsertSortByStraight {
    public void sort(int[] e) {
        int j;
        for (int i = 1; i < e.length; i++) {
            int current = e[i];
            for (j = i - 1; j >= 0 && e[j] > current; j -= 1) {
                e[j + 1] = e[j];
            }
            e[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        InsertSortByStraight straight = new InsertSortByStraight();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        straight.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));

    }
}
