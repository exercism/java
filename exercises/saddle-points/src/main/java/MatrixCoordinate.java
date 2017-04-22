final class MatrixCoordinate {

  private final int row;

  private final int column;

  MatrixCoordinate(final int row, final int column) {
    this.row = row;
    this.column = column;
  }

  // Generated equals and hashcode.

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final MatrixCoordinate that = (MatrixCoordinate) o;

    return row == that.row && column == that.column;
  }

  @Override
  public int hashCode() {
    int result = row;
    result = 31 * result + column;
    return result;
  }

}
