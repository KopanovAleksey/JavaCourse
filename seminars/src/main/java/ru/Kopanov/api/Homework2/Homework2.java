package ru.Kopanov.api.Homework2;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Homework2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Задание:
                             1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
                             Данные для фильтрации приведены ниже в виде json-строки.
                             Если значение null, то параметр не должен попадать в запрос.
                             Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
                             
                             2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
                             
                    Дополнительные задания:
                             
                             3) Дана json-строка (можно сохранить в файл и читать из файла)
                             [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
                             {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
                             {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
                             Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:\s
                             Студент [фамилия] получил [оценка] по предмету [предмет].
                             Пример вывода:
                             Студент Иванов получил 5 по предмету Математика.
                             Студент Петрова получил 4 по предмету Информатика.
                             Студент Краснов получил 5 по предмету Физика.
                             
                             4) К калькулятору из предыдущего ДЗ добавить логирование.
                             
                    """);
            System.out.print("Введите номер задания или нажмите \"5\" для выхода:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice != 5) {
                switch (choice) {
                    case 1 -> {
                        String[] parameters = {"name", "country", "city", "age"};
                        System.out.println(sql_request_creator(parameters));
                    }
                    case 2 -> {
                        System.out.println("Введите элементы массива через пробел:");
                        String[] array_sequence = scanner.nextLine().split(" ");
                        bubbleSort_to_log(array_sequence);
                    }
                    case 3 -> {
                        File file = new File("C:\\Users\\User\\Desktop\\JAVA\\seminars\\src\\main\\java\\ru\\Kopanov\\api\\Homework2\\file.json");
                        try (FileReader fr = new FileReader(file)) {
                            StringBuilder sb = new StringBuilder();
                            int c;
                            while ((c = fr.read()) != -1) {
                                sb.append((char) c);
                            }
                            json_string_parse((sb.toString()));
                        } catch (IOException ex) {

                        }
                    }
               case 4 -> simple_calculator();
                    default -> System.out.println("Введен недопустимый номер задания");
                }
                System.out.print("\nPress any key to continue \n");
                scanner.nextLine();
            } else {
                flag = false;
            }
        }
    }

    public static String sql_request_creator(String[] array) {
        String[] values = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите параметр \"%s\" sql-запроса:", array[i]);
            values[i] = scanner.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where ");
        for (int i = 0; i < array.length; i++) {
            if (values[i] != "") {
                sb.append("\"").append(array[i]).append("\"").append(":").append(values[i]).append("; ");
            }
        }
        return sb.toString();
    }

    public static void bubbleSort_to_log(String[] array) {
        try {
            File logfile = new File("C:\\Users\\User\\Desktop\\JAVA\\seminars\\src\\main\\java\\ru\\Kopanov\\api\\Homework2\\log.txt");
            FileWriter fileWriter = new FileWriter(logfile);
            fileWriter.write("Initial array: " + Arrays.toString(array) + "\n");
            int n = 1;
            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])) {
                        isSorted = false;
                        String temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
                fileWriter.write(n++ + ") " + Arrays.toString(array) + "\n");
            }
            fileWriter.write("Array is sorted for " + (n - 1) + " iterations.");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Success! Check log_file for details !");
        } catch (IOException ex) {
            System.out.println("Unexpected error acquired !");
        }
    }

    public static void json_string_parse(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int counter = 0;
        for (char aChar : chars) {
            if (Character.isLetterOrDigit(aChar)) {
                sb.append(aChar);
                counter++;
            } else if (!Character.isLetterOrDigit(aChar) && counter != 0) {
                counter = 0;
                sb.append(" ");
            }
        }
        String[] words = sb.toString().split(" ");
        sb.setLength(0);
        for (int i = 0; i < words.length - 1; i++) {
            if (Objects.equals(words[i], "фамилия")) {
                sb.append("Студент ").append(words[i + 1]).append(" ");
            } else if (Objects.equals(words[i], "оценка")) {
                sb.append("получил ").append(words[i + 1]).append(" ");
            } else if (Objects.equals(words[i], "предмет")) {
                sb.append("по предмету ").append(words[i + 1]).append(".\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void simple_calculator() throws IOException {
        Logger logger = Logger.getLogger(Homework2.class.getName());
        FileHandler fh = new FileHandler("C:\\Users\\User\\Desktop\\JAVA\\seminars\\src\\main\\java\\ru\\Kopanov\\api\\Homework2\\calc_log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        System.out.println("Welcome to a simple calculator !\n");
        logger.log(Level.INFO, "simple_calculator start\n");

        boolean flag = true;
        while (flag) {
            System.out.print("Введите первое число: ");
            double first_number = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите оператор (+, -, *, /, ^):");
            String operator = scanner.nextLine();
            System.out.print("Введите второе число: ");
            double second_number = Double.parseDouble(scanner.nextLine());
            String result;
            switch (operator) {
                case "+" -> {
                    result = String.format("%.2f + %.2f = %.2f\n", first_number, second_number, first_number + second_number);
                }
                case "-" -> {
                    result = String.format("%.2f - %.2f = %.2f\n", first_number, second_number, first_number - second_number);
                }
                case "*" -> {
                    result = String.format("%.2f * %.2f = %.2f\n", first_number, second_number, first_number * second_number);
                }
                case "/" -> {
                    if (second_number == 0) {
                        result = "Error: Zero division !\n";
                        break;
                    }
                    result = String.format("%.2f / %.2f = %.2f\n", first_number, second_number, first_number / second_number);
                }
                case "^" ->{
                    result = String.format("%.2f ^ %.2f = %.2f\n", first_number, second_number, Math.pow(first_number, second_number));
                }
                default -> {
                    result = "Wrong operator input !\n";
                }
            }
            logger.log(Level.INFO, String.format("Program result: %s", result));
            System.out.printf(result);
            while (flag) {
                System.out.println("Введите:\n1 - для продолжения работы с калькулятором;\n2 - для выхода.\n");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    logger.log(Level.INFO, "simple_calculator continue\n");
                    break;
                }
                else if (choice == 2) {
                    flag = false;
                    logger.log(Level.INFO, "simple_calculator stopped\n");
                    System.out.println("Goodbye !\n");

                }
                else {
                    logger.log(Level.INFO, "Wrong input !\n");
                    System.out.println("Wrong input !\n");
                }
            }
        }
    }
}
