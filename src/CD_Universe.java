import java.util.Scanner;

public class CD_Universe 
{
	private static Scanner input = new Scanner (System.in);
	
	private static int action;
	
	private static void primaryScreen() //Method shows the initial screen with the main set of options (add new item, edit items, delete items, rent items, overdue items)
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
			System.out.println("\t 5 - Add New Member");
			
			System.out.print("Enter the required number to perform an action: "); // This is going to prompt the user to enter a number
			action = input.nextInt();
			System.out.println(); //Add line
			
			//Giving an error to the user if he enters an invalid input
			if (!(action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 5))
			{
				System.err.println("Invalid input");
			}
		}while (!(action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 5));
	}
	
	private static void addNewItemActions() //This method executes the set of actions when the user wants to add a new item
	{
		System.out.println("\t\t New Iem"); //Title
		NewItem obj = new NewItem(); //Creating an object for the newItem class

			obj.setItemType(0); //Prompt user for details
			obj.setTitle(0); //Prompt user to set the title for the new item
			obj.setArtist(0); //Prompts the user to set the artist for the new item
			obj.setItemNumber(0); //Prompts the user to set the item number
			obj.showNewItemDetails(); //Giving a summary of the new item to the user
			obj.confirmNewItem(); //Asks the user if he has entered the correct values and gives the option to edit them
			obj.sortItemList();//Sorts the values in the multi dimensional array
	}
	
	private static void addNewMemberActions(){
			System.out.println("\t\t Add New Member");
			addNewMember objM = new addNewMember();
			
			objM.setName(0);
			objM.setNICNumber(0);
			objM.setTelephoneNumber(0);
			objM.setMemberID(0);
			objM.showMemberDetails();
			objM.confirmNewMember();
			objM.sortMemberList();
		
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
