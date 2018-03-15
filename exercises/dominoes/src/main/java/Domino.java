import java.util.Objects;

class Domino {
    int a;
    int b;
    Domino(int a, int b) {
        this.a = a;
        this.b = b;
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
