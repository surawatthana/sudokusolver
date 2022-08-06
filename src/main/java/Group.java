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

    public Byte getRowIndex() {
        return rowIndex;
    }

    public Byte getColumnIndex() {
        return columnIndex;
    }

    /**
     * returning group number between 1-9
     */
    public static byte getSectionNumber(Group group) throws RuntimeException {
        validation(group);

        byte rowIndex = group.getRowIndex();
        byte columnIndex = group.getColumnIndex();

        // TODO: refactor this
        if (rowIndex >= 0 && rowIndex <= 2) {
            if (columnIndex >= 0 && columnIndex <= 2) {
                return 1;
            }
            if (columnIndex >= 3 && columnIndex <= 5) {
                return 2;
            }
            if (columnIndex >= 6 && columnIndex <= 8) {
                return 3;
            }
        }

        if (rowIndex >= 3 && rowIndex <= 5) {
            if (columnIndex >= 0 && columnIndex <= 2) {
                return 4;
            }
            if (columnIndex >= 3 && columnIndex <= 5) {
                return 5;
            }
            if (columnIndex >= 6 && columnIndex <= 8) {
                return 6;
            }
        }

        if (rowIndex >= 6 && rowIndex <= 8) {
            if (columnIndex >= 0 && columnIndex <= 2) {
                return 7;
            }
            if (columnIndex >= 3 && columnIndex <= 5) {
                return 8;
            }
            if (columnIndex >= 6 && columnIndex <= 8) {
                return 9;
            }
        }

        throw new RuntimeException("unable to determine group");

    }

    private static void validation(Group group) {
        if (group == null) {
            throw new RuntimeException("group cannot be null");
        }

        if (group.getRowIndex() == null) {
            throw new RuntimeException("row index cannot be null");
        }

        if (group.getColumnIndex() == null) {
            throw new RuntimeException("column index cannot be null");
        }
    }


}
