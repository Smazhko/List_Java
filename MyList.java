package ru.gb.lesson3;
//Реализовать следующие методы в классе MyLinkedList, реализованном на уроке
//        1. public int size() - получить размер списка
//        2. public boolean contains(int value) - проверить наличие элемента в списке
//        3.* public MyLinkedList reversed() - создать НОВЫЙ список с обратным порядком
//        4.** Заменить все int значения на дженерик T
//        5.* Любые другие доработки, которые захотите для тренировки
public class MyList {
    Node head;
    Node tail;

    public static class Node {
        int value;
        Node previous;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public void addHead(int value){
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void addTail(int value){
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer find(int value) {
        Node currentNode = head;
        int index = 0;

        if (head == null) {
            return null;
        }

        while (currentNode != null) {
            if (currentNode.value == value) {
                return index;
            }
            currentNode = currentNode.next;
            index +=1;
        }
        return null;
    }

    public boolean contains(int value) {
        Node currentNode = head;
        int index = 0;

        if (head == null) {
            return false;
        }

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public Integer size(){
        int listSize = 0;
        Node currentNode = head;

        if (head == null){
            return null;
        }

        while (currentNode != null){
            listSize += 1;
            currentNode = currentNode.next;
        }

        return listSize;
    }

    public Node get(int index){
        Node currentNode = head;
        int currentIndex = 0;

        if (head == null || index > size()){
            throw new IndexOutOfBoundsException(index);
        }

        while (currentIndex < index){
            currentNode = currentNode.next;
            currentIndex +=1;
        }
        return currentNode;
    }

    public void add(int index, int value){
        Node newNode = new Node(value);
        Node currentNode = get(index);
        if (currentNode != null) {

            newNode.previous = currentNode;
            newNode.next = currentNode.next;


            currentNode.next.previous = newNode;
            currentNode.next = newNode;
        }
        else {
            System.out.println(", вставка не удалась.");
        }
    }

    public Integer delete(int index){
        if (head == null || index > size()){
            return null;
        }

        Node currentNode = get(index);

        if (index == 0)
        {
            head.next.previous = null;
            head = head.next;

        } else if (index == size() - 1){
            tail.previous.next = null;
            tail = tail.previous;
        } else {
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        }

        return currentNode.value;
    }

    public MyList reversed(){
        MyList newList = new MyList();

        if(head != null){
            newList.head = new Node(head.value) ;
            newList.tail = newList.head;

            Node currentNode = head.next;
            while(currentNode != null){
                Node newNode = new Node(currentNode.value);

                newNode.next = newList.head;
                newList.head.previous = newNode;
                newList.head = newNode;

                currentNode = currentNode.next;
            }
        }
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }

}



