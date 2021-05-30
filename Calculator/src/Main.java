package Calculator.src;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение. Для помощи введите \"help\". " +
                "Для выхода введите \"exit\".");
        Scanner scanner = new Scanner(System.in);
        String first;
        String second;
        String operand;
        String input;
        int num1;
        int num2;

        while (!(input = scanner.nextLine()).equals("")) {
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("Калькулятор принимает только арабские или только римские числа от 1 до 10 включительно. " +
                        "Разделите числа и знак операнда пробелами.");
            } else {
                String[] inputEx = Converter.inputToData(input);
                Validator.isInputDataValid(inputEx);
                first = inputEx[0];
                second = inputEx[2];
                operand = inputEx[1];

                if (Validator.isArabian(first, second)) {
                    Validator.isInRange(first, second);
                    num1 = Integer.parseInt(first);
                    num2 = Integer.parseInt(second);
                    System.out.println(operation(num1, num2, operand));
                } else if (Validator.isRoman(first, second)) {
                    Map<String, Integer> romanNumbers = IntegerData.getRomanToArabicMap();
                    num1 = romanNumbers.get(first.toUpperCase());
                    num2 = romanNumbers.get(second.toUpperCase());
                    int result = operation(num1, num2, operand);
                    System.out.println(Converter.toRoman(result));
                } else {
                    throw new RuntimeException("Пожалуйста введите арабские или римские числа");
                }
            }
        }
    }

    private static int operation(int first, int second, String operand) {
        switch (operand) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new RuntimeException("Неизвестный операнд, введите: -, +, *, /");
        }
    }
}
