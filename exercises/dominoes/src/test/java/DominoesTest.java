import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DominoesTest {
	
	@Test
	public void emtpyInputEmptyOutputTest() {
		Dominoes dominoes = new Dominoes();
		
		ArrayList<Domino> dominoesArray = new ArrayList<>();
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void singletonInputSingletonOutput() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 1)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void singletonCantBeChainedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void threeElementsTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(3, 1), new Domino(2, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void canReverseDominoesTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(1, 3), new Domino(2, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void cantBeChainedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(4, 1), new Domino(2, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedSimpleTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 1), new Domino(2, 2)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedDoubleLoopTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 1), new Domino(3, 4), new Domino(4, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void disconnectedSingleIsolatedTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(4, 4)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertNull(chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void needBacktrackTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(2, 4), new Domino(4, 2)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void separateLoopsTest() {
		Dominoes dominoes = new Dominoes();
		
		Domino[] dominoesList = {new Domino(1, 2), new Domino(2, 3), new Domino(3, 1), new Domino(1, 1), new Domino(2, 2), new Domino(3, 3)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	@Ignore("Remove to run test")
	@Test
	public void nineElementsTest() {
		Dominoes dominoes = new Dominoes();
		Domino[] dominoesList = {new Domino(1, 2), new Domino(5, 3), new Domino(3, 1), new Domino(1, 2), new Domino(2, 4), new Domino(1, 6), new Domino(2, 3), new Domino(3, 4), new Domino(5, 6)};
		ArrayList<Domino> dominoesArray = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = dominoes.formChain(dominoesArray);
		
		assertValidChain(dominoesArray, chain);
	}
	
	private void assertValidChain(ArrayList<Domino> inputDominoes, ArrayList<Domino> outputDominoes) {
		assertSameDominoes(inputDominoes, outputDominoes);
		assertEndDominoesMatch(outputDominoes);
		assertConsecutiveDominoes(outputDominoes);
	}
	
	private void assertEndDominoesMatch(ArrayList<Domino> outputDominoes) {
		assertEquals(outputDominoes.get(0).a, outputDominoes.get(outputDominoes.size() - 1).b);
	}
	
	private void assertSameDominoes(ArrayList<Domino> inputDominoes, ArrayList<Domino> outputDominoes) {
		assertEquals(inputDominoes.size(), outputDominoes.size());
		
		for(Domino domino : inputDominoes) {
			assertEquals(Collections.frequency(inputDominoes, domino), Collections.frequency(outputDominoes, domino));
		}
	}
	
	private void assertConsecutiveDominoes(ArrayList<Domino> dominoes) {
		for(int i = 0; i < dominoes.size() - 1; i++) {
			assertEquals(dominoes.get(i).b, dominoes.get(i+1).a);
		}
	}
}
