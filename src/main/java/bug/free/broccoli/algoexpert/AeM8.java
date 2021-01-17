package bug.free.broccoli.algoexpert;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class AeM8 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        List<Integer> nodes = new ArrayList<>();
        inOrder(tree, nodes);
        int index = nodes.indexOf(node.value);
        return index != -1 && index + 1 < nodes.size() ?
                new BinaryTree(nodes.get(nodes.indexOf(node.value) + 1)) : null;
    }

    private void inOrder(BinaryTree tree, List<Integer> nodes) {
        if (tree != null) {
            if (tree.left != null) inOrder(tree.left, nodes);
            nodes.add(tree.value);
            if (tree.right != null) inOrder(tree.right, nodes);
        }
    }

    public static void main(String[] args) {
        AeM8 aeM8 = new AeM8();
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.left.left.left = new BinaryTree(6);
        System.out.println(aeM8.findSuccessor(binaryTree, new BinaryTree(5)).value);
    }

}
