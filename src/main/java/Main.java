import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class Main {


    public static void main(String... args) {
        new SudokuEngine().solveSudoku(initialiseTable());
    }

    private static Node[][] initialiseTable() {

        Map<String, Byte> map = new HashMap<>();

        // level 2 problem (pass)
        map.put("02", (byte) 1);
        map.put("03", (byte) 3);
        map.put("06", (byte) 6);

        map.put("10", (byte) 6);
        map.put("11", (byte) 5);
        map.put("12", (byte) 3);
        map.put("13", (byte) 2);
        map.put("15", (byte) 4);

        map.put("22", (byte) 2);
        map.put("23", (byte) 5);
        map.put("25", (byte) 7);
        map.put("26", (byte) 3);
        map.put("27", (byte) 1);

        map.put("30", (byte) 1);
        map.put("31", (byte) 6);
        map.put("32", (byte) 7);
        map.put("34", (byte) 8);
        map.put("37", (byte) 3);
        map.put("38", (byte) 5);

        map.put("44", (byte) 5);
        map.put("45", (byte) 3);
        map.put("46", (byte) 1);
        map.put("48", (byte) 6);

        map.put("50", (byte) 4);
        map.put("51", (byte) 3);
        map.put("52", (byte) 5);
        map.put("53", (byte) 1);
        map.put("55", (byte) 6);
        map.put("56", (byte) 9);

        map.put("62", (byte) 8);
        map.put("64", (byte) 7);
        map.put("65", (byte) 1);
        map.put("66", (byte) 4);
        map.put("67", (byte) 9);
        map.put("68", (byte) 3);

        map.put("71", (byte) 1);
        map.put("73", (byte) 9);
        map.put("74", (byte) 4);
        map.put("76", (byte) 7);
        map.put("77", (byte) 2);
        map.put("78", (byte) 8);

        map.put("81", (byte) 7);
        map.put("83", (byte) 8);
        map.put("86", (byte) 5);
        map.put("88", (byte) 1);


        Node[][] tableOfNodes = new Node[9][9];

        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                tableOfNodes[i][j] = (map.get(i + "" + j) != null) ? new Node(i, j, map.get(i + "" + j)) : new Node(i, j);
            }
        }

        return tableOfNodes;
    }
}
