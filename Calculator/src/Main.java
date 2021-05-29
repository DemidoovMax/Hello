import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int num1 = 0;
    static int num2 = 0;
    static ArrayList<String> arab = new ArrayList<>(Arrays.asList("10", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    static ArrayList<String> rome = new ArrayList<>(Arrays.asList("X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI"));

    public static void main(String[] args) {
        System.out.println("Введите выражение. Для выхода введите \"exit\".");
        Scanner scanner = new Scanner(System.in);
        String a;
        String b;
        String op;
        do {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] inputEx = input.split(" ");
            a = inputEx[0];
            b = inputEx[2];
            op = inputEx[1];
            if (Integer.parseInt(a) < 0 || Integer.parseInt(a) > 10 || Integer.parseInt(b) < 0 || Integer.parseInt(b) > 10) {
                throw new NumberFormatException("Неверный диапазон чисел");
        }
            if (isArabian(a, b)) {
                num1 = Integer.parseInt(a);
                num2 = Integer.parseInt(b);
                System.out.println(operation(num1, num2, op));
            }
            if (isRoman(a, b)) {
                a = RomeNumbers.toArabian(a);
                b = RomeNumbers.toArabian(b);
                num1 = Integer.parseInt(a);
                num2 = Integer.parseInt(b);
                int result = operation(num1, num2, op);
                System.out.println(result);
            }

        } while (true);

    }

    static int operation(int a, int b, String op) {
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
                return 0;
        }
    }

    static boolean isArabian(String a, String b) {
        if (arab.contains(a) && arab.contains(b)) {
            return true;
        } else
            return false;
    }

    static boolean isRoman(String a, String b) {
        if (rome.contains(a) && rome.contains(b)) {
            return true;
        } else
            return false;
    }
}

