
public class RabinKarp {

	private String pat; 			// the pattern
	private int patHash; 			// pattern hash value
	private int M; 					// pattern length
	private int Q = 83543; 		// modulus
	private int R;					 // radix
	private int RM;
	private int N;
	
	public RabinKarp(String pat,int R)
	{
		this.pat=pat;
		this.M=pat.length();
		this.R=R;
		RM=1;
		
		for(int i=1;i<=M-1;i++)
			RM=(R*RM)%Q;
		
		patHash=hash(pat);
	}
	
	public int hash(String key)
	{
		int h = 0;
		for(int i=0;i<M;i++)
		{
			h=(h*R+key.charAt(i))%Q;
		}
		return h;
	}
	
	public int search(String txt)
	{
		N=txt.length();
		if(M>N)
			return N; 
		int offset=hashSearch(txt);
		if(offset==N)
			return N;
		for(int i=0;i<M;i++)
			if(pat.charAt(i)!=txt.charAt(offset+i))
				return N;
	    return offset;		
	}
	
	private int hashSearch(String txt)
	{
		N = txt.length();
		int textHash = hash(txt);
		if(textHash==patHash)
			return 0;
		for(int i=M;i<N;i++)
		{
			textHash = (textHash % Q - RM * txt.charAt(i-M) % Q)%Q;
			textHash = (textHash * R +txt.charAt(i)) % Q;
			if(textHash==patHash)
				return i-M+1;		
		}
	 return N;
	}
	

}
