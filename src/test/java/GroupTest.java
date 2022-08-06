import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    final private static Range
            groupBeginRow = new Range((byte) 0, (byte) 2),
            groupMidRow = new Range((byte) 3, (byte) 5),
            groupEndRow = new Range((byte) 6, (byte) 8);

    final private static Range
            groupBeginColumn = new Range((byte) 0, (byte) 2),
            groupMidColumn = new Range((byte) 3, (byte) 5),
            groupEndColumn = new Range((byte) 6, (byte) 8);

    @Test
    public void shouldReturnCorrectRangeForSection1() {
        section1(new Group((byte) 0, (byte) 0));

        section1(new Group((byte) 0, (byte) 1));

        section1(new Group((byte) 0, (byte) 2));

        section1(new Group((byte) 1, (byte) 0));

        section1(new Group((byte) 1, (byte) 1));

        section1(new Group((byte) 1, (byte) 2));

        section1(new Group((byte) 2, (byte) 0));

        section1(new Group((byte) 2, (byte) 1));

        section1(new Group((byte) 2, (byte) 2));
    }

    @Test
    public void shouldReturnCorrectRangeForSection2() {
        section2(new Group((byte) 0, (byte) 3));

        section2(new Group((byte) 0, (byte) 4));

        section2(new Group((byte) 0, (byte) 5));

        section2(new Group((byte) 1, (byte) 3));

        section2(new Group((byte) 1, (byte) 4));

        section2(new Group((byte) 1, (byte) 5));

        section2(new Group((byte) 2, (byte) 3));

        section2(new Group((byte) 2, (byte) 4));

        section2(new Group((byte) 2, (byte) 5));
    }

    @Test
    public void shouldReturnCorrectRangeForSection3() {
        section3(new Group((byte) 0, (byte) 6));

        section3(new Group((byte) 0, (byte) 7));

        section3(new Group((byte) 0, (byte) 8));

        section3(new Group((byte) 1, (byte) 6));

        section3(new Group((byte) 1, (byte) 7));

        section3(new Group((byte) 1, (byte) 8));

        section3(new Group((byte) 2, (byte) 6));

        section3(new Group((byte) 2, (byte) 7));

        section3(new Group((byte) 2, (byte) 8));
    }

    @Test
    public void shouldReturnCorrectRangeForSection4() {
        section4(new Group((byte) 3, (byte) 0));

        section4(new Group((byte) 3, (byte) 1));

        section4(new Group((byte) 3, (byte) 2));

        section4(new Group((byte) 4, (byte) 0));

        section4(new Group((byte) 4, (byte) 1));

        section4(new Group((byte) 4, (byte) 2));

        section4(new Group((byte) 5, (byte) 0));

        section4(new Group((byte) 5, (byte) 1));

        section4(new Group((byte) 5, (byte) 2));
    }

    @Test
    public void shouldReturnCorrectRangeForSection5() {
        section5(new Group((byte) 3, (byte) 3));

        section5(new Group((byte) 3, (byte) 4));

        section5(new Group((byte) 3, (byte) 5));

        section5(new Group((byte) 4, (byte) 3));

        section5(new Group((byte) 4, (byte) 4));

        section5(new Group((byte) 4, (byte) 5));

        section5(new Group((byte) 5, (byte) 3));

        section5(new Group((byte) 5, (byte) 4));

        section5(new Group((byte) 5, (byte) 5));
    }

    @Test
    public void shouldReturnCorrectRangeForSection6() {
        section6(new Group((byte) 3, (byte) 6));

        section6(new Group((byte) 3, (byte) 7));

        section6(new Group((byte) 3, (byte) 8));

        section6(new Group((byte) 4, (byte) 6));

        section6(new Group((byte) 4, (byte) 7));

        section6(new Group((byte) 4, (byte) 8));

        section6(new Group((byte) 5, (byte) 6));

        section6(new Group((byte) 5, (byte) 7));

        section6(new Group((byte) 5, (byte) 8));
    }

    @Test
    public void shouldReturnCorrectRangeForSection7() {
        section7(new Group((byte) 6, (byte) 0));

        section7(new Group((byte) 6, (byte) 1));

        section7(new Group((byte) 6, (byte) 2));

        section7(new Group((byte) 7, (byte) 0));

        section7(new Group((byte) 7, (byte) 1));

        section7(new Group((byte) 7, (byte) 2));

        section7(new Group((byte) 8, (byte) 0));

        section7(new Group((byte) 8, (byte) 1));

        section7(new Group((byte) 8, (byte) 2));
    }

    @Test
    public void shouldReturnCorrectSection() {
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 0, (byte) 0)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 0, (byte) 1)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 0, (byte) 2)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 1, (byte) 0)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 1, (byte) 1)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 1, (byte) 2)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 2, (byte) 0)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 2, (byte) 1)));
        assertEquals((byte) 1,  Group.getSectionNumber(new Group((byte) 2, (byte) 2)));

        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 0, (byte) 3)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 0, (byte) 4)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 0, (byte) 5)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 1, (byte) 3)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 1, (byte) 4)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 1, (byte) 5)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 2, (byte) 3)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 2, (byte) 4)));
        assertEquals((byte) 2,  Group.getSectionNumber(new Group((byte) 2, (byte) 5)));

        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 0, (byte) 6)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 0, (byte) 7)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 0, (byte) 8)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 1, (byte) 6)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 1, (byte) 7)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 1, (byte) 8)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 2, (byte) 6)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 2, (byte) 7)));
        assertEquals((byte) 3,  Group.getSectionNumber(new Group((byte) 2, (byte) 8)));
  // ---------------------------------------------------------------------------------- //
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 3, (byte) 0)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 3, (byte) 1)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 3, (byte) 2)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 4, (byte) 0)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 4, (byte) 1)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 4, (byte) 2)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 5, (byte) 0)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 5, (byte) 1)));
        assertEquals((byte) 4,  Group.getSectionNumber(new Group((byte) 5, (byte) 2)));

        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 3, (byte) 3)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 3, (byte) 4)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 3, (byte) 5)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 4, (byte) 3)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 4, (byte) 4)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 4, (byte) 5)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 5, (byte) 3)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 5, (byte) 4)));
        assertEquals((byte) 5,  Group.getSectionNumber(new Group((byte) 5, (byte) 5)));

        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 3, (byte) 6)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 3, (byte) 7)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 3, (byte) 8)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 4, (byte) 6)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 4, (byte) 7)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 4, (byte) 8)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 5, (byte) 6)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 5, (byte) 7)));
        assertEquals((byte) 6,  Group.getSectionNumber(new Group((byte) 5, (byte) 8)));
  // ---------------------------------------------------------------------------------- //
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 6, (byte) 0)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 6, (byte) 1)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 6, (byte) 2)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 7, (byte) 0)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 7, (byte) 1)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 7, (byte) 2)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 8, (byte) 0)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 8, (byte) 1)));
        assertEquals((byte) 7,  Group.getSectionNumber(new Group((byte) 8, (byte) 2)));

        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 6, (byte) 3)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 6, (byte) 4)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 6, (byte) 5)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 7, (byte) 3)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 7, (byte) 4)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 7, (byte) 5)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 8, (byte) 3)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 8, (byte) 4)));
        assertEquals((byte) 8,  Group.getSectionNumber(new Group((byte) 8, (byte) 5)));

        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 6, (byte) 6)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 6, (byte) 7)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 6, (byte) 8)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 7, (byte) 6)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 7, (byte) 7)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 7, (byte) 8)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 8, (byte) 6)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 8, (byte) 7)));
        assertEquals((byte) 9,  Group.getSectionNumber(new Group((byte) 8, (byte) 8)));
    }

    private void section1(Group group) {
        assertEquals(groupBeginRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupBeginRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupBeginColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupBeginColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section2(Group group) {
        assertEquals(groupBeginRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupBeginRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupMidColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupMidColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section3(Group group) {
        assertEquals(groupBeginRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupBeginRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupEndColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupEndColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section4(Group group) {
        assertEquals(groupMidRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupMidRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupBeginColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupBeginColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section5(Group group) {
        assertEquals(groupMidRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupMidRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupMidColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupMidColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section6(Group group) {
        assertEquals(groupMidRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupMidRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupEndColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupEndColumn.getMAX(),  group.getColumnRange().getMAX());
    }

    private void section7(Group group) {
        assertEquals(groupEndRow.getMIN(),  group.getRowRange().getMIN());
        assertEquals(groupEndRow.getMAX(),  group.getRowRange().getMAX());
        assertEquals(groupBeginColumn.getMIN(),  group.getColumnRange().getMIN());
        assertEquals(groupBeginColumn.getMAX(),  group.getColumnRange().getMAX());
    }
}
