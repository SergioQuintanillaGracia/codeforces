import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        list.add(3);
        list.add(2);
        list.add(5);

        list.removeFirst();
        list.addFirst(17);

        list.print();
    }
}


class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}


class SimpleLinkedList {
    private int length = 0;
    private Node tail = null;
    private Node head = null;

    public void add(int data) {
        length++;

        if (head == null) {
            head = new Node(data, null, null);
            tail = head;
        
        } else {
            Node newHead = new Node(data, tail, null);
            tail.next = newHead;
            tail = newHead;
        }
    }

    private Node getNodeAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
        }

        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node currNode = head;

        while (--index >= 0) {
            currNode = currNode.next;
        }

        return currNode;
    }

    public int getLength() {
        return length;
    }

    public int get(int index) {
        return getNodeAt(index).data;
    }

    public void set(int index, int data) {
        getNodeAt(index).data = data;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data, null, head);
        
        if (head != null) {
            head.prev = newNode;
            head = newNode;
        
        } else {
            add(data);
        }

        length++;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            
            } else {
                tail = null;
            }
        }

        length--;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    public void print() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }
}