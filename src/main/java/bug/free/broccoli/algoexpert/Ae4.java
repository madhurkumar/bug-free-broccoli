package bug.free.broccoli.algoexpert;

import java.util.*;
import java.util.stream.Collectors;

public class Ae4 {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
       return accumulate(root, 0);
    }

    private static List<Integer> accumulate(BinaryTree tree, int sum) {
        if (tree.right == null && tree.left == null) return Collections.singletonList(sum + tree.value);
        else {
            List<Integer> results = new ArrayList<>();
            if (tree.left != null) results.addAll(accumulate(tree.left, tree.value + sum));
            if (tree.right != null) results.addAll(accumulate(tree.right, tree.value + sum));
            return results;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = buildTree();
        System.out.println(branchSums(root));
    }

    private static Map<String, String> toNode(String left, String right, String value) {
        Map<String, String> n = new HashMap<>();
        n.put("left", left);
        n.put("right", right);
        n.put("value", value);
        return n;
    }

    private static int getValue(Map<String, String> in) {
        return in.get("value") != null ? Integer.parseInt(in.get("value")) : 0;
    }

    private static void attach(BinaryTree node, Map<String, String> m, Map<String, BinaryTree> nn) {
        String l = m.get("left");
        if (l != null) {
            node.left = nn.get(l);
        }
        String r = m.get("right");
        if (r != null) {
            node.right = nn.get(r);
        }
    }

    private static BinaryTree buildTree() {
        Map<String, Map<String, String>> nodes = new HashMap<>();
        nodes.put("10", toNode("5", "15", "10"));
        nodes.put("15", toNode("13", "22", "15"));
        nodes.put("22", toNode(null, null, "22"));
        nodes.put("13", toNode(null, "14", "13"));
        nodes.put("14", toNode(null, null, "14"));
        nodes.put("5", toNode("2", "5-2", "5"));
        nodes.put("5-2", toNode(null, null, "15"));
        nodes.put("2", toNode("1", null, "2"));
        nodes.put("1", toNode(null, null, "1"));
        Map<String, BinaryTree> nn = nodes.keySet()
                .stream()
                .collect(Collectors.toMap(k -> k, v -> new BinaryTree(getValue(nodes.get(v)))));
        nodes.keySet().forEach(n -> attach(nn.get(n), nodes.get(n), nn));
        return nn.get("10");
    }
}
