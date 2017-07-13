import org.junit.Assert;

/**
 * <pre>
 *     一、题目：最长连续上升子序列
 *     二、描述：给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
 *              最长上升连续子序列可以定义为从右到左或从左到右的序列。
 *     三、示例
 *          1. 给定 [5, 4, 2, 1, 3], 其最长上升连续子序列（LICS）为 [5, 4, 2, 1], 返回 4.
 *          2. 给定 [5, 1, 2, 3, 4], 其最长上升连续子序列（LICS）为 [1, 2, 3, 4], 返回 4.
 * </pre>
 */
public class LongestIncreasingContinuousSubsequence {

    public int longestSubsequence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int maxIncrease = 0,/**/ incDelta = 0;
        int maxDecrease = 0, decDelta = 0;
        for (int i = 1, flag = -1; i < array.length; i++) {
            if (flag == -1) {
                /*flag==1 表示此时是递增，flag=0 表示递减*/
                flag = array[i] > array[i - 1] ? 1 : 0;
                if (flag == 1)
                    incDelta++;
                else
                    decDelta++;
                continue;
            }
            if (array[i - 1] < array[i]) {/*转换为 递增*/
                if (flag == 0) {/*转换前为递减，则记录上次递减的区间长度*/
                    maxDecrease = Math.max(maxDecrease, decDelta + 1);
                    decDelta = 0;
                }
                incDelta++;
                flag = 1;
            } else {/*转换为 递减*/
                if (flag == 1) {/*转换前为递增，则记录上次递增的区间长度*/
                    maxIncrease = Math.max(maxIncrease, incDelta + 1);
                    incDelta = 0;
                }
                decDelta++;
                flag = 0;
            }
        }

        return Math.max(Math.max(maxDecrease, decDelta + 1), Math.max(maxIncrease, incDelta + 1));
    }


    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequence longest = new LongestIncreasingContinuousSubsequence();

        /*负面测试*/
        Assert.assertEquals(0, longest.longestSubsequence(null));

        /*功能测试*/
        Assert.assertEquals(4, longest.longestSubsequence(new int[]{5, 4, 2, 1, 3}));
        Assert.assertEquals(4, longest.longestSubsequence(new int[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(3, longest.longestSubsequence(new int[]{5, 1, 6, 1, 4, 6}));

        /*边界测试*/
        Assert.assertEquals(2, longest.longestSubsequence(new int[]{5, 1}));
        Assert.assertEquals(2, longest.longestSubsequence(new int[]{5, 10, 1}));
        Assert.assertEquals(1, longest.longestSubsequence(new int[]{5}));

        /*性能测试*/

    }
}
