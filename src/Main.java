
public class Main {
    public static void main(String[] args){
        String text = "abacaabacabacabaabb";
        String pattern = "abacab";
        int minIndex = BayerMoorePatternMatching.findFirstOccurence(text, pattern);
        System.out.println("\nminIndex = " + minIndex);
    }
}
