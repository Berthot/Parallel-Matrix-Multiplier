import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        var matrixA = new Matrix();
        var matrixB = new Matrix();

//        matrixA.GetMatrixByCsv("matrixA");
//        matrixB.GetMatrixByCsv("matrixB");

        matrixA.GenerateRandomMatrix(2000,2000);
        matrixB.GenerateRandomMatrix(2000,2000);

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
