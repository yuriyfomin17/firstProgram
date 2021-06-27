package learningLeetCode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    /* Time complexity is O(2n) = O(n)
    *  Space complexity is O(min(m, n)) as we need O(k) space for sliding window */
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
    /* Time complexity is O(n) = O(n)
     *  Space complexity is O(min(m, n)) as we need O(k) space for sliding window */
    static int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int end = 0;
        int windowLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (end< s.length()){
            Integer charCode = s.codePointAt(end);
            var index = hashMap.get(charCode);
            if(index!= null && index< end && index >=start){
                start = index + 1;
            }
            windowLength = Math.max(end - start + 1, windowLength);
            hashMap.put(charCode, end);
            end +=1;
        }
        return windowLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }
}
