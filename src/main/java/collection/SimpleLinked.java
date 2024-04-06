package collection;

import java.util.Iterator;

public interface SimpleLinked<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
