package LinkedList;

public class LinkedList {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // add node at the first position
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add node at the last position
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    // print linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    // delete node at first position
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        head = head.next;
    }

    // delete node at last position
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }

        secondLastNode.next = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst("This");
        list.addLast("Is");
        list.deleteFirst();
        list.deleteLast();
        list.printList();
    }
}
