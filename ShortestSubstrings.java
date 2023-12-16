/* Assignment 1:
Given a string s and a number x, print the shortest substrings which start and end with the same character and have lengths greater than or equal to x. If multiple substrings exist with the same shortest length, print them all. 
*/
//Code===>
import java.util.ArrayList;
import java.util.List;

public class ShortestSubstrings {
    public static void printShortestSubstrings(String s, int x) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + x - 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String substring = s.substring(i, j + 1);
                    if (substring.length() >= x && (result.isEmpty() || substring.length() < result.get(0).length())) {
                        result.clear();
                        result.add(substring);
                    } else if (substring.length() >= x && substring.length() == result.get(0).length()) {
                        result.add(substring);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println("not-found");
        } else {
            for (String sub : result) {
                System.out.print(sub + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "abccdbacca";

        int[] valuesOfX = {3, 4, 5, 6, 7, 8};

        for (int x : valuesOfX) {
            System.out.println("x = " + x);
            printShortestSubstrings(s, x);
            System.out.println();
        }
    }
}
