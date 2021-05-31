import java.time.LocalDate;
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
            + ",hireDay=" + e.getHireDay());
        }
    }
}

class Employee{
    /*instance fields*/
    private final String name;
    private double salary;
    private final LocalDate hireDay;
    /* Constructor has same name as the Class */
    /* Constructor needs new with it as it works on the heap*/
    /* Constructor can have 0, 1, or more parameters*/
    /* Class can have more then one constructor*/
    public Employee(String n, double s, int year, int month, int day){
        /* Don't put the variable name e.g. String name = n as it overshadows private fina String name*/
        name = Objects.requireNonNull(n, "unknown");
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }
    /* public means anybody can call those methods from anywhere*/
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public LocalDate getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
