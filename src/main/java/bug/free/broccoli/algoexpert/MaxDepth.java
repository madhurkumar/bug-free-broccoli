package bug.free.broccoli.algoexpert;

public class MaxDepth {
    static class Node {
        int value;
        Node left, right;

        Node(int val) {
            value = val;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        int maxDepth(Node root) {
            if (root == null)
                return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

     public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        tree.root = root;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        System.out.println("Max depth: " + tree.maxDepth(tree.root));
    }
}
