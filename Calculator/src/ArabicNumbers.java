import java.util.HashMap;

public class ArabicNumbers {
    private final static HashMap<Integer, String> romanNumbers = new HashMap<>();

    static {
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

    public static String toRoman(int arabic) {
        StringBuilder romanNumber;
        if (arabic > 10) {
            for (int i = 100; i >= 10 ; i-= 10) {
                if (arabic % i != 0) {
                    romanNumber += romanNumbers.get(i);
                } arabic -= i;
            }
        } else {

        }
    }
}
