public class learnInterface {
    public static void main(String [] args){
        Employee x = new Employee("Yuriy", 5000);
        Manger m = new Manger("Bohdan", 6000, 100000.0);
        System.out.println(m.getName());
        System.out.println(m.getAge());
        System.out.println(x.returnNameSalary());
        if(x instanceof Comparable){
            System.out.println("true");
        }
    }
}
/* Interface sets the rules on method which
* classes should have. Interfaces can never have instance fields
*
* All methods of the interface are automatically public
* so there is no need to put on this word
*
* Methods in interface are public while fields are public static final
* but it is not necessary to describe them like this*/

interface Comparable{
    /* word default supply default method for the class
    * hence any class that implements Comparable interface
    * returns zero
    *
    * really useful for the case of the old classes
    * say class use new interface with no default method and this class doesn't
    * this method –> results in error while default can mitigate such circumstances */
    default int compareTo(Object other){
        return 0;
    }
}
interface Info {
    String returnNameSalary(); /* public methods */
    double MAX_SIZE = 20; /* public static final*/

    /* Note that interface implements same method getName() for Manager class
    *  But same method is defined in superclass Employee. Java solves this conflict by simply using method
    *  from super class
    *
    * However, if interface supplies same method (default or not) with the same parameters
    *  then conflict must be resolved by overriding those methods  */
    default String getName(){ return "Yuriy";}

    default int getAge(){return 24;}
}
/* Employee implements Info, Comparable interface
* use comma to make class to implement them both
*
* Why can't we use an abstract class instead
* Answer is that each class can only extend single class
* Say Employee already extends Person class. Hence, it can't extend
* another class
* Designers of Java decided not to use multiple inheritence like in C as
* it makes language too complex. Hence interfaces is the key solution to multiple inheritence
* which complement C++ functionality */
class Employee implements Info, Comparable{
    private final String name;
    private Integer salary;
    private final double maxSize = Info.MAX_SIZE;

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
    /* When writing method from interface- there is a rule that it should be public
     * otherwise compiler assumes that the method has the package access the default
     * for a class */
    public int compareTo(Object otherObject){
        Employee other = (Employee) otherObject;
        return Double.compare(salary, other.salary);
    }
    public String returnNameSalary(){
        return "Name=" + this.name + " salary " + this.salary;
    }
}

class Manger extends Employee implements Info, Comparable{
    private final double bonus;

    public Manger(String aName, Integer aSalary, Double aBonus) {
        super(aName, aSalary);
        this.bonus = aBonus;
    }

    @Override public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        /* Here the conflict is resolved by programmer. I choose to use method of Info interface*/
        return Info.super.getAge();
    }
}
/* CAUTION!!!!!!!
BE CAREFUL WHEN USING INTERFACE WITH THE SAME NAME AS IN SUPERCLASS OBJECT
DUE TO CLASS WINS RULE METHODS SUCH AS toString and equals in Object would always win
* */
