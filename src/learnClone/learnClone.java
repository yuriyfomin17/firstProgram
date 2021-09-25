package learnClone;

import java.util.Date;
import java.util.GregorianCalendar;
public class learnClone {
     public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("Yuriy Fomin", 50000);
        original.setHireDay(2000, 1, 1);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}

class Employee implements Cloneable{
    private final String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    @Override protected Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireDay = (Date) this.hireDay.clone();
        return cloned;
    }

    /*
    * Set the hire day to a given date.
    * */

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        // example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }
    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
    @Override
    public String toString(){
        return "learnClone.Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
