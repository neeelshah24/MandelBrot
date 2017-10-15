import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}
	
	
	
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(6);
		MyDouble b = new MyDouble(-3);
		MyDouble c = new MyDouble(2);
		MyDouble d = new MyDouble(9);
		MyDouble e = new MyDouble(-8);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		
		ComplexNumber z = new ComplexNumber(a.add(c),b.add(d));
		
		ComplexNumber u = new ComplexNumber(a.add(c));
		
		ComplexNumber p = new ComplexNumber(a.add(c),e.add(b));
		
		assertTrue(z.toString().equals("8.0+6.0i"));
		assertTrue(u.toString().equals("8.0+0.0i"));
		assertTrue(p.toString().equals("8.0-11.0i"));
	}
	
	@Test
	public void testSubtract() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(8);
		MyDouble c = new MyDouble(2);
		MyDouble d = new MyDouble(9);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		
		ComplexNumber z = new ComplexNumber(a.subtract(c),b.subtract(d));
		
		ComplexNumber u = new ComplexNumber(a.subtract(c));
		
		ComplexNumber p = new ComplexNumber(a.subtract(c),b.subtract(c));
		
		assertTrue(z.toString().equals("3.0-1.0i"));
		assertTrue(u.toString().equals("3.0+0.0i"));
		assertTrue(p.toString().equals("3.0+6.0i"));
		
	}
	
	@Test
	public void testMult() {
		MyDouble a = new MyDouble(-2);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(9);
		MyDouble d = new MyDouble(-4);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		
		ComplexNumber z = new ComplexNumber(x.multiply(y));
		
		assertTrue(z.toString().equals("2.0+53.0i"));
	}
	
	@Test
	public void testDiv() {
		MyDouble a = new MyDouble(16);
		MyDouble b = new MyDouble(-2);
		MyDouble c = new MyDouble(3);
		MyDouble d = new MyDouble(-2);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		
		ComplexNumber z = new ComplexNumber(x.divide(y));
		
		assertTrue(z.toString().equals("4.0+2.0i"));
	}
	
	@Test
	public void testEqComp() {
		MyDouble a = new MyDouble(3);
		MyDouble b = new MyDouble(6);
		MyDouble c = new MyDouble(2);
		MyDouble d = new MyDouble(4);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		ComplexNumber z = new ComplexNumber(a,a);
		ComplexNumber u = new ComplexNumber(a,a);
		
		assertTrue(z.equals(u));
		assertTrue(x.compareTo(y) == 1);
		assertTrue(x.compareTo(y) != 0);
		
			
	}
	
	@Test
	public void testToString() {
		ComplexNumber a = new ComplexNumber(new MyDouble(3),new MyDouble(8));
		ComplexNumber b = new ComplexNumber(new MyDouble(-2),new MyDouble(-1));
		ComplexNumber c = new ComplexNumber(new MyDouble(8),new MyDouble(-3));
		
		assertTrue(a.toString().equals("3.0+8.0i"));
		assertTrue(b.toString().equals("-2.0-1.0i"));
		assertTrue(c.toString().equals("8.0-3.0i"));
		
		
	}
	
	@Test
	public void testNorm() {
		MyDouble a = new MyDouble(4);
		MyDouble b = new MyDouble(3);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(-12);
		
		ComplexNumber x = new ComplexNumber(a,b);
		ComplexNumber y = new ComplexNumber(c,d);
		
		MyDouble r = new MyDouble(ComplexNumber.norm(x));
		
		MyDouble t = new MyDouble(ComplexNumber.norm(y));
		
		assertTrue(r.toString().equals("5.0"));
		assertTrue(t.toString().equals("13.0"));
	}
	
	
}
