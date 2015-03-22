import java.util.Scanner;//hello

public class OverdueItems {
	
	private static Scanner in = new Scanner(System.in);

	public void displayingOverdueItems()
	{
		System.out.println("Item Number \t\t Name of Item \t\t Days borrowed \t\t RenterID \t\t Name of renter \t\t Telephone number");
		
		for (int i = 0; i < RentItem.rental.length; i++)
		{
			int daysBorrowedINT = 0;	
			
			if(RentItem.rental[i][4] != null) //If the borrowed time is not null
			{
				//Converting the days borrowed from integer to string
				String daysBorrowed = RentItem.rental[i][4];
				daysBorrowedINT = Integer.parseInt(daysBorrowed);
			}
			
			String itemNumber = RentItem.rental[i][0];
			String itemName = null;
			String renterID = RentItem.rental[i][2];
			String renterName = null;
			String telNO = null;
			
			for(int x = 0; x<NewItem.itemArray.length; i++) //Finding the name of the rented item and renter, and telephone number of the renter
			{
				//Finding name of the rented item
				if(NewItem.itemArray[x][3] != null && NewItem.itemArray[x][3].equals(itemNumber))
				{
					itemName = NewItem.itemArray[x][1];
				}
				
				//Finding name of renter and telephone number
				if(addNewMember.newMemberArray[x][3] != null && addNewMember.newMemberArray[x][3].equals(renterID))
				{
					renterName = addNewMember.newMemberArray[x][0];
					telNO = addNewMember.newMemberArray[x][2];
				}
				
				break;
			}
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Weekly") && daysBorrowedINT > 7) //Show if the list of rented items is of weekly type
			{
				System.out.println(itemNumber + "\t\t\t" + itemName + "\t\t\t" + daysBorrowedINT + "\t\t\t" + renterID + "\t\t\t" + renterName + "\t\t\t" + telNO);
			}
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Overnight") && daysBorrowedINT > 1) //Show if the list of rented items is of overnight type
			{
				System.out.println(itemNumber + "\t\t\t" + itemName + "\t\t\t" + daysBorrowedINT + "\t\t\t" + renterID + "\t\t\t" + renterName + "\t\t\t" + telNO);
			}
		}
		
		System.out.println();//Add space
		System.out.println("Press any key and hit enter to go back");
		String next = in.next();
	}
}
