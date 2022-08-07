import enums.Row;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class SudokuEngine {

    private Node[][] tableOfNodes;

    final private Set<Byte> ONE_TO_NINE = Set.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9);

    private final int ELIGIBLE_SIZE_MATCHING_PAIR = 3;

    public Node[][] solveSudoku(Node[][] tableOfNodes) {
        this.tableOfNodes = tableOfNodes;
        boolean areAllNumbersSet = false;
        int hashCodeBefore = 0;
        int hashCodeAfter = 0;
        byte countSame = 0;

        while (!areAllNumbersSet && countSame <= 1) {
            hashCodeBefore = Arrays.deepHashCode(this.tableOfNodes);
            areAllNumbersSet = basicSolving(tableOfNodes);
            hashCodeAfter = Arrays.deepHashCode(this.tableOfNodes);
            countSame = getCountSame(hashCodeBefore, hashCodeAfter, countSame);

            runTMBTechnique(areAllNumbersSet, hashCodeBefore, hashCodeAfter);
            areAllNumbersSet = checkAllNumbersSet(this.tableOfNodes);

            removePossibleValuesFromNodesThatHaveBeenFilled(this.tableOfNodes);
        }
        return this.tableOfNodes;
    }

    private void matchingTechniqueByRow(Node[][] tableOfNodes) {
        for (byte row = 0; row < 9; row++) {
            List<Set<Byte>> possibleValuesList = new ArrayList<>();
            for (byte column = 0; column < 9; column++) {
                if (tableOfNodes[row][column].getValue() == null &&
                        CollectionUtils.isNotEmpty(tableOfNodes[row][column].getPossibleValues()) ) {
                    possibleValuesList.add(tableOfNodes[row][column].getPossibleValues());
                }
            }

            if (ELIGIBLE_SIZE_MATCHING_PAIR == possibleValuesList.size() ) {
                Set<Byte> allPossibleValues = new HashSet<>();
                Map<Byte, Byte> mapValueWithNumberOfOccurrences = new HashMap<>();
                for (Set<Byte> set: possibleValuesList) {
                    for(Byte value: set) {
                        allPossibleValues.add(value);
                        if (mapValueWithNumberOfOccurrences.get(value) == null) {
                            mapValueWithNumberOfOccurrences.put(value, (byte) 1 );
                        } else {
                            mapValueWithNumberOfOccurrences.put(value, (byte) (mapValueWithNumberOfOccurrences.get(value) + (byte) 1));
                        }
                    }
                }

                byte value = 0;
                for (Map.Entry<Byte, Byte> entry: mapValueWithNumberOfOccurrences.entrySet()) {
                    if (Byte.valueOf("1").equals(entry.getValue())) {
                        value = entry.getKey();
                    }
                }

                for (byte _row = 0; _row < 9; _row++) {
                    for (byte _column = 0; _column < 9; _column++) {
                        if (tableOfNodes[_row][_column].getValue() == null &&
                                CollectionUtils.isNotEmpty(tableOfNodes[_row][_column].getPossibleValues()) &&
                                tableOfNodes[_row][_column].getPossibleValues().contains(value)
                        ) {
                            tableOfNodes[_row][_column].setValue(value);
                            tableOfNodes[_row][_column].setPossibleValues(null);
                        }
                    }
                }
            }
        }
    }

    private byte getCountSame(int hashCodeBefore, int hashCodeAfter, byte countSame) {
        if (hashCodeBefore == hashCodeAfter) {
            countSame++;
        } else {
            countSame = 0;
        }
        return countSame;
    }

    private void runTMBTechnique(boolean areAllNumbersSet, int hashCodeBefore, int hashCodeAfter) {
        if (!areAllNumbersSet && (hashCodeBefore == hashCodeAfter)) {
            boolean carryOnWithTMBTechnique = true;
            while(carryOnWithTMBTechnique) {
                hashCodeBefore = Arrays.deepHashCode(this.tableOfNodes);
                tmbTechniqueAllRows();
                hashCodeAfter = Arrays.deepHashCode(this.tableOfNodes);
                carryOnWithTMBTechnique = hashCodeBefore != hashCodeAfter;
            }
        }
    }

    private void tmbTechniqueAllRows() {
        tmbTechnique(this.tableOfNodes, Row.TOP);
        tmbTechnique(this.tableOfNodes, Row.MIDDLE);
        tmbTechnique(this.tableOfNodes, Row.BOTTOM);
    }

    private void tmbTechnique(Node[][] tableOfNodes, Row rowEnum) {
        if (rowEnum == null) throw new RuntimeException("rowEnum cannot be null");
        if (rowEnum != Row.TOP && rowEnum != Row.MIDDLE && rowEnum != Row.BOTTOM) throw new RuntimeException("Invalid rowEnum");

        for (byte numberLookingFor = 1; numberLookingFor <= 9; numberLookingFor++) {
            byte count = 0;
            OccupiedNode[] occupiedNodes = new OccupiedNode[3];
            byte rowBegin = 0;
            byte rowEnd = 0;
            if (rowEnum == Row.TOP) {
                rowBegin = 0;
                rowEnd = 2;
            } else if (rowEnum == Row.MIDDLE) {
                rowBegin = 3;
                rowEnd = 5;
            } else if (rowEnum == Row.BOTTOM) {
                rowBegin = 6;
                rowEnd = 8;
            }

            for (byte row = rowBegin; row <= rowEnd; row++) {
                for (byte column = 0; column < 9; column++) {
                    if (tableOfNodes[row][column].getValue() != null && tableOfNodes[row][column].getValue() == numberLookingFor) {
                        byte section = Group.getSectionNumber(new Group(row, column));
                        occupiedNodes[count] = new OccupiedNode(section, row, column, numberLookingFor);
                        count++;
                    }
                }
            }

            if (count == 0 || count == 1 || count == 3) {
                count = 0;
                continue;
            } else { // count == 2
                OccupiedNode occupiedNodeA = occupiedNodes[0];
                OccupiedNode occupiedNodeB = occupiedNodes[1];

                byte occupiedSectionA = Group.getSectionNumber(new Group(occupiedNodeA.getRow(), occupiedNodeA.getColumn()));
                byte occupiedSectionB = Group.getSectionNumber(new Group(occupiedNodeB.getRow(), occupiedNodeB.getColumn()));

                Set<Byte> sectionABC = null;

                if (rowEnum == Row.TOP) {
                    sectionABC = Set.of((byte) 1, (byte) 2, (byte) 3);
                } else if (rowEnum == Row.MIDDLE) {
                    sectionABC = Set.of((byte) 4, (byte) 5, (byte) 6);
                } else if (rowEnum == Row.BOTTOM) {
                    sectionABC = Set.of((byte) 7, (byte) 8, (byte) 9);
                }

                if (sectionABC == null) throw new RuntimeException("sectionABC is null");

                Set<Byte> occupiedSections = Set.of(occupiedSectionA, occupiedSectionB);

                Byte unoccupiedSection = (Byte) CollectionUtils.subtract(sectionABC, occupiedSections).toArray()[0];

                Set<Byte> fullRows = null;

                if (rowEnum == Row.TOP) {
                    fullRows = Set.of((byte) 0, (byte) 1, (byte) 2);
                } else if (rowEnum == Row.MIDDLE) {
                    fullRows = Set.of((byte) 3, (byte) 4, (byte) 5);
                } else if (rowEnum == Row.BOTTOM) {
                    fullRows = Set.of((byte) 6, (byte) 7, (byte) 8);
                }

                if (fullRows == null) throw new RuntimeException("fullRows is null");


                Set<Byte> occupiedRows = Set.of(occupiedNodeA.getRow(), occupiedNodeB.getRow());
                Byte unoccupiedRow = (Byte) CollectionUtils.subtract(fullRows, occupiedRows).toArray()[0]; // unoccupiedRow = 1

                Set<Byte> potentialColumns = null;
                if (unoccupiedSection == (byte) 1 || unoccupiedSection == (byte) 4 || unoccupiedSection == (byte) 7) {
                    potentialColumns = Set.of((byte) 0, (byte) 1, (byte) 2);
                } else if (unoccupiedSection == (byte) 2 || unoccupiedSection == (byte) 5 || unoccupiedSection == (byte) 8) {
                    potentialColumns = Set.of((byte) 3, (byte) 4, (byte) 5); // potentialColumns = 3, 4, 5
                } else if (unoccupiedSection == (byte) 3 || unoccupiedSection == (byte) 6 || unoccupiedSection == (byte) 9) {
                    potentialColumns = Set.of((byte) 6, (byte) 7, (byte) 8);
                }

                if (potentialColumns == null) {
                    throw new RuntimeException("potentialColumns cannot be null.");
                }

                byte nodeUnoccupied = 0;
                List<Node> nodesUnoccupied = new ArrayList();
                for (Byte potentialColumn : potentialColumns) {
                    Node node = tableOfNodes[unoccupiedRow][potentialColumn];
                    if (node.getValue() == null) {
                        nodesUnoccupied.add(node);
                        nodeUnoccupied++;
                    }
                }

                if (nodeUnoccupied == 1) {
                    nodesUnoccupied.get(0).setValue(numberLookingFor);
                    System.out.println();
                    printTable();
                } else {
                    Set<Byte> occupiedColumns = new HashSet<>();
                    for (Byte potentialColumn : potentialColumns) {
                        for (byte row = 0; row < 9; row++) {
                            if (tableOfNodes[row][potentialColumn].getValue() != null && numberLookingFor == tableOfNodes[row][potentialColumn].getValue()){
                                occupiedColumns.add(potentialColumn);
                            }
                        }
                    }

                    if (occupiedColumns.size() == 2) {
                        Byte column = (Byte) CollectionUtils.subtract(potentialColumns, occupiedColumns).toArray()[0];
                        tableOfNodes[unoccupiedRow][column].setValue(numberLookingFor);
                        System.out.println();
                        printTable();
                    }
                }
                continue;
            }
        }
    }

    private boolean runBasicSolving(boolean areAllNumbersSet, int hashCodeBefore, int hashCodeAfter) {
        if (!areAllNumbersSet && (hashCodeBefore == hashCodeAfter)) {
            boolean carryOnWithBasicSolvingTechnique = true;
            while (carryOnWithBasicSolvingTechnique) {
                hashCodeBefore = Arrays.deepHashCode(this.tableOfNodes);
                basicSolving(this.tableOfNodes);
                hashCodeAfter = Arrays.deepHashCode(this.tableOfNodes);
                carryOnWithBasicSolvingTechnique = hashCodeBefore != hashCodeAfter;
            }
        }

        return checkAllNumbersSet(this.tableOfNodes);
    }

    private boolean basicSolving(Node[][] tableOfNodes) {
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
                } else {
                    continue;
                }
            }
        }
        System.out.println();
        printTable();
        return checkAllNumbersSet(tableOfNodes);
    }

    private void gatherNumbersFromColumn(byte column, Set<Byte> numbersTaken) {
        for (Byte i = (byte) 0; i < (byte) 9; i++) {
            if (tableOfNodes[i][column].getValue() != null) {
                numbersTaken.add(tableOfNodes[i][column].getValue());
            }
        }
    }

    private void gatherNumbersFromRow(byte row, Set<Byte> numbersTaken) {
        for (Byte i = (byte) 0; i < (byte) 9; i++) {
            if (tableOfNodes[row][i].getValue() != null) {
                numbersTaken.add(tableOfNodes[row][i].getValue());
            }
        }
    }

    private void gatherNumbersFromGroup(Set<Byte> numbersTaken, Group group) {
        for (Byte groupRowIndex = group.getRowRange().getMIN(); groupRowIndex <= group.getRowRange().getMAX(); groupRowIndex++) {
            for (Byte groupColumnIndex = group.getColumnRange().getMIN(); groupColumnIndex <= group.getColumnRange().getMAX(); groupColumnIndex++) {
                if (tableOfNodes[groupRowIndex][groupColumnIndex].getValue() != null) {
                    numbersTaken.add(tableOfNodes[groupRowIndex][groupColumnIndex].getValue());
                }
            }
        }
    }

    private boolean checkAllNumbersSet(Node[][] tableOfNodes) {
        for (byte row = 0; row < 9; row++) {
            for (byte column = 0; column < 9; column++) {
                if (tableOfNodes[row][column].getValue() == null)
                    return false;
            }
        }
        return true;
    }

    private void removePossibleValuesFromNodesThatHaveBeenFilled(Node[][] tableOfNodes) {
        for (byte row = 0; row < 9; row++) {
            for (byte column = 0; column < 9; column++) {
                if (tableOfNodes[row][column].getValue() != null)
                    tableOfNodes[row][column].setPossibleValues(null);
            }
        }
    }

    private void printTable() {
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
