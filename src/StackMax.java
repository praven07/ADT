
public class StackMax {

    private static final int INITIAL_CAPACITY = 10;

    private int[] stack;

    private int size;

    private int[] max;

    private int maxSize;

    public StackMax() {
        stack = new int[INITIAL_CAPACITY];
        max = new int[INITIAL_CAPACITY];
        size = 0;
        maxSize = 0;
    }


    public void push(int item) {

        if (size == stack.length) {
            resizeStack();
        }

        if (maxSize == max.length) {
            resizeMax();
        }

        if (size == 0 || item >= max()) {
            max[maxSize++] = item;
        }

        stack[size++] = item;
    }

    public int pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }

        int item = stack[--size];

        if (item == max[maxSize - 1]) {
            maxSize--;
        }

        return item;
    }

    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }

        return stack[size - 1];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int max() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }

        return max[maxSize - 1];
    }

    private void resizeStack() {

        int[] newStack = new int[size * 2];

        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    private void resizeMax() {

        int[] newMax = new int[maxSize * 2];

        for (int i = 0; i < maxSize; i++) {
            newMax[i] = max[i];
        }

        max = newMax;
    }
}
