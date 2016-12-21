import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;


public class ExpressionParser {
	
	NodeFactory factory = new NodeFactory();
	
	private class BinaryOperators{ //clasa contine un map se asociaza fiecarui operator binar  gradul de prioritate ->+ are prioritatea cea mai mare
		
		public LinkedHashMap<String, Integer> map;
		
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
		
		public ArrayList<String> list;
		
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

	private class CorrectSyntax implements Observer{
		
		//clasa de tip observator
		//contine o lista de token-uri posibile 
		//cand observatorul este notificat se verifica daca token-ul curent face parte din lista token-urilor posibile
		//	-daca nu se lanseaza exceptie sintactica
		//	-daca da se actualizeaza lista de token-uri posibile

		private ArrayList<TokenType> posibleTokens=new ArrayList<TokenType>();
		private TokenType currentToken;
		
		public CorrectSyntax(){
			//o expresie poate sa inceapa cu un operand, o paranteza deschisa sau un operator unar
			posibleTokens.add(TokenType.OPERAND);
			posibleTokens.add(TokenType.LEFTPARANTHESES);
			posibleTokens.add(TokenType.OPERATOR_UNAR);
		}
		
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
	
	private class CreateTree implements Observable{

		private Node root;
		private Observer obs;
		private String e; //expression
		
		private Stack<Node> ResultStack = new Stack<Node>();				//stiva de noduri
		private Stack<Node> OperatorStack = new Stack<Node>();			//stiva de operatori
		
		public CreateTree(String expression){
			this.e = expression;
			addObserver(new CorrectSyntax());
		}
		
		private void build() throws SyntacticException{
			
			String token;
			
			//inainte de a incepe parsarea se verifica daca numarul parantezelor deschise este egal cu numarul parantezelor inchise
			//se verifica folosirea corecta a minusului
			//dupa verificarea minusului unar si parsarea unui token se redimensioneaza expresia
						
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
				System.out.println(token);
				
				e = e.substring(e.indexOf(token)).substring(token.length());	//redimensioneaza expresie
				
			/*	if(e.length()>1)
					if(e.charAt(0)!=' ' || e.charAt(1)==' ') 						//daca nu se lasa exact un spatiu liber - exceptie
						throw new SyntacticException();*/
				
				System.out.println("e:"+e);
				obs.notifyEvent(token);				//observatorul pentru sintaxa corecta este notificat
				TokenType currentToken = testTokenType(token); // verifica daca token-ul este operator,operand sau paranteza deschisa
				
				if(currentToken == TokenType.OPERATOR_UNAR){ //caz operator unar
					
					System.out.println("operator unar");
					int nr=1;
					int pairs=1;
					int i;
					
					if(e.isEmpty()){
						parse.close();
						throw new SyntacticException();	// caz special pentru un singur operator unar
					}

					if(e.charAt(1)!='('){
						parse.close();
						throw new SyntacticException();	// caz special pentru un singur operator unar
					}
					
					for(i =2;i<e.length() && nr!=0;i++){		//extrage expresia din interiorul parantezelor
						System.out.print(e.charAt(i));			//si numara perechile de paranteze - se retin in  -pairs-
						if(e.charAt(i)=='(')
							{
							nr++;
							pairs++;
							}
						if(e.charAt(i)==')')
							nr--;
					}// end for
					System.out.println();
					
					String f=e.substring(0, i);				// extragere
					System.out.println("f="+f);
					
					//se creaza un nou nod cu un singur descendent avand ca radacina operatorul unar
					Node node = factory.getNode(new CreateTree(f).getRoot(), token, null);
					ResultStack.push(node);						// radacina noului arbore este salvata in stiva de noduri

					while(pairs>0 && parse.hasNext())			// se parseaza in continuare pana la inchiderea parantezelor
					{
						token = parse.next();
						e = e.substring(e.indexOf(token));
						System.out.println("token: "+token);
						currentToken = testTokenType(token);
						if(currentToken == TokenType.RIGHTPARANTHESES){	//cand se intalneste paranteza inchisa variabila pairs scade cu 1
							pairs--;
						}
					}
				}//end if

				else
				if(currentToken == TokenType.LEFTPARANTHESES)	//caz paranteza deschisa
				{
					System.out.println("parantheses");
					int nr=1;
					int pairs=1;
					int i;
					for(i =1;i<e.length() && nr!=0;i++){		//extrage expresia din interiorul parantezelor
						System.out.print(e.charAt(i));			//si numara perechile de paranteze - se retin in  -pairs-
						if(e.charAt(i)=='(')
							{
							nr++;
							pairs++;
							}
						if(e.charAt(i)==')')
							nr--;
					}// end for
					System.out.println();
					
					String f=e.substring(1, i-1);				// extragere
					System.out.println(f);
					Node node = new CreateTree(f).getRoot();	// se creaza un nou arbore 
					ResultStack.push(node);						// radacina noului arbore este salvata in stiva de noduri
					
					while(pairs>0 && parse.hasNext())			// se parseaza in continuare pana la inchiderea parantezelor
					{
						token = parse.next();
						e = e.substring(e.indexOf(token));
						System.out.println("token: "+token);
						currentToken = testTokenType(token);
						if(currentToken == TokenType.RIGHTPARANTHESES){	//cand se intalneste paranteza inchisa variabila pairs scade cu 1
							pairs--;
						}
					}
				}//end if
				
				else
				if(currentToken == TokenType.OPERAND)			// caz operand
				{
					System.out.println("operand");
					ResultStack.push(factory.getNode(null, token, null));
					//se creaza nod fara descendenti avand ca radacina operandul
				}// end if
				
				else
				if(currentToken == TokenType.OPERATOR_BINAR)			// caz operator binar
				{
					System.out.println("operator binar");				
					
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
								System.out.println("last: "+lastToken);
								Node node1 = ResultStack.pop();
								Node node2 = ResultStack.pop();
								
								Node operator = OperatorStack.pop();
								
								//Pentru cazurile in care avem - si / exista un caz special
								//O data ce a aparut semnul -,daca semnul urmator este - acesta va deveni + 1-2-3 devin 1-(2+3)
								//O data ce a aparut semnul /,daca semnul urmator este / acesta va deveni * 1/2/3 devin 1/(2*3)
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
									lastToken = OperatorStack.lastElement().getRoot();
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
				//O data ce a aparut semnul -,daca semnul urmator este - acesta va deveni + 1-2-3 devin 1-(2+3)
				//O data ce a aparut semnul /,daca semnul urmator este / acesta va deveni * 1/2/3 devin 1/(2*3)
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
			}
			
			this.root=ResultStack.pop();
						
		}
		
