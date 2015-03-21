import java.util.Scanner;//hellol

public class CD_Universe 
{
	private static Scanner input = new Scanner (System.in);
	
	private static String action;
	private static int actionINT = 9;
	
	private static void primaryScreen() //Method shows the initial screen with the main set of options (add new item, edit items, delete items, rent items, overdue items)
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
			
		boolean tester = true;
		
		do
		{	
			System.out.print("Enter the required number to perform an action: "); // This is going to prompt the user to enter a number
			action = input.next();
			System.out.println(); //Add line
			
			try //Showing an error is the user enters a non numeric value
			{
				actionINT = Integer.parseInt(action);
				tester = false;
			}catch (Exception e)
			{
				System.err.println("Invalid input");
			}
			
			//Giving an error to the user if he enters an invalid input
			if (!(actionINT == 0 || actionINT == 1 || actionINT == 2 || actionINT == 3 || actionINT == 4 || actionINT == 5))
			{
				System.err.println("Invalid input");
			}else
			{
				tester = false;
			}
		}while(tester);
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
	
	private static void addNewMemberActions() //Set of actions to be undertaken when adding a new member
{
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

	private static void deleteItemActions() //Set of actions when deleting an item
	{
		DeleteItem objD = new DeleteItem();
		
		objD.getItemList();
		objD.deleteItem("deleted");
		
		System.out.println("Item deleted");
		
		//Sort the item list such that there will be no empty spaces between objects
		NewItem objN = new NewItem();
		objN.sortItemList();
	}

	private static void editItemDetailsActions() //Set of actions to be undertaken when editing an item
	{
		EditItemDetails objE = new EditItemDetails();
		objE.getItemList();
		objE.editItem();
	}
	
	private static void rentItemActions() //Set of actions when an item is to be rented
	{
		RentItem objR = new RentItem();
		
		objR.showActions();
	}
	
	private static void overdueItemsActions()
	{
		OverdueItems objO = new OverdueItems();
		objO.displayingOverdueItems();
	}
	
	public static void main(String[] args) 
	{
		do
		{
			primaryScreen();
			
			switch(actionINT)
			{
				case 0: addNewItemActions();	break; //When the user wants to add a new item
				case 1: editItemDetailsActions();	break; //When the user wants to edit a new item
				case 2: deleteItemActions();	break; //When the user wants to delete an item
				case 3: rentItemActions();	break; //When renting an item
				case 4: overdueItemsActions(); break; //When looking for a list of overdue items
				case 5: addNewMemberActions();	break; //When the user wants to add a new member
			}
		}while(true); //Creates an infinite loop such that the program displays the primary screen every time an action is completed
	}
		

}
