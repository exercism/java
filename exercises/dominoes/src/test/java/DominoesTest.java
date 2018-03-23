import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class DominoesTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	@Test
	public void emtpyInputEmptyOutputTest() {
		Dominoes dominoes = new Dominoes();
		
		ArrayList<Domino> dominoesArray = new ArrayList<>();
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertEquals("The output list should be empty.", 0, chain.size());
	}
	
	@Ignore("Remove to run test")
	@Test
	public void singletonInputSingletonOutput() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 1)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void singletonCantBeChainedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2)};
		List<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		expectedException.expect(ChainNotFoundException.class);
		expectedException.expectMessage("No domino chain found.");
		
		dominoes.formChain(dominoesArray);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void threeElementsTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(3, 1), new Domino(2, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void canReverseDominoesTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(1, 3), new Domino(2, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void cantBeChainedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(4, 1), new Domino(2, 3)};
		List<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		expectedException.expect(ChainNotFoundException.class);
		expectedException.expectMessage("No domino chain found.");
		
		dominoes.formChain(dominoesArray);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedSimpleTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 1), new Domino(2, 2)};
		List<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		expectedException.expect(ChainNotFoundException.class);
		expectedException.expectMessage("No domino chain found.");
		
		dominoes.formChain(dominoesArray);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedDoubleLoopTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 1), new Domino(3, 4), new Domino(4, 3)};
		List<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		expectedException.expect(ChainNotFoundException.class);
		expectedException.expectMessage("No domino chain found.");
		
		dominoes.formChain(dominoesArray);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedSingleIsolatedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(4, 4)};
		List<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		expectedException.expect(ChainNotFoundException.class);
		expectedException.expectMessage("No domino chain found.");
		
		dominoes.formChain(dominoesArray);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void needBacktrackTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(2, 4), new Domino(4, 2)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void separateLoopsTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1),
				new Domino(1, 1), new Domino(2, 2), new Domino(3, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void nineElementsTest() {
		Dominoes dominoes = new Dominoes();
		Domino[] dominoesList = {new Domino(1, 2), new Domino(5, 3), new Domino(3, 1), new Domino(1, 2), new Domino(2, 4), new Domino(1, 6), new Domino(2, 3), new Domino(3, 4), new Domino(5, 6)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		List<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
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
		
		assertEquals(errorMessage, leftValueOfFirstDomino, rightValueOfLastDomino);
	}
	
	private void assertSameDominoes(List<Domino> inputDominoes, List<Domino> outputDominoes) {
		String errorMessage = "The number of dominoes in the input list (" + inputDominoes.size()
				+ ") needs to match the number of dominoes in the output chain (" + outputDominoes.size() + ")";
		
		assertEquals(errorMessage, inputDominoes.size(), outputDominoes.size());
		
		for (Domino domino : inputDominoes) {
			int inputFrequency = Collections.frequency(inputDominoes, domino);
			int outputFrequency = Collections.frequency(outputDominoes, domino);
			
			String frequencyErrorMessage = "The frequency of domino (" + domino.getLeft() + ", " + domino.getRight() + ")"
					+ " in the input is (" + inputFrequency + "), but (" + outputFrequency + ") in the output.";
					
			assertEquals(frequencyErrorMessage, inputFrequency, outputFrequency);
		}
	}
	
	private void assertConsecutiveDominoes(List<Domino> dominoes) {
		for (int i = 0; i < dominoes.size() - 1; i++) {
			
			int rightValueOfIthDomino = dominoes.get(i).getRight();
			int leftValueOfNextDomino = dominoes.get(i+1).getLeft();
			String errorMessage = "The right value of domino number " + i + " ("
			    + rightValueOfIthDomino
			    + ") needs to match the left value of domino number " + (i+1) + " ("
			    + leftValueOfNextDomino
			    + ").";
			
			assertEquals(errorMessage, dominoes.get(i).getRight(), dominoes.get(i+1).getLeft());
		}
	}
}
