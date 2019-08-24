
import java.util.*;

public class Driver 
{
	public static void main(String[] arg)
	{
		GenTree tree = new GenTree();
		
		menu(tree);
	}
	
	public static char getChoice()
	{
		System.out.println("Enter Choice:");
		System.out.println("\t1 -- Quit");
		System.out.println("\t2 -- Insert");
		//System.out.println("\t3 -- Remove");
		System.out.println("\t4 -- Print");
		System.out.println("\t5 -- Clear");
		
		System.out.print("Choice: ");
		
		Scanner userInput = new Scanner(System.in);
		
		return userInput.nextLine().charAt(0);
	}
	
	public static void menu(GenTree tree)
	{
		char choice = ' ';
		boolean isDone = false;
		Scanner userInput = new Scanner(System.in);
		String line;
		
		while (! isDone)
		{
			choice = getChoice();
			
			switch (choice)
			{
			case '1':				// Quit
				isDone = true;
				break;
			case '2':				// Insert
				System.out.println("Do you want:");
				System.out.println("\t1 -- New Root");
				System.out.println("\t2 -- New Left Child");
				System.out.print("Choice: ");
				
				switch (userInput.nextLine().charAt(0))
				{
				case '1':
					System.out.print("Line to Enter: ");
					line = userInput.nextLine();
					tree.newroot(line,tree.root(),null);
					break;
				case '2':
					System.out.print("Line to Enter: ");
					line = userInput.nextLine();
					tree.newleftchild(line);
					break;
				}
				
				break;
			case '3':				// Remove
				break;
			case '4':				// Print
				tree.print();
				break;
			case '5':				// Clear
				tree.clear();
				break;
			}

		}
		
	}

}
