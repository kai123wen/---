package queue;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SeqQueue
 * @class_describe: ������ʵ��˳�����
 * @establish_time: 2019��8��7�� ����8:59:04
 * @how_to_use:
 */
public class SeqQueue {
	private static final int QUEUE_LENGTH = 10;
	int[] array = new int[QUEUE_LENGTH];
	int queueHead = 0;
	int queueEnd = 0;
	int length = 0;

	public void addQueue(int data) {
		array[queueEnd] = data;
		queueEnd++;
		length++;
	}

	public void printQueue() {
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
