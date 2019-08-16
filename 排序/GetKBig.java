package Sort;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: getKBig
 * @class_describe: ���ʵ�� O(n) ʱ�临�Ӷ����ҵ�һ�����ݵĵ� K ��Ԫ�� ˼����ͨ����������
 * @establish_time: 2019��8��14�� ����8:11:36
 * @how_to_use:
 */
public class GetKBig {
	public int getKBigNum(int[] array, int left, int right, int k) {
		int position = getOperationIndex(array, left, right);
		while (position != array.length - k) {
			if (position > array.length - k) {
				position = getOperationIndex(array, left, position);
			} else {
				position = getOperationIndex(array, position + 1, right);
			}
		}
		return array[position];
	}

//	public int getPosition(int[] array, int left, int right) {
//		int target = array[left];
//		int start = left;
//		int temp;
//		while (left < right) {
//			while (left < right && target < array[right]) {
//				right--;
//			}
//			while (left < right && target > array[left]) {
//				left++;
//			}
//			if (left < right) {
//				temp = array[right];
//				array[right] = array[left];
//				array[left] = temp;
//			}
//		}
//		array[start] = array[left];
//		array[left] = target;
//		return left;
//	}

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
