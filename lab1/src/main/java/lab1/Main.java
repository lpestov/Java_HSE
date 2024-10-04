package lab1;

public class Main {

    public static void main(String[] args) {
        testMatrix2x2();

        testMatrix3x3();
    }

    // Тест для 2x2 матрицы
    public static void testMatrix2x2() {
        System.out.println("--- Тест для матрицы 2x2 ---");

        ComplexNumber[][] data1 = {
                {new ComplexNumber(1, 2), new ComplexNumber(2, 4)},
                {new ComplexNumber(3, 6), new ComplexNumber(1, 8)}
        };
        ComplexNumber[][] data2 = {
                {new ComplexNumber(2, 1), new ComplexNumber(4, 3)},
                {new ComplexNumber(6, 9), new ComplexNumber(8, 7)}
        };

        ComplexMatrix matrix1 = new ComplexMatrix(data1);
        ComplexMatrix matrix2 = new ComplexMatrix(data2);

        System.out.println("Матрица 1:");
        System.out.println(matrix1);

        System.out.println("Матрица 2:");
        System.out.println(matrix2);

        // Сложение
        ComplexMatrix resultAdd = matrix1.add(matrix2);
        System.out.println("Результат сложения матриц:");
        System.out.println(resultAdd);

        // Вычитание
        ComplexMatrix resultSubtract = matrix1.subtract(matrix2);
        System.out.println("Результат вычитания матриц:");
        System.out.println(resultSubtract);

        // Умножение
        ComplexMatrix resultMultiply = matrix1.multiply(matrix2);
        System.out.println("Результат умножения матриц:");
        System.out.println(resultMultiply);

        // Умножение на скаляр
        ComplexMatrix resultMultiplyScalar = matrix1.scalarMultiply(new ComplexNumber(2, 1));
        System.out.println("Результат умножения матрицы 1 на скаляр:");
        System.out.println(resultMultiplyScalar);

        // Деление
        ComplexMatrix resultDivide = matrix1.divide(matrix2);
        System.out.println("Результат деления матриц:");
        System.out.println(resultDivide);

        // Транспонирование
        ComplexMatrix resultTranspose = matrix1.transpose();
        System.out.println("Результат транспонирования матрицы 1:");
        System.out.println(resultTranspose);

        // Детерминант
        ComplexNumber determinant = matrix1.determinant();
        System.out.println("Детерминант матрицы 1:");
        System.out.println(determinant);
    }

    // Тест для 3x3 матрицы
    public static void testMatrix3x3() {
        System.out.println("--- Тест для матрицы 3x3 ---");
        ComplexNumber[][] data1 = {
                {new ComplexNumber(1, 2), new ComplexNumber(2, 3), new ComplexNumber(3, 4)},
                {new ComplexNumber(4, 5), new ComplexNumber(5, 6), new ComplexNumber(6, 7)},
                {new ComplexNumber(7, 9), new ComplexNumber(8, 9), new ComplexNumber(9, 10)}
        };


        ComplexMatrix matrix1 = new ComplexMatrix(data1);

        // Убедившись на 1 тесте, что методы работают исправно, создадим 2 матрицу из случайных чисел
        ComplexMatrix matrix2 = new ComplexMatrix(3, 3);
        matrix2.fillWithRandomValues(-10.0, 10.0, -5.0, 5.0); // Заполняем матрицу случайными числами

        System.out.println("Матрица 1:");
        System.out.println(matrix1);

        System.out.println("Матрица 2:");
        System.out.println(matrix2);

        // Сложение
        ComplexMatrix resultAdd = matrix1.add(matrix2);
        System.out.println("Результат сложения матриц:");
        System.out.println(resultAdd);

        // Вычитание
        ComplexMatrix resultSubtract = matrix1.subtract(matrix2);
        System.out.println("Результат вычитания матриц:");
        System.out.println(resultSubtract);

        // Умножение
        ComplexMatrix resultMultiply = matrix1.multiply(matrix2);
        System.out.println("Результат умножения матриц:");
        System.out.println(resultMultiply);

        // Умножение на скаляр
        ComplexMatrix resultMultiplyScalar = matrix1.scalarMultiply(new ComplexNumber(2, 1));
        System.out.println("Результат умножения матрицы 1 на скаляр:");
        System.out.println(resultMultiplyScalar);

        // Деление
        ComplexMatrix resultDivide = matrix1.divide(matrix2);
        System.out.println("Результат деления матриц:");
        System.out.println(resultDivide);


        // Транспонирование
        ComplexMatrix resultTranspose = matrix1.transpose();
        System.out.println("Результат транспонирования матрицы 1:");
        System.out.println(resultTranspose);

        // Детерминант
        ComplexNumber determinant = matrix1.determinant();
        System.out.println("Детерминант матрицы 1:");
        System.out.println(determinant);
    }


}
