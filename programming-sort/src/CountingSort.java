import org.junit.Assert;

/**
 * Created by cwc on 2017/5/12 0012.
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
        Assert.assertFalse(Utils.isAsc(arrays));

        counting.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
