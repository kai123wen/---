package LinkList;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: SingleLinkList
 * @class_describe: 实现单链表，支持增删操作
 * @establish_time: 2019年8月4日 下午9:15:58
 * @how_to_use: 
 * SingleLinkList link = new SingleLinkList(); 
 * for (int i = 0; i < 5; i++) { 
 * 		link.addNode(i); 
 * } 
 * link.printLinkList();
 * link.deleteNode(2);
 * link.printLinkList();
 * link.reverseLinkList();
	link.printLinkList();
 */
public class SingleLinkList {
	class Node {
		Node next = null;
		int data;
	}

	int length = 0; // 节点数目
	Node head = null; // 链表头节点

	/*
	 * 增加节点
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
	 * 删除节点
	 */
	public void deleteNode(int pos) {
		if (pos > length) {
			System.out.println("the postion is illegal");
		} else {
			Node temp = head;
			// 如果是删除第一个节点，就需要特殊处理
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
	 * 单链表反转
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
	 * 打印链表
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
