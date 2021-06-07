import java.time.LocalDate;
import java.util.Objects;

public class exampleClass {
    public static void main(String[] args){
        var alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice Adams",75000, 1987, 12, 1 );
        var bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
        System.out.println("alice1 == alice2: " + (alice1 == alice2));
        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
        System.out.println("bob.toString(): " + bob);

        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
        carl.setBonus(5000);
        System.out.println("carl.equals(boss): " + carl.equals(boss));

    }

}

class Employee{
    private final String name;
    private double salary;
    private final LocalDate hireDay;

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

    @Override public boolean equals(Object otherObject){

        /* q quick test to see if the objects are identical*/
        if(this == otherObject) return true;

        /* must return false if the explicit parameter is null*/
        if(otherObject == null){
            return  false;
        }
        /* if the classes don't match, they can't be equal*/
        if(getClass()!= otherObject.getClass()) return false;

        /* now we know otherObject is a non-null Employee*/
        var other = (Employee) otherObject;

        /* test whether the field have identical values*/
        return this.name.equals(other.name) && this.salary == other.salary && this.hireDay.equals(other.hireDay) ;
    }
}
class Manager extends Employee{
    private double bonus;
    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        var other = (Manager) otherObject;
        return  bonus == other.bonus;
    }
    @Override public int hashCode(){
        return  Objects.hash(super.hashCode(), bonus);
    }
    public String toString(){
        return super.toString() + "[bonus=" + bonus + "]";
    }
}

