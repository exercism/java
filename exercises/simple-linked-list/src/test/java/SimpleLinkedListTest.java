import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void aNewListIsEmpty() {
        SimpleLinkedList list = new SimpleLinkedList();
        assertThat(list.size(), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void canCreateFromArray() {
        Integer[] values = new Integer[]{1, 2, 3};
        SimpleLinkedList list = new SimpleLinkedList(values);
        assertThat(list.size(), is(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void popOnEmptyListWillThrow() {
        thrown.expect(NoSuchElementException.class);
        SimpleLinkedList list = new SimpleLinkedList();
        list.pop();
    }

    @Ignore("Remove to run test")
    @Test
    public void popReturnsLastAddedElement() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        assertThat(list.size(), is(2));
        assertThat(list.pop(), is(8));
        assertThat(list.pop(), is(9));
        assertThat(list.size(), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void reverseReversesList() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.reverse();
        assertThat(list.pop(), is(9));
        assertThat(list.pop(), is(8));
        assertThat(list.pop(), is(7));
        assertThat(list.pop(), is(6));
        assertThat(list.pop(), is(5));
    }

    @Ignore("Remove to run test")
    @Test
    public void canReturnListAsArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        Integer[] expected = {5, 6, 7, 8, 9};
        assertArrayEquals(expected, list.asArray(Integer.class));
    }

    @Ignore("Remove to run test")
    @Test
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        Object[] expected = {};
        assertArrayEquals(expected, list.asArray(Object.class));
    }

}
