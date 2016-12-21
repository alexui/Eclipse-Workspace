

import java.sql.Array;
import java.util.ArrayList;

public class RadixTree {
		
	private String key;
	private ArrayList<Integer> pos;
	private RadixTree[] urm;
	private int sub=0;// numar noduri subordonate
	
	/**
	 * se creeaza o structura care contine :<br>
	 * un {@link ArrayList} pentru "pozitii";<br>
	 * un {@link Array} de valori de tip {@link RadixTree} pentru sussesori (descendenti directi);<br>
	 * un {@link Integer} pentru numarul de succesori;<br>
	 * un {@link String} ce retine prefixul (cheia);
	 * 
	 */
	
	public RadixTree()
	{
		this.pos= new ArrayList<>();
		this.urm=new RadixTree[0];
		this.key="";
	}
	
	/**
	 * adauga descendent
	 * @param s
	 */
	
	public void addNod(String s) 
	{
		this.urm = Realloc(this.urm,this.urm.length+1);
		this.urm[sub]=new RadixTree();
		this.urm[sub].key=s;
		this.sub++;
		
	}

	/**
	 * setter pentru {@link ArrayList}-ul de pozitii
	 * @param pos
	 */
	public void setPos(ArrayList<Integer> pos) {
		
		this.pos=pos;
	}
	
	/**
	 * getter pentru {@link ArrayList}-ul de pozitii
	 * @return {@link ArrayList} de pozitii
	 */
	public ArrayList<Integer> getPos() {
		return pos;
	}

	/**
	 * getter pentru prefix
	 * @return prefix
	 */
	public String getKey() {
		return key;
	}

	/**
	 * setter pentru prefix
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * getter pentru {@link RadixTree}
	 * @return {@link Array} de tip {@link RadixTree}
	 */
	public RadixTree[] getUrm() {
		return urm;
	}

	/**
	 * setter pentru {@link RadixTree}
	 * @param urm
	 */
	public void setUrm(RadixTree[] urm){
		this.urm=urm;
	}
	
	/**
	 * getter pentru numarul de succesori
	 * @return numar de succesori
	 */
	public int getSub() {
		return this.sub;
	}
	
	/**
	 * realoca vectorul la dimensiunea specificata de parametru
	 * @param array
	 * @param new_dim 
	 */
	
	private RadixTree[] Realloc(RadixTree[] array,int new_dim)
	{
		RadixTree[] aux = new RadixTree[new_dim];
		int old_dim=array.length;
		int preserveLength = Math.min(old_dim, new_dim);
		System.arraycopy(array, 0, aux, 0, preserveLength);
		return aux;
	}
	
	/**
	 * extinde vectorul cu o unitate
	 */
	
	public void extendUrm()
	{
		this.urm = Realloc(this.urm,this.urm.length+1);
		this.sub++;
	}

	/**
	 * setter pentru numarul de succesori
	 * @param sub
	 */
	public void setSub(int sub) {
		this.sub=sub;
	}

}
