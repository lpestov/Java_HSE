package lab1;

public class ComplexNumber {
    // Поля
    private double real;
    private double imaginary;

    // Конструктор
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Геттеры
    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    // Методы
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public boolean equals(ComplexNumber other) {
        return this.real == other.real && this.imaginary == other.imaginary;
    }

    // Переопределение метода toString для красивого вывода комплексного числа
    @Override
    public String toString() {
        String realPart;
        String imaginaryPart;

        // Определяем, как выводить реальную часть
        if (real == (long) real) {
            realPart = String.format("%d", (long) real);  // Выводим без незначащих нулей для целых чисел
        } else {
            realPart = String.format("%.2f", real);  // Для дробных чисел выводим с двумя знаками после запятой
        }

        // Определяем, как выводить мнимую часть
        if (imaginary == (long) imaginary) {
            imaginaryPart = String.format("%d", (long) imaginary);  // Выводим без незначащих нулей для целых чисел
        } else {
            imaginaryPart = String.format("%.2f", imaginary);  // Выводим с двумя знаками после запятой для дробных чисел
        }

        // Построение строки в зависимости от знака мнимой части
        if (real == 0 && imaginary == 0) {
            return "0";  // Если обе части равны 0
        } else if (real == 0) {
            return String.format("%si", imaginaryPart);  // Если только реальная часть равна 0
        } else if (imaginary == 0) {
            return realPart;  // Если только мнимая часть равна 0
        } else if (imaginary > 0) {
            return String.format("%s + %si", realPart, imaginaryPart);  // Если мнимая часть положительная
        } else {
            return String.format("%s - %si", realPart, imaginaryPart.substring(1));  // Если мнимая часть отрицательная
        }
    }


}

