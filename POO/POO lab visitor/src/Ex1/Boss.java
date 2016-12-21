package Ex1;

public class Boss extends Employee{
    
    float bonus;
    
    public Boss(String name, float salary) {
            super(name, salary);
            bonus = 0;
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
}

