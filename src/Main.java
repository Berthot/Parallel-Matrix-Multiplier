import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var matrixA = new Matrix();
        var matrixB = new Matrix();

        matrixA.GetMatrixByCsv("matrixA");
        matrixB.GetMatrixByCsv("matrixB");


        var cordinator = new Coordinator(matrixA, matrixB);






    }
}
