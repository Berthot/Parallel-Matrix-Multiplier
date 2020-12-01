import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Coordinator {
    Matrix matrixA;
    Matrix matrixB;
    Matrix newMatrix = new Matrix();
    List<ObjectToSendToCalculator> sendToCalculators = new ArrayList<>();

    public Coordinator(Matrix matrixA, Matrix matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        newMatrix.SetMatrixSize(matrixA.GetRowLength(), matrixB.GetColumnLength());
        CreateTask();
    }


    public void CreateTask() {
        var columnLength = newMatrix.GetColumnLength();
        var rowLength = newMatrix.GetRowLength();
        var plus = 0;
        if (columnLength % 2 == 1 || rowLength % 2 == 1) {
            columnLength++;
            rowLength++;
            plus++;
        }

        sendToCalculators.add(PartitionA(columnLength, rowLength, plus));
        sendToCalculators.add(PartitionB(columnLength, rowLength, plus));
        sendToCalculators.add(PartitionC(columnLength, rowLength, plus));
        sendToCalculators.add(PartitionD(columnLength, rowLength, plus));


    }


    public void MergeMatrix(Matrix partA, Matrix partB, Matrix partC, Matrix partD) throws IOException {
        for (var lineMatrixA = 0; lineMatrixA < newMatrix.GetRowLength(); lineMatrixA++) {
            for (var columnMatrixB = 0; columnMatrixB < newMatrix.GetColumnLength(); columnMatrixB++) {
                double[] values = new double[]{
                        partA.GetValue(lineMatrixA, columnMatrixB),
                        partB.GetValue(lineMatrixA, columnMatrixB),
                        partC.GetValue(lineMatrixA, columnMatrixB),
                        partD.GetValue(lineMatrixA, columnMatrixB)
                };

                newMatrix.SetValueInMatrix(lineMatrixA, columnMatrixB, Arrays.stream(values).max().getAsDouble());
            }
        }
//        newMatrix.SaveMatrixInCsv("batata");
    }


    private ObjectToSendToCalculator PartitionD(int columnLength, int rowLength, int plus) {
        return new ObjectToSendToCalculator(this.matrixA, this.matrixB,
                getRange(rowLength / 2 + plus, rowLength - plus),
                getRange(columnLength / 2, columnLength - plus)
        );
    }

    private ObjectToSendToCalculator PartitionC(int columnLength, int rowLength, int plus) {
        return new ObjectToSendToCalculator(this.matrixA, this.matrixB,
                getRange(rowLength / 2 + plus, rowLength - plus),
                getRange(0, columnLength / 2 + plus)
        );
    }

    private ObjectToSendToCalculator PartitionB(int columnLength, int rowLength, int plus) {
        return new ObjectToSendToCalculator(this.matrixA, this.matrixB,
                getRange(0, rowLength / 2 - plus),
                getRange(columnLength / 2, columnLength - plus)
        );
    }

    private ObjectToSendToCalculator PartitionA(int columnLength, int rowLength, int plus) {
        return new ObjectToSendToCalculator(this.matrixA, this.matrixB,
                getRange(0, rowLength / 2 - plus),
                getRange(0, columnLength / 2 - plus)
        );
    }

    private int[] getRange(int start, int end) {
        return IntStream.range(start, end).toArray();
    }


}
