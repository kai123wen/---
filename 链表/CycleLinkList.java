package LinkList;

import LinkList.SingleLinkList.Node;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: CycleLinkList
 * @class_describe: 实现循环链表，支持增删操作
 * @establish_time: 2019年8月4日 下午11:07:57
 * @how_to_use:
 */
public class CycleLinkList {
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
			// 只含有一个头节点时
			head.next = head;
		} else {
			Node temp = head;
			int lengthTemp = length;// 用于找到最后一个节点
			while (lengthTemp > 1) {
				temp = temp.next;
				lengthTemp--;
			}
			Node node = new Node();
			node.data = data;
			temp.next = node;
			// 作为循环链表，最后一个节点要与第一个节点相连
			node.next = head;
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
	 * 打印链表
	 */
	public void printLinkList() {
		Node temp = head;
		int lengthTemp = length;// 用于找到最后一个节点
		while (lengthTemp > 0) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			lengthTemp--;
		}
		System.out.println();
	}
}
