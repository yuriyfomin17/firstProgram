package algorithms;

public class HarmonicNumber {
    public static void main(String[] args) {
        System.out.println(HarmonicNum(5));
    }
    public static double HarmonicNum(int N){
        double sum = 0;
        for (int i = 1; i <= N ; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}
