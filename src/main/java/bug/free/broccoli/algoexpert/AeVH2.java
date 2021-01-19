package bug.free.broccoli.algoexpert;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class AeVH2 {


    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        List<BinaryTree> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes.get(0);
    }

    public static void traverse(BinaryTree root, List<BinaryTree> acc) {
        if (root == null) return;
        if (root.left != null) traverse(root.left, acc);
        acc.add(root);
        if (root.right != null) traverse(root.right, acc);
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
        System.out.println(flattenBinaryTree(root));
    }

    // This is the class of the input root. Do not edit it.
    @ToString
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
