package Test;
import Polynomial.Polynomial;
import java.io.*;

/**
 * This class will be used to test the Terms and Polynomial Classes.
 *
 */
public class Test {
	public static void main(String[] args){

		int count = 0;
		
		Polynomial polynomialObject = new Polynomial();
		
		String file_line = null, exponent_string = "", coefficient_string = "";
		
		int exponent = 0, coefficient = 0;
		
		File fileName = new File("data.txt");
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int length = bufferedReader.read();
			
			/**
			 * If file is empty, console log error. 
			 */
			
			if(length == -1){
				System.out.println("Error!! The file is empty");
			}
			
			else{
				while((file_line=bufferedReader.readLine())!=null){
					String[] spiltter=file_line.split(";");
					for(int i=1;i<spiltter.length;i++){
						if(i%2!=0){
							coefficient_string=spiltter[i];
							coefficient=Integer.parseInt(coefficient_string);
						}
						else{
							exponent_string=spiltter[i];
							exponent=Integer.parseInt(exponent_string);
							polynomialObject.Insert(coefficient,exponent);							
						}
					}
					
					System.out.println("P(" + count+")" + " : " + polynomialObject.return_polynomial());
					System.out.println("The product of the polynomial's term is: " + polynomialObject.Product());
					polynomialObject.Delete(7,1);
					System.out.println("After deleting (7,1) the Polynomial becomes: ");
					System.out.println("P(" + count+")" + " : " + polynomialObject.return_polynomial());
					System.out.println("After reversing the polynomail becomes: ");
					System.out.println("P(" + count+")" + " : " + polynomialObject.Reverse());
					System.out.println("The new product of the polynomial's term is: " + polynomialObject.Product() + "\n\n\n");
					count++;
				}
			}
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("File not found!");
		}
		catch(IOException ex){
			System.out.println("ERROR : "+ex);
		}
	}
}
