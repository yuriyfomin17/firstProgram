import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class learnArray {
    public static void main(String[] args){
        var e1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var e2= new Employee("Alice Adams",75000, 1987, 12, 15 );
        var e3 = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(e1);
        staff.add(e2);
        staff.add(e3);
        System.out.println("size = " + staff.size());

        /*Yet this is faster option as during add process we have to create new array
        * and all the values there. hence, we can use ensureCapacity method
        * which makes sure that static amount of memory is allocated */
        ArrayList<Employee> staff2 = new ArrayList<>(3);
        staff2.add(new Employee("Alice Adams", 75000, 1987, 12, 15));
        staff2.add(new Employee("Alice Adams", 75000, 1987, 12, 15));
        staff2.add(new Employee("Alice Adams", 75000, 1987, 12, 15));
        System.out.println("size = " + staff2.size());
        var staff3 = new ArrayList<>(100);
        var staff4 = new Employee[100];
        /* Note that new ArrayList<>(100) is not the same as new Employee[100]
         * An array with the capacity of 100 has the potential of holding 100 elements
         * but at the begging it has no elements at all */


        /* Once size of an array won't change then use trimToSize method
        * this method would adjusts the size of the memory block to use exactly as much
        * storage is required to hold current number of elements*/
        staff.trimToSize();
        /*
        * Capacity is 100, size is 0.
        * wrong notations as no elements
        */
//        var list = new ArrayList<Employee>(100); // capacity 100, size is 0
//        list.set(0, x) is w


        /* adding the element in the middle of an array */
        int n = staff.size() / 2;
        staff.add( n, new Employee("Bob Brandson", 50000, 1989, 10, 1));
        System.out.println("size= " + staff.size());
        /* removing the element in the middle of an array */
        staff.remove(n);
        System.out.println("size= " + staff.size());
        /* Instead of a[i] use a.get(i) to get an element*/
        Employee e = staff.get(staff.size() - 1);
        System.out.println(e.getName());

        var intList = new ArrayList<Integer>();
        /* Object wrappers and autoboxing
        *  new ArrayList<Integer>() is less efficient then an int[]
        *  because each value is separately wrapped inside an object
        * Only use for small collections when programmer convinience is more
        * important than efficiency
        *
        * new ArrayList<Integer>() -> list.add(3)-> list.add(Integer.valueOf(3))
        * n = list.get(i)  = list.get(i).intValue()
        * which of course takes more time. This is called autoboxing  */

        /* Hence, following notation will fail
        * since two classes can't be equal.
        * Those classes are called wrappers which are Integer, Long, Float, Double, Short, Byte
        * Character and Boolean -> first six inherit from superclass Number and their value can not be changed
        * since they are final*/
        Integer a = 1000;
        Integer b = 1000;
        if(a == b){
            System.out.println("true");
        }


    }
}


class Employee{
    private  String name;
    private double salary;
    private  LocalDate hireDay;
    {
        name = "unknown";
        salary = 0.0;
        hireDay = null;
    }

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName(){
        return name;
    }
    public  double getSalary(){
        return salary;
    }
    public LocalDate getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    public int hashCode(){
        return Objects.hash(name, salary, hireDay);
    }
    public String toString(){
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
