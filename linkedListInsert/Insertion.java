package linkedListInsert;


class Node {
    int data;
    Node next;
    // constructor
    public Node(int data) {
        this.data = data;
    }
}

class linkedListOperations {
    Node head;
    public void insertAtEnd(int data) {
        Node newnNode = new Node(data);
        if (head == null) {
            head = newnNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnNode;
        }
    }
    public void insertAtBegining(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }
        prev.next = temp.next;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Insertion {
    public static void main(String [] args) {
        linkedListOperations list = new linkedListOperations();
        System.out.println("Inserting at the begining of the list\n");
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.display();
        System.out.println("\nInserting 10 at the end of the list\n");
        list.insertAtBegining(10);
        list.display();
        System.out.println("\nDeleting 40 from the list\n");
        list.deleteNode(40);
        list.display();
    }
}
