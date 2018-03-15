import java.util.ArrayList;
import java.util.Arrays;

class Dominoes {
	
	public static void main(String[] args) {
		Domino[] dominoesList = {new Domino(1, 2), new Domino(3, 1), new Domino(2, 3)};
		ArrayList<Domino> dominoes = new ArrayList<>(Arrays.asList(dominoesList));
		
		ArrayList<Domino> chain = formPartialChain(new ArrayList<Domino>(), dominoes);
		
		for(int i = 0; i < chain.size(); i++) {
			System.out.print("(" + chain.get(i).a + ", " + chain.get(i).b + "), ");
		}
	}
	
	static ArrayList<Domino> formChain(ArrayList<Domino> inputDominoes) {
		if(inputDominoes.size() == 0) {
			return null;
		} else {
			return formPartialChain(new ArrayList<Domino>(), inputDominoes);
		}
	}
	
	static private boolean isValidChain(ArrayList<Domino> chain) {
		return isValidPartialChain(chain) && (chain.get(0).a == chain.get(chain.size() - 1).b);
	}
	
	static private boolean isValidPartialChain(ArrayList<Domino> chain) {
		for(int i = 0; i < chain.size() - 1; i++) {
			if(chain.get(i).b != chain.get(i+1).a) {
				return false;
			}
		}
		
		return true;
	}
	
	static ArrayList<Domino> formPartialChain(ArrayList<Domino> current, ArrayList<Domino> remaining) {
		if(remaining.size() == 0) {
			if(isValidChain(current)) {
				return current;
			} else {
				return null;
			}
		}
		
		for(int i = 0; i < remaining.size(); i++) {
			ArrayList<Domino> newRemaining = new ArrayList<Domino>(remaining);
			newRemaining.remove(i);
			
			ArrayList<Domino> newChainA = new ArrayList<Domino>(current);
			newChainA.add(remaining.get(i));
			
			ArrayList<Domino> newChainB = new ArrayList<Domino>(current);
			newChainB.add(new Domino(remaining.get(i).b, remaining.get(i).a));
			
			if(isValidPartialChain(newChainA)) {
				ArrayList<Domino> searchA = formPartialChain(newChainA, newRemaining);
				if(searchA != null) {
					return searchA;
				}
			}
			
			if(isValidPartialChain(newChainB)) {
				ArrayList<Domino> searchB = formPartialChain(newChainB, newRemaining);
				if(searchB != null) {
					return searchB;
				}
			}
		}
		
		return null;
	}
}
