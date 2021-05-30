import java.util.HashMap;

public class Converter {
    public static String[] inputToData(String input) {
        return input.split(" ");
    }

    public static String toRoman(int arabic) {
        HashMap<Integer, String> arabicToRomanMap = IntegerData.getArabicToRomanMap();
        if (arabic > 10) {
            for (int i = 100; i >= 10; i -= 10) {
                if (arabic == i) {
                    return arabicToRomanMap.get(i);
                } else if (arabic > i) {
                    int temp = arabic % i;
                    return arabicToRomanMap.get(i) + arabicToRomanMap.get(temp);
                }
            }
        }
        return arabicToRomanMap.get(arabic);
    }
}
