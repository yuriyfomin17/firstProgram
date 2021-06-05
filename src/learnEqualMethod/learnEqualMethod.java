package learnEqualMethod;

public class learnEqualMethod {
    public static void main(String[] args){
        var employee = new Employee("Yuriy", 5000);
        var manger = new Manager("Yuriy", 5000);
        var index = manger.equals(manger);
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
   @Override public boolean equals(Object otherObject){

        // quick test to see if the objects are identical
        if(this == otherObject) return true;

        // must return false if the explicit parameter is null
        if(otherObject == null) return false;

        // if the classes don't match, they can't be equal
        if(getClass() != otherObject.getClass()){
            return false;
        }
        Employee other = (Employee) otherObject;
        return name.equals(other.name) && salary == other.salary;
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
        if(!super.equals(otherObject)){
            return false;
        }else {
            return true;
        }
    }
}
