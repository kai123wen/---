package Graph;

/*
 * 有向图 邻接矩阵表示法
 */
public class MyGraphyouxianglinjiejuzhen {
	private char[] mVexs; // 定点集合
	private int[][] mMatrix; // 边的邻接矩阵
	int vexLength = 0;
	int edgesLength = 0;

	public MyGraphyouxianglinjiejuzhen(char[] mVexs, char[][] edges) {
		this.mVexs = mVexs;
		vexLength = mVexs.length; // 顶点数
		edgesLength = edges.length;
		mMatrix = new int[vexLength][vexLength];
		for (int i = 0; i < edgesLength; i++) {
			int first = getPosition(edges[i][0]);
			int second = getPosition(edges[i][1]);
			mMatrix[first][second] = 1;
		}
	}

	public int getPosition(char target) {
		for (int i = 0; i < mVexs.length; i++) {
			if (target == mVexs[i]) {
				return i;
			}
		}
		return -1;
	}

	public void printM() {
		for (int i = 0; i < vexLength; i++) {
			for (int j = 0; j < vexLength; j++) {
				System.out.print(mMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 获取到与该节点相邻的第一个节点
	public int getFirstPosition(int index) {
		if (index < 0 || index > (mVexs.length - 1))
			return -1;

		for (int i = 0; i < mVexs.length; i++) {
			if (mMatrix[index][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	// 获取到相对于索引为 Index 的节点相对于 索引为 w 的下一个相邻节点
	public int getNextPosition(int index, int w) {

		if (index < 0 || index > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1)) {
			return -1;
		}

		for (int i = w + 1; i < mVexs.length; i++) {
			if (mMatrix[index][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * 深度优先搜索递归实现
	 */
	public void DFS(int index, boolean[] isVisited) {
		if (isVisited[index] == false) {
			isVisited[index] = true;// 标记为已经访问
			System.out.print(mVexs[index] + " ");
			for (int w = getFirstPosition(index); w != -1; w = getNextPosition(index, w)) {
				if (isVisited[w] == false) {
					DFS(w, isVisited);
				}
			}
		}
	}

	/*
	 * 图的深度优先搜索
	 */
	public void DFS() {
		boolean[] isVisited = new boolean[mVexs.length];
		for (int i = 0; i < isVisited.length; i++) {
			if (isVisited[i] == false) {
				DFS(i, isVisited);
			}
		}
	}

	/*
	 * 图的广度优先搜索
	 */
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[mVexs.length];// 辅助队列
		boolean[] isVisited = new boolean[mVexs.length];
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < mVexs.length; i++) {
			if (isVisited[i] == false) {
				isVisited[i] = true;
				System.out.print(mVexs[i] + " ");
				queue[rear] = i;
				rear++;
			}
			while (head != rear) {
				int index = queue[head];
				head++;
				for (int w = getFirstPosition(index); w != -1; w = getNextPosition(index, w)) {
					if (isVisited[w] == false) {
						isVisited[w] = true;
						System.out.print(mVexs[w] + " ");
						queue[rear] = w;
						rear++;

					}
				}
			}
			System.out.println();
		}
	}
}
