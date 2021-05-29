import java.util.HashMap;

public class RomeNumbers {

    static HashMap<Integer, String> romanNumbers = new HashMap<Integer, String>();

    static {
        romanNumbers.put(0, null);
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(6, "VI");
        romanNumbers.put(7, "VII");
        romanNumbers.put(8, "VIII");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(20, "XX");
        romanNumbers.put(30, "XXX");
        romanNumbers.put(40, "XC");
        romanNumbers.put(50, "C");
        romanNumbers.put(60, "CX");
        romanNumbers.put(70, "CXX");
        romanNumbers.put(80, "CXXX");
        romanNumbers.put(90, "XL");
        romanNumbers.put(100, "L");
        }

    static String toRoman(String a){
        String[] numerals = a.split("");
        String result;
        if (numerals.length == 3) {
            String third = romanNumbers.get(Integer.parseInt(numerals[2]));
            String second = romanNumbers.get(Integer.parseInt(numerals[1]) * 10);
            String first = romanNumbers.get(Integer.parseInt(numerals[0]) * 100);
            StringBuilder value = new StringBuilder().append(first).append(second).append(third);
            result = value.toString();
        } else if (numerals.length == 2) {
            String second = romanNumbers.get(Integer.parseInt(numerals[1]));
            String first = romanNumbers.get(Integer.parseInt(numerals[0]) * 10);
            StringBuilder value = new StringBuilder().append(first).append(second);
            result = value.toString();
        } else if (numerals.length == 1) {
            String first = romanNumbers.get(Integer.parseInt(numerals[0]));
            result = first;
        } else {
            throw new NumberFormatException("Введены неверные числа");
        }
            return result;
    }
}

