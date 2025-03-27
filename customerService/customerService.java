package customerService;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class serveCustomers {
    Node front, rear;

    void addCustomer(String customer) {
        Node newNode = new Node(customer);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(customer + " added");
    }

    void serveCustomer() {
        if (front == null) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(front.data + " removed");
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


public class customerService {
    public static void main(String [] args) {
        serveCustomers customer = new serveCustomers();
        customer.addCustomer("Guy Stephane");
        customer.addCustomer("Akoh Caesia");
        customer.display();
        customer.serveCustomer();
        customer.display();
    }
}
