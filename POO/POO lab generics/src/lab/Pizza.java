package lab;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    protected String name = "Pizza";
 
    public String getName() {
        return name;
    }
}
 
class HamPizza extends Pizza {
    public HamPizza() {
        name = "HamPizza";
    }
}
 
class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "CheesePizza";
    }
}
 
class MyApplication {
    // Aici folosim "bounded wildcards"
    public static void listPizza(List<? extends Pizza> pizzaList) { //public static void listPizza(List<Pizza> pizzaList)
        for(Pizza item : pizzaList)
            System.out.println(item.getName());
    } //Observatie: Trebuie retinut faptul ca in continuare nu putem introduce 
    //valori intr-o colectie ce foloseste bounded wildcards si este data ca parametru unei functii.
 
    public static void main(String[] args) {
        List<Pizza> pList = new ArrayList<Pizza>();
 
        pList.add(new HamPizza());
        pList.add(new CheesePizza());
        pList.add(new Pizza());
 
        MyApplication.listPizza(pList);
        // Se va afisa: "HamPizza", "CheesePizza", "Pizza"
    }
}