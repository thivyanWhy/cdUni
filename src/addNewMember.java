import java.util.Scanner;

public class addNewMember {
	private Scanner in = new Scanner(System.in);
	private String name, nicNumber, telNumber, memberID; //The details of the new member are stored here
	public static String [][] newMemberArray = new String [100][5];
	public void setName() //The user sets the name of the new member
	{
		System.out.print("Enter first name: ");
		name = in.next();
		System.out.print("Enter last name: ");
		name = name + " " + in.next();
		
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][0] == null){
				
				newMemberArray[i][0] = name;
				
			}
		}
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
	
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][1] == null){
				
				newMemberArray[i][1] = nicNumber;
				
			}
		}
	}
	
	public void setTelephoneNumber() //The user sets the telephone number of the new member
	{
		telNumber = in.next(); //This does not need to be an int value because mathematical calculations should not be done on it
		
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][2] == null){
				
				newMemberArray[i][2] = telNumber;
				
			}
		}
	}
	
	public void setMemberID() //The user sets the member ID of the new member
	{
		memberID = in.next();
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][3] == null){
				
				newMemberArray[i][3] = memberID;
				
			}
		}
	}
	
	public void showMemberDetails() //Shows the details of the new member added
	{
		System.out.println("A new member has been added.");
		System.out.println("Name: " + name);
		System.out.println("NIC Number: " + nicNumber);
		System.out.println("Telephone number: " + telNumber);
		System.out.println("Member ID: " + memberID);
		System.out.println(); //Add space
	}

	public void confirmNewMember() //Asks the user if the displayed information is correct and then gives him the option to edit it
	{
		/*
		 * sort of complicated code. Let me know when you have used arrays for the other stuff
		 */
	}
	
}

