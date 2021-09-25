package learnEqualMethod;

public class learnEqualMethod {
    public static void main(String[] args){
        Object obj = new Object();
        var employee = new Employee("Yuriy", 5000);
        var manger = new Manager("Yuriy", 5000);
        var manger2 = new Manager("Yuriy", 5000);

        var index = employee.equals(manger);
        System.out.println("Index = " + index);
        System.out.println("Index = " + index);
        /* equal method should be symmetric manager should be equal to employee
        * and employee should be equal to manager but this is not true in terms
        * and violate rules of OOP so can't use instance of if want to compare two objects
        *
        *
        * In turn should override method equals of superclass Object
        * Also, var manager = new Manager is not equal to var manager2 = new Manager
        * since they refer to the references. Instead , should override the "equals method"
        * of superclass object*/
        var index1 = (manger instanceof Employee);
        System.out.println("Index1 = " + index1);
        var index2 = manger.equals(manger2);
        System.out.println("Index 2 = " + index2);
    }

}


class Employee{
    private final String name;
    private Integer salary;


    public Employee(String aName, Integer aSalary){
        this.name = aName;
        this.salary = aSalary;
    }

    public String getName() {
        return name;
    }
    public Integer getSalary(){ return salary;}
    public void raiseSalary(int aPercent){
        aPercent = aPercent / 100 + 1;
        this.salary = Math.round(this.salary * aPercent);
    }
    /* Overriding method equals of class Object*/
   @Override public boolean equals(Object otherObject){

        // quick test to see if the objects are identical
        if(this == otherObject) return true;

        // must return false if the explicit parameter is null
        if(otherObject == null) return false;


        // if the classes don't match, they can't be equal
        if(getClass() != otherObject.getClass()){
            return false;
        }
       // if the same class holds for all subclasses then  if (!(otherObject instanceof ClassName)) return false;
       // als can use this thing but stick to top

        Employee other = (Employee) otherObject;
        return name.equals(other.name) && salary.equals(other.salary);
    }
}
class Manager extends Employee{
    private Integer bonus;
    {
        bonus = 1000;
    }
    public Manager(String aName, Integer aSalary){
        super(aName, aSalary);
    }
    public Integer getBonus(){
        return this.bonus;
    }
    public void setBonus(Integer aBonus){
        this.bonus = aBonus;
    }
    public boolean equals(Object otherObject){
        return super.equals(otherObject);
    }
}
