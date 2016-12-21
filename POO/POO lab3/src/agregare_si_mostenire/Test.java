package agregare_si_mostenire;

public class Test {

	
	
	public static void main(String[] args) {
		
		String sir;
		Profesor p = new Profesor("Negrescu","Mate 1");
		Student s = new Student("Alex",10);
		
		sir=p.toString();
		System.out.println(sir);
		sir=s.toString();
		System.out.println(sir);
		
		Persoana[] v=new Persoana[4];
		v[0]=new Profesor("Luca","Mate 2");
		v[1]=new Student("Alex",10);
		v[2]=new Profesor("Duca","Mate 1");
		v[3]=new Student("Iulia",10);
		
		for(int i=0;i<4;i++)
		{
			System.out.println(v[i].toString());
		}
		
		for(int i=0;i<4;i++)
		{
			if(v[i] instanceof Profesor)
				((Profesor)v[i]).preda();
			if(v[i] instanceof Student)
				((Student)v[i]).invata();
		}
		
		

	}

}
