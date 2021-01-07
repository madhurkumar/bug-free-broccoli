package bug.free.broccoli.algoexpert;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ae3 {
    public static int findClosestValueInBst(BST tree, int target) {
        return traverse(tree, target, null);
    }

    private static int traverse(BST tree, int target, BST nearest) {
        if (tree == null) return nearest != null ? nearest.value : -1;
        if (nearest == null) nearest = tree;
        else {
            int nearDiff = nearest.value > target ? nearest.value - target : target - nearest.value;
            int newDiff = tree.value > target ? tree.value - target : target - tree.value;
            if (newDiff < nearDiff) nearest = tree;
        }
        return traverse(tree.value > target ? tree.left : tree.right, target, nearest);
    }

    public static void main(String[] args) {
        System.out.println(findClosestValueInBst(buildTree(), 12));
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

    private static void attach(BST node, Map<String, String> m, Map<String, BST> nn) {
        String l = m.get("left");
        if (l != null) {
            node.left = nn.get(l);
        }
        String r = m.get("right");
        if (r != null) {
            node.right = nn.get(r);
        }
    }

    private static BST buildTree() {
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
        Map<String, BST> nn = nodes.keySet()
                .stream()
                .collect(Collectors.toMap(k -> k, v -> new BST(getValue(nodes.get(v)))));
        nodes.keySet().forEach(n -> attach(nn.get(n), nodes.get(n), nn));
        return nn.get("10");
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
