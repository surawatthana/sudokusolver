import java.util.Set;

public class Group {
    private Byte rowIndex, columnIndex;

    final private static Range
            groupBeginRow = new Range((byte) 0, (byte) 2),
            groupMidRow = new Range((byte) 3, (byte) 5),
            groupEndRow = new Range((byte) 6, (byte) 8);

    final private static Range
            groupBeginColumn = new Range((byte) 0, (byte) 2),
            groupMidColumn = new Range((byte) 3, (byte) 5),
            groupEndColumn = new Range((byte) 6, (byte) 8);

    public Group(Byte rowIndex, Byte columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Range getRowRange() throws RuntimeException {
        if (rowIndex >= groupBeginRow.getMIN() && rowIndex <= groupBeginRow.getMAX()) {
            return groupBeginRow;
        }
        if (rowIndex >= groupMidRow.getMIN() && rowIndex <= groupMidRow.getMAX()) {
            return groupMidRow;
        }
        if (rowIndex >= groupEndRow.getMIN() && rowIndex <= groupEndRow.getMAX()) {
            return groupEndRow;
        }
        throw new RuntimeException("Row out of range");
    }

    public Range getColumnRange() throws RuntimeException {
        if (columnIndex >= groupBeginColumn.getMIN() && columnIndex <= groupBeginColumn.getMAX()) {
            return groupBeginColumn;
        }
        if (columnIndex >= groupMidColumn.getMIN() && columnIndex <= groupMidColumn.getMAX()) {
            return groupMidColumn;
        }
        if (columnIndex >= groupEndColumn.getMIN() && columnIndex <= groupEndColumn.getMAX()) {
            return groupEndColumn;
        }
        throw new RuntimeException("Column out of range");
    }


}
