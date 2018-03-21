import java.util.Objects;

class Domino {
    private int a;
    private int b;
    Domino(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    int getLeft() {
    	return this.a;
    }
    
    int getRight() {
    	return this.b;
    }
    
    @Override
    public boolean equals(Object o) {
    	Domino otherDomino = (Domino) o;
    	return (this.getLeft() == otherDomino.getLeft() && this.getRight() == otherDomino.getRight()) ||
    			(this.getLeft() == otherDomino.getRight() && this.getRight() == otherDomino.getLeft());
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(a, b);
    }
}
