
package Terms;

/**
 * This is the class term that has the following functions
 * 1) Constructor: Sets the private member variables of the class.
 * 2) get_coefficient: Returns the value of coefficient.
 * 3) get_exponent: Returns the value of the exponent.
 * 4) toString: Returns the formatted string of the Term.
 *
 */

public class Terms {
	private int exponent,coefficient;
	
	
	/**
	 * Constructor Initializes the private member variables of the Term class.
	 * Pre-condition: Validated input arguments are passed to the constructor.
	 * Postcondition: Passed values are assigned to the private member variables.
	 * @param exponent
	 * @param coefficient
	 */
	public Terms(int coefficient,int exponent) {
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	
	
	/**
	 * Pre-condition: An int value for the coefficient exists.
	 * Postcondition:  Returns the value of coefficient
	 * @return
	 */
	public int get_coefficient() {
		return this.coefficient;
	}
	
	
	/**
	 * Pre-condition: There is an int value for the exponent
	 * Postcondition:  Returns the value of exponent
	 * @return
	 */	
	public int get_exponent() {
		return this.exponent;
	}
	
	
	/**
	 * Pre-condition: There is an int value for both coefficient and exponent.
	 * Postcondition: The string is formatted and returned.
	 * @return
	 */
	public String toString(){
		String formatted_string;
		if(this.exponent == 0){
			formatted_string = Integer.toString(this.coefficient);
		}
		else if(this.exponent == 1){
			formatted_string = Integer.toString(this.coefficient)+"x";
		}
		else{
			formatted_string = Integer.toString(this.coefficient) + "x^" + Integer.toString(this.exponent);
		}
		return formatted_string;	
	}
	
	
}