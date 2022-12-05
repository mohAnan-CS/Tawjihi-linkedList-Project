package project;

import java.io.File;
import java.util.LinkedList;

public class MyLinkedList {

    private Node first, last;
    private int countIndex = -1;


    //Constructor of MyLinkedList
    public MyLinkedList() {

    }

    /*
    Add method -> when you call this function thats mean you want to add a new data to the link list
    adding operation mean creat a new node , at first the function check the first if null or not
    if first null -> the node will be store in the first node and the node will be also store in the last node
    if first != null -> the new node
    */
    public void add(Student data) {

        Node node = new Node(data);

        if (first == null) {
            first = node;
            last = node;
            countIndex++;
        } else {
            Node newNode = first;
            while (newNode.getNext() != null) {
                newNode = newNode.getNext();
            }
            newNode.setNext(node);
            ;
            last = node;
            countIndex++;
        }

    }

    public void addFirst(Student data) {

        Node node = new Node(data);

        if (first == null) {
            first = node;
            last = node;
        } else {
            node.setNext(first);
            first = node;
        }
    }

    public double getAt(int index) throws IllegalArgumentException {

        int count = -1;
        Node node = new Node();
        node = first;
        while (node.getNext() != null) {
            count++;
            if (count == index) {
                return node.getData().getGrade();
            } else {
                node = node.getNext();
            }
        }
        count++;
        if (count == index) {
            return node.getData().getGrade();
        } else {
            throw new IllegalArgumentException("The index that you insert is not found");
        }

    }

    public Student getFirst() throws IllegalArgumentException {
        if (first != null) {
            return first.getData();
        } else {
            throw new IllegalArgumentException("The link list is empty \n No data in first");
        }
    }

    public Student getLast() {
        if (last != null) {
            return last.getData();
        } else {
            throw new IllegalArgumentException("The link list is empty \n No data in last !!");
        }
    }

    public int size() {
        return countIndex + 1;
    }

    public void deleteLast() {

        Node nextNode = new Node(first.getNext());
        Node prevNode = new Node(first);

        if (first.getNext() == null) {
            first = null;
            last = null;
            countIndex--;
        } else {
            while (nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
                prevNode = prevNode.getNext();
            }
            prevNode.setNext(null);
            last = prevNode;
            countIndex--;
        }
    }

    public void deleteFirst() {

        if (first.getNext() == null) {
            first.setNext(null);
            first = null;
            countIndex--;
        } else {
            first.setNext(first.getNext().getNext());
            //first = first.getNext();
            countIndex--;
        }
    }

    public void deleteAtSeat(long seatNumber) {

        Node nodeNext = first.getNext();
        Node nodePrev = first;

        if (first.getData().getSeatNum() == seatNumber) {
            deleteFirst();
            return;
        } else if (last.getData().getSeatNum() == seatNumber) {
            deleteLast();
            return;
        } else {
            while (nodeNext.getNext() != null) {
                if (seatNumber == nodeNext.getData().getSeatNum()) {
                    nodePrev.setNext(nodePrev.getNext().getNext());
                    countIndex--;
                    return;
                } else {
                    nodePrev = nodeNext;
                    nodeNext = nodeNext.getNext();

                }
            }
        }
    }

    public void display() {

        if (first == null) {
            System.out.println("[]");
        } else {

            Node node = new Node();
            node = first;

            System.out.print("[ ");
            while (node.getNext() != null) {
                System.out.print(node.getData() + " , ");
                node = node.getNext();
            }
            System.out.print(node.getData() + " ]");
            System.out.println();

        }

    }

    public Student search(long seatNumber) {

        Student s1 = new Student(0000, "noBranch", 00);

        if (first == null) {
            return s1;
        }


        Node nodePrev = first;
        Node nodeNext = first.getNext();

        if (first.getData().getSeatNum() == seatNumber) {
            return first.getData();
        } else if (last.getData().getSeatNum() == seatNumber) {
            return last.getData();
        } else {
            while (nodeNext != null) {
                if (seatNumber == nodeNext.getData().getSeatNum()) {
                    return nodeNext.getData();
                } else {
                    nodeNext = nodeNext.getNext();
                }
            }
            return s1;
        }

    }

    public double getAverage() {

        Node node = first;

        if (node == null) {

            return -1;

        } else if (node.getNext() == null) {

            return node.getData().getGrade();

        } else {

            double sum = 0, avg = 0, counter = 0;
            while (node.getNext() != null) {
                counter++;
                sum = sum + node.getData().getGrade();
                node = node.getNext();
            }

            sum = sum + node.getData().getGrade();
            counter++;
            avg = sum / counter;

            return avg;

        }

    }

    public double getMode() {
        Node prev = first;
        Node next = first.getNext();

        add(new Student(0, "", 0));

        int c = 1;
        double grade = 0;
        int i = 0;

        while (next != null) {
            if (prev.getData().getGrade() == next.getData().getGrade()) {
                c++;
                next = next.getNext();
            }
            //90, 80, 55, 55, 55, 40, 30

            else {
                if (c > i) {
                    grade = prev.getData().getGrade();
                    i = c;
                }
                prev = next;
                next = prev.getNext();
                c = 1;
            }
        }

        deleteLast();
        return grade;
    }

    public double getVariance() {
        Node next = first;

        double total = 0;
        double avg = getAverage();

        while (next != null) {
            total = total + Math.pow(next.getData().getGrade() - avg, 2);
            next = next.getNext();
        }

        double variance = total / size();
        return variance;
    }

    public double getStandardDeviation() {
        return Math.sqrt(getVariance());
    }

    public double getMedian() {

        int size = size();
        int num = 0;
        double grade = 0;
        if (size % 2 == 1) {
            num = size / 2;
            grade = getAt(num);
            return grade;
        } else {
            num = size / 2;
            double grade2 = (getAt(num) + getAt(num - 1)) / 2;
            return grade2;
        }


    }

    public String getNumberPercentage(double grade) {

        Node node = first;

        double counterOfAllStudents = 0, counterStudent = 0;
        while (node != null) {
            counterOfAllStudents++;
            if (node.getData().getGrade() >= grade) {
                counterStudent++;
            }
            node = node.getNext();

        }
        counterOfAllStudents++;


        double percentage = 0;
        percentage = (counterStudent / counterOfAllStudents) * 100;
        String value = counterStudent + "\n" + percentage + "%";


        return value;

    }

    public boolean sort(Student data) {

        if (first == null) {
            add(data);
            return true;
        }

        Node newNode = new Node(data);
        Node prev = first;

        if (prev.getData().getGrade() < newNode.getData().getGrade()) {

            addFirst(data);
            return true;
        }

        Node next = first.getNext();

        while (next != null) {

            if (next.getData().getGrade() < newNode.getData().getGrade()) {
                prev.setNext(newNode);
                newNode.setNext(next);
                countIndex++;
                return true;
            } else {
                prev = prev.getNext();
                next = next.getNext();
            }

        }

        if (prev.getData().getGrade() >= newNode.getData().getGrade()) {
            add(data);
            return true;
        } else {
            return false;
        }

    }

    public String topTen() {

        Node node = first;

        String topTen = "";
        int count = 0;

        if (first != null) {

            while (first.getNext() != null && count <= 10) {

                topTen = topTen + first.getData() + "\n";
                first = first.getNext();
                count++;

            }
            while (first.getNext() != null && count == 10) {
                if (first.getData().getGrade() == first.getData().getGrade()) {
                    topTen = topTen + first.getData();
                } else {
                    break;
                }
            }

        }
        return topTen;


    }

}
