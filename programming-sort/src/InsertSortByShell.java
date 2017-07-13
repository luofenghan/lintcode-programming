import org.junit.Assert;

/**
 * Created by cwc on 2017/07/13 0013.
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
        Assert.assertFalse(Utils.isAsc(arrays));

        shell.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }
}
