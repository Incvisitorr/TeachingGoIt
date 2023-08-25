package Task9;

import java.util.Objects;
import java.util.StringJoiner;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList();
        mll.add("asedfg");
        mll.add("11111");
        mll.add("2222");
        mll.add("3333");
        mll.add("4444");
        mll.add("5555");
        System.out.println(mll);
        mll.remove(1);
        System.out.println(mll);
        System.out.println(mll.get(3));
        System.out.println(mll.size);
        mll.clear();
        System.out.println(mll);
        mll.add("33433");
        System.out.println(mll);
    }
}

    class MyLinkedList<E>{
        Node<E> first;
        Node<E> last;
        int size;

        public MyLinkedList() {
        }

        private static class Node<E> {
            E element;
            Node<E> next;
            Node<E> prev;

            Node(E element) {
                this.element = element;
                this.next = next;
                this.prev = prev;
            }

            @Override
            public String toString() {
                return element.toString();
            }
        }

        public void add(E element) {
            Node<E> newNode = new Node<>(element);
            if (isEmpty()) {
                first = last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        public E remove(int index) {
            Objects.checkIndex(index, size);
            E removedElement;
            if (index == 0) {
                removedElement = first.element;
                first = first.next;
                if (first == null) {
                    last = null;
                }
            } else {
                Node<E> prev = getNodeByIndex(index - 1);
                removedElement = prev.next.element;
                prev.next = prev.next.next;
                if (index == size - 1) {
                    last = prev;
                }
            }
            size--;
            return removedElement;
        }


        private Node<E> getNodeByIndex(int index) {
            Objects.checkIndex(index, size);
            Node<E> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        public void clear() {
            first = last = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public E get(int index) {
            return getNodeByIndex(index).element;
        }

        public void print() {
           Node<E> curr=first;
           if(first!=null){
               System.out.println(first.element);
           }
           while (curr.element!=null){
               curr=curr.next;
               System.out.println(curr);
           }
        }
        public boolean isEmpty(){
            return first==null;
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




