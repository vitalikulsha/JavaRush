package Level05.Lecture12.TemplatePattern;
/*
Template pattern
 */
public class Solution {
    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        LatteMaker latteMaker = new LatteMaker();

        teaMaker.makeDrink();
        latteMaker.makeDrink();
    }
}
