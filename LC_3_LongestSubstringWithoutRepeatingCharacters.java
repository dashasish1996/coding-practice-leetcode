import java.util.ArrayList;
import java.util.List;

public class LC_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input = "abcccsdddhsiaodfdghhjkerty";
        System.out.println("Size of Longest Substring Without Repeating Characters: "+ lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            List<Character> currentWindow = new ArrayList<>();
            for(int j =i; j<s.length();j++){
                if(isElementInCurrentWindow(currentWindow, s.charAt(j))){
                    maxLength = Math.max(currentWindow.size(), maxLength);
                    break;
                } else {
                    currentWindow.add(s.charAt(j));
                }
            }
            maxLength = Math.max(currentWindow.size(), maxLength);
        }
        return maxLength;
    }
    private static boolean isElementInCurrentWindow(List<Character> currentWindow, Character c){
        return currentWindow.contains(c);
    }
}
