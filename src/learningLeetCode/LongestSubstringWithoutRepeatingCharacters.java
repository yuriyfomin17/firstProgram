package learningLeetCode;


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int windowLength = Integer.MIN_VALUE;
        HashSet<Character> hashSet = new HashSet<>();
        while (end< s.length()){
            Character currChar = s.charAt(end);
            if(!hashSet.contains(currChar)){
                hashSet.add(currChar);
                end+=1;
                windowLength = Math.max(end - start, windowLength);
            } else {
               hashSet.clear();
               start+=1;
               end = start;
            }
        }
        return windowLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
