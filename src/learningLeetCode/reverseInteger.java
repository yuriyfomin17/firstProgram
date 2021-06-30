package learningLeetCode;

public class reverseInteger {
    /*
    * Time complexity is O(n) where n is the length of the string number
    * */
    static public int reverse(int x) {
        String integer = Integer.toString(x);
        String result = "";
        boolean negative = false;
        if (x < 0){
            negative = true;
        }
        for (int i = integer.length() -1; i>=0 ; i--) {
            if (!String.valueOf(integer.charAt(i)).equals("-") ){
                result += integer.charAt(i);
            }
        }
        try {
            int answer = negative ? Integer.parseInt(result) *-1: Integer.parseInt(result);
            return answer ;
        }catch(Exception e) {
            return 0;
        }


    }

    public static void main(String[] args) {
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
