package Exemple;

class Outer {

	   public Hidden getInnerInstance(int i) {
		   
		   if(i==11){
	        class FuncInner implements Hidden {
	            private int i = 11;
	        
	            public int value () {
	                return i;
	            }
	        }
	         
	        return new FuncInner();
		   }
		   else return null;
	   } // atentie !! clasa va fi creata chiar daca nu este adevarata conditia de la if
}

