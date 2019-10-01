class ChangeCalculator {
    static int  [] coins  = {100,25,10,5,1};

    public static ArrayList<> getChange(int x) { // x is the input 
      ArrayList<> returned = new ArrayList<Integer>();// array contain all coins returned by change  
        int  res = x;
        int i = 0;
        while (i<coins.length || res >0) {
            if(coins[i]<=res){
                res-=coins[i];
                returned.add(coins[i]);
            }else{
                i++;
            }
        }
        return returned;
    }
 
}