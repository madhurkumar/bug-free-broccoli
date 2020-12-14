package bug.free.broccoli;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class LinkedListFactory {

    public static void main(String[] args) {
        LinkedList<Integer> testList = create();
        testList.addFirst(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.addLast(8);
        testList.addAfter(15, 5);
        testList.addBefore(12, 2);
        testList.remove(12);
        ((SimpleLinkedList<Integer>) testList).print();
    }

    public static <T> LinkedList<T> create() {
        return new SimpleLinkedList<>();
    }
}

interface LinkedList<T> {

    void addFirst(T data);

    void addLast(T data);

    void add(T data);

    void addBefore(T data, T item);

    void addAfter(T data, T item);

    T remove(T data);
}

@RequiredArgsConstructor(staticName = "of")
@Setter
@Getter
class Node<T> {
    private final T data;
    private Node<T> previous;
    private Node<T> next;
}

class SimpleLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private Node<T> add(T data, Node<T> before, Node<T> after) {
        final Node<T> newNode = Node.of(data);
        newNode.setPrevious(before);
        newNode.setNext(after);
        if (before != null) before.setNext(newNode);
        if (after != null) after.setPrevious(newNode);
        return newNode;
    }

    private void headNTail(Node<T> node) {
        if (node.getPrevious() == null) head = node;
        if (node.getNext() == null) tail = node;
    }

    @Override
    public void addFirst(T data) {
        headNTail(add(data, null, head));
    }


    @Override
    public void addLast(T data) {
        headNTail(add(data, tail, null));
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void addBefore(T data, T item) {
        Node<T> tracker = head;
        while (tracker != null) {
            if (item.equals(tracker.getData())) {
                headNTail(add(data, tracker.getPrevious(), tracker));
            }
            tracker = tracker.getNext();
        }
    }

    @Override
    public void addAfter(T data, T item) {
        Node<T> tracker = head;
        while (tracker != null) {
            if (item.equals(tracker.getData())) {
                headNTail(add(data, tracker, tracker.getNext()));
            }
            tracker = tracker.getNext();
        }
    }

    @Override
    public T remove(T data) {
        Node<T> tracker = head;
        while (tracker != null) {
            if (data.equals(tracker.getData())) {
                tracker.getPrevious().setNext(tracker.getNext());
                headNTail(tracker.getPrevious());
                tracker.getNext().setPrevious(tracker.getPrevious());
                headNTail(tracker.getNext());
                return tracker.getData();
            }
            tracker = tracker.getNext();
        }
        return null;
    }

    public void print() {
        Node<T> tracker = head;
        System.out.println("head->");
        while (tracker != null) {
            System.out.println(tracker.getData());
            tracker = tracker.getNext();
        }
        System.out.println("->tail");
    }

}


