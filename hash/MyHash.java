package Sort;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: MyHash
 * @class_describe: 实现一个基于链表法解决冲突问题的散列表
 * @establish_time: 2019年8月17日 下午8:37:56
 * @how_to_use:
 */
public class MyHash {
	private static final int DEFAULT_LENGTH = 10;
	private static final float LOAD_FACTOR = 0.75f;
	private int size = 0; // 哈希表中元素的实际个数
	private int use = 0; // 根据此值来判断是否进行扩容

	private class Node {
		int key;
		String value;
		Node next = null;

		public Node(int key, String value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node[] nodeList = new Node[DEFAULT_LENGTH];

	public void put(int key, String value) {
		int index = hash(key);
		if (nodeList[index] == null) {
			nodeList[index] = new Node(-1, " ", null);
		}
		Node nodeHead = nodeList[index];
		if (nodeHead.next == null) { // 说明该节点还未被使用
			Node node = new Node(key, value, null);
			nodeHead.next = node;
			size++;
			use++;
			if (use > nodeList.length * LOAD_FACTOR) { // 超过了
				reSize();
			}
		}
	}

	// 扩容方法
	public void reSize() {
		int newSize = DEFAULT_LENGTH * 2;
		Node[] oldNodeList = nodeList;
		nodeList = new Node[newSize];
		int index;
		use = 0;
		for (int i = 0; i < oldNodeList.length; i++) {
			Node nodeTemp = oldNodeList[i];
			while (nodeTemp.next != null) {
				Node next = nodeTemp.next;
				if (nodeList[i] == null) {
					use++;
					nodeList[i] = new Node(-1, " ", null);
				}
				// 此处采用的是头插法

				// 获取到新哈希表的元素部分
				Node nodeNext = nodeList[i].next;
				// 重新使用哈希函数
				int newIndex = hash(next.key);
				// temp 的 next 指针指向 nodeNext
				Node temp = new Node(newIndex, next.value, nodeNext);
				nodeList[i].next = temp;
				nodeTemp = nodeTemp.next;
			}
		}

	}

	public int hash(int key) {
		return key % nodeList.length;
	}
}
