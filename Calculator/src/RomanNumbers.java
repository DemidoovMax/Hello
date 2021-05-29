package Calculator.src;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {

    private final static HashMap<String, Integer> romanNumbers = new HashMap<>();

    static {
        romanNumbers.put("I", 1);
        romanNumbers.put("II", 2);
        romanNumbers.put("III", 3);
        romanNumbers.put("IV", 4);
        romanNumbers.put("V", 5);
        romanNumbers.put("VI", 6);
        romanNumbers.put("VII", 7);
        romanNumbers.put("VIII", 8);
        romanNumbers.put("IX", 9);
        romanNumbers.put("X", 10);
        romanNumbers.put("XX", 20);
        romanNumbers.put("XXX", 30);
        romanNumbers.put("XC", 40);
        romanNumbers.put("C", 50);
        romanNumbers.put("CX", 60);
        romanNumbers.put("CXX", 70);
        romanNumbers.put("CXXX", 80);
        romanNumbers.put("XL", 90);
        romanNumbers.put("L", 100);
    }

    public static String toRoman(int arabic) {
        if (arabic > 10) {
            for (int i = 100; i >= 10 ; i-= 10) {
                int i1 = arabic % i;

            }
        } else {

        }
    }

    public static Map<String, Integer> getRomanNumbers() {
        return romanNumbers;
    }
}
