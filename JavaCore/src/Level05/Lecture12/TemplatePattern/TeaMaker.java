package Level05.Lecture12.TemplatePattern;

public class TeaMaker extends DrinkMaker{
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятков");
    }
}
