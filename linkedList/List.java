package linkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;
    Node temp;
    void insertAtEnd(int data) {
        Node newnode = new Node(data);
        System.out.println(data + " inserted");
        if(head == null) {
            head = temp = newnode;
        } else {
            temp.next = newnode;
            temp = newnode;
        }
    }

    void insertAtStart(int data) {
        Node newnode = new Node(data);
        System.out.println(data + " inserted at beginning");
        newnode.next = head;
        head = newnode;
    }

    boolean insertAnywhere(int data, int pos) {
        temp = head;
        boolean found = false;
        int count = 1;
        while(temp != null) {
            if(count == pos) {
                Node newnode = new Node(data);
                newnode.next = temp.next;
                temp.next = newnode;
                found = true;
                break;
            }
            temp = temp.next;
            count++;
        }
        return found;
    }

    void display() {
        temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class List {
    public static void main(String [] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(5);
        list.insertAtEnd(10);
        list.insertAtEnd(15);
        list.insertAtStart(1);
        list.insertAtStart(100);
        boolean any = list.insertAnywhere(6, 5);
       if(any) {
            System.out.println("Inserted 6 at position 5");
        } else {
            System.out.println("Invalid position to insert 6 in!");
        }
        list.display();
    }
}
