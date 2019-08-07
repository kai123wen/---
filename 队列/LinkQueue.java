package queue;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: LInkQueue
 * @class_describe: 实现链式队列
 * @establish_time: 2019年8月7日 下午9:12:05
 * @how_to_use:
 */
public class LinkQueue {
	class Node {
		Node next = null;
		int data;
	}

	int length = 0;
	Node queueHead = null;
	Node queueEnd = null;

	public void addQueue(int data) {
		Node node = new Node();
		node.data = data;
		if (queueHead == null) {
			queueHead = node;
			queueEnd = node;
		} else {
			queueEnd.next = node;
			queueEnd = node;
		}
		length++;
	}

	public void printQueue() {
		Node temp = queueHead;
		int lengthTemp = length;
		while (lengthTemp > 0) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			lengthTemp--;
		}
		System.out.println();
	}
}
