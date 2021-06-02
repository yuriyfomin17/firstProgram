package com.yuriy.overloading;
import java.util.Random;
/* with packages classes with same name are not a problem*/

public class Overloading {
    public static void main(String[] args) {
        /* in package word public and private allows
        * to set access to methods and fields
        * e.g. inside package evey class can access
        * public method of another class and
        * same for the field*/
        System.out.println(" Employer nexNextId=" + Employee.getNextNextId());
        /* Overloading occurs if the several methods have the same name but methods have
         * different parameters supplied to them */
        var messages = new StringBuilder();
        var todoList = new StringBuilder("To do:\n");
        Employee e2 = new Employee();
        Employee.nextId += 1;
        System.out.println("Employer name is " + e2.getName() + Employee.getNextId());
    }
}

class Employee{
    private static int nextNextId;
    public static int nextId;
    private final String name;
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
    public static int getNextNextId() {return nextNextId;}
}