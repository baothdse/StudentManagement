package test;

public class Student {	
	private int studentId;
	private String studentName;
	private int studentAge;
	private int point;
	Student() {
		
	}
	Student(int id, String name, int age, int point) {
		
	}
	public int getId() {
		return studentId;
	}
	public void setId(int id) {
		this.studentId = id;
	}
	public String getName() {
		return studentName;
	}
	public void setName(String name) {
		this.studentName = name;
	}
	public int getAge() {
		return studentAge;
	}
	public void setAge(int age) {
		this.studentAge = age;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Student [id = " + studentId + ", " + "name=" + studentName + ", age=" + studentAge + ", point=" + point + "]";
	}
	
}
