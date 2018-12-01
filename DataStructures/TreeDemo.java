import java.util.Random;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public void insert(int value) {
		if (value <= this.data) {
			if (this.left == null)
				this.left = new TreeNode(value);
			else
				this.left.insert(value);
		} else {
			if (this.right == null)
				this.right = new TreeNode(value);
			else
				this.right.insert(value);
		}
	}

	public boolean contains(int value) {
		if (value == data)
			return true;
		else if (value < data) {
			return this.left == null ? false : left.contains(value);
		} else {
			return this.right == null ? false : right.contains(value);
		}
	}

	public void printInorderTraversal() {
		if (left != null)
			left.printInorderTraversal();
		System.out.print(" " + this.data);
		if (right != null)
			right.printInorderTraversal();
	}

	public void printPreOrder() {
		System.out.print(" " + this.data);
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	public void printPostOrder() {
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
		System.out.print(" " + this.data);
	}

	public int findHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		if (left == null && right == null)
			return 0;
		else {
			if (left != null)
				leftHeight = left.findHeight();
			if (right != null)
				rightHeight = right.findHeight();
		}
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}
}

public class TreeDemo {

	public static void main(String[] args) {

		Random random = new Random();
		TreeNode treeNode = new TreeNode(10);

		for (int i = 0; i < 10; i++)
			treeNode.insert(random.nextInt(20));

		// Check if element/node is present
		System.out.println("Contains 7? " + treeNode.contains(7));

		// Print the height of the tree
		System.out.println("Height of the tree: " + treeNode.findHeight());

		// Print PreOrder
		System.out.print("PreOrder Traversal : ");
		treeNode.printPreOrder();
		System.out.println();

		// Print PostOrder
		System.out.print("PostOrder Traversal : ");
		treeNode.printPostOrder();
		System.out.println();

		// Print Inorder
		System.out.print("Inorder Traversal : ");
		treeNode.printInorderTraversal();
		System.out.println();

	}

}

