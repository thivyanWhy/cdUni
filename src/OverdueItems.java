import java.util.Scanner;//hello

public class OverdueItems {
	
	private static Scanner in = new Scanner(System.in);

	public void displayingOverdueItems()
	{
		System.out.println("Item Number \t\t Days borrowed \t\t Renter");
		
		for (int i = 0; i < RentItem.rental.length; i++)
		{
			int daysBorrowedINT = 0;	
			
			if(RentItem.rental[i][4] != null)
			{
				//Converting the days borrowed from integer to string
				String daysBorrowed = RentItem.rental[i][4];
				daysBorrowedINT = Integer.parseInt(daysBorrowed);
			}
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Weekly") && daysBorrowedINT > 7) //Show if the list of rented items is of weekly type
			{
				System.out.println(RentItem.rental[i][0] + "\t\t\t" + RentItem.rental[i][4] + "\t\t\t" + RentItem.rental[i][2]);
			}
			
			if(RentItem.rental[i][1] != null && RentItem.rental[i][1].equals("Overnight") && daysBorrowedINT > 1) //Show if the list of rented items is of overnight type
			{
				System.out.println(RentItem.rental[i][0] + "\t\t\t" + RentItem.rental[i][4] + "\t\t\t" + RentItem.rental[i][2]);
			}
		}
		
		System.out.println();//Add space
		System.out.println("Press any key and hit enter to go back");
		String next = in.next();
	}

	//Discuss additional functionalitites to this
}
