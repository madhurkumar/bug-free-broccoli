package bug.free.broccoli.algoexpert;

public class SumOfLinkedLists {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        int sum = toValue(linkedListOne) + toValue(linkedListTwo);
        return buildLinkedList(sum);
    }


    private LinkedList buildLinkedList(int value) {
        char[] valueS = String.valueOf(value).toCharArray();
        LinkedList current = null;
        for (char s : valueS) {
            LinkedList l = new LinkedList(Integer.parseInt(String.valueOf(s)));
            l.next = current;
            current = l;
        }
        return current;
    }

    private int toValue(LinkedList linkedList) {
        int pos = 0;
        int value = 0;
        LinkedList tracker = linkedList;
        while (tracker != null) {
            value += tracker.value * (int) Math.pow(10, pos++);
            tracker = tracker.next;
        }
        return value;
    }

    public static void main(String[] args) {
        SumOfLinkedLists s = new SumOfLinkedLists();
        LinkedList l = s.sumOfLinkedLists(s.buildLinkedList(1742), s.buildLinkedList(549));
        System.out.println(s.toValue(l));
    }
}
