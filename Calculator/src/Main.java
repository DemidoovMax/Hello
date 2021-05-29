package Calculator.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int num1 = 0;
    static int num2 = 0;
    static ArrayList<String> arab = new ArrayList<>(Arrays.asList("10", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    static ArrayList<String> rome = new ArrayList<>(Arrays.asList("X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI"));

    public static void main(String[] args) {
        System.out.println("Введите выражение, разделите числа и знак операции пробелами. Для выхода введите \"exit\".");
        Scanner scanner = new Scanner(System.in);
        String a;
        String b;
        String op;
        String input;

        while (!(input = scanner.nextLine()).equals("")) {
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] inputEx = input.split(" ");
            a = inputEx[0];
            b = inputEx[2];
            op = inputEx[1];

            if (isArabian(a, b)) {
                isInRange(a, b);
                num1 = Integer.parseInt(a);
                num2 = Integer.parseInt(b);
                System.out.println(operation(num1, num2, op));
            } else if (isRoman(a, b)) {
                num1 = RomanNumbers.getRomanNumbers().get(a.toUpperCase());
                num2 = RomanNumbers.getRomanNumbers().get(b.toUpperCase());
                int result = operation(num1, num2, op);
                System.out.println(result);
            } else {
                throw new RuntimeException("Пожалуйста введите арабские или римские числа");
            }
        }
    }

    private static int operation(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("Неизвестный операнд, введите: -, +, *, /");
        }
    }

    static boolean isArabian(String a, String b) {
        return arab.contains(a) && arab.contains(b);
    }

    private static boolean isRoman(String a, String b) {
        return rome.contains(a.toUpperCase()) && rome.contains(b.toUpperCase());
    }

    private static void isInRange(String first, String second) {
        if (Integer.parseInt(first) < 0 || Integer.parseInt(first) > 10 || Integer.parseInt(second) < 0 || Integer.parseInt(second) > 10) {
            throw new NumberFormatException("Введите числа от 1 до 10 включительно");
        }
    }
}

