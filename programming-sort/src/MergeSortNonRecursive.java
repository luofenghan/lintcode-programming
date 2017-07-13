import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          将数组中的相邻元素两两配对，构成N/2个长度为2的排好序的子数组，
 *          然后再将他们排序成长度为4的子数组段，如此下去，直至整个数组排好序。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(NlogN)
 *          3. 【平均】时间复杂度：O(NlogN)
 *     三、空间复杂度：O(N)
 *     四、稳定性：稳定
 *     五、结论
 * </pre>
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
