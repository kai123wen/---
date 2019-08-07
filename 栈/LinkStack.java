package Stack;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: LinkStack
 * @class_describe: 用链表实现一个链式栈
 * @establish_time: 2019年8月7日 下午8:45:41
 * @how_to_use:
 */
public class LinkStack {
	class Node {
		Node next = null;
		int data;
	}

	int length = 0;
	Node head = null;
	Node end = null;

	public void addStack(int data) {
		Node node = new Node();
		node.data = data;
		if (head == null) {
			head = node;
			end = node;
		} else {
			end.next = node;
			end = node;
		}
		length++;
	}

	public void printStack() {
		Node temp = head;
		while (length > 0) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			length--;
		}
		System.out.println();
	}
}
