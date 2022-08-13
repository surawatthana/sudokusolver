import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuEngineTest {

    @Test
    public void shouldReturnCorrectResultForLevel3() {
        testOutput(expectedOutputLevel3(), new SudokuEngine().solveSudoku(initialiseInputsLevel3()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel4a() {
        testOutput(expectedOutputLevel4a(), new SudokuEngine().solveSudoku(initialiseInputsLevel4a()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel4b() {
        testOutput(expectedOutputLevel4b(), new SudokuEngine().solveSudoku(initialiseInputsLevel4b()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel4c() {
        testOutput(expectedOutputLevel4c(), new SudokuEngine().solveSudoku(initialiseInputsLevel4c()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel4d() {
        testOutput(expectedOutputLevel4d(), new SudokuEngine().solveSudoku(initialiseInputsLevel4d()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel4e() {
        testOutput(expectedOutputLevel4e(), new SudokuEngine().solveSudoku(initialiseInputsLevel4e()));
    }

    @Test
    public void shouldReturnCorrectResultForLevel5a() {
        testOutput(expectedOutputLevel5a(), new SudokuEngine().solveSudoku(initialiseInputsLevel5a()));
    }

    @Test
    public void shouldSetValueCorrectlyWhenMatchingTechniqueByRow1() {
        Node node00 = new Node((byte) 0, (byte) 0);
        Node node01 = new Node((byte) 0, (byte) 1);
        Node node02 = new Node((byte) 0, (byte) 2);
        Node node03 = new Node((byte) 0, (byte) 3);
        Node node04 = new Node((byte) 0, (byte) 4);
        Node node05 = new Node((byte) 0, (byte) 5);
        Node node06 = new Node((byte) 0, (byte) 6);
        Node node07 = new Node((byte) 0, (byte) 7);
        Node node08 = new Node((byte) 0, (byte) 8);

        node00.setPossibleValues(Set.of((byte) 3, (byte) 5));
        node01.setPossibleValues(Set.of((byte) 3, (byte) 5));
        node02.setPossibleValues(Set.of((byte) 3, (byte) 5, (byte) 8));

        Node[] node0 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node1 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node2 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node3 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node4 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node5 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node6 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node7 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node8 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[][] tableOfNodes = new Node[][]{node0, node1, node2, node3, node4, node5, node6, node7, node8};

        new SudokuEngine().matchingTechniqueByRow(tableOfNodes);

        assertTrue(tableOfNodes[0][2].getValue() == (byte) 8);
    }

    @Test
    public void shouldSetValueCorrectlyWhenMatchingTechniqueByRow2() {
        Node node00 = new Node((byte) 0, (byte) 0);
        Node node01 = new Node((byte) 0, (byte) 1);
        Node node02 = new Node((byte) 0, (byte) 2);
        Node node03 = new Node((byte) 0, (byte) 3);
        Node node04 = new Node((byte) 0, (byte) 4);
        Node node05 = new Node((byte) 0, (byte) 5);
        Node node06 = new Node((byte) 0, (byte) 6);
        Node node07 = new Node((byte) 0, (byte) 7);
        Node node08 = new Node((byte) 0, (byte) 8);

        node00.setPossibleValues(Set.of((byte) 3, (byte) 8));
        node01.setPossibleValues(Set.of((byte) 3, (byte) 8));
        node02.setPossibleValues(Set.of((byte) 3, (byte) 5));

        Node[] node0 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node1 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node2 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node3 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node4 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node5 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node6 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node7 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node8 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[][] tableOfNodes = new Node[][]{node0, node1, node2, node3, node4, node5, node6, node7, node8};

        new SudokuEngine().matchingTechniqueByRow(tableOfNodes);

        assertTrue(tableOfNodes[0][2].getValue() == (byte) 5);
    }

    @Test
    public void shouldSetValueCorrectlyWhenMatchingTechniqueByRow3() {
        Node node00 = new Node((byte) 0, (byte) 0);
        Node node01 = new Node((byte) 0, (byte) 1);
        Node node02 = new Node((byte) 0, (byte) 2);
        Node node03 = new Node((byte) 0, (byte) 3);
        Node node04 = new Node((byte) 0, (byte) 4);
        Node node05 = new Node((byte) 0, (byte) 5);
        Node node06 = new Node((byte) 0, (byte) 6);
        Node node07 = new Node((byte) 0, (byte) 7);
        Node node08 = new Node((byte) 0, (byte) 8);

        node00.setPossibleValues(Set.of((byte) 3, (byte) 6));
        node01.setPossibleValues(Set.of((byte) 3, (byte) 8));
        node02.setPossibleValues(Set.of((byte) 3, (byte) 6, (byte) 8));

        Node[] node0 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node1 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node2 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node3 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node4 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node5 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node6 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node7 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[] node8 = new Node[]{node00, node01, node02, node03, node04, node05, node06, node07, node08};
        Node[][] tableOfNodes = new Node[][]{node0, node1, node2, node3, node4, node5, node6, node7, node8};

        new SudokuEngine().matchingTechniqueByRow(tableOfNodes);

        assertTrue(tableOfNodes[0][0].getValue() == null);
        assertTrue(tableOfNodes[0][1].getValue() == null);
        assertTrue(tableOfNodes[0][2].getValue() == null);

        assertTrue(tableOfNodes[0][0].getPossibleValues().equals(Set.of((byte) 3, (byte) 6)));
        assertTrue(tableOfNodes[0][1].getPossibleValues().equals(Set.of((byte) 3, (byte) 8)));
        assertTrue(tableOfNodes[0][2].getPossibleValues().equals(Set.of((byte) 3, (byte) 6, (byte) 8)));
    }

    private Node[][] expectedOutputLevel3() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 6);
        expectedMap.put("01", (byte) 3);
        expectedMap.put("02", (byte) 2);
        expectedMap.put("03", (byte) 7);
        expectedMap.put("04", (byte) 4);
        expectedMap.put("05", (byte) 8);
        expectedMap.put("06", (byte) 9);
        expectedMap.put("07", (byte) 1);
        expectedMap.put("08", (byte) 5);

        expectedMap.put("10", (byte) 1);
        expectedMap.put("11", (byte) 8);
        expectedMap.put("12", (byte) 5);
        expectedMap.put("13", (byte) 9);
        expectedMap.put("14", (byte) 3);
        expectedMap.put("15", (byte) 6);
        expectedMap.put("16", (byte) 7);
        expectedMap.put("17", (byte) 4);
        expectedMap.put("18", (byte) 2);

        expectedMap.put("20", (byte) 4);
        expectedMap.put("21", (byte) 7);
        expectedMap.put("22", (byte) 9);
        expectedMap.put("23", (byte) 5);
        expectedMap.put("24", (byte) 2);
        expectedMap.put("25", (byte) 1);
        expectedMap.put("26", (byte) 6);
        expectedMap.put("27", (byte) 3);
        expectedMap.put("28", (byte) 8);

        expectedMap.put("30", (byte) 3);
        expectedMap.put("31", (byte) 4);
        expectedMap.put("32", (byte) 6);
        expectedMap.put("33", (byte) 2);
        expectedMap.put("34", (byte) 1);
        expectedMap.put("35", (byte) 5);
        expectedMap.put("36", (byte) 8);
        expectedMap.put("37", (byte) 9);
        expectedMap.put("38", (byte) 7);

        expectedMap.put("40", (byte) 9);
        expectedMap.put("41", (byte) 2);
        expectedMap.put("42", (byte) 8);
        expectedMap.put("43", (byte) 3);
        expectedMap.put("44", (byte) 7);
        expectedMap.put("45", (byte) 4);
        expectedMap.put("46", (byte) 5);
        expectedMap.put("47", (byte) 6);
        expectedMap.put("48", (byte) 1);

        expectedMap.put("50", (byte) 5);
        expectedMap.put("51", (byte) 1);
        expectedMap.put("52", (byte) 7);
        expectedMap.put("53", (byte) 6);
        expectedMap.put("54", (byte) 8);
        expectedMap.put("55", (byte) 9);
        expectedMap.put("56", (byte) 3);
        expectedMap.put("57", (byte) 2);
        expectedMap.put("58", (byte) 4);

        expectedMap.put("60", (byte) 8);
        expectedMap.put("61", (byte) 5);
        expectedMap.put("62", (byte) 3);
        expectedMap.put("63", (byte) 1);
        expectedMap.put("64", (byte) 6);
        expectedMap.put("65", (byte) 2);
        expectedMap.put("66", (byte) 4);
        expectedMap.put("67", (byte) 7);
        expectedMap.put("68", (byte) 9);

        expectedMap.put("70", (byte) 2);
        expectedMap.put("71", (byte) 6);
        expectedMap.put("72", (byte) 4);
        expectedMap.put("73", (byte) 8);
        expectedMap.put("74", (byte) 9);
        expectedMap.put("75", (byte) 7);
        expectedMap.put("76", (byte) 1);
        expectedMap.put("77", (byte) 5);
        expectedMap.put("78", (byte) 3);

        expectedMap.put("80", (byte) 7);
        expectedMap.put("81", (byte) 9);
        expectedMap.put("82", (byte) 1);
        expectedMap.put("83", (byte) 4);
        expectedMap.put("84", (byte) 5);
        expectedMap.put("85", (byte) 3);
        expectedMap.put("86", (byte) 2);
        expectedMap.put("87", (byte) 8);
        expectedMap.put("88", (byte) 6);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel4a() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 1);
        expectedMap.put("01", (byte) 3);
        expectedMap.put("02", (byte) 9);
        expectedMap.put("03", (byte) 6);
        expectedMap.put("04", (byte) 4);
        expectedMap.put("05", (byte) 2);
        expectedMap.put("06", (byte) 7);
        expectedMap.put("07", (byte) 8);
        expectedMap.put("08", (byte) 5);

        expectedMap.put("10", (byte) 4);
        expectedMap.put("11", (byte) 5);
        expectedMap.put("12", (byte) 6);
        expectedMap.put("13", (byte) 7);
        expectedMap.put("14", (byte) 8);
        expectedMap.put("15", (byte) 3);
        expectedMap.put("16", (byte) 9);
        expectedMap.put("17", (byte) 1);
        expectedMap.put("18", (byte) 2);

        expectedMap.put("20", (byte) 2);
        expectedMap.put("21", (byte) 8);
        expectedMap.put("22", (byte) 7);
        expectedMap.put("23", (byte) 1);
        expectedMap.put("24", (byte) 5);
        expectedMap.put("25", (byte) 9);
        expectedMap.put("26", (byte) 4);
        expectedMap.put("27", (byte) 6);
        expectedMap.put("28", (byte) 3);

        expectedMap.put("30", (byte) 7);
        expectedMap.put("31", (byte) 2);
        expectedMap.put("32", (byte) 4);
        expectedMap.put("33", (byte) 8);
        expectedMap.put("34", (byte) 6);
        expectedMap.put("35", (byte) 5);
        expectedMap.put("36", (byte) 3);
        expectedMap.put("37", (byte) 9);
        expectedMap.put("38", (byte) 1);

        expectedMap.put("40", (byte) 3);
        expectedMap.put("41", (byte) 9);
        expectedMap.put("42", (byte) 5);
        expectedMap.put("43", (byte) 2);
        expectedMap.put("44", (byte) 1);
        expectedMap.put("45", (byte) 7);
        expectedMap.put("46", (byte) 6);
        expectedMap.put("47", (byte) 4);
        expectedMap.put("48", (byte) 8);

        expectedMap.put("50", (byte) 6);
        expectedMap.put("51", (byte) 1);
        expectedMap.put("52", (byte) 8);
        expectedMap.put("53", (byte) 3);
        expectedMap.put("54", (byte) 9);
        expectedMap.put("55", (byte) 4);
        expectedMap.put("56", (byte) 5);
        expectedMap.put("57", (byte) 2);
        expectedMap.put("58", (byte) 7);

        expectedMap.put("60", (byte) 9);
        expectedMap.put("61", (byte) 4);
        expectedMap.put("62", (byte) 2);
        expectedMap.put("63", (byte) 5);
        expectedMap.put("64", (byte) 7);
        expectedMap.put("65", (byte) 1);
        expectedMap.put("66", (byte) 8);
        expectedMap.put("67", (byte) 3);
        expectedMap.put("68", (byte) 6);

        expectedMap.put("70", (byte) 8);
        expectedMap.put("71", (byte) 7);
        expectedMap.put("72", (byte) 3);
        expectedMap.put("73", (byte) 9);
        expectedMap.put("74", (byte) 2);
        expectedMap.put("75", (byte) 6);
        expectedMap.put("76", (byte) 1);
        expectedMap.put("77", (byte) 5);
        expectedMap.put("78", (byte) 4);

        expectedMap.put("80", (byte) 5);
        expectedMap.put("81", (byte) 6);
        expectedMap.put("82", (byte) 1);
        expectedMap.put("83", (byte) 4);
        expectedMap.put("84", (byte) 3);
        expectedMap.put("85", (byte) 8);
        expectedMap.put("86", (byte) 2);
        expectedMap.put("87", (byte) 7);
        expectedMap.put("88", (byte) 9);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel4b() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 3);
        expectedMap.put("01", (byte) 8);
        expectedMap.put("02", (byte) 6);
        expectedMap.put("03", (byte) 7);
        expectedMap.put("04", (byte) 9);
        expectedMap.put("05", (byte) 5);
        expectedMap.put("06", (byte) 2);
        expectedMap.put("07", (byte) 1);
        expectedMap.put("08", (byte) 4);

        expectedMap.put("10", (byte) 2);
        expectedMap.put("11", (byte) 9);
        expectedMap.put("12", (byte) 4);
        expectedMap.put("13", (byte) 3);
        expectedMap.put("14", (byte) 6);
        expectedMap.put("15", (byte) 1);
        expectedMap.put("16", (byte) 5);
        expectedMap.put("17", (byte) 8);
        expectedMap.put("18", (byte) 7);

        expectedMap.put("20", (byte) 1);
        expectedMap.put("21", (byte) 5);
        expectedMap.put("22", (byte) 7);
        expectedMap.put("23", (byte) 2);
        expectedMap.put("24", (byte) 8);
        expectedMap.put("25", (byte) 4);
        expectedMap.put("26", (byte) 9);
        expectedMap.put("27", (byte) 3);
        expectedMap.put("28", (byte) 6);

        expectedMap.put("30", (byte) 8);
        expectedMap.put("31", (byte) 7);
        expectedMap.put("32", (byte) 5);
        expectedMap.put("33", (byte) 1);
        expectedMap.put("34", (byte) 4);
        expectedMap.put("35", (byte) 9);
        expectedMap.put("36", (byte) 6);
        expectedMap.put("37", (byte) 2);
        expectedMap.put("38", (byte) 3);

        expectedMap.put("40", (byte) 9);
        expectedMap.put("41", (byte) 1);
        expectedMap.put("42", (byte) 3);
        expectedMap.put("43", (byte) 5);
        expectedMap.put("44", (byte) 2);
        expectedMap.put("45", (byte) 6);
        expectedMap.put("46", (byte) 4);
        expectedMap.put("47", (byte) 7);
        expectedMap.put("48", (byte) 8);

        expectedMap.put("50", (byte) 4);
        expectedMap.put("51", (byte) 6);
        expectedMap.put("52", (byte) 2);
        expectedMap.put("53", (byte) 8);
        expectedMap.put("54", (byte) 3);
        expectedMap.put("55", (byte) 7);
        expectedMap.put("56", (byte) 1);
        expectedMap.put("57", (byte) 5);
        expectedMap.put("58", (byte) 9);

        expectedMap.put("60", (byte) 7);
        expectedMap.put("61", (byte) 4);
        expectedMap.put("62", (byte) 8);
        expectedMap.put("63", (byte) 9);
        expectedMap.put("64", (byte) 1);
        expectedMap.put("65", (byte) 2);
        expectedMap.put("66", (byte) 3);
        expectedMap.put("67", (byte) 6);
        expectedMap.put("68", (byte) 5);

        expectedMap.put("70", (byte) 6);
        expectedMap.put("71", (byte) 3);
        expectedMap.put("72", (byte) 1);
        expectedMap.put("73", (byte) 4);
        expectedMap.put("74", (byte) 5);
        expectedMap.put("75", (byte) 8);
        expectedMap.put("76", (byte) 7);
        expectedMap.put("77", (byte) 9);
        expectedMap.put("78", (byte) 2);

        expectedMap.put("80", (byte) 5);
        expectedMap.put("81", (byte) 2);
        expectedMap.put("82", (byte) 9);
        expectedMap.put("83", (byte) 6);
        expectedMap.put("84", (byte) 7);
        expectedMap.put("85", (byte) 3);
        expectedMap.put("86", (byte) 8);
        expectedMap.put("87", (byte) 4);
        expectedMap.put("88", (byte) 1);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel4c() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 5);
        expectedMap.put("01", (byte) 8);
        expectedMap.put("02", (byte) 6);
        expectedMap.put("03", (byte) 2);
        expectedMap.put("04", (byte) 7);
        expectedMap.put("05", (byte) 1);
        expectedMap.put("06", (byte) 3);
        expectedMap.put("07", (byte) 9);
        expectedMap.put("08", (byte) 4);

        expectedMap.put("10", (byte) 9);
        expectedMap.put("11", (byte) 3);
        expectedMap.put("12", (byte) 7);
        expectedMap.put("13", (byte) 4);
        expectedMap.put("14", (byte) 6);
        expectedMap.put("15", (byte) 8);
        expectedMap.put("16", (byte) 2);
        expectedMap.put("17", (byte) 1);
        expectedMap.put("18", (byte) 5);

        expectedMap.put("20", (byte) 1);
        expectedMap.put("21", (byte) 2);
        expectedMap.put("22", (byte) 4);
        expectedMap.put("23", (byte) 3);
        expectedMap.put("24", (byte) 5);
        expectedMap.put("25", (byte) 9);
        expectedMap.put("26", (byte) 7);
        expectedMap.put("27", (byte) 6);
        expectedMap.put("28", (byte) 8);

        expectedMap.put("30", (byte) 7);
        expectedMap.put("31", (byte) 6);
        expectedMap.put("32", (byte) 9);
        expectedMap.put("33", (byte) 5);
        expectedMap.put("34", (byte) 8);
        expectedMap.put("35", (byte) 2);
        expectedMap.put("36", (byte) 4);
        expectedMap.put("37", (byte) 3);
        expectedMap.put("38", (byte) 1);

        expectedMap.put("40", (byte) 3);
        expectedMap.put("41", (byte) 4);
        expectedMap.put("42", (byte) 2);
        expectedMap.put("43", (byte) 6);
        expectedMap.put("44", (byte) 1);
        expectedMap.put("45", (byte) 7);
        expectedMap.put("46", (byte) 8);
        expectedMap.put("47", (byte) 5);
        expectedMap.put("48", (byte) 9);

        expectedMap.put("50", (byte) 8);
        expectedMap.put("51", (byte) 1);
        expectedMap.put("52", (byte) 5);
        expectedMap.put("53", (byte) 9);
        expectedMap.put("54", (byte) 3);
        expectedMap.put("55", (byte) 4);
        expectedMap.put("56", (byte) 6);
        expectedMap.put("57", (byte) 2);
        expectedMap.put("58", (byte) 7);

        expectedMap.put("60", (byte) 2);
        expectedMap.put("61", (byte) 7);
        expectedMap.put("62", (byte) 3);
        expectedMap.put("63", (byte) 8);
        expectedMap.put("64", (byte) 9);
        expectedMap.put("65", (byte) 5);
        expectedMap.put("66", (byte) 1);
        expectedMap.put("67", (byte) 4);
        expectedMap.put("68", (byte) 6);

        expectedMap.put("70", (byte) 6);
        expectedMap.put("71", (byte) 5);
        expectedMap.put("72", (byte) 8);
        expectedMap.put("73", (byte) 1);
        expectedMap.put("74", (byte) 4);
        expectedMap.put("75", (byte) 3);
        expectedMap.put("76", (byte) 9);
        expectedMap.put("77", (byte) 7);
        expectedMap.put("78", (byte) 2);

        expectedMap.put("80", (byte) 4);
        expectedMap.put("81", (byte) 9);
        expectedMap.put("82", (byte) 1);
        expectedMap.put("83", (byte) 7);
        expectedMap.put("84", (byte) 2);
        expectedMap.put("85", (byte) 6);
        expectedMap.put("86", (byte) 5);
        expectedMap.put("87", (byte) 8);
        expectedMap.put("88", (byte) 3);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel4d() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 2);
        expectedMap.put("01", (byte) 5);
        expectedMap.put("02", (byte) 1);
        expectedMap.put("03", (byte) 4);
        expectedMap.put("04", (byte) 9);
        expectedMap.put("05", (byte) 8);
        expectedMap.put("06", (byte) 3);
        expectedMap.put("07", (byte) 7);
        expectedMap.put("08", (byte) 6);

        expectedMap.put("10", (byte) 6);
        expectedMap.put("11", (byte) 4);
        expectedMap.put("12", (byte) 7);
        expectedMap.put("13", (byte) 3);
        expectedMap.put("14", (byte) 5);
        expectedMap.put("15", (byte) 1);
        expectedMap.put("16", (byte) 2);
        expectedMap.put("17", (byte) 8);
        expectedMap.put("18", (byte) 9);

        expectedMap.put("20", (byte) 8);
        expectedMap.put("21", (byte) 3);
        expectedMap.put("22", (byte) 9);
        expectedMap.put("23", (byte) 2);
        expectedMap.put("24", (byte) 7);
        expectedMap.put("25", (byte) 6);
        expectedMap.put("26", (byte) 4);
        expectedMap.put("27", (byte) 1);
        expectedMap.put("28", (byte) 5);

        expectedMap.put("30", (byte) 4);
        expectedMap.put("31", (byte) 1);
        expectedMap.put("32", (byte) 6);
        expectedMap.put("33", (byte) 8);
        expectedMap.put("34", (byte) 3);
        expectedMap.put("35", (byte) 9);
        expectedMap.put("36", (byte) 7);
        expectedMap.put("37", (byte) 5);
        expectedMap.put("38", (byte) 2);

        expectedMap.put("40", (byte) 7);
        expectedMap.put("41", (byte) 8);
        expectedMap.put("42", (byte) 2);
        expectedMap.put("43", (byte) 6);
        expectedMap.put("44", (byte) 1);
        expectedMap.put("45", (byte) 5);
        expectedMap.put("46", (byte) 9);
        expectedMap.put("47", (byte) 3);
        expectedMap.put("48", (byte) 4);

        expectedMap.put("50", (byte) 3);
        expectedMap.put("51", (byte) 9);
        expectedMap.put("52", (byte) 5);
        expectedMap.put("53", (byte) 7);
        expectedMap.put("54", (byte) 2);
        expectedMap.put("55", (byte) 4);
        expectedMap.put("56", (byte) 8);
        expectedMap.put("57", (byte) 6);
        expectedMap.put("58", (byte) 1);

        expectedMap.put("60", (byte) 5);
        expectedMap.put("61", (byte) 2);
        expectedMap.put("62", (byte) 4);
        expectedMap.put("63", (byte) 1);
        expectedMap.put("64", (byte) 8);
        expectedMap.put("65", (byte) 7);
        expectedMap.put("66", (byte) 6);
        expectedMap.put("67", (byte) 9);
        expectedMap.put("68", (byte) 3);

        expectedMap.put("70", (byte) 9);
        expectedMap.put("71", (byte) 6);
        expectedMap.put("72", (byte) 8);
        expectedMap.put("73", (byte) 5);
        expectedMap.put("74", (byte) 4);
        expectedMap.put("75", (byte) 3);
        expectedMap.put("76", (byte) 1);
        expectedMap.put("77", (byte) 2);
        expectedMap.put("78", (byte) 7);

        expectedMap.put("80", (byte) 1);
        expectedMap.put("81", (byte) 7);
        expectedMap.put("82", (byte) 3);
        expectedMap.put("83", (byte) 9);
        expectedMap.put("84", (byte) 6);
        expectedMap.put("85", (byte) 2);
        expectedMap.put("86", (byte) 5);
        expectedMap.put("87", (byte) 4);
        expectedMap.put("88", (byte) 8);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel4e() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 2);
        expectedMap.put("01", (byte) 4);
        expectedMap.put("02", (byte) 9);
        expectedMap.put("03", (byte) 1);
        expectedMap.put("04", (byte) 6);
        expectedMap.put("05", (byte) 3);
        expectedMap.put("06", (byte) 8);
        expectedMap.put("07", (byte) 5);
        expectedMap.put("08", (byte) 7);

        expectedMap.put("10", (byte) 6);
        expectedMap.put("11", (byte) 8);
        expectedMap.put("12", (byte) 1);
        expectedMap.put("13", (byte) 4);
        expectedMap.put("14", (byte) 5);
        expectedMap.put("15", (byte) 7);
        expectedMap.put("16", (byte) 9);
        expectedMap.put("17", (byte) 3);
        expectedMap.put("18", (byte) 2);

        expectedMap.put("20", (byte) 7);
        expectedMap.put("21", (byte) 3);
        expectedMap.put("22", (byte) 5);
        expectedMap.put("23", (byte) 9);
        expectedMap.put("24", (byte) 8);
        expectedMap.put("25", (byte) 2);
        expectedMap.put("26", (byte) 4);
        expectedMap.put("27", (byte) 1);
        expectedMap.put("28", (byte) 6);

        expectedMap.put("30", (byte) 9);
        expectedMap.put("31", (byte) 1);
        expectedMap.put("32", (byte) 6);
        expectedMap.put("33", (byte) 5);
        expectedMap.put("34", (byte) 2);
        expectedMap.put("35", (byte) 8);
        expectedMap.put("36", (byte) 7);
        expectedMap.put("37", (byte) 4);
        expectedMap.put("38", (byte) 3);

        expectedMap.put("40", (byte) 8);
        expectedMap.put("41", (byte) 7);
        expectedMap.put("42", (byte) 2);
        expectedMap.put("43", (byte) 3);
        expectedMap.put("44", (byte) 4);
        expectedMap.put("45", (byte) 9);
        expectedMap.put("46", (byte) 1);
        expectedMap.put("47", (byte) 6);
        expectedMap.put("48", (byte) 5);

        expectedMap.put("50", (byte) 4);
        expectedMap.put("51", (byte) 5);
        expectedMap.put("52", (byte) 3);
        expectedMap.put("53", (byte) 7);
        expectedMap.put("54", (byte) 1);
        expectedMap.put("55", (byte) 6);
        expectedMap.put("56", (byte) 2);
        expectedMap.put("57", (byte) 9);
        expectedMap.put("58", (byte) 8);

        expectedMap.put("60", (byte) 3);
        expectedMap.put("61", (byte) 6);
        expectedMap.put("62", (byte) 8);
        expectedMap.put("63", (byte) 2);
        expectedMap.put("64", (byte) 9);
        expectedMap.put("65", (byte) 4);
        expectedMap.put("66", (byte) 5);
        expectedMap.put("67", (byte) 7);
        expectedMap.put("68", (byte) 1);

        expectedMap.put("70", (byte) 1);
        expectedMap.put("71", (byte) 9);
        expectedMap.put("72", (byte) 7);
        expectedMap.put("73", (byte) 8);
        expectedMap.put("74", (byte) 3);
        expectedMap.put("75", (byte) 5);
        expectedMap.put("76", (byte) 6);
        expectedMap.put("77", (byte) 2);
        expectedMap.put("78", (byte) 4);

        expectedMap.put("80", (byte) 5);
        expectedMap.put("81", (byte) 2);
        expectedMap.put("82", (byte) 4);
        expectedMap.put("83", (byte) 6);
        expectedMap.put("84", (byte) 7);
        expectedMap.put("85", (byte) 1);
        expectedMap.put("86", (byte) 3);
        expectedMap.put("87", (byte) 8);
        expectedMap.put("88", (byte) 9);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] expectedOutputLevel5a() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 3);
        expectedMap.put("01", (byte) 5);
        expectedMap.put("02", (byte) 2);
        expectedMap.put("03", (byte) 9);
        expectedMap.put("04", (byte) 8);
        expectedMap.put("05", (byte) 6);
        expectedMap.put("06", (byte) 4);
        expectedMap.put("07", (byte) 7);
        expectedMap.put("08", (byte) 1);

        expectedMap.put("10", (byte) 4);
        expectedMap.put("11", (byte) 6);
        expectedMap.put("12", (byte) 7);
        expectedMap.put("13", (byte) 5);
        expectedMap.put("14", (byte) 2);
        expectedMap.put("15", (byte) 1);
        expectedMap.put("16", (byte) 8);
        expectedMap.put("17", (byte) 3);
        expectedMap.put("18", (byte) 9);

        expectedMap.put("20", (byte) 8);
        expectedMap.put("21", (byte) 9);
        expectedMap.put("22", (byte) 1);
        expectedMap.put("23", (byte) 7);
        expectedMap.put("24", (byte) 4);
        expectedMap.put("25", (byte) 3);
        expectedMap.put("26", (byte) 2);
        expectedMap.put("27", (byte) 5);
        expectedMap.put("28", (byte) 6);

        expectedMap.put("30", (byte) 5);
        expectedMap.put("31", (byte) 8);
        expectedMap.put("32", (byte) 4);
        expectedMap.put("33", (byte) 3);
        expectedMap.put("34", (byte) 6);
        expectedMap.put("35", (byte) 7);
        expectedMap.put("36", (byte) 1);
        expectedMap.put("37", (byte) 9);
        expectedMap.put("38", (byte) 2);

        expectedMap.put("40", (byte) 6);
        expectedMap.put("41", (byte) 1);
        expectedMap.put("42", (byte) 9);
        expectedMap.put("43", (byte) 8);
        expectedMap.put("44", (byte) 5);
        expectedMap.put("45", (byte) 2);
        expectedMap.put("46", (byte) 3);
        expectedMap.put("47", (byte) 4);
        expectedMap.put("48", (byte) 7);

        expectedMap.put("50", (byte) 7);
        expectedMap.put("51", (byte) 2);
        expectedMap.put("52", (byte) 3);
        expectedMap.put("53", (byte) 4);
        expectedMap.put("54", (byte) 1);
        expectedMap.put("55", (byte) 9);
        expectedMap.put("56", (byte) 6);
        expectedMap.put("57", (byte) 8);
        expectedMap.put("58", (byte) 5);

        expectedMap.put("60", (byte) 2);
        expectedMap.put("61", (byte) 3);
        expectedMap.put("62", (byte) 5);
        expectedMap.put("63", (byte) 1);
        expectedMap.put("64", (byte) 7);
        expectedMap.put("65", (byte) 8);
        expectedMap.put("66", (byte) 9);
        expectedMap.put("67", (byte) 6);
        expectedMap.put("68", (byte) 4);

        expectedMap.put("70", (byte) 9);
        expectedMap.put("71", (byte) 4);
        expectedMap.put("72", (byte) 6);
        expectedMap.put("73", (byte) 2);
        expectedMap.put("74", (byte) 3);
        expectedMap.put("75", (byte) 5);
        expectedMap.put("76", (byte) 7);
        expectedMap.put("77", (byte) 1);
        expectedMap.put("78", (byte) 8);

        expectedMap.put("80", (byte) 1);
        expectedMap.put("81", (byte) 7);
        expectedMap.put("82", (byte) 8);
        expectedMap.put("83", (byte) 6);
        expectedMap.put("84", (byte) 9);
        expectedMap.put("85", (byte) 4);
        expectedMap.put("86", (byte) 5);
        expectedMap.put("87", (byte) 2);
        expectedMap.put("88", (byte) 3);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] initialiseInputsLevel4c() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("01", (byte) 8);
        expectedMap.put("02", (byte) 6);
        expectedMap.put("03", (byte) 2);
        expectedMap.put("07", (byte) 9);

        expectedMap.put("10", (byte) 9);
        expectedMap.put("11", (byte) 3);
        expectedMap.put("12", (byte) 7);
        expectedMap.put("14", (byte) 6);
        expectedMap.put("18", (byte) 5);

        expectedMap.put("25", (byte) 9);
        expectedMap.put("28", (byte) 8);

        expectedMap.put("30", (byte) 7);
        expectedMap.put("36", (byte) 4);
        expectedMap.put("38", (byte) 1);

        expectedMap.put("42", (byte) 2);
        expectedMap.put("43", (byte) 6);
        expectedMap.put("44", (byte) 1);

        expectedMap.put("52", (byte) 5);
        expectedMap.put("55", (byte) 4);
        expectedMap.put("57", (byte) 2);

        expectedMap.put("62", (byte) 3);
        expectedMap.put("63", (byte) 8);
        expectedMap.put("68", (byte) 6);

        expectedMap.put("72", (byte) 8);
        expectedMap.put("73", (byte) 1);
        expectedMap.put("74", (byte) 4);

        expectedMap.put("82", (byte) 1);
        expectedMap.put("83", (byte) 7);
        expectedMap.put("84", (byte) 2);
        expectedMap.put("86", (byte) 5);
        expectedMap.put("88", (byte) 3);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] initialiseInputsLevel4d() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("05", (byte) 8);
        expectedMap.put("07", (byte) 7);
        expectedMap.put("08", (byte) 6);

        expectedMap.put("13", (byte) 3);
        expectedMap.put("14", (byte) 5);
        expectedMap.put("18", (byte) 9);

        expectedMap.put("20", (byte) 8);
        expectedMap.put("22", (byte) 9);
        expectedMap.put("23", (byte) 2);

        expectedMap.put("30", (byte) 4);
        expectedMap.put("32", (byte) 6);
        expectedMap.put("33", (byte) 8);
        expectedMap.put("35", (byte) 9);
        expectedMap.put("36", (byte) 7);

        expectedMap.put("43", (byte) 6);
        expectedMap.put("44", (byte) 1);
        expectedMap.put("48", (byte) 4);

        expectedMap.put("51", (byte) 9);
        expectedMap.put("52", (byte) 5);
        expectedMap.put("54", (byte) 2);
        expectedMap.put("55", (byte) 4);
        expectedMap.put("56", (byte) 8);

        expectedMap.put("60", (byte) 5);
        expectedMap.put("61", (byte) 2);
        expectedMap.put("62", (byte) 4);
        expectedMap.put("65", (byte) 7);
        expectedMap.put("68", (byte) 3);

        expectedMap.put("71", (byte) 6);
        expectedMap.put("75", (byte) 3);
        expectedMap.put("76", (byte) 1);

        expectedMap.put("81", (byte) 7);
        expectedMap.put("84", (byte) 6);
        expectedMap.put("86", (byte) 5);
        expectedMap.put("87", (byte) 4);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] initialiseInputsLevel3() {
        Map<String, Byte> map = new HashMap<>();

        map.put("00", (byte) 6);
        map.put("01", (byte) 3);
        map.put("02", (byte) 2);
        map.put("05", (byte) 8);
        map.put("06", (byte) 9);

        map.put("10", (byte) 1);
        map.put("13", (byte) 9);
        map.put("14", (byte) 3);
        map.put("16", (byte) 7);
        map.put("17", (byte) 4);

        map.put("20", (byte) 4);
        map.put("21", (byte) 7);
        map.put("25", (byte) 1);
        map.put("26", (byte) 6);

        map.put("32", (byte) 6);
        map.put("34", (byte) 1);
        map.put("38", (byte) 7);

        map.put("40", (byte) 9);
        map.put("41", (byte) 2);
        map.put("43", (byte) 3);
        map.put("44", (byte) 7);
        map.put("46", (byte) 5);
        map.put("47", (byte) 6);

        map.put("50", (byte) 5);
        map.put("52", (byte) 7);
        map.put("57", (byte) 2);

        map.put("61", (byte) 5);
        map.put("62", (byte) 3);
        map.put("63", (byte) 1);
        map.put("67", (byte) 7);

        map.put("70", (byte) 2);
        map.put("73", (byte) 8);
        map.put("74", (byte) 9);

        map.put("83", (byte) 4);
        map.put("84", (byte) 5);
        map.put("85", (byte) 3);
        map.put("86", (byte) 2);
        map.put("88", (byte) 6);

        Node[][] inputTable = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                inputTable[i][j] = (map.get(i + "" + j) != null) ? new Node(i, j, map.get(i + "" + j)) : new Node(i, j);
            }
        }
        return inputTable;
    }

    private Node[][] initialiseInputsLevel4a() {
        Map<String, Byte> map = new HashMap<>();

        map.put("01", (byte) 3);
        map.put("03", (byte) 6);
        map.put("05", (byte) 2);
        map.put("06", (byte) 7);

        map.put("12", (byte) 6);
        map.put("14", (byte) 8);
        map.put("15", (byte) 3);
        map.put("16", (byte) 9);
        map.put("17", (byte) 1);

        map.put("21", (byte) 8);
        map.put("23", (byte) 1);
        map.put("24", (byte) 5);
        map.put("26", (byte) 4);
        map.put("28", (byte) 3);

        map.put("32", (byte) 4);
        map.put("35", (byte) 5);
        map.put("37", (byte) 9);

        map.put("44", (byte) 1);
        map.put("46", (byte) 6);

        map.put("50", (byte) 6);
        map.put("51", (byte) 1);
        map.put("55", (byte) 4);
        map.put("57", (byte) 2);
        map.put("58", (byte) 7);

        map.put("62", (byte) 2);
        map.put("64", (byte) 7);
        map.put("65", (byte) 1);
        map.put("67", (byte) 3);
        map.put("68", (byte) 6);

        map.put("70", (byte) 8);
        map.put("71", (byte) 7);
        map.put("73", (byte) 9);
        map.put("76", (byte) 1);
        map.put("77", (byte) 5);

        map.put("80", (byte) 5);
        map.put("84", (byte) 3);

        Node[][] inputTable = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                inputTable[i][j] = (map.get(i + "" + j) != null) ? new Node(i, j, map.get(i + "" + j)) : new Node(i, j);
            }
        }
        return inputTable;
    }

    private Node[][] initialiseInputsLevel4b() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("00", (byte) 3);
        expectedMap.put("01", (byte) 8);
        expectedMap.put("07", (byte) 1);
        expectedMap.put("08", (byte) 4);

        expectedMap.put("10", (byte) 2);
        expectedMap.put("11", (byte) 9);
        expectedMap.put("16", (byte) 5);
        expectedMap.put("18", (byte) 7);

        expectedMap.put("20", (byte) 1);
        expectedMap.put("23", (byte) 2);
        expectedMap.put("27", (byte) 3);

        expectedMap.put("31", (byte) 7);
        expectedMap.put("37", (byte) 2);

        expectedMap.put("40", (byte) 9);
        expectedMap.put("41", (byte) 1);
        expectedMap.put("42", (byte) 3);
        expectedMap.put("43", (byte) 5);

        expectedMap.put("50", (byte) 4);
        expectedMap.put("54", (byte) 3);
        expectedMap.put("55", (byte) 7);
        expectedMap.put("56", (byte) 1);
        expectedMap.put("57", (byte) 5);

        expectedMap.put("60", (byte) 7);
        expectedMap.put("62", (byte) 8);
        expectedMap.put("64", (byte) 1);
        expectedMap.put("67", (byte) 6);

        expectedMap.put("71", (byte) 3);
        expectedMap.put("74", (byte) 5);

        expectedMap.put("81", (byte) 2);
        expectedMap.put("84", (byte) 7);
        expectedMap.put("87", (byte) 4);

        Node[][] inputTable = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                inputTable[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return inputTable;
    }

    private Node[][] initialiseInputsLevel4e() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("01", (byte) 4);

        expectedMap.put("11", (byte) 8);
        expectedMap.put("14", (byte) 5);
        expectedMap.put("15", (byte) 7);
        expectedMap.put("18", (byte) 2);

        expectedMap.put("20", (byte) 7);
        expectedMap.put("23", (byte) 9);
        expectedMap.put("24", (byte) 8);
        expectedMap.put("26", (byte) 4);

        expectedMap.put("30", (byte) 9);
        expectedMap.put("32", (byte) 6);
        expectedMap.put("33", (byte) 5);
        expectedMap.put("35", (byte) 8);
        expectedMap.put("36", (byte) 7);

        expectedMap.put("46", (byte) 1);
        expectedMap.put("47", (byte) 6);

        expectedMap.put("50", (byte) 4);
        expectedMap.put("52", (byte) 3);
        expectedMap.put("54", (byte) 1);
        expectedMap.put("56", (byte) 2);
        expectedMap.put("57", (byte) 9);

        expectedMap.put("60", (byte) 3);
        expectedMap.put("61", (byte) 6);
        expectedMap.put("63", (byte) 2);
        expectedMap.put("64", (byte) 9);
        expectedMap.put("65", (byte) 4);
        expectedMap.put("66", (byte) 5);
        expectedMap.put("67", (byte) 7);
        expectedMap.put("68", (byte) 1);

        expectedMap.put("71", (byte) 9);
        expectedMap.put("75", (byte) 5);
        expectedMap.put("76", (byte) 6);

        expectedMap.put("80", (byte) 5);
        expectedMap.put("81", (byte) 2);
        expectedMap.put("82", (byte) 4);
        expectedMap.put("87", (byte) 8);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }

    private Node[][] initialiseInputsLevel5a() {
        Map<String, Byte> expectedMap = new HashMap<>();
        expectedMap.put("01", (byte) 5);
        expectedMap.put("06", (byte) 4);
        expectedMap.put("07", (byte) 7);
        expectedMap.put("08", (byte) 1);

        expectedMap.put("11", (byte) 6);
        expectedMap.put("14", (byte) 2);

        expectedMap.put("23", (byte) 7);
        expectedMap.put("27", (byte) 5);

        expectedMap.put("30", (byte) 5);
        expectedMap.put("36", (byte) 1);
        expectedMap.put("38", (byte) 2);

        expectedMap.put("41", (byte) 1);
        expectedMap.put("42", (byte) 9);
        expectedMap.put("45", (byte) 2);

        expectedMap.put("53", (byte) 4);
        expectedMap.put("55", (byte) 9);

        expectedMap.put("60", (byte) 2);
        expectedMap.put("61", (byte) 3);
        expectedMap.put("65", (byte) 8);
        expectedMap.put("66", (byte) 9);
        expectedMap.put("67", (byte) 6);

        expectedMap.put("70", (byte) 9);
        expectedMap.put("71", (byte) 4);
        expectedMap.put("72", (byte) 6);

        expectedMap.put("80", (byte) 1);
        expectedMap.put("85", (byte) 4);
        expectedMap.put("86", (byte) 5);

        Node[][] expectedResult = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                expectedResult[i][j] = (expectedMap.get(i + "" + j) != null) ? new Node(i, j, expectedMap.get(i + "" + j)) : new Node(i, j);
            }
        }
        return expectedResult;
    }
    private void testOutput(Node[][] expectedResult, Node[][] actualResult) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 ; j++) {
                assertEquals(expectedResult[i][j], actualResult[i][j]);
            }
        }
    }
}
