package Sort;

public class MergeSort {
	public void mergeSort(int[] array, int left, int right) {
		if (left == right) {
			return;
		}else {
			int middle = (left + right) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle + 1, right);	
		}
	}

	public void merge(int[] array, int L, int M, int R) {
		int[] left = new int[M - L];
		int[] right = new int[R - M + 1];
		for (int i = L; i < M; i++) {
			left[i - L] = array[i];
		}
		for (int i = M; i <= R; i++) {
			right[i - M] = array[i];
		}
		int leftPtr = 0;
		int rightPtr = 0;
		int index = L;
		while (leftPtr < left.length && rightPtr < right.length) {
			if (left[leftPtr] < right[rightPtr]) {
				array[index] = left[leftPtr];
				leftPtr++;
			} else {
				array[index] = right[rightPtr];
				rightPtr++;
			}
			index++;
		}
		while (leftPtr < left.length) {
			array[index] = left[leftPtr];
			leftPtr++;
			index++;
		}
		while (rightPtr < right.length) {
			array[index] = right[rightPtr];
			rightPtr++;
			index++;
		}
	}
}
