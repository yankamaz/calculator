import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение в формате 'число1 оператор число2': ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] tokens = input.trim().split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода!");
        }

        int operand1 = parseNumber(tokens[0]);
        int operand2 = parseNumber(tokens[2]);
        String operator = tokens[1];

        int result;
        switch (operator) {
            case "+" -> result = operand1 + operand2;
            case "-" -> result = operand1 - operand2;
            case "*" -> result = operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль недопустимо!");
                }
                result = operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Ложный оператор!");
        }

        return String.valueOf(result);
    }

    private static int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 1 || number > 10) {
                throw new IllegalArgumentException("Числа должны быть целыми, от 1 до 10!");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное число: " + token);
        }
    }
}