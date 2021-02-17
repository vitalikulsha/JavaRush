package Level05.Lecture12.StaticBlock;
import java.io.*;
/*
Осваивание статического блока
 */
public class Solution {
    public static void main(String[] args) {

    }
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CanFly result;
    public static void reset() throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            if (string.equals("helicopter")) {
                result = new Helicopter();
            }
       if(string.equals("plane")){
        int x = Integer.parseInt(reader.readLine());
        result = new Plane(x);
    }
       reader.close();
     }
}
