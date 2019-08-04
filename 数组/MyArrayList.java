package Array;

public class MyArrayList {
	private static final int DEFAULT_LENGTH = 10;
	// 让一个数组的对象作为一个实例，这里比较重要
	int[] array = new int[DEFAULT_LENGTH];
	int index = -1;

	public void expand(int expandSize) {
		if (expandSize <= 0) {
			System.out.println("the expandSize is illegal");
		} else {
			int[] newArray = new int[DEFAULT_LENGTH + expandSize];
			System.arraycopy(array, 0, newArray, 0, DEFAULT_LENGTH);
			array = newArray;
		}
	}

	public void add(int value) {
		if (index >= 9) {
			expand(1);
		}
		index++;
		array[index] = value;
	}

	public int get(int pos) {
		return array[pos];
	}
}
