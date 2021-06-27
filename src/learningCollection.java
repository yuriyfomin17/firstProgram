import java.time.LocalDate;
import java.util.*;

public class learningCollection {
    public static void main(String[] args) {
        Queue<Employee> expressLane = new LinkedList<>();
        expressLane.add(new Employee("Harry", 3000, 1997, 9, 1));

        Queue<Employee> expressLane2 = new ArrayDeque<>(100);
        expressLane2.add(new Employee("Harry2", 3100, 1998, 10, 2));

        /*Circular array or ArrayDeque is better then Linked list as it it is faster, but it has drawback that it has limited capacity*/

        var staff = new LinkedList<String>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        Iterator<String> iter = staff.iterator();
        String first = iter.next(); // visit first element
        String second = iter.next(); // visit second element
        iter.remove(); // remove last visited element
    }
}

class Employee {
    /*instance fields*/
    private final String name;
    private double salary;
    private LocalDate hireDay;
    private Integer id;
    /* say there are 1000 objects of Employee type class. But each of them has nextId = 1*/
    private static int nextId;


    /* Constructor has same name as the Class */
    /* Constructor needs new with it as it works on the heap*/
    /* Constructor can have 0, 1, or more parameters*/
    /* Class can have more then one constructor*/
    public Employee(String aName, double aSalary, int aYear, int aMonth, int aDay) {
        /* Don't put the variable name e.g. String name = n as it overshadows private fina String name*/
        this.name = aName;
        this.salary = aSalary;
        this.hireDay = LocalDate.of(aYear, aMonth, aDay);
        this.id = Employee.nextId;
        Employee.nextId += 1;
    }

    public String getName() {
        return this.name;
    }

    /* static method don't operate on object. they don't have "this" parameter in them*/
    public static int getNextId() {
        return nextId; // return static field
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    /* public means anybody can call those methods from anywhere*/
    /* Clear example of encapsulation. Field accessors methods which return values of instance fields*/
    /* Rule of thumb is to use clone when giving mutable field. As mitigate the concept of encapsulation*/
    public Integer getId() {
        return this.id;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDay() {
        return this.hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i =0; i< nums.length; i++){
            int difference = target - nums[i];
            if(hashmap.containsKey(difference)){
                result[0] = i;
                result[1] = hashmap.get(difference);
                return result;
            }
        }
        return result;
    }
}
