import java.util.Scanner;

public class CD_Universe 
{
	
	public static void main(String[] args) 
	{
		int action; //The action number
		Scanner input = new Scanner(System.in);//Scanner named "input"
		
		System.out.println("\t\t CD Universe"); //Title
		System.out.println(); //Add space
		
		//Printing out the actions and their numbers
		System.out.println("\t 0 - Add New Item");
		System.out.println("\t 1 - Edit Item Details");
		System.out.println("\t 2 - Delete Item");
		System.out.println("\t 3 - Rent Item");
		System.out.println("\t 4 - Overdue Items");
		
		System.out.print("Enter the required number to perform an action: "); // This is going to prompt the user to enter a number
		action = input.nextInt();
		System.out.println(); //Add line
		
		//Giving an error message to an invalid input and making the user try again
		while (!(action == 0 || action == 1 || action == 2 || action == 3 || action == 4)){ 
			System.err.println("Invalid input"); //Telling the user that this is an invalid input
			
			//Telling the user to enter a valid input
			System.out.println("\t 0 - Add New Item");
			System.out.println("\t 1 - Edit Item Details");
			System.out.println("\t 2 - Delete Item");
			System.out.println("\t 3 - Rent Item");
			System.out.println("\t 4 - Overdue Items");
			
			System.out.print("Enter the required number to perform an action: "); // This is going to prompt the user to enter a number
			action = input.nextInt();
		}
	}

}
