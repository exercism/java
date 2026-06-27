import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SimpleLinkedListTest {

    @Test
    @DisplayName("count -> Empty list has length of zero")
    public void countEmptyListHasLengthOfZero() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("count -> Singleton list has length of one")
    public void countSingletonListHasLengthOfOne() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1});
        assertThat(list.size()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("count -> Non-empty list has correct length")
    public void countNonEmptyListHasCorrectLength() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2, 3});
        assertThat(list.size()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pop -> Pop from empty list is an error")
    public void popFromEmptyListIsAnError() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(list::pop);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pop -> Can pop from singleton list")
    public void canPopFromSingletonList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1});
        assertThat(list.pop()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pop -> Can pop from non-empty list")
    public void canPopFromNonEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        assertThat(list.pop()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pop -> Can pop multiple items")
    public void canPopMultipleItems() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pop -> Pop updates the count")
    public void popUpdatesTheCount() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.pop()).isEqualTo(1);
        assertThat(list.size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("push -> Can push to an empty list")
    public void canPushToAnEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.push(1);
        assertThat(list.size()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("push -> Can push to a non-empty list")
    public void canPushToANonEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        list.push(3);
        assertThat(list.size()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("push -> Push updates count")
    public void pushUpdatesCount() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        list.push(3);
        assertThat(list.size()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("push -> Push and pop")
    public void pushAndPop() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.push(1);
        list.push(2);
        assertThat(list.pop()).isEqualTo(2);
        list.push(3);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(3);
        assertThat(list.pop()).isEqualTo(1);
        assertThat(list.size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("peek -> Peek on empty list is an error")
    public void peekOnEmptyListIsAnError() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(list::peek);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("peek -> Can peek on singleton list")
    public void canPeekOnSingletonList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1});
        assertThat(list.peek()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("peek -> Can peek on non-empty list")
    public void canPeekOnNonEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        assertThat(list.peek()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("peek -> Peek does not change the count")
    public void peekDoesNotChangeTheCount() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2});
        assertThat(list.peek()).isEqualTo(2);
        assertThat(list.size()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("peek -> Can peek after a pop and push")
    public void canPeekAfterAPopAndPush() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.push(1);
        list.push(2);
        assertThat(list.peek()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.peek()).isEqualTo(1);
        list.push(3);
        assertThat(list.peek()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("toList LIFO -> Empty linked list to list is empty")
    public void toListLifoEmptyLinkedListToListIsEmpty() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThat(list.toList()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("toList LIFO -> To list with multiple values")
    public void toListLifoToListWithMultipleValues() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2, 3});
        assertThat(list.toList()).containsExactly(3, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("toList LIFO -> To list after a pop")
    public void toListLifoToListAfterAPop() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        assertThat(list.pop()).isEqualTo(3);
        list.push(4);
        assertThat(list.toList()).containsExactly(4, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse -> Reversed empty list has same values")
    public void reversedEmptyListHasSameValues() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.reverse();
        assertThat(list.toList()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse -> Reversed singleton list is same list")
    public void reversedSingletonListIsSameList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1});
        list.reverse();
        assertThat(list.toList()).containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse -> Reversed non-empty list is reversed")
    public void reversedNonEmptyListIsReversed() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2, 3});
        list.reverse();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.pop()).isEqualTo(1);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse -> Double reverse")
    public void doubleReverse() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{1, 2, 3});
        list.reverse();
        list.reverse();
        assertThat(list.pop()).isEqualTo(3);
        assertThat(list.pop()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Create list from array")
    public void canCreateFromArray() {
        Character[] values = new Character[]{'1', '2', '3'};
        SimpleLinkedList<Character> list = new SimpleLinkedList<Character>(values);
        assertThat(list.size()).isEqualTo(3);
    }
}
