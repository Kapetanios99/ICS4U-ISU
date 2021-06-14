
import javax.swing.JFrame;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.util.ArrayList;
import java.awt.Font;
import java.awt.*;

public class Frame1 implements ActionListener {
	private ArrayList<String> questions = new ArrayList<String>();
	private static JFrame frmGetQuizzing;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<String> correctAns = new ArrayList<String>();

	private ArrayList<String> wrongAns = new ArrayList<String>();

	private String correctAnswerString = "";

	private JRadioButton radBtn1 = new JRadioButton("");
	private JRadioButton radBtn2 = new JRadioButton("");
	private JRadioButton radBtn3 = new JRadioButton("");
	private JRadioButton radBtn4 = new JRadioButton("");
	private JLabel lblQuestion = new JLabel("");
	private JProgressBar pgbDone = new JProgressBar(0, 5);
	private JProgressBar pgbWrong = new JProgressBar(0, 3);
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnRules = new JButton("Rules");
	private JLabel lblProgressBar = new JLabel("Progress");
	private JLabel lblWrong = new JLabel("Wrong");
	boolean checkAnsBool = false;
	private int pgbDoneValue = 0;
	private int pgbWrongValue = 0;
	private int userScore = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		run();

	}

	public static void run() {

		Frame1 window = new Frame1();
		window.frmGetQuizzing.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmGetQuizzing = new JFrame();
		frmGetQuizzing.setTitle("Get Quizzing");
		frmGetQuizzing.setBounds(100, 100, 1000, 600);
		frmGetQuizzing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGetQuizzing.getContentPane().setLayout(null);
		frmGetQuizzing.setLocationRelativeTo(null);
		frmGetQuizzing.setResizable(false);
		lblQuestion.setFont(new Font("Roboto", Font.BOLD, 20));
		// Questions
		questions.add("What branch of physics deals with forces?");
		questions.add("What type of langauge is HTML?");
		questions.add("What type of language is Java?");
		questions.add("Who invented Calculus?");
		questions.add("Which company owns Instagram?");

		// Adding answers
		correctAns.add("Dynamics");
		correctAns.add("Markup Language");
		correctAns.add("Object Oriented");
		correctAns.add("Isaac Newton");
		correctAns.add("Facebook");

		// Adding wrong answers
		wrongAns.add("Kinematics");
		wrongAns.add("Gravitation");
		wrongAns.add("Waves and Sounds");

		wrongAns.add("Object Oriented");
		wrongAns.add("Database");
		wrongAns.add("Scripting Langauge");

		wrongAns.add("Database");
		wrongAns.add("Markup Language");
		wrongAns.add("Scripting Language");

		wrongAns.add("Gottfried Leibniz");
		wrongAns.add("Elon Musk");
		wrongAns.add("Albert Einstein");

		wrongAns.add("Uber");
		wrongAns.add("Google");
		wrongAns.add("Amazon");
		// Creating buttons and labels: adding
		buttonGroup.add(radBtn1);
		radBtn1.setBounds(252, 350, 182, 23);
		frmGetQuizzing.getContentPane().add(radBtn1);

		buttonGroup.add(radBtn2);
		radBtn2.setBounds(665, 350, 205, 23);
		frmGetQuizzing.getContentPane().add(radBtn2);

		buttonGroup.add(radBtn3);
		radBtn3.setBounds(252, 438, 218, 23);
		frmGetQuizzing.getContentPane().add(radBtn3);

		buttonGroup.add(radBtn4);
		radBtn4.setBounds(665, 438, 205, 23);
		frmGetQuizzing.getContentPane().add(radBtn4);

		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);

		lblQuestion.setBounds(221, 113, 542, 196);
		frmGetQuizzing.getContentPane().add(lblQuestion);
		lblQuestion.setFont(new Font("Roboto", Font.BOLD, 20));
		pgbDone.setBounds(92, 24, 800, 23);
		frmGetQuizzing.getContentPane().add(pgbDone);

		pgbWrong.setBounds(48, 520, 197, 14);
		frmGetQuizzing.getContentPane().add(pgbWrong);

		btnSubmit.setBounds(447, 511, 89, 23);
		frmGetQuizzing.getContentPane().add(btnSubmit);

		btnRules.setBounds(868, 511, 89, 23);
		frmGetQuizzing.getContentPane().add(btnRules);

		lblProgressBar.setBounds(26, 27, 55, 16);
		frmGetQuizzing.getContentPane().add(lblProgressBar);

		lblWrong.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrong.setBounds(112, 532, 55, 16);
		frmGetQuizzing.getContentPane().add(lblWrong);

		// Displays a new question
		displayNewQ();

		// Rules action listener
		btnRules.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Displays rules
				displayRules();

			}
		});

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If a radio button is selected, checks if its right and responds accordingly
				if (buttonGroup.getSelection() != null) {
					pgbDoneValue++;
					pgbDone.setValue(pgbDoneValue);
					checkAnsBool = checkAns(buttonGroup.getSelection());

					if (checkAnsBool == true) {

						userScore++;

						lblQuestion.setText("Correct!");
						btnSubmit.disable(); // Disabling and enabling button so that it cannot be clicked when unwanted
						Timer timer = new Timer(1000, new ActionListener() { // A timer so the frame displays Correct
																				// for some time

							@Override
							public void actionPerformed(ActionEvent arg0) {
								reset();
								btnSubmit.enable();
							}
						});
						timer.setRepeats(false);
						timer.start();

					} else {
						pgbWrongValue++;
						pgbWrong.setValue(pgbWrongValue);
						lblQuestion.setText("Incorrect!");
						btnSubmit.disable();
						Timer timer = new Timer(1000, new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								reset();
								btnSubmit.enable();
							}
						});
						timer.setRepeats(false);
						timer.start();
					}
				}

			}

		});

	}

	/*
	 * returns true if the selected buttons action command corresponds with the
	 * correct answer
	 */
	public boolean checkAns(ButtonModel radBtn) {
		if (radBtn.getActionCommand().equals(correctAnswerString)) {
			return true;
		}
		return false;

	}

	/*
	 * returns an int to escape method when necessary Displays a new question with
	 * multiple choice answers
	 */
	public int displayNewQ() {
		// Checks if the game is done and removes components
		// displays the end of the game with the option to play again
		if (pgbWrong.getPercentComplete() == 1) {
			radBtn1.setVisible(false);
			radBtn2.setVisible(false);
			radBtn3.setVisible(false);
			radBtn4.setVisible(false);
			btnRules.setVisible(false);
			lblProgressBar.setVisible(false);
			lblWrong.setVisible(false);
			pgbDone.setVisible(false);
			pgbWrong.setVisible(false);
			btnSubmit.setSize(150, 20);
			btnSubmit.setText("Play Again?");
			lblQuestion.setFont(new Font("Roboto", Font.BOLD, 20));
			lblQuestion.setText("<html>Game Over! You got 3 questions wrong so you lost.<br>Your score was " + userScore
					+ "/5<br>Would you like to play again?</html>");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playAgain();
				}
			});
			return 0;
			// Checks if user got 3 or more wrong and ends game with option to play again
		} else if (pgbDone.getPercentComplete() == 1) {

			radBtn1.setVisible(false);
			radBtn2.setVisible(false);
			radBtn3.setVisible(false);
			radBtn4.setVisible(false);
			btnRules.setVisible(false);
			lblProgressBar.setVisible(false);
			lblWrong.setVisible(false);
			pgbDone.setVisible(false);
			pgbWrong.setVisible(false);
			btnSubmit.setSize(150, 20);
			btnSubmit.setText("Play Again?");
			lblQuestion.setFont(new Font("Roboto", Font.BOLD, 20));
			lblQuestion.setText("<html>Congratulations!<br>Your score was " + userScore
					+ "/5<br>Would you like to play again?</html>");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playAgain();
				}
			});
			return 0;
		}

		int random = (int) (Math.random() * (correctAns.size() - 1 + 1)) + 1; // to select question
		lblQuestion.setText(questions.get(random - 1)); // sets question to label
		int ansKey = (int) (Math.random() * (4 - 1 + 1) + 1); // to randomly dictate where correct answer should go on
																// multiple choice

		/*
		 * The series of if-statements are to determine which question is being asked to
		 * display the correct answers As well, if-statements are used to determine
		 * which radio button to put correct answer
		 */
		if (lblQuestion.getText().equals("What branch of physics deals with forces?")) {
			if (ansKey == 1) {
				correctAnswerString = correctAns.get(random - 1);
				radBtn1.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Kinematics")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Waves and Sounds")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Gravitation")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 2) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn2.setText(correctAns.get(random - 1));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Kinematics")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Waves and Sounds")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Gravitation")));

				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 3) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn3.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Kinematics")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Waves and Sounds")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Gravitation")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 4) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn4.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Kinematics")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Waves and Sounds")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Gravitation")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			}

		} else if (lblQuestion.getText().equals("What type of langauge is HTML?")) {
			if (ansKey == 1) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn1.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Object Oriented")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 2) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn2.setText(correctAns.get(random - 1));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Object Oriented")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 3) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn3.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Object Oriented")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));

				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 4) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn4.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Object Oriented")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));

				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			}
		} else if (lblQuestion.getText().equals("What type of language is Java?")) {
			if (ansKey == 1) {

				// correctAnswerString = correctAns.get(correctAns.indexOf("Object Oriented"));
				// radBtn1.setText(correctAns.get(correctAns.indexOf("Object Oriented")));
				correctAnswerString = correctAns.get(random - 1);
				radBtn1.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Markup Language")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));

				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 2) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn2.setText(correctAns.get(random - 1));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Markup Language")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 3) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn3.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Markup Language")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 4) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn4.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Database")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Markup Language")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Scripting Language")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			}
		} else if (lblQuestion.getText().equals("Who invented Calculus?")) {
			if (ansKey == 1) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn1.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Gottfried Leibniz")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Elon Musk")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Albert Einstein")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 2) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn2.setText(correctAns.get(random - 1));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Gottfried Leibniz")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Elon Musk")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Albert Einstein")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 3) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn3.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Gottfried Leibniz")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Elon Musk")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Albert Einstein")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 4) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn4.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Gottfried Leibniz")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Elon Musk")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Albert Einstein")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			}
		} else if (lblQuestion.getText().equals("Which company owns Instagram?")) {
			if (ansKey == 1) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn1.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Uber")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Google")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Amazon")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 2) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn2.setText(correctAns.get(random - 1));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Uber")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Google")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Amazon")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 3) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn3.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Uber")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Google")));
				radBtn4.setText(wrongAns.get(wrongAns.indexOf("Amazon")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			} else if (ansKey == 4) {

				correctAnswerString = correctAns.get(random - 1);
				radBtn4.setText(correctAns.get(random - 1));
				radBtn2.setText(wrongAns.get(wrongAns.indexOf("Uber")));
				radBtn3.setText(wrongAns.get(wrongAns.indexOf("Google")));
				radBtn1.setText(wrongAns.get(wrongAns.indexOf("Amazon")));
				radBtn1.setActionCommand(radBtn1.getText());
				radBtn2.setActionCommand(radBtn2.getText());
				radBtn3.setActionCommand(radBtn3.getText());
				radBtn4.setActionCommand(radBtn4.getText());

			}
		}
		// removes the answer and questions so that they aren't asked again
		correctAns.remove(random - 1);
		questions.remove(random - 1);
		return 0;
	}

	/*
	 * displays a dialog window with the rules of the game works when btnRules is
	 * clicked
	 */
	public void displayRules() {
		JDialog rulesPop = new JDialog();
		rulesPop.setTitle("Rules");
		rulesPop.setLocationRelativeTo(frmGetQuizzing);
		JLabel helpLabel = new JLabel(
				"<html>\tSelect an answer to the question, then click submit. <br>\tThe top bar is your quiz progress, and the bottom-left bar is your wrong answer progress. <br>\tIf you get 3 answers wrong, the quiz is over and you can restart</html>");
		rulesPop.add(helpLabel);
		rulesPop.setSize(500, 500);
		rulesPop.setVisible(true);

	}

	/*
	 * Used to instantiate a new instance of the game when the user wants to play
	 * again Works when btnSubmit is clicked after the game ends
	 */
	public static void playAgain() {
		frmGetQuizzing.dispose();
		run();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * Used to reset certain variables and display a new question after the user
	 * answers
	 */
	public void reset() {
		correctAnswerString = "";
		buttonGroup.clearSelection();
		displayNewQ();

	}
}