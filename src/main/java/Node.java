import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {

    final private Byte row;
    final private Byte column;
    private Boolean isProvided = false;
    private Byte value;
    private Set<Byte> possibleValues = new HashSet<>();

    public Node (Byte row, Byte column) {
        this(row, column, null);
    }

    public Node (Byte row, Byte column, Byte value) {
        this.row = row;
        this.column = column;
        this.value = value;

        if (this.value != null) {
            this.isProvided = true;
        }
    }

    public Byte getRow() {
        return row;
    }

    public Byte getColumn() {
        return column;
    }

    public Boolean getProvided() {
        return isProvided;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public Set<Byte> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(Set<Byte> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return row.equals(node.row) && column.equals(node.column) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", column=" + column +
                ", value=" + value +
                '}';
    }
}
