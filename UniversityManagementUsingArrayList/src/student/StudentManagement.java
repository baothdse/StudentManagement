package student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManagement {
	ArrayList<Student> studentList = new ArrayList<Student>();
	private Scanner sc;
	private Pattern regexPattern;
	private Matcher regMatcher;
	
	public StudentManagement(Scanner scanner) {
		sc = scanner;
	}
	
	// Function input a student
	public Student inputStudent(Student student) {
		
		int studentId = 0;
		int studentAge = 0, mark = 0;
		String studentName = null;
		String studentEmail = null;
		
		try {
			System.out.println("Input Student's id: ");
			studentId = Integer.parseInt(sc.nextLine());
			
			System.out.println("Input student's name: ");
			studentName = sc.nextLine();			

			System.out.println("Input Student's age: ");
			studentAge = Integer.parseInt(sc.nextLine());			

			System.out.println("Input Student's mark: ");
			mark = Integer.parseInt(sc.nextLine());
			
			System.out.println("Input Student's email: ");
			studentEmail = sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		student.setStudentId(studentId);
		student.setName(studentName);
		student.setAge(studentAge);
		student.setMarkOfStudent(mark);
		student.setEmail(studentEmail);
		return student;
	}
	
	public boolean checkDuplicateId (int ID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == ID) {
				System.out.println("ID is existed!");
				return false;
			}
		}
		return true;
	}
	
	public boolean validateEmailFormat(String emailAddress) {
		regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
	    regMatcher   = regexPattern.matcher(emailAddress);
	    if(regMatcher.matches()){
	        return true;
	    } else {
	    	System.out.println("Email format is wrong. Please try again!");
	        return false;
	    }
    
	}
	// Function validate the student information
	public boolean validateInput(Student student) {

		if (student.getStudentId() < 0) {
			System.out.println("ID cannot less than 0!");
			return false;
		}

		if (student.getAge() <= 8 || student.getAge() >= 30) {
			System.out.println("Age range from 8 to 30!");
			return false;
		}

		if (student.getMarkOfStudent() < 0 || student.getMarkOfStudent() > 10) {
			System.out.println("Mark range: 0-10! ");
			return false;
		}
		return true;
	}

	public void addStudentToList() {
		Student student = new Student();
		inputStudent(student);
		if (validateInput(student) == true && checkDuplicateId(student.getStudentId()) == true 
				&& validateEmailFormat(student.getEmail()) == true) {
			studentList.add(student);
			System.out.println("Student was added!");
		} 
	}
	
	public boolean searchByStudentId(int studentId) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == studentId)
				return true;
		}
		return false;
	}
	
	public void updateStudentInfo(int studentId) {
		Student tempStudent = new Student();
		int studentAge = 0;
		int mark = 0;
		String studentEmail = null;
		String studentName = null;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == studentId) {
				try {
					
					System.out.println("Input new student's name: ");
					studentName = sc.nextLine();

					System.out.println("Input new Student's age: ");
					studentAge = Integer.parseInt(sc.nextLine());

					System.out.println("Input new Student's mark: ");
					mark = Integer.parseInt(sc.nextLine());
					
					System.out.println("Input new Student's email: ");
					studentEmail = sc.nextLine();
					
					tempStudent.setName(studentName);
					tempStudent.setAge(studentAge);
					tempStudent.setMarkOfStudent(mark);
					tempStudent.setEmail(studentEmail);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (validateInput(tempStudent) == true && validateEmailFormat(tempStudent.getEmail()) == true) {
					studentList.get(i).setName(studentName);
					studentList.get(i).setAge(studentAge);
					studentList.get(i).setMarkOfStudent(mark);
					System.out.println("Update student who have ID= " + studentList.get(i).getStudentId() + " successful!");
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
				if (studentList.get(j+1).getStudentId() > studentList.get(j).getStudentId()) {
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j + 1));
					studentList.set(j + 1, temp);					
				}
			}
		}
	}
	
	public void deleteStudentById(int ID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == ID) {
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
			if (leftStudentList.get(leftIndex).getMarkOfStudent() < rightStudentList.get(rightIndex).getMarkOfStudent()) {
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
	public void sortStudentByMark() {
		mergeSort(studentList);
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
}