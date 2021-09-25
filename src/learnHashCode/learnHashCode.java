package learnHashCode;

import java.util.Objects;

public class learnHashCode {
    public static void main(String[] args){
        String word = "\uD83D\uDE00";
        byte val  = 108 & 0xff;
        System.out.println();
        var index = word.codePointAt(word.length() - 1);
        /* String method uses following algorithm to compute
        * hashcode of the string*/
        int hash = 0;
        for(int i =0; i< word.length(); i++){
            var ch = word.charAt(i);
            hash = 31 * hash + word.charAt(i);
        }
        /* Note that hashcode for String s and String t is the same
        * as the class String derives hashcode for those strings based
        * on contents.
        *
        * While StringBuilder doesn't have hashCode method.
        * and default  hashCode method in the Object class derives the
        * hashcode from the object's memory address*/
        var s = "OK";
        var sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        var t = "OK";
        var tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());

        var e = new Employee("Yuriy", 23);
        System.out.println(e.getHashCode());
        System.out.println(e.getHashCode2());
    }
}

class Employee{
    private final String  name;
    private final Integer age;
    private final Integer hashCode;
    private final Integer hashCode2;
    Employee(String aName, Integer anAge){
        this.name = aName;
        this.age = anAge;
        /* First way of doing hashcode*/
        this.hashCode = Objects.hash(this.name, this.age);
        /* Second way of doing hashcode*/
        this.hashCode2 = 7 * Objects.hashCode(this.name) + 11 * Objects.hashCode(this.age);
        System.out.println(this.hashCode2);
    }

    public Integer getHashCode() {
        return hashCode;
    }
    public Integer getHashCode2() {
        return hashCode2;
    }

}
