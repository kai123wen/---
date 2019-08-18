package HashAndString;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: MyHash
 * @class_describe: ʵ��һ���������������ͻ�����ɢ�б�
 * @establish_time: 2019��8��17�� ����8:37:56
 * @how_to_use: MyHash hash = new MyHash(); hash.put(0, "I"); hash.put(1,
 *              "love"); hash.put(2, "you"); hash.put(12, "me");
 *              System.out.println(hash.get(12));
 *              System.out.println(hash.delete(12));
 *              System.out.println(hash.delete(12)); //
 *              System.out.println(hash.get(12));
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
		} else { // ˵���ڵ��Ѿ���ʹ��

			// ������Ҫ���һ�� put ��Ŀ���Ƿ���Ҫ�޸�ֵ
			for (nodeHead = nodeHead.next; nodeHead != null; nodeHead = nodeHead.next) {
				int k = nodeHead.key;
				if (k == key) {
					nodeHead.value = value;
					return;
				}
			}

			Node temp = nodeList[index].next;
			Node node = new Node(key, value, temp);
			nodeList[index].next = node;
			size++;
		}
	}

	// ��ȡ��ϣ���С
	public int getSize() {
		return size;
	}

	// ͨ�� key ��ɾ��value
	public boolean delete(int key) {
		int index = hash(key);
		Node temp = nodeList[index];
		Node tempPre = nodeList[index];
		if (temp != null && temp.next != null) {
			for (temp = temp.next; temp != null; tempPre = temp, temp = temp.next) {
				if (temp.key == key) {
					tempPre.next = temp.next;
					size--;
					return true;
				}
			}
		}
		return false;
	}

	// ͨ�� key ����ȡ��value
	public String get(int key) {
		int index = hash(key);
		Node temp = nodeList[index];
		if (temp != null && temp.next != null) {
			for (temp = temp.next; temp != null; temp = temp.next) {
				if (temp.key == key) {
					return temp.value;
				}
			}
		}
		return "#";
	}

	// ���ݷ���
	public void reSize() {
		int newSize = DEFAULT_LENGTH * 2;
		Node[] oldNodeList = nodeList;
		nodeList = new Node[newSize];
		use = 0;
		for (int i = 0; i < oldNodeList.length; i++) {
			Node nodeTemp = oldNodeList[i];
			while (nodeTemp.next != null && nodeTemp != null) {
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
