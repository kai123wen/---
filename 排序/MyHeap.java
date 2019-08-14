package Sort;

public class MyHeap {
	public void upAdjust(int[] array, int index) {
		int childIndex = index;
		int parentIndex = (childIndex - 1) / 2;
		int temp = array[childIndex];
		while (childIndex > 0 && temp < array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[childIndex] = temp;
	}

	public void buildHeap(int[] array) {
		for (int i = array.length - 1; i >= (array.length - 1) / 2 + 1; i--) {
			upAdjust(array, i);
		}
	}

	public void downBuild(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			downAdjust(array, i,array.length);
		}
	}

	public void downAdjust(int[] array, int index, int length) {
		int parentIndex = index;
		int childIndex = 2 * parentIndex + 1;
		int temp = array[parentIndex];
		// 保证操作已经到达底部了
		while (childIndex < length) {
			// 如果左孩子的值 大于 右孩子的值，就指向右孩子
			if (childIndex < length - 1 && array[childIndex] > array[childIndex + 1]) {
				childIndex++;
			}
			if (temp <= array[childIndex]) {
				break;
			}
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * parentIndex + 1;
		}
		array[parentIndex] = temp;
	}

	public void heapSort(int[] array) {
		// 首先将无序数组转化为小顶堆
		downBuild(array);

		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			downAdjust(array, 0, i);
		}
	}

}
