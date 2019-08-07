package Stack;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SeqStack
 * @class_describe: ������ʵ��һ��˳��ջ
 * @establish_time: 2019��8��7�� ����8:33:15
 * @how_to_use:
 */
public class SeqStack {
	private static final int STACL_LENGTH = 10;// ջ�Ĵ�С
	int[] array = new int[STACL_LENGTH];
	int stackTop = 0;// ָ��ջ����ָ��

	public void addStack(int data) {
		if (stackTop >= STACL_LENGTH) {
			System.out.println("the stack is full");
		} else {
			array[stackTop] = data;
			stackTop++;
		}
	}

	public void printStack() {
		for (int i = 0; i < stackTop; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

}
