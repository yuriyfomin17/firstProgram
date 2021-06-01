package com.yuriy.overloading;
import java.util.Random;
/* with packages classes with same name are not a problem*/

public class Overloading {
    public static void main(String[] args) {
        /* Overloading occurs if the several methods have the same name but methods have
         * different parameters supplied to them */
        var messages = new StringBuilder();
        var todoList = new StringBuilder("To do:\n");
        Employee e2 = new Employee();
        System.out.println("Employer name is " + e2.getName() + Employee.getNextId());
    }
}

class Employee{
    public static int nextId;
    String name;
    /* this is the other option to initialize the nextId
    * if it requires complex way to do it*/
    static
    {
        System.out.println("Hello World");
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    public Employee(){
        /* this can be used when calling another constructor. Overloading*/
        this("Yuriy");
        Employee.nextId +=1;
    }
    public Employee(String aName){
        this.name = aName;
    }

    public String getName() {
        return name;
    }
    public static int getNextId(){
        return nextId;
    }
}