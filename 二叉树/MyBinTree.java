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

	// ���������ڵ�
	Node root = null;

	public Node insert(Node root, int data) {
		Node x = search(root,data);
		if (root == null)
			root = x;
		Node p = null;// ��Ҫ��¼���ڵ�
		while (root != null)// ��λ�����λ��
		{
			p = root;// ��¼���ڵ�
			if (x.data < root.data)
				root = root.left;
			else
				root = root.right;
		}
		x.parent = p;// ��λ�����ʵ�ҳ�ڵ�Ŀհ״��󣬸��ݺ͸��ڵ�Ĵ�С�Ƚϲ�����ʵ�λ��
		if (x.data < p.data)
			p.left = x;
		else if (x.data > p.data)
			p.right = x;
		return root;
	}

	// ������������룺�ⲿ����
	public void insert(int data) {
		insert(root, data,null);
	}

	// �������������
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

	// �ҵ�ǰ���ڵ��������Ľڵ�
	public Node getMaxNode(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	// ���������ɾ��
	public void delete(int data) {
		Node node = search(root,data); // �ҵ��ڵ�λ��
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
		System.out.print(rootNode.data + ' ');
		printTree(rootNode.left);
		printTree(rootNode.right);
	}
}
