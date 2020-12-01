import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Matrix implements Serializable {

    private double[][] matrix;

    public Matrix() {

    }

    public void GenerateRandomMatrix(int columns, int rows) {
        matrix = new double[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = GenerateRandomDoubleValue();
            }
        }
    }

    public void GenerateEmptyMatrix(int columns, int rows) {
        matrix = new double[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = -1.0;
            }
        }
    }

    public void SaveMatrixInCsv(String fileName) throws IOException {
        FileWriter csv;
        csv = new FileWriter("Files/" + fileName + ".csv");
        for (double[] row : matrix) {
            StringBuilder csvLine = new StringBuilder();
            for (int column = 0; column < matrix[0].length; column++) {
                var value = row[column];
                csvLine.append(value).append(",");
            }
            csv.write(csvLine.substring(0, csvLine.length() - 1) + "\n");
        }
        csv.flush();
        csv.close();


    }

    public void GetMatrixByCsv(String fileName) throws IOException {
        var path = "Files/" + fileName + ".csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        var line = "";
        var matrixStringList = new ArrayList<String[]>();
        while ((line = br.readLine()) != null) {
            matrixStringList.add(line.split(","));
        }
        GetMatrixByStringArray(matrixStringList);
    }

    private void GetMatrixByStringArray(ArrayList<String[]> matrixStringList) {
        SetMatrixSize(matrixStringList.size(), matrixStringList.get(0).length);

        for (int row = 0; row < GetRowLength(); row++) {
            for (int column = 0; column < GetColumnLength(); column++) {
                matrix[row][column] = Double.parseDouble(matrixStringList.get(row)[column]);
            }
        }
    }

    public void SetMatrixSize(int rows, int columns) {
        matrix = new double[rows][columns];
    }

    public void SetValueInMatrix(int row, int column, double value) {
        matrix[row][column] = value;
    }


    public int GetColumnLength() {
        return matrix[0].length;
    }

    public int GetRowLength() {
        return matrix.length;
    }

    public double[][] GetMatrix() {
        return matrix;
    }


    private double GenerateRandomDoubleValue() {
        return new Random().nextInt(100) + 1;
    }

    public void PrintMatrix() {
        for (double[] row : matrix) {
            StringBuilder csvLine = new StringBuilder();
            for (int column = 0; column < matrix[0].length; column++) {
                var value = row[column];
                String val = String.valueOf(value);
                if (val.length() == 4)
                    csvLine.append(value).append(" | ");
                else
                    csvLine.append(value).append("  | ");
            }
            System.out.println(csvLine.substring(0, csvLine.length() - 3));
        }
    }


    public double GetValue(int lineMatrixA, int columnMatrixB) {
        return matrix[lineMatrixA][columnMatrixB];
    }
}
