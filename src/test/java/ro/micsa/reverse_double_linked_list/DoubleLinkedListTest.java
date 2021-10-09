package ro.micsa.reverse_double_linked_list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoubleLinkedListTest {

    @Test
    void empty() {
        assertThat(new DoubleLinkedList<>().values()).isEmpty();
    }

    @Test
    void oneNode() {
        assertThat(new DoubleLinkedList<>("test").values()).containsOnly("test");
    }

    @Test
    void multipleNodes() {
        assertThat(new DoubleLinkedList<>(2, 3, 1).values()).containsExactly(2, 3, 1);
    }

    @Test
    void reverseEmpty() {
        assertThat(new DoubleLinkedList<>().reverse().values()).isEmpty();
    }

    @Test
    void reverseOne() {
        assertThat(new DoubleLinkedList<>(3).reverse().values()).containsOnly(3);
    }

    @Test
    void reverseTwoNodes() {
        assertThat(new DoubleLinkedList<>(2, 3).reverse().values()).containsExactly(3, 2);
    }

    @Test
    void reverseMultipleNodes() {
        assertThat(new DoubleLinkedList<>("r", "a", "l", "l", "y").reverse().values()).containsExactly("y", "l", "l", "a", "r");
    }
}
