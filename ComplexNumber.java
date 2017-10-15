
public class ComplexNumber {
	
	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors
	
	
	/* STUDENTS: Put your methods here, as described in the project description.
	 * 	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */
	public ComplexNumber(MyDouble realIn, MyDouble imagIn) {
		/* constructor which will take in two MyDoubles and sets the value
		 * of the real and imag to the ones listed in the parameter
		 */
		real = realIn;
		imag = imagIn;
	}
	
	public ComplexNumber(MyDouble realIn) {
		/* constructor takes in a value of MyDouble and sets this value
		 * to the value of the real instance variable while the imag will
		 * always be set to 0
		 */
		real = realIn;
		imag = new MyDouble(0);
	}
	
	public ComplexNumber(ComplexNumber a) {
		// copy constructor setting the same values
		
		this(a.getReal(),a.getImag());
	}
	
	public MyDouble getReal() { //returns the private real value
		return real;
	}
	
	public MyDouble getImag() { //returns the private imag value
		return imag;
	}
	
	/*this method is used to add two complex numbers together, there is 
	 * already an add method instituted in the class which adds together
	 * MyDouble values, using that method the add method for the complex 
	 * number adds together two complex numbers*/
	public ComplexNumber add(ComplexNumber other) { 
		//takes in a parameter of a complex number 
		MyDouble a = new MyDouble(this.real.add(other.getReal()));
		/*the value of a set to the value obtained by adding the real value
		 *of the current object to the real value of the parameter */
		MyDouble b = new MyDouble(this.imag.add(other.getImag()));
		/*the value of b set to the value obtained by adding the imag value
		 *of the current object to the imag value of the parameter */
		ComplexNumber sum = new ComplexNumber(a,b);
		// a new complexNumber is created using the two calculated values
		return sum;
	}
	
	/*this method is used to subtract two complex numbers together, there is 
	 * already an subtract method instituted in the class which subtracts
	 *  the MyDouble values, using that method the subtract method for the 
	 *  complex number subtracts the two complex numbers*/
	public ComplexNumber subtract(ComplexNumber other) {
		MyDouble a = new MyDouble (this.real.subtract(other.getReal()));
		/*value of a set to the value obtained by subtracting the real value
		 *of the current object to the real value of the parameter */
		MyDouble b = new MyDouble (this.imag.subtract(other.getImag()));
		/*value of b set to the value obtained by subtracting the real value
		 *of the current object to the real value of the parameter */
		ComplexNumber difference = new ComplexNumber(a,b);
		return difference;
	}
	
	public ComplexNumber multiply(ComplexNumber other) {
		MyDouble first = new MyDouble(this.real.multiply(other.getReal()));
		/*value of first set to the value obtained by multiplying the real value
		 *of the current object to the real value of the parameter (FOIL)*/
		MyDouble outer = new MyDouble(this.real.multiply(other.getImag()));
		/*value of outer set to the value obtained by multiplying the real value
		 *of the current object to the imag value of the parameter (FOIL)*/
		MyDouble inner = new MyDouble(this.imag.multiply(other.getReal()));
		/*value of inner set to the value obtained by multiplying the imag value
		 *of the current object to the real value of the parameter (FOIL)*/
		MyDouble last = new MyDouble(this.imag.multiply
				(other.getImag()).multiply(new MyDouble(-1)));
		/*value of last set to the value obtained by multiplying the imag value
		 *of the current object to the imag value of the parameter which will
		 *result in an i^2 = -1 (FOIL)*/
		MyDouble sumReal = new MyDouble(first.add(last));
		//adds up the first and last term after the foil method
		MyDouble sumImag = new MyDouble(outer.add(inner));
		//adds up the two middle terms after the foil method
		ComplexNumber product = new ComplexNumber(sumReal,sumImag);
		return product;
	}
	
	public ComplexNumber divide(ComplexNumber other) {
		MyDouble realNum = new MyDouble(this.real.multiply
				(other.getReal()).add(this.imag.multiply(other.getImag())));
		/* this calculates the value of the real portion of the fraction
		 * resulting in the final real number numerator*/
		MyDouble commonDen = new MyDouble(other.getReal().multiply
				(other.getReal()).add(other.getImag().multiply
						(other.getImag())));
		/* this calculates the value of the common denominator*/
		MyDouble imagNum = new MyDouble(this.imag.multiply
				(other.getReal()).subtract(this.real.multiply(other.getImag())));
		/* this calculates the value of the imaginary portion of the 
		 * fraction which results in the final imaginary numerator */
		MyDouble lastReal = new MyDouble(realNum.divide(commonDen));
		// this simplifies the real number coefficient 
		MyDouble lastImag = new MyDouble(imagNum.divide(commonDen));
		// this simplifies the imaginary number coefficient
		ComplexNumber quotient = new ComplexNumber(lastReal,lastImag);
		return quotient;
	}
	
