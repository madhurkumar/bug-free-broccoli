package bug.free.broccoli;

public class TreeToList {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        helper(root, null);
    }

    private static TreeNode helper(TreeNode root, TreeNode last) {
        if (root == null) return last;
        if (last != null) last.right = root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = null;
        root.right = null;
        TreeNode newLast = helper(l, root);
        return helper(r, newLast);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        flatten(root);
        System.out.println(root);
    }
}
