import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DoublyLinkedListTest {

    @Test
    public void testPushPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(10);
        list.push(20);

        assertThat(list.pop(), is(20));
        assertThat(list.pop(), is(10));
    }

    @Ignore("Remove to run test")
    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("10");
        list.push("20");

        assertThat(list.shift(), is("10"));
        assertThat(list.shift(), is("20"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        list.unshift('1');
        list.unshift('2');

        assertThat(list.shift(), is('2'));
        assertThat(list.shift(), is('1'));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnshiftPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.unshift(10);
        list.unshift(20);

        assertThat(list.pop(), is(10));
        assertThat(list.pop(), is(20));
    }

    @Ignore("Remove to run test")
    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("ten");
        list.push("twenty");

        assertThat(list.pop(), is("twenty"));

        list.push("thirty");

        assertThat(list.shift(), is("ten"));

        list.unshift("forty");
        list.push("fifty");

        assertThat(list.shift(), is("forty"));
        assertThat(list.pop(), is("fifty"));
        assertThat(list.shift(), is("thirty"));
    }

}
