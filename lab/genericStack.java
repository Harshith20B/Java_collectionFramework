import java.util.ArrayList;
import java.util.List;
class Stack<T> {
    List<T> elements = new ArrayList<>();
    final int maxSize;
    Stack(int maxSize) {
        this.maxSize = maxSize;
    }
    void push(T element) {
        if (elements.size() < maxSize) {
            elements.add(element);
        }
    }
    T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }
    T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }
    void clear() {
        elements.clear();
    }
    boolean isFull() {
        return elements.size() >= maxSize;
    }
    void display() {
        if (elements.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack contents: " + elements);
        }
    }
}
public class genericStack {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>(2);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.display(); // Output: Stack contents: [Hello, World]
        // Attempt to push another element (won't be added since stack is full)
        stringStack.push("Overflow");
        System.out.println("Peeked element: " + stringStack.peek()); // Output: Peeked element:World
        System.out.println("Popped element: " + stringStack.pop()); // Output: Popped element:World
        stringStack.display(); // Output: Stack contents: [Hello]
        // Stack of Integers with a maximum size of 3
        Stack<Integer> integerStack = new Stack<>(3);
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.display(); // Output: Stack contents: [1, 2, 3]
        // Attempt to push another element (won't be added since stack is full)
        integerStack.push(4);
        System.out.println("Peeked element: " + integerStack.peek()); // Output: Peeked element: 3
        System.out.println("Popped element: " + integerStack.pop()); // Output: Popped element: 3
        integerStack.display(); // Output: Stack contents: [1, 2]
        integerStack.clear();
        integerStack.display(); // Output: Stack is empty
    }
}