import java.util.Scanner;//hellol

public class CD_Universe 
{ 
	private static Scanner input2 = new Scanner (System.in); 
	
	private static String action;
	private static int actionINT = 9;
	private static String newWindow = "\n------------------------------------------------------------------------\n"; //Making a small window such that the user can read what's actually in that window
	
	private static void primaryScreen() //Method shows the initial screen with the main set of options (add new item, edit items, delete items, rent items, overdue items)
	{
			System.out.println(newWindow);
		
			System.out.println("\t\t CD Universe"); //Title
			System.out.println(); //Add space
			
			//Printing out the actions and their numbers
			System.out.println("\t 0 - Add New Item");
			System.out.println("\t 1 - Edit Item Details");
			System.out.println("\t 2 - Delete Item");
			System.out.println("\t 3 - Rent Item");
			System.out.println("\t 4 - Overdue Items");
			System.out.println("\t 5 - Add New Member");
			System.out.println("\t 10 - Exit");
			
		boolean tester = true;
		
		do
		{	
			System.out.print("Enter the required number to perform an action: "); // This is going to prompt the user to enter a number
			action = input2.next();
			System.out.println(); //Add line
			
			try //Showing an error is the user enters a non numeric value
			{
				actionINT = Integer.parseInt(action);
				tester = false;
				
				//Giving an error to the user if he enters an invalid input
				if (!(actionINT == 0 || actionINT == 1 || actionINT == 2 || actionINT == 3 || actionINT == 4 || actionINT == 5 || actionINT == 10))
				{
					System.err.println("Invalid input");
					tester = true;
				}else
				{
					tester = false;
				}
			}catch (Exception e)
			{
				System.err.println("Invalid input");
				tester = true;
			}
		}while(tester);
		System.out.println(newWindow);
	}
	
	private static void addNewItemActions() //This method executes the set of actions when the user wants to add a new item
	{
		System.out.println(newWindow);
		
		System.out.println("\t\t New Item"); //Title
		NewItem obj = new NewItem(); //Creating an object for the newItem class

		do//Gives the user the option to go back
		{
			System.out.println("0 - Back");
			System.out.println("1 - Continue to make new item");
			
			action = input2.next();
			
			if(action.equals("0")){ //Going back to the main screen when the user wants to go back
				primaryScreen();
			}else if(action.equalsIgnoreCase("1"))
			{
				obj.setItemType(0); //Prompt user for details
				obj.setTitle(0); //Prompt user to set the title for the new item
				obj.setArtist(0); //Prompts the user to set the artist for the new item
				obj.setItemNumber(0); //Prompts the user to set the item number
				obj.showNewItemDetails(); //Giving a summary of the new item to the user
				obj.confirmNewItem(); //Asks the user if he has entered the correct values and gives the option to edit them
				obj.sortItemList();//Sorts the values in the multi dimensional arr
			}else
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equals("0") || action.equals("1")));
		
		System.out.println(newWindow);
	}
	
	private static void addNewMemberActions() //Set of actions to be undertaken when adding a new member
	{
			System.out.println(newWindow);
		
			System.out.println("\t\t Add New Member");
			addNewMember objM = new addNewMember();
			
			do//Gives the user the option to go back
			{
				System.out.println("0 - Back");
				System.out.println("1 - Continue to add new member");
				
				action = input2.next();
				
				if(action.equals("0")){ //Going back to the main screen when the user wants to go back
					primaryScreen();
				}else if(action.equalsIgnoreCase("1"))
				{
					objM.setName(0);
					objM.setNICNumber(0);
					objM.setTelephoneNumber(0);
					objM.setMemberID(0);
					objM.showMemberDetails();
					objM.confirmNewMember();
				}else
				{
					System.err.println("Invalid input");
				}
			}while (!(action.equals("0") || action.equals("1")));
		
			System.out.println(newWindow);
	}

	private static void deleteItemActions() //Set of actions when deleting an item
	{
		System.out.println(newWindow);
		
		System.out.println("\t\t Delete Item");
		
		do//Gives the user the option to go back
		{
			System.out.println("0 - Back");
			System.out.println("1 - Continue to Delete item");
			
			action = input2.next();
			
			if(action.equals("0")){ //Going back to the main screen when the user wants to go back
				primaryScreen();
			}else if(action.equalsIgnoreCase("1"))
			{
				DeleteItem objD = new DeleteItem();
				
				objD.getItemList();
				objD.deleteItem("deleted");
				
				System.out.println("Item deleted");
				
				//Sort the item list such that there will be no empty spaces between objects
				NewItem objN = new NewItem();
				objN.sortItemList();
			}else
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equals("0") || action.equals("1")));
		
		System.out.println(newWindow);
	}

	private static void editItemDetailsActions() //Set of actions to be undertaken when editing an item
	{
		System.out.println(newWindow);
		
		System.out.println("\t\t Edit Item");
		
		do//Gives the user the option to go back
		{
			System.out.println("0 - Back");
			System.out.println("1 - Continue to make edit item");
			
			action = input2.next();
			
			if(action.equals("0")){ //Going back to the main screen when the user wants to go back
				primaryScreen();
			}else if(action.equalsIgnoreCase("1"))
			{
				EditItemDetails objE = new EditItemDetails();
				objE.getItemList();
				objE.editItem();
			}else
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equals("0") || action.equals("1")));
				
		System.out.println(newWindow);
	}
	
	private static void rentItemActions() //Set of actions when an item is to be rented
	{
		System.out.println(newWindow);
		
		System.out.println("\t\t Rent Item");
		
		do//Gives the user the option to go back
		{
			System.out.println("0 - Back");
			System.out.println("1 - Continue to make rent item");
			
			action = input2.next();
			
			if(action.equals("0")){ //Going back to the main screen when the user wants to go back
				primaryScreen();
			}else if(action.equalsIgnoreCase("1"))
			{
				RentItem objR = new RentItem();
				objR.showActions();
			}else
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equals("0") || action.equals("1")));
		
		System.out.println(newWindow);
	}
	
	private static void overdueItemsActions()
	{
		System.out.println(newWindow);
		
		System.out.println("\t\t Overdue Items");
		
		do//Gives the user the option to go back
		{
			System.out.println("0 - Back");
			System.out.println("1 - Continue to make Overdue Items");
			
			action = input2.next();
			
			if(action.equals("0")){ //Going back to the main screen when the user wants to go back
				primaryScreen();
			}else if(action.equalsIgnoreCase("1"))
			{
				OverdueItems objO = new OverdueItems();
				objO.displayingOverdueItems();
			}else
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equals("0") || action.equals("1")));
		
		System.out.println(newWindow);
	}
	
	public static void exitActions() //Set of actions when exiting the program is needed
	{
		do
		{
			System.out.println("Are you sure you want to exit the program? Doing so will lose all the stored data.");
			System.out.println("Y - Yes");
			System.out.println("N- No");
			
			action = input2.next();
			
			if(action.equalsIgnoreCase("Y"))
			{
				System.exit(0);
			}else if(action.equalsIgnoreCase("N"))
			{
				System.out.println("Exit terminated.");
			}
		}while(!(action.equalsIgnoreCase("Y") || action.equalsIgnoreCase("N")));
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
				case 10: exitActions(); break; //Terminating the program
			}
		}while(true); //Creates an infinite loop such that the program displays the primary screen every time an action is completed
	}
		

}
