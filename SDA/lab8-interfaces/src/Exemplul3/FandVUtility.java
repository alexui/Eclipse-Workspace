package Exemplul3;

public class FandVUtility {

	static String doesThisHaveAPeel(Fruit fruitIn)
	   {
	        if (fruitIn.hasAPeel())
	           return "This has a peel";
	        else   
	           return "This does not have a peel";
	   }
	   static String isThisARoot(Vegetable vegetableIn)
	   {
	        if (vegetableIn.isARoot())
	           return "This is a root";
	        else   
	           return "This is not a root";
	   }   
	   static String doesThisHaveAPeelOrIsThisRoot(
	     Tomato tomatoIn)
	   {
	        if (tomatoIn.hasAPeel() && tomatoIn.isARoot())
	           return "This both has a peel and is a root";
	        else if (tomatoIn.hasAPeel() || tomatoIn.isARoot())
	           return "This either has a peel or is a root";
	        else   
	           return "This neither has a peel or is a root";        
	   }


}
