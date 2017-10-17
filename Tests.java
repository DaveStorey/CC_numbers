/*David Storey
 * das2p3
 * CS 2261 Project 1
 * September 15, 2017
 */

public class Tests {
	
	//Method to determine if the number has an appropriate number of digits.
	static int digits(long ccNumber){
		int count = 0;
		
		//Using an index variable to keep track of the iterations of the loop while taking a digit off each iteration.
		while (ccNumber > 0)
		{
			ccNumber = ccNumber / 10;
			count += 1;				
		}
		
		//If statement to reset the int variable if the digits are incorrect so it can be used as a flag in main.
		if (count <= 12 || count >= 17)
		{
			count = 0;
		}
		return count;
	}
	
	//Method to separate the digits of the number into an array.
	static int[] getArray(int count, long ccNumber){
		int[] ccArray = new int[count];
		int index = 0;
		
		//Separating the digits, with rightmost going into array position 0.
		while (ccNumber > 0)
		{
			ccArray[index] = (int)(ccNumber % 10);
			ccNumber = ccNumber / 10;
			index += 1;
		}
		return ccArray;
	}
	
	//Method to determine if the leading digit(s) are appropriate for one of the recognized brands.
	static boolean brands(int[] ccArray, int count){
		boolean validity = false;
		
		//Switch statement for the various possibilities, including an if statement to handle Amex.
		switch (ccArray[count - 1]){
			case 4: validity = true;
				break;
			case 5: validity = true;
				break;
			case 6: validity = true;
				break;
			case 3: if (ccArray[count - 2] == 7)
				validity = true;
				break;
		}
		return validity;
	}
	
	//Method to determine if the digits are arithmetically appropriate.
	static boolean validity(int[] ccArray, int count){
		boolean valid = false;
		int evens = 0, odds = 0, temp = 0;
		
		//Loop doubling and adding up the even digits of the number.
		for (int i=1; i<count; i+=2)
		{
			
			//If/else statement to handle digits that are over 10 when doubled.
			if (ccArray[i]*2 < 10)
				evens += ccArray[i]*2;
			else
			{
				temp = ((ccArray[i]*2) % 10);
				temp += (((ccArray[i]*2)/10) % 10);
				evens += temp;
			}
		}
		
		//Loop adding up the odd digits of the number.
		for (int i=0; i<count; i+=2)
			odds += ccArray[i];
		
		//Testing to see if the result is evenly divisible by 10.
		if (((evens + odds) % 10) == 0)
			valid = true;
		return valid;
	}

}
