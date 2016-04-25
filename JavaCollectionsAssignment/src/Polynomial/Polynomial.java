package Polynomial;
import Terms.Terms;

import java.util.*;
/**
 * This class will have 5 member functions.
 * 1) Constructor: Initializes the class with the termsList.
 * 2) Insert: Inserts the exponents and the coefficients.
 * 3) return_polynomial: Returns the polynomial in ascending order.
 * 4) Delete: Removes the term with passed coefficients and exponents.
 * 5) Reverse: Reverses the polynomial.
 * 6) Product: Computes the product of all the terms.
 *
 */

public class Polynomial {
	
	
	private ArrayList<Terms> terms;
	
	Terms termObject;
	
	
	/**
	 * Constructor: Initializes a Polynomial Object with an empty termsList.
	 */
	public Polynomial(){
		 terms = new ArrayList<Terms>();
	}
	
	
	/**
	 * PreCondition: Exponents and coefficients are passed in as arguments.
	 * PostCondition: Values are inserted to the polynomial in ascending order.
	 * @param x
	 * @param y
	 */
	public void Insert(int x, int y){

		termObject = new Terms(x, y);
		
		if(terms.size() == 0){
			terms.add(termObject);
		}
		else{
			for(int i = 0; i < terms.size(); i++){
				Terms term = terms.get(i);
				int current_exponent = term.get_exponent();
				int current_coefficient = term.get_coefficient();
				if((y >= current_exponent) && (x > current_coefficient)){
					terms.add(i,termObject);
					return;
				}
			}
			terms.add(termObject);
		}
	}
	
	
	/**
	 * Returns the polynomial in ascending order.
	 */
	
	public String return_polynomial(){
		boolean is_first_item = true;
		String polynomial="";
		for(Terms iter: terms){
			if(is_first_item){
				polynomial+=iter.toString();
			}
			else if(iter.get_coefficient()<0){
				polynomial+=iter.toString();
			}
			else{
				polynomial+=" + "+iter.toString();
			}
			is_first_item = false;
			}
			return polynomial;
	}
	
	
	/**
	 * PreCondition: The exponents and coefficients are passed in as arguments.
	 * PostCondition: The values with the exponent and coefficient is deleted from the Polynomial.
	 * @param x
	 * @param y
	 */
	
	public void Delete(int x,int y){
		for(Terms iter : terms){
			if((iter.get_coefficient()==x)&&(iter.get_exponent()==y)){
				terms.remove(iter);
				System.out.println("The values are deleted. Coefficient : "+x + ". Exponent : "+y);
				return;
			}
		}
	}
	
	
	/**
	 * Returns the product of the terms of the polynomial.
	 */
	public String Product(){
		String product="";
		int coefficient=1,exponents=0;
		for(Terms iter : terms){
			int iter_coefficient=iter.get_coefficient();
			int iter_exponents=iter.get_exponent();
			exponents+=iter_exponents;
			coefficient*=iter_coefficient;
		}
		if(exponents==0){
			product+=Integer.toString(coefficient);
		}
		else if(coefficient==1){
			product+="x^"+Integer.toString(exponents);
		}
		else if(coefficient==0) {
			product = "0";
		}
		else{
			product+=coefficient+"x^"+exponents;
		}
		return product;	
	}
	
	
	/**
	 * Reverses the polynomial.
	 */
	public StringBuffer Reverse(){
		int temp_count=0;
		String temp="";
		StringBuffer reverse_string = new StringBuffer("");
		for(Terms iter : terms){
			if(temp_count==terms.size()-1){
				temp+=iter.toString();
			}
			else if(iter.get_coefficient()<0){
				temp+=iter.toString();
			}
			else{
				temp+=" + "+iter.toString();
			}
			
			reverse_string.insert(0, temp);
			temp="";
			temp_count++;
		}
		return reverse_string;
	}	
}

