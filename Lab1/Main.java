public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Compulsory();
        //Homework
    }

    public static void Compulsory() {
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
            System.out.println((stopTime - startTime));
        }

}
