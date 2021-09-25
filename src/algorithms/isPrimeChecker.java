package algorithms;

public class isPrimeChecker {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(7500));
    }
    public static boolean isPrimeNumber(int num){
        if (num < 2) return false;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
