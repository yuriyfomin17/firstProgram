package learnInputOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BufferedInputExample {

    public static void main(String[] args) {
        // напишите тут ваш код

        try {
//            String file = reader.readLine();
            FileInputStream inputStream = new FileInputStream("/Users/icom/Desktop/javaFile.txt");

            BufferedInputStream buffer = new BufferedInputStream(inputStream);
            ArrayList<Integer> arrayList = new ArrayList<>();
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNext()) {

                int num = scanner.nextInt();
                if (num %2 == 0) arrayList.add(num);

            }
            Collections.sort(arrayList);
            for (Integer num: arrayList){
                System.out.println(num);
            }
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
