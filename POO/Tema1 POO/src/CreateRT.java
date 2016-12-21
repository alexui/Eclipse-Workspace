

import java.util.ArrayList;

public class CreateRT {
	
	private RadixTree tree;
	private int word_count=-1;
	public final Object NOT_FOUND=null;
	
	
	/**
	 * metoda de creare a unui RADIX TREE pe baza unui fisier
	 * @param FilePath reprezinta calea fisierului
	 */
	public CreateRT(String FilePath)
	{
		String word;
		FileParser textFile = new FileParser(FilePath);
		tree=new RadixTree();
		textFile.open();
		while((word=textFile.getNextWord())!=null) // adauga in arbore fiecare cuvant
		{
			word_count++;
			buildRadixTree(tree,word);
		}
	}
	
	/**
	 * metoda de cautare a prefixului lui word2 in word1
	 * @param word1
	 * @param word2
	 * @return dimensiunea prefixului comun lui word1 si lui word2
	 */
	private int checkForPrefix(String word1,String word2)
	{
		int i=-1;
		while((i+1)<word1.length() && (i+1)<word2.length() && word1.charAt(i+1)==word2.charAt(i+1))
			i++;
		return i;
	}
	
	/**
	 * metoda de introducere in arbore a unui nou cuvant 
	 * @param rt
	 * @param key
	 * @return <code>true</code> daca cuvantul a fost adaugat sau <code>false</code> daca cuvantul se afla deja in arbore
	 */
	public boolean buildRadixTree(RadixTree rt, String key) 
	{		
		boolean val=true;
		ArrayList<Integer> pos=null;
		if(rt.getUrm().length==0) // daca nu are succesori adauga key ca succesor
		{
			rt.addNod(key);
			rt.getUrm()[0].getPos().add(word_count);
			return true;
		}
		
		int i,p=-1;
		
			
		for(i=0;i<rt.getUrm().length;i++)
			{
			//if(rt.getUrm()[i]!=null)
				p=checkForPrefix(rt.getUrm()[i].getKey(),key);
			//else return false;
			if(p>=0) break;
			// daca s-a gasit prefix se opreste cautarea
			} 
		
		// i reprezinta indexul succesorului al carui prefix coincide cu al cheii 
		
		
		if(p==-1) //daca prefxul lui key nu corespunde cu nici un prefix al succesorilor adauga key ca succesor
		{
			rt.addNod(key);
			rt.getUrm()[rt.getSub()-1].getPos().add(word_count);
			return true;
		}
		
		if(p>=0) // daca prefixul lui key corespunde cu a unui succesor 
		{
			if(key.equals(rt.getUrm()[i].getKey())) //daca cheyle coincid se returneaza false adica- nu s-a construit nimic
			{									
				rt.getUrm()[i].getPos().add(word_count);
				return false;
			}
			
			if(p+1==rt.getUrm()[i].getKey().length()) // daca prefixul lui key este in totalitate un succesor
			{
				if(rt.getUrm()[i].getUrm().length==0) //daca nu avem succesori pentru succesorul de fata
				{
					String word=rt.getUrm()[i].getKey();			//se creaza un nou arbore pornind de la succesorul curent
					pos=rt.getUrm()[i].getPos();
					rt.getUrm()[i]=new RadixTree();
					rt.getUrm()[i].setKey(word.substring(0, p+1)); // seteaza prefix comun la succesor
					rt.getUrm()[i].setPos(pos);
					val=buildRadixTree(rt.getUrm()[i],key.substring(p+1)); // sufixul va fi adaugat la arbore 
					return val;
				}
				else
					{
					val=buildRadixTree(rt.getUrm()[i],key.substring(p+1)); //daca exista succesori se cauta pozitionarea sufixului
					return val;
					}
			}
			
			if(key.equals(key.substring(0, p+1))) // daca prefixul succesorului este egal in totalitate cu key
				{
					String word=rt.getUrm()[i].getKey(); //se creaza un nou arbore pornind de la succesorul curent
										
					RadixTree aux = rt.getUrm()[i]; //se retine nod curent in aux
					rt.getUrm()[i]=new RadixTree(); // se creaza nod nou
					rt.getUrm()[i].setKey(key);
					rt.getUrm()[i].getPos().add(word_count); // se adauga pozitie in lista de pozitii
					
					
					aux.setKey(word.substring(p+1)); //se adauga aux ca succesor
					rt.getUrm()[i].extendUrm();
					rt.getUrm()[i].getUrm()[0]=aux;
					
					return val;
				}
			
			else //daca prefixul lui key nu este in totalitate un succesor si nici prefixul succesorului nu este egal in totalitate cu key
			{
				String word=rt.getUrm()[i].getKey(); //se pastreaza cheia succesorului de fata
				if(rt.getUrm()[i].getUrm().length==0) // daca succesorul nu are succesori
				{
					pos=rt.getUrm()[i].getPos();
					rt.getUrm()[i]=new RadixTree();   //se creaza un nou arbore pornind de la succesorul curent
					rt.getUrm()[i].setKey(word.substring(0, p+1));  // seteaza prefix cumun la succesor
					val=buildRadixTree(rt.getUrm()[i],word.substring(p+1));  // se adauga la arbore sufixul cheilor
					rt.getUrm()[i].getUrm()[0].setPos(pos); // se pastreza pozitia gasita pentru succesorul curent
					val=buildRadixTree(rt.getUrm()[i],key.substring(p+1));
					return val;
				}
				else // daca succesorul are succesori
				{
					RadixTree aux=rt.getUrm()[i];  // creaza nod auxiliar
					aux.setKey(word.substring(p+1)); // nodul auxiliar are cheia - sufixul din succesor curent
					rt.getUrm()[i]=new RadixTree();   //se creaza un nou arbore pornind de la succesorul curent
					rt.getUrm()[i].setKey(word.substring(0, p+1)); // seteaza prefix cumun la succesor
					rt.getUrm()[i].extendUrm();
					rt.getUrm()[i].getUrm()[0]=aux; // se adauga in lista de succesori a succesorului curent nodul aux.
					val=buildRadixTree(rt.getUrm()[i],key.substring(p+1)); //se adauga la arbore sufixul cheii de la succesor
					return val;
				}
			}
		}
		return val;
	}
	
