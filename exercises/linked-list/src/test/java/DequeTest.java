import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DequeTest {
    private Deque<Integer> subject;

    @Before
    public void setUp() {
        subject = new Deque<>();
    }

    @Test
    public void testPushPop() {
        subject.push(10);
        subject.push(20);
        assertThat(subject.pop()).isEqualTo(20);
        assertThat(subject.pop()).isEqualTo(10);
    }

    @Test
    public void testPushShift() {
        subject.push(10);
        subject.push(20);
        assertThat(subject.shift()).isEqualTo(10);
        assertThat(subject.shift()).isEqualTo(20);
    }

    @Test
    public void testUnshiftShift() {
        subject.unshift(10);
        subject.unshift(20);
        assertThat(subject.shift()).isEqualTo(20);
        assertThat(subject.shift()).isEqualTo(10);
    }

    @Test
    public void testUnshiftPop() {
        subject.unshift(10);
        subject.unshift(20);
        assertThat(subject.pop()).isEqualTo(10);
        assertThat(subject.pop()).isEqualTo(20);
    }

    @Test
    public void testExample() {
        subject.push(10);
        subject.push(20);
        assertThat(subject.pop()).isEqualTo(20);

        subject.push(30);
        assertThat(subject.shift()).isEqualTo(10);

        subject.unshift(40);
        subject.push(50);
        assertThat(subject.shift()).isEqualTo(40);
        assertThat(subject.pop()).isEqualTo(50);
        assertThat(subject.shift()).isEqualTo(30);
    }
}
