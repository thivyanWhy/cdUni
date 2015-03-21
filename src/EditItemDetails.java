import java.util.Scanner;//hello

public class EditItemDetails {

	private Scanner in = new Scanner(System.in);
	
	public void getItemList() //Loops through the list of items and displays list of items and ID
	{
		System.out.println("Item Number \t Title");
		
		for(int i = 0; i<NewItem.itemArray.length; i++)
		{
			if(NewItem.itemArray[i][3] == null)
			{
				break;
			}
			
			System.out.println(NewItem.itemArray[i][3] + "\t\t\t" + NewItem.itemArray[i][1]);
		}
	}
	
	public void editItem()
	{
		DeleteItem objAD = new DeleteItem();
		objAD.deleteItem("edited"); //Deletes the item temporarily so that an empty space is created where it will be overwritten by a the edited item
		
		//Creates a new item in the empty space
		NewItem objBN = new NewItem();
		objBN.setItemType(0); //Prompt user for details
		objBN.setTitle(0); //Prompt user to set the title for the new item
		objBN.setArtist(0); //Prompts the user to set the artist for the new item
		objBN.setItemNumber(0); //Prompts the user to set the item number
		objBN.sortItemList();//Sorts the values in the multi dimensional array
		
		
	}
}
