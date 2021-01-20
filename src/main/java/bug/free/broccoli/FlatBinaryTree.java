package bug.free.broccoli;

public class FlatBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public void flatten(Node node) {
            if (node == null)
                return;
            if (node.left == null &&
                    node.right == null)
                return;
            if (node.left != null) {
                flatten(node.left);
                Node tempNode = node.right;
                node.right = node.left;
                node.left = null;
                Node curr = node.right;
                while (curr.right != null) {
                    curr = curr.right;
                }
                curr.right = tempNode;
            }
            flatten(node.right);
        }

        public void inOrder(Node node) {
            if (node == null)
                return;
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(8);
        tree.root.right.left = new Node(6);
        tree.flatten(tree.root);
        tree.inOrder(tree.root);
    }

}
