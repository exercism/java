import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Represents partial or complete information about a jigsaw puzzle,
 *
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
public class JigsawInfo {
    private final OptionalInt pieces;
    private final OptionalInt border;
    private final OptionalInt inside;
    private final OptionalInt rows;
    private final OptionalInt columns;
    private final OptionalDouble aspectRatio;
    private final Optional<String> format;

    private JigsawInfo(Builder builder) {
        this.pieces = builder.pieces;
        this.border = builder.border;
        this.inside = builder.inside;
        this.rows = builder.rows;
        this.columns = builder.columns;
        this.aspectRatio = builder.aspectRatio;
        this.format = builder.format;
    }

    public static class Builder {
        private OptionalInt pieces = OptionalInt.empty();
        private OptionalInt border = OptionalInt.empty();
        private OptionalInt inside = OptionalInt.empty();
        private OptionalInt rows = OptionalInt.empty();
        private OptionalInt columns = OptionalInt.empty();
        private OptionalDouble aspectRatio = OptionalDouble.empty();
        private Optional<String> format = Optional.empty();

        public Builder pieces(int pieces) {
            this.pieces = OptionalInt.of(pieces);
            return this;
        }

        public Builder border(int border) {
            this.border = OptionalInt.of(border);
            return this;
        }

        public Builder inside(int inside) {
            this.inside = OptionalInt.of(inside);
            return this;
        }

        public Builder rows(int rows) {
            this.rows = OptionalInt.of(rows);
            return this;
        }

        public Builder columns(int columns) {
            this.columns = OptionalInt.of(columns);
            return this;
        }

        public Builder aspectRatio(double aspectRatio) {
            this.aspectRatio = OptionalDouble.of(aspectRatio);
            return this;
        }

        public Builder format(String format) {
            this.format = Optional.of(format);
            return this;
        }

        public JigsawInfo build() {
            return new JigsawInfo(this);
        }
    }

    public OptionalInt getPieces() {
        return pieces;
    }

    public OptionalInt getBorder() {
        return border;
    }

    public OptionalInt getInside() {
        return inside;
    }

    public OptionalInt getRows() {
        return rows;
    }

    public OptionalInt getColumns() {
        return columns;
    }

    public OptionalDouble getAspectRatio() {
        return aspectRatio;
    }

    public Optional<String> getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JigsawInfo that = (JigsawInfo) o;
        return Objects.equals(pieces, that.pieces)
                && Objects.equals(border, that.border)
                && Objects.equals(inside, that.inside)
                && Objects.equals(rows, that.rows)
                && Objects.equals(columns, that.columns)
                && Objects.equals(aspectRatio, that.aspectRatio)
                && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces, border, inside, rows, columns, aspectRatio, format);
    }

    @Override
    public String toString() {
        return "JigsawInfo{" +
                "pieces=" + pieces +
                ", border=" + border +
                ", inside=" + inside +
                ", rows=" + rows +
                ", columns=" + columns +
                ", aspectRatio=" + aspectRatio +
                ", format=" + format +
                '}';
    }
}
