
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class SimpleLinkedListTest {

    @Test
    public void aNewListIsEmpty() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void canCreateFromArray() {
        Integer[] values = new Integer[]{1, 2, 3};
        SimpleLinkedList list = new SimpleLinkedList(values);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void popOnEmptyListWillThrow() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.pop();
    }

    @Test
    public void popReturnsLastAddedElement() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(8);
        assertThat(list.pop()).isEqualTo(9);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void reverseReversesList() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.reverse();
        assertThat(list.pop()).isEqualTo(9);
        assertThat(list.pop()).isEqualTo(8);
        assertThat(list.pop()).isEqualTo(7);
        assertThat(list.pop()).isEqualTo(6);
        assertThat(list.pop()).isEqualTo(5);
    }

    @Test
    public void canReturnListAsArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        Integer[] expected = {5, 6, 7, 8, 9};
        assertThat(list.asArray(Integer.class)).containsExactly(expected);
    }

    @Test
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        Object[] expected = {};
        assertThat(list.asArray(Object.class)).containsExactly(expected);
    }

}
