import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SudokuEngine {

    private Node[][] tableOfNodes;

    final private Set<Byte> ONE_TO_NINE = Set.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9);

    public Node[][] solveSudoku(Node[][] tableOfNodes) {
        this.tableOfNodes = tableOfNodes;

        boolean allNumberSet = false;
        int countSame = 0;

        while (!allNumberSet) {
            int hashCodeBefore = Arrays.deepHashCode(this.tableOfNodes);
            allNumberSet = basicSolving(tableOfNodes, allNumberSet);
            int hashCodeAfter = Arrays.deepHashCode(this.tableOfNodes);

            if (hashCodeBefore == hashCodeAfter) {
                countSame++;
                if (countSame == 3) {
                    break;

                    // TMB algorithm

                    // LCR algorithm

                }
            } else {
                countSame = 0;
                continue;
            }
        }
        return this.tableOfNodes;
    }


    private boolean tmbTechnique(Node[][] tableOfNodes, boolean allNumberSet) {

    }

    private boolean basicSolving(Node[][] tableOfNodes, boolean allNumberSet) {
        for (byte row = (byte) 0; row < (byte) 9; row++) {
            ROW_LEVEL:
            for (byte column = (byte) 0; column < (byte) 9; column++) {
                Node node = tableOfNodes[row][column];
                if (node.getValue() == null) {
                    Set<Byte> numbersTaken = new TreeSet<>();
                    Group group = new Group(row, column);

                    gatherNumbersFromGroup(numbersTaken, group);
                    gatherNumbersFromRow(row, numbersTaken);
                    gatherNumbersFromColumn(column, numbersTaken);

                    if (numbersTaken.size() == 8) {
                        Byte number = ((List<Byte>) CollectionUtils.subtract(ONE_TO_NINE, numbersTaken)).get(0);
                        node.setValue(number);
                    } else if (numbersTaken.size() == 0) {
                        throw new RuntimeException("Size should not be zero.");
                    } else {
                        if (!numbersTaken.equals(node.getPossibleValues())) {
                            node.setPossibleValues(new TreeSet<>(CollectionUtils.subtract(ONE_TO_NINE, numbersTaken)));
                        }
                    }

                    // carry on if all numbers are not set
                    for (byte a = (byte) 0; a < (byte) 9; a++) {
                        for (byte b = (byte) 0; b < (byte) 9; b++) {
                            if (tableOfNodes[a][b].getValue() == null) {
                                continue ROW_LEVEL;
                            }
                        }
                    }

                    allNumberSet = true;
                } else {
                    continue;
                }
            }
        }
        System.out.println();
        printTable();
        return allNumberSet;
    }

    private  void gatherNumbersFromColumn(byte column, Set<Byte> numbersTaken) {
        for (Byte i = (byte) 0; i < (byte) 9; i++) {
            if (tableOfNodes[i][column].getValue() != null) {
                numbersTaken.add(tableOfNodes[i][column].getValue());
            }
        }
    }

    private  void gatherNumbersFromRow(byte row, Set<Byte> numbersTaken) {
        for (Byte i = (byte) 0; i < (byte) 9; i++) {
            if (tableOfNodes[row][i].getValue() != null) {
                numbersTaken.add(tableOfNodes[row][i].getValue());
            }
        }
    }

    private  void gatherNumbersFromGroup(Set<Byte> numbersTaken, Group group) {
        for (Byte groupRowIndex = group.getRowRange().getMIN(); groupRowIndex <= group.getRowRange().getMAX(); groupRowIndex++) {
            for (Byte groupColumnIndex = group.getColumnRange().getMIN(); groupColumnIndex <= group.getColumnRange().getMAX(); groupColumnIndex++) {
                if (tableOfNodes[groupRowIndex][groupColumnIndex].getValue() != null) {
                    numbersTaken.add(tableOfNodes[groupRowIndex][groupColumnIndex].getValue());
                }
            }
        }
    }

    private  void printTable() {
        for (byte i = 0; i < 9; i++) {
            for (byte j = 0; j < 9; j++) {
                Byte value = tableOfNodes[i][j].getValue();
                System.out.print("|");
                System.out.print(value != null ? value : " ");
                if (j == (byte) 8) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
