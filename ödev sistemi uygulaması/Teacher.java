package Users; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Assignments.*;
import connector.MySQLConnector;

public class Teacher 
{

private ArrayList<Course> courses;
private String name, surname, username, department, password;
private int teacherID;

public Teacher(String name, String surname, String department, String username, String password) 
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
.prepareStatement("INSERT INTO teachers (username, password, name, surname, department)"
+ " VALUES ('" + username + "', '" + password + "', '" + name + "', '"
+ surname + "', '" + department + "')" );
posted.executeUpdate();
} catch (Exception e) {
System.out.println(e);
}
}

/*
* public Assignment createAssignment(int AssignmentChoice, String dueDate,
* int numOfQuestion, int numOfAssignment, int quizTime, String hint) { if
* (AssignmentChoice == Question.QUIZ) { Quiz q = new Quiz(dueDate,
* numOfQuestion, numOfAssignment, quizTime); return q; }
* 
* else if (AssignmentChoice == Question.HOMEWORK) { Homework h = new
* Homework(dueDate, numOfQuestion, numOfAssignment, hint); return h; } else
* return null; }
*/
/*
* public String changeDueDate(Assignment a, String dueDate){
* 
* }
*/
public Teacher(String username) {

ArrayList<String> nameSet = new ArrayList<String>();
ArrayList<String> surnameSet = new ArrayList<String>();
ArrayList<String> departmentSet = new ArrayList<String>();
ArrayList<String> passwordSet = new ArrayList<String>();
ArrayList<Integer> teacherIDSet = new ArrayList<Integer>();
;
try {
Connection con = MySQLConnector.getConnection();

PreparedStatement posted = con.prepareStatement("SELECT * FROM teachers WHERE username = ?");
posted.setString(1, username);

ResultSet teacherInfo = posted.executeQuery();

while (teacherInfo.next()) {
nameSet.add(teacherInfo.getString("name"));
surnameSet.add(teacherInfo.getString("surname"));
departmentSet.add(teacherInfo.getString("department"));
passwordSet.add(teacherInfo.getString("password"));
teacherIDSet.add(teacherInfo.getInt("id"));
}

this.username = username;
name = nameSet.get(0);
surname = surnameSet.get(0);
department = departmentSet.get(0);
password = passwordSet.get(0);
teacherID = teacherIDSet.get(0);

PreparedStatement postedCourses = con
.prepareStatement("SELECT course_code FROM courses WHERE teacher_id = ?");
postedCourses.setInt(1, teacherID);
courses = new ArrayList<Course>();

} catch (Exception e) {
System.out.println(e);
System.out.println("Cannot create teacher: " + username);
}
}

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

public int getTeacherID() {
return teacherID;
}

public void setTeacherID(int teacherID) {
this.teacherID = teacherID;
}

/*
* public void openClass(int keyCode) {
* 
* }
* 
* public void grade(FreeResponseQuestion f) {
* 
* }
* 
* public void addStudent(Student s) {
* 
* }
* 
* public void dropStudent(Student s) {
* 
* }
* 
* public void createQuestion(Question q) {
* 
* }
*/

}
