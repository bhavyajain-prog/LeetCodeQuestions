package DataStructures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void print(TreeNode node) {
        if (node == null) {
            // System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        print(node.left);
        print(node.right);
    }
}
