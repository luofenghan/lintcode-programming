import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          按照索引顺序，每趟会在该索引后的数组元素中找出一个【最小元素】与【当前索引处的元素】进行交换。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N^2)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：不稳定
 *     五、结论
 *          1. 不受初始排序状态影响的排序算法
 * </pre>
 */
public class SelectSortBySimple {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = minValue;
        }
    }

    public static void main(String[] args) {
        SelectSortBySimple simple = new SelectSortBySimple();


        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        simple.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
