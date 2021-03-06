package binaryTrees;
import java.util.Scanner;
public class MirrorBinaryTree {

	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter Root Data : ");
		}else {
			if(isLeft){
				System.out.println("ENter left child of " + parentData);
			}else {
				System.out.println("ENter right child of " + parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = treeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = treeInputBetter(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
		
	}
	
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ",");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}
	
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
//		if(root == null) {
//			return;
//		}
//		BinaryTreeNode<Integer>left = root.left;
//		root.left = root.right;
//		root.right = left;
//		mirrorBinaryTree(root.left);
//		mirrorBinaryTree(root.right);
		
		
		if(root == null) {
			return;
		}
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		printTreeDetailed(root);
		mirrorBinaryTree(root);
		printTreeDetailed(root);
	}

}
