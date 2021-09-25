package algorithms;

public class sqrtNewtonMethod {
    public static void main(String[] args) {
        System.out.println(newtonianSquare(5));
    }
    public static double newtonianSquare(double num){
        double err = 1e-15;
        double sqrtNum = num;
        while (Math.abs(sqrtNum - num / sqrtNum) > err){
            sqrtNum = (sqrtNum + num / sqrtNum) * 0.5;
        }
        return sqrtNum;
    }
}
