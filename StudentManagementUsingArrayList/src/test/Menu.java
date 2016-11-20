package test;

import java.util.Scanner;

public class Menu {
	public void menu() {
		StudentManagement stm = new StudentManagement();
		int ID;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice <= 6) {
			System.out.println("--------menu---------");
			System.out.println("1. Add new student.");
			System.out.println("2. Update an existed student.");
			System.out.println("3. Delete a student.");
			System.out.println("4. Print list of Student.");
			System.out.println("5. Sort Student by ID.");
			System.out.println("6. Sort Student by point.");
			System.out.println("Input your choice: ");
			choice = Integer.parseInt(sc.nextLine());	
			switch (choice) {
			case 1:
				stm.addStudentToList();
				break;
			case 2: 
				System.out.print("Input the ID of Student you want to change information: ");
				ID = Integer.parseInt(sc.nextLine());
				stm.updateStudentInfo(ID);
				break;
			case 3: 
				System.out.print("Enter ID of Student you want to delete: ");
				ID = Integer.parseInt(sc.nextLine());
				stm.deleteStudentById(ID);
				break;
			case 4: 
				stm.printAll();
				break;
			case 5: 
				stm.sortStudentByID();
				stm.printAll();
				break;
			case 6: 
				stm.sortStudentByPoint();
				stm.printAll();
				break;
			default:
				System.out.print("Exit");
				break;
			}
		}
		sc.close();
	}
	
	public static void main(String []args) {
		Menu m = new Menu();	
		m.menu();
	}
}
