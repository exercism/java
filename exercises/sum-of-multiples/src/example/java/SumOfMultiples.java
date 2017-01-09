public class SumOfMultiples {
    
    
    public static int sum(int number, int[] set) {
        
        int sum = 0;
        int count = 0;
        
        for (int i = 1; i < number; i++) {
            
            for (int j = 0; j < set.length; j++) {
                if (i % set[j] == 0) {
                    count++;
                }
            }
            
            if (count > 0) {
                sum = sum + i;
                count = 0;
            }
        }
        
        return sum;
    }
    
}
