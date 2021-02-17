package Level05.Lecture12.FileStaticBlock;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
Файл в статическом блоке
 */
public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
        String s;
        while ((s = reader.readLine()) != null){
            lines.add(s);
        }
        reader.close();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException {
       System.out.println(lines);
    }
}
