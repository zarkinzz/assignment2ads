# assignment-2-ADS

# Custom Data Structures in Java

This project contains custom implementations of basic data structures in Java without using java.util.* (except Iterator), as part of the Algorithms and Data Structures course at AITU.

---

## Structure

- MyList<T> – Interface defining core list methods (add, remove, get, etc.)
- MyArrayList<T> – Array-based list implementation
- MyLinkedList<T> – Doubly linked list implementation
- MyStack<T> – Stack implementation (LIFO) based on MyArrayList
- MyQueue<T> – Queue implementation (FIFO) based on MyLinkedList
- MyMinHeap<T> – Min-heap implementation based on MyArrayList

---

## Features

- No use of java.util.* collections
- Implements all basic list operations
- Each logical data structure (Stack, Queue, MinHeap) is based on the most suitable physical structure
- Full sorting and traversal support
- Simple iterator implemented manually

---

## Testing

All components are tested in MainTest.java using simple assertions:
```java
assert heap.peekMin() == 10;
assert heap.extractMin() == 10;
assert heap.size() == 2;


Run the project:
MainTest.java → Run
