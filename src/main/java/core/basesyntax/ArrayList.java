package core.basesyntax;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    @Override
    public void add(T value) {
        if (size == elements.length) {
            Object[] newElements = new Object[(int) (elements.length * 1.5)];
        }

        elements[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {

        if (size == elements.length) {
            Object[] newElements = new Object[(int) (elements.length * 1.5)];
            for (int j = 0; j < size; j++) {
                newElements[j] = elements[j];
            }
            elements = newElements;
        }

        if (index >= 0 && index <= size) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];

            }
            elements[index] = value;
            size++;
        }
    }

    @Override
    public void addAll(List<T> list) {

    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        }

        throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public void set(T value, int index) {
        if (index >= 0 && index < size) {
            elements[index] = value;
        }
    }

    @Override
    public T remove(int index) {
        Object savedValue = 0;
        if (index >= 0 && index < size) {
            savedValue = elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            elements[size] = null;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
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
        } else  {
            throw new ArrayIndexOutOfBoundsException("Size: " + size);
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
