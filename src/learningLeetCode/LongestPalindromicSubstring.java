package learningLeetCode;


import java.util.ArrayList;

class Solution {
    /* Brute Force
     * Time Complexity - O(n^3)
     * Space Complexity - O(1)
     * */
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
    }

    /* Time Complexity is O(n^2)
    *  Space complexity is O(1)*/
    static public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        String result = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() && result.length() < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s,  i,i + 1);
            int len3 = Math.max(len2, len1);
            if(len3 > end - start){
                start = i - (len3 - 1) /2;
                end = i + len3 / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    static public Integer expandAroundCenter(String s, Integer start, Integer end){

        while (start>=0 && end <s.length() && s.charAt(end) == s.charAt(start)){
            start-=1;
            end+=1;
        }
        return end - start - 1;
    }



    public static void main(String[] args) {
        String string1 = "aaabaaaa";
        System.out.println(longestPalindrome2(string1));
    }
}
