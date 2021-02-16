package Level05_Lecture12.ClassTreeOverload;
import java.math.BigDecimal;
/*
ООП. Перегрузка
 */
public class Solution {
    public static void main(String[] args) {
        //блок 2
        // Вызов для Object
        new Tree().info((Object) new Integer("4"));
        new Tree().info((Object) new Short("4"));
        new Tree().info((Object) new BigDecimal("4"));

        //блок 3
        //вызов для number
        new Tree().info(new Integer("4"));
        new Tree().info(new Short("4"));
        new Tree().info(new BigDecimal("4"));

        //блок 4
        //вызов для String
        new Tree().info(new String("4"));
        new Tree().info(new Integer("4").toString());
        new Tree().info(new Short("4").toString());
        new Tree().info(new BigDecimal("4").toString());
    }
}
