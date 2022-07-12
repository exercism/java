import java.util.*;
import java.math.*;
class PythagoreanTriplet{
    private int a;
    private int b;
    private int c;
    PythagoreanTriplet(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public boolean equals(Object object) {
        PythagoreanTriplet other = (PythagoreanTriplet) object;
        return a == other.a && b == other.b && c == other.c;
    }
    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }
}
class PythagoreanTripletBuilder{
    private int sum;
    private int maximum;
    PythagoreanTripletBuilder  thatSumTo(int value){
        this.sum = value;
        return this;
    }
    
    PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int value){
        this.maximum = value;
        return this;
    }
    List<PythagoreanTriplet> build() {
        List<PythagoreanTriplet> triples = new ArrayList<PythagoreanTriplet>(); 
        for(int a=1;a<=maximum/2;a++){
            for(int b=a+1;b<=(maximum-a)/2;b++){
                if(b!=a){
                    int c = sum - a - b;
                        if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)){
                            triples.add(new PythagoreanTriplet(a, b, c));
                        }
                    }
                        
            }
        }
        return triples;
    }
}
