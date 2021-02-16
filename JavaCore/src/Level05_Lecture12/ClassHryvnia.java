package Level05_Lecture12;

/*
ООП. Hryvnia - тоже деньги
 */
public class ClassHryvnia {
    public static void main(String[] args) {
        System.out.println(new Hryvnia().getAmount());
    }
    public static abstract class Money {
        abstract Money getMoney();
        public Object getAmount(){
            return getMoney().getAmount();
        }
    }
    // код
    public static class Hryvnia extends Money{
        //public Object getAmount;
        private double amount = 123d;
        public Object getAmount(){
            return this.amount;
        }
        public Hryvnia getMoney(){
            return this;
        }

    }
}
