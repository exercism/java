import java.util.Objects;
import java.util.Optional;

public class PartialJigsawInformation {
    private Optional<Integer> pieces;
    private Optional<Integer> border;
    private Optional<Integer> inside;
    private Optional<Integer> rows;
    private Optional<Integer> columns;
    private Optional<Double> aspectRatio;
    private Optional<String> format;

    public PartialJigsawInformation(Integer pieces, Integer border, Integer inside, Integer rows, Integer columns, Double aspectRatio, String format) {
        this.pieces = Optional.ofNullable(pieces);
        this.border = Optional.ofNullable(border);
        this.inside = Optional.ofNullable(inside);
        this.rows = Optional.ofNullable(rows);
        this.columns = Optional.ofNullable(columns);
        this.aspectRatio = Optional.ofNullable(aspectRatio);
        this.format = Optional.ofNullable(format);
    }

    public Optional<Integer> getPieces() {
        return pieces;
    }

    public Optional<Integer> getBorder() {
        return border;
    }

    public Optional<Integer> getInside() {
        return inside;
    }

    public Optional<Integer> getRows() {
        return rows;
    }

    public Optional<Integer> getColumns() {
        return columns;
    }

    public Optional<Double> getAspectRatio() {
        return aspectRatio;
    }

    public Optional<String> getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PartialJigsawInformation that = (PartialJigsawInformation) o;
        return Objects.equals(pieces, that.pieces) && Objects.equals(border, that.border) && Objects.equals(inside, that.inside) && Objects.equals(rows, that.rows) && Objects.equals(columns, that.columns) && Objects.equals(aspectRatio, that.aspectRatio) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces, border, inside, rows, columns, aspectRatio, format);
    }

    @Override
    public String toString() {
        return "PartialJigsawInformation{" + "pieces=" + pieces + ", border=" + border + ", inside=" + inside + ", rows=" + rows + ", columns=" + columns + ", aspectRatio=" + aspectRatio + ", format=" + format + '}';
    }
}
