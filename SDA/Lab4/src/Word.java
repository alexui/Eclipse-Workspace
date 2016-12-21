
public class Word {

	/**
	 * @param args
	 */
	private String text;
	
	public Word (String s)
	{
		int i=0,j=s.length()-1;
		while(i<s.length() && !Character.isLetter(s.charAt(i)))
			i++;
		while(j>i && !Character.isLetter(s.charAt(j)))
			j--;
		text=s.substring(i,j+1);
	}
	
	public int NumberOfSyllables()
	{
		int counter=0,i;
		String vowels="AEIOUaeiou";
		if(text.charAt(text.length()-1)=='e')
			text=text.substring(0,text.length()-1);
		boolean GroupOfVowels=false;
		for(i=0;i<text.length();i++)
		{
			if(vowels.indexOf(text.charAt(i))>0)
			{
				if(!GroupOfVowels)
				{
					GroupOfVowels=true;
					counter++;
				}
			}
			else
				GroupOfVowels=false;
		}	
		
		if(counter==0)
			counter=1;
		
		return counter;
		}
						
}

	

