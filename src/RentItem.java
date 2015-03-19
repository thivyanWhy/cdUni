import java.util.Scanner;

public class RentItem {

	private Scanner in = new Scanner(System.in);
	private String action;
	private String rentalType;
	
	public String [][]rental = new String[100][3]; //Multi dimensional array for rentals
		/*Column 1: Item Number
		 *Column 2: Rental type
		 *Column 3: Renter
		 */
	
		public void showActions()
		{
			do
			{
				System.out.println("0 - Rent item"); //This selection asks the user to give the ID of the member who wants to rent out an item
				System.out.println("1 - Add new member"); //If member doesn't already exist in the database, then a new member should be selected
				System.out.println("Select action: ");
				action = in.next();
				
				if (!(action.equals("0") || action.equals("1")))
				{
					System.err.println("Invalid input");
				}
			}while (!(action.equals("0") || action.equals("1")));
			
			//MORE CODE TO BE ADDED
		}
		
		//If the user selects "Rent item"
		public void setMembertoRental() //User selects the member who wants to borrow an item
		{
			System.out.println("Member ID \t Name");
			
			/*
			 * loops through the member array (multi dimensional) and displays all the members
			 */
			
			//Asks the user to select the member who wants to borrow something
			System.out.println("Here is the list of members. Enter the member ID.");
			System.out.println("0 - Exit");
			action = in.next();
			
			//If the user wants to exit
			if (action.equals("0"))
			{
				showActions();
				return; //MAY CAUSE BUG
			}
			
			//If the user enters a member ID
				/*
				 * loops through member array and finds the member with the desired ID
				 * 
				 */
		}

		public void setItemNumberToRental()
		{
			boolean tester = true;
			
			//Displays a list of available items and asks to select the desired item
			System.out.println("Item Number \t Title");
			for (int i = 0; i < NewItem.itemArray.length; i++)
			{
				System.out.println(NewItem.itemArray[i][3] + "\t" + NewItem.itemArray[i][1]);
			}
			
			do
			{
				System.out.println("Here is a list of the available items. Enter the Item number.");
				action = in.next();
				
				for(int i = 0; i < NewItem.itemArray.length; i++) //Go through the item number in itemArray
				{
					if (action.equals(NewItem.itemArray[i][3])) //If the entered item number is equal to the value in the item array
						{
							tester = false; //When an item number corresponding to the entered value is found, the tester value changes to false
						
							for (int x = 0; x<rental.length; x++) //Go through the rental MDA until an empty spot is found
							{
								if (rental[x][0] == null)
								{
									rental[x][0] = action;
									break;
								}
							}
						}
				}
				
				if(tester)
				{
					System.err.println("Item number could not be found.");
				}
				
			}while(tester); //If an item number could not be found, tester will remain to be true			
		}

		public void setRentalType()
		{
			System.out.println("0 - Weekly");
			System.out.println("1 - Overnight");
			
			do
			{
				System.out.print("Select the rental type: ");
				action = in.next();
				
				for(int i = 0; i<rental.length; i++)
				{
					if(rental[i][1] == null)
					{
						
						if(action.equals("0")) //If the user selects Weekly
						{
							rental[i][1] = "Weekly";
							break;
						}
						
						if(action.equals("1"))//If the user selects Overnight
						{
							rental[i][1] = "Overnight";
							break;
						}
					}
				}
				
				if (!(action.equals("0") || action.equals("1")))
				{
					System.err.println("Invalid Input");
				}
			}while(!(action.equals("0") || action.equals("1")));
		}

		public void setRentalDate() //Complete later
		{
			System.out.println("Enter rental date (DD MM YYYY): ");
			
		}
}
