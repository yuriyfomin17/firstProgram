package algorithms;

public class euclidAlgorithm {
    public static void main(String[] args) {
        System.out.println(greatestCommonDenominator(192, 270));
    }
    static int greatestCommonDenominator(int numerator, int denominator){
        if (numerator % denominator == 0) return denominator;
        int remainder  = numerator % denominator;
        return greatestCommonDenominator(denominator, remainder);
    }
}
