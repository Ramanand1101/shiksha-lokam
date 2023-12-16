/* 
 
Given a string s, find the ASCII value of each character iteratively. If the ASCII value is even, increment the next character by (ASCII_value % 7). If the ascii value is odd, decrement the previous character by (ASCII_value % 5). Output the newly formed string. 
Note:
If a character has already been changed once, do not change that character again. 
If the new number is an invalid ASCII value, replace it with 83. 
 */

public class ASCIITransform {
    public static void main(String[] args) {
        String input = "sHQen}";
        String transformedString = transformString(input);
        System.out.println("Final Answer: " + transformedString);
    }

    public static String transformString(String input) {
        char[] chars = input.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            int asciiValue = (int) chars[i];

            if (asciiValue % 2 == 0) {
                if (i + 1 < length) {
                    int increment = asciiValue % 7;
                    int nextAscii = (int) chars[i + 1] + increment;

                    if (nextAscii > 127 || nextAscii < 0) {
                        chars[i + 1] = 'S'; // Replace with 'S' if out of ASCII range
                    } else {
                        chars[i + 1] = (char) nextAscii;
                    }
                }
            } else {
                if (i - 1 >= 0) {
                    int decrement = asciiValue % 5;
                    int prevAscii = (int) chars[i - 1] - decrement;

                    if (prevAscii > 127 || prevAscii < 0) {
                        chars[i - 1] = 'S'; // Replace with 'S' if out of ASCII range
                    } else {
                        chars[i - 1] = (char) prevAscii;
                    }
                }
            }
        }
        return new String(chars);
    }
}
