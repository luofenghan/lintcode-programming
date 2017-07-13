import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          1. 归并排序是采用【分治法】的一个非常典型的应用，归并排序的思想就是【先递归分解数组，再合并数组】。
 *          2. 先考虑【合并】两个有序数组，基本思路是两个输入数组A和B，一个输出数组C，以及3个计数器ai、bi、ci，
 *              他们的初始置于对应数组的开始端。A[ai]和B[bi]中的最小者被拷贝到C中的下一个位置，
 *              相关的计数器向前推进一步。当两个输入表有一个用完时，则将另一个表剩余部分拷贝到C中。
 *          3. 再考虑【递归分解】，基本思路是将数组分解成left和right，如果这两个数组内部数据是有序的，
 *              那么就可以用上面的合并数组方式将这两个数组合并排序。
 *              如何让这两个数组内部有序？可以再二分，直至分解出的小组含有一个元素为止，此时认为该小组内部已有序，然后合并排序相邻两个小组即可。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(NlogN)
 *          3. 【平均】时间复杂度：O(NlogN)
 *     三、空间复杂度：O(N)
 *     四、稳定性：稳定
 *     五、结论
 *          1. 归并排序是经典的分治策略，它将问题【分（divide）】成一些小问题然后递归求解，而【治（conquer）】的阶段则将分的阶段解得的各答案修补在一起。
 *          2. 最差的情况下，归并排序的运行时间是O(NlogN)，但是有一个明显的问题，整个算法还要花费将数据拷贝到临时数组再拷贝回来这样一个附加的工作，明显减慢了排序的速度。
 *          3. 归并排序使用所有流行排序算法中最少的比较次数。
 * </pre>
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
        Assert.assertFalse(Utils.isOrdered(array));

        useRecursive.sort(array);
        Assert.assertTrue(Utils.isAsc(array));


    }
}
