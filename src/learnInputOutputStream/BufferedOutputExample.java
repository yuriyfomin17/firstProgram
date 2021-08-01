package learnInputOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputExample {


    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("/Users/icom/Desktop/javaFile.txt");
        BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);

        String text = "I love Java!"; // эту строку мы преобразуем в массив байтов и запишем в файл

        byte[] buffer = text.getBytes();

        bufferedStream.write(buffer, 0, buffer.length);
        bufferedStream.close();
    }
}
