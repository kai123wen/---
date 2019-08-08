package recursion;

/**
 * 
 * @author: Guo Zhenhao
 * @project_name: CodeWork
 * @class_name: RecursionClass
 * @class_describe: - 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2) - 编程实现求阶乘 n! -
 *                  编程实现一组数据集合的全排列
 * @establish_time: 2019年8月8日 下午11:05:29
 * @how_to_use:
 */
public class RecursionClass {
	public int fibo(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public void getArrangement(int[] array, int start) {
		if (start == array.length - 1) {
			print(array);
		}
		for (int i = start; i <= array.length - 1; i++) {
			swap(array, start, i);
			getArrangement(array, start + 1);
			swap(array, start, i);
		}
	}
	
	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
