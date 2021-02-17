package Level05.Lecture12;

/*
Порядок загрузки переменных
 */
public class VariableBreakepointDebag {
    static {
        init();
    }
    static {
        System.out.println("Static block");
    }
    {
        System.out.println("Non-static block");
        printAllFields(this);
    }
    public int i = 6;
    public String name = "First name";
    public VariableBreakepointDebag(){
        System.out.println("Solution constructor");
        printAllFields(this);
    }
    public static void init(){
        System.out.println("static void init");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        VariableBreakepointDebag s = new VariableBreakepointDebag();
    }
    public static void printAllFields(VariableBreakepointDebag obj){
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);

    }
}
