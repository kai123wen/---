package LeetCode;

public class MaximumDepthBinTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root != null) {
			int leftLength = maxDepth(root.left);
			int rightLength = maxDepth(root.right);
			return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
		}
		return 0;
	}
}
