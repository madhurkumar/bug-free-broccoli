package bug.free.broccoli.algoexpert;

import lombok.ToString;

public class ReverseALinkedList {

    public static LinkedList reverseLinkedList(LinkedList head) {
        return reverse(head);
    }

    private static LinkedList reverse(LinkedList head) {
        LinkedList tracker = head;
        LinkedList previous = null;
        while (tracker != null) {
            LinkedList next = tracker.next;
            tracker.next = previous;
            previous = tracker;
            tracker = next;
        }
        return previous;
    }

    @ToString
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    private static LinkedList buildLinkedList(String value) {
        char[] valueS = value.toCharArray();
        LinkedList current = null;
        LinkedList head = null;
        for (char s : valueS) {
            LinkedList l = new LinkedList(Integer.parseInt(String.valueOf(s)));
            if (head == null) head = l;
            if (current != null)
                current.next = l;
            current = l;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(reverseLinkedList(buildLinkedList("012345")));
    }
}
