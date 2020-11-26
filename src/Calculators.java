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

//        for (var lineMatrixA = 0; lineMatrixA < matrixARow; lineMatrixA++)
        for(int lineMatrixA:fromCoordinator.getRowsLimit())
        {
//            for (var columnMatrixB = 0; columnMatrixB < matrixBColumn; columnMatrixB++)
            for(int columnMatrixB: fromCoordinator.getColumnsLimit())
            {
//                if(lineMatrixA >=)
                var acc = 0.0;
                for (int i = 0; i < matrixAColumn; i++)
//                for(var i: fromCoordinator.getColumnsLimit())
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
