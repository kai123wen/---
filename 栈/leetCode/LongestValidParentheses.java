package LeetCode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int start = 0;
		int maxLen = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					// start 用于记录合法的第一个左括号的位置
					stack.pop();
					// 如果此时栈空了，说明可以匹配的都已经匹配完成了，这时候就应该
					// 算一算总共的长度，然后和maxlen 比较
					if (stack.isEmpty()) {
						maxLen = Math.max(i - start, maxLen);
					} else {
						// 如果此时栈没有空，那么就按照正常来进行计算然后与maxlen进行比较
						maxLen = Math.max(i - stack.peek(), maxLen);
					}
				} else {
					start = i;
				}
			}
		}
		return maxLen;
	}
}
