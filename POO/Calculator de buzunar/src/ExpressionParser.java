import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author alexandru budau 323 CB
 * clasa se ocupa cu calculul unei expresii matematice 
 * contine un numar de clase interne
 * contine instante ale altor clase din default package 
 */
public class ExpressionParser {
	
	
	NodeFactory factory = new NodeFactory();
	
	private class BinaryOperators{ //clasa contine un map se asociaza fiecarui operator binar  gradul de prioritate -> + are prioritatea cea mai mare
		
		/**
		 * map este o mapare a sirurilor de caractere ce descriu operatori la intregi reprezentand prioritatea
		 */
		public LinkedHashMap<String, Integer> map;
		
		/**
		 * initializeaza map cu + - * / ^ 
		 */
		public BinaryOperators(){
			
			map = new LinkedHashMap<String,Integer>();
			map.put("+",1);
			map.put("-",2);
			map.put("*",3);
			map.put("/",4);
			map.put("^",5);
		}
	}
	
	private class UnaryOperators{
		
		/**
		 * list contine siruri de caractere ce descriu operatori unari
		 */
		public ArrayList<String> list;
		
		/**
		 * list se initializeaza cu sin,cos,log,sqrt
		 */
		public UnaryOperators(){
			
			list = new ArrayList<String>();
			list.add("sin");
			list.add("log");
			list.add("sqrt");
			list.add("cos");
			list.add("tan");
			list.add("cot");
		}
	}

	/**
	 * 
	 * clasa de tip observator, verifica corectitudinea sintactica a expresiei
	 * contine o lista de token-uri posibile 
	 * cand observatorul este notificat se verifica daca token-ul curent face parte din lista token-urilor posibile
	 *	-daca nu se lanseaza exceptie sintactica
	 *	-daca da se actualizeaza lista de token-uri posibile
	 */
	private class CorrectSyntax implements Observer{

		/**
		 * 
		 */
		private ArrayList<TokenType> posibleTokens=new ArrayList<TokenType>();
		private TokenType currentToken;
		
		/**
		 * o expresie poate sa inceapa cu un operand, o paranteza deschisa sau un operator unar
		 */
		public CorrectSyntax(){
			
			posibleTokens.add(TokenType.OPERAND);
			posibleTokens.add(TokenType.LEFTPARANTHESES);
			posibleTokens.add(TokenType.OPERATOR_UNAR);
		}
		
		/**
		 * se actualizeaza lista de token-uri posibile:
		 * -dupa paranteza deschisa poate urma operator binar, sau paranteza inchisa
		 * -dupa operand poate urma operator binar sau paranteza inchisa
		 * -dupa operator binar poate urma operator unar, paranteza deschisa sau operand
		 * -dupa paranteza inchisa poate urma operator binar sau paranteza inchisa
		 * -dupa operator unar poate urma paranteza inchisa sau operator binar
		 * -daca token-ul nu corespunde nici unuia din cazuri estelansata o exceptie sintactica
		 * @throws SyntacticException
		 */

		@Override
		public void notifyEvent(String s) throws SyntacticException {
			
			currentToken=testTokenType(s);
			
			if(!posibleTokens.contains(currentToken))
				throw new SyntacticException();
			
			posibleTokens.clear();
			switch(currentToken){
				case LEFTPARANTHESES:	//dupa paranteza deschisa poate urma operator binar, sau paranteza inchisa
					posibleTokens.add(TokenType.RIGHTPARANTHESES);
					posibleTokens.add(TokenType.OPERATOR_BINAR);
					break;
				case OPERAND:			//dupa operand poate urma operator binar sau paranteza inchisa
					posibleTokens.add(TokenType.RIGHTPARANTHESES);
					posibleTokens.add(TokenType.OPERATOR_BINAR);
					break;
				case OPERATOR_BINAR:	//dupa operator binar poate urma operator unar, paranteza deschisa sau operand
					posibleTokens.add(TokenType.OPERAND);
					posibleTokens.add(TokenType.LEFTPARANTHESES);
					posibleTokens.add(TokenType.OPERATOR_UNAR);
					break;
				case RIGHTPARANTHESES:	//dupa paranteza inchisa poate urma operator binar sau paranteza inchisa
					posibleTokens.add(TokenType.OPERATOR_BINAR);
					posibleTokens.add(TokenType.RIGHTPARANTHESES);
					break;
				case OPERATOR_UNAR:		//dupa operator unar poate urma paranteza inchisa sau operator binar
					posibleTokens.add(TokenType.OPERATOR_BINAR);
					posibleTokens.add(TokenType.RIGHTPARANTHESES);
					break;
				default:				//daca token-ul nu corespunde nici unuia din cazuri estelansata o exceptie sintactica
					throw new SyntacticException();	
			}
		}
		
	}
	
