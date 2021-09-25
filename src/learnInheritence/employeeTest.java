package learnInheritence;
import java.text.NumberFormat;
import java.time.LocalDate;

public class employeeTest {
    public static void main(String[] args){
        /* Factory methods can can create instance of same class -> object. But result can be different*/
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        /* Constructor name is always same as class name. So, we can't have two constructors */
        /* Key is in inheritance.percentFormatter and currencyFormatter has inheritence in different classes  */
        System.out.println(percentFormatter.format(x)); // prints $0.10 System.out.println(percentFormatter.format(x)); // prints 10%
        Employee [] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 5000, 1997, 7, 17);
        staff[1] = new Employee("Yarl Bracker", 6000, 1998, 8, 18);
        staff[2] = new Employee("Rarl Dracker", 7000, 1999, 9, 19);

        for(Employee e : staff){
            e.raiseSalary(5);
        }
        for(Employee e : staff){
            System.out.println("name=" + e.getName()
            + ",salary=" + e.getSalary()
            + ",hireDay=" + e.getHireDay()
            +", id=" + e.getId()
            +", nextId=" + Employee.getNextId());
        }
    }
}

class Employee {
    /*instance fields*/
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    private final Integer id;
    /* say there are 1000 objects of Employee type class. But each of them has nextId = 1*/
    private static int nextId;


    /* Constructor has same name as the Class */
    /* Constructor needs new with it as it works on the heap*/
    /* Constructor can have 0, 1, or more parameters*/
    /* Class can have more then one constructor*/
    public Employee(String aName, double aSalary, int aYear, int aMonth, int aDay){
        /* Don't put the variable name e.g. String name = n as it overshadows private fina String name*/
        this.name = aName;
        this.salary = aSalary;
        this.hireDay = LocalDate.of(aYear, aMonth, aDay);
        this.id = Employee.nextId;
        Employee.nextId += 1;
    }
    public String getName(){
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
    public double getSalary(){
        return this.salary;
    }
    public LocalDate getHireDay(){
        return this.hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
    /* Every class can have a void main method as for the purpose of the unit testing*/
    /* Main method will be never executed */

    public static void main(String[] args){
        var e = new Employee("Romeo", 50000, 2003, 3, 31);
        e.raiseSalary(10);
        System.out.println(e.getName() + " " + e.getSalary());
        /*Methods can't attach new objects to parameters*/
        callByValue();
        /* Methods can change state of object*/
        System.out.println("Salary before changeStateOfObject=" + e.getSalary());
        changeStateOfObject(e);
        System.out.println("Salary after changeStateOfObject=" + e.getSalary());

        /* Method can't modify numeric parameters*/
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);
    }
    /* swap and callByValue demonstrates that in java we can only get call by value.
    *  swap method creates copy of references to object and in side swap they swap
    *  But outside the swap x an y are abandoned. Which means that -> object references are passed by value */
    public static void swap(Employee x , Employee y){
      Employee temp = x;
      x = y;
      y = temp;
      System.out.println(x.getName());
    }
    public static void callByValue(){
        var x = new Employee("Alice", 50000, 2003, 3, 31);
        var y = new Employee("Bob", 50000, 2003, 3, 31);
        swap(x, y);
        System.out.println(x.getName());
    }
    public static void changeStateOfObject(Employee e){
        e.raiseSalary(200);
    }
    public static void tripleValue(double x){
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }
}

/* native method can bypass java language rules. For example, setOut in System.out println can change the instance
* fields with word final */

class Manager extends Employee{
    private double bonus;
    /*
    * @param name
    * */
    public Manager(String aName, double aSalary, int aYear, int aMonth, int aDay){
        super(aName, aSalary, aYear, aMonth, aDay);
    }
    public void setBonus(double aBonus){
        this.bonus = aBonus;
    }
    /* overriding method. as method getSalary() exists in Employee */
    public double getSalary(){
        double baseSalary = super.getSalary();
        return bonus + baseSalary;
    }
    public static void main(String[] args){

        var manger = new Manager("Yuriy Fomin", 5300, 1997, 9, 17);
        /* use of instanceof to check before
         casting so no exception will be thrown */
        if (manger instanceof Employee){
            var employee = (Employee) manger;
            System.out.println("It worked" +  employee.getName());
        }
        manger.setBonus(5000);
        System.out.println("Manager salary = " + manger.getSalary());
        var staff = new Employee[3];
        staff[0] = manger;
        /* Won't work since not every employee is a manager*/
//        staff[0].setBonus(1000);

        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        /* the fact that e can refer to multiple object variable such as manager and employer
        *  is called polymorphism. Automatically selecting appropriate method is called
        * dynamic binding*/
        for (Employee e: staff){
            System.out.println(e.getName() + " " + e.getSalary());
        }
    }

}
/* word final doesn't allow any other class to extend from Executive
* word final also doesn't allow to override methods*/
final class Executive extends Manager{

    public Executive(String aName, double aSalary, int aYear, int aMonth, int aDay) {
        super(aName, aSalary, aYear, aMonth, aDay);
    }
}
