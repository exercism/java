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

        assertThat(list.count(), is(2));
        assertThat(list.pop(), is(20));
        assertThat(list.count(), is(1));
        assertThat(list.pop(), is(10));
        assertThat(list.count(), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testInitializeWithValues() {
      DoublyLinkedList<Character> list = new DoublyLinkedList<>('a', 'b', 'c');

      assertThat(list.getValueAtIndex(0), is('a'));
      assertThat(list.getValueAtIndex(1), is('b'));
      assertThat(list.getValueAtIndex(2), is('c'));
    }

    @Ignore("Remove to run test")
    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("10");
        list.push("20");

        assertThat(list.shift(), is("10"));
        assertThat(list.shift(), is("20"));
        assertThat(list.count(), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        list.unshift('1');
        list.unshift('2');

        assertThat(list.shift(), is('2'));
        assertThat(list.count(), is(1));
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
    public void testInsert() {
      DoublyLinkedList<String> list = new DoublyLinkedList<>("Foo", "Bar");

      list.insert("Hello", 1);
      list.insert("World", 3);
      list.insert("FooBar", 5);
      list.insert("BarFoo", 0);

      assertThat(list.getValueAtIndex(0), is("BarFoo"));
      assertThat(list.getValueAtIndex(1), is("Foo"));
      assertThat(list.getValueAtIndex(2), is("Hello"));
      assertThat(list.getValueAtIndex(3), is("Bar"));
      assertThat(list.getValueAtIndex(4), is("World"));
      assertNull(list.getValueAtIndex(5));
      assertThat(list.getValueAtIndex(6), is("FooBar"));
      assertThat(list.count(), is(7));
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
