
public class MainClass {

	public static void main(String[] args) {

		MyHashMapImpl<Student, Integer> hm1 = new MyHashMapImpl<Student,Integer>(20); 
		
		
		MyHashTesterForStudent test = new MyHashTesterForStudent();
		test.run(hm1,1000,"Student.txt",100);
		
		MyHashMapImpl<LazyStudent, Integer> hm2 = new MyHashMapImpl<LazyStudent,Integer>(20); 
		
		
		MyHashTesterForLazyStudent test2 = new MyHashTesterForLazyStudent();
		test2.run(hm2,1000,"LazyStudent.txt",100);
	}

}
