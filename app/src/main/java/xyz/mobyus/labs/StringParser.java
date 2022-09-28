package xyz.mobyus.labs;

import java.util.StringTokenizer;

public class StringParser {
    public static int CountStrings(String textFieldInput){
        StringTokenizer words = new StringTokenizer(textFieldInput);
        int countStrings = words.countTokens();
        return countStrings;
    }
    public static int CountChars(String textFieldInput) {
        String[] chars = textFieldInput.split("\\s");
        int countChars = textFieldInput.length();
        return countChars;
    }
}
