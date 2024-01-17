import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DominoesTest {

    @Test
    public void emtpyInputEmptyOutputTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        List<Domino> dominoesList = new ArrayList<>();

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertThat(chain).withFailMessage("The output list should be empty.").hasSize(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void singletonInputSingletonOutput() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 1)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void singletonCantBeChainedTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Disabled("Remove to run test")
    @Test
    public void threeElementsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(3, 1), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void canReverseDominoesTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(1, 3), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void cantBeChainedTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(4, 1), new Domino(2, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Disabled("Remove to run test")
    @Test
    public void disconnectedSimpleTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 1), new Domino(2, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Disabled("Remove to run test")
    @Test
    public void disconnectedDoubleLoopTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 1), new Domino(3, 4), new Domino(4, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Disabled("Remove to run test")
    @Test
    public void disconnectedSingleIsolatedTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(4, 4)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    @Disabled("Remove to run test")
    @Test
    public void needBacktrackTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(2, 4),
            new Domino(4, 2)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void separateLoopsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1),
            new Domino(1, 1), new Domino(2, 2), new Domino(3, 3)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void nineElementsTest() throws ChainNotFoundException {
        Dominoes dominoes = new Dominoes();
        Domino[] dominoesArray = {new Domino(1, 2), new Domino(5, 3), new Domino(3, 1),
            new Domino(1, 2), new Domino(2, 4), new Domino(1, 6),
            new Domino(2, 3), new Domino(3, 4), new Domino(5, 6)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        List<Domino> chain = dominoes.formChain(dominoesList);

        assertValidChain(dominoesList, chain);
    }

    @Disabled("Remove to run test")
    @Test
    public void separateThreeDominoLoopsTest() {
        Dominoes dominoes = new Dominoes();

        Domino[] dominoesArray = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1),
            new Domino(4, 5), new Domino(5, 6), new Domino (6, 4)};
        List<Domino> dominoesList = Arrays.asList(dominoesArray);

        assertThatExceptionOfType(ChainNotFoundException.class)
                .isThrownBy(() -> dominoes.formChain(dominoesList))
                .withMessage("No domino chain found.");
    }

    private void assertValidChain(List<Domino> inputDominoes, List<Domino> outputDominoes) {
        assertSameDominoes(inputDominoes, outputDominoes);
        assertEndDominoesMatch(outputDominoes);
        assertConsecutiveDominoes(outputDominoes);
    }

    private void assertEndDominoesMatch(List<Domino> outputDominoes) {
        int leftValueOfFirstDomino = outputDominoes.get(0).getLeft();
        int rightValueOfLastDomino = outputDominoes.get(outputDominoes.size() - 1).getRight();
        String errorMessage = "The left value of the first domino ("
            + leftValueOfFirstDomino
            + ") needs to match the right value of the last domino ("
            + rightValueOfLastDomino
            + ").";

        assertThat(leftValueOfFirstDomino).withFailMessage(errorMessage).isEqualTo(rightValueOfLastDomino);
    }

    private void assertSameDominoes(List<Domino> inputDominoes, List<Domino> outputDominoes) {
        String errorMessage = "The number of dominoes in the input list (" + inputDominoes.size()
                + ") needs to match the number of dominoes in the output chain (" + outputDominoes.size() + ")";

        assertThat(inputDominoes).withFailMessage(errorMessage).hasSameSizeAs(outputDominoes);

        for (Domino domino : inputDominoes) {
            int inputFrequency = Collections.frequency(inputDominoes, domino);
            int outputFrequency = Collections.frequency(outputDominoes, domino);

            String frequencyErrorMessage = "The frequency of domino (" + domino.getLeft() + ", " +
                domino.getRight() + ")" +
                " in the input is (" + inputFrequency + "), but (" + outputFrequency + ") in the output.";

            assertThat(inputFrequency).withFailMessage(frequencyErrorMessage).isEqualTo(outputFrequency);
        }
    }

    private void assertConsecutiveDominoes(List<Domino> dominoes) {
        for (int i = 0; i < dominoes.size() - 1; i++) {

            int rightValueOfIthDomino = dominoes.get(i).getRight();
            int leftValueOfNextDomino = dominoes.get(i + 1).getLeft();
            String errorMessage = "The right value of domino number " + i + " ("
                + rightValueOfIthDomino
                + ") needs to match the left value of domino number " + (i + 1) + " ("
                + leftValueOfNextDomino
                + ").";

            assertThat(dominoes.get(i).getRight()).withFailMessage(errorMessage)
                .isEqualTo(dominoes.get(i + 1).getLeft());
        }
    }
}
