import java.util.HashMap;
import java.util.Map;

public class BayerMoorePatternMatching {

    public static int findFirstOccurence (String text, String pattern){
        if (pattern.length() == 0) return 0;

        // initialize last Map
        Map<Character, Integer> last = new HashMap<>();
        text.chars().mapToObj(i -> (char)i).forEach(c ->last.put(c, -1));
        for (int i = 0; i < pattern.length(); i++) last.put(pattern.charAt(i), i);

        // start actual algorithm
        int indexText = pattern.length() - 1;
        int indexPattern = indexText;

        for (char textChar = text.charAt(indexText); indexText < text.length(); textChar = text.charAt(indexText)){
            printPosition(text, indexText);
            printPosition(pattern, indexPattern);
            if (textChar == pattern.charAt(indexPattern)) {
                printLnInColor("match", AnsiEscapeCodes.BLUE);
                if (indexPattern == 0) return indexText;
                indexText--;
                indexPattern--;
            } else {
                printLnInColor("no match, indexText += " + pattern.length()
                        + " - min(" + indexPattern + ", " + (1 + last.get(textChar)) + ")", AnsiEscapeCodes.YELLOW);
                indexText += pattern.length() - Math.min(indexPattern, 1 + last.get(textChar));
                indexPattern = pattern.length() - 1;
            }
            System.out.println();
        }
        return -1;
    }

    private static void printPosition(String text, int position) {
        for(int i = 0; i < text.length(); i++){
            if (i == position) System.out.print(AnsiEscapeCodes.RED.toString() + text.charAt(i)
                    + AnsiEscapeCodes.RESET.toString());
            else System.out.print(text.charAt(i));
        }
        System.out.println();
    }

    private static void printLnInColor(String text, AnsiEscapeCodes color){
        System.out.println(color + text + AnsiEscapeCodes.RESET);
    }
}
