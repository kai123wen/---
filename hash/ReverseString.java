package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {
	public void reverseString(char[] array) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i < array.length; i++) {
			map.put(i, array[i]);
		}
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = map.get(array.length - 1 - i);
		}
	}
}
