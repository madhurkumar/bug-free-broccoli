package bug.free.broccoli.algoexpert;

public class InvertBST {

    public static void invertBinaryTree(BinaryTree tree) {
        swap(tree);
    }

    private static void swap(BinaryTree tree) {
        if (tree == null) return;
        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
        swap(tree.left);
        swap(tree.right);
    }

    private static void inOrder(BinaryTree tree){
        if(tree==null) return;
        inOrder(tree.left);
        System.out.print(tree.value+" ");
        inOrder(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        root.right.left = new BinaryTree(6);
        inOrder(root);
        System.out.print("=== ");
        invertBinaryTree(root);
        inOrder(root);
    }
}
