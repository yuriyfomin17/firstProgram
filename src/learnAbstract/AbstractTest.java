package learnAbstract;

import java.time.LocalDate;

public class AbstractTest {
    public static void main(String [] args){
        var people = new Person[2];
        people[0] = new Employee("Yuriy Fomin", 330000, 1997, 9, 17);
        people[1] = new Student("Yuriy", "Computer Science");
        for(Person p : people){
            System.out.println(p.getDescription());
        }
    }
}
/* when extending com.yuriy.abstract class Person there are two
* choices. All of the methods should be defined
* then subclass is no longer com.yuriy.abstract
* or some methods can be undefined and subclass is also com.yuriy.abstract*/
abstract class Person{
    /* anything tagged as private won't be accessible in other class. But public method
    * with private filed will be accessible*/

    private String name;
    {
        this.name = "Unknown";
    }
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    /* if to remove this com.yuriy.abstract method getDescription
    * We would not be able to use getDescription method*/
    public abstract String getDescription();
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
    * class Employee is no longer com.yuriy.abstract*/
    public String getDescription(){
        return "Employee name is " + super.getName() + " and his salary is " + getSalary();
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
    /* When we override com.yuriy.abstract method getDescription
     * class Student is no longer com.yuriy.abstract*/
    public String getDescription(){
        return "Student name is " + super.getName() + " and his major is " + getMajor();
    }
}
