public class CalculatorTest {

    Matrix matrixA;
    Matrix matrixB;
    Matrix newMatrix = new Matrix();

    public CalculatorTest(Matrix matrixA, Matrix matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        newMatrix.SetMatrixSize(matrixA.GetRowLength(), matrixB.GetColumnLength());
    }

    public void CalculateMatrix(){
        var matrixARow = matrixA.GetRowLength();
        var matrixBColumn = matrixB.GetColumnLength();
        var matrixAColumn = matrixA.GetColumnLength();

        var matrixAClone = matrixA.GetMatrix();
        var matrixBClone = matrixB.GetMatrix();

        for (var lineMatrixA = 0; lineMatrixA < matrixARow; lineMatrixA++)
        {
            for (var columnMatrixB = 0; columnMatrixB < matrixBColumn; columnMatrixB++)
            {
                var acc = 0.0;
                for (var i = 0; i < matrixAColumn; i++)
                {
                    var a = matrixAClone[lineMatrixA][i];
                    var b = matrixBClone[i][columnMatrixB];
                    acc += a * b;
                }

                newMatrix.SetValueInMatrix(lineMatrixA, columnMatrixB, acc);
            }
        }

    }
}
