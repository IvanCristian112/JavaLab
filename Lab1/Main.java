
public class Main {

    static int[][] mulMat(int[][] mat1, int[][] mat2) {
        // To store result
        int numberOfRows = mat1.length;
        int numberOfColumns = mat1[0].length;
        int numberOfColumns2 = mat2[0].length;
        int[][] resultMatrix = new int[numberOfRows][numberOfColumns2];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns2; j++) {
                for (int k = 0; k < numberOfColumns; k++)
                    resultMatrix[i][j] += mat1[i][k] * mat2[k][j];

            }
        }

        return resultMatrix;
    }

    public static int[][] matrixToPower(int power, int[][] matrix) {
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, resultMatrix[i], 0, matrix[0].length);
        }
        while ((power - 1) != 0) {
            resultMatrix = mulMat(resultMatrix, matrix);
            power--;
        }
        return resultMatrix;
    }


    public static void Compulsory() {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int result = n * 3 + 0b10101 + 0xFF;
        result *= 6;

        while (result > 10) {
            int sum = 0;
            while (result != 0) {
                sum += result % 10;
                result = result / 10;
            }
            result = sum;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    public static void Homework(String input) {
        int dimension;
        try {
            dimension = Integer.parseInt(input);
            System.out.println("Input valid");
        } catch (NumberFormatException e) {
            System.out.println("Input invalid");
            return;
        }
        long startTime = System.nanoTime();
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) matrix[i][i] = 1;
                else if (j > i) matrix[i][j] = j - i + 1;
                else matrix[i][j] = j - i + dimension + 1;

            }

        }
        if (dimension < 30) {
            for (int i = 0; i < dimension; i++) {
                StringBuilder concat = new StringBuilder();
                for (int j = 0; j < dimension; j++) {
                    concat.append(matrix[i][j]);
                }
                System.out.println("Linia " + i + ": " + concat);
            }
            for (int j = 0; j < dimension; j++) {
                StringBuilder concat = new StringBuilder();
                for (int i = 0; i < dimension; i++) {
                    concat.append(matrix[i][j]);
                }
                System.out.println("Coloana " + j + ": " + concat);
            }
        } else {
            long stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + " nanosecunde");
        }

    }


    public static void Bonus(String input1, String input2) {
        int numberOfNodes, kRegulated;
        try {
            numberOfNodes = Integer.parseInt(input1);
            kRegulated = Integer.parseInt(input2);
            System.out.println("Input valid");
        } catch (NumberFormatException e) {
            System.out.println("Input invalid");
            return;
        }
        //Cream matricea de adiacenta pentru circuit
        int dimension = 3;
        int[][] adjacencyMatrix = new int[dimension][dimension];
        //primul nod este vecin cu al doilea nod si cu ultimul nod
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][dimension - 1] = 1;
        for (int i = 1; i < dimension - 1; i++) {
            adjacencyMatrix[i][i - 1] = 1;
            adjacencyMatrix[i][i + 1] = 1;
        }
        //ultimul nod este vecin cu primul nod si cu penultimul nod
        adjacencyMatrix[dimension - 1][0] = 1;
        adjacencyMatrix[dimension - 1][dimension - 2] = 1;
        //Calculam A^2, A^3, A^n;
        int[][] nthPower = new int[dimension][dimension];
        nthPower = matrixToPower(4, adjacencyMatrix);
/*        for(int[] row : nthPower) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }*/
        //Cream matricea de adiacenta pentru graful regulat
        if (kRegulated >= numberOfNodes || (kRegulated % 2 == 1 && numberOfNodes % 2 == 1)) {
            System.out.println("Adjancency matrix cannot be created");
            return;
        }
        int[][] regularGraph = new int[numberOfNodes][numberOfNodes];
        //first case, when kRegulated is even

        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 1; j <= kRegulated / 2; j++) {
                regularGraph[i][(i + j + numberOfNodes) % numberOfNodes] = 1;
                regularGraph[i][(i - j + numberOfNodes) % numberOfNodes] = 1;
            }
            if (kRegulated % 2 == 1) {
                regularGraph[i][(i + numberOfNodes / 2) % numberOfNodes] = 1;
            }
        }

        for (int[] row : regularGraph) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        //Compulsory();

        //Homework(args[0]);

        //Bonus(args[0], args[1]);


    }
}
