package bug.free.broccoli.algoexpert;

import java.util.Objects;

public class DLL {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
        }

        public void setTail(Node node) {
            if (tail != null) {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            Node track = head;
            while (track != null) {
                if (track.equals(node)) break;
                track = track.next;
            }
            if (track != null) {
                nodeToInsert.next = track;
                track.prev = nodeToInsert;
                if (head.value == track.value) head = nodeToInsert;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            Node track = head;
            while (track != null) {
                if (track.equals(node)) break;
                track = track.next;
            }
            if (track != null) {
                nodeToInsert.prev = track;
                track.next = nodeToInsert;
                if (tail.value == track.value) tail = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            Node track = head;
            int i = 1;
            while (track != null && i < position) {
                track = track.next;
                i++;
            }
            if (i == position) {
                if (position == 1) head = nodeToInsert;
                nodeToInsert.next = track;
                track.prev = nodeToInsert;
            }
            if (position == i + 1) {
                tail.next = nodeToInsert;
                nodeToInsert.prev = tail;
                tail = nodeToInsert;
            }
        }

        public void removeNodesWithValue(int value) {
            Node track = head;
            while (track != null) {
                if (track.value == value) break;
                track = track.next;
            }
            if (track != null && track.equals(head)) {
                head = head.next;
            }
            if (track != null && track.equals(tail)) {
                tail = tail.prev;
            }
            if (track != null) {
                if (track.prev != null) track.prev.next = track.next;
                if (track.next != null) track.next.prev = track.prev;
            }
        }

        public void remove(Node node) {
            Node track = head;
            while (track != null) {
                if (track.equals(node)) break;
                track = track.next;
            }
            if (track != null && track.equals(head)) {
                head = head.next;
            }
            if (track != null && track.equals(tail)) {
                tail = tail.prev;
            }
            if (track != null) {
                if (track.prev != null) track.prev.next = track.next;
                if (track.next != null) track.next.prev = track.prev;
            }
        }

        public boolean containsNodeWithValue(int value) {
            Node track = head;
            while (track != null) {
                if (track.value == value) return true;
                track = track.next;
            }
            return false;
        }

        @Override
        public String toString() {
            Node track = head;
            StringBuilder sb = new StringBuilder();
            while (track != null) {
                sb.append("->").append(track).append("->");
                track = track.next;
            }
            return sb.toString();
        }
    }

    // Do not edit the class below.

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(prev, node.prev) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, prev, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.setHead(new Node(5));
        dll.setHead(new Node(4));
        dll.setHead(new Node(3));
        dll.setHead(new Node(2));
        dll.setHead(new Node(1));
        dll.setHead(new Node(4));
        dll.setTail(new Node(6));
        dll.insertBefore(new Node(6), new Node(3));
        dll.insertAfter(new Node(6), new Node(3));
        dll.insertAtPosition(1, new Node(3));
        dll.removeNodesWithValue(3);
        dll.remove(new Node(2));
        dll.containsNodeWithValue(5);
        System.out.println(dll);
    }
}
