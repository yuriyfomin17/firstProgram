package algorithms;

public class euclidAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(270, 192));
    }
    // Euclid algorithm
    public static int gcd(int num , int r){
        // if remainder is zero then return the number as it means
        if (r == 0) return num;
        int q = num % r;
        return gcd(r, q);
    }
}
