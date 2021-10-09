package ro.micsa.reverse_double_linked_list;

import java.util.ArrayList;
import java.util.List;

import static ro.micsa.reverse_double_linked_list.Node.node;

public class DoubleLinkedList<T> {
    private Node<T> root;

    public DoubleLinkedList() {
    }

    @SafeVarargs
    public DoubleLinkedList(final T... values) {
        Node<T> currentNode = null;
        for (T value : values) {
            final Node<T> newNode = node(value);
            if (currentNode == null) {
                currentNode = newNode;
                root = currentNode;
            } else {
                currentNode.setNext(newNode);
                currentNode = newNode;
            }
        }
    }

    private DoubleLinkedList(final Node<T> root) {
        this.root = root;
    }

    public List<T> values() {
        final List<T> values = new ArrayList<>();
        Node<T> node = root;
        while (node != null) {
            values.add(node.value());
            node = node.next();
        }
        return values;
    }

    public DoubleLinkedList<T> reverse() {
        Node<T> lastNode = lastNode();
        if (lastNode == null) {
            return new DoubleLinkedList<>();
        }
        Node<T> currentNode = node(lastNode.value());
        final Node<T> root = currentNode;

        while (lastNode.previous() != null) {
            final Node<T> previous = lastNode.previous();
            final Node<T> newNode = node(previous.value());
            currentNode.setNext(newNode);
            lastNode = previous;
            currentNode = newNode;
        }

        return new DoubleLinkedList<>(root);
    }

    private Node<T> lastNode() {
        if (root == null) {
            return null;
        }
        Node<T> node = root;
        while (node.next() != null) {
            node = node.next();
        }
        return node;
    }
}
