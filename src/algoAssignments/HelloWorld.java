package algoAssignments;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        if (stringBuilder.length() != 0) stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
