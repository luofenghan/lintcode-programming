import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          希尔排序通过将比较的全部元素分为【几个区域】来提升插入排序的性能，
 *          这样可以让一个元素可以一次性地朝最终位置前进一大步。
 *          然后算法再取【越来越小的步长】进行排序，
 *          算法的最后一步就是【普通的插入排序】，但到了这一步，数据几乎已经排好序。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(N)
 *          2. 【最差】时间复杂度：O(N^2)
 *          3. 【平均】时间复杂度：O(NlogN)−O(N^2)
 *     三、空间复杂度：O(1)
 *     四、稳定性：不稳定
 *     五、结论
 *          1. 如果有一个【很小的数据】在一个已按【升序排好序】的数组的【末端】，
 *              如果用复杂度为O(N^2)的排序算法（冒泡排序或直接插入排序），
 *              可能会进行【n次的比较和交换】才能将该数据移至正确的位置。
 *              而希尔排序会用【较大的步长移动数据】，所以小数据只需要进行【少数比较和交换】即可到正确位置。
 * </pre>
 */
public class InsertSortByShell {
    public void sort(int[] e) {
        for (int gap = e.length / 2; gap > 0; gap /= 2) {
            for (int i = gap, j; i < e.length; i++) {
                int current = e[i];
                for (j = i - gap; j >= 0 && e[j] > current; j -= gap) {
                    e[j + gap] = e[j];
                }
                e[j + gap] = current;
            }
        }
    }

    public static void main(String[] args) {
        InsertSortByShell shell = new InsertSortByShell();

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        shell.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
