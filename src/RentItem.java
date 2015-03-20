import java.util.Scanner;

public class RentItem {

<<<<<<< HEAD
	private Scanner in = new Scanner(System.in);
	private String action;
	private String rentalType;
	
	public String [][]rental = new String[100][3]; //Multi dimensional array for rentals
		/*Column 1: Item Number
		 *Column 2: Rental type
		 *Column 3: Renter
=======
	private Scanner in = new Scanner(System.in); //For inputs with no white spaces
	private Scanner in2 = new Scanner(System.in); //FOr inputs with white spaces
	
	private String action;
	private String itemNumber;
	private String rentalType;
	private String renter;
	private String rentalDate;
	
	public String [][]rental = new String[100][4]; //Multi dimensional array for rentals
		/*Column 1: Item Number
		 *Column 2: Rental type
		 *Column 3: Renter
		 *Column 4: Rental Date
>>>>>>> origin/master
		 */
	
		public void showActions()
		{
<<<<<<< HEAD
=======
			
			addNewMember objAM = new addNewMember();
			
>>>>>>> origin/master
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
			
<<<<<<< HEAD
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
=======
			if (action.equals("0")) //If the user selects "Rent item"
			{
				setMembertoRental(0);
				setItemNumberToRental(0);
				setRentalType(0);
				setRentalDate(0);
				showRentalDetails();
				confirmRentalDetails();
			}
			
			if(action.equals("1")) //If the user selects Add new member
			{
				System.out.println("\t\t Add New Member");
				
				objAM.setName(0);
				objAM.setNICNumber(0);
				objAM.setTelephoneNumber(0);
				objAM.setMemberID(0);
				objAM.showMemberDetails();
				objAM.confirmNewMember();
				objAM.sortMemberList();
			}
		}
		
		private void setMembertoRental(int correction) //User selects the member who wants to borrow an item 
		{
			
			boolean tester = true;
			
			System.out.println("Member ID \t Name");
			
			for(int i = 0; i<addNewMember.newMemberArray.length; i++) //Displaying a list of members along with their ID
			{
				if(addNewMember.newMemberArray[i][3] == null)
				{
					break; //Break the loop if an empty space is found
				}
				
				System.out.println(addNewMember.newMemberArray[i][3] + "\t" + addNewMember.newMemberArray[i][0]);
			}
			
			do
			{
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
				
				for(int i = 0; i<addNewMember.newMemberArray.length; i++)
				{
					if(action.equals(addNewMember.newMemberArray[i][3]))
					{
						tester = false;
						
						for (int x = 0; x<rental.length; x++)
						{
							if(rental[x][2] == null)
							{
								rental[x - correction][2] = action;
								break;
							}
						}
					}
				}
			}while (tester);
		}

