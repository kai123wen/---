package Graph;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: Warshall 
 * @class_describe: 
 * warshell 思想主要就是一个利用一个十字形来对有向图的邻接矩阵进行操作
 * @establish_time: 2019年9月26日 下午3:09:22
 * @how_to_use:
 */
public class Warshall {
	public static void main(String[] args) {
		warshall();
	}

	public static void warshall() {
		int row = 5;
		int column = 5;
		int[][] graphMatrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				graphMatrix[i][j] = 0;
			}
		}
		graphMatrix[0][1] = 1;
		graphMatrix[1][2] = 1;
		graphMatrix[2][3] = 1;
		graphMatrix[3][0] = 1;
		graphMatrix[3][4] = 1;

		for (int n = 0; n < row; n++) {
			// m 指向的是十字的行，k指向的是十字的列
			for (int m = 0; m < row; m++) {
				for (int k = 0; k < row; k++) {
					if (m == n) {
						break;
					}
					if (graphMatrix[n][m] == 1 && graphMatrix[k][n] == 1) {
						graphMatrix[k][m] = 1;
					}
				}
			}
		}
		printArray(graphMatrix, 5, 5);
	}

	public static void printArray(int[][] array, int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
