package LinkList;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: DoubleLinkList
 * @class_describe: ʵ��˫���������ɾ����
 * @establish_time: 2019��8��5�� ����6:22:52
 * @how_to_use:
 * DoubleLinkList link = new DoubleLinkList();
	for (int i = 0; i < 5; i++) {
			link.addNode(i);
		}
		link.printLinkList();
		link.deleteNode(6);
		link.printLinkList();
 */
public class DoubleLinkList {
	class Node {
		Node next = null;
		Node pre = null;
		int data;
	}

	Node head = null;
	int length = 0;

	/*
	 * ������
	 */
	public void addNode(int data) {
		if (length == 0) {
			head = new Node();
			head.data = data;
			head.pre = head;
			head.next = head;
		} else {
			Node node = new Node();
			node.data = data;
			Node temp = head;
			int lengthTemp = length;
			while (lengthTemp > 1) {
				temp = temp.next;
				lengthTemp--;
			}
			node.next = head;
			head.pre = node;
			temp.next = node;
			node.pre = temp;
		}
		length++;
	}

	/*
	 * ɾ����
	 */
	public void deleteNode(int pos) {
		if (pos > length) {
			System.out.println("the postion is illegal");
		} else {
			if (pos == 1) {
				// ���ֻ��һ���ڵ�
				if (length == 1) {
					head = null;
				} else {
					head.pre.next = head.next;
					head = head.next;
				}
			} else {
				Node temp = head;
				int posTemp = pos;
				while (posTemp > 2) {
					temp = temp.next;
					posTemp--;
				}
				temp.next.next.pre = temp;
				temp.next = temp.next.next;
			}
			length--;
		}
	}

	/*
	 * ��ӡ����
	 */
	public void printLinkList() {
		Node temp = head;
		int lengthTemp = length;// �����ҵ����һ���ڵ�
		while (lengthTemp > 0) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			lengthTemp--;
		}
		System.out.println();
	}
}
