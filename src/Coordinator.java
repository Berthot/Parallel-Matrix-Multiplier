import java.util.ArrayList;
import java.util.List;

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


    public void CreateTask(){
        var columnLength = newMatrix.GetColumnLength();
        var rowLength = newMatrix.GetRowLength();
        var plus = 0;
        if(columnLength % 2 == 1 || rowLength % 2 == 1) {
            columnLength++;
            rowLength++;
            plus++;
        }
        sendToCalculators.add(new ObjectToSendToCalculator(this.matrixA.GetMatrix(), this.matrixB.GetMatrix(),0, rowLength/2-plus,0,columnLength/2 -plus));
        sendToCalculators.add(new ObjectToSendToCalculator(this.matrixA.GetMatrix(), this.matrixB.GetMatrix(),0, rowLength/2-plus,columnLength/2, columnLength -plus));
        sendToCalculators.add(new ObjectToSendToCalculator(this.matrixA.GetMatrix(), this.matrixB.GetMatrix(),rowLength/2+plus, rowLength -plus,0,columnLength/2+plus));
        sendToCalculators.add(new ObjectToSendToCalculator(this.matrixA.GetMatrix(), this.matrixB.GetMatrix(),rowLength/2+plus, rowLength -plus,columnLength/2, columnLength -plus));

    }




}
