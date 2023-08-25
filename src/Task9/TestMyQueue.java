package Task9;

import java.util.StringJoiner;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue<Integer> mq1 = new MyQueue<>();
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            mq1.add(i);
        }
        System.out.println(mq1);
        System.out.println("Размер: "+mq1.size());
        System.out.println("\n");
        while (!mq1.isEmpty()){
            System.out.println(mq1.peek());
            System.out.println(mq1.poll());
        }
        System.out.println("Размер: "+mq1.size());

    }
}


class MyQueue<E> {
    private Node<E> first;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        Node<E> currNode = first;
        if (isEmpty()) {
            first = newNode;
        } else {
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        size++;
    }

    public E poll() {
        if (first != null) {
            E result = first.element;
            first = first.next;
            size--;
            return result;
        } else {
            throw new NullPointerException("Пустая очередь");
        }
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return first.element;
    }

    public boolean isEmpty() {
        return first == null;
    }
    @Override
    public String toString() {
        Node<E> current = first;
        if(isEmpty()){
            return "EmptyList";
        }
        StringJoiner result = new StringJoiner(", ");
        if(first!=null){
            result.add(first.toString());
        }
        while(current.next!=null){
            current=current.next;
            result.add(current.toString());
        }
        String result1 = String.valueOf(result);
        return result1;
    }
}
