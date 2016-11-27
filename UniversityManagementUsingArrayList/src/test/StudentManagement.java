package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	ArrayList<Student> studentList = new ArrayList<Student>();
//	Scanner sc1 = new Scanner(System.in);
	private Scanner sc;
	
	public StudentManagement(Scanner scanner) {
		sc = scanner;
	}

	// Function input a student
	public Student inputStudent(Student s) {
		
		
		int studentId = 0;
		int studentAge = 0, mark = 0;
		String studentName = null;
		
		try {
			System.out.println("Input Student's id: ");
			studentId = Integer.parseInt(sc.nextLine());
			
			System.out.println("Input student's name");
			studentName = sc.nextLine();			

			System.out.println("Input Student's age: ");
			studentAge = Integer.parseInt(sc.nextLine());

			System.out.println("Input Student's mark: ");
			mark = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		s.setId(studentId);
		s.setName(studentName);
		s.setAge(studentAge);
		s.setMark(mark);
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

		if (s.getMark() < 0 || s.getMark() > 10) {
			System.out.println("Mark range: 0-10! ");
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
		int mark = 0;
		String studentName = null;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == studentId) {
				try {
					
					System.out.println("Input new student's name");
					studentName = sc.nextLine();

					System.out.println("Input new Student's age: ");
					studentAge = Integer.parseInt(sc.nextLine());

					System.out.println("Input new Student's mark: ");
					mark = Integer.parseInt(sc.nextLine());
					
					tempStudent.setName(studentName);
					tempStudent.setAge(studentAge);
					tempStudent.setMark(mark);	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (validateInput(tempStudent) == true) {
					studentList.get(i).setName(studentName);
					studentList.get(i).setAge(studentAge);
					studentList.get(i).setMark(mark);
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
	
	// Sort student by mark using Merge Sort
	public void mergeSort(ArrayList<Student> listOfStudent) {
		if (listOfStudent.size() == 1) {
			return;
		}
		
		ArrayList<Student> leftStudentList = new ArrayList<Student>();
		ArrayList<Student> rightStudentList = new ArrayList<Student>();
		int mid = listOfStudent.size()/2;
		
		for (int leftIndex = 0; leftIndex < mid; leftIndex++) {
			leftStudentList.add(listOfStudent.get(leftIndex));
		}
		
		for (int rightIndex = mid; rightIndex <= listOfStudent.size() - 1; rightIndex++) {
			rightStudentList.add(listOfStudent.get(rightIndex));
		}
		
		mergeSort(leftStudentList);
		mergeSort(rightStudentList);
		
		merge(listOfStudent, leftStudentList, rightStudentList);
	}
	
	public void merge(ArrayList<Student> listOfStudent, ArrayList<Student> leftStudentList, ArrayList<Student> rightStudentList ) {
		int index = 0;
		int rightIndex = 0;
		int leftIndex = 0;
		
		while (leftIndex < leftStudentList.size() && rightIndex < rightStudentList.size()) {
			if (leftStudentList.get(leftIndex).getMark() < rightStudentList.get(rightIndex).getMark()) {
				listOfStudent.set(index, leftStudentList.get(leftIndex));
				leftIndex++;
				index++;
			} else {
				listOfStudent.set(index, rightStudentList.get(rightIndex));
				rightIndex++;
				index++;
			}
		}
		
		//add the rest of rightStudentList to listOfStudent
		if (rightIndex >= rightStudentList.size()) {
			while (leftIndex < leftStudentList.size()) {
				listOfStudent.set(index, leftStudentList.get(leftIndex));
				leftIndex++;
				index++;
			}
		}
		
		//add the rest of leftStudentList to listOfStudent
		if (leftIndex >= leftStudentList.size()) {
			while (rightIndex< rightStudentList.size()) {
				listOfStudent.set(index, rightStudentList.get(rightIndex));
				rightIndex++;
				index++;
			}
		}
	}
	
	//Call merge sort function
	public void sortStudentByPoint() {
		mergeSort(studentList);
	}
}