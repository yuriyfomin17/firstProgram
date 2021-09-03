package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(fact(input));
    }

    public static String fact(int n) {
        //add your code here
        if (n< 0){
            return "0";
        }
        if (n == 1){
            return "1";
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return Integer.toString(result);
    }
}
