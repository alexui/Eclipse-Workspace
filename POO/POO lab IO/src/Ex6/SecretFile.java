package Ex6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SecretFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RandomAccessFile data_in =null;
		
		try {
			data_in = new RandomAccessFile("secret.txt","rw");
			data_in.writeLong(3);
			data_in.writeInt(2);
			data_in.writeInt(3);
			data_in.writeInt(4);
			data_in.writeInt(5);
			data_in.writeInt(6);
			data_in.seek(0);
			long offset = data_in.readLong();
			System.out.println(offset);
			data_in.skipBytes((int) ((offset-1)*(Integer.SIZE/8)));
			System.out.println("Integer value: "+data_in.readInt());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
	}

}
