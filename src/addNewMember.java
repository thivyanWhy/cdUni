import java.util.Scanner;

public class addNewMember {
	private Scanner in = new Scanner(System.in);
	private String name, nicNumber, telNumber, memberID; //The details of the new member are stored here
	
	public void setName() //The user sets the name of the new member
	{
		System.out.print("Enter first name: ");
		name = in.next();
		System.out.print("Enter last name: ");
		name = name + " " + in.next();
		/*
		 * Make new multi dimensional array and add name
		 */
	}
	
	public void setNICNumber() //The user sets the NIC number of the new member
	{
		int lengthOfNumber; //The length of the NIC number
		
		do
		{
			System.out.println("Enter NIC number: ");
			nicNumber = in.next();
			lengthOfNumber = nicNumber.length(); //Finding the number of characters in the NIC number
			
			//This is if the user enters an invalid NIC number
			if (lengthOfNumber != 10 && !(nicNumber.substring(9).equalsIgnoreCase("V") || nicNumber.substring(9).equalsIgnoreCase("X")))
			{
				System.err.println("Invalid input. Check whether there are 10 characters or ends with a V or X");
			}
		}while (lengthOfNumber != 10 && !(nicNumber.substring(9).equalsIgnoreCase("V") || nicNumber.substring(9).equalsIgnoreCase("X")));	
	
		/*
		 * Make new multi dimensional array for NIC number
		 */
	}
	
	public void setTelephoneNumber() //The user sets the telephone number of the new member
	{
		telNumber = in.next(); //This does not need to be an int value because mathematical calculations should not be done on it
		
		/*
		 * Make new multi dimensional array for telephone number
		 */
	}
	
	public void setMemberID() //The user sets the member ID of the new member
	{
		memberID = in.next();
		/*
		 * Make new multi dimensional array for member ID
		 */
	}
	
	public void showMemberDetails()
	{
		System.out.println("A new member has been added.");
		System.out.println("Name: " + name);
		System.out.println("NIC Number: " + nicNumber);
		System.out.println("Telephone number: " + telNumber);
		System.out.println("Member ID: " + memberID);
		System.out.println(); //Add space
	}
}

// God Vs Gugsi