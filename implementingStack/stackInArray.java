package implementingStack;

class stackArray {
    int top = -1;
    int maxSize = 5;
    int[] stack = new int[maxSize];

    void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed");
        }
    }

    void pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--] + " popped");
        }
    }

    void display() {
        for (int i = top; i >= 0; i++) {
            System.out.println(stack[i]);
        }
    }
}




public class stackInArray {
    public static void main(String [] args) {
        stackArray stack = new stackArray();
        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.pop();
        stack.display();
    }
}
