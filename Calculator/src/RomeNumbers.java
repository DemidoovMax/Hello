import java.util.HashMap;

public class RomeNumbers {

    static HashMap<String, Integer> romanNumbers = new HashMap<String, Integer>();

    static {
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
    }
    /*static String toArabian(String a) {
        switch (a) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
            default:
                return "0";
        }

        } */


}