	/**
	 * 
	 * @author aless
	 * clasa observabila, se ocupa de parsarea expresiei si creerea arborelui
	 * utilizeaza un observator care este notificat la citirea fiecarui token
	 * pentru crearea arborelui se utilizeaza o stiva de noduri - rezultat si o stiva de noduri - operator
	 */
	private class CreateTree implements Observable{

		/**
		 * nodul de la care porneste constructia arborelui
		 */
		private Node root;	
		private Observer obs;
		private String e; //expression
		
		private Stack<Node> ResultStack = new Stack<Node>();				//stiva de noduri
		private Stack<Node> OperatorStack = new Stack<Node>();			//stiva de operatori
		
		/**
		 * 
		 * @param expression
		 * la fiecare apelare a constructorului se va crea un nou observator - util pentru recursivitate
		 */
		public CreateTree(String expression){
			this.e = expression;
			addObserver(new CorrectSyntax());
		}
		
		/**
		 * metoda construieste arborele 
		 * @throws SyntacticException
		 * inainte de a incepe parsarea se verifica daca numarul parantezelor deschise este egal cu numarul parantezelor inchise
		 * se verifica folosirea corecta a minusului
		 * dupa verificarea minusului unar si parsarea unui token se redimensioneaza expresia
		 */
		private void build() throws SyntacticException{
			
			String token;
									
			//verificarea numarului de paranteze
			if(searchForCharacter(e, '(')!=searchForCharacter(e,')'))		
				throw new SyntacticException();
			
			//folosirea incorecta a minusului unar
			if(!testCorectMinus(e))		
				throw new SyntacticException();
			
			if(e.charAt(0)=='-'){ 
				ResultStack.push(new Operand(null,"0",null));
				OperatorStack.push(new Minus(null,"-",null));
				e=e.substring(1);
				}
			
		Scanner parse = new Scanner(e);
		
			while(parse.hasNext()){		//cat timp in expresie exista token-uri (operatori,oeranzi sau paranteze)
				
				token =  parse.next();	//salveaza token
				
				e = e.substring(e.indexOf(token)).substring(token.length());	//redimensioneaza expresie
								
				obs.notifyEvent(token);				//observatorul pentru sintaxa corecta este notificat
				TokenType currentToken = testTokenType(token); // verifica daca token-ul este operator,operand sau paranteza deschisa
				
				if(currentToken == TokenType.OPERATOR_UNAR){ //caz operator unar
					
					int nr=1;
					int pairs=1;
					int i;
					
					if(e.isEmpty()){
						parse.close();
						throw new SyntacticException();	// caz special pentru un singur operator unar fara argument
					}

					if(e.charAt(1)!='('){
						parse.close();
						throw new SyntacticException();	// caz special pentru paranteza
					}
					
					for(i =2;i<e.length() && nr!=0;i++){		//extrage expresia din interiorul parantezelor
																//si numara perechile de paranteze - se retin in  -pairs-
						if(e.charAt(i)=='(')
							{
							nr++;
							pairs++;
							}
						if(e.charAt(i)==')')
							nr--;
					}// end for
					
					String f=e.substring(0, i);				// extragere
					
					//se creaza un nou nod cu un singur descendent avand ca radacina operatorul unar
					Node node = factory.getNode(new CreateTree(f).getRoot(), token, null);
					ResultStack.push(node);						// radacina noului arbore este salvata in stiva de noduri

					while(pairs>0 && parse.hasNext())			// se parseaza in continuare pana la inchiderea parantezelor
					{
						token = parse.next();
						e = e.substring(e.indexOf(token));
						currentToken = testTokenType(token);
						if(currentToken == TokenType.RIGHTPARANTHESES){	//cand se intalneste paranteza inchisa variabila pairs scade cu 1
							pairs--;
						}
					}
				}//end if

				else
				if(currentToken == TokenType.LEFTPARANTHESES)	//caz paranteza deschisa
				{
					int nr=1;
					int pairs=1;
					int i;
					for(i =1;i<e.length() && nr!=0;i++){		//extrage expresia din interiorul parantezelor
																//si numara perechile de paranteze - se retin in  -pairs-
						if(e.charAt(i)=='(')
							{
							nr++;
							pairs++;
							}
						if(e.charAt(i)==')')
							nr--;
					}// end for
					
					String f=e.substring(1, i-1);				// extragere
					Node node = new CreateTree(f).getRoot();	// se creaza un nou arbore 
					ResultStack.push(node);						// radacina noului arbore este salvata in stiva de noduri
					
					while(pairs>0 && parse.hasNext())			// se parseaza in continuare pana la inchiderea parantezelor
					{
						token = parse.next();
						e = e.substring(e.indexOf(token));
						currentToken = testTokenType(token);
						if(currentToken == TokenType.RIGHTPARANTHESES){	//cand se intalneste paranteza inchisa variabila pairs scade cu 1
							pairs--;
						}
					}
				}//end if
				
				else
				if(currentToken == TokenType.OPERAND)			// caz operand
				{
					ResultStack.push(factory.getNode(null, token, null));
					//se creaza nod fara descendenti avand ca radacina operandul
				}// end if
				
				else
				if(currentToken == TokenType.OPERATOR_BINAR)			// caz operator binar
				{
				
					// daca stiva de operatori este goala se introduce operator
					
					if(OperatorStack.empty())
						OperatorStack.push(factory.getNode(null, token, null));
					else										//daca stiva de operatori nu este goala
					{
						String lastToken = OperatorStack.lastElement().getRoot();	
						String newToken = token;
						
						//se compara prioritatea operatorului curent cu prioritatea ultimului element din stiva
						//daca operatorul nou este mai prioritar se introduce in stiva
						
						if(bo.map.get(lastToken)<=bo.map.get(newToken))	
							OperatorStack.push(factory.getNode(null, token, null));
						
						//altel se extrag pe rand cate doua noduri si cate un operator pentru a se crea un nou nod avand:
						//	-doi descendenti
						//	-radacina: operatorul extras ultima data
						//cat timp operatorul ramas ultim dupa extragere este mai putin sau la fel de prioritar ca operatorul curent
						else											
						{
							do
							{
								Node node1 = ResultStack.pop();
								Node node2 = ResultStack.pop();
								
								Node operator = OperatorStack.pop();
								
								//Pentru cazurile in care avem - si / exista un caz special
								//Odata ce a aparut semnul -,daca semnul urmator este - acesta va deveni + 1-2-3 devin 1-(2+3)
								//Odata ce a aparut semnul /,daca semnul urmator este / acesta va deveni * 1/2/3 devin 1/(2*3)
								if(!OperatorStack.empty()){	
								
									if(operator.getRoot().equals("-") && OperatorStack.peek().getRoot().equals("-"))					{
										operator.setRoot("+");
									}
									
									if(operator.getRoot().equals("/")&&OperatorStack.peek().getRoot().equals("/"))
									{
										operator.setRoot("*");
									}
									
								}
								ResultStack.push(factory.getNode(node2,operator.getRoot(),node1));
								
								if(OperatorStack.size()>0)
									lastToken = OperatorStack.lastElement().getRoot();	//se actualizeaza ultimul element din stiva
							}while(bo.map.get(lastToken)>bo.map.get(newToken) && OperatorStack.size()>0);
							OperatorStack.push(factory.getNode(null, token, null));
						}
						
					}
				}//end if
			}//end while
	
			
			parse.close();
			
			//pentru crearea arborelui stiva de operatori trebuie sa ramana goala iar stiva de noduri trebuie sa raman doar cu un nod:
			// -radacina
			//se extrag doua noduri din stiva de noduri, un operator din stiva de operatori
			//se creaza un nou nod avand ca descendenti cele doua noduri si radacina operatorul
			while(!OperatorStack.empty()){	
				
				Node node1=null,node2=null;
				if(!ResultStack.empty())
					node1 = ResultStack.pop();
				if(!ResultStack.empty())
					node2 = ResultStack.pop();

				Node operator = OperatorStack.pop();
				
				//Pentru cazurile in care avem - si / exista un caz special
				//Odata ce a aparut semnul -,daca in stiva se mai gaseste - neintrerupt de + acesta va deveni + 1-2-3 devin 1-(2+3)
				//Odata ce a aparut semnul /,daca semnul urmator este / acesta va deveni * 1/2/3 devin 1/(2*3)
				if(!OperatorStack.empty()){	
				
					if(operator.getRoot().equals("-") &&OperatorStack.peek().getRoot().equals("-"))
					{
						operator.setRoot("+");
					}
					
					if(operator.getRoot().equals("/")&&OperatorStack.peek().getRoot().equals("/"))
					{
						operator.setRoot("*");
					}
					
				}
				ResultStack.push(factory.getNode(node2,operator.getRoot(),node1));
				
			}
			
			this.root=ResultStack.pop();	//radacina este salvata
						
		}
		
