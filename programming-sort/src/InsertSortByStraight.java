import org.junit.Assert;

/**
 *
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
        Assert.assertFalse(Utils.isAsc(arrays));

        straight.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));

    }
}
