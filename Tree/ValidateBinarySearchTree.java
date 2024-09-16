package Tree;

public class ValidateBinarySearchTree {
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
        TreeNode firstNode = new TreeNode(4);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(5);
        TreeNode fourthNode = new TreeNode(1);
        TreeNode fifthNode = new TreeNode(3);

        this.root = firstNode;
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
    }

    // Method to validate whether a binary tree is a binary search tree
    public boolean validate(TreeNode node, int min, int max) {
        if (node == null) {
            return true; // Base case: an empty tree is a valid BST
        }

        // Check if the current node's data is within the valid range
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively validate the left and right subtrees
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    public static void main(String[] args) {
        System.out.println("Validate Binary Search Tree");
        ValidateBinarySearchTree binaryTree = new ValidateBinarySearchTree();
        binaryTree.createBinaryTree();
        boolean result = binaryTree.validate(binaryTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Is the tree a valid BST? " + result);
    }
}
