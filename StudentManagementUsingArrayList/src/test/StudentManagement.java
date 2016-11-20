package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	ArrayList<Student> studentList = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	// Function input a student
	public Student inputStudent(Student s) {
		
		int studentId = 0;
		int studentAge = 0, point = 0;
		String studentName = null;
		
		try {
			System.out.println("Input Student's id: ");
			studentId = Integer.parseInt(sc1.nextLine());
			
			System.out.println("Input student's name");
			studentName = sc.nextLine();			

			System.out.println("Input Student's age: ");
			studentAge = Integer.parseInt(sc1.nextLine());

			System.out.println("Input Student's point: ");
			point = Integer.parseInt(sc1.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		s.setId(studentId);
		s.setName(studentName);
		s.setAge(studentAge);
		s.setPoint(point);
		return s;
	}
	
	public boolean checkDuplicateId (int ID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == ID) {
				System.out.println("ID is existed!");
				return false;
			}
		}
		return true;
	}

	// Function validate the student information
	public boolean validateInput(Student s) {

		if (s.getId() < 0) {
			System.out.println("ID cannot less than 0!");
			return false;
		}

		if (s.getAge() <= 8 || s.getAge() >= 30) {
			System.out.println("Age range from 8 to 30!");
			return false;
		}

		if (s.getPoint() < 0 || s.getPoint() > 10) {
			System.out.println("Point range: 0-10! ");
			return false;
		}
		return true;
	}

	public void addStudentToList() {
		Student s = new Student();
		inputStudent(s);
		if (validateInput(s) == true && checkDuplicateId(s.getId()) == true) {
			studentList.add(s);
		} 
	}
	
	public boolean searchByStudentId(int studentId) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == studentId)
				return true;
		}
		return false;
	}
	
	public void updateStudentInfo(int studentId) {
		Student tempStudent = new Student();
		int studentAge = 0;
		int point = 0;
		String studentName = null;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == studentId) {
				try {
					
					System.out.println("Input new student's name");
					studentName = sc.nextLine();

					System.out.println("Input new Student's age: ");
					studentAge = Integer.parseInt(sc1.nextLine());

					System.out.println("Input new Student's point: ");
					point = Integer.parseInt(sc1.nextLine());
					
					tempStudent.setName(studentName);
					tempStudent.setAge(studentAge);
					tempStudent.setPoint(point);	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (validateInput(tempStudent) == true) {
					studentList.get(i).setName(studentName);
					studentList.get(i).setAge(studentAge);
					studentList.get(i).setPoint(point);
					System.out.println("Update student who have ID= " + studentList.get(i).getId() + " successful!");
				}
				return;
			} else {
				System.out.println("This ID is not existed in system!");
			}
		}		
	}
	
	public void sortStudentByID() {
		Student temp;
		for (int i = 0; i < studentList.size() - 1; i++) {
			for (int j = 0; j < studentList.size() - i - 1; j++) {
				if (studentList.get(j+1).getId() > studentList.get(j).getId()) {
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j + 1));
					studentList.set(j + 1, temp);					
				}
			}
		}
	}
	
	public void deleteStudentById(int ID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == ID) {
				studentList.remove(i);
				System.out.println("Delete successful");
			} else {
				System.out.println("This ID is not existed in system. Please try again!");
			}
		}
	}
//	// Check ID that is duplicate
//	public boolean checkId(int ID) {
//		for (int i = 0; i < student.size(); i++) {
//			if (student.get(i).getId() == ID) {
//				return false;
//			}
//		}
//		return true;
//	}

	// Function print all Students in the list
	public void printAll() {
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}

	}
}