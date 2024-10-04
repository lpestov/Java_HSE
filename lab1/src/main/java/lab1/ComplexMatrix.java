package lab1;

import java.util.Random;

public class ComplexMatrix {
    // Поля
    private ComplexNumber[][] matrix;    private int rows;
    private int columns;

    // Конструктор для создания нулевой матрицы заданного размера
    public ComplexMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ComplexNumber[rows][columns];

        // Инициализация всех элементов матрицы нулями
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = new ComplexNumber(0, 0);
            }
        }
    }

    // Конструктор для создания матрицы из двумерного массива
    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    // Геттеры
    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public ComplexNumber get(int row, int column) {
        return this.matrix[row][column];
    }

    // Методы

    // Сложение двух матриц
    public ComplexMatrix add(ComplexMatrix other) {
        ComplexMatrix result = new ComplexMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = this.matrix[i][j].add(other.matrix[i][j]);
            }
        }
        return result;
    }

    // Вычитание двух матриц
    public ComplexMatrix subtract(ComplexMatrix other) {
        ComplexMatrix result = new ComplexMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = this.matrix[i][j].subtract(other.matrix[i][j]);
            }
        }
        return result;
    }

    // Умножение двух матриц
    public ComplexMatrix multiply(ComplexMatrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно быть равно числу строк второй матрицы.");
        }

        ComplexMatrix result = new ComplexMatrix(this.rows, other.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                ComplexNumber sum = new ComplexNumber(0, 0);
                for (int k = 0; k < this.columns; k++) {
                    sum = sum.add(this.matrix[i][k].multiply(other.matrix[k][j]));
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;


    }

    // Умножение матрицы на скаляр
    public ComplexMatrix scalarMultiply(ComplexNumber scalar) {
        ComplexMatrix result = new ComplexMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = matrix[i][j].multiply(scalar);
            }
        }
        return result;
    }


    // Транспонирование матрицы
    public ComplexMatrix transpose() {
        ComplexMatrix result = new ComplexMatrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[j][i] = this.matrix[i][j];
            }
        }
        return result;
    }


    // Детерминант матрицы
    public ComplexNumber determinant() {
        if (rows != columns) {
            throw new IllegalArgumentException("Матрица должна быть квадратной.");
        }

        return calculateDeterminant(matrix, rows);
    }


    private ComplexNumber calculateDeterminant(ComplexNumber[][] matrix, int size) {
        // Если матрица состоит из одного элемента, то возвращаем его
        if (size == 1) {
            return matrix[0][0];
        }

        ComplexNumber det = new ComplexNumber(0, 0);
        for (int i = 0; i < size; i++) {
            det = det.add(matrix[0][i].multiply(cofactor(matrix, 0, i, size)));
        }

        return det;
    }


    // Cofactor (Алгебраическое дополнение)
    private ComplexNumber cofactor(ComplexNumber[][] matrix, int row, int columns, int size) {
        ComplexNumber[][] minor = new ComplexNumber[size - 1][size - 1];

        for (int i = 0, minorRow = 0; i < size; i++) {
            // Проверка на вычеркивание строки
            if (i == row) continue;
            for (int j = 0, minorCol = 0; j < size; j++) {
                // Проверка на вычеркивание столбца
                if (j == columns) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }

        ComplexNumber determinantOfMinor = calculateDeterminant(minor, size - 1);
        return (columns % 2 == 0) ? determinantOfMinor : determinantOfMinor.multiply(new ComplexNumber(-1, 0));
    }


    // Деление матрицы на другую матрицу
    public ComplexMatrix divide(ComplexMatrix other) {
        if (other.rows != other.columns) {
            throw new IllegalArgumentException("Деление возможно только на квадратную матрицу.");
        }

        // Находим обратную матрицу для второй матрицы
        ComplexMatrix inverseOther = other.inverse();

        return this.multiply(inverseOther);
    }


    public ComplexMatrix inverse() {
        if (rows != columns) {
            throw new IllegalArgumentException("Матрица должна быть квадратной.");
        }

        ComplexNumber det = determinant();
        if (det.getReal() == 0 && det.getImaginary() == 0) {
            throw new ArithmeticException("Обратная матрица не существует, так как детерминант равен нулю.");
        }

        ComplexMatrix adjugateMatrix = adjugate(); // Находим присоединенную матрицу
        ComplexMatrix inverseMatrix = new ComplexMatrix(rows, columns);

        // Каждую элемент присоединенной матрицы делим на детерминант
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                inverseMatrix.matrix[i][j] = adjugateMatrix.matrix[i][j].divide(det);
            }
        }

        return inverseMatrix;
    }

    // Присоединенная матрица это транспонированная матрица алгебраических дополнений
    private ComplexMatrix adjugate() {
        ComplexMatrix adjugateMatrix = new ComplexMatrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                adjugateMatrix.matrix[i][j] = cofactor(matrix, i, j, rows);
            }
        }

        return adjugateMatrix.transpose();
    }

    // Метод генерации случайной матрицы
    public void fillWithRandomValues(double minReal, double maxReal, double minImaginary, double maxImaginary) {
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // nextDouble() генерирует случайное число от 0 до 1
                double real = minReal + (maxReal - minReal) * random.nextDouble();
                double imaginary = minImaginary + (maxImaginary - minImaginary) * random.nextDouble();
                matrix[i][j] = new ComplexNumber(real, imaginary);
            }
        }
    }


    // Переопределение метода toString для красивого вывода матрицы
    @Override
    public String toString() {
        /**
         * Создаем объект StringBuilder для эффективной конкатенации строк
         * (так как строки в Java неизменяемы, и каждая конкатенация создает новый объект)
         */
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < rows; i++) {    // Проходим по каждой строке матрицы, где row — это массив ComplexNumber
            sb.append("  [ ");
            for (int j = 0; j < columns; j++) { // Проходим по каждому элементу строки (каждый элемент — это ComplexNumber)
                sb.append(matrix[i][j].toString()); // Добавляем строковое представление элемента
                if (j < columns - 1) {
                    sb.append(", ");
                }

            }
            sb.append(" ]");
            if (i < rows - 1) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
