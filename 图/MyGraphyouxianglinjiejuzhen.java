package Graph;

/*
 * ����ͼ �ڽӾ����ʾ��
 */
public class MyGraphyouxianglinjiejuzhen {
	private char[] mVexs; // ���㼯��
	private int[][] mMatrix; // �ߵ��ڽӾ���
	int vexLength = 0;
	int edgesLength = 0;

	public MyGraphyouxianglinjiejuzhen(char[] mVexs, char[][] edges) {
		this.mVexs = mVexs;
		vexLength = mVexs.length; // ������
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

	// ��ȡ����ýڵ����ڵĵ�һ���ڵ�
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

	// ��ȡ�����������Ϊ Index �Ľڵ������ ����Ϊ w ����һ�����ڽڵ�
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
	 * ������������ݹ�ʵ��
	 */
	public void DFS(int index, boolean[] isVisited) {
		if (isVisited[index] == false) {
			isVisited[index] = true;// ���Ϊ�Ѿ�����
			System.out.print(mVexs[index] + " ");
			for (int w = getFirstPosition(index); w != -1; w = getNextPosition(index, w)) {
				if (isVisited[w] == false) {
					DFS(w, isVisited);
				}
			}
		}
	}

	/*
	 * ͼ�������������
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
	 * ͼ�Ĺ����������
	 */
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[mVexs.length];// ��������
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
