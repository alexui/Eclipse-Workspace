package Ex2;



public class Employee implements Visitable{
	 
    protected String  name;
    protected float   salary;

    public Employee(String name, float salary) {
            this.name       = name;
            this.salary     = salary;
    }

    public String getName() {
            return name;
    }

    public float getSalary() {
            return salary;
    }

	public void accept(Visitor v) {
		v.visit(this);    		
	}
	
}
