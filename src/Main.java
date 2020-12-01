import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        var matrixA = new Matrix();
        var matrixB = new Matrix();

//        matrixA.GetMatrixByCsv("matrixA");
//        matrixB.GetMatrixByCsv("matrixB");

        matrixA.GenerateRandomMatrix(500,500);
        matrixB.GenerateRandomMatrix(500,500);
//
//        matrixA.SaveMatrixInCsv("matrixA");
//        matrixB.SaveMatrixInCsv("matrixB");

//        var calculatorTest = new CalculatorTest(matrixA, matrixB);
//        calculatorTest.CalculateMatrix();
//        calculatorTest.newMatrix.SaveMatrixInCsv("batata-safe");



        var cordinator = new Coordinator(matrixA, matrixB);

        var server = new CoordinatorServer(cordinator);


        server.IniciarServer();

        cordinator.newMatrix.SaveMatrixInCsv("batata");





    }
}
