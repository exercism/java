# Introduction

In this exercise, we determine if two queens on a chessboard can attack each other based on their positions.
A queen in chess can move any number of squares horizontally, vertically, or diagonally.
The task is to check if two queens, placed on specific coordinates, can attack each other.

## Genral Advice

The problem boils down to checking three conditions:

1. **Same Row**: If the queens are on the same row.
2. **Same Column**: If the queens are on the same column.
3. **Same Diagonal**: If the queens are on the same diagonal, i.e., the absolute difference between their row and column positions is equal.

## Approach: Simple Comparison Approach

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

For more details on the implementation of this approach, check out the [Simple Comparison Approach][simple-comparison-approach].

[simple-comparison-approach]: https://exercism.org/tracks/java/exercises/queen-attack/approaches/simple-comparison
