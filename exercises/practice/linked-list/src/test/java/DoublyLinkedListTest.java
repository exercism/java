import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DoublyLinkedListTest {

    @Test
    public void popGetsElementFromTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(7);

        assertThat(list.pop()).isEqualTo(7);
    }

    @Disabled("Remove to run test")
    @Test
    public void pushAndPopRespectivelyAddsAndRemovesAtEndOfList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(11);
        list.push(13);

        assertThat(list.pop()).isEqualTo(13);
        assertThat(list.pop()).isEqualTo(11);
    }

    @Disabled("Remove to run test")
    @Test
    public void shiftGetsAnElementFromTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(17);

        assertThat(list.shift()).isEqualTo(17);
    }

    @Disabled("Remove to run test")
    @Test
    public void shiftGetsFirstElementFromTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(23);
        list.push(5);

        assertThat(list.shift()).isEqualTo(23);
        assertThat(list.shift()).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    public void unshiftAddsElementAtStartOfTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.unshift(23);
        list.unshift(5);

        assertThat(list.shift()).isEqualTo(5);
        assertThat(list.shift()).isEqualTo(23);
    }

    @Disabled("Remove to run test")
    @Test
    public void popPushShiftUnshiftCanBeUsedInAnyOrder() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("one");
        list.push("two");

        assertThat(list.pop()).isEqualTo("two");

        list.push("three");

        assertThat(list.shift()).isEqualTo("one");

        list.unshift("four");
        list.push("five");

        assertThat(list.shift()).isEqualTo("four");
        assertThat(list.pop()).isEqualTo("five");
        assertThat(list.shift()).isEqualTo("three");
    }

    @Disabled("Remove to run test")
    @Test
    public void poppingToEmptyDoesNotBreakTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(41);
        list.push(59);
        list.pop();
        list.pop();
        list.push(47);

        assertThat(list.pop()).isEqualTo(47);
    }

    @Disabled("Remove to run test")
    @Test
    public void shiftingToEmptyDoesNotBreakTheList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(41);
        list.push(59);
        list.shift();
        list.shift();
        list.push(47);

        assertThat(list.shift()).isEqualTo(47);
    }
}
