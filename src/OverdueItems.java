import java.util.Scanner;//hello

public class OverdueItems {

	public void displayingOverdueItems()
	{
		System.out.println("Item Number \t Days borrowed \t Renter");
		
		for (int i = 0; i < RentItem.rental.length; i++)
		{
			//Converting the days borrowed from integer to string
			String daysBorrowed = RentItem.rental[i][4];
			int daysBorrowedINT = Integer.parseInt(daysBorrowed);
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Weekly") && daysBorrowedINT > 7) //Show if the list of rented items is of weekly type
			{
				System.out.println(RentItem.rental[i][0] + "\t" + RentItem.rental[i][4] + "\t" + RentItem.rental[i][2]);
			}
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Overnight") && daysBorrowedINT > 1) //Show if the list of rented items is of overnight type
			{
				System.out.println(RentItem.rental[i][0] + "\t" + RentItem.rental[i][4] + "\t" + RentItem.rental[i][2]);
			}
		}
	}

	//Discuss additional functionalitites to this
}
