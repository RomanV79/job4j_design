package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleLinked<E> {

    private int size;
    private int modCount;
    private Node<E> head;

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node<>(value, null);
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> nessesary = head;
        for (int i = 0; i < index; i++) {
            nessesary = nessesary.next;
        }
        return nessesary.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> next = head;
            private Node<E> current;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = next;
                next = next.next;
                return current.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
