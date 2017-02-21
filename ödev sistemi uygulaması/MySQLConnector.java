package connector;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Questions.*;
import Users.*;
import Assignments.*;

public class MySQLConnector {
	

	public static void main(String[] args) throws Exception {
		
		
		
		System.out.println(getGrades("CS101-5", "Homework", 1));
	   Student student = new Student("yusuf123");
		checkToFreeResponse("MATH102-1Homework20", student, false);
		
		
		
		

	}

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/quick_assign?&useSSL=false";
			String username = "root";
			String password = "2127mamu";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public static void postTeacher(Teacher t) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO teachers (username, password, name, surname, department)"
							+ " VALUES ('" + t.getUsername() + "', '" + t.getPassword() + "', '" + t.getName() + "', '"
							+ t.getSurname() + "', '" + t.getDepartment() + "')");
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Teacher Insert Complete");
		}
	}

	public static void postStudent(Student t) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO students (username, password, name, surname, department)"
							+ " VALUES ('" + t.getUsername() + "', '" + t.getPassword() + "', '" + t.getName() + "', '"
							+ t.getSurname() + "', '" + t.getDepartment() + "')");
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Student Insert Complete");
		}
	}

	public static void enrollCourse(Student s, String courseCode) throws Exception {
		try {
			ResultSet result1;
			ResultSet result2;
			ArrayList<String> array1 = new ArrayList<String>();
			ArrayList<String> array2 = new ArrayList<String>();
			Connection con = getConnection();
			PreparedStatement takeStudent = con.prepareStatement("SELECT id FROM students WHERE username = ?");
			takeStudent.setString(1, s.getUsername());
			System.out.println(s.getUsername());
			result1 = takeStudent.executeQuery();
			while (result1.next()) {
				array1.add(result1.getString("id"));
			}
			System.out.println(array1.get(0));
			PreparedStatement takeCourse = con.prepareStatement("SELECT id FROM courses WHERE course_code = ?");
			takeCourse.setString(1, courseCode);

			result2 = takeCourse.executeQuery();
			while (result2.next()) {
				array2.add(result2.getString("id"));
			}
			System.out.println(array2.get(0));
			PreparedStatement postStudentToCourse = con
					.prepareStatement("INSERT INTO student_course (student_id, course_id) VALUES ( ?, ?)");
			postStudentToCourse.setString(1, array1.get(0));
			postStudentToCourse.setString(2, array2.get(0));
			postStudentToCourse.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createCourse(Teacher t, String courseCode) throws Exception {
		try {
			ResultSet result;
			ArrayList<Integer> array = new ArrayList<Integer>();

			Connection con = getConnection();
			PreparedStatement take = con.prepareStatement("SELECT id FROM teachers WHERE username = ? ");
			take.setString(1, t.getUsername());
			System.out.println(t.getUsername());
			result = take.executeQuery();
			while (result.next()) {
				array.add(result.getInt("id"));
			}
			System.out.println(array.get(0));
			PreparedStatement post = con
					.prepareStatement("INSERT INTO courses (course_code, teacher_id) VALUES (?, ?)");
			post.setString(1, courseCode);
			post.setInt(2, array.get(0));
			post.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void postMultipleChoiceQuestion(MultipleChoiceQuestion m) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO multiple_choice_question (course, assignment_type, num_of_assignment, question_number, question_code, text, choice1, choice2, choice3, choice4, correct_answer)"
							+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			posted.setString(1, m.getNameOfCourse());
			posted.setString(2, m.getAssignmentType());
			posted.setInt(3, m.assignmentNumber());
			posted.setInt(4, m.getQuestionNumber());
			posted.setString(5, m.calculateQuestionCode());
			posted.setString(6, m.getQuestionText());
			posted.setString(7, m.getchoiceText(0));
			posted.setString(8, m.getchoiceText(1));
			posted.setString(9, m.getchoiceText(2));
			posted.setString(10, m.getchoiceText(3));
			posted.setInt(11, m.getCorrectChoice());
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("m question inserted");
		}
	}

	public static void postFreeResponseQuestion(FreeResponseQuestion q) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO free_response_question (course, assignment_type, num_of_assignment, question_number, question_code, text)"
							+ " VALUES (?, ?, ?, ?, ?, ?)");
			posted.setString(1, q.getNameOfCourse());
			posted.setString(2, q.getAssignmentType());
			posted.setInt(3, q.assignmentNumber());
			posted.setInt(4, q.getQuestionNumber());
			posted.setString(5, q.calculateQuestionCode());
			posted.setString(6, q.getQuestionText());
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void postFreeResponseAnswer(Student student, FreeResponseQuestion q, String answer) throws Exception {
		try {
			ResultSet checker = null;
			Connection con = getConnection();
			PreparedStatement check = con
					.prepareStatement("SELECT question_code FROM free_response_answer WHERE username = ?");
			check.setString(1, student.getUsername());
			checker = check.executeQuery();
			boolean inserted = false;
			ArrayList<String> Array =new ArrayList<String>();
			while(checker.next()){Array.add(checker.getString("question_code"));}
			for(int i = 0 ;i<Array.size()&&!inserted;i++){
				if(Array.get(i).equals(q.calculateQuestionCode())){
				PreparedStatement update = con.prepareStatement("UPDATE free_response_answer SET answer = ? WHERE username = ? and question_code = ?");
				update.setString(1, answer);
				update.setString(2, student.getUsername());
				update.setString(3, q.calculateQuestionCode());
				update.executeUpdate();
				inserted=true;}}
			if(!inserted){
				System.out.println("sdasdfasd");
				PreparedStatement posted = con
						.prepareStatement("INSERT INTO free_response_answer (username, question_code, answer) VALUES ('"
								+ student.getUsername() + "', '" + q.calculateQuestionCode() + "', '" + answer + "' )");
				posted.executeUpdate();}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void postMultipleChoiceAnswer(Student student, MultipleChoiceQuestion q, int answer)
			throws Exception {
		try {
			ResultSet checker=null;
			Connection con = getConnection();
			PreparedStatement check = con
					.prepareStatement("SELECT question_code FROM multiple_choice_answer WHERE username = ?");
			check.setString(1, student.getUsername());
			checker = check.executeQuery();
			ArrayList<String> Array =new ArrayList<String>();
			boolean inserted = false;
			while(checker.next()){Array.add(checker.getString("question_code"));}
			for(int i = 0 ;i<Array.size()&&!inserted;i++){
				if(Array.get(i).equals(q.calculateQuestionCode())) {
				PreparedStatement update = con.prepareStatement(
						"UPDATE multiple_choice_answer SET answer = ? WHERE username = ? and question_code = ?");
				update.setInt(1, answer);
				update.setString(2, student.getUsername());
				update.setString(3, q.calculateQuestionCode());
				update.executeUpdate();
				inserted = true ;}
			} if(!inserted){
				PreparedStatement posted = con.prepareStatement(
						"INSERT INTO multiple_choice_answer (username, question_code, answer, correctness) VALUES ('"
								+ student.getUsername() + "', '" + q.calculateQuestionCode() + "', '" + answer
								+ "', ? )");

				if (answer == q.getCorrectChoice())
					posted.setString(1, "t");
				else
					posted.setString(1, "f");
				posted.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void checkToFreeResponse(String questionCode, Student s, boolean b) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement give = con.prepareStatement(
					"UPDATE free_response_answer SET  correctness = ? WHERE username = ? and question_code = ?");
			give.setString(2, s.getUsername());
			give.setString(3, questionCode);
			if (b)
				give.setString(1, "true");
			if (!b)
				give.setString(1, "false");
			give.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static ArrayList<FreeResponseQuestion> getFreeResponseQuestions(String courseCode, int assignmentNo,
			String assignmentType) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("SELECT text, question_number FROM free_response_question WHERE course = ?"
							+ "AND assignment_type = ? AND num_of_assignment = ?");
			posted.setString(1, courseCode);
			posted.setString(2, assignmentType);
			posted.setInt(3, assignmentNo);
			ResultSet questionSet = posted.executeQuery();

			ArrayList<FreeResponseQuestion> questions = new ArrayList<FreeResponseQuestion>();
			while (questionSet.next()) {
				questions.add(new FreeResponseQuestion(questionSet.getString("text"), courseCode,
						questionSet.getInt("question_number"), assignmentNo, assignmentType));
			}
			return questions;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public static ArrayList<MultipleChoiceQuestion> getMultipleChoiceQuestions(String courseCode, int assignmentNo,
			String assignmentType) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("SELECT * FROM multiple_choice_question"
					+ " WHERE course = ? AND assignment_type = ? AND num_of_assignment = ?");
			posted.setString(1, courseCode);
			posted.setString(2, assignmentType);
			posted.setInt(3, assignmentNo);
			ResultSet questionSet = posted.executeQuery();

			ArrayList<MultipleChoiceQuestion> questions = new ArrayList<MultipleChoiceQuestion>();
			while (questionSet.next()) {
				questions.add(new MultipleChoiceQuestion(questionSet.getString("text"), courseCode,
						questionSet.getInt("question_number"), assignmentNo, assignmentType,
						questionSet.getInt("correct_answer"), questionSet.getString("choice1"),
						questionSet.getString("choice2"), questionSet.getString("choice3"),
						questionSet.getString("choice4")));
			}
			return questions;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}

	public static ArrayList<String> getCourses(Student s) throws Exception {
		try {
			ResultSet student_id;
			ResultSet course_id;
			ResultSet course;
			ArrayList<String> courses = new ArrayList<String>();
			ArrayList<Integer> s_id = new ArrayList<Integer>();
			ArrayList<Integer> c_id = new ArrayList<Integer>();
			Connection con = MySQLConnector.getConnection();
			PreparedStatement getStudent = con.prepareStatement("SELECT id FROM students WHERE username = ?");
			getStudent.setString(1, s.getUsername());
			student_id = getStudent.executeQuery();
			while (student_id.next()) {
				s_id.add(student_id.getInt("id"));
			}

			PreparedStatement getCourseid = con
					.prepareStatement("SELECT course_id FROM student_course WHERE student_id = ?");
			getCourseid.setInt(1, s_id.get(0));
			course_id = getCourseid.executeQuery();
			while (course_id.next()) {
				c_id.add(course_id.getInt("course_id"));
			}
			for (int i = 0; i < c_id.size(); i++) {
				PreparedStatement getCourse = con.prepareStatement("SELECT course_code FROM courses WHERE id = ?");
				getCourse.setInt(1, c_id.get(i));
				course = getCourse.executeQuery();
				while (course.next()) {
					courses.add(course.getString("course_code"));
				}
			}
			return courses;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static ArrayList<String> getAllCourses() {
		ArrayList<String> courses = new ArrayList<String>();
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("SELECT course_code FROM courses");
			ResultSet result = posted.executeQuery();
			while (result.next()) {
				courses.add(result.getString("course_code"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return courses;
	}

	public static ArrayList<String> getTeacherCourses(Teacher t) throws Exception {
		try {
			Connection con = getConnection();
			ResultSet teacher;
			ResultSet courses;
			ArrayList<Integer> idList = new ArrayList<Integer>();
			ArrayList<String> courseList = new ArrayList<String>();
			PreparedStatement id = con.prepareStatement("SELECT id FROM teachers WHERE username = ?");
			id.setString(1, t.getUsername());
			teacher = id.executeQuery();
			while (teacher.next()) {
				idList.add(teacher.getInt("id"));
			}
			PreparedStatement course = con.prepareStatement("SELECT course_code FROM courses WHERE teacher_id = ?");
			course.setInt(1, idList.get(0));
			courses = course.executeQuery();
			while (courses.next()) {
				courseList.add(courses.getString("course_code"));
			}
			return courseList;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static ArrayList<String> getStudentsFromCourse(String courseCode) {
		try {
			ResultSet ids;
			ResultSet s_ids;
			ResultSet users;
			ArrayList<Integer> c_id = new ArrayList<Integer>();
			ArrayList<Integer> student_id = new ArrayList<Integer>();
			ArrayList<String> usernames = new ArrayList<String>();
			Connection con = getConnection();
			PreparedStatement id = con.prepareStatement("SELECT id FROM courses WHERE course_code = ?");
			id.setString(1, courseCode);
			ids = id.executeQuery();
			while (ids.next()) {
				c_id.add(ids.getInt("id"));
			}
			PreparedStatement s_id = con.prepareStatement("SELECT student_id FROM student_course WHERE course_id = ?");
			s_id.setInt(1, c_id.get(0));
			s_ids = s_id.executeQuery();
			while (s_ids.next()) {
				student_id.add(s_ids.getInt("student_id"));
			}
			for (int i = 0; i < student_id.size(); i++) {
				PreparedStatement user = con.prepareStatement("SELECT username FROM students WHERE id = ?");
				user.setInt(1, student_id.get(i));
				users = user.executeQuery();
				while (users.next()) {
					usernames.add(users.getString("username"));
				}
			}
			return usernames;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static boolean checkStudent(String username, String password) throws Exception {
		try {
			Connection con = MySQLConnector.getConnection();
			PreparedStatement result = con.prepareStatement("SELECT username, password FROM students");
			ResultSet resultSet = result.executeQuery();
			while (resultSet.next()) {
				if (username.equals(resultSet.getString("username"))
						&& password.equals(resultSet.getString("password"))) {
					System.out.println("login");
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static boolean checkTeacher(String username, String password) throws Exception {
		try {
			Connection con = MySQLConnector.getConnection();
			PreparedStatement result = con.prepareStatement("SELECT username, password FROM teachers");
			ResultSet resultSet = result.executeQuery();
			while (resultSet.next()) {
				if (username.equals(resultSet.getString("username"))
						&& password.equals(resultSet.getString("password")))
					return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public static ArrayList<String> getFreeResponseAnswer(String classCode, String assignmentType, int assignmentNo,
			String username) {
		try {
			String questionCode = classCode + assignmentType + assignmentNo;
			ResultSet codes;
			ResultSet allAns;
			ArrayList<String> q_code = new ArrayList<String>();
			ArrayList<String> question_code = new ArrayList<String>();
			ArrayList<String> index = new ArrayList<String>();
			ArrayList<String> allAnswer = new ArrayList<String>();
			ArrayList<String> answer = new ArrayList<String>();
			Connection con = getConnection();
			PreparedStatement code = con
					.prepareStatement("SELECT question_code FROM free_response_answer WHERE username = ?");
			code.setString(1, username);
			codes = code.executeQuery();
			while (codes.next()) {
				q_code.add(codes.getString("question_code"));
			}

			for (int i = 0; i < q_code.size(); i++) {
				System.out.println("1. for");
				if (q_code.get(i).substring(0, q_code.get(i).length() - 1).equals(questionCode)) {System.out.println(q_code.get(i));
					index.add(q_code.get(i).substring(q_code.get(i).length() - 1));
					question_code.add(q_code.get(i));
				}
			}

			for (int i = 0; i < question_code.size(); i++) {
				System.out.println("2. for");
				PreparedStatement ans = con
						
						.prepareStatement("SELECT answer FROM free_response_answer WHERE question_code = ? and username =?");
				ans.setString(1, question_code.get(i));
				ans.setString(2, username);
				allAns = ans.executeQuery();
				while (allAns.next()) {
					allAnswer.add(allAns.getString("answer"));
				}
			}

			for (int i = 0; i < allAnswer.size(); i++) {
				System.out.println("3. for");
				answer.add(index.get(i));
				answer.add(allAnswer.get(i));
			}
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	


	
	public static int calculateGrade(String courseCode, String username, String assignmentType, int assignmentNo) {

		int numOfCorrect = 0;
		int numQuest=0;

		for (int i = 0; i < 10; i++) {
			if (isFreeCorrect(courseCode, username, assignmentType, assignmentNo, i)
					|| isMultipleCorrect(courseCode, username, assignmentType, assignmentNo, i)) {
				numOfCorrect++;
			}
		}

		return numOfCorrect;
	}

	public static boolean isFreeCorrect(String courseCode, String username, String assignmentType, int assignmentNo,
			int questionNo) {

		String questionCode = "" + courseCode + assignmentType + assignmentNo + questionNo;
		
		try {
			Connection con = getConnection();

			PreparedStatement resultFree = con.prepareStatement(
					"SELECT correctness FROM free_response_answer WHERE username = ? and question_code = ?");
			resultFree.setString(1, username);
			resultFree.setString(2, questionCode);
			ResultSet freeSet = resultFree.executeQuery();
			
			while( freeSet.next() ){
				if ( (freeSet.getString("correctness")).equals("t") || (freeSet.getString("correctness")).equals("true")){
					
					return true;}
				else if ((freeSet.getString("correctness")).equals("f") || (freeSet.getString("correctness")).equals("false")){
					
					return false;
					}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static boolean isMultipleCorrect(String courseCode, String username, String assignmentType, int assignmentNo,
			int questionNo) {

		String questionCode = "" + courseCode + assignmentType + assignmentNo + questionNo;
		
		try {
			Connection con = getConnection();

			PreparedStatement resultMultiple = con.prepareStatement(
					"SELECT correctness FROM multiple_choice_answer WHERE username = ? and question_code = ?");
			resultMultiple.setString(1, username);
			resultMultiple.setString(2, questionCode);
			ResultSet multipleSet = resultMultiple.executeQuery();
			
			while( multipleSet.next() ){ 
				if ( (multipleSet.getString("correctness")).equals("t") || (multipleSet.getString("correctness")).equals("true")){
					
					return true;}
				else if ((multipleSet.getString("correctness")).equals("f") || (multipleSet.getString("correctness")).equals("false"))
				return false;
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public static ArrayList<String> getGrades(String courseCode, String assignmentType, int assignmentNo) {

		ArrayList<String> grades = new ArrayList<String>();
		try {
			ArrayList<String> students = getStudentsFromCourse(courseCode);
			String username = "";

			for (int i = 0; i < students.size(); i++) {
				username = students.get(i);
				grades.add(username);
				grades.add(Integer.toString(calculateGrade(courseCode, username, assignmentType, assignmentNo)));
			}

			return grades;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}}
