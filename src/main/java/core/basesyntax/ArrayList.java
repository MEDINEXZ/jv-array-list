package core.basesyntax;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void grow() {
        if (size == elements.length) {
            Object[] newElements =
                    new Object[(int) (elements.length * 1.5)];

            System.arraycopy(elements, 0, newElements, 0, size);

            elements = newElements;
        }
    }

    @Override
    public void add(T value) {
        grow();

        elements[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkPositionIndex(index);
        grow();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        int orginalSize = list.size();
        for (int i = 0; i < orginalSize; i++) {
            add(list.get(i));

        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        elements[index] = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        Object savedValue = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        elements[size] = null;

        return (T) savedValue;
    }

    @Override
    public T remove(T element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    Object savedValue = elements[i];

                    for (int j = i; j < size - 1; j++) {
                        elements[j] = elements[j + 1];
                    }

                    size--;
                    elements[size] = null;

                    return (T) savedValue;
                }
            }
        } else {
            throw new NoSuchElementException("Element is null");
        }

        throw new NoSuchElementException("Element not found: " + element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
