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
					// start ���ڼ�¼�Ϸ��ĵ�һ�������ŵ�λ��
					stack.pop();
					// �����ʱջ���ˣ�˵������ƥ��Ķ��Ѿ�ƥ������ˣ���ʱ���Ӧ��
					// ��һ���ܹ��ĳ��ȣ�Ȼ���maxlen �Ƚ�
					if (stack.isEmpty()) {
						maxLen = Math.max(i - start, maxLen);
					} else {
						// �����ʱջû�пգ���ô�Ͱ������������м���Ȼ����maxlen���бȽ�
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
