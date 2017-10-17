/*David Storey
 * das2p3
 * CS 2261 Project 1
 * September 15, 2017
 */

import java.util.Scanner;

class NumberCheck{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int count = 0;
		boolean again = true;
		
		//While loop based on variable which will respond to user input.
		while (again)
		{
			System.out.print("Please enter a CC number for checking or 0 to exit: ");
			long ccNumber = input.nextLong();
			
			//If/else statement to handle looping based on user input (see above while loop).
			if (ccNumber != 0)
			{
				count = Tests.digits(ccNumber);
				
				//While loop with count serving as a flag variable for having the appropriate number of digits.
				while (count == 0){
					System.out.print("Invalid number, please enter a number containing 13-15 digits.");
					ccNumber = input.nextLong();
					count = Tests.digits(ccNumber);
					}
				
				//Creating an array to handle separating the digits out of the number.
				int[] ccArray = new int[count];
				ccArray = Tests.getArray(count, ccNumber);
				
				//If/else statement with boolean method to test whether number is headed by appropriate digits.
				if (Tests.brands(ccArray, count))
				{
					
					//If/else statement with boolean method to test whether number is arithmetically appropriate.	
					if (Tests.validity(ccArray, count))
						System.out.println(ccNumber+ " is valid.");
					else
						System.out.println(ccNumber +" is invalid.");
				}
				else
					System.out.println(ccNumber + " is invalid. Does not correspond to known credit card brand.");
			}
			
			else
				again = false;
		}	
		input.close();
	}
}
