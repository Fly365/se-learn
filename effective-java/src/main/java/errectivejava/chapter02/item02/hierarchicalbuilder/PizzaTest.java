package errectivejava.chapter02.item02.hierarchicalbuilder;

/**
 * effective-java-errectivejava.chapter02.item02.hierarchicalbuilder
 */
public class PizzaTest {

    public static void main(String[] args){

       NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
               .addTopping(Pizza.Topping.SAUSAGE)
               .addTopping(Pizza.Topping.ONION)
               .build();
       Calzone calzone = new Calzone.Builder()
               .addTopping(Pizza.Topping.HAM)
               .sauceInside()
               .build();
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
