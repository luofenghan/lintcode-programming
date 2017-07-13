import org.junit.Assert;

/**
 * Created by cwc on 2017/07/13 0013.
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
        Assert.assertFalse(Utils.isAsc(arrays));

        binary.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
