package learningLeetCode;

public class AtoiStringToInteger {
    public static void main(String[] args) {
        System.out.println(AtoiStringToInteger.myAtoi("-91283472332"));
    }
    static int myAtoi(String s) {
        int count = 0;
        var number = new StringBuilder();
        boolean firstNumber = false;
        while (count< s.length()){
            char currChar = s.charAt(count);
            if (Character.isDigit(currChar) || (currChar == '-'&& !firstNumber)){
                firstNumber = true;
                number.append(currChar);
                if (Character.isDigit(currChar)){
                    long currResult = Long.parseLong(number.toString());
                    if (currResult > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                    if (currResult < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
            }else if(!Character.isDigit(currChar) && currChar!= ' ' && !firstNumber){
                return 0;
            } else if (currChar == '.'){
                return Integer.parseInt(number.toString());
            }
            count+=1;
        }
        return Integer.parseInt(number.toString());
    }
}
