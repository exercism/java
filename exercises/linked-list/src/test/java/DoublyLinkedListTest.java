import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

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
    public void testFind() {
      DoublyLinkedList<Character> list = new DoublyLinkedList<>('h', 'e', 'l', 'l', 'o');

      assertThat(list.find('e'), is(1));
      assertThat(list.find('o'), is(4));
      assertThat(list.find('l'), is(2)); // Returns first index if multiple elements exist
      assertNull(list.find('r'));
    }

    @Ignore("Remove to run test")
    @Test
    public void testReplace() {
      DoublyLinkedList<String> list = new DoublyLinkedList<>();

      list.push("Goodbye");
      list.push("World");
      list.replace(0, "Hello");

      assertThat(list.getValueAtIndex(0), is("Hello"));
      assertThat(list.getValueAtIndex(1), is("World"));
    }

    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("ten");
        list.push("twenty");

        assertThat(list.pop(), is("twenty"));
        assertThat(list.count(), is(1));

        list.insert("zero", 0);
        list.push("thirty");

        assertThat(list.shift(), is("zero"));
        assertThat(list.getValueAtIndex(0), is("ten"));
        assertThat(list.count(), is(2));

        list.unshift("forty");
        list.push("fifty");
        list.insert("seventy", 5);

        assertNull(list.getValueAtIndex(4));
        assertThat(list.find("thirty"), is(2));

        list.replace(4, "sixty");

        assertThat(list.shift(), is("forty"));
        assertThat(list.pop(), is("seventy"));
        assertThat(list.pop(), is("sixty"));
        assertThat(list.shift(), is("ten"));
    }

}
