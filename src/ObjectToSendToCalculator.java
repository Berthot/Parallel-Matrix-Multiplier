import java.io.Serializable;
import java.util.ArrayList;

public class ObjectToSendToCalculator implements Serializable {

    private final Matrix matrixA;
    private final Matrix matrixB;


    private final int[] rowsLimit;
    private final String name;
    private final int[] columnsLimit;

    public ObjectToSendToCalculator(Matrix matrixA, Matrix matrixB, int[] rowsLimit, int[] columnsLimit, String name) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.columnsLimit = columnsLimit;
        this.rowsLimit = rowsLimit;
        this.name = name;
    }

    public Matrix getMatrixA() {
        return matrixA;
    }

    public Matrix getMatrixB() {
        return matrixB;
    }

    public int[] getColumnsLimit() {
        return columnsLimit;
    }

    public int[] getRowsLimit() {
        return rowsLimit;
    }

    public String getName() {
        return name;
    }
}
