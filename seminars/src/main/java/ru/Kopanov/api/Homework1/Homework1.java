package ru.Kopanov.api.Homework1;
import java.util.Scanner;

public class Homework1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Задания:
                    1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
                    2) Вывести все простые числа от 1 до 1000
                    3) Реализовать простой калькулятор
                    4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
                    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
                    5) Выход.

                    """);
            System.out.print("Введите номер задания: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Введите n: ");
                    int n = scanner.nextInt();
                    int[] value = triangle_number(n);
                    System.out.printf("%d-ое треугольного число = %d\n", n, value[0]);
                    System.out.printf("%d!= %d\n\n", n, value[1]);
                }
                case 2 -> all_simple_numbers();
                case 3 -> simple_calculator();
                case 4 -> restore_equation();
                case 5 -> flag = false;
                default -> System.out.println("Введен недопустимый номер задания");
            }
        }
        scanner.close();
    }


    public static int[] triangle_number(int number) {
        int[] result = new int[2];
        result[0] = number * (number + 1) / 2;
        result[1] = factorial(number);
        return result;
    }

    public static int factorial(int number) {
        if (number == 0) return 1;
        else return number * factorial(number - 1);
    }

    public static void all_simple_numbers() {
        int flag = 0;
        for (int i = 1; i <= 1000; i++) {
            int counter = 0;
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) counter++;
                if (counter > 1) break;
            }
            if (counter == 1 && i != 1) {
                System.out.printf("%d\t", i);
                flag++;
            }
            if (flag == 21) {
                System.out.println();
                flag = 0;
            }
        }
        System.out.println("\n");
    }

    public static void simple_calculator() {
        boolean flag = true;
        while (flag) {
            System.out.print("Введите первое число: ");
            double first_number = scanner.nextDouble();
            System.out.print("Введите оператор (+, -, *, /, ^):");
            scanner.nextLine();
            String operator = scanner.nextLine();
            System.out.print("Введите второе число: ");
            double second_number = scanner.nextDouble();
            switch (operator) {
                case "+" ->
                        System.out.printf("%f + %f = %f\n", first_number, second_number, first_number + second_number);
                case "-" ->
                        System.out.printf("%f - %f = %f\n", first_number, second_number, first_number - second_number);
                case "*" ->
                        System.out.printf("%f * %f = %f\n", first_number, second_number, first_number * second_number);
                case "/" -> {
                    if (second_number == 0) {
                        System.out.println("Ошибка: Деление на ноль !");
                        break;
                    }
                    System.out.printf("%f / %f = %f\n", first_number, second_number, first_number / second_number);
                }
                case "^" ->
                        System.out.printf("%f ^ %f = %f\n", first_number, second_number, Math.pow(first_number, second_number));
                default -> System.out.println("Введен недопустимый оператор!");
            }
            System.out.println();
            while (flag) {
                System.out.println("Введите:\n1 - для продолжения работы с калькулятором;\n2 - для выхода.\n");
                int choice = scanner.nextInt();
                if (choice == 1) break;
                else if (choice == 2) flag = false;
                else System.out.println("Введено недопустимое значение");
            }
        }
    }

    public static void restore_equation() {
        System.out.println("Введите уравнение вида: q + w = e, q, w, e >= 0.\n" +
                "Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.");
        scanner.nextLine();
        String equation = scanner.nextLine();
        equation = equation.replace(" ", "");
        int flag = 0;
        int position = 0;
        int first_number_lenght = equation.indexOf('+');
        int second_number_lenght = -equation.indexOf('+') + equation.indexOf('=') - 1;
        char[] first_number = new char[first_number_lenght];
        char[] second_number = new char[second_number_lenght];
        char[] result = new char[equation.length() - 2 - second_number_lenght - first_number_lenght];
        for (int i = 0; i < equation.length(); i++) {
            switch (flag) {
                case 0 -> {
                    if (equation.charAt(i) == '+') {
                        flag = 1;
                        position = 0;
                    } else first_number[position++] = equation.charAt(i);
                }
                case 1 -> {
                    if (equation.charAt(i) == '=') {
                        flag = 2;
                        position = 0;
                    } else second_number[position++] = equation.charAt(i);
                }
                case 2 -> result[position++] = equation.charAt(i);
            }
        }
        int first_number_question_index = findIndex(first_number, '?');
        int second_number_question_index = findIndex(second_number, '?');
        int result_question_index = findIndex(result, '?');

        int first_number_int = charToInt(first_number, first_number_question_index);
        int second_number_int = charToInt(second_number, second_number_question_index);
        int result_int = charToInt(result, result_question_index);

        boolean match = false;
        if (first_number_question_index == -1 && second_number_question_index != -1) {
            for (int i = 0; i < 10; i++) {
                if (first_number_int + second_number_int + i * (int)Math.pow(10, second_number.length - second_number_question_index - 1) == result_int) {
                    match = true;
                    System.out.printf("%d + %d = %d\n", first_number_int, second_number_int + i *(int)Math.pow(10, second_number.length - second_number_question_index - 1), result_int );
                }
            }
        }
        else if (first_number_question_index != -1 && second_number_question_index == -1){
            for (int i = 0; i < 10; i++) {
                if (first_number_int + second_number_int + i * (int)Math.pow(10, first_number.length - first_number_question_index - 1) == result_int) {
                    match = true;
                    System.out.printf("%d + %d = %d\n", first_number_int + i *(int)Math.pow(10, first_number.length - first_number_question_index - 1), second_number_int, result_int );
                }
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (first_number_int + second_number_int + i * (int)Math.pow(10, first_number.length - first_number_question_index - 1) +
                            j * (int)Math.pow(10, second_number.length - second_number_question_index - 1) == result_int) {
                        match = true;
                        System.out.printf("%d + %d = %d\n", first_number_int + i *(int)Math.pow(10, first_number.length - first_number_question_index - 1),
                                second_number_int + j * (int)Math.pow(10, second_number.length - second_number_question_index - 1), result_int );
                    }
                }
            }
        }
        if (!match) {
            System.out.println("Подходящего значения '?' не найдено!");
        }
    }

    public static int findIndex(char[] arr, char element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int charToInt(char[] array, int position){
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != position)
                result += Character.getNumericValue(array[i]) * (int)Math.pow(10, array.length-i - 1);
        }
        return result;
    }
}