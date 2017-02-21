package Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Assignments.Course;
import connector.MySQLConnector;

public class Student 
{

private ArrayList<Course> courses;
private String name, surname, username, department, password;
private int studentID;

public Student(String name, String surname, String department, String username, String password) 
{
this.name = name;
this.surname = surname;
this.department = department;
this.surname = username;
this.password = password;
courses = new ArrayList<Course>();
try {
Connection con = MySQLConnector.getConnection();
PreparedStatement posted = con
.prepareStatement("INSERT INTO students (username, password, name, surname, department)"
+ " VALUES ('" + username + "', '" + password + "', '" + name + "', '"
+ surname + "', '" + department + "')" );
posted.executeUpdate();
} catch (Exception e) {
System.out.println(e);
}
}

public Student(String username) {

try {
Connection con = MySQLConnector.getConnection();
PreparedStatement posted = con.prepareStatement("SELECT * FROM students WHERE username = ?");
posted.setString(1, username);

ResultSet studentInfo = posted.executeQuery();

ArrayList<String> nameSet = new ArrayList<String>();
ArrayList<String> surnameSet = new ArrayList<String>();
ArrayList<String> departmentSet = new ArrayList<String>();
ArrayList<String> passwordSet = new ArrayList<String>();
ArrayList<Integer> studentIDSet = new ArrayList<Integer>();
while (studentInfo.next()) {
nameSet.add(studentInfo.getString("name"));
surnameSet.add(studentInfo.getString("surname"));
departmentSet.add(studentInfo.getString("department"));
passwordSet.add(studentInfo.getString("password"));
studentIDSet.add(studentInfo.getInt("id"));
}

this.username = username;
name = nameSet.get(0);
surname = surnameSet.get(0);
department = departmentSet.get(0);
password = passwordSet.get(0);
studentID = studentIDSet.get(0);

PreparedStatement postedCourses = con
.prepareStatement("SELECT course_id FROM student_courses WHERE student_id = ?");
postedCourses.setInt(1, studentID);
courses = new ArrayList<Course>();

} catch (Exception e) {
System.out.println(e);
System.out.println("Cannot create student: " + username);
}
}

/*
* public void answerFreeResponseQuestion(FreeResponseQuestion f) {
* 
* }
* 
* public void answerMultipleChoiceQuestion(MultipleChoiceQuestion m) {
* 
* }
*/

public ArrayList<Course> getCourses() {
return courses;
}

public void setCourses(ArrayList<Course> courses) {
this.courses = courses;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSurname() {
return surname;
}

public void setSurname(String surname) {
this.surname = surname;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getDepartment() {
return department;
}

public void setDepartment(String department) {
this.department = department;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public int getStudentID() {
return studentID;
}

public void setStudentID(int studentID) {
this.studentID = studentID;
}

}
