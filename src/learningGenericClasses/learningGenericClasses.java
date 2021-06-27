package learningGenericClasses;

public class learningGenericClasses {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        double middle = ArrayAlg.getMiddle(3.14, 1729.0, 0.0);
    }
}

@SuppressWarnings("rawtypes")
class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }

    /*
     * Class can also have a generic methods
     * */
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
    /*
    * to utilize methods of objects in generic methods
    * we need to make sure that correct interface is implemented
    *
    * note that word extends was used which is usually applied to classes
    * because both T and the bounding type can be either a class or an interface
    *
    * */
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++)
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        return smallest;
    }


}

/* Example of the generic class
 *
 * */
class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}

/*
 * During the code compilation the compiler translates the generic methods to the normal methods nad classes
 * e.g.public static <T extends Comparable> T min(T[] a) ---> public static Comparable min(Comparable[] a)
 *
 * It often the case that bridge methods are created in generic class and not only. For example Employee.clone and Object.clone
 * the first override the latter but in reality synthesized bridge method calls the newly defined method Employee.clone.
 * Same thing but in generic classes too. Synthesized method is created if the type erasure interferes with the polymorphism
 *
 *
 * class DateInterval extends Pair<LocalDate> {
 *   public LocalDate getSecond() { return (LocalDate) super.getSecond(); }
 *   .. .
 * }
 * LocalDate getSecond() // defined in DateInterval
 * Object getSecond() // overrides the method defined in Pair to call the first method
 *
 *  In summary following things should be remembered about generic classes
 *  1. There are no generics in the virtual machine, only ordinary classes and methods.
 *
 *  2. All type parameters are replaced by their bounds. I.e if we expect variable to have some sort of method then we can make
 *     generic class to extend an interface.
 *
 *  3. Bridge method are synthesized to preserve polymorphism
 *
 *  4. Casts are inserted as necessary to preserve type safety
 *
 *  <----------------------------------------Inheritence rule in Generic Classes------------------------------------------------->
 *
 * Also, note that if class Manager extends Employee and we will implement them with generic Class then we won't be able to
 * have an inheritence of manager from employee class. As this is necessary for safety precaution
 *
 * This is might be possible
 *   var managerBuddies = new Pair<Manager>(ceo, cfo);
 *   Pair<Employee> employeeBuddies = managerBuddies; // illegal, but suppose it wasn't
 *   employeeBuddies.setFirst(lowlyEmployee);
 * which is illegal as an array remembers the members that is stored in it and it will throw
 * an ArrayStoreException
 * */