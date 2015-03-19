import java.util.Scanner;

public class CD_Universe 
{
	private static Scanner input = new Scanner (System.in);
	
	private static int action;
	
	private static void primaryScreen() //This method shows the initial screen with the main set of options (add new item, edit items, delete items, rent items, overdue items)
	{
		
		do
		{
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
			
			//Giving an error to the user if he enters an invalid input
			if (!(action == 0 || action == 1 || action == 2 || action == 3 || action == 4))
			{
				System.err.println("Invalid input");
			}
		}while (!(action == 0 || action == 1 || action == 2 || action == 3 || action == 4));
	}
	
	private static void addNewItemActions() //This method executes the set of actions when the user wants to add a new item
	{
		System.out.println("\t\t New Iem"); //Title
		NewItem obj = new NewItem(); //Creating an object for the newItem class
		
		String informationState = "O"; /*This string should either have the option Y or N
										*After the user has entered the details for the new item, the system prompts the user asking if the entered items are correct
										*If correct, the value should change to Y, incorrect; N
		 								*/
		
		while (!(informationState.equalsIgnoreCase("Y"))) //While loop A
		{
			obj.setItemType(); //Prompt user for details
			obj.setTitle(); //Prompt user to set the title for the new item
			obj.setArtist(); //Prompts the user to set the artist for the new item
			obj.setItemNumber(); //Prompts the user to set the item number
			obj.showNewItemDetails(); //Giving a summary of the new item to the user
			
			do
			{
				//This statement exists if the user enters anything other than Y or N
					//Giving the user the option to edit the item if the given information is incorrect
					System.out.print("Is this information correct? (Y/N) ");
					informationState = input.next();
						
					if(!((informationState.equalsIgnoreCase("Y") || informationState.equalsIgnoreCase("N"))))
					{
						System.err.println("Invalid input");
						/*Prints "Invalid input" if the user enters anything other than Y or N
						* Then the while loop B is carried out, asking the user if the information is correct
						* If N is entered, the while loop A is carried out
						*/
					}
			}	while (!((informationState.equalsIgnoreCase("Y") || (informationState.equalsIgnoreCase("N")))));//While loop B	
			
		}
	}
	
	
	public static void main(String[] args) 
	{
		primaryScreen();
		
		switch(action)
		{
			case 0:addNewItemActions();
				primaryScreen(); //After a new item is added, the system should go back to the primary screen, without exiting the program
				break;
		}
	}
		

}
