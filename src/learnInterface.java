public class learnInterface {
    public static void main(String [] args){
        Employee x = new Employee("Yuriy", 5000);
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
    int compareTo(Object other);
}
interface Info {
    String returnNameSalary(); /* public methods */
    double MAX_SIZE = 20; /* public static final*/
}
/* Employee implements Info, Comparable interface
* use comma to make class to implement them both
*
* Why can't we use an abstract class instead
* Answer is that each class can only extend single class
* Say Employee ealready extends Person class. Hence, it can't extend
* another class*/
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