	public boolean equals(ComplexNumber other) {
		/*this method compares the values of two different complex numbers
		 * it takes in the real value of the current object and parameter
		 * and the imag value of the current object and the parameter. */
		return this.real.equals(other.getReal()) && this.imag.equals(other.getImag()); 
	}
	
	public int compareTo(ComplexNumber num) {
		if (ComplexNumber.norm(this).equals(ComplexNumber.norm(num))) {
			/* compares the values of the parameter to the values of the 
			 * current object to see if they are equal */
			return 0;
		
			/* compares the values of the parameter to the values of the 
			 * current object to see if the current object is less than the 
			 * parameter */
		} else if (ComplexNumber.norm(this).compareTo(ComplexNumber.norm(num)) < 0) {
			/* compares the values of the parameter to the values of the 
			 * current object to see if the current object is greater than the 
			 * parameter */
			return -1;
		} else {
			/* compares the values of the parameter to the values of the 
			 * current object to see if the current object is less than the 
			 * parameter */
			return 1;
		}
	}
	
	/* this toString method combines the complex number to make a single
	 * value. if the imag value is negative the toString method doesn't add
	 * the extra "+" sign, if the imag value is positive the toString method
	 * adds the "+" sign to compensate for the total. */
	public String toString() {
		MyDouble initial = new MyDouble(0);
		if (this.imag.compareTo(initial) < 0) {
			return this.real.toString() + this.imag.toString() + "i";
		} else {
			return this.real.toString() + "+" + this.imag.toString() + "i";
		}
		
	}
	
	public static MyDouble norm(ComplexNumber other) {
		/* This method return the squareroot of a^2 + b^2, it takes in 
		 * a parameter of ComplexNumber and returns the norm */
		MyDouble a = new MyDouble(other.getReal().multiply(other.getReal()));
		/*MyDouble is set to the value this is calculated when both the real
		 * values of the parameter are multiplied together */
		MyDouble b = new MyDouble(other.getImag().multiply(other.getImag()));
		/*MyDouble is set to the value this is calculated when both the imag
		 * values of the parameter are multiplied together */
		MyDouble norm = a.add(b).sqrt();
		/*The norm value is calculated to produce the squareroot, 
		 * the squareroot of the MyDoubles a and b are calculated */
		return norm;
	}
	
	/*this method takes one parameter (a String) and returns a ComplexNumber.
	 *The parameter is a String that represents a complex number, such as
	 *"5.9 + 73.44i" or "-2.35 - 6.5i". There could be any number of
	 *spaces in the beginning, at the end, before the 'i', and surrounding
	 *the '+' and '-' characters. The method will parse the String and return
	 * a ComplexNumber that represents the value described by the String.*/
	
	public static ComplexNumber parseComplexNumber(String input) {
		String complexNumber = input.replaceAll("\\s", "");
		int findI = complexNumber.indexOf("i");
		//this finds the i in the after the toString has been called
		double doubleReal;
		double doubleImag;
		boolean positive = complexNumber.contains("+");
		//this is to see if the complex number has a addition or subtraction
		//also related to the imag, to see if it is positive or negative
		if (positive == true) {
			//this section runs if the complex number contains a "+" sign
			int plusSign = complexNumber.indexOf("+");
			String realString = complexNumber.substring(0, plusSign);
			//takes the string  from the first position to the "+" sign
			String imagString = complexNumber.substring(plusSign, findI);
			//takes the string from the "+" sign to the last "i"
			doubleReal = Double.parseDouble(realString);
			doubleImag = Double.parseDouble(imagString);
			
		} else {
			//this section runs if the complex number contains a "-" sign
			int minusSign = complexNumber.lastIndexOf("-");
			String realString = complexNumber.substring(0, minusSign);
			//takes the string  from the first position to the "-" sign
			String imagString = complexNumber.substring(minusSign, findI);
			//takes the string from the "-" sign to the last "i"
			doubleReal = Double.parseDouble(realString);
			doubleImag = Double.parseDouble(imagString);
			
		}
		MyDouble real = new MyDouble(doubleReal);
		MyDouble imag = new MyDouble(doubleImag);
		ComplexNumber last = new ComplexNumber(real,imag);
		return last;
	}
	
	
}
