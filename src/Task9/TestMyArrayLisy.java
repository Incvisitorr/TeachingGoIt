package Task9;

import java.util.Objects;
import java.util.StringJoiner;

public class TestMyArrayLisy {
    public static void main(String[] args) {
        MyArrayList<String> ml = new MyArrayList();
        ml.add("1");
        ml.add("2");
        ml.add("3");
        ml.add("4");
        ml.add("5");
        System.out.println(ml);
        System.out.println(ml.size());
        ml.remove(4);
        System.out.println(ml);
        System.out.println(ml.get(2));
        ml.clear();
        System.out.println(ml);
    }
}

class MyArrayList<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initCap) {
        if (initCap <= 0) {
            throw new IllegalArgumentException();
        }
        if (initCap == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }
        elementData = new Object[initCap];
    }

    public void add(E e) {
        grow();
        elementData[size] = e;
        size = size + 1;
    }

    private void grow() {
        if (elementData.length == size) {
            Object[] newArray = new Object[elementData.length * 3];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        @SuppressWarnings("unchecked") E removedEl = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        size--;
        return removedEl;
    }

    public void clear() {
        size = 0;
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(elementData[i].toString());
        }
        String result1 = String.valueOf(result);
        return "[ " + result1 + " ]";
    }

}
