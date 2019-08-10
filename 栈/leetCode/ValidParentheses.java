package LeetCode;

class ValidParentheses {
	public boolean isValid(String s) {
		char[] stackOne = s.toCharArray(); // 用于存放符号原本的符号序列
		char[] opLeft = new char[] { '(', '[', '{' };
		char[] opRight = new char[] { ')', ']', '}' };
		int stackOneTop = stackOne.length - 1; // 代表栈顶
		int stackTwoTop = 0;
		char[] stackTwo = new char[stackOne.length];
		// 这里很重要！！
		if (stackOne.length % 2 != 0) {
			return false;
		}
		for (int i = 0; i < stackOne.length; i++) {
			char outOne = pop(stackOne, stackOneTop);
			stackOneTop--;
			if (isInArray(opRight, outOne)) {
				push(stackTwo, stackTwoTop, outOne);
				stackTwoTop++;
			} else {
				char outTwo = pop(stackTwo, stackTwoTop - 1);
				stackTwoTop--;
				if (isMatch(opLeft, opRight, outOne, outTwo)) {
					continue;
				} else {
					return false;
				}
			}

		}
		return true;
	}

	public char pop(char[] stackOne, int stackOneTop) {
		if (stackOneTop >= 0) {
			return stackOne[stackOneTop];
		} else {
			System.out.println("the stack is empty!");
			return ' ';
		}
	}

	public boolean isMatch(char[] arrayOne, char[] arrayTwo, char targetOne, char targetTwo) {
		int oneIndex = -1;
		int twoIndex = -1;
		for (int i = 0; i < arrayOne.length; i++) {
			if (arrayOne[i] == targetOne) {
				oneIndex = i;
			}
		}

		for (int i = 0; i < arrayTwo.length; i++) {
			if (arrayTwo[i] == targetTwo) {
				twoIndex = i;
			}
		}
		if (oneIndex == twoIndex) {
			return true;
		} else {
			return false;
		}
	}

	public void push(char[] stackTwo, int stackTwoTop, char value) {
		stackTwo[stackTwoTop] = value;
	}

	public boolean isInArray(char[] array, char target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return true;
			}
		}
		return false;
	}
}
