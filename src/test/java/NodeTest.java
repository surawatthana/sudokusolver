import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTest {

    @Test
    public void shouldReturnTrueWhen2By2NodeAreIdential() {
        Node[][] table1 = new Node[2][2];
        Node[][] table2 = new Node[2][2];

        table1[0][0] = new Node((byte) 0,(byte)  0, (byte) 1);
        table1[0][1] = new Node((byte) 0,(byte)  1, (byte) 2);
        table1[1][0] = new Node((byte) 1,(byte)  0, (byte) 3);
        table1[1][1] = new Node((byte) 1,(byte)  1, (byte) 4);

        table2[0][0] = new Node((byte) 0,(byte)  0, (byte) 1);
        table2[0][1] = new Node((byte) 0,(byte)  1, (byte) 2);
        table2[1][0] = new Node((byte) 1,(byte)  0, (byte) 3);
        table2[1][1] = new Node((byte) 1,(byte)  1, (byte) 4);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 ; j++) {
                assertEquals(table1[i][j], table2[i][j]);
            }
        }
    }
}
