import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var matrixA = new Matrix();
        var matrixB = new Matrix();

//        matrixA.GetMatrixByCsv("matrixA");
//        matrixB.GetMatrixByCsv("matrixB");

        matrixA.GenerateRandomMatrix(30,30);
        matrixB.GenerateRandomMatrix(30,30);

        var calculatorTest = new CalculatorTest(matrixA, matrixB);


        var cordinator = new Coordinator(matrixA, matrixB);
        cordinator.CalculateMatrix();

        cordinator.newMatrix.SaveMatrixInCsv("kkk");


        calculatorTest.CalculateMatrix();
        calculatorTest.newMatrix.SaveMatrixInCsv("hhhh");






    }
}
