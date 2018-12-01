public class FindingFibonacci{
    public static int findingFib(int n){
        if(n<= 2){
        	return 1;
        }
        else{
        	return findingFib(n-1) + findingFib(n-2);
        }
    }
    public static int[] getResults(int[] input){
        int size = input.length;
    	int[] results = new int[size];
    	for(int i = 0; i < size; i++){
    		results[i] = FindingFibonacci.findingFib(input[i]);
    	}
        return results;
    }
}