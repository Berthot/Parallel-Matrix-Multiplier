import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var matrixA = new Matrix();
        var matrixB = new Matrix();

//        matrixA.GetMatrixByCsv("matrixA");
//        matrixB.GetMatrixByCsv("matrixB");
////
        matrixA.GenerateRandomMatrix(8,4);
        matrixB.GenerateRandomMatrix(4,6);

        matrixA.SaveMatrixInCsv("matrixA");
        matrixB.SaveMatrixInCsv("matrixB");



        var cordinator = new Coordinator(matrixA, matrixB);

        var server = new CoordinatorServer(cordinator);


        server.IniciarServer();

        cordinator.newMatrix.SaveMatrixInCsv("matrix_resultado");


//        var calculatorTest = new CalculatorTest(matrixA, matrixB);
//        calculatorTest.CalculateMatrix();
//        calculatorTest.newMatrix.SaveMatrixInCsv("batata-safe");


    }
}
