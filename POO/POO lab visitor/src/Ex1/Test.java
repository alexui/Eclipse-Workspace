package Ex1;

public class Test {
    public static void main(String[] args) {
        
    	Employee[] employees = new Employee[2];
    	employees[0]= new Employee("gigel",698.23f);
    	employees[1] = new Boss("becali",822222.4f);
    	((Boss)employees[1]).setBonus(78.6f);
        Visitor v = new RevenueVisitor();        // creeaza un obiect-vizitator concret
        for (Employee e : employees)
                e.accept(v);

}
}
