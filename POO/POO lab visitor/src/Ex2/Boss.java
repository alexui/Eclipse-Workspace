package Ex2;

import java.util.LinkedList;

public class Boss extends Employee{
    
    private float bonus;
    private LinkedList<Employee> list = null;
    
    public Boss(String name, float salary) {
            super(name, salary);
            bonus = 0;
            this.list = new LinkedList<Employee>();
    }

    public float getBonus() {
            return bonus;
    }

    public void setBonus(float bonus) {
            this.bonus = bonus;
    }

	@Override
    public void accept(Visitor v) {
            v.visit(this);          
    }
    
	public void addSubordinate(Employee e)
	{
		list.add(e);
	}
	
	public LinkedList<Employee> getSubordinateListL()
	{
		return this.list;
	}
	
	public void printSubordinatesList()
	{
		System.out.println(this.getName()+"  salary: "+this.getSalary()+"\n");
		for(int i =0;i<list.size();i++)
		{
			System.out.print("\t"+list.get(i).getName()+"  salary: "+list.get(i).getSalary()+"\n");
		}
		System.out.println();
	}
	
	public void printSubordinatesTree(Employee e, int tabs)
	{

		for(int i=0;i<tabs;i++)
			System.out.print("\t");
		System.out.print("\t"+e.getName()+"  salary: "+e.getSalary()+"\n");
		if(e instanceof Boss){
			System.out.println();
			for(int i =0;i<((Boss) e).getSubordinateListL().size();i++)
			{
				printSubordinatesTree(((Boss) e).getSubordinateListL().get(i), tabs+1);
			}
			System.out.println();}
	}
}

