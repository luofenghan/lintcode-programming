import org.junit.Assert;

/**
 * @title 冒泡排序
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
        Assert.assertFalse(Utils.isAsc(arrays));

        bubble.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
