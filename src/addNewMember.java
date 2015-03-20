import java.util.Scanner;
import java.util.Arrays;

public class addNewMember {
	private Scanner in = new Scanner(System.in);
	String action; //Stores the action number user enters
	private String name, nicNumber, telNumber, memberID; //The details of the new member are stored here
	public static String [][] newMemberArray = new String [100][4];
		/*Column 1: Name
		 *Column 2: NIC number
		 *Column 3: Telephone number
		 *Column 4: Member ID
		 */
	
	public void setName(int correction) //The user sets the name of the new member
	{
		System.out.print("Enter first name: ");
		name = in.next();
		System.out.print("Enter last name: ");
		name = name + " " + in.next();
		
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][0] == null){
				
				newMemberArray[i - correction][0] = name;
				
			}
		}
	}
	
	public void setNICNumber(int correction) //The user sets the NIC number of the new member
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
				
				newMemberArray[i - correction][1] = nicNumber;
				
			}
		}
	}
	
	public void setTelephoneNumber(int correction) //The user sets the telephone number of the new member
	{
		telNumber = in.next(); //This does not need to be an int value because mathematical calculations should not be done on it
		
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][2] == null){
				
				newMemberArray[i - correction][2] = telNumber;
				
			}
		}
	}
	
	public void setMemberID(int correction) //The user sets the member ID of the new member
	{
		memberID = in.next();
		for (int i = 0; i < newMemberArray.length; i++){
			if (newMemberArray[i][3] == null){
				
				newMemberArray[i - correction][3] = memberID;
				
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
		do //Shows error message if user inputs a value that is not Y or N
		{
			System.out.print("Is the information shown above correct? (Y/N) ");
			action = in.next();
			
			if (!(action.equalsIgnoreCase("Y") || action.equalsIgnoreCase("N")))
			{
				System.err.println("Invalid input");
			}
		}while (!(action.equalsIgnoreCase("Y") || action.equalsIgnoreCase("N")));
		
		if(action.equalsIgnoreCase("N")) //If the user says that the shown values are incorrect
		{
			setName(1);
			setNICNumber(1);
			setTelephoneNumber(1);
			setMemberID(1);
			showMemberDetails();
			sortMemberList();
		}
	}
	
	public void sortMemberList()
	{
		String []members = new String[100];
		String [][] newMemberArraySORTED = new String [100][4];
		
		//Goes through all the titles in the "itemArray" multi dimensional array and assign them to their respective values in the "titles" array
		for (int i = 0; i<newMemberArray.length; i++)
		{
			members[i] = newMemberArray[i][1];
		}
		
		Arrays.sort(members); //Sorts the "titles" array in alphabetical order
		
		for (int i = 0; i<members.length; i++) //loop A
		{
			for (int x = 0; x<newMemberArray.length; x++) //loop B
			{
				if(members[i].equals(newMemberArray[x][1])) //loop C
				{
					for(int y = 0; y < 4; y++)
					{
						newMemberArraySORTED[i][y] = newMemberArray[x][y];
					}
				}
			}
		}
		
		/*EXPLAINATION FOR THE CODE ABOVE
		 *The "titles" array is sorted in alphabetical order
		 *in loop B, it goes through each value of the "members" array (through loop A) and checks if it is equal to some value in the title column of "newMemberArray"
		 *When it does become equal, all of the values in that row is assigned to the values in "newMemberArraySORTED" array in loop C
		 */
		for (int i = 0; i<newMemberArraySORTED.length; i++) //Now the MDA "itemArray" is in alphabetical order
		{
			for (int x = 0; x < 4; x++)
			{
				newMemberArray[i][x] = newMemberArraySORTED[i][x];
			}
		}
	}
}

