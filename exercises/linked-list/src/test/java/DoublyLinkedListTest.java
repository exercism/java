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

        assertEquals(list.pop(), 20);
        assertEquals(list.pop(), 10);
    }

    @Ignore("Remove to run test")
    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("10");
        list.push("20");

        assertEquals(list.shift(), "10");
        assertEquals(list.shift(), "20");
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        list.unshift('1');
        list.unshift('2');

        assertEquals(list.shift(), '2');
        assertEquals(list.shift(), '1');
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnshiftPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.unshift(10);
        list.unshift(20);

        assertEquals(list.pop(), 10);
        assertEquals(list.pop(), 20);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("ten");
        list.push("twenty");

        assertEquals(list.pop(), "twenty");

        list.push("thirty");

        assertEquals(list.shift(), "ten");

        list.unshift("forty");
        list.push("fifty");

        assertEquals(list.shift(), "forty");
        assertEquals(list.pop(), "fifty");
        assertEquals(list.shift(), "thirty");
    }

}
