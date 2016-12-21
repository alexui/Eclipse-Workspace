package Ex2;

public class PercentageVisitor implements Visitor{

	@Override
	public void visit(Employee e) {
		System.out.println(e.getName()+" Percentage: "+0);
	}

	@Override
	public void visit(Boss b) {
		
		System.out.println(b.getName()+" Percentage: "+b.getBonus()/b.getSalary());
	}

}
