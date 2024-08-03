public class ArrayStack<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] stack;

    private int size;

    public ArrayStack() {
        stack = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(T item) {

        if (stack.length == size) {
            resize();
        }

        stack[size++] = item;
    }

    public T pop() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        T item = stack[--size];
        stack[size] = null;

        return item;
    }

    public T peek() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        return stack[size - 1];
    }

    public int size() {
        return size;
    }

    private void resize() {

        T[] newStack = (T[]) new Object[size * 2];

        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }
}
