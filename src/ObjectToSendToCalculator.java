public class ObjectToSendToCalculator {

    private double[][] matrixA;
    private double[][] matrixB;

    private int rowEnd;
    private int rowStart;
    private int columnStart;
    private int columnEnd;

    public ObjectToSendToCalculator(double[][] matrixA, double[][] matrixB, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rowEnd = rowEnd;
        this.rowStart = rowStart;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }

    public double[][] getMatrixA() {
        return matrixA;
    }

    public double[][] getMatrixB() {
        return matrixB;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public int getColumnEnd() {
        return columnEnd;
    }

}
