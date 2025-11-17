import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SimpleLinkedListTest {

    @Test
    @DisplayName("A new list is empty with size zero")
    public void aNewListIsEmpty() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create list from array sets correct size")
    public void canCreateFromArray() {
        Character[] values = new Character[]{'1', '2', '3'};
        SimpleLinkedList<Character> list = new SimpleLinkedList<Character>(values);
        assertThat(list.size()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Popping an empty list throws NoSuchElementException")
    public void popOnEmptyListWillThrow() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(list::pop);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Pop returns last added element (LIFO)")
    public void popReturnsLastAddedElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.push(9);
        list.push(8);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(8);
        assertThat(list.pop()).isEqualTo(9);
        assertThat(list.size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reverse reverses the list order")
    public void reverseReversesList() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.push("9");
        list.push("8");
        list.push("7");
        list.push("6");
        list.push("5");
        list.reverse();
        assertThat(list.pop()).isEqualTo("9");
        assertThat(list.pop()).isEqualTo("8");
        assertThat(list.pop()).isEqualTo("7");
        assertThat(list.pop()).isEqualTo("6");
        assertThat(list.pop()).isEqualTo("5");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Convert list to array returns correct element order")
    public void canReturnListAsArray() {
        SimpleLinkedList<Character> list = new SimpleLinkedList<Character>();
        list.push('9');
        list.push('8');
        list.push('7');
        list.push('6');
        list.push('5');
        Character[] expected = {'5', '6', '7', '8', '9'};
        assertThat(list.asArray(Character.class)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Empty list as array returns empty array")
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList<Object> list = new SimpleLinkedList<Object>();
        Object[] expected = {};
        assertThat(list.asArray(Object.class)).isEqualTo(expected);
    }

}
