import java.util.Scanner;
import java.util.Stack;

public class ArboreDeParsare{

		Operatori op;
		Factory factory;
		private Nod radacina;
		private String expresie;
		
		private Stack<Nod> StivaNoduri = new Stack<Nod>();				
		private Stack<Nod> StivaOperatori = new Stack<Nod>();			//stiva de operatori
		
		
		public Nod radacina() throws SyntacticException{
			
			parsare();
			return radacina;
		}
		
		public ArboreDeParsare(String s){
			this.expresie = s;
			op = new Operatori();
			factory = new Factory();
		}
		
		private void parsare() throws SyntacticException{
			
			String cuv;	
			
			int j=0;
			while(expresie.charAt(j)=='(' || expresie.charAt(j)==' ') j++;
			if(expresie.charAt(j)=='-' && expresie.charAt(j+1)!=' ' && Character.isDigit(expresie.charAt(j+1))==false)
			{
				throw new SyntacticException();	//test minus unar
			}
			
		
			int paranteze=0;
			for(j=0;j<expresie.length();j++)			// numar de paranteze
			{
				if(expresie.charAt(j)=='(') paranteze++;
				if(expresie.charAt(j)==')') paranteze--;
			}
			if(paranteze!=0) {
				throw new SyntacticException();
			}
			
			if(expresie.charAt(0)=='-'){  // cand intalnim minus unar se realizeaza scaderea din 0
				StivaOperatori.push(new Scadere(null,"-",null));
				StivaNoduri.push(new Atom(null,"0",null));
				expresie=expresie.substring(1);
				}
			
			
			Scanner citeste = new Scanner(expresie);
			
		
			while(citeste.hasNext()){		//cat timp exista expresie
				
				cuv =  citeste.next();
				try{
				expresie = expresie.substring(expresie.indexOf(cuv)).substring(cuv.length());	//redimensioneaza expresie
				}
				catch (Exception e){
					citeste.close();
					throw new SyntacticException();	
				}
												
				if(op.operatori_unari.contains(cuv)){
					
					//System.out.println("operator unar");
					int contor=1; //nr paranteza
					int nr_perechi=1;
					int i;
					
					if(expresie.isEmpty() || expresie.charAt(1)!='('){
						citeste.close();
						throw new SyntacticException();	}

					
					for(i =2;i<expresie.length() && contor!=0;i++){
						System.out.print(expresie.charAt(i));			
						if(expresie.charAt(i)=='(')
							{
							contor++;
							nr_perechi++;
							}
						if(expresie.charAt(i)==')')
							contor--;
					}
					
					String expresie_noua=expresie.substring(0, i);			
					
					//operatorul unar e salvat intr-un nod nou obtinut prin factory
					Nod node = factory.take(new ArboreDeParsare(expresie_noua).radacina(), cuv, null);
					StivaNoduri.push(node);						

					while(citeste.hasNext() && nr_perechi>0)			// se citesc cuvinte in continuare
					{
						cuv = citeste.next();
						expresie = expresie.substring(expresie.indexOf(cuv));
						if(cuv.equals(")")){
							nr_perechi-=1;
						}
					}
				}

				else
				if(cuv.equals("("))	
				{
					//System.out.println("paranteze");
					int nr=1;
					int p=1;
					int i;
					for(i =1;i<expresie.length() && nr!=0;i++){		
								//se numara parantezele 
						if(expresie.charAt(i)=='(')
							{
								nr++;
								p++;
							}
						if(expresie.charAt(i)==')')
							nr--;
					}
					
					String f=expresie.substring(1, i-1);				
					Nod n = new ArboreDeParsare(f).radacina();	 
					StivaNoduri.push(n);						//se creaza un nou nod care va fi radacina unui nou arbore
					
					while(p>0 && citeste.hasNext())			// se urmareste incheierea expresiei din interiorul parantezelor
					{
						cuv = citeste.next();
						expresie = expresie.substring(expresie.indexOf(cuv));
						if(cuv.equals(")")){
							p--;
						}
					}
				}
				
				else
				if(!op.operatori_binari.keySet().contains(cuv))			
				{
					//System.out.println("operand");
					StivaNoduri.push(factory.take(null, cuv, null));
					//nod nou obtinut cu factory
				}
				
				else
				if(op.operatori_binari.keySet().contains(cuv))
				{
					//System.out.println("operator binar");				
					
					
					if(StivaOperatori.empty())//stiva goala
						StivaOperatori.push(factory.take(null, cuv, null));
					else										//stiva are elemente
					{
						//test priorite operator
						String ultim_op = StivaOperatori.peek().getRadacina();	
						String nou_op = cuv;
						
						
						
					if(op.operatori_binari.get(nou_op)>=op.operatori_binari.get(ultim_op))	
							StivaOperatori.push(factory.take(null, cuv, null));
					//se extrag ultimii operatori in stiva si se formeaza noduri noi care vor fi adaugate la StivaNoduri
					else											
						{
							do
							{
								
								Nod node1 = StivaNoduri.pop();
								Nod node2 = StivaNoduri.pop();
								
								Nod operator = StivaOperatori.pop();
								
				// daca avem operatori minus consecutivi
							if(!StivaOperatori.empty()){	
								
									String r = StivaOperatori.peek().getRadacina();
									if(operator.getRadacina().equals("-") && r.equals("-"))					{
										operator.setRadacina("+");
									}
				//sau impartire consecutiv					
									if(operator.getRadacina().equals("/")&&  r.equals("/"))
									{
										operator.setRadacina("*");
									}
									
								}
								StivaNoduri.push(factory.take(node2,operator.getRadacina(),node1));
								
								if(StivaOperatori.empty()==false)
									ultim_op = StivaOperatori.lastElement().getRadacina();
							}while(op.operatori_binari.get(ultim_op)>op.operatori_binari.get(nou_op) && StivaOperatori.empty()==false);
							
							StivaOperatori.push(factory.take(null, cuv, null));
						}
						
					}
				}
			}
	
			
			citeste.close();
			
	//se creaza arbore prin extragerea tuturor operatorilor si formarea de noi noduri
			while(!StivaOperatori.empty()){	
				
				Nod node1=null,node2=null;
				
				if(!StivaNoduri.empty()){
					node1 = StivaNoduri.pop();
				}
				if(!StivaNoduri.empty()){
					node2 = StivaNoduri.pop();
				}
				Nod operator = StivaOperatori.pop();
			//cazul minus sau impartit de mai devreme
				if(!StivaOperatori.empty()){	
				
					String s = StivaOperatori.peek().getRadacina();
					if(operator.getRadacina().equals("-") && 	s.equals("-"))	{
						operator.setRadacina("+");
					}
					
					if(operator.getRadacina().equals("/")&&		s.equals("/"))
					{
						operator.setRadacina("*");
					}
					
				}
				StivaNoduri.push(factory.take(node2,operator.getRadacina(),node1));
			}
			
			this.radacina=StivaNoduri.pop();
						
		}
	
					
}
