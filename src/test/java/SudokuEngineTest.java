import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private void testOutput(Node[][] expectedResult, Node[][] actualResult) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 ; j++) {
                assertEquals(expectedResult[i][j], actualResult[i][j]);
            }
        }
    }
}
