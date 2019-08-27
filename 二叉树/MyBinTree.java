package BInTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyBinTree {
	public class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		public Node(int data, Node left, Node right, Node parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	// ���������ڵ�
	Node root = null;

	// ����
	public void insert(int data) {
		// �½��ڵ�
		Node node = new Node(data, null, null, null);
		if (node != null)
			root = insert(root, node);
	}

	/**
	 * �ݹ��
	 */
	private Node insert(Node node, Node insert) {
		if (node == null) {
			node = insert;
		}
		if (insert.data < node.data) {
			node.left = insert(node.left, insert);
			node.left.parent = node;
		} else if (insert.data > node.data) {
			node.right = insert(node.right, insert);
			node.right.parent = node;
		}
		return node;
	}

//	// �ǵݹ��
//	private void insert(Node node, Node insert) {
//		if (root == null) {
//			root = insert;
//			return;
//		}
//		int cmp = 0;
//		// ��¼���ڵ�
//		Node p = null;
//		while (node != null) {
//			p = node;
//			cmp = insert.data.compareTo(node.data);
//			if (cmp < 0) {
//				node = node.left;
//			} else if (cmp > 0) {
//				node = node.right;
//			} else {
//				return;
//			}
//		}
//		insert.parent = p;
//		if (cmp < 0) {
//			p.left = insert;
//		}else if (cmp > 0) {
//			p.right = insert;
//		}
//	}
//	


	// ����������ĺ�̽ڵ�
	public Node getSucceedNode(int data) {
		Node node = search(data);
		if (node.right != null) {
			return getMinNode(node);
		}
		Node parentNode = node.parent;
		while (parentNode != null && parentNode.left != node) {
			node = parentNode;
			parentNode = node.parent;
		}
		return parentNode;
	}

	// �ں�̽ڵ����в�����С�Ľڵ�
	public Node getMinNode(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	// ���������ǰ���ڵ�
	public Node getPreNode(int data) {
		Node node = search(root, data);
		if (node.left != null) {
			return getMaxNode(node.left);
		}
		Node parentNode = node.parent;
		while (parentNode != null && parentNode.right != node) {
			node = parentNode;
			parentNode = node.parent;
		}
		return parentNode;

	}

	// �ҵ�ǰ���ڵ��������Ľڵ�
	public Node getMaxNode(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	// ���������ɾ��
	public void delete(int data) {
		Node node = search(root, data); // �ҵ��ڵ�λ��
		Node succeedNode = null;
		if (node.right != null) {
			succeedNode = getSucceedNode(data);
			int temp = succeedNode.data;
			succeedNode.data = node.data;
			node.data = temp;
			if (succeedNode.parent.left == succeedNode) {
				succeedNode.parent.left = succeedNode.right;
			}
			if (succeedNode.parent.right == succeedNode) {
				succeedNode.parent.right = succeedNode.right;
			}
			succeedNode.right.parent = succeedNode.parent;
		} else {
			if (node.parent.left == node) {
				node.parent.left = node.left;
			}
			if (node.parent.right == node) {
				node.parent.right = node.left;
			}
			// ���Ҫ�����½ڵ�� parent ��ָ��
			// ����Ҫע����ǣ���Ϊ��һ�� if ��û�иı�
			node.left.parent = node.parent;
		}
	}

	// ���ң���������������
	public Node search(int data) {
		return search(this.root, data);
	}

	// ����������
	public Node search(Node rootNode, int data) {
		if (rootNode.data == data) {
			return rootNode;
		}
		if (data < rootNode.data) {
			return search(rootNode.left, data);
		} else {
			return search(rootNode.right, data);
		}
	}

	// ���ⲿ���õı�������
	public void printTree() {
		printTree(root);
	}

	// ����ǰ���������ӡ�����������
	public void printTree(Node rootNode) {
		if (rootNode == null) {
			return;
		}
		System.out.print(rootNode.data + "  ");
		printTree(rootNode.left);
		printTree(rootNode.right);
	}

	// ��α��������ⲿ��������
	public void searchLayer() {
		searchLayer(root);
	}

	public void searchLayer(Node root) {
		LinkedList<Node> nodeList = new LinkedList<Node>();
		nodeList.offer(root);
		while (!nodeList.isEmpty()) {
			Node node = nodeList.poll();
			System.out.print(node.data + " ");
			if (node.left != null) {
				nodeList.offer(node.left);
			}
			if (node.right != null) {
				nodeList.offer(node.right);
			}

		}
	}
}
