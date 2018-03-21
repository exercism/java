import java.util.Objects;

class Domino {
    private int a;
    private int b;
    Domino(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    void getLeft() {
    	return this.a;
    }
    
    void getRight() {
    	return this.b;
    }
    
    @Override
    public boolean equals(Object o) {
    	Domino otherDomino = (Domino) o;
    	return (this.a == otherDomino.a && this.b == otherDomino.b) || (this.a == otherDomino.b && this.b == otherDomino.a);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(a, b);
    }
}
