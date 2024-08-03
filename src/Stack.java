import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first = null;

    private int size = 0;

    public void push(T item) {

        first = new Node(item, first);
        size++;
    }

    public T pop() {

        validate();

        Node node = first;

        first = node.next;

        size--;

        return node.item;
    }

    public T peek() {
        validate();

        return first.item;
    }

    public int size() {
        return size;
    }

    private void validate() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        public T item;

        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class StackIterator implements Iterator<T> {

        private Node pointer;

        public StackIterator() {
            pointer = first;
        }

        @Override
        public boolean hasNext() {

            return pointer != null;
        }

        @Override
        public T next() {
            Node node = pointer;

            pointer = node.next;

            return node.item;
        }
    }
}
