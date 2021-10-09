package ro.micsa.reverse_double_linked_list;

import java.util.Objects;

final class Node<T> {
    private final T value;
    private Node<T> previous;
    private Node<T> next;

    private Node(final T value) {
        this.value = value;
    }

    static <T> Node<T> node(final T value) {
        return new Node<T>(value);
    }

    T value() {
        return value;
    }

    Node<T> previous() {
        return previous;
    }

    Node<T> next() {
        return next;
    }

    private void setPrevious(final Node<T> previous) {
        this.previous = previous;
    }

    void setNext(final Node<T> next) {
        this.next = next;
        next.setPrevious(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Node<?> node = (Node<?>) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
