import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class training {
    public static void main(String[] args) throws IOException {
        URL url = null;
        try {
            url = new URL("https://javarush.ru");
            InputStream input = url.openStream();
            byte[] buffer = input.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
