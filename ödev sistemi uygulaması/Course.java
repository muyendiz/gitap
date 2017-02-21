package Assignments;

import java.util.ArrayList;

import Users.*;

public class Course {

	private String classCode;
	private ArrayList<Student> students;
	private Teacher t;
	private ArrayList<Assignment> assignments;
	private int section;
	private String courseName;
	
	
	public Course(int section, String courseName, Teacher t){
		this.setCourseName(courseName);
		this.setSection(section);
		this.setT(t);
		setClassCode(courseName + "-" + section);
		students = new ArrayList<Student>();
		setAssignments(new ArrayList<Assignment>());
	}
	
	
	
	public void addStudent(Student s){
		students.add(s);
	}
	
	
	public void assign(Assignment a){
		
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public int getSection() {
		return section;
	}



	public void setSection(int section) {
		this.section = section;
	}



	public String getClassCode() {
		return classCode;
	}



	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}



	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}



	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}



	public Teacher getT() {
		return t;
	}



	public void setT(Teacher t) {
		this.t = t;
	}
	
}
