package Graph;

public class MyGraphyouxianglinjiebiao {
	private class ENode {
		int index = -1;
		ENode next = null;
	}

	private class VNode {
		char data;
		ENode firstEdge = null;
	}

	VNode[] nodeList;

	public MyGraphyouxianglinjiebiao(char[] nodeL, char[][] edges) {
		nodeList = new VNode[nodeL.length];
		for (int i = 0; i < nodeL.length; i++) {
			VNode node = new VNode();
			node.data = nodeL[i];
			node.firstEdge = null;
			nodeList[i] = node;
		}
		for (int j = 0; j < edges.length; j++) {
			int first = getPosition(edges[j][0]);
			int second = getPosition(edges[j][1]);
			insertEdges(first, second);
		}

	}

	public void insertEdges(int first, int second) {
		ENode eNode = new ENode();
		eNode.index = second;
		eNode.next = nodeList[first].firstEdge;
		nodeList[first].firstEdge = eNode;
	}

	public int getPosition(char target) {
		for (int i = 0; i < nodeList.length; i++) {
			if (target == nodeList[i].data) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 找到节点的第一个邻接点
	 */
	public int getFirstPosition(int index) {
		VNode vNode = nodeList[index];
		ENode eNode = vNode.firstEdge;
		return eNode.index;
	}

	/*
	 * 深度优先遍历，递归
	 */
	public void DFS(int index, boolean[] isVisited) {
		if (isVisited[index] == false) {
			isVisited[index] = true;
			System.out.print(nodeList[index].data + " ");
			VNode vNode = nodeList[index];
			ENode eNode = vNode.firstEdge;
//			System.out.println(eNode.index);
			while (eNode != null) {
				int w = eNode.index;
				DFS(w, isVisited);
				eNode = eNode.next;
			}
		}
	}

	/*
	 * 深度优先遍历
	 */
	public void DFS() {
		boolean[] isVisited = new boolean[nodeList.length];
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < isVisited.length; i++) {
			if (isVisited[i] == false) {
				DFS(i, isVisited);
			}
		}
	}

	/*
	 * 广度优先遍历
	 */
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[nodeList.length];
		boolean[] isVisited = new boolean[nodeList.length];
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
		for (int j = 0; j < nodeList.length; j++) {
			if (isVisited[j] == false) {
				queue[rear] = j;
				rear++;
				isVisited[j] = true;
				System.out.print(nodeList[j].data + " ");
//				printArray(queue);
			}

			while (head != rear) {
				int index = queue[head];
				head++;
				VNode nodeTemp = nodeList[index];
				ENode eNodeTemp = nodeTemp.firstEdge;
				while (eNodeTemp != null ) {
					int tempIndex = eNodeTemp.index;
					if (isVisited[tempIndex] == false) {
						isVisited[tempIndex] = true;
						queue[rear] = tempIndex;
						rear++;
						System.out.print(nodeList[tempIndex].data + " ");
//						printArray(queue);
						eNodeTemp = eNodeTemp.next;
					}
				}

			}
		}
	}

	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
