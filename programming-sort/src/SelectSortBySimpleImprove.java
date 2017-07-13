import org.junit.Assert;

/**
 * @title 简单选择排序优化
 * @method 将每趟循环可以确定两个元素（最大和最小值），从而减少排序所需的循环次数。改进后对n个数据进行排序，最多只需进行[n/2]趟即可
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
        Assert.assertFalse(Utils.isAsc(arrays));

        simpleImprove.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