		private void setItemNumberToRental(int correction) //The item number of the item being rented is selected
>>>>>>> origin/master
		{
			boolean tester = true;
			
			//Displays a list of available items and asks to select the desired item
			System.out.println("Item Number \t Title");
			for (int i = 0; i < NewItem.itemArray.length; i++)
			{
<<<<<<< HEAD
=======
				if(NewItem.itemArray[i][3] == null)
				{
					break; //Break the loop when an empty space is found
				}
				
>>>>>>> origin/master
				System.out.println(NewItem.itemArray[i][3] + "\t" + NewItem.itemArray[i][1]);
			}
			
			do
			{
				System.out.println("Here is a list of the available items. Enter the Item number.");
<<<<<<< HEAD
				action = in.next();
				
				for(int i = 0; i < NewItem.itemArray.length; i++) //Go through the item number in itemArray
				{
					if (action.equals(NewItem.itemArray[i][3])) //If the entered item number is equal to the value in the item array
=======
				itemNumber = in.next();
				
				for(int i = 0; i < NewItem.itemArray.length; i++) //Go through the item number in itemArray
				{
					if (itemNumber.equals(NewItem.itemArray[i][3])) //If the entered item number is equal to the value in the item array
>>>>>>> origin/master
						{
							tester = false; //When an item number corresponding to the entered value is found, the tester value changes to false
						
							for (int x = 0; x<rental.length; x++) //Go through the rental MDA until an empty spot is found
							{
								if (rental[x][0] == null)
								{
<<<<<<< HEAD
									rental[x][0] = action;
=======
									rental[x - correction][0] = itemNumber;
>>>>>>> origin/master
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

<<<<<<< HEAD
		public void setRentalType()
=======
		private void setRentalType(int correction) //The rental type (weekly/ overnight) is selected
>>>>>>> origin/master
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
<<<<<<< HEAD
							rental[i][1] = "Weekly";
=======
							rental[i - correction][1] = "Weekly";
>>>>>>> origin/master
							break;
						}
						
						if(action.equals("1"))//If the user selects Overnight
						{
<<<<<<< HEAD
							rental[i][1] = "Overnight";
=======
							rental[i - correction][1] = "Overnight";
>>>>>>> origin/master
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

<<<<<<< HEAD
		public void setRentalDate() //Complete later
		{
			System.out.println("Enter rental date (DD MM YYYY): ");
			
		}
=======
		private void setRentalDate(int correction) //Date of rental is selected
		{
			boolean tester = false;
			
			do
			{
				tester = false; //When the loop starts, tester is initialized to false
				System.out.println("Enter rental date (DD MM YYYY): ");
				rentalDate = in2.nextLine();
				
				if (!(rentalDate.substring(2) == " " && rentalDate.substring(5) == " "))
				{
					System.err.println("Invalid input");
					tester = true; //If the spacing is not done properly, spacing gets reinitialized to true
				}
				
				//Exception handling when the user has entered an input which is not a numeric value
				try
				{
					Integer.parseInt(rentalDate.substring(0, 1));
					Integer.parseInt(rentalDate.substring(3, 4));
					Integer.parseInt(rentalDate.substring(6, 9));
				}catch (Exception e)
				{
					System.err.println("Invalid input");
					tester = true; // If numeric values are not used, tester gets reinitialized to true
				}
			}while (tester);
			
			
			for (int i = 0; i<rental.length; i++)
			{
				if(rental[i][3] == null)
				{
					rental[i - correction][3] = rentalDate;
				}
			}
		}

		private void showRentalDetails()
		{
			System.out.println("\t A rental has been made.");
			System.out.println(); //Add Space
			System.out.println("Item Number: " + itemNumber);
			System.out.println("Rental type: " + rentalType);
			System.out.println("Rented to: " + renter);
			System.out.println("Date of rental: " + rentalDate);
		}

		private void confirmRentalDetails()
		{
			do //Shows error message if user inputs a value that is not Y or N
			{
				System.out.print("Is the information shown above correct? (Y/N) ");
				action = in.next();
				
				if (!(action.equalsIgnoreCase("Y") || action.equalsIgnoreCase("N")))
				{
					System.err.println("Invalid input");
				}
			}while (!(action.equalsIgnoreCase("Y") || action.equalsIgnoreCase("N")));
			
			//If the user says that the entered values are incorrect
			if(action.equalsIgnoreCase("N"))
			{
				setMembertoRental(1);
				setItemNumberToRental(1);
				setRentalType(1);
				setRentalDate(1);
				showRentalDetails();
			}
		}

/*CORRECTION ARGUMENT EXPLAINED
 * In the addNewItemActions() method in the CD_Universe class, the given value for correction is 0
 * This is because when looping through the multi dimensional array in the required column and a free space is found (null), the new item must be added to that free space
 * In the confirmNewItem() method, the given argument for correction is 1
 * This is because the user has decided to edit the values of an item he has just created
 * In this case, the program loops through the specific column in the multi dimensional array, and finds an empty space (null).
 * The newly created item is just before that free space. As a result, the changes to be made is in the (i - 1)th row (since i is now an empty row
 */
>>>>>>> origin/master
}
