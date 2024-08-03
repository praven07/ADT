import java.util.EmptyStackException;

public class Queue<T> {

    private Node front;

    private Node back;

    private int size;

    public Queue() {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(T item) {

        Node node = new Node(item, null);

        if (back != null) {
            back.next = node;
        }

        back = node;

        if (front == null) {
            front = node;
        }

        size++;
    }

    public T dequeue() {

        if (front == null) {
            throw new EmptyStackException();
        }

        Node node = front;

        front = node.next;

        if (front == null) {
            back = null;
        }

        size--;

        return node.item;
    }

    public T peek() {
        if (front == null) {
            throw new EmptyStackException();
        }

        return front.item;
    }

    public int size() {
        return size;
    }

    private class Node {

        public T item;

        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
