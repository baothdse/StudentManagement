package instructor;

import java.util.Scanner;

public class InstructorOption {
	Scanner input = new Scanner(System.in);
	public InstructorOption(Scanner scanner) {
		input = scanner;
	}
	public void selectInstructorOption() {
		InstructorManagement instructorManagement = new InstructorManagement(input);
		
		int choice = 0;
		while (choice <= 2) {
			System.out.println("---------Instructor Management System----------");
			System.out.println("1. Add a new Instructor");
			System.out.println("2. Update an instructor");
			System.out.println("3. Delete an instructor");
			choice = Integer.parseInt(input.nextLine());
			
			switch(choice) {
			case 1:
				instructorManagement.addInstructorToList();
				break;
			default:
				System.out.println("Exit");
				break;
			}
			
		}
		
	}
}
