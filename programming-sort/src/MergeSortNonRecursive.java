import org.junit.Assert;

/**
 * Created by cwc on 2017/5/12 0012.
 */
public class MergeSortNonRecursive {

    /**
     * 非递归排序
     */
    public void sort(int[] array) {
        int[] tmp = new int[array.length];
        for (int gap = 1, len = array.length, tmpIndex, leftStart, leftEnd, rightStart, rightEnd; gap < len; gap *= 2) {
            for (tmpIndex = 0, leftStart = 0; leftStart < len - gap; leftStart = rightEnd) {
                if ((rightEnd = ((rightStart = leftEnd = leftStart + gap) + gap)) > len) {
                    rightEnd = len;
                }

                while (leftStart < leftEnd && rightStart < rightEnd) {
                    if (array[leftStart] <= array[rightStart]) {
                        tmp[tmpIndex++] = array[leftStart++];
                    } else {
                        tmp[tmpIndex++] = array[rightStart++];
                    }
                }

                while (leftStart < leftEnd) {
                    array[--rightStart] = array[--leftEnd];
                }

                while (tmpIndex > 0) {
                    array[--rightStart] = tmp[--tmpIndex];
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeSortNonRecursive nonRecursive = new MergeSortNonRecursive();
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        nonRecursive.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));

    }
}
