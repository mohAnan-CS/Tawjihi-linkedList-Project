package project;

public class Node {

    private Node next;
    private Student data;

    public Node() {

    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Student data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Student data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }
}
