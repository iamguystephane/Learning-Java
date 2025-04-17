package doublyLinkedList;

class Node {
    int data;
    Node next, prev;
    // constructor
    public Node(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class doubleLinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head  = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void delete(int data) {
        //deleting a node.
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) return;   //element not found.
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.prev != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}


public class doublyLinkedList {
    public static void main(String [] args) {
        doubleLinkedList list = new doubleLinkedList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        list.delete(20);
        System.out.println("\n");
        list.display();
    }
}
