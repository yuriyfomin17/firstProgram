import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class employeeTest {
    public static void main(String[] args){
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
            +", id=" + e.getId());
        }
    }
}

class Employee{
    /*instance fields*/
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    private final Integer id;
    /* say there are 1000 objects of Employee type class. But each of them has nextId = 1*/
    private static int nextId = 1;

    /* Constructor has same name as the Class */
    /* Constructor needs new with it as it works on the heap*/
    /* Constructor can have 0, 1, or more parameters*/
    /* Class can have more then one constructor*/
    public Employee(String n, double s, int year, int month, int day){
        /* Don't put the variable name e.g. String name = n as it overshadows private fina String name*/
        this.name = Objects.requireNonNull(n, "unknown");
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
        this.id = Employee.nextId;
        Employee.nextId += 1;
    }

    public static int getNextId() {
        return nextId;
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
    public String getName(){
        return this.name;
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
}
