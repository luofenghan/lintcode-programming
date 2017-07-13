import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          按照索引顺序，每一步将该索引上的值插入到前面已经有序的一组的值适当位置（通过二分查找法找到，可以减少比较次数）上，直到全部插入为止。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：稳定
 *     五、结论
 *          1. 当N比较大时，二分插入排序的比较次数比直接插入排序的最坏情况（反序）要少，但是比直接插入排序的最好情况（基本有序）要差。
 *          2. 当元素初始序列接近有序时，直接插入排序比二分插入排序的比较次数少。
 *          3. 二分插入排序元素【交换次数】与直接插入排序相同，依赖于元素的初始序列。
 * </pre>
 */
public class InsertSortByBinary {
    public void sort(int[] array) {
        int left, current, mid, right;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            left = 0;
            right = i - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (current > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int k = i - 1; k >= left; k--) {
                array[k + 1] = array[k];
            }
            if (left != i) {
                array[left] = current;
            }
        }
    }

    public static void main(String[] args) {
        InsertSortByBinary binary = new InsertSortByBinary();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        binary.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
