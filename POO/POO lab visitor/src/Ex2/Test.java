package Ex2;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        
    	Boss CEO = new Boss("Alex Budau", 1000f);
    	LinkedList<Boss> managers = new LinkedList<Boss>();

    	managers.add(0, new Boss("Florin",1000f));
    	managers.add(1, new Boss("George",1000f));
    	managers.add(2, new Boss("Costel",1000f));
    	managers.add(3, new Boss("Andrei",1000f));
    	CEO.addSubordinate(managers.get(0));
    	CEO.addSubordinate(managers.get(1));
    	CEO.addSubordinate(managers.get(2));
    	CEO.addSubordinate(managers.get(3));

    	
    	LinkedList<Employee> HR = new LinkedList<Employee>();
    	HR.add(0, new Employee("Florina",460f));
    	HR.add(0, new Employee("Alexandra",400f));
    	HR.add(0, new Employee("Andreea",470f));
    	
    	LinkedList<Employee> Products = new LinkedList<Employee>();
    	Products.add(0, new Employee("Mircea",290f));
    	Products.add(1, new Employee("Georgiana",190f));
    	Products.add(2, new Employee("Sebastian",270f));
    	Products.add(3, new Employee("Doru",190f));
    	
    	LinkedList<Employee> Services = new LinkedList<Employee>();
    	Services.add(0, new Employee("Laur",300f));
    	Services.add(1, new Employee("Vlad",400f));
    	Services.add(2, new Employee("Tatiana",350f));
    	Services.add(3, new Employee("Clara",320f));
    	
    	LinkedList<Employee> Marketing = new LinkedList<Employee>();
    	Marketing.add(0, new Employee("Iulian",320f));
    	Marketing.add(1, new Employee("Mihai",310f));    	
    	Marketing.add(2, new Employee("Antonel",380f));
    	Marketing.add(3, new Employee("Lucas",320f));
    	Marketing.add(4, new Employee("Oana",370f));

    	for(int i=0;i<HR.size();i++)
    		managers.get(0).addSubordinate(HR.get(i));
    	for(int i=0;i<Products.size();i++)
    		managers.get(1).addSubordinate(Products.get(i));
    	for(int i=0;i<Services.size();i++)
    		managers.get(2).addSubordinate(Services.get(i));
    	for(int i=0;i<Marketing.size();i++)
    		managers.get(3).addSubordinate(Marketing.get(i));
    	
    	/*CEO.printSubordinatesList();
    	((Boss)CEO.getSubordinateListL().get(0)).printSubordinatesList();
    	((Boss)CEO.getSubordinateListL().get(1)).printSubordinatesList();
    	((Boss)CEO.getSubordinateListL().get(2)).printSubordinatesList();
    	((Boss)CEO.getSubordinateListL().get(3)).printSubordinatesList();*/
    	
    	Visitor visitor= new RevenueVisitor();

    	CEO.printSubordinatesTree(CEO, 0);
    	
    	CEO.setBonus(500f);
    	CEO.accept(visitor);
    	
    	Marketing.get(0).accept(visitor);

    	Visitor newVisitor= new PercentageVisitor();
    	CEO.accept(newVisitor);
    	
    	HR.get(2).accept(newVisitor);
}	
}
