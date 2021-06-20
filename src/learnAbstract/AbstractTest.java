package learnAbstract;

import java.time.LocalDate;
public class AbstractTest {
    public static void main(String [] args){
        var people = new Person[2];
        people[0] = new Employee("Yuriy Fomin", 330000, 1997, 9, 17);
        people[1] = new Student("Yuriy", "Computer Science");
        var employee = people[0];
        /* Because we have put protected against lastName
        *  thus we can access lastName field directly
        * not good in terms of encapsulation*/
        employee.lastName = "Bohdan";
        for(Person p : people){
            System.out.println(p.getDescription());
        }
    }
}
/* when extending abstract class Person there are two
* choices. All of the methods should be defined
* then subclass is no longer abstract
* or some methods can be undefined and subclass is also com.yuriy.abstract*/
abstract class Person{
    /* anything tagged as private won't be accessible in other class. But public method
    * with private filed will be accessible*/
    private static final int nextId;
    private String name;
    /* Subclasses of Person such as Employee and
    * Student can access the lastName*/
    protected String lastName;
    static {
        nextId = (int) Math.round(Math.random() * 100);
    }
    {
        this.name = "Unknown";
        this.lastName = "Unknown";
    }
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getLastName(){return this.lastName;}
    /* if to remove this com.yuriy.abstract method getDescription
    * We would not be able to use getDescription method*/
    public abstract String getDescription();
    /* This private method won't accessible by the subclass Person */
    private Integer getNextId(){ return Person.nextId;}
}

class Employee extends Person {
    private double salary;
    private final LocalDate hireDay;
    private  Integer id;
    private static int nextId;



    public Employee(String aName, double aSalary, int aYear, int aMonth, int aDay){
        super(aName);
        this.salary = aSalary;
        this.hireDay = LocalDate.of(aYear, aMonth, aDay);
    }
    /* Overloading- here we have multiple constructors that have different signature in them i.e.
    *  parameter methods variables */
    public Employee(double aSalary, int aYear, int aMonth, int aDay){
        this.salary = aSalary;
        this.hireDay = LocalDate.of(aYear, aMonth, aDay);
    }
    /* When we override com.yuriy.abstract method getDescription
    * class Employee is no longer abstract*/
    @Override public String getDescription(){
        return "Employee name is " + super.getName()+ " and last name is "+ super.getLastName() + " and his salary is " + getSalary();
    }
    public String getName(){
        return super.getName();
    }
    public static int getNextId() {
        return nextId; // return static field
    }

    public static void setNextId(int nextId) {
        Employee.nextId+= 1;
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

    public static void main(String[] args) {
    }
}

class Student extends Person{
    private final String major;
    public Student(String aName, String aMajor){
        super(aName);
        this.major = aMajor;
    }
    public String getMajor(){
        return this.major;
    }
    /* When we override abstract method getDescription
     * class Student is no longer abstract*/
    public String getDescription(){
        return "Student name is " + super.getName() + " and his major is " + getMajor();
    }
}

/* Summary of access modifiers
* 1. Public - accessible by the world
* 2. Private - accessible by the class only
* 3. Protected - is accessible by the package and
*  all subclasses
* 4. No modifiers are needed- accessible in the package and no modifiers are needed */