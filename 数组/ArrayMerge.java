package Array;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: ArrayMerge
 * @class_describe: 实现两个有序数组合并为一个有序数组
 * @establish_time: 2019年8月4日 下午8:09:41
 * @how_to_use:
 */
public class ArrayMerge {
	public int[] mergeArray(int[] arrayOne, int[] arrayTwo) {
		int one = 0;// arrayOne 的指针
		int two = 0;// arrayTwo 的指针
		int index = 0;// arrayNew 的指针
		int[] arrayNew = new int[arrayOne.length + arrayTwo.length];
		while (one < arrayOne.length && two < arrayTwo.length) {
			if (arrayOne[one] < arrayTwo[two]) {
				arrayNew[index] = arrayOne[one];
				one++;
			} else {
				arrayNew[index] = arrayTwo[two];
				two++;
			}
			index++;
		}
		if (one < arrayOne.length) {
			for (int i = one; i < arrayOne.length; i++) {
				arrayNew[index] = arrayOne[i];
				index++;
			}
		}
		if (two < arrayTwo.length) {
			for (int i = two; i < arrayTwo.length; i++) {
				arrayNew[index] = arrayTwo[i];
				index++;
			}
		}
		return arrayNew;
	}
}
