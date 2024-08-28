package Tree;

public class BinaryTree {
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
        TreeNode fourthNode = new TreeNode(4); // Corrected spelling
        TreeNode fifthNode = new TreeNode(5); // Corrected spelling
        TreeNode sixthNode = new TreeNode(6); // Corrected spelling

        this.root = firstNode;
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
        thirdNode.left = sixthNode;
    }

    // Recursive method for preorder traversal
    public void recursivePreorderTraversal(TreeNode root) {
        if (root == null) { // Check if the node is null before accessing data
            return;
        }
        System.out.print(root.data + " "); // Print the data of the current node
        recursivePreorderTraversal(root.left); // Traverse left subtree
        recursivePreorderTraversal(root.right); // Traverse right subtree
    }

    public static void main(String[] args) {
        System.out.println("Binary Tree");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        System.out.println("Preorder Traversal (Node -> Left Tree -> Right Tree):");
        binaryTree.recursivePreorderTraversal(binaryTree.root); // Perform preorder traversal
    }
}
