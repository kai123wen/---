package BInTree;

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

	public Node insert(Node root, int data) {
		Node x = search(root,data);
		if (root == null)
			root = x;
		Node p = null;// 需要记录父节点
		while (root != null)// 定位插入的位置
		{
			p = root;// 记录父节点
			if (x.data < root.data)
				root = root.left;
			else
				root = root.right;
		}
		x.parent = p;// 定位到合适的页节点的空白处后，根据和父节点的大小比较插入合适的位置
		if (x.data < p.data)
			p.left = x;
		else if (x.data > p.data)
			p.right = x;
		return root;
	}

	// 二叉查找树插入：外部调用
	public void insert(int data) {
		insert(root, data,null);
	}

	// 二叉查找树插入
	public Node insert(Node root, int data, Node parent) {
		if (root == null) {
			root = new Node(data, null, null, parent);
		}
		if (data < root.data) {
			root.left = insert(root.left, data, root);
		} else {
			root.right = insert(root.right, data, root);
		}
		return root;
	}

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
		Node node = search(root,data);
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
		Node node = search(root,data); // 找到节点位置
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
		System.out.print(rootNode.data + ' ');
		printTree(rootNode.left);
		printTree(rootNode.right);
	}
}
