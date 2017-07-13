import org.junit.Assert;

/**
 * Created by cwc on 2017/5/12 0012.
 */
public class MergeSortUseRecursive {
    static int counter = 0;

    /**
     * 递归排序
     *
     * @param array
     */
    public void sort(int[] array) {
        int[] tmpArray = new int[array.length];
        sort(array, tmpArray, 0, array.length - 1);
    }

    private void sort(int[] array, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(array, tmp, left, center);
            sort(array, tmp, center + 1, right);
            merge(array, tmp, left, center + 1, right);
        }
    }

    private void merge(int[] array, int[] temp, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int tmpStart = leftStart;
        int numElements = rightEnd - leftStart + 1;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (array[leftStart] <= array[rightStart]) {
                temp[tmpStart++] = array[leftStart++];
            } else {
                temp[tmpStart++] = array[rightStart++];
            }
        }

        /*将left剩余元素复制到tmp中*/
        while (leftStart <= leftEnd) {
            temp[tmpStart++] = array[leftStart++];
        }

        /*将right剩余元素复制到tmp中*/
        while (rightStart <= rightEnd) {
            temp[tmpStart++] = array[rightStart++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = temp[rightEnd];
        }
    }


    public static void main(String[] args) {
        MergeSortUseRecursive useRecursive = new MergeSortUseRecursive();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(array);
        Assert.assertFalse(Utils.isAsc(array));

        useRecursive.sort(array);
        Assert.assertTrue(Utils.isAsc(array));


    }
}
