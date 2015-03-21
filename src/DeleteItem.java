import java.util.Scanner;//hello

public class DeleteItem {
	private static Scanner in = new Scanner(System.in);
	
	public void getItemList() //Loops through the list of items and displays list of items and ID
	{
		System.out.println("Item Number \t Title");
		
		for(int i = 0; i<NewItem.itemArray.length; i++)
		{
			if(NewItem.itemArray[i][3] == null)
			{
				break;
			}
			
			System.out.println(NewItem.itemArray[i][3] + "\t" + NewItem.itemArray[i][1]);
		}	
	}

	public void deleteItem(String verb) //Find the item and delete it
	{
		boolean tester = true;
		
		do
		{
			System.out.print("Enter the Item number of what is to be " + verb + "? ");
			String itemNO = in.next();
			
			for (int i = 0; i<NewItem.itemArray.length; i++)
			{

				if(NewItem.itemArray[i][3] != null && NewItem.itemArray[i][3].equals(itemNO))
				{
					tester = false; //If the corresponding item number is found in the list, then change the value of tester to false
					
					for (int x = 0; x < 4; x++)
					{
						NewItem.itemArray[i][x] = null; //Change all the values in the row to null
					}
				}
			}
			
			if(tester)
			{
				System.err.println("Item number could not be found.");
			}
		}while(tester);
	}
}
