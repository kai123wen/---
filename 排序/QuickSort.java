package Sort;

public class QuickSort {
	public void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = getOperationIndex(array, left, right);
		quickSort(array, left, index - 1);
		quickSort(array, index + 1, right);
	}

	public int getOperationIndex(int[] array, int left, int right) {
		int temp;
		int start = left;
		int target = array[left];
		while (left != right) {
			while (left < right && array[right] > target) {
				right--;
			}
			while (left < right && array[left] <= target) {
				left++;
			}
			if (left < right) {
				temp = array[right];
				array[right] = array[left];
				array[left] = temp;
			}
		}
		array[start] = array[left];
		array[left] = target;
		return left;
	}

}
