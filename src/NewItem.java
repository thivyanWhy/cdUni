import java.util.Scanner;

public class NewItem 
{	
	private Scanner input = new Scanner (System.in); //For single letter inputs
	private Scanner input2 = new Scanner (System.in); //For multiple word inputs
	
	private String itemType; // Item type identifier
	private String title; //Title of the new item
	private String artist; //Artist of the new item
	private String itemNumber; // Number for the new item - This is a string because characters can be present in the number as well
	
	public void setItemType() //This method prompts the user with what to input (Music video, Album, Podcast)
	{
		//Giving the user an option to enter an item type
		System.out.println("\tItem type: ");
		System.out.println("\t\t A - Music Video");
		System.out.println("\t\t B - Album");
		System.out.println("\t\t C - Podcast");
		System.out.print("Select Item Type: ");
		
		itemType = input.next();// User enters either A, B or C
		
		//Course of action if the user enters an invalid input
		while (!(itemType.equalsIgnoreCase("A") || itemType.equalsIgnoreCase("B") || itemType.equalsIgnoreCase("C")))
		{
			System.err.println("Invalid input");
			System.out.println(); //Add space
			
			System.out.println("\tItem type: ");
			System.out.println("\t\t A - Music Video");
			System.out.println("\t\t B - Album");
			System.out.println("\t\t C - Podcast");
			System.out.print("Select Item Type: ");
			
			itemType = input.next();// User enters either A, B or C
		}
	
		
		//When the user enters a correct input
		if(itemType.equalsIgnoreCase("A"))
		{
			/*
			 * Enter code with arrays here
			 */
		}else if (itemType.equalsIgnoreCase("B"))
		{
			/*
			 * Enter code with arrays here
			 */
		}else if (itemType.equalsIgnoreCase("C"))
		{
			/*
			 * Enter code with arrays here
			 */
		}
	}

	public void setTitle() //Prompts the user for the title
	{
		System.out.print("Title: "); //User inputs the title of the new item
		title = input2.nextLine();
		/*
		 * Enter the title to an appropriate array
		 */
	}
	
	public void setArtist() //Prompts the user to set the name of the artist 
	{
		System.out.print("Artist: ");
		artist = input2.nextLine();
		/*
		 * Enter Artist to an appropriate array
		 */
	}

	public void setItemNumber() //Prompts the user to set an item number to identify it
	{
		System.out.print("Item number: ");
		itemNumber = input.next();
		/*
		 * Enter item number to an appropriate array
		 * Make sure that there is no other item with the same number
		 */
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
}
