package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;


public class Board implements ActionListener {

	
	private JFrame frame;
	private JPanel panel;
	private JPanel scorePanel;
	JButton btn00, btn01, btn02,
			btn10, btn11, btn12,
			btn20, btn21, btn22;
	public int playerPoints = 0;
	public int aiPoints = 0;
	public int ties = 0;
	private int roundCount = 0;
	private JLabel scoreJLabel = new JLabel();
	
	int frameWidth = 1200;
	int frameHeight = 800;
	int panelWidth = 600;
	int panelHeight = 400;
	
	int fontSize = 80;
	
	Font font = new Font("Arial", Font.PLAIN, fontSize);
	String currentPlayerMark = "X";
	
	
	
	
	public Board() {
		
		setFrame();
		panel.setVisible(true);
		frame.setVisible(true);
	}
	

	
	private void setFrame() {
		frame = new JFrame("TicTacToe");
		JMenuBar jMenuBar = new JMenuBar();
		populateMenuBar(jMenuBar);
		frame.setJMenuBar(jMenuBar);
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(400, 100, frameWidth, frameHeight);
		
		setPanel();
	}
	
	private void setPanel() {
		
		panel = new JPanel(new GridLayout(3,3));
		panel.setBounds(300, 150, panelWidth, panelHeight);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new CompoundBorder());
		
		scorePanel = new JPanel();
		scorePanel.setBounds(300, 50, 600, 50);
		scorePanel.setBackground(Color.white);
		scorePanel.setBorder(new CompoundBorder());
		
		scorePanel.add(scoreJLabel);
		scoreJLabel.setText("Round: "+ this.roundCount +
							"          Player's points: " + this.playerPoints + 
							"          AI's points: " + this.aiPoints +
							"          Ties: " + this.ties);
		
		initAndAddButtons();
		
