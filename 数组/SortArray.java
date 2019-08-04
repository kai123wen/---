package Array;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SortArray
 * @class_describe: 实现一个大小固定的有序数组，支持动态增删改操作
 * @establish_time: 2019年8月4日 上午11:21:58
 * @how_to_use: SortArray sort = new SortArray(); sort.add(123); sort.add(12);
 *              sort.add(1); sort.add(34); sort.change(0, 133); sort.delete(0)
 * 
 */
public class SortArray {
	private static final int DEFAULT_LENGTH = 10;
	private int[] array = new int[DEFAULT_LENGTH];
	private int length = 0; // 记录数组中实际插入数据的长度

	/*
	 * 增操作时选择正确插入位置
	 */
	public void insertToArray(int[] array, int value) {
		// inserted 作用是判断在已经插入的有序区内是否可以找到
		// 将value 插入的位置，如果为false，代表在有序区中
		// 未找到，因此就要在有序区后将其插入
		boolean inserted = false;
		for (int i = 0; i < length; i++) {
			if (array[i] > value) {
				for (int j = length - 1; j >= i; j--) {
					array[j + 1] = array[j];
				}
				inserted = true;
				array[i] = value;
				break;
			}
		}
		if (inserted == false) {
			// 如果为 false ，就在有序区后插入
			array[length] = value;
		}
		length++;
	}

	/*
	 * 增操作
	 */
	public void add(int value) {
		if (length >= DEFAULT_LENGTH) {
			System.out.println("the array is full and the value will be abandoned");
		} else {
			insertToArray(array, value);
		}
	}

	/*
	 * 刪操作
	 */
	public void delete(int pos) {
		// 这里需要判断一下，删除的是否是之前自己插入的数据
		if (pos > length - 1) {
			System.out.println("there is no data");
		} else {
			// 只需要将pos之后的向前移动
			for (int i = pos; i < length - 1; i++) {
				array[i] = array[i + 1];
			}
			// 这一步十分重要，在编程过程中因这一步有问题造成结果错误
			// 这一步的目的是将有序区最后一位置零，因为最后一位向前移动了
			array[length - 1] = 0;
		}

	}

	/*
	 * 改操作完成后对新的序列进行排序
	 */
	public void sort() {
		// 使用冒泡排序
		boolean isSorted = true;
		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			isSorted = true;
			for (int j = 0; j < length - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSorted = false;
				}
			}
			if (isSorted == true) {
				break;
			}
		}
	}

	/*
	 * 改操作 pos 为要改动的元素位置 newValue为新值
	 */
	public void change(int pos, int newValue) {
		if (pos > length - 1) {
			System.out.println("there is no data");
		} else {
			array[pos] = newValue;
			sort();
		}
	}

	public void printArray() {
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public int get(int pos) {
		return array[pos];
	}

}
