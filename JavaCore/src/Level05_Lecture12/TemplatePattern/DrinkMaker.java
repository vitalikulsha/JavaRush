package Level05_Lecture12.TemplatePattern;

public abstract class DrinkMaker {
    abstract public void getRightCup();
    abstract public void putIngredient();
    abstract public void pour();
    public void makeDrink (){
    getRightCup();
    putIngredient();
    pour();
    }

}
