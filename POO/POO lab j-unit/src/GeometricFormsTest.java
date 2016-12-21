import org.junit.*;

public class GeometricFormsTest {

	private GeometricForms form;
	@Before
	public void setup(){
		
		 form= new GeometricForms(Forms.CIRCLE.name());
	}
	
	@org.junit.Test
	public void circleTest(){
		
		Assert.assertTrue(form.isCircle());
	}
	
	@org.junit.Test
	public void triangleTest(){
	
		Assert.assertTrue(form.isTriangle());
	}
	
	@org.junit.Test
	public void rectangleTest(){
		
		Assert.assertTrue(form.isRectangle());
	}
}
