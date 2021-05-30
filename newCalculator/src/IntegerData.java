import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntegerData {
    private final static HashMap<String, Integer> romanToArabicMap = new HashMap<>();
    private final static HashMap<Integer, String> arabicToRomanMap = new HashMap<>();

    private final static ArrayList<String> arab = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    private final static ArrayList<String> rome = new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));

    static {
        // заполнение карты римских к арабским
        romanToArabicMap.put("I", 1);
        romanToArabicMap.put("II", 2);
        romanToArabicMap.put("III", 3);
        romanToArabicMap.put("IV", 4);
        romanToArabicMap.put("V", 5);
        romanToArabicMap.put("VI", 6);
        romanToArabicMap.put("VII", 7);
        romanToArabicMap.put("VIII", 8);
        romanToArabicMap.put("IX", 9);
        romanToArabicMap.put("X", 10);
        romanToArabicMap.put("XX", 20);
        romanToArabicMap.put("XXX", 30);
        romanToArabicMap.put("XL", 40);
        romanToArabicMap.put("L", 50);
        romanToArabicMap.put("LX", 60);
        romanToArabicMap.put("LXX", 70);
        romanToArabicMap.put("LXXX", 80);
        romanToArabicMap.put("XC", 90);
        romanToArabicMap.put("C", 100);

        // заполнение карты арабских к римским
        arabicToRomanMap.put(0, "NULLA");
        arabicToRomanMap.put(1, "I");
        arabicToRomanMap.put(2, "II");
        arabicToRomanMap.put(3, "III");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(6, "VI");
        arabicToRomanMap.put(7, "VII");
        arabicToRomanMap.put(8, "VIII");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(20, "XX");
        arabicToRomanMap.put(30, "XXX");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(60, "LX");
        arabicToRomanMap.put(70, "LXX");
        arabicToRomanMap.put(80, "LXXX");
        arabicToRomanMap.put(90, "XC");
        arabicToRomanMap.put(100, "C");
    }

    public static HashMap<String, Integer> getRomanToArabicMap() {
        return romanToArabicMap;
    }

    public static HashMap<Integer, String> getArabicToRomanMap() {
        return arabicToRomanMap;
    }

    public static ArrayList<String> getArab() {
        return arab;
    }

    public static ArrayList<String> getRome() {
        return rome;
    }
}
