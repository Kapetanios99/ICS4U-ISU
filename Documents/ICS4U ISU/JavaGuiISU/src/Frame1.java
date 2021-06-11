import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.util.ArrayList;
import java.awt.Font;
import java.awt.*;

/*
 * TODO: 
 * - Complete CheckAns Method
 * - Complete Progress Bar functionality
 * - Complete Game functionally
 * - Make game scalable with window size OR make window unscaleable 
 */
public class Frame1 implements ActionListener{
	private ArrayList<String> questions = new ArrayList<String>();
	private static JFrame frmGetQuizzing; 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<String> correctAns = new ArrayList<String>();
	//Wrong answers
	private String[][] wrongAns  = {
			{"Kinematics", "Gravitation", "Waves and Sound"},
			{"Object Oriented", "Database", "Scripting Language"},
			{"Database", "Markup Language", "Scripting Language"},
			{"Gottfried Leibniz", "Elon Musk", "Albert Einstein"},
			{"Uber", "Google", "Amazon"}
	};
	
	private JRadioButton radBtn1 = new JRadioButton("");
	private JRadioButton radBtn2 = new JRadioButton("");
	private JRadioButton radBtn3 = new JRadioButton("");
	private JRadioButton radBtn4 = new JRadioButton("");
	private JLabel lblQuestion = new JLabel("");
	private JProgressBar pgbDone = new JProgressBar();
	private JProgressBar pgbWrong = new JProgressBar();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnRules = new JButton("Rules");
	private JLabel lblProgressBar = new JLabel("Progress");
	private JLabel lblWrong = new JLabel("Wrong");
	
	
	private boolean checkAnsBool = false;
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
		
		//Questions
		questions.add("What branch of physics deals with forces?");
		questions.add("What type of langauge is HTML?");
		questions.add("What type of language is Java?");
		questions.add("Who invented Calculus?");
		questions.add("Which company owns Instagram?");
		
		//Adding answers
		correctAns.add("Dynamics");
		correctAns.add("Markup Language");
		correctAns.add("Object Oriented Programming Language");
		correctAns.add("Isaac Newton");
		correctAns.add("Facebook");
		

		
		
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
		lblQuestion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblQuestion.setBounds(221, 113, 542, 196);
		frmGetQuizzing.getContentPane().add(lblQuestion);
		
		
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
		
		
		
		displayNewQ();
		
		//Rules action listener
		btnRules.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				displayRules();
				
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.getSelection() != null) {
					checkAns( buttonGroup.getSelection());
				}
			}
		});
		
			
		
	}
	
	public boolean checkAns(ButtonModel radBtn) {
		System.out.println("working");
		return true;
	}
	
	public void displayNewQ() {
		int random = (int)(Math.random()*(5-1) +1);
		lblQuestion.setText(questions.get(random-1));
		int ansKey = (int)(Math.random()* (4-1) + 1);
		if (ansKey == 1) {
			radBtn1.setText(correctAns.get(random-1));
			radBtn2.setText(wrongAns[random-1][0]);
			radBtn3.setText(wrongAns[random-1][1]);
			radBtn4.setText(wrongAns[random-1][2]);
		}else if (ansKey == 2) {
			radBtn2.setText(correctAns.get(random-1));
			radBtn1.setText(wrongAns[random-1][0]);
			radBtn3.setText(wrongAns[random-1][1]);
			radBtn4.setText(wrongAns[random-1][2]);
		}else if (ansKey == 3) {
			radBtn3.setText(correctAns.get(random-1));
			radBtn2.setText(wrongAns[random-1][0]);
			radBtn1.setText(wrongAns[random-1][1]);
			radBtn4.setText(wrongAns[random-1][2]);
		}if (ansKey == 4) {
			radBtn4.setText(correctAns.get(random-1));
			radBtn2.setText(wrongAns[random-1][0]);
			radBtn1.setText(wrongAns[random-1][1]);
			radBtn4.setText(wrongAns[random-1][2]);
		}
	
		
		
	}
	
	public void displayRules() {
		JDialog rulesPop = new JDialog();
		rulesPop.setTitle("Rules");
		rulesPop.setLocationRelativeTo(frmGetQuizzing);
		JLabel helpLabel = new JLabel("<html>\tSelect an answer to the question, then click submit. <br>\tThe top bar is your quiz progress, and the bottom-left bar is your wrong answer progress. <br>\tIf you get 3 answers wrong, the quiz is over and you can restart</html>");
		rulesPop.add(helpLabel);
		rulesPop.setSize(500, 500);
		rulesPop.setVisible(true);
		
		
	}
	
	public static void playAgain() {
		run();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

