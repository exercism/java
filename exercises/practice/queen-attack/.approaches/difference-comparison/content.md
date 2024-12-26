# Difference Comparison Approach

```java
class QueenAttackCalculator {
    private final Queen queen1;
    private final Queen queen2;
    
    QueenAttackCalculator(Queen queen1, Queen queen2) {
        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getRow() == queen2.getRow() && queen1.getColumn() == queen2.getColumn()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    boolean canQueensAttackOneAnother() {
        int rowDifference = Math.abs(queen1.getRow() - queen2.getRow());
        int columnDifference = Math.abs(queen1.getColumn() - queen2.getColumn());
        return rowDifference == 0 || columnDifference == 0 || rowDifference == columnDifference;
    }
}
```

## Explanation

### Constructor

The constructor takes two `Queen` objects, `queen1` and `queen2`, and stores them as instance variables after validating the following conditions:

- Either queen is `null`.
- Both queens occupy the same position.

If either of these conditions is true, an exception is thrown.

### `canQueensAttackOneAnother` Method

This method calculates the row and column differences between the two queens and checks the following conditions:

- The row difference is zero (the queens are on the same row).
- The column difference is zero (the queens are on the same column).
- The row and column differences are equal (the queens are on the same diagonal).

If any of these conditions are true, the method returns `true`, indicating that the queens can attack each other.
