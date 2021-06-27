package learningStaticInnerClass;

public class learningStaticInnerClass {
    public static void main(String[] args) {

        var values = new double[20];
        for(int i =0; i< values.length; i++){
            values[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg{
    /* Difference between the static inner class and the simple inner class
    * is that static inner class doesn't have reference to the outer class
    * and the word static suppress this reference
    *
    * Good example when it is needed if we need to find the min and max in array.
    * If the project is large then it is quite common that someone might also utilize this name
    * Hence, when we make class static we can call the method via ArrayAlg.Pair*/
    public static class Pair{
        private final double first;
        private final double second;

        public Pair(double aFirst, double aSecond){
           this.first = aFirst;
           this.second = aSecond;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }
    /**
     * Computes both the minimum and the maximum of an array
     * @param values an array of floating-point numbers
     * @return a pair whose first element is the minimum and whose second element * is the maximum
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY; double max = Double.NEGATIVE_INFINITY; for (double v : values)
        {
            if (min > v) min = v;
            if (max < v) max = v; }
        return new Pair(min, max); }

}
