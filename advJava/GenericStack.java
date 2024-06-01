package advJava;
import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> stack; // ArrayList to store stack elements
    private int maxSize;        // Maximum size of the stack

    // Constructor for the GenericStack class with a specified maximum size
    public GenericStack(int maxSize) {
        this.stack = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    // Method to push an element onto the stack
    public void push(T data) {
        if (stack.size() >= maxSize) {
            throw new IllegalStateException("Stack is full");
        }
        stack.add(data);
    }

    // Method to pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    // Method to peek at the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Method to get the size of the stack
    public int getSize() {
        return stack.size();
    }

    // Main method for testing
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 3
        System.out.println("Stack size is: " + stack.getSize()); // Output: Stack size is: 3

        try {
            stack.push(4); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Output: Stack is full
        }

        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 3
        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 2

        System.out.println("Stack size is: " + stack.getSize()); // Output: Stack size is: 1
    }
}
