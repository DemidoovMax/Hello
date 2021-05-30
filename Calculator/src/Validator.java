package Calculator.src;

public class Validator {

    public static void isInputDataValid(String[] data) {
        if (data.length != 3) {
            throw new RuntimeException("Введите 2 значения и операнд через пробел, например: 1 + 2");
        }
    }

    public static boolean isArabian(String a, String b) {
        return IntegerData.getArab().contains(a) && IntegerData.getArab().contains(b);
    }

    public static boolean isRoman(String a, String b) {
        return IntegerData.getRome().contains(a.toUpperCase()) && IntegerData.getRome().contains(b.toUpperCase());
    }

    public static void isInRange(String first, String second) {
        if (Integer.parseInt(first) < 0 || Integer.parseInt(first) > 10 || Integer.parseInt(second) < 0 || Integer.parseInt(second) > 10) {
            throw new NumberFormatException("Введите числа от 1 до 10 включительно");
        }
    }
}