		frame.add(panel);
		frame.add(scorePanel);
		
	}
	
	private void populateMenuBar(final JMenuBar jMenuBar) {

		jMenuBar.add(createFileMenu());
		
	}
	
	private JMenu createFileMenu()
	{
		final JMenu fileMenu = new JMenu("File");
		
		
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		
		
		return fileMenu;
	}	
	
	

	
	private void initAndAddButtons() {
		
		btn00 = new JButton();
		btn01 = new JButton();
		btn02 = new JButton();
		
		btn10 = new JButton();
		btn11 = new JButton();
		btn12 = new JButton();
		
		btn20 = new JButton();
		btn21 = new JButton();
		btn22 = new JButton();
		
		btn00.addActionListener(this);
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		
		btn20.addActionListener(this);
		btn21.addActionListener(this);
		btn22.addActionListener(this);
		
		this.panel.add(btn00);
		this.panel.add(btn01);
		this.panel.add(btn02);
		
		this.panel.add(btn10);
		this.panel.add(btn11);
		this.panel.add(btn12);
		
		this.panel.add(btn20);
		this.panel.add(btn21);
		this.panel.add(btn22);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btn00) {
			if(currentPlayerMark == "O") {
				btn00.setForeground(Color.RED);
			}else {btn00.setForeground(Color.BLACK);}
			btn00.setFont(font);
			btn00.setText(currentPlayerMark);
			btn00.setEnabled(false);
			
		}
		if(e.getSource() == btn01) {
			if(currentPlayerMark == "O") {
				btn01.setForeground(Color.RED);
			}else {btn01.setForeground(Color.BLACK);}
			btn01.setFont(font);
			btn01.setText(currentPlayerMark);
			btn01.setEnabled(false);
		}
		if(e.getSource() == btn02) {
			if(currentPlayerMark == "O") {
				btn02.setForeground(Color.RED);
			}else {btn02.setForeground(Color.BLACK);}
			btn02.setFont(font);
			btn02.setText(currentPlayerMark);
			btn02.setEnabled(false);
		}
		
		if(e.getSource() == btn10) {
			if(currentPlayerMark == "O") {
				btn10.setForeground(Color.RED);
			}else {btn10.setForeground(Color.BLACK);}
			btn10.setFont(font);
			btn10.setText(currentPlayerMark);
			btn10.setEnabled(false);
		}
		if(e.getSource() == btn11) {
			if(currentPlayerMark == "O") {
				btn11.setForeground(Color.RED);
			}else {btn11.setForeground(Color.BLACK);}
			btn11.setFont(font);
			btn11.setText(currentPlayerMark);
			btn11.setEnabled(false);
		}
		if(e.getSource() == btn12) {
			if(currentPlayerMark == "O") {
				btn12.setForeground(Color.RED);
			}else {btn12.setForeground(Color.BLACK);}
			btn12.setFont(font);
			btn12.setText(currentPlayerMark);
			btn12.setEnabled(false);
		}
		
		if(e.getSource() == btn20) {
			if(currentPlayerMark == "O") {
				btn20.setForeground(Color.RED);
			}else {btn20.setForeground(Color.BLACK);}
			btn20.setFont(font);
			btn20.setText(currentPlayerMark);
			btn20.setEnabled(false);
		}
		if(e.getSource() == btn21) {
			if(currentPlayerMark == "O") {
				btn21.setForeground(Color.RED);
			}else {btn21.setForeground(Color.BLACK);}
			btn21.setFont(font);
			btn21.setText(currentPlayerMark);
			btn21.setEnabled(false);
		}
		if(e.getSource() == btn22) {
			if(currentPlayerMark == "O") {
				btn22.setForeground(Color.RED);
			}else {btn22.setForeground(Color.BLACK);}
			btn22.setFont(font);
			btn22.setText(currentPlayerMark);
			btn22.setEnabled(false);
			
		}
		if(checkWin(currentPlayerMark) && currentPlayerMark == "X") {this.aiPoints++; setCurrentPlayerMark(); startNewGame();}
		//if(checkWin(currentPlayerMark) && currentPlayerMark == "O") {this.playerPoints++; setCurrentPlayerMark(); startNewGame();}
		/***
		 * 
		 * checkWin method for o was useful for testing so I will keep it here in case something goes wrong. However, we check the gamestate in AI class (but draws and x here to avoid problems with ai's tempboard..)
		 * 
		 * ***/
		
		
		if(checkDraw()) {this.ties++; setCurrentPlayerMark(); startNewGame();}
		setCurrentPlayerMark();
		
	}
	
	public void setCurrentPlayerMark() {
		
		if(currentPlayerMark == "X") {
			currentPlayerMark = "O";
		}else {
			currentPlayerMark = "X";	
		}
	}
	public String getCurrentPlayerMark() {
		return this.currentPlayerMark;
	}
	
	public boolean checkWin(String currentPlayerMark) {
		
		//ROWS
		if(btn00.getText().equalsIgnoreCase(currentPlayerMark) && 
		   btn01.getText().equalsIgnoreCase(currentPlayerMark) &&
		   btn02.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		if(btn10.getText().equalsIgnoreCase(currentPlayerMark) && 
			btn11.getText().equalsIgnoreCase(currentPlayerMark) &&
			btn12.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		if(btn20.getText().equalsIgnoreCase(currentPlayerMark) && 
		   btn21.getText().equalsIgnoreCase(currentPlayerMark) &&
		   btn22.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
			
		//COLUMNS
		if(btn00.getText().equalsIgnoreCase(currentPlayerMark) && 
		   btn10.getText().equalsIgnoreCase(currentPlayerMark) &&
		   btn20.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		if(btn01.getText().equalsIgnoreCase(currentPlayerMark) && 
			btn11.getText().equalsIgnoreCase(currentPlayerMark) &&
			btn21.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		if(btn02.getText().equalsIgnoreCase(currentPlayerMark) && 
		   btn12.getText().equalsIgnoreCase(currentPlayerMark) &&
		   btn22.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		// X
		if(btn00.getText().equalsIgnoreCase(currentPlayerMark) && 
		   btn11.getText().equalsIgnoreCase(currentPlayerMark) &&
		   btn22.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		if(btn02.getText().equalsIgnoreCase(currentPlayerMark) && 
			btn11.getText().equalsIgnoreCase(currentPlayerMark) &&
			btn20.getText().equalsIgnoreCase(currentPlayerMark)) {return true;}
		return false;
	}
	
	public boolean checkDraw() {
		if(!btn00.getText().isEmpty() &&
			!btn01.getText().isEmpty() &&
			!btn02.getText().isEmpty() &&
			
			!btn10.getText().isEmpty() &&
			!btn11.getText().isEmpty() &&
			!btn12.getText().isEmpty() &&
			
			!btn20.getText().isEmpty() &&
			!btn21.getText().isEmpty() &&
			!btn22.getText().isEmpty()  && !checkWin("X") && !checkWin("Y")
				) {return true;}
		return false;
	}
	
	public void startNewGame() {
		this.roundCount++;
		
		scoreJLabel.setText("Round: "+ this.roundCount +
				"          Player's points: " + this.playerPoints + 
				"          AI's points: " + this.aiPoints +
				"          Ties: " + this.ties);
		
		btn00.setText("");
		btn00.setEnabled(true);
		btn01.setText("");
		btn01.setEnabled(true);
		btn02.setText("");
		btn02.setEnabled(true);
		
		btn10.setText("");
		btn10.setEnabled(true);
		btn11.setText("");
		btn11.setEnabled(true);
		btn12.setText("");
		btn12.setEnabled(true);
		
		btn20.setText("");
		btn20.setEnabled(true);
		btn21.setText("");
		btn21.setEnabled(true);
		btn22.setText("");
		btn22.setEnabled(true);
		
		
		
	}
}