	/**
	 * metoda de afisare a arborelui
	 * @param tree
	 * @param nr - numar taburi
	 */
	public void printRadixTree(RadixTree tree,int nr)
	{
		int i,j;
		
		for(i=0;i<tree.getSub();i++)
		{
			for(j=0;j<nr;j++)
				System.out.print("\t");
			System.out.println(tree.getUrm()[i].getKey() + tree.getUrm()[i].getPos().toString());
			if(tree.getUrm()[i].getSub()!=0)
				printRadixTree(tree.getUrm()[i], nr+1);
		}
	}

	/**
	 * metoda de cautare a unui cuvant in {@link RadixTree} 
	 * @param rt
	 * @param key
	 * @return un vector de pozitii in care cuvantul a fost gasit
	 */
	public int[] search(RadixTree rt,String key) 
	{
		if(rt.getUrm().length==0) 
			return null;
		
		int i,p=-1;
		for(i=0;i<rt.getUrm().length;i++)
			{
			//if(rt.getUrm()[i]!=null)
				p=checkForPrefix(rt.getUrm()[i].getKey(),key);
			//else	return null;
			if(p>=0) break;
			// daca s-a gasit prefix se opreste cautarea
			} // i reprezinta indexul succesorului al carui prefix coincide cu al cheii 
		
		if(key.equals(key.substring(0, p+1))) //s-a gasit key in arbore 
		{			
			IntArray index = new IntArray();
			return seek(rt.getUrm()[i],index);    //se cauta toti succesorii care incep cu prefixul key
		}
		
		if(p==-1) //daca prefxul lui key nu corespunde cu nici un prefix al succesorilor adauga key ca succesor
		{
			return null;
		}
		
		if(p>=0) // daca prefixul lui key corespunde cu a unui succesor 
		{
			return search(rt.getUrm()[i],key.substring(p+1));
		}
		
		return null;

	}
	
	/**
	 * metoda auxiliara utila metodei public int[] search(RadixTree rt,String key)  
	 * metoda cauta recursiv toate cuvintele care incep cu prefixul aflat in nod
	 * @param nod
	 * @param a
	 * @return un vector cu toate pozitiile cuvintelor gasite
	 */
	private int[] seek(RadixTree nod,IntArray a) 
	{
		if(nod.getPos()!=this.NOT_FOUND)
			for(int i=0;i<nod.getPos().size();i++)
				a.add(nod.getPos().get(i));
		if(nod.getSub()!=0)
		{
			int i;
			for(i=0;i<nod.getSub();i++)
				seek(nod.getUrm()[i],a);
		}
		return a.getA();
	}
	
	/**
	 * getter pentru RadixTree
	 * @return arbore RADIX-TREE
	 */
	public RadixTree getRadixTree()
	{
		return tree;
	}
}