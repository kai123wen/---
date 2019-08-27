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

	// 二叉树根节点
	Node root = null;

	// 插入
	public void insert(int data) {
		// 新建节点
		Node node = new Node(data, null, null, null);
		if (node != null)
			root = insert(root, node);
	}

	/**
	 * 递归版
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

//	// 非递归版
//	private void insert(Node node, Node insert) {
//		if (root == null) {
//			root = insert;
//			return;
//		}
//		int cmp = 0;
//		// 记录父节点
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


	// 二叉查找树的后继节点
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

	// 在后继节点树中查找最小的节点
	public Node getMinNode(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	// 二叉查找树前驱节点
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

	// 找到前驱节点树中最大的节点
	public Node getMaxNode(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	// 二叉查找树删除
	public void delete(int data) {
		Node node = search(root, data); // 找到节点位置
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
			// 最后要调整新节点的 parent 的指向
			// 这里要注意的是，因为上一个 if 中没有改变
			node.left.parent = node.parent;
		}
	}

	// 查找，供其他方法调用
	public Node search(int data) {
		return search(this.root, data);
	}

	// 二叉树查找
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

	// 供外部调用的遍历方法
	public void printTree() {
		printTree(root);
	}

	// 根据前序遍历来打印出二叉查找树
	public void printTree(Node rootNode) {
		if (rootNode == null) {
			return;
		}
		System.out.print(rootNode.data + "  ");
		printTree(rootNode.left);
		printTree(rootNode.right);
	}

	// 层次遍历，供外部方法调用
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
