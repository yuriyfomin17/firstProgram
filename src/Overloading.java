import java.util.Random;

public class Overloading {
    public static void main(String[] args) {
        /* Overloading occurs if the several methods have the same name but methods have
         * different parameters supplied to them */
        var messages = new StringBuilder();
        var todoList = new StringBuilder("To do:\n");
        Employee2 e2 = new Employee2();
        System.out.println("Employer name is " + e2.getName() + Employee2.getNextId());
    }
}

class Employee2{
    public static int nextId;
    String name;
    /* this is the other option to initialize the nextId
    * if it requires complex way to do it*/
    static
    {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    public Employee2(){
        /* this can be used when calling another constructor. Overloading*/
        this("Yuriy");
        Employee2.nextId +=1;
    }
    public Employee2(String aName){
        this.name = aName;
    }

    public String getName() {
        return name;
    }
    public static int getNextId(){
        return nextId;
    }
}