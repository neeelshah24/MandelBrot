import java.awt.Color;

public class MandelbrotTools {
	

	/* this method takes one parameter of a ComplexNumber and will return 
	 * either true of false. this method calculates takes the real value 
	 * of the complex number and squares it, takes the imag value of the 
	 * complex number and squares it and then adds the two numbers together.  
	 * the value will then be compared to the static variable called 
	 * Controller.DIVERGENCE_BOUNDARY, which is built-in to one of the 
	 * classes we have provided. If a2 + b2 is greater than the value 
	 * of the variable named DIVERGENCE_BOUNDARY, then the method returns true.
	 * otherwise it returns false.*/
	public static boolean isBig(ComplexNumber num) {
		MyDouble a = new MyDouble(num.getReal());
		MyDouble b = new MyDouble(num.getImag());
		MyDouble realSquared = new MyDouble(a.multiply(a));
		MyDouble imagSquared = new MyDouble(b.multiply(b));
		if (realSquared.add(imagSquared).compareTo(Controller.DIVERGENCE_BOUNDARY) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*this method takes one parameter, a ComplexNumber which we will call z0.
	 *The method will return type int. the initial parameter value is squared
	 *and this value is stored as a new complex number. the new complex number
	 *is then added by the original parameter. a loop is then put in place to 
	 *see if the value of the new zero ever crosses the value of the static 
	 *Variable Controller.LIMIT. if the value passes the program terminates
	 *if not the loop keeps on going until it terminates. 
	 */
	public static int divergence(ComplexNumber zero) {
		ComplexNumber newZero = zero.multiply(zero);
		newZero = zero.add(newZero);
		if(isBig(newZero)) {
			return 0;
		}
		for (int value = 1; value <= Controller.LIMIT; value++) {
			newZero = newZero.multiply(newZero).add(zero);
			if (isBig(newZero)) {
				return value;
			}
		}
		return -1;
	}
	
	/* This method selects a non-black color for a point which DIVERGED when 
	 * tested with the Mandelbrot recurrence, based on how many terms in the 
	 * sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was 
	 * first to be "too big".  This value could be anything from 0 to 
	 * Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if 
	 * clause below which says "modify this block to create your own color 
	 * scheme".  When someone runs the program and selects "Student Color 
	 * Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;
		
		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}
		
		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}
		
		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			
			
			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.YELLOW;  // take out and return something useful 
			
			
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	
}
