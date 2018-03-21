import java.util.ArrayList;
import java.util.Arrays;

class Dominoes {
	
	ArrayList<Domino> formChain(ArrayList<Domino> inputDominoes) {
		if (inputDominoes.size() == 0) {
			throw new IllegalArgumentException("Empty input domino list.");
		} else {
			ArrayList<Domino> dominoChain = formPartialChain(new ArrayList<Domino>(), inputDominoes);
			if(dominoChain == null) {
				throw new IllegalArgumentException("No domino chain found.");
			} else {
				return dominoChain;
			}
		}
	}
	
	private boolean isValidChain(ArrayList<Domino> chain) {
		return isValidPartialChain(chain) && (chain.get(0).getLeft() == chain.get(chain.size() - 1).getRight());
	}
	
	private boolean isValidPartialChain(ArrayList<Domino> chain) {
		for (int i = 0; i < chain.size() - 1; i++) {
			if (chain.get(i).getRight() != chain.get(i+1).getLeft()) {
				return false;
			}
		}
		
		return true;
	}
	
	ArrayList<Domino> formPartialChain(ArrayList<Domino> current, ArrayList<Domino> remaining) {
		if (remaining.size() == 0) {
			if (isValidChain(current)) {
				return current;
			} else {
				return null;
			}
		}
		
		for (int i = 0; i < remaining.size(); i++) {
			ArrayList<Domino> newRemaining = new ArrayList<Domino>(remaining);
			newRemaining.remove(i);
			
			ArrayList<Domino> newChainA = new ArrayList<Domino>(current);
			newChainA.add(remaining.get(i));
			
			ArrayList<Domino> newChainB = new ArrayList<Domino>(current);
			newChainB.add(new Domino(remaining.get(i).getRight(), remaining.get(i).getLeft()));
			
			if (isValidPartialChain(newChainA)) {
				ArrayList<Domino> searchA = formPartialChain(newChainA, newRemaining);
				if (searchA != null) {
					return searchA;
				}
			}
			
			if (isValidPartialChain(newChainB)) {
				ArrayList<Domino> searchB = formPartialChain(newChainB, newRemaining);
				if (searchB != null) {
					return searchB;
				}
			}
		}
		
		return null;
	}
}
