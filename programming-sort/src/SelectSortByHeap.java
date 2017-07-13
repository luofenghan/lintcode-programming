import org.junit.Assert;

/**
 * <pre>
 *     一、排序思想
 *          1. 优先队列可以用于以O(NlogN)时间来排序，基于该思想的算法叫做【堆排序heapsort】。
 *              - 在建立N个元素的二叉堆时，该阶段花费O(N)时间；
 *              - 然后又执行N次deleteMin操作，由于每个deleteMin花费时间O(logN)，因此总运行时间是O(NlogN)。
 *          2. 优先队列的算法主要问题在于，它使用了一个附加数组，因此，存储需求增加一倍。但不会太影响时间问题，附加的时间消耗只有O(N)，只是增加了空间复杂度。
 *          3. 那么对于以上问题，在堆排序中的解决方案是：在每次deleteMin之后，将堆缩小1。
 *              - 因此，堆中的最后一个单元可以用来存放刚刚删除的元素。
 *              - 使用这种策略，在最后一次deleteMin之后，该数组将以递减的顺序包含这些元素。
 *              - 如果想要排成更典型的递增顺序，那么可以在构建堆的时候建立最大堆。
 *     二、时间复杂度
 *          1. 【最优】时间复杂度：O(NlogN)
 *          2. 【最差】时间复杂度：O(NlogN)
 *          3. 【平均】时间复杂度：O(NlogN)
 *     三、空间复杂度：O(1)
 *     四、稳定性：不稳定
 *     五、结论
 *          1. 选择排序都是不稳定算法；
 * </pre>
 */
public class SelectSortByHeap {
    public void sort(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            Utils.swap(array, 0, i);
            percolateDown(array, 0, i);
        }
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private void percolateDown(int[] a, int i, int n) {
        int child;
        int tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            //找到i孩子节点中最大的一个
            if (child != n - 1 && a[child] < a[child + 1]) {
                child++;//i的右孩子
            }
            if (tmp < a[child]) {//如果较大的子结点大于父结点
                a[i] = a[child]; // 那么把较大的子结点往上移动，替换它的父结点
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    public static void main(String[] args) {
        SelectSortByHeap heap = new SelectSortByHeap();


        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Utils.shuffle(arrays);
        Assert.assertFalse(Utils.isOrdered(arrays));

        heap.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }

}
