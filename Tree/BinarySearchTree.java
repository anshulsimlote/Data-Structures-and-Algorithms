package Tree;

public class BinarySearchTree {

    // The root of the Binary Search Tree
    private TreeNode root;

    // TreeNode class to represent each node in the tree
    private class TreeNode {
        private int data;
        private TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // Public method to insert a value into the BST
    public BinarySearchTree insert(int value) {
        root = insert(root, value);
        return this; // Return 'this' to allow method chaining if desired
    }

    public void search(int value) {
        search(root, value);
    }
    
    // Recursive method to insert a value into the BST
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // Inorder traversal: Left -> Root -> Right
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println(); // Print a new line after traversal
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    // Preorder traversal: Root -> Left -> Right
    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // Postorder traversal: Left -> Right -> Root
    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // Method to search for a value in the BST
    private void search(TreeNode node, int data) {
        if (node == null) {
            System.out.println(data + " not found");
            return;
        }
        if (node.data == data) {
            System.out.println(data + " found");
            return;
        } else if (data < node.data) {
            search(node.left, data);
        } else {
            search(node.right, data);
        }
    }

    // Main method to test the Binary Search Tree
    public static void main(String[] args) {
        System.out.println("Binary Search Tree");
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values
        bst.insert(5).insert(3).insert(7).insert(1).insert(9).insert(6);

        // Perform traversals
        System.out.println("Inorder Traversal (Sorted):");
        bst.inOrderTraversal();

        System.out.println("Preorder Traversal:");
        bst.preOrderTraversal();

        System.out.println("Postorder Traversal:");
        bst.postOrderTraversal();

        // Search for values
        System.out.println("Search results:");
        bst.search(2);
        bst.search(9);
    }
}
