package instructor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import student.Student;
import student.StudentManagement;

public class InstructorManagement {
	private Pattern regexPattern;
	private Matcher regMatcher;
	Scanner input = new Scanner(System.in);
	StudentManagement studentManagement = new StudentManagement(input);
	
	ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
	ArrayList<Student> studentList = studentManagement.getStudentList();
	
	public InstructorManagement(Scanner scanner) {
		input = scanner;
	}
	
	public Instructor inputInstructor(Instructor instructor) {
		int instructorId = 0;
		String instructorName = null;
		int instructorAge = 0;
		String subject = null;
		String classId = null;
		String email = null;
		try {
			System.out.println("Input instructor's ID: ");
			instructorId = Integer.parseInt(input.nextLine());
			
			System.out.println("Input instructor's name: ");
			instructorName = input.nextLine();
			
			System.out.println("Input instructor's age: ");
			instructorAge = Integer.parseInt(input.nextLine());
			
			System.out.println("Input instructor's subject: ");
			subject = input.nextLine();
			
			System.out.println("Input instructor's email: ");
			email = input.nextLine();
			
			System.out.println("Input instructor's class ID: ");
			classId = input.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		instructor.setInstructorId(instructorId);
		instructor.setName(instructorName);
		instructor.setAge(instructorAge);
		instructor.setSubject(subject);
		instructor.setEmail(email);
		instructor.setClassId(classId);
		return instructor;
	}
	
	public boolean checkDuplicateId(int id) {
		for (int index = 0; index < instructorList.size(); index++) {
			if (instructorList.get(index).getInstructorId() == id) {
				System.out.println("Id is duplicated. Please try again!");
				return false;
			}
		}
		return true;
	}
	
	public boolean validateAge(int age) {
		if (age <= 0) {
			System.out.println("Age can not less than 0! Please try again!");
			return false;
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
	
	//function check duplicated email. email of student & instructor cannot be the same.
	public boolean checkDuplicateEmail(String emailAddress) {
		for (int index = 0; index < instructorList.size(); index++) {
			if (instructorList.get(index).getEmail().equals(emailAddress) || studentList.get(index).getEmail().equals(emailAddress)) {
				System.out.println("Email cannot duplicated!");
				return false;
			}
		}
		return true;
	}
	
	public void addInstructorToList() {
		Instructor instructor = new Instructor();
		inputInstructor(instructor);
		if (checkDuplicateId(instructor.getInstructorId()) == true && validateAge(instructor.getAge()) == true 
			&& validateEmailFormat(instructor.getEmail()) == true && checkDuplicateEmail(instructor.getEmail()) == true) {
			System.out.println("Instructor was added to list! ");
		}
	}
}
