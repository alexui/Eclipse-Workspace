package tetris;

public class Enumerate {
	 enum Tetrominoes { NoShape, ZShape, SShape, LineShape, 
         TShape, SquareShape, LShape, MirroredLShape };
     static Tetrominoes[] values = Tetrominoes.values();
     
     public static void main(String[] args){
    	 
    	 System.out.println("enum: "+values[2]);
     }

}
