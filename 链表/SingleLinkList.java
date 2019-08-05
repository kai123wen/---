package LinkList;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SingleLinkList
 * @class_describe: ʵ�ֵ�����֧����ɾ����
 * @establish_time: 2019��8��4�� ����9:15:58
 * @how_to_use: SingleLinkList link = new SingleLinkList(); for (int i = 0; i <
 *              5; i++) { link.addNode(i); } link.printLinkList();
 *              link.deleteNode(2); link.printLinkList();
 *              link.reverseLinkList(); link.printLinkList();
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
			length--;
		}
	}

	/*
	 * ����Ŀ���ǵõ�ͷ�ڵ㣬Ϊ�˺ϲ�������������
	 */
	public Node getHeadNode() {
		return head;
	}

	public void setHeadNode(Node head) {
		this.head = head;
	}

	/*
	 * ʵ���������������ϲ�Ϊһ����������
	 */
	public SingleLinkList merge(SingleLinkList linkOne, SingleLinkList linkTwo) {
		Node headNew = null; //ָ���µ�����ͷ�ڵ�
		Node endNew = null; // ָ���µ�����β�ڵ�
		Node linkNodeOne = linkOne.getHeadNode(); //��ȡ����һ������
		Node linkNodeTwo = linkTwo.getHeadNode(); //��ȡ���ڶ�������
		while (linkNodeOne != null && linkNodeTwo != null) {
			Node node = new Node();
			if (linkNodeOne.data < linkNodeTwo.data) {
				node.data = linkNodeOne.data;
				linkNodeOne = linkNodeOne.next;
			} else {
				node.data = linkNodeTwo.data;
				linkNodeTwo = linkNodeTwo.next;
			}
			if (headNew == null) {
				headNew = node;
				endNew = node;
			} else {
				endNew.next = node;
				endNew = node;
			}
		}
		while (linkNodeOne != null) {
			Node node = new Node();
			node.data = linkNodeOne.data;
			endNew.next = node;
			endNew = node;
			linkNodeOne = linkNodeOne.next;
		}

		while (linkNodeTwo != null) {
			Node node = new Node();
			node.data = linkNodeTwo.data;
			endNew.next = node;
			endNew = node;
			linkNodeTwo = linkNodeTwo.next;
		}
		SingleLinkList newLink = new SingleLinkList();
		newLink.setHeadNode(headNew);
		return newLink;
	}

	/*
	 * ������ת
	 */
	public void reverseLinkList() {
		if (head != null) {
			Node curPre = head;
			Node cur = head.next;
			head.next = null;
			while (cur != null) {
				Node curNext = cur.next;
				cur.next = curPre;
				curPre = cur;
				cur = curNext;
			}
			head = curPre;
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
