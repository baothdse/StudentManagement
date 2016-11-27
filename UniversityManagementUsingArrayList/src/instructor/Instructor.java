package instructor;

import staff.*;

public class Instructor extends Staff {
	private int instructorId;
	private String subject;
	private String classId;
	
	public Instructor (int id, String instructorName, int instructorAge,String subjectName, String classID, String instructorEmail) {
		super (instructorName, instructorAge, instructorEmail);
		instructorId = id;
		subject = subjectName;
		classId = classID;
	}
	
	public Instructor(){
		
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Instructor Id: " + instructorId + ", subject: " + subject + ", classId: " + classId
				+ ",Name: " + getName() + ",Age(): " + getAge() + ", Email: " + getEmail();
	}
	
	
}
