import java.util.Scanner;

public class NewItem 
{	
	private Scanner input = new Scanner (System.in);
	private String itemType;
	
	public void setItemType() //This method prompts the user with what to input
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
		
	}
}
