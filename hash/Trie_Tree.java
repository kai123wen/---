package MyTrieTree;

import java.util.HashMap;

public class Trie_Tree {
	/*
	 * �ڲ��ڵ���
	 */
	private class Node {
		private int dumpli_num;// �ַ����ظ�����Ŀ
		private int prefix_num;// �Ը��ַ���Ϊǰ׺���ַ���
		private Node childs[]; // ���ӽڵ�
		private boolean isLeaf; // �Ƿ�Ϊ���ʽڵ㣬���Ƿ�ΪҶ�ӽڵ�

		public Node() {
			dumpli_num = 0;
			prefix_num = 0;
			isLeaf = false;
			childs = new Node[26];
		}
	}

	private Node root;// ����

	public Trie_Tree() {
		// ��ʼ����
		root = new Node();
	}

	/*
	 * �����ַ��������ⲿ����ʹ��
	 */
	public void insert(String words) {
		insert(root, words);
	}

	/*
	 * �����ַ�������ѭ�����������ʵ��
	 */
	public void insert(Node root, String words) {
		words = words.toLowerCase();// ȫ��ת��ΪСд
		char[] wordArray = words.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			int index = wordArray[i] - 'a'; // �õ���� a ��ƫ��
			if (root.childs[index] != null) {
				root.childs[index].prefix_num++;
			} else {
				Node node = new Node();
				node.prefix_num++;
				root.childs[index] = node;
			}
			// ����Ҫ�ж��Ƿ񵽴����ַ�����β
			if (i == wordArray.length - 1) {
				root.childs[index].isLeaf = true;
				root.childs[index].dumpli_num++;
				System.out.println("successful");
			}
			root = root.childs[index];
		}
	}

	/*
	 * ǰ����������ⲿ���õķ���
	 */
	public HashMap<String, Integer> getAllWords() {
		return preTraversal(root, "");
	}

	/**
	 * ǰ�����������
	 * 
	 * @param root    �������ڵ�
	 * @param prefixs ��ѯ���ýڵ�ǰ����������ǰ׺
	 * @return
	 */
	private HashMap<String, Integer> preTraversal(Node root, String prefixs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		if (root != null) {

			if (root.isLeaf == true) {
				//// ��ǰ��Ϊһ������
				map.put(prefixs, root.dumpli_num);
			}

			for (int i = 0, length = root.childs.length; i < length; i++) {
				if (root.childs[i] != null) {
					char ch = (char) (i + 'a');
					//// �ݹ����ǰ�����
					String tempStr = prefixs + ch;
					map.putAll(preTraversal(root.childs[i], tempStr));
				}
			}
		}
		return map;
	}

}
