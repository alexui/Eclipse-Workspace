package Ex4;

import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends InputStream{

	protected InputStream input;
	
	public DecryptInputStream(InputStream input)
	{
		this.input=input;
	}

	@Override
	public int read() throws IOException {
		int val=input.read();
		if(val==-1)
			return val;
		else return val -1;
		
	}
	
}
