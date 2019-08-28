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
	
}
