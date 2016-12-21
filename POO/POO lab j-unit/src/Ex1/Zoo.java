package Ex1;

import java.util.ArrayList;

public class Zoo {

	private ArrayList<Animal> animals;
	
	public Zoo(){
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a){
		animals.add(animals.size(), a);
	}
	
	public Animal removeAnimal(Animal a){
		
		if(animals.contains(a)){
			
			animals.remove(a);
			return a;
			}
		else return null;
	}
	
	public boolean areAnimals(){
		if(animals.size()==0)
			return false;
		else return true;
	}
	
	public ArrayList<Animal> getAnimals(){
		return animals;		
	}
	
}
