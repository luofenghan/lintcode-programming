import org.junit.Assert;

/**
 * @title 简单选择排序
 * @method 按照索引顺序，每趟选择一个最小元素与当前索引元素进行交换
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
        Assert.assertFalse(Utils.isAsc(arrays));

        simple.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
