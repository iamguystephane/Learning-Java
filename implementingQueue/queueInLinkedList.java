package implementingQueue;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class queueLinkedList {
    Node front, rear;

    void enqueue(int value) {
        Node newNode = new Node(value);
        if(rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(front.data + " dequeued");
            front = front.next;
            if (front == null) rear = null;
        }
    }

    void display() {
        Node temp = front;
        while(temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}


public class queueInLinkedList {
    public static void main(String [] args) {
        queueLinkedList queueList = new queueLinkedList();
        queueList.enqueue(5);
        queueList.enqueue(15);
        queueList.enqueue(25);
        queueList.display();
        queueList.dequeue();
        queueList.dequeue();
        queueList.display();
    }
}
