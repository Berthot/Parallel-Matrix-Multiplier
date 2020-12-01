import java.io.Serializable;

public class Calculators implements Serializable {

    private final ObjectToSendToCalculator fromCoordinator;

    public Calculators(ObjectToSendToCalculator objectToSendToCalculator) {

        fromCoordinator = objectToSendToCalculator;
    }


    public Matrix CalculateMatrix() {
        var matrixA = fromCoordinator.getMatrixA();
        var matrixB = fromCoordinator.getMatrixB();


        var matrixAClone = matrixA.GetMatrix();
        var matrixBClone = matrixB.GetMatrix();

        var matrixAColumn = matrixA.GetColumnLength();

        var newMatrix = new Matrix();
        newMatrix.GenerateEmptyMatrix(matrixA.GetRowLength(), matrixB.GetColumnLength());

        for(int lineMatrixA:fromCoordinator.getRowsLimit())
        {
            for(int columnMatrixB: fromCoordinator.getColumnsLimit())
            {
                var acc = 0.0;
                for (int i = 0; i < matrixAColumn; i++)
                {
                    var a = matrixAClone[lineMatrixA][i];
                    var b = matrixBClone[i][columnMatrixB];
                    acc += a * b;
                }
                newMatrix.SetValueInMatrix(lineMatrixA, columnMatrixB, acc);
            }
        }
        return newMatrix;

    }
}