		@Override
		public void addObserver(Observer o) {
			this.obs=o;
		}

		@Override
		public void removeObserver(Observer o) {
			if(this.obs.equals(o))
				this.obs=null;
			else return;
		}
		
		public Node getRoot() throws SyntacticException{
			
			build();
			return root;
		}
		
		private int searchForCharacter(String s,char c){
			
			int nr=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==c)
					nr++;
				}
			return nr;
		}
		
		private boolean testCorectMinus(String s){
			
			int i=0;
			while(s.charAt(i)==' ' || s.charAt(i)=='(') i++;
			
			
			if(s.charAt(i)=='-' && s.charAt(i+1)!=' ' && Character.isDigit(s.charAt(i+1))==false)
				return false;
			return true;
		}
		
		public void printTree(Node root,int tabs){
			
			System.out.println(root.getRoot());
			for(int i=0;i<tabs;i++)
				System.out.print("\t");
			if(root.getLeft()==null)
				System.out.println();
			else
				printTree(root.getLeft(),tabs+1);
			
			for(int i=0;i<tabs;i++)
				System.out.print("\t");
			if(root.getRight()==null)
				System.out.println();
			else
				printTree(root.getRight(),tabs+1);
		}
	
	}
	
	BinaryOperators bo = new BinaryOperators();
	UnaryOperators uo = new UnaryOperators();
		
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
	
	private double calculator(Node node) throws EvaluatorException, SyntacticException{
		
		Compute compute =new Compute();
		
				
		double left,right;
		if(node.getLeft()!=null)
			{
			left=calculator(node.getLeft());
			node.getLeft().setRoot(String.valueOf(left));
			}
		if(node.getRight()!=null)
			{
			right=calculator(node.getRight());
			node.getRight().setRoot(String.valueOf(right));
			}
		return node.accept(compute);
	}
	
	public Double eval(String expression) throws SyntacticException, EvaluatorException{
		
		CreateTree parseTree = new CreateTree(expression);
		Node root = parseTree.getRoot();
		System.out.println();
		System.out.println("-TREE-");
		parseTree.printTree(root, 0);
		System.out.println(calculator(root));
		return calculator(root);
	}
	
}
