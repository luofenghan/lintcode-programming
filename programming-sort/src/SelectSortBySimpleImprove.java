import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          将每趟循环可以确定两个元素（最大和最小值），从而减少排序所需的循环次数。改进后对n个数据进行排序，最多只需进行[n/2]趟即可
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N^2)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：不稳定
 *     五、结论
 *          1. 不受初始排序状态影响的排序算法
 *          2. 选择排序都是不稳定排序算法
 * </pre>
 */
public class SelectSortBySimpleImprove {
    public void sort(int[] array) {
        for (int i = 1, min, max, len = array.length; i <= len / 2; i++) {
            min = max = i;
            for (int j = i + 1; j <= len - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                    continue;
                }
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //该交换操作还可分情况讨论以提高效率
            Utils.swap(array, min, i - 1);
            Utils.swap(array, max, len - i);
        }
    }

    public static void main(String[] args) {
        SelectSortBySimpleImprove simpleImprove = new SelectSortBySimpleImprove();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        simpleImprove.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
