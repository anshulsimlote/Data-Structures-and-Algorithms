package Tree;

import java.util.Stack;

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

    // Recursive method for preorder traversal
    public void recursivePreorderTraversal(TreeNode root) {
        if (root == null) {
            return; // Base case: if node is null, return
        }
        System.out.print(root.data + " "); // Print the data of the current node
        recursivePreorderTraversal(root.left); // Traverse left subtree
        recursivePreorderTraversal(root.right); // Traverse right subtree
    }
    // Recursive method for inorder traversal
    public void recursiveInorderTraversal(TreeNode root) {
        if (root == null) {
            return; // Base case: if node is null, return
        }
        recursiveInorderTraversal(root.left); // Traverse left subtree
        System.out.print(root.data + " "); // Print the data of the current node
        recursiveInorderTraversal(root.right); // Traverse right subtree
    }
    // Recursive method for postorder traversal
    public void recursivePostorderTraversal(TreeNode root) {
        if (root == null) {
            return; // Base case: if node is null, return
        }
        recursivePreorderTraversal(root.left); // Traverse left subtree
        recursivePreorderTraversal(root.right); // Traverse right subtree
        System.out.print(root.data + " "); // Print the data of the current node
    }

    // Iterative method for preorder traversal
    public void iterativePreorderTraversal(TreeNode root) {
        if (root == null) {
            return; // If the tree is empty, return
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            System.out.print(currentNode.data + " "); // Print the data of the current node

            // Push right child first so that left child is processed first
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
    }


    public void iterativeInorderTraversal(TreeNode root) {
        if (root == null) {
            return; // If the tree is empty, return
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !nodeStack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Current node must be null at this point
            currentNode = nodeStack.pop();
            System.out.print(currentNode.data + " "); // Print the data of the current node

            // Visit the right subtree
            currentNode = currentNode.right;
        }
    }


    public static void main(String[] args) {
        System.out.println("Binary Tree");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        System.out.println("Recursive Preorder Traversal (Node -> Left Tree -> Right Tree):");
        binaryTree.recursivePreorderTraversal(binaryTree.root); // Perform recursive preorder traversal
        System.out.println(); // New line for clarity

        System.out.println("Iterative Preorder Traversal (Node -> Left Tree -> Right Tree):");
        binaryTree.iterativePreorderTraversal(binaryTree.root); // Perform iterative preorder traversal
        System.out.println(); // New line for clarity

        System.out.println("Recursive Inorder Traversal ( Left Tree -> Node ->  Right Tree):");
        binaryTree.recursiveInorderTraversal(binaryTree.root); // Perform recursive inorder traversal
        System.out.println(); // New line for clarity

        System.out.println("Iterative Inorder Traversal ( Left Tree -> Node ->  Right Tree):");
        binaryTree.iterativeInorderTraversal(binaryTree.root); // Perform recursive inorder traversal
        System.out.println(); // New line for clarity

        System.out.println("Recursive Postorder Traversal ( Left Tree ->  Right Tree -> Node):");
        binaryTree.recursivePostorderTraversal(binaryTree.root); // Perform recursive postorder traversal
        System.out.println(); // New line for clarity
    }
}
