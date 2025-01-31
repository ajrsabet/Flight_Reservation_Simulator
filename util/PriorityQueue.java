package util;

public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> front;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public PriorityQueue() {
        this.front = null;
        this.size = 0;
    }

    // Enqueue method to add elements to the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null || front.data.compareTo(data) > 0) {
            newNode.next = front;
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.next != null && current.next.data.compareTo(data) <= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Dequeue method to remove elements from the queue
    public T dequeue() {
        if (front == null) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }

    // Peek method to get the front element of the queue
    public T peek() {
        if (front == null) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }
}