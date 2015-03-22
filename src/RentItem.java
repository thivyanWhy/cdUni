import java.util.Calendar;//hello
import java.util.Date;
import java.util.Scanner;

public class RentItem {

	private Scanner in = new Scanner(System.in); //For inputs with no white spaces
	private Scanner in2 = new Scanner(System.in); //For inputs with white spaces
	
	private String action;
	private String itemNumber;
	private String rentalType;
	private String renter;
	private String rentalDate; //(DD MM YYYY)
	private String timeBorrowed;
	
	private boolean cont; //This is used if there are no members or items so that the user does not get stuck
	
	public static String [][]rental = new String[100][5]; //Multi dimensional array for rentals
		/*Column 1: Item Number
		 *Column 2: Rental type
		 *Column 3: Renter
		 *Column 4: Rental Date
		 *Column 5: Borrowed time (days)
		 */
	
		public void showActions()
		{
			
			addNewMember objAM = new addNewMember();
			
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
			
			if (action.equals("0")) //If the user selects "Rent item"
			{
				setMembertoRental(0);
				setItemNumberToRental(0);
				
				if(cont)
				{
					setRentalType(0);
					setRentalDate(0);
					showRentalDetails();
					confirmRentalDetails();
					setTimeBorrowed();
				}
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
			}
		}
		
		private void setMembertoRental(int correction) //User selects the member who wants to borrow an item 
		{
			
			boolean tester = true;
			int count1 = 0;
			
			System.out.println("Member ID \t Name");
			
			for(int i = 0; i<addNewMember.newMemberArray.length; i++) //Displaying a list of members along with their ID
			{
				if(!(addNewMember.newMemberArray[i][3] == null))
				{
					System.out.println(addNewMember.newMemberArray[i][3] + "\t\t" + addNewMember.newMemberArray[i][0]);
					count1++;
				}
				
			}
			
			if(count1 == 0)
			{
				System.err.println("There are no members.");
				cont = false;
			}else
			{
				cont = true;
				
				do
				{	
					//Asks the user to select the member who wants to borrow something
					System.out.print("Here is the list of members. Enter the member ID. ");
					action = in.next();
				
					for(int i = 0; i<addNewMember.newMemberArray.length; i++)
					{
						if(action.equals(addNewMember.newMemberArray[i][3]))
						{
							tester = false;
							
							renter = addNewMember.newMemberArray[i][0]; //renter variable gets assigned the value which is the name of the member who has rented it
							
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
					if(tester)
					{
					System.err.println("Member could not be found");
					}
				}while (tester);
			}
		}

		private void setItemNumberToRental(int correction) //The item number of the item being rented is selected
		{
			boolean tester = true;
			int count = 0;
			
			//Displays a list of available items and asks to select the desired item
			System.out.println("Item Number \t Title");
			for (int i = 0; i < NewItem.itemArray.length; i++)
			{
				if(!(NewItem.itemArray[i][3] == null))
				{
					System.out.println(NewItem.itemArray[i][3] + "\t" + NewItem.itemArray[i][1]);
					count++;
				}
			}
			
			if(count == 0)
			{
				System.err.println("There are no items available");
				cont = false;
			}else
			{
				cont = true; 
				
				do
				{
					System.out.print("Here is a list of the available items. Enter the Item number. ");
					itemNumber = in.next();
				
					for(int i = 0; i < NewItem.itemArray.length; i++) //Go through the item number in itemArray
					{
						if (itemNumber.equals(NewItem.itemArray[i][3])) //If the entered item number is equal to the value in the item array
							{
								tester = false; //When an item number corresponding to the entered value is found, the tester value changes to false
						
								for (int x = 0; x<rental.length; x++) //Go through the rental MDA until an empty spot is found
								{
									if (rental[x][0] == null)
									{
										rental[x - correction][0] = itemNumber;
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
		}

		
		private void setRentalType(int correction) //The rental type (weekly/ overnight) is selected
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
							rentalType = "Weekly";
							rental[i - correction][1] = rentalType;
							break;
						}
						
						if(action.equals("1"))//If the user selects Overnight
						{
							rentalType = "Overnight";
							rental[i - correction][1] = rentalType;
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

		
		private void setRentalDate(int correction) //Date of rental is selected
		{
			boolean tester = false;
			
			do
			{
				tester = false; //When the loop starts, tester is initialized to false
				System.out.println("Enter rental date (DD MM YYYY): ");
				rentalDate = in2.nextLine() + " ";
				
				if (!(rentalDate.substring(2,3).equals(" ") && rentalDate.substring(5,6).equals(" ")))
				{
					System.err.println("Invalid input");
					tester = true; //If the spacing is not done properly, spacing gets reinitialized to true
				}
				
				//Exception handling when the user has entered an input which is not a numeric value
				try
				{
					Integer.parseInt(rentalDate.substring(0, 2));
					Integer.parseInt(rentalDate.substring(3, 5));
					Integer.parseInt(rentalDate.substring(6, 10));
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

		
		public void setTimeBorrowed() //Calculates the amount of time taken since the item has been borrowed
		{
			boolean tester = true;
			boolean tester2 = true;
			boolean mainTester = true;
			
			int day = 0, month = 0, year = 0;
			int borrowedDay = 0, borrowedMonth = 0, borrowedYear = 0;
			
			do //Entering today's date
			{
				System.out.print("Enter today's date (DD MM YYYY) ");
				String rentalDate = in2.nextLine() + " ";
				
				try
				{
				day = Integer.parseInt(rentalDate.substring(0, 2));
				month = Integer.parseInt(rentalDate.substring(4, 5));
				year = Integer.parseInt(rentalDate.substring(6, 10));
				
				tester = false;
				}catch(Exception e)
				{
					System.err.println("Invalid input");
				}
			}while(tester);
			
			//Getting the values of the borrowed date. No exception handling needed as it has been done when the rented date is entered
			borrowedDay = Integer.parseInt(rentalDate.substring(0, 2));
			borrowedMonth = Integer.parseInt(rentalDate.substring(4, 5));
			borrowedYear = Integer.parseInt(rentalDate.substring(6, 10));
			
			//Calculating the total number of days rented
			int todayInDays = (day) + (month*30) + (year*365);
			int borrowedDaysInDays = (borrowedDay) + (borrowedMonth*30) + (borrowedYear*365);
			int daysRented = todayInDays - borrowedDaysInDays;
			
			String daysRentedS = Integer.toString(daysRented);
			
			for (int i = 0; i<rental.length; i++)
			{
				if(rental[i][4] == null)
				{
					rental[i][4] = daysRentedS;
				}
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
}
