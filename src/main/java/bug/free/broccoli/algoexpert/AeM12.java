package bug.free.broccoli.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AeM12 {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(this);
            traverse(nodes, array);
            return array;
        }

        private void traverse(Queue<Node> nodes, List<String> array) {
            if (nodes.isEmpty()) return;
            Node n = nodes.remove();
            array.add(n.name);
            nodes.addAll(n.children);
            traverse(nodes, array);
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
