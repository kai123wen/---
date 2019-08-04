package Array;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SortArray
 * @class_describe: ʵ��һ����С�̶����������飬֧�ֶ�̬��ɾ�Ĳ���
 * @establish_time: 2019��8��4�� ����11:21:58
 * @how_to_use: SortArray sort = new SortArray(); sort.add(123); sort.add(12);
 *              sort.add(1); sort.add(34); sort.change(0, 133); sort.delete(0)
 * 
 */
public class SortArray {
	private static final int DEFAULT_LENGTH = 10;
	private int[] array = new int[DEFAULT_LENGTH];
	private int length = 0; // ��¼������ʵ�ʲ������ݵĳ���

	/*
	 * ������ʱѡ����ȷ����λ��
	 */
	public void insertToArray(int[] array, int value) {
		// inserted �������ж����Ѿ���������������Ƿ�����ҵ�
		// ��value �����λ�ã����Ϊfalse����������������
		// δ�ҵ�����˾�Ҫ���������������
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
			// ���Ϊ false �����������������
			array[length] = value;
		}
		length++;
	}

	/*
	 * ������
	 */
	public void add(int value) {
		if (length >= DEFAULT_LENGTH) {
			System.out.println("the array is full and the value will be abandoned");
		} else {
			insertToArray(array, value);
		}
	}

	/*
	 * �h����
	 */
	public void delete(int pos) {
		// ������Ҫ�ж�һ�£�ɾ�����Ƿ���֮ǰ�Լ����������
		if (pos > length - 1) {
			System.out.println("there is no data");
		} else {
			// ֻ��Ҫ��pos֮�����ǰ�ƶ�
			for (int i = pos; i < length - 1; i++) {
				array[i] = array[i + 1];
			}
			// ��һ��ʮ����Ҫ���ڱ�̹���������һ����������ɽ������
			// ��һ����Ŀ���ǽ����������һλ���㣬��Ϊ���һλ��ǰ�ƶ���
			array[length - 1] = 0;
		}

	}

	/*
	 * �Ĳ�����ɺ���µ����н�������
	 */
	public void sort() {
		// ʹ��ð������
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
	 * �Ĳ��� pos ΪҪ�Ķ���Ԫ��λ�� newValueΪ��ֵ
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
