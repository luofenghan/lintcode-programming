import org.junit.Assert;

/**
 * Created by cwc on 2017/07/13 0013.
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
        Assert.assertFalse(Utils.isAsc(arrays));

        heap.sort(arrays);
        Assert.assertTrue(Utils.isAsc(arrays));
    }

}
