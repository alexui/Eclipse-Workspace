package Exemplul3;

public class Tomato implements Fruit, Vegetable {

	boolean peel = false;
	boolean root = false;

	public boolean hasAPeel()  
	   //must have this method, 
	   //  because Fruit declared it
	   { 
	      return peel; 
	   }    
	   public boolean isARoot()  
	     //must have this method, 
	     //  because Vegetable declared it
	   { 
	      return root; 
	   }      


	   public static void main(String[] args) {


	      //Part one: making a tomato
	      Tomato tomato = new Tomato();


	      System.out.println(FandVUtility.isThisARoot(tomato));
	      //output is: This is not a root
	      System.out.println(
	        FandVUtility.doesThisHaveAPeel(tomato));
	      //output is: This does not have a peel
	      System.out.println
	        (FandVUtility.doesThisHaveAPeelOrIsThisRoot
	          (tomato));
	      //output is: This neither has a peel or is a root


	      //Part two: making a fruit
	      //Fruit  = new Fruit();  
	        //can not instantiate an interface like 
	        //  this because Fruit is not a class
	      Fruit tomatoFruit = new Tomato();   
	        //can instantiate by interface like 
	        //  this because Tomato is a class

	      //System.out.println(
	      //  FandVUtility.isThisARoot(tomatoFruit));  
	        //can not treat tomatoFruit as a Vegetable 
	        //  without casting it to a Vegetable or Tomato
	      System.out.println(
	        FandVUtility.doesThisHaveAPeel(tomatoFruit));
	      //output is: This does not have a peel
	      //System.out.println
	      //  (FandVUtility.doesThisHaveAPeelOrIsThisRoot
	      //  (tomatoFruit)); 
	        //can not treat tomatoFruit as a Vegetable 
	        //  without casting it to a Vegetable or Tomato
	 
	   }


}
