package LinkList;

import LinkList.SingleLinkList.Node;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: CycleLinkList
 * @class_describe: ʵ��ѭ������֧����ɾ����
 * @establish_time: 2019��8��4�� ����11:07:57
 * @how_to_use:
 */
public class CycleLinkList {
	class Node {
		Node next = null;
		int data;
	}

	int length = 0; // �ڵ���Ŀ
	Node head = null; // ����ͷ�ڵ�

	/*
	 * ���ӽڵ�
	 */
	public void addNode(int data) {
		if (head == null) {
			head = new Node();
			head.data = data;
			// ֻ����һ��ͷ�ڵ�ʱ
			head.next = head;
		} else {
			Node temp = head;
			int lengthTemp = length;// �����ҵ����һ���ڵ�
			while (lengthTemp > 1) {
				temp = temp.next;
				lengthTemp--;
			}
			Node node = new Node();
			node.data = data;
			temp.next = node;
			// ��Ϊѭ���������һ���ڵ�Ҫ���һ���ڵ�����
			node.next = head;
		}
		length++;
	}

	/*
	 * ɾ���ڵ�
	 */
	public void deleteNode(int pos) {
		if (pos > length) {
			System.out.println("the postion is illegal");
		} else {
			Node temp = head;
			// �����ɾ����һ���ڵ㣬����Ҫ���⴦��
			if (pos == 1) {
				if (head.next != null) {
					head = head.next;
				} else {
					head = null;
				}
			} else {
				for (int i = 1; i < pos - 1; i++) {
					temp = temp.next;
				}
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
