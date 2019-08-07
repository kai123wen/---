package queue;

public class CycleQueue {
	private static final int QUEUE_LENGTH = 10;
	int[] array = new int[QUEUE_LENGTH];
	int queueHead = 0;
	int queueEnd = 0;
	int length = 0;

	public void addQueue(int data) {
		if ((queueEnd + 1) % QUEUE_LENGTH == queueHead) {
			System.out.println("the queue is full");
		} else {
			array[queueEnd] = data;
			queueEnd = (queueEnd + 1) % QUEUE_LENGTH;
		}
		length++;
	}

	public void printQueue() {
		for (int i = queueHead; i != queueEnd; i = (i + 1) % QUEUE_LENGTH) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
