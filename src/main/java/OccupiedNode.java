public class OccupiedNode {
    /**
     * group ranging from 1-9
     */
    private byte section;
    /**
     * row ranging from 0-8
     */
    private byte row;
    /**
     * column ranging from 0-8
     */
    private byte column;
    /**
     * value ranging from 1-9
     */
    private byte value;

    public OccupiedNode(byte section, byte row, byte column, byte value) {
        this.section = section;
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public byte getSection() {
        return section;
    }

    public byte getRow() {
        return row;
    }

    public byte getColumn() {
        return column;
    }

    public byte getValue() {
        return value;
    }
}
