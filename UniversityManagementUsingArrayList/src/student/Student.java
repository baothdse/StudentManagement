package student;

import staff.*;

public class Student extends Staff {	
	private int studentId;
	private int markOfStudent;	
	
	Student(){
		
	}
	
	Student(int id, String name, int age, int mark, String email) {
		super (name, age, email);
		studentId = id;
		markOfStudent = mark;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMarkOfStudent() {
		return markOfStudent;
	}

	public void setMarkOfStudent(int markOfStudent) {
		this.markOfStudent = markOfStudent;
	}

	@Override
	public String toString() {
		return "Student ID: " + studentId + ", Mark: " + markOfStudent + ", Name: " + getName()
				+ ", Age: " + getAge() + ", Email: " + getEmail();
	}
}
