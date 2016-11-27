package test;

public class Student {	
	private int studentId;
	private String studentName;
	private int studentAge;
	private int mark;
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
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Student [id = " + studentId + ", " + "name=" + studentName + ", age=" + studentAge + ", mark=" + mark + "]";
	}
	
}
