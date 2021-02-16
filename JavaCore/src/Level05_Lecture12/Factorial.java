package Level05_Lecture12;

import java.io.*;
import java.math.BigInteger;
public class Factorial {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(factorial(input));
    }
    public static String factorial (int n){
        BigInteger result = BigInteger.valueOf(1);
        if (n <= 150 && n > 0){
           for (int i = 1; i <= n ; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        if (n == 0) {
            result = BigInteger.valueOf(1);
        }
        if (n < 0) {
            result = BigInteger.valueOf(0);
        }
        return String.valueOf(result);
    }
}
