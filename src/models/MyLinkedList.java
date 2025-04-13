package models;

import interfaces.MyList;

public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E data;
        MyNode next;
        MyNode prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(E item) {
        addLast(item);
    }

    @Override
    public void addFirst(E item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            MyNode prev = current.prev;

            newNode.next = current;
            newNode.prev = prev;
            prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void set(int index, E item) {
        getNode(index).data = item;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E getFirst() {
        if (head == null) throw new IllegalStateException();
        return head.data;
    }

    @Override
    public E getLast() {
        if (tail == null) throw new IllegalStateException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        removeNode(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException();
        removeNode(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException();
        removeNode(tail);
    }

    private void removeNode(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    @Override
    public void sort() {
        // Simple bubble sort (not efficient but shows concept)
        if (size <= 1) return;

        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current.next != null) {
                Comparable<E> a = (Comparable<E>) current.data;
                E b = current.next.data;
                if (a.compareTo(b) > 0) {
                    E temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode current = head; current != null; current = current.next, index++) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data)))
                return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode current = tail; current != null; current = current.prev, index--) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data)))
                return index;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (MyNode current = head; current != null; current = current.next) {
            arr[i++] = current.data;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

