package learningLeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            int difference = target - nums[i];
            if(hashmap.containsKey(nums[i])){
                result[1] = hashmap.get(nums[i]);
                result[0] = i;
                return result;
            }else{
                hashmap.put(difference, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] example = {2,7,11,15};
        System.out.println(Arrays.toString(TwoSum.twoSum(example, 9)));
    }
}
