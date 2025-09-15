import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactTest {

    @Test
    @DisplayName("input cells have a value")
    public void testInputCellHasValue() {
        var input = React.inputCell(10);

        assertThat(input.getValue()).isEqualTo(10);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("an input cell's value can be set")
    public void testInputCellValueCanBeSet() {
        var input = React.inputCell(4);
        input.setValue(20);

        assertThat(input.getValue()).isEqualTo(20);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("compute cells calculate initial value")
    public void testComputeCellCalculateInitialValue() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        assertThat(output.getValue()).isEqualTo(2);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("compute cells take inputs in the right order")
    public void testComputeCellsInTheRightOrder() {
        var first = React.inputCell(1);
        var second = React.inputCell(2);
        var output = React.computeCell(list -> list.get(0) + list.get(1) * 10, List.of(first, second));

        assertThat(output.getValue()).isEqualTo(21);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("compute cells update value when dependencies are changed")
    public void testComputeCellsUpdateValueWhenDependenciesAreChanged() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        input.setValue(3);
        assertThat(output.getValue()).isEqualTo(4);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("compute cells can depend on other compute cells")
    public void testComputeCellsCanDependOnOtherComputeCells() {
        var input = React.inputCell(1);
        var timesTwo = React.computeCell(list -> list.get(0) * 2, List.of(input));
        var timesThirty = React.computeCell(list -> list.get(0) * 30, List.of(input));
        var output = React.computeCell(list -> list.get(0) + list.get(1), List.of(timesTwo, timesThirty));

        assertThat(output.getValue()).isEqualTo(32);

        input.setValue(3);
        assertThat(output.getValue()).isEqualTo(96);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("compute cells fire callbacks")
    public void testComputeCellsFireCallbacks() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        var values = new ArrayList<Integer>();
        output.addCallback(values::add);

        input.setValue(3);
        assertThat(values).containsExactly(4);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callback cells only fire on change")
    public void testCallbacksOnlyFireOnChange() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) < 3 ? 111 : 222, List.of(input));

        var values = new ArrayList<Integer>();
        output.addCallback(values::add);

        input.setValue(2);
        assertThat(values).isEmpty();

        input.setValue(4);
        assertThat(values).containsExactly(222);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callbacks do not report already reported values")
    public void testCallbacksDoNotReportAlreadyReportedValues() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        var values = new ArrayList<Integer>();
        output.addCallback(values::add);

        input.setValue(2);
        assertThat(values).containsExactly(3);
        values.clear();

        input.setValue(3);
        assertThat(values).containsExactly(4);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callbacks can fire from multiple cells")
    public void testCallbacksCanFireFromMultipleCells() {
        var input = React.inputCell(1);
        var plusOne = React.computeCell(list -> list.get(0) + 1, List.of(input));
        var minusOne = React.computeCell(list -> list.get(0) - 1, List.of(input));

        var values1 = new ArrayList<Integer>();
        plusOne.addCallback(values1::add);

        var values2 = new ArrayList<Integer>();
        minusOne.addCallback(values2::add);

        input.setValue(10);
        assertThat(values1).containsExactly(11);
        assertThat(values2).containsExactly(9);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callbacks can be added and removed")
    public void testCallbacksCanBeAddedAndRemoved() {
        var input = React.inputCell(11);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        var values1 = new ArrayList<Integer>();
        Consumer<Integer> callback1 = values1::add;
        output.addCallback(callback1);

        var values2 = new ArrayList<Integer>();
        output.addCallback(values2::add);

        input.setValue(31);
        assertThat(values1).containsExactly(32);
        assertThat(values2).containsExactly(32);

        values1.clear();
        values2.clear();

        output.removeCallback(callback1);

        var values3 = new ArrayList<Integer>();
        output.addCallback(values3::add);

        input.setValue(41);

        assertThat(values1).isEmpty();
        assertThat(values2).containsExactly(42);
        assertThat(values3).containsExactly(42);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("removing a callback multiple times doesn't interfere with other callbacks")
    public void testRemovingACallbackMultipleTimesDoesntInterfereWithOtherCallbacks() {
        var input = React.inputCell(1);
        var output = React.computeCell(list -> list.get(0) + 1, List.of(input));

        var values1 = new ArrayList<Integer>();
        Consumer<Integer> callback1 = values1::add;
        output.addCallback(callback1);

        var values2 = new ArrayList<Integer>();
        Consumer<Integer> callback2 = values2::add;
        output.addCallback(callback2);

        output.removeCallback(callback1);
        output.removeCallback(callback1);

        input.setValue(2);
        assertThat(values2).containsExactly(3);

        assertThat(values1).isEmpty();
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callbacks should only be called once even if multiple dependencies change")
    public void testCallbacksShouldOnlyBeCalledOnceEvenIfMultipleDependenciesChange() {
        var input = React.inputCell(1);
        var plusOne = React.computeCell(list -> list.get(0) + 1, List.of(input));
        var minusOne1 = React.computeCell(list -> list.get(0) - 1, List.of(input));
        var minusOne2 = React.computeCell(list -> list.get(0) - 1, List.of(minusOne1));
        var output = React.computeCell(list -> list.get(0) * list.get(1), List.of(plusOne, minusOne2));

        var values = new ArrayList<Integer>();
        output.addCallback(values::add);

        input.setValue(4);
        assertThat(values).containsExactly(10);
    }

    @Disabled("Remove to run")
    @Test
    @DisplayName("callbacks should not be called if dependencies change but output value doesn't change")
    public void testCallbacksShouldNotBeCalledIfDependenciesChangeButOutputValueDoesntChange() {
        var input = React.inputCell(1);
        var plusOne = React.computeCell(list -> list.get(0) + 1, List.of(input));
        var minusOne = React.computeCell(list -> list.get(0) - 1, List.of(input));
        var alwaysTwo = React.computeCell(list -> list.get(0) - list.get(1), List.of(plusOne, minusOne));

        var values = new ArrayList<Integer>();
        alwaysTwo.addCallback(values::add);

        input.setValue(2);
        assertThat(values).isEmpty();

        input.setValue(3);
        assertThat(values).isEmpty();

        input.setValue(4);
        assertThat(values).isEmpty();

        input.setValue(5);
        assertThat(values).isEmpty();
    }
}
