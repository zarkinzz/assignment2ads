import models.*;

public class MainTest {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(1, 15);
        arrayList.set(0, 5);
        assert arrayList.get(0) == 5;
        assert arrayList.get(1) == 15;
        assert arrayList.size() == 3;
        arrayList.removeFirst();
        assert arrayList.get(0) == 15;
        arrayList.clear();
        assert arrayList.size() == 0;

        //Test MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("A");
        linkedList.addLast("B");
        linkedList.addFirst("Start");
        assert linkedList.getFirst().equals("Start");
        assert linkedList.getLast().equals("B");
        linkedList.remove(1); // remove "A"
        assert linkedList.get(1).equals("B");
        linkedList.clear();
        assert linkedList.size() == 0;

        //Test MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        assert stack.peek() == 200;
        assert stack.pop() == 200;
        assert stack.size() == 1;

        //Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("X");
        queue.enqueue("Y");
        assert queue.peek().equals("X");
        assert queue.dequeue().equals("X");
        assert queue.size() == 1;

        //Test MyMinHeap
        MyMinHeap heap = new MyMinHeap();
        heap.insert(30);
        heap.insert(10);
        heap.insert(20);
        assert heap.peekMin() == 10;
        assert heap.extractMin() == 10;
        assert heap.size() == 2;

        System.out.println("All tests passed.");
    }
}
