package Task9;

import java.util.Objects;
import java.util.StringJoiner;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> mq1 = new MyStack<>();
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            mq1.push(i);
        }
        System.out.println("Размер: "+mq1.size());
        mq1.remove(0);
        System.out.println(mq1);
        System.out.println("Размер: "+mq1.size());
        int length= mq1.size();
        for (int i = 0; i < length; i++) {
            System.out.println(mq1.pop());
        }
        System.out.println(mq1);
        System.out.println("Размер: "+mq1.size());
    }

}

class MyStack<E> {
    private Node<E> first;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public E pop() {
        E removedElement = first.element;
        first = first.next;
        size--;
        return removedElement;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        if (index == 0) {
            first = first.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E peek() {
        return first.element;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public String toString() {
        Node<E> current = first;
        if (isEmpty()) {
            return "EmptyList";
        }
        StringJoiner result = new StringJoiner(", ");
        if (first != null) {
            result.add(first.toString());
        }
        while (current.next != null) {
            current = current.next;
            result.add(current.toString());
        }
        String result1 = String.valueOf(result);
        return result1;
    }
}

