package MyTrieTree;

import java.util.HashMap;

public class Trie_Tree {
	/*
	 * 内部节点类
	 */
	private class Node {
		private int dumpli_num;// 字符串重复的数目
		private int prefix_num;// 以该字符串为前缀的字符数
		private Node childs[]; // 孩子节点
		private boolean isLeaf; // 是否为单词节点，即是否为叶子节点

		public Node() {
			dumpli_num = 0;
			prefix_num = 0;
			isLeaf = false;
			childs = new Node[26];
		}
	}

	private Node root;// 树根

	public Trie_Tree() {
		// 初始化树
		root = new Node();
	}

	/*
	 * 插入字符串，供外部调用使用
	 */
	public void insert(String words) {
		insert(root, words);
	}

	/*
	 * 插入字符串，用循环代替迭代来实现
	 */
	public void insert(Node root, String words) {
		words = words.toLowerCase();// 全部转换为小写
		char[] wordArray = words.toCharArray();
		for (int i = 0; i < wordArray.length; i++) {
			int index = wordArray[i] - 'a'; // 得到相对 a 的偏移
			if (root.childs[index] != null) {
				root.childs[index].prefix_num++;
			} else {
				Node node = new Node();
				node.prefix_num++;
				root.childs[index] = node;
			}
			// 还需要判断是否到达了字符串结尾
			if (i == wordArray.length - 1) {
				root.childs[index].isLeaf = true;
				root.childs[index].dumpli_num++;
				System.out.println("successful");
			}
			root = root.childs[index];
		}
	}

	/*
	 * 前序遍历，供外部调用的方法
	 */
	public HashMap<String, Integer> getAllWords() {
		return preTraversal(root, "");
	}

	/**
	 * 前序遍历。。。
	 * 
	 * @param root    子树根节点
	 * @param prefixs 查询到该节点前所遍历过的前缀
	 * @return
	 */
	private HashMap<String, Integer> preTraversal(Node root, String prefixs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		if (root != null) {

			if (root.isLeaf == true) {
				//// 当前即为一个单词
				map.put(prefixs, root.dumpli_num);
			}

			for (int i = 0, length = root.childs.length; i < length; i++) {
				if (root.childs[i] != null) {
					char ch = (char) (i + 'a');
					//// 递归调用前序遍历
					String tempStr = prefixs + ch;
					map.putAll(preTraversal(root.childs[i], tempStr));
				}
			}
		}
		return map;
	}

}
