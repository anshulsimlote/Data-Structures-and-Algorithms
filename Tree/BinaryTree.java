package Tree;

public class BinaryTree {
    TreeNode root;
    public class TreeNode{
        int data;
        TreeNode left, right;
        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createBinaryTree(){
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourtNode = new TreeNode(4);
        TreeNode fivethNode = new TreeNode(5);
        TreeNode sixtNode = new TreeNode(6);

        this.root = firstNode;
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourtNode;
        secondNode.right = fivethNode;
        thirdNode.left = sixtNode;
    }

    public static void main(String[] args){
        System.out.println("Binary Tree");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
    }
}
