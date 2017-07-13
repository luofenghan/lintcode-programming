import org.junit.Assert;

/**
 * <pre>
 *     一、标题：删除排序数组中的重复数字（允许出现两次重复）
 *     二、描述：给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素最多出现2次，并且返回新的数组的长度。
 *     三、示例：给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,1,2]。
 * </pre>
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int filter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int size = nums.length;
        for (int i = 0, gap; i < size; i++) {
            gap = 0;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] == nums[i]) {
                    if (j - i > 1) {
                        gap++;
                    }
                } else if (gap != 0) {
                    System.arraycopy(nums, j, nums, j - gap, size - j);
                    break;
                } else {
                    break;
                }
            }
            size -= gap;
        }
        return size;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII filter = new RemoveDuplicatesFromSortedArrayII();

        int[] nums;

        /*功能测试*/
        nums = new int[]{1, 2, 3, 4, 5, 6};
        Assert.assertEquals(6, filter.filter(nums));

        nums = new int[]{1, 1, 1, 4, 5, 6};
        Assert.assertEquals(5, filter.filter(nums));

        nums = new int[]{1, 1, 1, 4, 4, 5, 5, 6, 7, 8, 8};
        Assert.assertEquals(10, filter.filter(nums));

        /*负面测试*/
        nums = new int[]{1};
        Assert.assertEquals(1, filter.filter(nums));

        nums = new int[]{};
        Assert.assertEquals(0, filter.filter(nums));

        nums = null;
        Assert.assertEquals(0, filter.filter(nums));


    }
}
