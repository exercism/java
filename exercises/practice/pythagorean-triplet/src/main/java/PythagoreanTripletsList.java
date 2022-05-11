import java.util.ArrayList;
import java.util.List;
public class PythagoreanTripletsList {
	
	private int maxFactors = 1000;
	private int minFactors = 1;
	private int maxSum = 1000;
	public PythagoreanTripletsList withFactorsLessThanOrEqualTo(int i) {
		this.maxFactors = i;
		return this;
	}
	public PythagoreanTripletsList withFactorsGreaterThanOrEqualTo(int i) {
		this.minFactors = i;
		return this;
	}
	
	public PythagoreanTripletsList() {
	}
	public List<PythagoreanTriplet> build() {
		ArrayList<PythagoreanTriplet> tripletList = new ArrayList<PythagoreanTriplet>();
		
		//k<j<i
		for (int i = minFactors+2; i<= maxFactors; i++) {
			for (int j = minFactors+1; j<i;j++) {
				for (int k = minFactors; k<j; k++) {
					
					if (maxSum != 1000 && (i+j+k)!=maxSum) {
						continue;
					}
				
					if (PythagoreanTriplet.isPythagorean(k,j, i)) {
						tripletList.add(new PythagoreanTriplet(k, j, i));
					}
				}
			}
		}
		return tripletList;
	}
	public PythagoreanTripletsList thatSumTo(int i) {
		this.maxSum = i;
		return this;
	}
}
