package bug.free.broccoli.algoexpert;

import lombok.ToString;

public class MergeSortedLinkedList {

    @ToString(exclude = "next")
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList tracker = null;
        LinkedList head = null;
        while (headOne != null && headTwo != null) {
            if (headOne.value < headTwo.value) {
                if (tracker == null) tracker = headOne;
                else {
                    LinkedList cNext = tracker.next;
                    LinkedList tNext = headOne.next;
                    tracker.next = headOne;
                    headOne.next = cNext;
                    tracker = headOne;
                    headOne = tNext;
                }
            } else {
                if (tracker == null) tracker = headTwo;
                else {
                    LinkedList cNext = tracker.next;
                    LinkedList tNext = headTwo.next;
                    tracker.next = headTwo;
                    headTwo.next = cNext;
                    tracker = headTwo;
                    headTwo = tNext;
                }
            }
            if (head == null) head = tracker;
        }
        if (headOne == null && headTwo != null && tracker != null) tracker.next = headTwo;
        if (headTwo == null && headOne != null && tracker != null) tracker.next = headOne;
        return head;
    }

    private static LinkedList buildLinkedList(String value) {
        String[] valueS = value.split(",");
        LinkedList current = null;
        LinkedList head = null;
        for (String s : valueS) {
            LinkedList l = new LinkedList(Integer.parseInt(s));
            if (head == null) head = l;
            if (current != null)
                current.next = l;
            current = l;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList head = mergeLinkedLists(buildLinkedList("1,3,4,5,9,10"), buildLinkedList("2,6,7,8"));
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
