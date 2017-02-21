package gui;

import connector.*;
import Assignments.*;
import Users.*;
import Questions.*;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JRadioButton;
import javax.swing.*;

public class Gui {
	private JComboBox coursesBox;
	private JFrame mainPanel;
	private JTextField studentUserName;
	private JTextField studentPassword;
	private JTextField instructorUserName;
	private JTextField instructorPassword;
	private JPanel instructorPage;
	private JPanel loginPanel;
	private JPanel studentPage;
	private JComboBox task;
	private JTextField AquizAnswer;
	private JTextField BquizAnswer;
	private JTextField CquizAnswer;
	private JTextField DquizAnswer;
	private JTextField quizNoText;
	private JPanel newQuiz;
	private JPanel quizMulti;
	private JPanel quizOpen;
	private JPanel quizCreating;
	private JPanel instructorGroup;
	private JPanel quizBlank;
	private JComboBox kindOfQuiz;
	private JPanel homeworkPanel;
	private JPanel quizPanel;
	private JComboBox courseBox;
	private JComboBox taskNo;
	private JComboBox Quiz;
	private JPanel multipleDisplay;
	private JPanel openEndDisplay;
	private JPanel studentGroup;
	private JPanel displayPanel;
	private JPanel answerDisplayPanel;
	private JPanel gradePanel;
	private JPanel displayGrade;
	private JPanel newGradePanel;
	private JPanel quizBlank_1;
	private JTextField AassignmentAnswer;
	private JTextField BassignmentAnswer;
	private JTextField CassignmentAnswer;
	private JTextField DassignmentAnswer;
	private JTextField assignmentNo;
	private JPanel newAssignment;
	private JPanel assignmentBlank;
	private JPanel assignmentCreating;
	private JPanel assignmentOpen;
	private JPanel assignmentMulti;
	private JTextField signUserName;
	private JTextField signPassword;
	private JTextField signName;
	private JTextField signSurname;
	private JPanel displayQuestion;
	private JComboBox Assignment;
	private JTextField addCourseName;
	private JPanel addCoursePanel;
	private JPanel gradeDisplayStudent;
	private JPanel enrollCoursePanel;
	private JPanel studentSignUpPanel;
	private JTextField signDepartment;
	private JTextField trueAnswerText;
	private JTextField trueAnswerA;
	private Student studentObject;
	private Teacher instructorObject;
	private ArrayList<String> studentCourseList;
	private ArrayList<String> instructorCourseList;
	private Course selectedCourseInstructor;
	private ArrayList<MultipleChoiceQuestion> studentMultiQuestions;
	private ArrayList<FreeResponseQuestion> studentFreeQuestions;
	private ArrayList<MultipleChoiceQuestion> instructorMultiQuestions;
	private ArrayList<FreeResponseQuestion> instructorFreeQuestions;
	private ArrayList<FreeResponseQuestion> instructorGradeQuestions;
	private int qNo = 0;
	private int qNoi = 0;
	private ArrayList<String> answers;
	private JComboBox gradeCourse;
	private JLabel studentNameLabel;
	private JLabel surnameLabel;
	private JLabel instructorNameLabel;
	private JLabel instructorSurnameLabel;
	private JLabel multiQuestionLabel;
	private JLabel openQuestionLabel;
	private JRadioButton Aoption;
	private JRadioButton Boption;
	private JRadioButton Coption;
	private JRadioButton Doption;
	private JTextArea answerText;
	private JButton btnNewButton_21;
	private JButton btnNewButton_20;
	private JLabel studentGradeLabel;
	private JComboBox enrollBox;
	private JTextArea openQuestionQuiz;
	private JTextArea multiQuestionQuiz;
	private JTextArea openQuestionAssignment;
	private JTextArea multiQuestionAssignment;
	private ArrayList<String> userList;
	private JComboBox giveGradeUser;
	private int num = 0;
	private JLabel studentAnswerLabel;
	private JRadioButton trueOption;
	private JRadioButton falseOption;
	private JLabel gradeTableLabel;
	private JComboBox taskNoGrade;
	private JComboBox taskGrade;
	private JComboBox giveGradeTask;
	private JComboBox gradeBox;
	private JComboBox giveGradeTaskNo;
	private JComboBox instructorDisplayTaskNo;
	private JComboBox gradeNo;
	private JComboBox gradeTask;
	private JLabel questLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.mainPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainPanel = new JFrame();
		mainPanel.setSize(new Dimension(971, 500));
		mainPanel.setPreferredSize(new Dimension(10, 10));
		mainPanel.getContentPane().setPreferredSize(new Dimension(700, 600));
		mainPanel.getContentPane().setBackground(new Color(240, 255, 240));
		mainPanel.setBackground(Color.ORANGE);
		mainPanel.setBounds(100, 100, 1104, 500);
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.getContentPane().setLayout(new CardLayout(0, 0));
		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.getContentPane().add(loginPanel, "name_89697727010634");
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.X_AXIS));
		loginPanel.setVisible(true);
		JPanel studentLogin = new JPanel();
		loginPanel.add(studentLogin);
		studentLogin.setBackground(new Color(255, 215, 0));
		studentLogin.setForeground(new Color(255, 255, 0));
		studentLogin.setLayout(null);
		JLabel studentLable = new JLabel("Student Account");
		studentLable.setBounds(54, 11, 229, 36);
		studentLogin.add(studentLable);
		studentLable.setFont(new Font("Kristen ITC", Font.PLAIN, 26));
		studentLable.setForeground(new Color(255, 0, 0));
		studentLable.setBackground(new Color(255, 165, 0));
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (MySQLConnector.checkStudent(studentUserName.getText(), studentPassword.getText())) {
						studentObject = new Student(studentUserName.getText());
						studentNameLabel.setText(studentObject.getName());
						surnameLabel.setText(studentObject.getSurname());

						if (MySQLConnector.getCourses(studentObject) != null) {
							studentCourseList = MySQLConnector.getCourses(studentObject);
							for (int i = 0; i < studentCourseList.size(); i++) {
								courseBox.addItem(studentCourseList.get(i));
							}

						}

						loginPanel.setVisible(false);
						studentGroup.setVisible(true);
						studentPage.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Wrong UserName or Password ", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		loginButton.setBounds(232, 303, 110, 25);
		loginButton.setBackground(new Color(0, 0, 255));
		loginButton.setForeground(new Color(255, 255, 0));
		loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		studentLogin.add(loginButton);
		JLabel lblUsername = new JLabel("  User Name");
		lblUsername.setForeground(new Color(255, 0, 0));
		lblUsername.setFont(new Font("Papyrus", Font.BOLD, 22));
		lblUsername.setBounds(24, 100, 137, 56);
		studentLogin.add(lblUsername);
		JLabel lblNewLabel_1 = new JLabel(" Password");
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Papyrus", Font.BOLD, 22));
		lblNewLabel_1.setBounds(40, 199, 121, 41);
		studentLogin.add(lblNewLabel_1);
		studentUserName = new JTextField();
		studentUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentUserName.setBounds(171, 112, 171, 36);
		studentLogin.add(studentUserName);
		studentUserName.setColumns(10);
		studentPassword = new JTextField();
		studentPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentPassword.setColumns(10);
		studentPassword.setBounds(171, 199, 171, 36);
		studentLogin.add(studentPassword);
		JButton studentSignUpButton = new JButton("Sign Up");
		studentSignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				studentSignUpPanel.setVisible(true);
			}
		});
		studentSignUpButton.setBounds(24, 367, 89, 23);
		studentLogin.add(studentSignUpButton);
		JPanel instructorLogin = new JPanel();
		loginPanel.add(instructorLogin);
		instructorLogin.setBackground(new Color(0, 0, 255));
		instructorLogin.setLayout(null);
		instructorLogin.setVisible(true);
		JLabel lblNewLabel = new JLabel("Instructor Account");
		lblNewLabel.setBounds(55, 11, 246, 35);
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBackground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		instructorLogin.add(lblNewLabel);
		JButton button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MySQLConnector.checkTeacher(instructorUserName.getText(), instructorPassword.getText())) {
						instructorObject = new Teacher(instructorUserName.getText());

						instructorNameLabel.setText(instructorObject.getName());
						instructorSurnameLabel.setText(convertToLabel(instructorObject.getSurname()));

						if (MySQLConnector.getTeacherCourses(instructorObject) != null) {
							instructorCourseList = MySQLConnector.getTeacherCourses(instructorObject);
							for (int i = 0; i < instructorCourseList.size(); i++) {
								coursesBox.addItem(instructorCourseList.get(i));
							}

							loginPanel.setVisible(false);
							instructorGroup.setVisible(true);
							instructorPage.setVisible(true);
							newQuiz.setVisible(false);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Wrong UserName or Password ", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception d) {
					// TODO Auto-generated catch block
					d.printStackTrace();
				}
			}
		});

		button.setBounds(216, 302, 100, 31);
		button.setForeground(new Color(0, 0, 139));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		button.setBackground(new Color(255, 255, 0));
		instructorLogin.add(button);
		JLabel label = new JLabel("  User Name");
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("Papyrus", Font.BOLD, 22));
		label.setBounds(25, 102, 137, 56);
		instructorLogin.add(label);
		JLabel label_1 = new JLabel(" Password");
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setFont(new Font("Papyrus", Font.BOLD, 22));
		label_1.setBackground(Color.RED);
		label_1.setBounds(41, 200, 121, 41);
		instructorLogin.add(label_1);
		instructorUserName = new JTextField();
		instructorUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		instructorUserName.setColumns(10);
		instructorUserName.setBounds(181, 114, 171, 36);
		instructorLogin.add(instructorUserName);
		instructorPassword = new JTextField();
		instructorPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		instructorPassword.setColumns(10);
		instructorPassword.setBounds(181, 200, 171, 36);
		instructorLogin.add(instructorPassword);
		JButton btnNewButton_9 = new JButton("Quiz1");
		btnNewButton_9.setBounds(40, 41, 89, 23);
		JButton btnNewButton_2 = new JButton("Homework1");
		btnNewButton_2.setBounds(40, 41, 89, 23);
		JButton button_2 = new JButton("Quiz1");
		button_2.setBounds(173, 41, 89, 23);
		JButton button_3 = new JButton("Quiz1");
		button_3.setBounds(293, 41, 89, 23);
		JButton button_4 = new JButton("Quiz1");
		button_4.setBounds(40, 99, 89, 23);
		JButton button_5 = new JButton("Quiz1");
		button_5.setBounds(293, 99, 89, 23);
		JButton button_6 = new JButton("Quiz1");
		button_6.setBounds(40, 164, 89, 23);
		JButton button_7 = new JButton("Quiz1");
		button_7.setBounds(173, 164, 89, 23);
		JButton btnQuiz = new JButton("Quiz9");
		btnQuiz.setBounds(293, 164, 89, 23);
		instructorGroup = new JPanel();
		instructorGroup.setSize(new Dimension(800, 600));
		instructorGroup.setPreferredSize(new Dimension(800, 600));
		instructorGroup.setVisible(false);
		mainPanel.getContentPane().add(instructorGroup, "name_97208112738239");
		instructorGroup.setLayout(new CardLayout(0, 0));
		instructorPage = new JPanel();
		instructorPage.setVisible(true);
		instructorGroup.add(instructorPage, "name_97276894460944");
		instructorPage.setBackground(new Color(255, 255, 0));
		instructorPage.setForeground(new Color(0, 0, 0));
		instructorPage.setLayout(null);
		Assignment = new JComboBox();
		Assignment.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (Assignment.getSelectedItem() == "New Assignment") {
					instructorPage.setVisible(false);
					newAssignment.setVisible(true);
					assignmentBlank.setVisible(true);
					assignmentMulti.setVisible(false);
					assignmentOpen.setVisible(false);
					assignmentCreating.setVisible(true);
				} else if (Assignment.getSelectedItem() == "Past Assignment") {
					instructorPage.setVisible(false);
					displayQuestion.setVisible(true);
				}
			}
		});
		Assignment.setOpaque(false);
		Assignment.setBackground(new Color(0, 255, 255));
		Assignment.setForeground(new Color(0, 0, 0));
		Assignment.setFont(new Font("Constantia", Font.ITALIC, 18));
		Assignment
				.setModel(new DefaultComboBoxModel(new String[] { "Assignment", "New Assignment", "Past Assignment" }));
		Assignment.setToolTipText("Assignment\r\n");
		Assignment.setBounds(127, 95, 177, 27);
		instructorPage.add(Assignment);
		gradeBox = new JComboBox();
		gradeBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				if (gradeBox.getSelectedItem() == "Student Grades") {
					instructorPage.setVisible(false);
					gradePanel.setVisible(true);
					displayGrade.setVisible(true);
					newGradePanel.setVisible(false);
				} else if (gradeBox.getSelectedItem() == "New") {

					userList = MySQLConnector.getStudentsFromCourse(String.valueOf(coursesBox.getSelectedItem()));
					int a = userList.size();
					if (num == 0) {
						for (int i = 0; i < a; i++) {
							giveGradeUser.addItem(userList.get(i));
						}
					}
					num++;

					instructorPage.setVisible(false);
					gradePanel.setVisible(true);
					newGradePanel.setVisible(true);
					displayGrade.setVisible(false);
				}

			}
		});
		gradeBox.setBackground(new Color(0, 255, 255));
		JLabel lblNewLabel_2 = new JLabel("    Instructor Page");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 21));
		lblNewLabel_2.setBounds(250, 13, 306, 61);
		instructorPage.add(lblNewLabel_2);
		gradeBox.setFont(new Font("Constantia", Font.ITALIC, 18));
		gradeBox.setModel(new DefaultComboBoxModel(new String[] { "Grades", "Student Grades", "New" }));
		gradeBox.setBounds(563, 95, 177, 27);
		instructorPage.add(gradeBox);
		Quiz = new JComboBox();
		Quiz.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (Quiz.getSelectedItem() == "New Quiz") {
					instructorPage.setVisible(false);
					newQuiz.setVisible(true);
					quizBlank_1.setVisible(true);
					quizMulti.setVisible(false);
					quizOpen.setVisible(false);
					quizCreating.setVisible(true);
				} else if (Quiz.getSelectedItem() == "Past Quiz") {
					instructorPage.setVisible(false);
					displayQuestion.setVisible(true);
				}
			}
		});
		Quiz.setModel(new DefaultComboBoxModel(new String[] { "Quiz", "New Quiz", "Past Quiz" }));
		Quiz.setToolTipText("\r\n");
		Quiz.setForeground(Color.BLACK);
		Quiz.setFont(new Font("Constantia", Font.ITALIC, 18));
		Quiz.setBackground(new Color(0, 255, 255));
		Quiz.setBounds(347, 95, 185, 27);
		instructorPage.add(Quiz);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(380, 242, 382, 178);
		instructorPage.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("Information ");
		lblNewLabel_3.setBounds(109, 11, 184, 44);
		lblNewLabel_3.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		panel.add(lblNewLabel_3);
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		lblSurname.setBounds(10, 113, 121, 32);
		panel.add(lblSurname);
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		lblName.setBounds(10, 58, 91, 44);
		panel.add(lblName);
		instructorNameLabel = new JLabel();
		instructorNameLabel.setForeground(new Color(139, 0, 0));
		instructorNameLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		instructorNameLabel.setBounds(119, 66, 91, 25);
		panel.add(instructorNameLabel);
		instructorSurnameLabel = new JLabel("Surname");
		instructorSurnameLabel.setForeground(new Color(139, 0, 0));
		instructorSurnameLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		instructorSurnameLabel.setBounds(142, 113, 91, 25);
		panel.add(instructorSurnameLabel);
		JButton btnLogout = new JButton("Log-Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructorGroup.setVisible(false);
				loginPanel.setVisible(true);
				instructorUserName.setText("");
				instructorPassword.setText("");
				instructorNameLabel.setText("");
				instructorSurnameLabel.setText("");
				try {
					instructorCourseList = MySQLConnector.getTeacherCourses(instructorObject);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int a = coursesBox.getItemCount();
				for (int i = 0; i < a; i++) {
					coursesBox.removeItem(instructorCourseList.get(i));
				}
			}
		});
		btnLogout.setBounds(664, 13, 126, 43);
		instructorPage.add(btnLogout);
		coursesBox = new JComboBox();
		coursesBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblNewLabel_2.setText(String.valueOf(coursesBox.getSelectedItem()));
			}
		});
		coursesBox.setBounds(10, 95, 85, 27);
		instructorPage.add(coursesBox);
		JButton btnNewButton_8 = new JButton("Add Course ");
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructorPage.setVisible(false);
				addCoursePanel.setVisible(true);
			}
		});
		btnNewButton_8.setForeground(Color.RED);
		btnNewButton_8.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		btnNewButton_8.setBounds(26, 292, 177, 49);
		instructorPage.add(btnNewButton_8);

		newQuiz = new JPanel();
		newQuiz.setVisible(false);
		newQuiz.setLayout(null);
		newQuiz.setBackground(Color.GREEN);
		instructorGroup.add(newQuiz, "name_99049466063304");

		JLabel lblNewQuiz = new JLabel("New Quiz");
		lblNewQuiz.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewQuiz.setBounds(258, 25, 237, 46);
		newQuiz.add(lblNewQuiz);

		kindOfQuiz = new JComboBox();
		kindOfQuiz.setEnabled(false);
		kindOfQuiz.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				if (kindOfQuiz.getSelectedItem() == "Open Ended Question") {
					quizOpen.setVisible(true);
					quizCreating.setVisible(false);
					quizMulti.setVisible(false);
				}

				else if (kindOfQuiz.getSelectedItem() == "Multiple Choices Question") {
					quizMulti.setVisible(true);
					quizOpen.setVisible(false);
					quizCreating.setVisible(false);
				}

			}
		});

		kindOfQuiz.setModel(
				new DefaultComboBoxModel(new String[] { "Open Ended Question", "Multiple Choices Question" }));
		kindOfQuiz.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		kindOfQuiz.setBounds(36, 107, 231, 38);
		newQuiz.add(kindOfQuiz);

		quizBlank_1 = new JPanel();
		quizBlank_1.setVisible(true);
		quizBlank_1.setBounds(0, 156, 803, 276);
		newQuiz.add(quizBlank_1);
		quizBlank_1.setLayout(new CardLayout(0, 0));

		quizCreating = new JPanel();
		quizCreating.setVisible(true);
		quizCreating.setLayout(null);
		quizCreating.setBackground(Color.CYAN);
		quizBlank_1.add(quizCreating, "name_99339471617053");

		JLabel lblDueDate = new JLabel("Due Date :");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDueDate.setBounds(37, 32, 180, 52);
		quizCreating.add(lblDueDate);

		JComboBox dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayBox.setBounds(227, 46, 155, 36);
		quizCreating.add(dayBox);

		JLabel label_12 = new JLabel("DAY");
		label_12.setBounds(285, 21, 46, 14);
		quizCreating.add(label_12);

		JComboBox monthBox = new JComboBox();
		monthBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		monthBox.setBounds(425, 48, 142, 36);
		quizCreating.add(monthBox);

		JLabel label_13 = new JLabel("MONTH");
		label_13.setBounds(467, 21, 46, 14);
		quizCreating.add(label_13);

		JComboBox yearBox = new JComboBox();
		yearBox.setModel(new DefaultComboBoxModel(new String[] { "2016", "2017", "2018", "2019" }));
		yearBox.setBounds(602, 48, 142, 33);
		quizCreating.add(yearBox);

		JLabel label_14 = new JLabel("YEAR");
		label_14.setBounds(648, 21, 46, 14);
		quizCreating.add(label_14);

		JComboBox hourBox = new JComboBox();
		hourBox.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
		hourBox.setBounds(321, 117, 155, 36);
		quizCreating.add(hourBox);

		JComboBox minuteBox = new JComboBox();
		minuteBox.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15" }));
		minuteBox.setBounds(551, 117, 155, 36);
		quizCreating.add(minuteBox);

		JLabel label_15 = new JLabel("HOUR");
		label_15.setBounds(382, 95, 46, 14);
		quizCreating.add(label_15);

		JLabel label_16 = new JLabel("MINUTE");
		label_16.setBounds(612, 92, 46, 14);
		quizCreating.add(label_16);

		JLabel quizNo = new JLabel("QUIZ NO:");
		quizNo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		quizNo.setBounds(37, 205, 180, 36);
		quizCreating.add(quizNo);

		quizNoText = new JTextField();
		quizNoText.setColumns(10);
		quizNoText.setBounds(245, 205, 108, 31);
		quizCreating.add(quizNoText);

		JButton button_15 = new JButton("START");
		button_15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				kindOfQuiz.setEnabled(true);

				if (kindOfQuiz.getSelectedItem() == "Open Ended Question") {
					quizOpen.setVisible(true);
					quizCreating.setVisible(false);
					quizMulti.setVisible(false);
				}

				else if (kindOfQuiz.getSelectedItem() == "Multiple Choices Question") {
					quizMulti.setVisible(true);
					quizOpen.setVisible(false);
					quizCreating.setVisible(false);
				}

			}
		});
		button_15.setBounds(648, 216, 124, 36);
		quizCreating.add(button_15);

		quizOpen = new JPanel();
		quizOpen.setVisible(false);
		quizOpen.setLayout(null);
		quizOpen.setForeground(Color.BLACK);
		quizOpen.setBackground(Color.CYAN);
		quizBlank_1.add(quizOpen, "name_99310445372200");

		JLabel label_9 = new JLabel("QUESTION");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		label_9.setBounds(141, 21, 208, 27);
		quizOpen.add(label_9);

		JButton button_11 = new JButton("NEXT");
		button_11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FreeResponseQuestion postedQuestion = new FreeResponseQuestion(openQuestionQuiz.getText(),
						String.valueOf(coursesBox.getSelectedItem()), qNoi, Integer.parseInt(quizNoText.getText()),
						"Quiz");
				try {
					MySQLConnector.postFreeResponseQuestion(postedQuestion);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qNoi++;
				openQuestionQuiz.setText("");

			}
		});
		button_11.setBounds(595, 90, 144, 44);
		quizOpen.add(button_11);

		JButton button_12 = new JButton("FINISH");
		button_12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				qNoi = 0;

				Quiz.setSelectedItem("Quiz");

				quizOpen.setVisible(false);

				quizMulti.setVisible(false);

				quizCreating.setVisible(false);

				quizBlank_1.setVisible(false);

				newQuiz.setVisible(false);

				instructorPage.setVisible(true);

			}
		});
		button_12.setBounds(595, 177, 144, 53);
		quizOpen.add(button_12);

		openQuestionQuiz = new JTextArea();
		openQuestionQuiz.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		openQuestionQuiz.setBounds(45, 90, 304, 140);
		quizOpen.add(openQuestionQuiz);

		quizMulti = new JPanel();
		quizMulti.setVisible(false);
		quizMulti.setLayout(null);
		quizMulti.setBackground(Color.CYAN);
		quizBlank_1.add(quizMulti, "name_99310427147627");

		AquizAnswer = new JTextField();
		AquizAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		AquizAnswer.setColumns(10);
		AquizAnswer.setBounds(395, 14, 267, 37);
		quizMulti.add(AquizAnswer);

		JLabel label_8 = new JLabel("QUESTION");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		label_8.setBounds(103, 17, 128, 27);
		quizMulti.add(label_8);

		BquizAnswer = new JTextField();
		BquizAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		BquizAnswer.setColumns(10);
		BquizAnswer.setBounds(395, 62, 267, 45);
		quizMulti.add(BquizAnswer);

		CquizAnswer = new JTextField();
		CquizAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		CquizAnswer.setColumns(10);
		CquizAnswer.setBounds(395, 118, 267, 45);
		quizMulti.add(CquizAnswer);

		DquizAnswer = new JTextField();
		DquizAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		DquizAnswer.setColumns(10);
		DquizAnswer.setBounds(395, 174, 267, 44);
		quizMulti.add(DquizAnswer);

		JButton button_9 = new JButton("NEXT\r\n");
		button_9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MultipleChoiceQuestion postedQuestion2 = new MultipleChoiceQuestion(multiQuestionQuiz.getText(),
						String.valueOf(coursesBox.getSelectedItem()), qNoi, Integer.parseInt(quizNoText.getText()),
						"Quiz", Integer.parseInt(trueAnswerText.getText()), AquizAnswer.getText(),
						BquizAnswer.getText(), CquizAnswer.getText(), DquizAnswer.getText());
				try {
					MySQLConnector.postMultipleChoiceQuestion(postedQuestion2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qNoi++;
				multiQuestionQuiz.setText("");
				AquizAnswer.setText("");
				BquizAnswer.setText("");
				CquizAnswer.setText("");
				DquizAnswer.setText("");
				trueAnswerText.setText("");

			}
		});
		button_9.setBounds(672, 66, 101, 37);
		quizMulti.add(button_9);

		JButton button_10 = new JButton("FINISH");
		button_10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				qNoi = 0;

				Quiz.setSelectedItem("Quiz");

				quizOpen.setVisible(false);

				quizMulti.setVisible(false);

				quizCreating.setVisible(false);

				quizBlank_1.setVisible(false);

				instructorPage.setVisible(true);

				newQuiz.setVisible(false);

			}
		});
		button_10.setBounds(672, 140, 101, 37);
		quizMulti.add(button_10);

		multiQuestionQuiz = new JTextArea();
		multiQuestionQuiz.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		multiQuestionQuiz.setBounds(37, 80, 299, 138);
		quizMulti.add(multiQuestionQuiz);

		JLabel lblNewLabel_5 = new JLabel("True answer :\r\n(0,1,2,3)");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(405, 223, 151, 47);
		quizMulti.add(lblNewLabel_5);

		trueAnswerText = new JTextField();
		trueAnswerText.setBounds(566, 229, 86, 36);
		quizMulti.add(trueAnswerText);
		trueAnswerText.setColumns(10);

		JButton btnNewButton_11 = new JButton("BACK");
		btnNewButton_11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				qNoi = 0;
				newQuiz.setVisible(false);

				instructorPage.setVisible(true);

				Quiz.setSelectedItem("Quiz");

			}
		});
		btnNewButton_11.setBounds(10, 25, 117, 46);
		newQuiz.add(btnNewButton_11);

		gradePanel = new JPanel();
		gradePanel.setVisible(false);
		instructorGroup.add(gradePanel, "name_252610178778207");
		gradePanel.setLayout(new CardLayout(0, 0));

		displayGrade = new JPanel();
		displayGrade.setVisible(false);
		displayGrade.setBackground(Color.YELLOW);
		gradePanel.add(displayGrade, "name_252658823192425");
		displayGrade.setLayout(null);

		taskGrade = new JComboBox();
		taskGrade.setModel(new DefaultComboBoxModel(new String[] { "Homework", "Quiz" }));
		taskGrade.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		taskGrade.setEnabled(true);
		taskGrade.setBounds(25, 110, 221, 43);
		displayGrade.add(taskGrade);

		taskNoGrade = new JComboBox();
		taskNoGrade
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		taskNoGrade.setForeground(Color.BLACK);
		taskNoGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taskNoGrade.setEnabled(true);
		taskNoGrade.setBounds(38, 215, 46, 43);
		displayGrade.add(taskNoGrade);

		JButton btnNewButton_12 = new JButton("Display Grades");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> gradeListesi = MySQLConnector.getGrades(String.valueOf(coursesBox.getSelectedItem()),
						String.valueOf(taskGrade.getSelectedItem()),
						Integer.valueOf(String.valueOf(taskNoGrade.getSelectedItem())));
				String text = "<html>";
				for (int i = 0; i < gradeListesi.size(); i += 2) {
					text = text + gradeListesi.get(i) + "------------------" + gradeListesi.get(i + 1) + "<br>";
				}
				text = text + "</html>";
				gradeTableLabel.setText(text);
			}
		});
		btnNewButton_12.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnNewButton_12.setBounds(110, 215, 136, 43);
		displayGrade.add(btnNewButton_12);

		gradeTableLabel = new JLabel();
		gradeTableLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		gradeTableLabel.setBounds(443, 41, 563, 318);
		displayGrade.add(gradeTableLabel);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnBack_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gradeTableLabel.setText("");
				displayGrade.setVisible(false);

				instructorPage.setVisible(true);

				gradePanel.setVisible(false);

				gradeBox.setSelectedItem("Grades");

			}
		});
		btnBack_1.setBounds(25, 11, 89, 23);
		displayGrade.add(btnBack_1);

		newGradePanel = new JPanel();
		newGradePanel.setVisible(false);
		newGradePanel.setBackground(Color.YELLOW);
		gradePanel.add(newGradePanel, "name_255853437587984");
		newGradePanel.setLayout(null);

		giveGradeTask = new JComboBox();
		giveGradeTask.setModel(new DefaultComboBoxModel(new String[] { "Quiz", "Homework" }));
		giveGradeTask.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		giveGradeTask.setBounds(36, 87, 171, 30);
		newGradePanel.add(giveGradeTask);

		giveGradeTaskNo = new JComboBox();
		giveGradeTaskNo
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		giveGradeTaskNo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		giveGradeTaskNo.setBounds(36, 158, 77, 30);
		newGradePanel.add(giveGradeTaskNo);

		giveGradeUser = new JComboBox();
		giveGradeUser.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		giveGradeUser.setModel(new DefaultComboBoxModel(new String[] { "Users" }));
		giveGradeUser.setBounds(36, 240, 171, 30);
		newGradePanel.add(giveGradeUser);

		JButton btnNewButton_13 = new JButton("Display");
		btnNewButton_13.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnNewButton_13.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					instructorGradeQuestions = MySQLConnector.getFreeResponseQuestions(
							String.valueOf(coursesBox.getSelectedItem()),
							Integer.parseInt(String.valueOf(giveGradeTaskNo.getSelectedItem())),
							String.valueOf(giveGradeTask.getSelectedItem()));

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (instructorGradeQuestions.size() > 0) {
					questLabel.setText(convertToLabel(instructorGradeQuestions.get(0).getQuestionText()));
					instructorGradeQuestions.remove(0);
				} else if (instructorGradeQuestions == null) {
					JOptionPane.showMessageDialog(null, "Wrong UserName or Password ", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
				answers = MySQLConnector.getFreeResponseAnswer(String.valueOf(coursesBox.getSelectedItem()),
						String.valueOf(giveGradeTask.getSelectedItem()),
						Integer.valueOf(String.valueOf(giveGradeTaskNo.getSelectedItem())),
						String.valueOf(giveGradeUser.getSelectedItem()));
				if (answers.size() > 0) {
					studentAnswerLabel.setText(answers.get(1));

					answerDisplayPanel.setVisible(true);
				} else if (answers == null) {
					JOptionPane.showMessageDialog(null, "Wrong UserName or Password ", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnNewButton_13.setBounds(131, 324, 104, 23);
		newGradePanel.add(btnNewButton_13);

		JButton btnBack_2 = new JButton("Back");
		btnBack_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnBack_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int a = userList.size();
				num = 0;
				for (int i = 0; i < a; i++) {
					giveGradeUser.removeItem(userList.get(i));
				}

				newGradePanel.setVisible(false);

				instructorPage.setVisible(true);

				gradePanel.setVisible(false);

				gradeBox.setSelectedItem("Grades");

				answerDisplayPanel.setVisible(false);

			}
		});
		btnBack_2.setBounds(21, 11, 89, 23);
		newGradePanel.add(btnBack_2);

		answerDisplayPanel = new JPanel();
		answerDisplayPanel.setVisible(false);
		answerDisplayPanel.setBackground(Color.YELLOW);
		answerDisplayPanel.setBounds(308, 11, 406, 403);
		newGradePanel.add(answerDisplayPanel);
		answerDisplayPanel.setLayout(null);

		studentAnswerLabel = new JLabel();
		studentAnswerLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		studentAnswerLabel.setBounds(49, 196, 328, 103);
		answerDisplayPanel.add(studentAnswerLabel);

		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (instructorGradeQuestions.size() > 0) {
					questLabel.setText(instructorGradeQuestions.get(0).getQuestionText());
					instructorGradeQuestions.remove(0);
				}

				else {
					questLabel.setText("Finish");
				}
				if (answers.size() >= 2) {
					Student student = new Student(String.valueOf(giveGradeUser.getSelectedItem()));
					String questionCode = String.valueOf(coursesBox.getSelectedItem())
							+ String.valueOf(giveGradeTask.getSelectedItem())
							+ Integer.valueOf(String.valueOf(giveGradeTaskNo.getSelectedItem()))
							+ Integer.parseInt(answers.get(0));
					if (trueOption.isSelected()) {
						try {
							MySQLConnector.checkToFreeResponse(questionCode, student, true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (falseOption.isSelected()) {
						try {
							MySQLConnector.checkToFreeResponse(questionCode, student, false);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				if (answers.size() > 2) {
					answers.remove(0);
					answers.remove(0);
					studentAnswerLabel.setText(answers.get(1));
				} else {
					studentAnswerLabel.setText("Finish");
				}

			}
		});
		Next.setBounds(267, 335, 110, 41);
		answerDisplayPanel.add(Next);

		trueOption = new JRadioButton("True");
		trueOption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		trueOption.setBounds(25, 344, 109, 23);
		answerDisplayPanel.add(trueOption);

		falseOption = new JRadioButton("False");
		falseOption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		falseOption.setBounds(143, 344, 109, 23);
		answerDisplayPanel.add(falseOption);
		ButtonGroup gb = new ButtonGroup();
		gb.add(trueOption);
		gb.add(falseOption);

		questLabel = new JLabel("New label");
		questLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		questLabel.setBounds(49, 47, 312, 98);
		answerDisplayPanel.add(questLabel);

		newAssignment = new JPanel();
		newAssignment.setVisible(false);
		newAssignment.setBackground(Color.YELLOW);
		instructorGroup.add(newAssignment, "name_265816478469972");
		newAssignment.setLayout(null);

		JLabel lblNewAssignment = new JLabel("New Assignment");
		lblNewAssignment.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewAssignment.setBounds(276, 7, 237, 46);
		newAssignment.add(lblNewAssignment);

		JComboBox kindOfAssignment = new JComboBox();
		kindOfAssignment.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				if (kindOfAssignment.getSelectedItem() == "Open Ended Question") {
					assignmentOpen.setVisible(true);
					assignmentCreating.setVisible(false);
					assignmentMulti.setVisible(false);
				}

				else if (kindOfAssignment.getSelectedItem() == "Multiple Choices Question") {
					assignmentMulti.setVisible(true);
					assignmentOpen.setVisible(false);
					assignmentCreating.setVisible(false);
				}

			}
		});
		kindOfAssignment.setModel(
				new DefaultComboBoxModel(new String[] { "Open Ended Question", "Multiple Choices Question" }));
		kindOfAssignment.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		kindOfAssignment.setEnabled(false);
		kindOfAssignment.setBounds(10, 94, 231, 38);
		newAssignment.add(kindOfAssignment);

		assignmentBlank = new JPanel();
		assignmentBlank.setBounds(0, 165, 803, 267);
		newAssignment.add(assignmentBlank);
		assignmentBlank.setLayout(new CardLayout(0, 0));

		assignmentCreating = new JPanel();
		assignmentCreating.setVisible(true);
		assignmentCreating.setBackground(Color.CYAN);
		assignmentBlank.add(assignmentCreating, "name_272889934326284");
		assignmentCreating.setLayout(null);

		JLabel label_18 = new JLabel("Post Date :");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_18.setBounds(10, 11, 180, 52);
		assignmentCreating.add(label_18);

		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_12.setBounds(240, 33, 155, 36);
		assignmentCreating.add(comboBox_12);

		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(438, 33, 155, 36);
		assignmentCreating.add(comboBox_13);

		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(623, 33, 155, 36);
		assignmentCreating.add(comboBox_14);

		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.setBounds(323, 110, 155, 36);
		assignmentCreating.add(comboBox_15);

		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setBounds(535, 110, 155, 36);
		assignmentCreating.add(comboBox_16);

		assignmentNo = new JTextField();
		assignmentNo.setColumns(10);
		assignmentNo.setBounds(230, 193, 108, 31);
		assignmentCreating.add(assignmentNo);

		JLabel label_19 = new JLabel("DAY");
		label_19.setBounds(292, 11, 46, 14);
		assignmentCreating.add(label_19);

		JLabel lblMonth_1 = new JLabel("MONTH");
		lblMonth_1.setBounds(502, 11, 46, 14);
		assignmentCreating.add(lblMonth_1);

		JLabel lblYear_1 = new JLabel("YEAR");
		lblYear_1.setBounds(673, 8, 46, 14);
		assignmentCreating.add(lblYear_1);

		JLabel lblHour_1 = new JLabel("HOUR");
		lblHour_1.setBounds(378, 85, 46, 14);
		assignmentCreating.add(lblHour_1);

		JLabel lblMnute_1 = new JLabel("MINUTE");
		lblMnute_1.setBounds(587, 85, 46, 14);
		assignmentCreating.add(lblMnute_1);

		JLabel lblAssgnmentNo = new JLabel("ASSIGNMENT NO :");
		lblAssgnmentNo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblAssgnmentNo.setBounds(22, 187, 185, 36);
		assignmentCreating.add(lblAssgnmentNo);

		JButton button_19 = new JButton("START");
		button_19.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				kindOfAssignment.setEnabled(true);

				if (kindOfAssignment.getSelectedItem() == "Open Ended Question") {
					assignmentOpen.setVisible(true);
					assignmentCreating.setVisible(false);
					quizMulti.setVisible(false);
				}

				else if (kindOfAssignment.getSelectedItem() == "Multiple Choices Question") {
					quizMulti.setVisible(true);
					quizOpen.setVisible(false);
					quizCreating.setVisible(false);
				}

			}
		});
		button_19.setBounds(626, 197, 124, 36);
		assignmentCreating.add(button_19);

		assignmentOpen = new JPanel();
		assignmentOpen.setVisible(false);
		assignmentOpen.setBackground(Color.CYAN);
		assignmentBlank.add(assignmentOpen, "name_272886628101937");
		assignmentOpen.setLayout(null);

		JLabel label_7 = new JLabel("QUESTION");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		label_7.setBounds(10, 11, 208, 27);
		assignmentOpen.add(label_7);

		JButton button_17 = new JButton("NEXT\r\n");
		button_17.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FreeResponseQuestion postedQuestion3 = new FreeResponseQuestion(openQuestionAssignment.getText(),
						String.valueOf(coursesBox.getSelectedItem()), qNoi, Integer.parseInt(assignmentNo.getText()),
						"Homework");
				try {
					MySQLConnector.postFreeResponseQuestion(postedQuestion3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qNoi++;
				openQuestionAssignment.setText("");

			}
		});
		button_17.setBounds(494, 96, 129, 40);
		assignmentOpen.add(button_17);

		JButton button_18 = new JButton("FINISH");
		button_18.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				qNoi = 0;

				Assignment.setSelectedItem("Assignment");

				assignmentOpen.setVisible(false);

				assignmentMulti.setVisible(false);

				assignmentCreating.setVisible(false);

				assignmentBlank.setVisible(false);

				instructorPage.setVisible(true);

				newAssignment.setVisible(false);

			}
		});
		button_18.setBounds(494, 158, 129, 40);
		assignmentOpen.add(button_18);

		openQuestionAssignment = new JTextArea();
		openQuestionAssignment.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		openQuestionAssignment.setBounds(42, 76, 295, 140);
		assignmentOpen.add(openQuestionAssignment);

		assignmentMulti = new JPanel();
		assignmentMulti.setVisible(false);
		assignmentMulti.setBackground(Color.CYAN);
		assignmentBlank.add(assignmentMulti, "name_272882659525643");
		assignmentMulti.setLayout(null);

		JLabel label_6 = new JLabel("QUESTION");
		label_6.setBounds(37, 11, 102, 26);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		assignmentMulti.add(label_6);

		AassignmentAnswer = new JTextField();
		AassignmentAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		AassignmentAnswer.setColumns(10);
		AassignmentAnswer.setBounds(409, 27, 267, 37);
		assignmentMulti.add(AassignmentAnswer);

		BassignmentAnswer = new JTextField();
		BassignmentAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		BassignmentAnswer.setColumns(10);
		BassignmentAnswer.setBounds(409, 75, 267, 37);
		assignmentMulti.add(BassignmentAnswer);

		CassignmentAnswer = new JTextField();
		CassignmentAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		CassignmentAnswer.setColumns(10);
		CassignmentAnswer.setBounds(409, 123, 267, 37);
		assignmentMulti.add(CassignmentAnswer);

		DassignmentAnswer = new JTextField();
		DassignmentAnswer.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		DassignmentAnswer.setColumns(10);
		DassignmentAnswer.setBounds(409, 174, 267, 37);
		assignmentMulti.add(DassignmentAnswer);

		JButton button_16 = new JButton("NEXT\r\n");
		button_16.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MultipleChoiceQuestion postedQuestion4 = new MultipleChoiceQuestion(multiQuestionAssignment.getText(),
						String.valueOf(coursesBox.getSelectedItem()), qNoi, Integer.parseInt(assignmentNo.getText()),
						"Homework", Integer.parseInt(trueAnswerA.getText()), AassignmentAnswer.getText(),
						BassignmentAnswer.getText(), CassignmentAnswer.getText(), DassignmentAnswer.getText());
				try {
					MySQLConnector.postMultipleChoiceQuestion(postedQuestion4);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				qNoi++;
				multiQuestionAssignment.setText("");
				AassignmentAnswer.setText("");
				BassignmentAnswer.setText("");
				CassignmentAnswer.setText("");
				DassignmentAnswer.setText("");
				trueAnswerA.setText("");

			}
		});
		button_16.setBounds(692, 96, 101, 34);
		assignmentMulti.add(button_16);

		JButton btnFinish = new JButton("FINISH");
		btnFinish.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Assignment.setSelectedItem("Assignment");
				qNoi = 0;

				assignmentOpen.setVisible(false);

				assignmentMulti.setVisible(false);

				assignmentCreating.setVisible(false);

				assignmentBlank.setVisible(false);

				instructorPage.setVisible(true);

				newAssignment.setVisible(false);

			}
		});
		btnFinish.setBounds(692, 160, 101, 34);
		assignmentMulti.add(btnFinish);

		multiQuestionAssignment = new JTextArea();
		multiQuestionAssignment.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		multiQuestionAssignment.setBounds(25, 71, 295, 140);
		assignmentMulti.add(multiQuestionAssignment);

		JLabel label_5 = new JLabel("True answer :\r\n(0,1,2,3)");
		label_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		label_5.setBounds(409, 222, 151, 47);
		assignmentMulti.add(label_5);

		trueAnswerA = new JTextField();
		trueAnswerA.setBounds(559, 230, 86, 26);
		assignmentMulti.add(trueAnswerA);
		trueAnswerA.setColumns(10);

		JButton button_14 = new JButton("BACK");
		button_14.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				qNoi = 0;
				newAssignment.setVisible(false);

				instructorPage.setVisible(true);

				Assignment.setSelectedItem("Assignment");

			}
		});
		button_14.setBounds(10, 11, 117, 46);
		newAssignment.add(button_14);

		displayQuestion = new JPanel();
		displayQuestion.setVisible(false);
		displayQuestion.setBackground(Color.CYAN);
		instructorGroup.add(displayQuestion, "name_338468502991061");
		displayQuestion.setLayout(null);

		JLabel labelQuestion = new JLabel();
		labelQuestion.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		labelQuestion.setBounds(34, 143, 458, 228);
		displayQuestion.add(labelQuestion);

		JButton button_8 = new JButton("Back");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				displayQuestion.setVisible(false);

				instructorPage.setVisible(true);

				Quiz.setSelectedItem("Quiz");

				Assignment.setSelectedItem("Assignment");

			}
		});
		button_8.setBounds(613, 28, 133, 44);
		displayQuestion.add(button_8);

		JLabel label_20 = new JLabel("QUESTION");
		label_20.setForeground(Color.RED);
		label_20.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		label_20.setBounds(34, 36, 191, 44);
		displayQuestion.add(label_20);

		JButton button_20 = new JButton("Next");
		button_20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (instructorMultiQuestions.size() > 0) {
					labelQuestion.setText(instructorMultiQuestions.get(0).getQuestionText());
					instructorMultiQuestions.remove(0);
				} else if (instructorFreeQuestions.size() > 0) {
					labelQuestion.setText(instructorFreeQuestions.get(0).getQuestionText());
					instructorFreeQuestions.remove(0);
				} else {
					labelQuestion.setText("Finish");
				}

			}
		});
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_20.setBounds(613, 321, 133, 50);
		displayQuestion.add(button_20);

		instructorDisplayTaskNo = new JComboBox();
		instructorDisplayTaskNo
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		instructorDisplayTaskNo.setBounds(339, 37, 71, 30);
		displayQuestion.add(instructorDisplayTaskNo);

		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Assignment.getSelectedItem().equals("Past Assignment")) {
					try {
						instructorMultiQuestions = MySQLConnector.getMultipleChoiceQuestions(
								String.valueOf(coursesBox.getSelectedItem()),
								Integer.parseInt(String.valueOf(instructorDisplayTaskNo.getSelectedItem())),
								"Homework");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						instructorFreeQuestions = MySQLConnector.getFreeResponseQuestions(
								String.valueOf(coursesBox.getSelectedItem()),
								Integer.valueOf(String.valueOf(instructorDisplayTaskNo.getSelectedItem())), "Homework");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else if (String.valueOf(Quiz.getSelectedItem()).equals("Past Quiz")) {
					try {
						instructorMultiQuestions = MySQLConnector.getMultipleChoiceQuestions(
								String.valueOf(coursesBox.getSelectedItem()),
								Integer.valueOf(String.valueOf(instructorDisplayTaskNo.getSelectedItem())), "Quiz");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						instructorFreeQuestions = MySQLConnector.getFreeResponseQuestions(
								String.valueOf(coursesBox.getSelectedItem()),
								Integer.valueOf(String.valueOf(instructorDisplayTaskNo.getSelectedItem())), "Quiz");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				if (instructorMultiQuestions.size() > 0) {
					labelQuestion.setText(convertToLabel(instructorMultiQuestions.get(0).getQuestionText()));
					instructorMultiQuestions.remove(0);
				} else if (instructorFreeQuestions.size() > 0) {
					labelQuestion.setText(convertToLabel(instructorFreeQuestions.get(0).getQuestionText()));
					instructorFreeQuestions.remove(0);
				} else {
					labelQuestion.setText("Finish");
				}
			}
		});
		btnNewButton.setBounds(443, 41, 89, 23);
		displayQuestion.add(btnNewButton);

		addCoursePanel = new JPanel();
		addCoursePanel.setVisible(false);
		addCoursePanel.setBackground(Color.YELLOW);
		addCoursePanel.setForeground(Color.WHITE);
		instructorGroup.add(addCoursePanel, "name_346820661638888");
		addCoursePanel.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Add New Course");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_7.setBounds(280, 11, 426, 57);
		addCoursePanel.add(lblNewLabel_7);

		addCourseName = new JTextField();
		addCourseName.setBounds(250, 135, 203, 47);
		addCoursePanel.add(addCourseName);
		addCourseName.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("COURSE NAME :");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblNewLabel_8.setBounds(82, 134, 145, 47);
		addCoursePanel.add(lblNewLabel_8);

		JButton btnNewButton_10 = new JButton("Add New Course");
		btnNewButton_10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnector.createCourse(instructorObject, addCourseName.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				coursesBox.addItem(addCourseName.getText());
			}
		});
		btnNewButton_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton_10.setBounds(537, 137, 169, 41);
		addCoursePanel.add(btnNewButton_10);

		JButton btnNewButton_14 = new JButton("Back");
		btnNewButton_14.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				addCourseName.setText("");
				instructorPage.setVisible(true);

				addCoursePanel.setVisible(false);

			}
		});
		btnNewButton_14.setBounds(10, 11, 102, 31);
		addCoursePanel.add(btnNewButton_14);

		studentGroup = new JPanel();
		studentGroup.setVisible(false);
		mainPanel.getContentPane().add(studentGroup, "name_248291222256914");
		studentGroup.setLayout(new CardLayout(0, 0));

		studentPage = new JPanel();
		studentGroup.add(studentPage, "name_248497251779673");
		studentPage.setBackground(new Color(255, 255, 0));
		studentPage.setLayout(null);
		studentPage.setVisible(false);

		JLabel lblStudentPage = new JLabel("    Student Page");
		lblStudentPage.setForeground(Color.RED);
		lblStudentPage.setFont(new Font("Kristen ITC", Font.BOLD, 21));
		lblStudentPage.setBounds(243, 11, 306, 61);
		studentPage.add(lblStudentPage);

		courseBox = new JComboBox();
		courseBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				task.setEnabled(true);

			}
		});

		courseBox.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		courseBox.setBounds(37, 100, 221, 43);
		studentPage.add(courseBox);

		JButton button_1 = new JButton("Log-Out");
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int a = courseBox.getItemCount();
				try {
					studentCourseList = studentCourseList = MySQLConnector.getCourses(studentObject);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < a; i++) {

					courseBox.removeItem(studentCourseList.get(i));
				}

				studentNameLabel.setText("");
				surnameLabel.setText("");
				studentUserName.setText("");
				studentPassword.setText("");
				studentGroup.setVisible(false);

				displayPanel.setVisible(false);

				studentPage.setVisible(false);

				loginPanel.setVisible(true);

				studentUserName.setText("");

				studentPassword.setText("");

			}
		});
		button_1.setBounds(646, 24, 134, 43);
		studentPage.add(button_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(514, 209, 281, 213);
		studentPage.add(panel_2);

		JLabel label_2 = new JLabel("Information ");
		label_2.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		label_2.setBounds(51, 11, 184, 44);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Surname:");
		label_3.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		label_3.setBounds(10, 119, 121, 32);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("Name:");
		label_4.setFont(new Font("Kristen ITC", Font.BOLD, 23));
		label_4.setBounds(10, 58, 91, 44);
		panel_2.add(label_4);

		studentNameLabel = new JLabel("Name");
		studentNameLabel.setForeground(new Color(139, 0, 0));
		studentNameLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		studentNameLabel.setBounds(119, 66, 150, 25);
		panel_2.add(studentNameLabel);

		surnameLabel = new JLabel("Surname");
		surnameLabel.setForeground(new Color(139, 0, 0));
		surnameLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		surnameLabel.setBounds(141, 126, 128, 25);
		panel_2.add(surnameLabel);

		task = new JComboBox();
		task.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				taskNo.setEnabled(true);

				task.setEnabled(true);

			}
		});
		task.setBounds(37, 182, 221, 43);
		studentPage.add(task);
		task.setEnabled(false);

		task.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		task.setModel(new DefaultComboBoxModel(new String[] { "Homework", "Quiz" }));
		task.setEnabled(false);

		taskNo = new JComboBox();
		taskNo.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

			}
		});
		taskNo.setEnabled(true);
		taskNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taskNo.setForeground(new Color(0, 0, 0));
		taskNo.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		taskNo.setBounds(37, 265, 46, 43);
		studentPage.add(taskNo);

		JButton display = new JButton("START");
		display.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_21.setEnabled(true);
				btnNewButton_20.setEnabled(true);
				if (MySQLConnector.calculateGrade(String.valueOf(courseBox.getSelectedItem()),
						studentObject.getUsername(), String.valueOf(task.getSelectedItem()),
						Integer.parseInt(String.valueOf(taskNo.getSelectedItem()))) == 0
						|| (String.valueOf(task.getSelectedItem())).equals("Homework")) {
					try {
						if (MySQLConnector.getMultipleChoiceQuestions(String.valueOf(courseBox.getSelectedItem()),
								Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
								String.valueOf(task.getSelectedItem())) != null) {
							studentMultiQuestions = MySQLConnector.getMultipleChoiceQuestions(
									String.valueOf(courseBox.getSelectedItem()),
									Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
									String.valueOf(task.getSelectedItem()));
						} else {
							JOptionPane.showMessageDialog(null, " There is no assignment or quiz in this index ",
									"Error", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if (MySQLConnector.getFreeResponseQuestions(String.valueOf(courseBox.getSelectedItem()),
								Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
								String.valueOf(task.getSelectedItem())) != null) {
							studentFreeQuestions = MySQLConnector.getFreeResponseQuestions(
									String.valueOf(courseBox.getSelectedItem()),
									Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
									String.valueOf(task.getSelectedItem()));
						} else {
							JOptionPane.showMessageDialog(null, " There is no assignment or quiz in this index ",
									"Error", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if (MySQLConnector.getFreeResponseQuestions(String.valueOf(courseBox.getSelectedItem()),
								Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
								String.valueOf(task.getSelectedItem())) != null
								&& MySQLConnector.getMultipleChoiceQuestions(
										String.valueOf(courseBox.getSelectedItem()),
										Integer.parseInt(String.valueOf(taskNo.getSelectedItem())),
										String.valueOf(task.getSelectedItem())) != null) {
							if (studentMultiQuestions.get(0).getQuestionNumber() == qNo) {
								displayPanel.setVisible(true);
								multipleDisplay.setVisible(true);
								openEndDisplay.setVisible(false);
								studentPage.setVisible(false);
								multiQuestionLabel.setText(studentMultiQuestions.get(0).getQuestionText());
								Aoption.setText(convertToLabel(studentMultiQuestions.get(0).getchoiceText(0)));
								Boption.setText(convertToLabel(studentMultiQuestions.get(0).getchoiceText(1)));
								Coption.setText(convertToLabel(studentMultiQuestions.get(0).getchoiceText(2)));
								Doption.setText(convertToLabel(studentMultiQuestions.get(0).getchoiceText(3)));
								qNo++;

							}

							else if (studentFreeQuestions.get(0).getQuestionNumber() == qNo) {
								displayPanel.setVisible(true);
								multipleDisplay.setVisible(false);
								openEndDisplay.setVisible(true);
								studentPage.setVisible(false);
								openQuestionLabel
										.setText(convertToLabel(studentFreeQuestions.get(0).getQuestionText()));
								qNo++;

							}
						}
						Aoption.setEnabled(true);
						Boption.setEnabled(true);
						Coption.setEnabled(true);
						Doption.setEnabled(true);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (MySQLConnector.calculateGrade(String.valueOf(courseBox.getSelectedItem()),
						studentObject.getUsername(), String.valueOf(task.getSelectedItem()),
						Integer.parseInt(String.valueOf(taskNo.getSelectedItem()))) != 0
						&& String.valueOf(task.getSelectedItem()).equals("Quiz")) {
					JOptionPane.showMessageDialog(null, " You have already solved it ", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		display.setBounds(117, 265, 122, 43);
		studentPage.add(display);

		JButton btnNewButton_7 = new JButton("Display Grade");
		btnNewButton_7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					studentCourseList = MySQLConnector.getCourses(studentObject);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 0; i < studentCourseList.size(); i++) {
					gradeCourse.addItem(studentCourseList.get(i));
				}

				gradeDisplayStudent.setVisible(true);

				studentPage.setVisible(false);

			}
		});
		btnNewButton_7.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		btnNewButton_7.setBounds(337, 98, 134, 49);
		studentPage.add(btnNewButton_7);

		JButton btnNewButton_16 = new JButton("Enroll Course");
		btnNewButton_16.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<String> courses = MySQLConnector.getAllCourses();
				for (int i = 0; i < courses.size(); i++) {
					enrollBox.addItem(courses.get(i));
				}
				enrollCoursePanel.setVisible(true);

				studentPage.setVisible(false);

			}
		});
		btnNewButton_16.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		btnNewButton_16.setBounds(492, 97, 155, 49);
		studentPage.add(btnNewButton_16);

		displayPanel = new JPanel();
		displayPanel.setVisible(false);
		studentGroup.add(displayPanel, "name_248747712215222");
		displayPanel.setLayout(new CardLayout(0, 0));

		openEndDisplay = new JPanel();
		openEndDisplay.setVisible(false);
		displayPanel.add(openEndDisplay, "name_248773720842143");
		openEndDisplay.setVisible(false);
		openEndDisplay.setBackground(Color.YELLOW);
		openEndDisplay.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("QUESTION");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNewLabel_10.setBounds(20, 22, 191, 44);
		openEndDisplay.add(lblNewLabel_10);

		openQuestionLabel = new JLabel();
		openQuestionLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		openQuestionLabel.setBounds(30, 77, 458, 198);
		openEndDisplay.add(openQuestionLabel);

		JButton btnNewButton_5 = new JButton("Next");
		btnNewButton_5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnNewButton_20.setEnabled(true);
				if (studentFreeQuestions.size() > 0) {
					studentFreeQuestions.remove(0);
				}
				btnNewButton_21.setEnabled(true);
				openQuestionLabel.setText("");
				answerText.setText("");

				if (studentMultiQuestions.size() > 0 && studentMultiQuestions.get(0).getQuestionNumber() == qNo) {
					displayPanel.setVisible(true);
					multipleDisplay.setVisible(true);
					openEndDisplay.setVisible(false);
					multiQuestionLabel.setText(convertToLabel(studentMultiQuestions.get(0).getQuestionText()));
					Aoption.setText(studentMultiQuestions.get(0).getchoiceText(0));
					Boption.setText(studentMultiQuestions.get(0).getchoiceText(1));
					Coption.setText(studentMultiQuestions.get(0).getchoiceText(2));
					Doption.setText(studentMultiQuestions.get(0).getchoiceText(3));
					qNo++;

				}

				else if (studentFreeQuestions.size() > 0 && studentFreeQuestions.get(0).getQuestionNumber() == qNo) {
					displayPanel.setVisible(true);
					multipleDisplay.setVisible(false);
					openEndDisplay.setVisible(true);
					openQuestionLabel.setText(convertToLabel(studentFreeQuestions.get(0).getQuestionText()));
					qNo++;

				} else {

					multiQuestionLabel.setText("Finish");
					openQuestionLabel.setText("Finish");
					answerText.setText("");

				}

			}
		});
		btnNewButton_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		btnNewButton_5.setBounds(597, 171, 133, 50);
		openEndDisplay.add(btnNewButton_5);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				qNo = 0;

				displayPanel.setVisible(false);

				openEndDisplay.setVisible(false);

				multipleDisplay.setVisible(false);

				studentPage.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(608, 22, 118, 31);
		openEndDisplay.add(btnNewButton_3);

		btnNewButton_21 = new JButton("Respond");
		btnNewButton_21.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnector.postFreeResponseAnswer(studentObject, studentFreeQuestions.get(0),
							answerText.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewButton_21.setEnabled(false);
			}
		});
		btnNewButton_21.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		btnNewButton_21.setBounds(448, 323, 118, 59);
		openEndDisplay.add(btnNewButton_21);

		answerText = new JTextArea();
		answerText.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		answerText.setBounds(30, 282, 349, 132);
		openEndDisplay.add(answerText);

		multipleDisplay = new JPanel();
		multipleDisplay.setVisible(false);
		displayPanel.add(multipleDisplay, "name_248778917480290");
		multipleDisplay.setVisible(false);
		multipleDisplay.setBackground(Color.YELLOW);
		multipleDisplay.setLayout(null);

		JLabel label_10 = new JLabel("QUESTION");
		label_10.setBounds(27, 11, 191, 44);
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		multipleDisplay.add(label_10);

		multiQuestionLabel = new JLabel();
		multiQuestionLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		multiQuestionLabel.setBounds(27, 52, 555, 148);
		multipleDisplay.add(multiQuestionLabel);

		Aoption = new JRadioButton("New radio button");
		Aoption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		Aoption.setBounds(27, 221, 347, 38);
		multipleDisplay.add(Aoption);

		Boption = new JRadioButton("New radio button");
		Boption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		Boption.setBounds(27, 272, 347, 38);
		multipleDisplay.add(Boption);

		Coption = new JRadioButton("New radio button");
		Coption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		Coption.setBounds(27, 324, 347, 38);
		multipleDisplay.add(Coption);

		Doption = new JRadioButton("New radio button");
		Doption.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		Doption.setBounds(25, 375, 349, 38);
		multipleDisplay.add(Doption);

		ButtonGroup bG = new ButtonGroup();
		bG.add(Aoption);
		bG.add(Boption);
		bG.add(Coption);
		bG.add(Doption);

		JButton btnNewButton_6 = new JButton("Next");
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				btnNewButton_20.setEnabled(true);
				btnNewButton_21.setEnabled(true);
				if (studentMultiQuestions.size() > 0) {
					studentMultiQuestions.remove(0);
				}
				multiQuestionLabel.setText("");

				if (studentMultiQuestions.size() > 0 && studentMultiQuestions.get(0).getQuestionNumber() == qNo) {
					displayPanel.setVisible(true);
					multipleDisplay.setVisible(true);
					openEndDisplay.setVisible(false);
					multiQuestionLabel.setText(convertToLabel(studentMultiQuestions.get(0).getQuestionText()));
					Aoption.setText(studentMultiQuestions.get(0).getchoiceText(0));
					Boption.setText(studentMultiQuestions.get(0).getchoiceText(1));
					Coption.setText(studentMultiQuestions.get(0).getchoiceText(2));
					Doption.setText(studentMultiQuestions.get(0).getchoiceText(3));
					qNo++;

				} else if (studentFreeQuestions.size() > 0 && studentFreeQuestions.get(0).getQuestionNumber() == qNo) {
					displayPanel.setVisible(true);
					multipleDisplay.setVisible(false);
					openEndDisplay.setVisible(true);
					openQuestionLabel.setText(convertToLabel(studentFreeQuestions.get(0).getQuestionText()));
					qNo++;

				} else {

					multiQuestionLabel.setText("Finish");
					openQuestionLabel.setText("Finish");
					answerText.setText("");
					Aoption.setEnabled(false);
					Boption.setEnabled(false);
					Coption.setEnabled(false);
					Doption.setEnabled(false);

				}

			}
		});
		btnNewButton_6.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		btnNewButton_6.setBounds(637, 213, 104, 54);
		multipleDisplay.add(btnNewButton_6);

		JButton button_13 = new JButton("Back");
		button_13.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				qNo = 0;

				displayPanel.setVisible(false);

				openEndDisplay.setVisible(false);

				multipleDisplay.setVisible(false);

				studentPage.setVisible(true);

			}
		});
		button_13.setBounds(613, 27, 118, 31);
		multipleDisplay.add(button_13);

		btnNewButton_20 = new JButton("Respond");
		btnNewButton_20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnNewButton_20.setEnabled(false);
				if (Aoption.isSelected()) {
					try {
						MySQLConnector.postMultipleChoiceAnswer(studentObject, studentMultiQuestions.get(0), 0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (Boption.isSelected()) {
					try {
						MySQLConnector.postMultipleChoiceAnswer(studentObject, studentMultiQuestions.get(0), 1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (Coption.isSelected()) {
					try {
						MySQLConnector.postMultipleChoiceAnswer(studentObject, studentMultiQuestions.get(0), 2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (Doption.isSelected()) {
					try {
						MySQLConnector.postMultipleChoiceAnswer(studentObject, studentMultiQuestions.get(0), 3);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton_20.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		btnNewButton_20.setBounds(417, 281, 104, 54);
		multipleDisplay.add(btnNewButton_20);

		JLabel trueAnswer = new JLabel();
		trueAnswer.setBounds(417, 359, 196, 54);
		multipleDisplay.add(trueAnswer);

		gradeDisplayStudent = new JPanel();
		gradeDisplayStudent.setVisible(false);
		gradeDisplayStudent.setBackground(Color.CYAN);
		studentGroup.add(gradeDisplayStudent, "name_346230603358826");
		gradeDisplayStudent.setLayout(null);

		gradeTask = new JComboBox();
		gradeTask.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		gradeTask.setModel(new DefaultComboBoxModel(new String[] { "Homework", "Quiz" }));
		gradeTask.setBounds(51, 135, 186, 37);
		gradeDisplayStudent.add(gradeTask);

		gradeCourse = new JComboBox();
		gradeCourse.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		gradeCourse.setBounds(51, 43, 186, 37);
		gradeDisplayStudent.add(gradeCourse);

		gradeNo = new JComboBox();
		gradeNo.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		gradeNo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		gradeNo.setBounds(52, 234, 75, 37);
		gradeDisplayStudent.add(gradeNo);

		studentGradeLabel = new JLabel();
		studentGradeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		studentGradeLabel.setBounds(654, 82, 192, 121);
		gradeDisplayStudent.add(studentGradeLabel);

		JLabel lblGrade = new JLabel("Number of Correct Answers :");
		lblGrade.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblGrade.setBounds(310, 112, 332, 60);
		gradeDisplayStudent.add(lblGrade);

		JButton btnNewButton_15 = new JButton("Back");
		btnNewButton_15.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		btnNewButton_15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					studentCourseList = MySQLConnector.getCourses(studentObject);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 0; i < studentCourseList.size(); i++) {
					gradeCourse.removeItem(studentCourseList.get(i));
				}

				gradeDisplayStudent.setVisible(false);

				studentPage.setVisible(true);

			}
		});
		btnNewButton_15.setBounds(674, 11, 102, 38);
		gradeDisplayStudent.add(btnNewButton_15);

		JButton btnNewButton_22 = new JButton("Display");
		btnNewButton_22.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (MySQLConnector.calculateGrade(String.valueOf(gradeCourse.getSelectedItem()),
						studentObject.getUsername(), String.valueOf(gradeTask.getSelectedItem()),
						Integer.parseInt(String.valueOf(gradeNo.getSelectedItem()))) != -1) {
					studentGradeLabel
							.setText("" + MySQLConnector.calculateGrade(String.valueOf(gradeCourse.getSelectedItem()),
									studentObject.getUsername(), String.valueOf(gradeTask.getSelectedItem()),
									Integer.parseInt(String.valueOf(gradeNo.getSelectedItem()))));
				} else {
					JOptionPane.showMessageDialog(null, " There is no assignment or quiz in this index ", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_22.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		btnNewButton_22.setBounds(258, 286, 102, 29);
		gradeDisplayStudent.add(btnNewButton_22);

		enrollCoursePanel = new JPanel();
		enrollCoursePanel.setVisible(false);
		enrollCoursePanel.setBackground(Color.CYAN);
		studentGroup.add(enrollCoursePanel, "name_348555419587593");
		enrollCoursePanel.setLayout(null);

		enrollBox = new JComboBox();
		enrollBox.setBounds(190, 183, 228, 49);
		enrollCoursePanel.add(enrollBox);

		JLabel lblNewLabel_9 = new JLabel("Courses :");
		lblNewLabel_9.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		lblNewLabel_9.setBounds(85, 180, 105, 49);
		enrollCoursePanel.add(lblNewLabel_9);

		JButton btnNewButton_17 = new JButton("Enroll");
		btnNewButton_17.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnector.enrollCourse(studentObject, String.valueOf(enrollBox.getSelectedItem()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				courseBox.addItem(enrollBox.getSelectedItem());
			}
		});
		btnNewButton_17.setBounds(483, 183, 132, 49);
		enrollCoursePanel.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("Back");
		btnNewButton_18.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ArrayList<String> deleted = MySQLConnector.getAllCourses();
				for (int i = 0; i < deleted.size(); i++) {
					enrollBox.removeItem(deleted.get(i));
				}

				enrollCoursePanel.setVisible(false);

				studentPage.setVisible(true);

			}
		});
		btnNewButton_18.setBounds(20, 23, 97, 34);
		enrollCoursePanel.add(btnNewButton_18);

		studentSignUpPanel = new JPanel();
		studentSignUpPanel.setVisible(false);
		mainPanel.getContentPane().add(studentSignUpPanel, "name_333374826373635");
		studentSignUpPanel.setBackground(Color.YELLOW);
		studentSignUpPanel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("User Name:");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 105, 129, 42);
		studentSignUpPanel.add(lblNewLabel_4);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblPassword.setBounds(10, 175, 129, 42);
		studentSignUpPanel.add(lblPassword);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblName_1.setBounds(10, 249, 129, 42);
		studentSignUpPanel.add(lblName_1);

		JLabel lblSurname_1 = new JLabel("Surname:");
		lblSurname_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblSurname_1.setBounds(10, 316, 129, 42);
		studentSignUpPanel.add(lblSurname_1);

		signUserName = new JTextField();
		signUserName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		signUserName.setBounds(149, 112, 129, 35);
		studentSignUpPanel.add(signUserName);
		signUserName.setColumns(10);

		signPassword = new JTextField();
		signPassword.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		signPassword.setBounds(149, 182, 129, 35);
		studentSignUpPanel.add(signPassword);
		signPassword.setColumns(10);

		signName = new JTextField();
		signName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		signName.setColumns(10);
		signName.setBounds(149, 256, 125, 35);
		studentSignUpPanel.add(signName);

		signSurname = new JTextField();
		signSurname.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		signSurname.setColumns(10);
		signSurname.setBounds(149, 323, 125, 35);
		studentSignUpPanel.add(signSurname);

		JButton btnNewButton_4 = new JButton("Create");
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Student newStudent = new Student(signName.getText(), signSurname.getText(), signDepartment.getText(),
						signUserName.getText(), signPassword.getText());
			}
		});
		btnNewButton_4.setBounds(405, 198, 148, 42);
		studentSignUpPanel.add(btnNewButton_4);

		JLabel lblNewLabel_6 = new JLabel("Student Sign Up ");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(285, 11, 207, 57);
		studentSignUpPanel.add(lblNewLabel_6);

		JButton btnNewButton_19 = new JButton("BACK");
		btnNewButton_19.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				signUserName.setText("");
				signName.setText("");
				signSurname.setText("");
				signPassword.setText("");
				signDepartment.setText("");

				loginPanel.setVisible(true);

				studentSignUpPanel.setVisible(false);

			}
		});
		btnNewButton_19.setBounds(10, 11, 106, 42);
		studentSignUpPanel.add(btnNewButton_19);

		signDepartment = new JTextField();
		signDepartment.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		signDepartment.setColumns(10);
		signDepartment.setBounds(149, 387, 125, 35);
		studentSignUpPanel.add(signDepartment);

		JLabel Department = new JLabel("Department :");
		Department.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		Department.setBounds(10, 380, 129, 42);
		studentSignUpPanel.add(Department);
	}

	public String convertToLabel(String a) {
		String returnText = "<html>";
		for (int i = 0; i < a.length(); i += 45) {
			if ((i + 45) <= a.length()) {
				returnText = returnText + a.substring(i, i + 45) + "<br>";
			} else if ((i + 45) > a.length()) {
				returnText = returnText + a.substring(i, a.length()) + "<br>";
			}
		}
		return returnText;
	}
}
