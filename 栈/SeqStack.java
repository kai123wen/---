package Stack;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SeqStack
 * @class_describe: 用数组实现一个顺序栈
 * @establish_time: 2019年8月7日 下午8:33:15
 * @how_to_use:
 */
public class SeqStack {
	private static final int STACL_LENGTH = 10;// 栈的大小
	int[] array = new int[STACL_LENGTH];
	int stackTop = 0;// 指向栈顶的指针

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
