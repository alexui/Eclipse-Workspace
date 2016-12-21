package Ex4;

import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends OutputStream{

		protected OutputStream output;
		
		public EncryptOutputStream(OutputStream output)
		{
			this.output=output;
		}

		@Override
		public void write(int b) throws IOException {
			output.write(b+1);
		}

		

}
