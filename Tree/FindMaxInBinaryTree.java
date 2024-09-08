package Tree;

public class FindMaxInBinaryTree {
    TreeNode root;

    // Inner class representing a node in the binary tree
    public class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // Method to create a sample binary tree
    public void createBinaryTree() {
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourthNode = new TreeNode(4);
        TreeNode fifthNode = new TreeNode(5);
        TreeNode sixthNode = new TreeNode(6);

        this.root = firstNode;
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
        thirdNode.left = sixthNode;
    }

    // Method to find the maximum value in the binary tree
    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find Max In Binary Tree");

        // Creating an instance of FindMaxInBinaryTree
        FindMaxInBinaryTree binaryTree = new FindMaxInBinaryTree();

        // Creating the binary tree
        binaryTree.createBinaryTree();

        // Finding and printing the maximum value in the binary tree
        int result = binaryTree.findMax(binaryTree.root);
        System.out.println("Max -> " + result);
    }
}
