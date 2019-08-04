package LinkList;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: LinkListCreate
 * @class_describe: ʵ�ֵ�����֧����ɾ����
 * @establish_time: 2019��8��4�� ����9:15:58
 * @how_to_use: LinkList link = new LinkList(); for (int i = 0; i < 5; i++) {
 *              link.addNode(i); } link.printLinkList(); link.deleteNode(2);
 *              link.printLinkList();
 */
public class SingleLinkList {
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
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node node = new Node();
			node.data = data;
			temp.next = node;
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
		}
	}

	/*
	 * ��ӡ����
	 */
	public void printLinkList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
