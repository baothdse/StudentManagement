package test;


import java.util.Scanner;

public class Menu {
	public void menu() {
		StudentManagement stm = new StudentManagement();
		int ID;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice <= 5) {
			System.out.println("--------menu---------");
			System.out.println("1. Add");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Print");
			System.out.println("5. Sort Student by ID");
			System.out.println("Input your choice: ");		
		
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				stm.addStudentToList();
				break;
			case 2: 
				System.out.print("Input the ID of Student you want to change information: ");
				ID = sc.nextInt();
				stm.updateStudentInfo(ID);
				break;
			case 3: 
				System.out.print("Enter ID of Student you want to delete: ");
				ID = sc.nextInt();
				stm.deleteStudentById(ID);
				break;
			case 4: 
				stm.printAll();
				break;
			case 5: 
				stm.sortStudentByID();
				//stm.printAll();
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
