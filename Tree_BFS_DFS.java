import java.util.LinkedList;
import java.util.Queue;

public class Tree_BFS_DFS {
	
	public static void main(String[] args) {
		new Tree_BFS_DFS();
	}
	
	public Tree_BFS_DFS() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = new TreeNode();
		root = levelOrderInsert(arr, root, 0);
		printTreeLevelOrder(root);
		System.out.println("\n------------------------------------------------\nDFS:\n");
		doDFSOnTreeNode(root, 0);
	}
	
	/**
	 * Left Child is (2*index) + 1, Right Child is (2*index) + 2
	 * @param arr
	 * @return
	 */
	private TreeNode levelOrderInsert(int[] arr, TreeNode node, int index) {
		if(index < arr.length) {
			TreeNode temp = new TreeNode();
			temp.val = arr[index];
			node = temp;
			//insert left child
			node.left = levelOrderInsert(arr, node.left, (2*index)+1);
			//insert right child
			node.right = levelOrderInsert(arr, node.right, (2*index)+2);
		}
		
		return node;
	}
	
	/**
	 * Does a BFS
	 * @param root
	 */
	private void printTreeLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int index=0; index<size; index++) {
				TreeNode current = queue.poll();
				System.out.println("Level " + level + ", Value: " + current.val);
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
			}
			level++;
		}
	}
	
	private void doDFSOnTreeNode(TreeNode root, int level) {
		if(root == null) {
			System.out.println("Level " + level + ", Value: NULL");
			return;
		}
		System.out.println("Level " + level + ", Value: " + root.val);
		doDFSOnTreeNode(root.left, level+1);
		doDFSOnTreeNode(root.right, level+1);
	}
	
	/**
	 * 
	 * @author nealk
	 *
	 */
	
	private class TreeNode{
		public int val;
		public TreeNode left, right;
	}

}
