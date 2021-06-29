package learningLeetCode;

import java.util.ArrayList;
/* Brute Force
 * Time Complexity - O(n^3)
 * Space Complexity - O(1)
 * */
class Solution {
    static public String longestPalindrome(String s) {
        if (s.length() ==1){
            return s;
        }
        String result = "";
        int maxStringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (j> i){
                    String currString = s.substring(i, j);
                    if (currString.length() > maxStringLength && checkPalindrome(currString)){
                        maxStringLength = currString.length();
                        result = currString;
                    }
                }

            }
        }


        return result;
    }

    static public Boolean checkPalindrome(String s){
        boolean aPalindrome = true;
        for (int i = 0; i < s.length()/2 && aPalindrome; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                aPalindrome = false;
                break;
            }
        }
        return aPalindrome;
    };
    public static void main(String[] args) {
        String string1 = "bab";
        System.out.println(longestPalindrome(string1));
    }
}