		/**
		 * adauga observator (se actualizeaza observator curent)
		 * @param o
		 */
		@Override
		public void addObserver(Observer o) {
			this.obs=o;
		}

		/**
		 * elimina observator - ii atribuie observatorului curent valoarea null
		 */
		@Override
		public void removeObserver(Observer o) {
			if(this.obs.equals(o))
				this.obs=null;
			else return;
		}
		
		/**
		 * 
		 * @return radacina arborelui format prin parsarea expresiei
		 * @throws SyntacticException
		 */
		public Node getRoot() throws SyntacticException{
			
			build();
			return root;
		}
		
		/**
		 * cauta caracterul c in sirul s
		 * @param s
		 * @param c
		 * @return pozitia in sirul s unde s-a gasit caracterul c
		 */
		private int searchForCharacter(String s,char c){
			
			int nr=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==c)
					nr++;
				}
			return nr;
		}
		
		/**
		 * 
		 * @param s
		 * @return true daca minusul unar este folosit corect
		 * minusul unar trebuie sa fie despartit cu un spatiu de un operator unar : sin, cos, log, sqrt
		 */
		private boolean testCorectMinus(String s){
			
			int i=0;
			while(s.charAt(i)==' ' || s.charAt(i)=='(') i++;
			if(s.charAt(i)=='-' && s.charAt(i+1)!=' ' && Character.isDigit(s.charAt(i+1))==false)
				return false;
			return true;
		}
		
	}
	
	BinaryOperators bo = new BinaryOperators();
	UnaryOperators uo = new UnaryOperators();
		
	/**
	 * 
	 * @param s token
	 * @return element din enum=ul {@link TokenType} corespunzator token-ului
	 */
	private TokenType testTokenType(String s){
		
		TokenType currentToken;
		if(bo.map.keySet().contains(s))
			currentToken = TokenType.OPERATOR_BINAR;
		else
			if(uo.list.contains(s))
				currentToken = TokenType.OPERATOR_UNAR;
			else
				if(s.equals("("))
				currentToken = TokenType.LEFTPARANTHESES;
				else
					if(s.equals(")"))
						currentToken = TokenType.RIGHTPARANTHESES;
					else 
						currentToken = TokenType.OPERAND;
			
		return currentToken;
	}
	
	/**
	 * 
	 * @param node radacina arborelui in care se va face calculul expresiei
	 * @return rezultat de tip float
	 * @throws EvaluatorException
	 * @throws SyntacticException
	 */
	private double calculator(Node node) throws EvaluatorException, SyntacticException{
		
		/**
		 * vizitator
		 * calculul este facut de vizitator in functie de tipul nodului care accepta vizitatorului
		 */
		Compute compute =new Compute();
		
		double left,right;
		//daca exista adiacent-stanga se reapeleaza metoda calculator pentru a face calculul, iar rezultatul se reintroduce in arbore
		if(node.getLeft()!=null)
			{
			left=calculator(node.getLeft());
			node.getLeft().setRoot(String.valueOf(left));
			}
		//daca exista adiacent-dreapta se reapeleaza metoda calculator pentru a face calculul, iar rezultatul se reintroduce in arbore
		if(node.getRight()!=null)
			{
			right=calculator(node.getRight());
			node.getRight().setRoot(String.valueOf(right));
			}
		
		//calculul este facut de vizitator in functie de tipul nodului care accepta vizitatorului
		return node.accept(compute);
	}
	
	/**
	 * Aceasta metoda primeste ca argument expresia ce trebuie parsata si intoarce rezultatul acesteia.
	 * @param expression
	 * @return rezultat de tip float
	 * @throws SyntacticException
	 * @throws EvaluatorException
	 */
	public double eval(String expression) throws SyntacticException, EvaluatorException{
	
		CreateTree parseTree = new CreateTree(expression);
		Node root = parseTree.getRoot();
			
		return calculator(root);
	}
	
}
