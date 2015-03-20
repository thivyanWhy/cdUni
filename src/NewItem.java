import java.util.Scanner;
import java.util.Arrays;

public class NewItem 
{	
	private Scanner input = new Scanner (System.in); //For single letter inputs
	private Scanner input2 = new Scanner (System.in); //For multiple word inputs
	
	private String itemType; // Item type identifier
	private String title; //Title of the new item
	private String artist; //Artist of the new item
	private String itemNumber; // Number for the new item - This is a string because characters can be present in the number as well
	
	public static String [][] itemArray = new String [100][4]; //Storing the item type.
		 /*Column 1: Item type
		 * Column 2: Title
		 * Column 3: Artist
		 * Column 4: Item number
		 */
	
	//Sorry for the lack of comments.
	public void setItemType(int correction) //This method prompts the user with what to input (Music video, Album, Podcast)
	{
		do //Course of action if the user enters an anvalid input
		{
			//Giving the user an option to enter an item type
			System.out.println("\tItem type: ");
			System.out.println("\t\t A - Music Video");
			System.out.println("\t\t B - Album");
			System.out.println("\t\t C - Podcast");
			System.out.print("Select Item Type: ");
			
			itemType = input.next();// User enters either A, B or C
			
			if (!(itemType.equalsIgnoreCase("A") || itemType.equalsIgnoreCase("B") || itemType.equalsIgnoreCase("C")))
			{
				System.err.println("Invalid input");
			}
		}while (!(itemType.equalsIgnoreCase("A") || itemType.equalsIgnoreCase("B") || itemType.equalsIgnoreCase("C")));
		
		//When the user enters a correct input
		if(itemType.equalsIgnoreCase("A"))
		{	
			for (int i = 0; i < itemArray.length; i++ )
			{
				
				if (itemArray[i][0] == null)
				{
					itemArray[i - correction][0] = "Music Video";
					break;
				}
				
				
			}
		}else if (itemType.equalsIgnoreCase("B"))
		{
			for (int i = 0; i < itemArray.length; i++ )
			{
				
				if (itemArray[i][0] == null)
				{
					itemArray[i - correction][0] = "Album";
					break;
				}
			}
			
		}else if (itemType.equalsIgnoreCase("C"))
		{
			for (int i = 0; i < itemArray.length; i++ )
			{
				
				if (itemArray[i][0] == null)
				{
					itemArray[i - correction][0] = "Podcast";
					break;
				}
			}
		}
	}

	public void setTitle(int correction) //Prompts the user for the title
	{
		System.out.print("Title: "); //User inputs the title of the new item
		title = input2.nextLine();
		for (int i = 0; i < itemArray.length; i++ )
		{
			
			if (itemArray[i][1] == null)
			{
				itemArray[i - correction][1] = title;
				break;
			}
		}
	}
	
	public void setArtist(int correction) //Prompts the user to set the name of the artist 
	{
		System.out.print("Artist: ");
		artist = input2.nextLine();
		for (int i = 0; i < itemArray.length; i++ )
		{
			
			if (itemArray[i][2] == null)
			{
				itemArray[i - correction][2] = artist;
				break;
			}
		}
	}

	public void setItemNumber(int correction) //Prompts the user to set an item number to identify it
	{
		System.out.print("Item number: ");
		itemNumber = input.next();
		for (int i = 0; i < itemArray.length; i++ )
		{
			
			if (itemArray[i][3] == null)
			{
				itemArray[i - correction][3] = itemNumber;
				break;
			}
		}
	}

	public void showNewItemDetails() //Giving the summary of the new item after it has been created
	{
		//Telling the user that a new item has been created and showing item details
		System.out.println(); //Add space
		System.out.println("New item has been created");
		System.out.print("\t Item type: ");
		//Showing the item type
			if (itemType.equalsIgnoreCase("A"))
			{
				System.out.println("Music Video");
			}else if (itemType.equalsIgnoreCase("B"))
			{
				System.out.println("Album");
			}else if (itemType.equalsIgnoreCase("C"))
			{
				System.out.println("Podcast");
			}
			System.out.println("\t Title: " + title);
			System.out.println("\t Artist: " + artist);
			System.out.println("\t itemNumber: " + itemNumber);
	}

	public void confirmNewItem() //Asks the user if the vales entered is correct and then gives him the option to change it
	{
		String informationState = "O"; //This string changes to Y or N depends on whether the given displayed information is correct. It is initialized to "O" at the start
		
		do //Course of action if the user enters an invalid value
		{
			System.out.print("Is this information correct? (Y/N) ");
			informationState = input.next(); /*This string should either have the option Y or N
			 									*After the user has entered the details for the new item, the system prompts the user asking if the entered items are correct
			 									*If correct, the value should change to Y, incorrect; N*/
			
			if (!(informationState.equalsIgnoreCase("N") || informationState.equalsIgnoreCase("Y")))
			{
				System.err.println("Invalid input");
			}
		}while(!(informationState.equalsIgnoreCase("N") || informationState.equalsIgnoreCase("Y")));
		
		//If the shown information is incorrect
		if (informationState.equalsIgnoreCase("N"))
		{
			setItemType(1);
			setTitle(1);
			setArtist(1);
			setItemNumber(1);
			showNewItemDetails();
			sortItemList();
		}
	}

	public void sortItemList() //After the item is created, it is sorted in alphabetical order
	{
		String []titles = new String[100];
		String [][] itemArraySORTED = new String [100][4];
		
		//Goes through all the titles in the "itemArray" multi dimensional array and assign them to their respective values in the "titles" array
		for (int i = 0; i<itemArray.length; i++)
		{
			titles[i] = itemArray[i][1];
		}
		
		Arrays.sort(titles); //Sorts the "titles" array in alphabetical order
		
		for (int i = 0; i<titles.length; i++) //loop A
		{
			for (int x = 0; x<itemArray.length; x++) //loop B
			{
				if(titles[i].equals(itemArray[x][1])) //loop C
				{
					for(int y = 0; y < 4; y++)
					{
						itemArraySORTED[i][y] = itemArray[x][y];
					}
				}
			}
		}
		
		/*EXPLAINATION FOR THE CODE ABOVE
		 *The "titles" array is sorted in alphabetical order
		 *in loop B, it goes through each value of the "titles" array (through loop A) and checks if it is equal to some value in the title column of "itemArray"
		 *When it does become equal, all of the values in that row is assigned to the values in "itemArraySORTED" array in loop C
		 */
		for (int i = 0; i<itemArraySORTED.length; i++) //Now the MDA "itemArray" is in alphabetical order
		{
			for (int x = 0; x < 4; x++)
			{
				itemArray[i][x] = itemArraySORTED[i][x];
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
