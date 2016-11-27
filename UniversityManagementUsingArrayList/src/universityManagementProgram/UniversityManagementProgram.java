package universityManagementProgram;

import java.util.Scanner;

import instructor.InstructorOption;
import student.StudentOption;

public class UniversityManagementProgram {	
	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		StudentOption studentOption = new StudentOption(input);	
		InstructorOption instructorOption = new InstructorOption(input);
		int choice = 0;
		
		while(choice <= 2) {
			System.out.println("-------University Management System-------");
			System.out.println("1. Student Management System.");
			System.out.println("2. Instructor Management System.");
			choice = Integer.parseInt(input.nextLine());
			
			switch(choice) {
			case 1: 
				studentOption.selectStudentOption();
				break;
			case 2:
				instructorOption.selectInstructorOption();
				break;
			default:
				System.out.println("Exit");
				break;
			}
		}
		
		
	}
}
