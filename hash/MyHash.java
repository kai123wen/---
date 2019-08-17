package Sort;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: MyHash
 * @class_describe: ʵ��һ���������������ͻ�����ɢ�б�
 * @establish_time: 2019��8��17�� ����8:37:56
 * @how_to_use:
 */
public class MyHash {
	private static final int DEFAULT_LENGTH = 10;
	private static final float LOAD_FACTOR = 0.75f;
	private int size = 0; // ��ϣ����Ԫ�ص�ʵ�ʸ���
	private int use = 0; // ���ݴ�ֵ���ж��Ƿ��������

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
		if (nodeHead.next == null) { // ˵���ýڵ㻹δ��ʹ��
			Node node = new Node(key, value, null);
			nodeHead.next = node;
			size++;
			use++;
			if (use > nodeList.length * LOAD_FACTOR) { // ������
				reSize();
			}
		}
	}

	// ���ݷ���
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
				// �˴����õ���ͷ�巨

				// ��ȡ���¹�ϣ���Ԫ�ز���
				Node nodeNext = nodeList[i].next;
				// ����ʹ�ù�ϣ����
				int newIndex = hash(next.key);
				// temp �� next ָ��ָ�� nodeNext
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
