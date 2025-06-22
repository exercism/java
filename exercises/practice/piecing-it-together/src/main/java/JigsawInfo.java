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
        this.pieces = builder.pieces != null ? OptionalInt.of(builder.pieces) : OptionalInt.empty();
        this.border = builder.border != null ? OptionalInt.of(builder.border) : OptionalInt.empty();
        this.inside = builder.inside != null ? OptionalInt.of(builder.inside) : OptionalInt.empty();
        this.rows = builder.rows != null ? OptionalInt.of(builder.rows) : OptionalInt.empty();
        this.columns = builder.columns != null ? OptionalInt.of(builder.columns) : OptionalInt.empty();
        this.aspectRatio = builder.aspectRatio != null ? OptionalDouble.of(builder.aspectRatio) : OptionalDouble.empty();
        this.format = Optional.ofNullable(builder.format);
    }

    public static class Builder {
        private Integer pieces;
        private Integer border;
        private Integer inside;
        private Integer rows;
        private Integer columns;
        private Double aspectRatio;
        private String format;

        public Builder pieces(Integer pieces) {
            this.pieces = pieces;
            return this;
        }

        public Builder border(Integer border) {
            this.border = border;
            return this;
        }

        public Builder inside(Integer inside) {
            this.inside = inside;
            return this;
        }

        public Builder rows(Integer rows) {
            this.rows = rows;
            return this;
        }

        public Builder columns(Integer columns) {
            this.columns = columns;
            return this;
        }

        public Builder aspectRatio(Double aspectRatio) {
            this.aspectRatio = aspectRatio;
            return this;
        }

        public Builder format(String format) {
            this.format = format;
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
        if (o == null || getClass() != o.getClass()) return false;
        JigsawInfo that = (JigsawInfo) o;
        return Objects.equals(pieces, that.pieces) && Objects.equals(border, that.border) && Objects.equals(inside, that.inside) && Objects.equals(rows, that.rows) && Objects.equals(columns, that.columns) && Objects.equals(aspectRatio, that.aspectRatio) && Objects.equals(format, that.format);
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
